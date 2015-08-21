package org.bukkit.configuration;

import java.util.Map;

/**
 * 配置文件的基类.
 * <p>
 * 原文:Represents a source of configurable options and settings
 */
public interface Configuration extends ConfigurationSection {
    /**
     * 设置给定路径({@link path})的默认值. 
     * <p>
     * 如果没有默认的{@link Configuration}. 
     * 那么将会建立一个新的{@link MemoryConfiguration}用于保存
     * <p>
     * 如果值为null，该值将被从默认的配置源中删除。
     * <p>
     * 原文: Sets the default value of the given path as provided.
     * <p>
     * If no source {@link Configuration} was provided as a default
     * collection, then a new {@link MemoryConfiguration} will be created to
     * hold the new default value.
     * <p>
     * If value is null, the value will be removed from the default
     * Configuration source.
     * 
     *
     * @param path 路径.
     * @param value 默认值.
     * @throws IllegalArgumentException 如果路径为null.
     */
    public void addDefault(String path, Object value);

    /**
     * 把map里面的键值都加入到默认值列表. 
     * <p>
     * 如果没有默认的{@link Configuration},
     * 那么将会建立一个新的{@link MemoryConfiguration}用于保存.
     * <p>
     * 如果值为null，该值将被从默认的配置源中删除。
     * <p>
     * 原文: Sets the default values of the given paths as provided.
     * <p>
     * If no source {@link Configuration} was provided as a default
     * collection, then a new {@link MemoryConfiguration} will be created to
     * hold the new default values.
     *
     * @param defaults map的键是路径,值是对应路径的值.
     * @throws IllegalArgumentException 如果defaults为null.
     */
    public void addDefaults(Map<String, Object> defaults);

    /**
     * 把{@link Configuration}全部加入到默认值列表. 
     * <p>
     * 如果没有默认的{@link Configuration},
     * 那么将会建立一个新的{@link MemoryConfiguration}用于保存.
     * <p>
     * <p>
     * 原文:Sets the default values of the given paths as provided.
     * <p>
     * If no source {@link Configuration} was provided as a default
     * collection, then a new {@link MemoryConfiguration} will be created to
     * hold the new default value.
     * <p>
     * This method will not hold a reference to the specified Configuration,
     * nor will it automatically update if that Configuration ever changes. If
     * you require this, you should set the default source with {@link
     * #setDefaults(org.bukkit.configuration.Configuration)}.
     *
     * @param defaults A configuration holding a list of defaults to copy.
     * @throws IllegalArgumentException Thrown if defaults is null or this.
     */
    public void addDefaults(Configuration defaults);

    /**
     * 设置新的默认值的来源.
     * <p>
     * 如果原来有默认值列表,将不会保留,直接被替换.
     * <p>
     * 原文:Sets the source of all default values for this {@link Configuration}.
     * <p>
     * If a previous source was set, or previous default values were defined,
     * then they will not be copied to the new source.
     *
     * @param defaults 新的{@link Configuration}
     * @throws IllegalArgumentException 如果参数为null,或者就是原来的列表.
     */
    public void setDefaults(Configuration defaults);

    /**
     * 获取这个configuration的默认值列表{@link Configuration}.
     * <p>
     * 如果设置默认值列表来源,但设置过默认值,则返回{@link Configuration}.
     * 如果都没有,则返回null
     * <p>
     * Gets the source {@link Configuration} for this configuration.
     * <p>
     * If no configuration source was set, but default values were added, then
     * a {@link MemoryConfiguration} will be returned. If no source was set
     * and no defaults were set, then this method will return null.
     *
     * @return 返回默认值列表,如果没有则返回null.
     */
    public Configuration getDefaults();

    /**
     * 获取这个{@link Configuration}的{@link ConfigurationOptions}.
     * <p>
     * 通过这种方法，所有的配置都是直接修改。
     * <p>
     * Gets the {@link ConfigurationOptions} for this {@link Configuration}.
     * <p>
     * All setters through this method are chainable.
     *
     * @return 所有的配置.原文:Options for this configuration
     */
    public ConfigurationOptions options();
}
