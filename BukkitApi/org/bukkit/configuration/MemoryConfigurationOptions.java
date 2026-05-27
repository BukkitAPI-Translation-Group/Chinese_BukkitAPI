package org.bukkit.configuration;

import org.jetbrains.annotations.NotNull;

/**
 * 用于控制 {@link MemoryConfiguration} 输入输出的各种设置。
 */
public class MemoryConfigurationOptions extends ConfigurationOptions {
    protected MemoryConfigurationOptions(@NotNull MemoryConfiguration configuration) {
        super(configuration);
    }

    @NotNull
    @Override
    public MemoryConfiguration configuration() {
        return (MemoryConfiguration) super.configuration();
    }

    @NotNull
    @Override
    public MemoryConfigurationOptions copyDefaults(boolean value) {
        super.copyDefaults(value);
        return this;
    }

    @NotNull
    @Override
    public MemoryConfigurationOptions pathSeparator(char value) {
        super.pathSeparator(value);
        return this;
    }
}
