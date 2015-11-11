package org.bukkit.configuration;
//汉化进度; 99% 魔法值@11110153
//格式校对完毕.
/**
 * {@link Configuration} 的配置类.
 * <p>原文:
 * Various settings for controlling the input and output of a {@link Configuration}
 */
public class ConfigurationOptions {
    private char pathSeparator = '.';
    private boolean copyDefaults = false;
    private final Configuration configuration;

    protected ConfigurationOptions(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 返回关联这个配置的 {@link Configuration}.
     * <p>原文:
     * Returns the {@link Configuration} that this object is responsible for.
     *
     * @return Parent configuration
     */ 
    public Configuration configuration() {
        return configuration;
    }

    /**
     * 获取用于分离 {@link ConfigurationSection} 中路径的 char.
     * <P>
     * 这个char并不会影响数据的储存, 它只是路径的分隔符. 
     * 只会影响你在程序中怎样读取数据.默认为 '.'.
     * <p>原文:
     * Gets the char that will be used to separate {@link ConfigurationSection}s
     * <p>
     * This value does not affect how the {@link Configuration} is stored, only in how you access the data.
     * The default value is '.'.
     *
     * @return Path 路径分割符.
     */
    public char pathSeparator() {
        return pathSeparator;
    }

    /**
     * 设置用于分离 {@link ConfigurationSection} 中路径的 char.
     * <P>
     * 这个 char 并不会影响数据的储存, 它只是路径的分隔符.
     * 只会影响你在程序中怎样读取数据.默认为 '.'.
     * <p>原文:
     * Sets the char that will be used to separate {@link ConfigurationSection}s.
     * <p>
     * This value does not affect how the {@link Configuration} is stored, only in how you access the data. 
     * The default value is '.'.
     *
     * @param value Path 路径分割符.
     * @return 返回 this .
     */
    public ConfigurationOptions pathSeparator(char value) {
        this.pathSeparator = value;
        return this;
    }

    /**
     * 检查这个{@link Configuration} 是不是直接从缺省值 {@link Configuration} 那里复制过来的.
     * <p>
     * 如果为真, 表明这个列表中的值都是从缺省值 {@link Configuration} 中复制过来的. 
     * <p>
     * 这个列表将被锁定. 并始终返回缺省值列表中的值. 可以看作是只读的缺省值列表. 
     * <p>
     * 默认值是false.
     * <p>原文: 
     * Checks if the {@link Configuration} should copy values from its default {@link Configuration} directly.
     * <p>
     * If this is true, all values in the default Configuration will be directly copied, making it impossible to distinguish between values that were set and values that are provided by default. 
     * As a result, {@link ConfigurationSection#contains(java.lang.String)} will always return the same value as {@link ConfigurationSection#isSet(java.lang.String)}. 
     * The default value is false.
     *
     * @return Whether or not defaults are directly copied
     */ 
    public boolean copyDefaults() {
        return copyDefaults;
    }

    /**
     * 如果这个{@link Configuration}从 它的默认{@link Configuration}那里直接 复制值, 就设为true.
     * <p>
     * 如果值为 true, 将直接从默认源中复制所有的值.
     * <p>
     * 机器翻译(使得不可能分别设置，默认情况下所提供的值的值和区分。?).
     * 其结果{@link ConfigurationSection#contains(java.lang.String)}, 将始终返回相同的值{@link ConfigurationSection#isSet(java.lang.String)}.
     * <p>
     * 默认值是false.
     * <p>原文:
     * Sets if the {@link Configuration} should copy values from its default {@link Configuration} directly.
     * <p>
     * If this is true, all values in the default Configuration will be directly copied, making it impossible to distinguish between values that were set and values that are provided by default.
     * As a result, {@link ConfigurationSection#contains(java.lang.String)} will always return the same value as {@link ConfigurationSection#isSet(java.lang.String)}.
     * The default value is false.
     *
     * @param value Whether or not defaults are directly copied
     * @return 返回 this
     *///魔法值@11110153
    public ConfigurationOptions copyDefaults(boolean value) {
        this.copyDefaults = value;
        return this;
    }
}
