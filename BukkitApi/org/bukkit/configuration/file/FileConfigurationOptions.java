package org.bukkit.configuration.file;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.bukkit.configuration.MemoryConfiguration;
import org.bukkit.configuration.MemoryConfigurationOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 用于控制 {@link FileConfiguration} 输入和输出的各种设置.
 */
public class FileConfigurationOptions extends MemoryConfigurationOptions {
    private List<String> header = Collections.emptyList();
    private List<String> footer = Collections.emptyList();
    private boolean parseComments = true;

    protected FileConfigurationOptions(@NotNull MemoryConfiguration configuration) {
        super(configuration);
    }

    @NotNull
    @Override
    public FileConfiguration configuration() {
        return (FileConfiguration) super.configuration();
    }

    @NotNull
    @Override
    public FileConfigurationOptions copyDefaults(boolean value) {
        super.copyDefaults(value);
        return this;
    }

    @NotNull
    @Override
    public FileConfigurationOptions pathSeparator(char value) {
        super.pathSeparator(value);
        return this;
    }

    /**
     * 获取将应用于保存输出顶部的头部注释.
     * <p>
     * 此头部注释将以注释形式直接应用在 {@link FileConfiguration} 生成的输出的顶部. 无需在头部末尾包含换行符, 因为它会自动添加, 但如果需要额外的间距可以包含一个.
     * <p>
     * 如果不存在注释, 将返回一个空列表. null 条目代表一个空行, 空字符串代表一个空的注释行.
     * <p>
     * 原文：
     * Gets the header that will be applied to the top of the saved output.
     * <p>
     * This header will be commented out and applied directly at the top of
     * the generated output of the {@link FileConfiguration}. It is not
     * required to include a newline at the end of the header as it will
     * automatically be applied, but you may include one if you wish for extra
     * spacing.
     * <p>
     * If no comments exist, an empty list will be returned. A null entry
     * represents an empty line and an empty String represents an empty comment
     * line.
     *
     * @return 不可修改的头部注释, 每个条目代表一行.
     */
    @NotNull
    public List<String> getHeader() {
        return header;
    }

    /**
     * @return 字符串形式的头部注释.
     *
     * @deprecated 请改用getHeader().
     */
    @NotNull
    @Deprecated(since = "1.18.1")
    public String header() {
        StringBuilder stringHeader = new StringBuilder();
        for (String line : header) {
            stringHeader.append(line == null ? "\n" : line + "\n");
        }
        return stringHeader.toString();
    }

    /**
     * 设置将应用于保存输出顶部的头部注释.
     * <p>
     * 此头部注释将以注释形式直接应用在 {@link FileConfiguration} 生成的输出的顶部. 无需在头部末尾包含换行符, 因为它会自动添加, 但如果需要额外的间距可以包含一个.
     * <p>
     * 如果不存在注释, 将返回一个空列表. null 条目代表一个空行, 空字符串代表一个空的注释行.
     * <p>
     * 原文：
     * Sets the header that will be applied to the top of the saved output.
     * <p>
     * This header will be commented out and applied directly at the top of
     * the generated output of the {@link FileConfiguration}. It is not
     * required to include a newline at the end of the header as it will
     * automatically be applied, but you may include one if you wish for extra
     * spacing.
     * <p>
     * If no comments exist, an empty list will be returned. A null entry
     * represents an empty line and an empty String represents an empty comment
     * line.
     *
     * @param value 新的头部注释, 每个条目代表一行.
     * @return 此对象, 用于链式调用.
     */
    @NotNull
    public FileConfigurationOptions setHeader(@Nullable List<String> value) {
        this.header = (value == null) ? Collections.emptyList() : Collections.unmodifiableList(value);
        return this;
    }

    /**
     * @param value 字符串形式的头部注释.
     * @return 此对象, 用于链式调用.
     *
     * @deprecated 请改用setHeader()
     */
    @NotNull
    @Deprecated(since = "1.18.1")
    public FileConfigurationOptions header(@Nullable String value) {
        this.header = (value == null) ? Collections.emptyList() : Collections.unmodifiableList(Arrays.asList(value.split("\\n")));
        return this;
    }

    /**
     * 获取将应用于保存输出底部的尾部注释.
     * <p>
     * 此尾部注释将以注释形式直接应用在 {@link FileConfiguration} 生成的输出的底部. 无需在尾部开头包含换行符, 因为它会自动添加, 但如果需要额外的间距可以包含一个.
     * <p>
     * 如果不存在注释, 将返回一个空列表. null 条目代表一个空行, 空字符串代表一个空的注释行.
     * <p>
     * 原文：
     * Gets the footer that will be applied to the bottom of the saved output.
     * <p>
     * This footer will be commented out and applied directly at the bottom of
     * the generated output of the {@link FileConfiguration}. It is not required
     * to include a newline at the beginning of the footer as it will
     * automatically be applied, but you may include one if you wish for extra
     * spacing.
     * <p>
     * If no comments exist, an empty list will be returned. A null entry
     * represents an empty line and an empty String represents an empty comment
     * line.
     *
     * @return 不可修改的尾部注释, 每个条目代表一行.
     */
    @NotNull
    public List<String> getFooter() {
        return footer;
    }

    /**
     * 设置将应用于保存输出底部的尾部注释.
     * <p>
     * 此尾部注释将以注释形式直接应用在 {@link FileConfiguration} 生成的输出的底部. 无需在尾部开头包含换行符, 因为它会自动添加, 但如果需要额外的间距可以包含一个.
     * <p>
     * 如果不存在注释, 将返回一个空列表. null 条目代表一个空行, 空字符串代表一个空的注释行.
     * <p>
     * 原文：
     * Sets the footer that will be applied to the bottom of the saved output.
     * <p>
     * This footer will be commented out and applied directly at the bottom of
     * the generated output of the {@link FileConfiguration}. It is not required
     * to include a newline at the beginning of the footer as it will
     * automatically be applied, but you may include one if you wish for extra
     * spacing.
     * <p>
     * If no comments exist, an empty list will be returned. A null entry
     * represents an empty line and an empty String represents an empty comment
     * line.
     *
     * @param value 新的尾部注释, 每个条目代表一行.
     * @return 此对象, 用于链式调用.
     */
    @NotNull
    public FileConfigurationOptions setFooter(@Nullable List<String> value) {
        this.footer = (value == null) ? Collections.emptyList() : Collections.unmodifiableList(value);
        return this;
    }

    /**
     * 获取是否应该加载和保存注释.
     * <p>
     * 默认为 true.
     * <p>
     * 原文：
     * Gets whether or not comments should be loaded and saved.
     * <p>
     * Defaults to true.
     *
     * @return 是否解析注释.
     */
    public boolean parseComments() {
        return parseComments;
    }

    /**
     * 设置是否应该加载和保存注释.
     * <p>
     * 默认为 true.
     * <p>
     * 原文：
     * Sets whether or not comments should be loaded and saved.
     * <p>
     * Defaults to true.
     *
     * @param value 是否解析注释.
     * @return 此对象, 用于链式调用.
     */
    @NotNull
    public MemoryConfigurationOptions parseComments(boolean value) {
        parseComments = value;
        return this;
    }

    /**
     * @return 是否解析注释.
     *
     * @deprecated 请改用{@link #parseComments()}.
     */
    @Deprecated(since = "1.18.1")
    public boolean copyHeader() {
        return parseComments;
    }

    /**
     * @param value Should comments be parsed.
     * @return This object, for chaining
     *
     * @deprecated Call {@link #parseComments(boolean)} instead.
     */
    @NotNull
    @Deprecated(since = "1.18.1")
    public FileConfigurationOptions copyHeader(boolean value) {
        parseComments = value;
        return this;
    }
}
