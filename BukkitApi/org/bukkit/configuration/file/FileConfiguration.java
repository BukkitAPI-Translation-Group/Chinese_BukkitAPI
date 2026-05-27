package org.bukkit.configuration.file;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.Files;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.MemoryConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 这是一个实现了 {@link Configuration} 的配置文件的基类
 */
public abstract class FileConfiguration extends MemoryConfiguration {

    /**
     * 创建一个空的，没有值默认值的 {@link FileConfiguration}.
     */
    public FileConfiguration() {
        super();
    }

    /**
     * 创建一个空的 {@link FileConfiguration} 并且使用 {@link
     * Configuration} 内的所有默认值创建它.
     *
     * @param defaults 为其创建提供缺省值的Configuration.
     */
    public FileConfiguration(@Nullable Configuration defaults) {
        super(defaults);
    }

    /**
     * 以一个 {@link FileConfiguration} 调用该方法，将文件储存到指定位置.
     * <p>
     * 如果你指定储存的这个文件不存在,这个方法会帮你自动创建一个. 如果这个文件存在,那么该方法会把所有未保存的更改直接写入文件
     * 并且直接覆盖原文件. 如果储存或者创建失败,将会抛出一个异常
     * <p>
     * 本方法会用系统默认的编码储存,不过也有可能用UTF-8出储存
     *
     * @param file 要储存的文件
     * @throws IOException 然后会给出无法创建或者保存的原因.
     * @throws IllegalArgumentException 如果文件为空，抛出该异常
     */
    public void save(@NotNull File file) throws IOException {
        Preconditions.checkArgument(file != null, "File cannot be null");

        Files.createParentDirs(file);

        String data = saveToString();

        Writer writer = new OutputStreamWriter(new FileOutputStream(file), Charsets.UTF_8);

        try {
            writer.write(data);
        } finally {
            writer.close();
        }
    }

	/**
     * 以一个 {@link FileConfiguration} 调用该方法，将文件储存到指定位置.
     * <p>
     * 如果你指定储存的这个文件不存在,这个方法会帮你自动创建一个. 如果这个文件存在,那么该方法会把所有未保存的更改直接写入文件
	 * 并且直接覆盖原文件. 如果储存或者创建失败,将会抛出一个异常
     * <p>
     * 本方法会用系统默认的编码储存,不过也有可能用UTF-8出储存
     *
     * @param file 要储存的文件
     * @throws IOException 然后会给出无法创建或者保存的原因.
     * @throws IllegalArgumentException 如果文件为空，泡出该异常
     */
    public void save(@NotNull String file) throws IOException {
        Preconditions.checkArgument(file != null, "File cannot be null");

        save(new File(file));
    }

    /**
     * 将这个 {@link FileConfiguration} 转化为String对象并且返回
     *
     * @return 这个FileConfiguration包含的所有String
     */
    @NotNull
    public abstract String saveToString();

    /**
     * 从指定位置加载 {@link FileConfiguration}.
     * <p>
     * 此配置中包含的所有值都将被移除,只保留设置和默认值,新的值将从给定的文件中加载.
     * <p>
     * 如果文件因任何原因无法加载,将会抛出异常.
     * <p>
     * 原文：Load from the specified file. All the values contained within this
     * configuration will be removed, leaving only settings and defaults, and the
     * new values will be loaded from the given file. If the file cannot be loaded
     * for any reason, an exception will be thrown.
     *
     * @param file 要加载的文件
     * @throws FileNotFoundException 当给定的文件无法被打开时抛出
     * @throws IOException 当给定的文件无法被读取时抛出
     * @throws InvalidConfigurationException 当给定的文件不是有效的配置时抛出
     * @throws IllegalArgumentException 当文件为null时抛出
     */
    public void load(@NotNull File file) throws FileNotFoundException, IOException, InvalidConfigurationException {
        Preconditions.checkArgument(file != null, "File cannot be null");

        final FileInputStream stream = new FileInputStream(file);

        load(new InputStreamReader(stream, Charsets.UTF_8));
    }

    /**
     * 从指定的读取器加载此 {@link FileConfiguration}.
     * <p>
     * 此配置中包含的所有值都将被移除,只保留设置和默认值,新的值将从给定的流中加载.
     * <p>
     * 原文：Loads this FileConfiguration from the specified reader. All the values
     * contained within this configuration will be removed, leaving only settings
     * and defaults, and the new values will be loaded from the given stream.
     *
     * @param reader 要从中加载的读取器
     * @throws IOException 当底层读取器抛出IOException时抛出
     * @throws InvalidConfigurationException 当读取器不表示有效的配置时抛出
     * @throws IllegalArgumentException 当reader为null时抛出
     */
    public void load(@NotNull Reader reader) throws IOException, InvalidConfigurationException {
        BufferedReader input = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);

        StringBuilder builder = new StringBuilder();

        try {
            String line;

            while ((line = input.readLine()) != null) {
                builder.append(line);
                builder.append('\n');
            }
        } finally {
            input.close();
        }

        loadFromString(builder.toString());
    }

    /**
     * 从指定位置加载 {@link FileConfiguration}.
     * <p>
     * 此配置中包含的所有值都将被移除,只保留设置和默认值,新的值将从给定的文件中加载.
     * <p>
     * 如果文件因任何原因无法加载,将会抛出异常.
     * <p>
     * 原文：Loads this FileConfiguration from the specified location. All the values
     * contained within this configuration will be removed, leaving only settings
     * and defaults, and the new values will be loaded from the given file. If the
     * file cannot be loaded for any reason, an exception will be thrown.
     *
     * @param file 要加载的文件
     * @throws FileNotFoundException 当给定的文件无法被打开时抛出
     * @throws IOException 当给定的文件无法被读取时抛出
     * @throws InvalidConfigurationException 当给定的文件不是有效的配置时抛出
     * @throws IllegalArgumentException 当文件为null时抛出
     */
    public void load(@NotNull String file) throws FileNotFoundException, IOException, InvalidConfigurationException {
        Preconditions.checkArgument(file != null, "File cannot be null");

        load(new File(file));
    }

    /**
     * 从指定的字符串加载此 {@link FileConfiguration},而不是从文件加载.
     * <p>
     * 此配置中包含的所有值都将被移除,只保留设置和默认值,新的值将从给定的字符串中加载.
     * <p>
     * 如果字符串在任何方面无效,将会抛出异常.
     * <p>
     * 原文：Loads this FileConfiguration from the specified string, as opposed to
     * from file. All the values contained within this configuration will be
     * removed, leaving only settings and defaults, and the new values will be
     * loaded from the given string. If the string is invalid in any way, an
     * exception will be thrown.
     *
     * @param contents 要加载的配置内容
     * @throws InvalidConfigurationException 如果指定的字符串无效则抛出
     * @throws IllegalArgumentException 如果contents为null则抛出
     */
    public abstract void loadFromString(@NotNull String contents) throws InvalidConfigurationException;

    /**
     * @return 空白字符串
     *
     * @deprecated 此方法仅为向后兼容而存在.它不会执行任何操作,请勿使用!请使用
     * {@link FileConfigurationOptions#getHeader()} 代替.
     */
    @NotNull
    @Deprecated(since = "1.18.1")
    protected String buildHeader() {
        return "";
    }

    @NotNull
    @Override
    public FileConfigurationOptions options() {
        if (options == null) {
            options = new FileConfigurationOptions(this);
        }

        return (FileConfigurationOptions) options;
    }
}
