package org.bukkit.configuration.file;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import org.apache.commons.lang.Validate;
import org.bukkit.configuration.InvalidConfigurationException;

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
import org.bukkit.configuration.MemoryConfiguration;

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
    public FileConfiguration(Configuration defaults) {
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
     * @throws IllegalArgumentException 如果文件为空，泡出该异常
     */
    public void save(File file) throws IOException {
        Validate.notNull(file, "File cannot be null");

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
    public void save(String file) throws IOException {
        Validate.notNull(file, "File cannot be null");

        save(new File(file));
    }

    /**
     * 将这个 {@link FileConfiguration} 转化为String对象并且返回
     *
     * @return 这个FileConfiguration包含的所有String
     */
    public abstract String saveToString();

    /**
     * 从指定位置加载 {@link FileConfiguration} 
     * <p>
     * All the values contained within this configuration will be removed,
     * leaving only settings and defaults, and the new values will be loaded
     * from the given file.
     * <p>
     * If the file cannot be loaded for any reason, an exception will be
     * thrown.
     *
     * @param file File to load from.
     * @throws FileNotFoundException Thrown when the given file cannot be
     *     opened.
     * @throws IOException Thrown when the given file cannot be read.
     * @throws InvalidConfigurationException Thrown when the given file is not
     *     a valid Configuration.
     * @throws IllegalArgumentException Thrown when file is null.
     */
    public void load(File file) throws FileNotFoundException, IOException, InvalidConfigurationException {
        Validate.notNull(file, "File cannot be null");

        final FileInputStream stream = new FileInputStream(file);

        load(new InputStreamReader(stream, Charsets.UTF_8));
    }

    /**
     * Loads this {@link FileConfiguration} from the specified reader.
     * <p>
     * All the values contained within this configuration will be removed,
     * leaving only settings and defaults, and the new values will be loaded
     * from the given stream.
     *
     * @param reader the reader to load from
     * @throws IOException thrown when underlying reader throws an IOException
     * @throws InvalidConfigurationException thrown when the reader does not
     *      represent a valid Configuration
     * @throws IllegalArgumentException thrown when reader is null
     */
    public void load(Reader reader) throws IOException, InvalidConfigurationException {
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
     * Loads this {@link FileConfiguration} from the specified location.
     * <p>
     * All the values contained within this configuration will be removed,
     * leaving only settings and defaults, and the new values will be loaded
     * from the given file.
     * <p>
     * If the file cannot be loaded for any reason, an exception will be
     * thrown.
     *
     * @param file File to load from.
     * @throws FileNotFoundException Thrown when the given file cannot be
     *     opened.
     * @throws IOException Thrown when the given file cannot be read.
     * @throws InvalidConfigurationException Thrown when the given file is not
     *     a valid Configuration.
     * @throws IllegalArgumentException Thrown when file is null.
     */
    public void load(String file) throws FileNotFoundException, IOException, InvalidConfigurationException {
        Validate.notNull(file, "File cannot be null");

        load(new File(file));
    }

    /**
     * Loads this {@link FileConfiguration} from the specified string, as
     * opposed to from file.
     * <p>
     * All the values contained within this configuration will be removed,
     * leaving only settings and defaults, and the new values will be loaded
     * from the given string.
     * <p>
     * If the string is invalid in any way, an exception will be thrown.
     *
     * @param contents Contents of a Configuration to load.
     * @throws InvalidConfigurationException Thrown if the specified string is
     *     invalid.
     * @throws IllegalArgumentException Thrown if contents is null.
     */
    public abstract void loadFromString(String contents) throws InvalidConfigurationException;

    /**
     * Compiles the header for this {@link FileConfiguration} and returns the
     * result.
     * <p>
     * This will use the header from {@link #options()} -&gt; {@link
     * FileConfigurationOptions#header()}, respecting the rules of {@link
     * FileConfigurationOptions#copyHeader()} if set.
     *
     * @return Compiled header
     */
    protected abstract String buildHeader();

    @Override
    public FileConfigurationOptions options() {
        if (options == null) {
            options = new FileConfigurationOptions(this);
        }

        return (FileConfigurationOptions) options;
    }
}
