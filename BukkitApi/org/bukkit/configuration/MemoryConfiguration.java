package org.bukkit.configuration;

import com.google.common.base.Preconditions;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * {@link Configuration} 的一种实现, 不会从任何数据源进行保存或加载, 所有值仅存储在内存中.
 * 这对于临时的配置对象或提供默认值非常有用.
 */
public class MemoryConfiguration extends MemorySection implements Configuration {
    protected Configuration defaults;
    protected MemoryConfigurationOptions options;

    /**
     * 创建一个没有默认值的空 {@link MemoryConfiguration}.
     * <p>
     * 原文：
     * Creates an empty {@link MemoryConfiguration} with no default values.
     */
    public MemoryConfiguration() {}

    /**
     * 创建一个空的 {@link MemoryConfiguration}, 并使用指定的 {@link Configuration} 作为所有默认值的来源.
     *
     * @param defaults 默认值提供者
     * @throws IllegalArgumentException 如果 defaults 为 null 则抛出此异常
     */
    public MemoryConfiguration(@Nullable Configuration defaults) {
        this.defaults = defaults;
    }

    @Override
    public void addDefault(@NotNull String path, @Nullable Object value) {
        Preconditions.checkArgument(path != null, "Path may not be null");

        if (defaults == null) {
            defaults = new MemoryConfiguration();
        }

        defaults.set(path, value);
    }

    @Override
    public void addDefaults(@NotNull Map<String, Object> defaults) {
        Preconditions.checkArgument(defaults != null, "Defaults may not be null");

        for (Map.Entry<String, Object> entry : defaults.entrySet()) {
            addDefault(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void addDefaults(@NotNull Configuration defaults) {
        Preconditions.checkArgument(defaults != null, "Defaults may not be null");

        for (String key : defaults.getKeys(true)) {
            if (!defaults.isConfigurationSection(key)) {
                addDefault(key, defaults.get(key));
            }
        }
    }

    @Override
    public void setDefaults(@NotNull Configuration defaults) {
        Preconditions.checkArgument(defaults != null, "Defaults may not be null");

        this.defaults = defaults;
    }

    @Override
    @Nullable
    public Configuration getDefaults() {
        return defaults;
    }

    @Nullable
    @Override
    public ConfigurationSection getParent() {
        return null;
    }

    @Override
    @NotNull
    public MemoryConfigurationOptions options() {
        if (options == null) {
            options = new MemoryConfigurationOptions(this);
        }

        return options;
    }
}
