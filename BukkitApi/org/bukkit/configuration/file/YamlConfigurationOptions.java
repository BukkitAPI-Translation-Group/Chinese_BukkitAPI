package org.bukkit.configuration.file;

import com.google.common.base.Preconditions;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 用于控制 {@link YamlConfiguration} 输入和输出的各种设置.
 */
public class YamlConfigurationOptions extends FileConfigurationOptions {
    private int indent = 2;
    private int width = 80;

    protected YamlConfigurationOptions(@NotNull YamlConfiguration configuration) {
        super(configuration);
    }

    @NotNull
    @Override
    public YamlConfiguration configuration() {
        return (YamlConfiguration) super.configuration();
    }

    @NotNull
    @Override
    public YamlConfigurationOptions copyDefaults(boolean value) {
        super.copyDefaults(value);
        return this;
    }

    @NotNull
    @Override
    public YamlConfigurationOptions pathSeparator(char value) {
        super.pathSeparator(value);
        return this;
    }

    @NotNull
    @Override
    public YamlConfigurationOptions setHeader(@Nullable List<String> value) {
        super.setHeader(value);
        return this;
    }

    @NotNull
    @Override
    @Deprecated(since = "1.18.1")
    public YamlConfigurationOptions header(@Nullable String value) {
        super.header(value);
        return this;
    }

    @NotNull
    @Override
    public YamlConfigurationOptions setFooter(@Nullable List<String> value) {
        super.setFooter(value);
        return this;
    }

    @NotNull
    @Override
    public YamlConfigurationOptions parseComments(boolean value) {
        super.parseComments(value);
        return this;
    }

    @NotNull
    @Override
    @Deprecated(since = "1.18.1")
    public YamlConfigurationOptions copyHeader(boolean value) {
        super.copyHeader(value);
        return this;
    }

    /**
     * 获取每行缩进使用的空格数.
     * <p>
     * 最小值为 2, 最大值为 9.
     * <p>
     * 原文：
     * Gets how much spaces should be used to indent each line.
     * <p>
     * The minimum value this may be is 2, and the maximum is 9.
     *
     * @return 缩进量.
     */
    public int indent() {
        return indent;
    }

    /**
     * 设置每行缩进使用的空格数.
     * <p>
     * 最小值为 2, 最大值为 9.
     * <p>
     * 原文：
     * Sets how much spaces should be used to indent each line.
     * <p>
     * The minimum value this may be is 2, and the maximum is 9.
     *
     * @param value 新的缩进值.
     * @return 此对象, 用于链式调用.
     */
    @NotNull
    public YamlConfigurationOptions indent(int value) {
        Preconditions.checkArgument(value >= 2, "Indent must be at least 2 characters");
        Preconditions.checkArgument(value <= 9, "Indent cannot be greater than 9 characters");

        this.indent = value;
        return this;
    }

    /**
     * 获取行在被拆分之前的最大长度.
     * <p>
     * 原文：
     * Gets how long a line can be, before it gets split.
     *
     * @return 最大行宽.
     */
    public int width() {
        return width;
    }

    /**
     * 设置行在被拆分之前的最大长度.
     * <p>
     * 原文：
     * Sets how long a line can be, before it gets split.
     *
     * @param value 新的宽度.
     * @return 此对象, 用于链式调用.
     */
    @NotNull
    public YamlConfigurationOptions width(int value) {
        this.width = value;
        return this;
    }
}
