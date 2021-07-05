package org.bukkit.configuration;

import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 配置文件的基类.
 * <p>原文: 
 * Represents a source of configurable options and settings
 */
public interface Configuration extends ConfigurationSection {
    /**
     * 设置指定路径的缺省值. 
     * <p>
     * 如果没有默认的 {@link Configuration}. 
     * 那么将会建立一个新的 {@link MemoryConfiguration} 用于保存.
     * <p>
     * 如果值为 null ，该值将被从默认的配置源中删除.
     * <p>原文: 
     * Sets the default value of the given path as provided.
     * <p>
     * If no source {@link Configuration} was provided as a default collection, then a new {@link MemoryConfiguration} will be created to hold the new default value.
     * <p>
     * If value is null, the value will be removed from the default Configuration source.
     * 
     * @param path 路径.
     * @param value 缺省值.
     * @throws IllegalArgumentException 如果路径为 null .
     */
    @Override
    public void addDefault(@NotNull String path, @Nullable Object value);

    /**
     * 把指定map里面的键值都加入到缺省值列表.
     * <p>
     * 如果没有缺省值 {@link Configuration}, 那么将会建立一个新的缺省值 {@link MemoryConfiguration} 用于保存.
     * <p>
     * 如果值为 null , 将会删除该路径上的缺省值.
     * <p>原文: 
     * Sets the default values of the given paths as provided.
     * <p>
     * If no source {@link Configuration} was provided as a default collection, then a new {@link MemoryConfiguration} will be created to hold the new default values.
     *
     * @param defaults Map 的键是路径, 值是对应路径的值.
     * @throws IllegalArgumentException 如果defaults为null.
     */
    public void addDefaults(@NotNull Map<String, Object> defaults);

    /**
     * 把指定 {@link Configuration} 全部加入到缺省值列表.
     * <p>
     * 如果没有缺省值 {@link Configuration}, 那么将会建立一个新的 {@link MemoryConfiguration} 用于保存.
     * <p>
     * 你可以使用{@link #setDefaults(org.bukkit.configuration.Configuration)}来设置缺省值列表来源. 
     * <p>原文: 
     * Sets the default values of the given paths as provided.
     * <p>
     * If no source {@link Configuration} was provided as a default collection, then a new {@link MemoryConfiguration} will be created to hold the new default value.
     * <p>
     * If you require this, you should set the default source with {@link #setDefaults(org.bukkit.configuration.Configuration)}.
     *
     * @param defaults A configuration holding a list of defaults to copy.
     * @throws IllegalArgumentException Thrown if defaults is null or this.
     */
    public void addDefaults(@NotNull Configuration defaults);

    /**
     * 设置新的缺省值列表.
     * <p>
     * 将直接替换原有的缺省值列表(如果有).
     * <p>原文: 
     * Sets the source of all default values for this {@link Configuration}.
     * <p>
     * If a previous source was set, or previous default values were defined, then they will not be copied to the new source.
     *
     * @param defaults 新的 {@link Configuration} .
     * @throws IllegalArgumentException 当参数为 null 或 defaults == getDefaults() 时, 抛出此异常.
     */
    public void setDefaults(@NotNull Configuration defaults);

    /**
     * 获取这个 {@link Configuration} 的缺省值 {@link Configuration}.
     * <p>
     * 如果设置过缺省值, 即使没有设置缺省值列表, 也会返回 {@link Configuration}.
     * <p>
     * 如果都没有, 则返回 null.
     * <p>原文: 
     * Gets the source {@link Configuration} for this configuration.
     * <p>
     * If no configuration source was set, but default values were added, then a {@link MemoryConfiguration} will be returned. 
     * If no source was set and no defaults were set, then this method will return null.
     *
     * @return 返回缺省值列表, 如果没有则返回 null.
     */
    @Nullable
    public Configuration getDefaults();

    /**
     * 获取这个 {@link Configuration} 的 {@link ConfigurationOptions}.
     * <p>
     * 如需修改配置,直接修改返回值即可.
     * <p>原文: 
     * Gets the {@link ConfigurationOptions} for this {@link Configuration}.
     * <p>
     * All setters through this method are chainable.
     *
     * @return 这个配置文件的一些配置(格式之类的).
     */
    @NotNull
    public ConfigurationOptions options();
}
