package org.bukkit.plugin;

import org.jetbrains.annotations.NotNull;

/**
 * 表示一个基础的 {@link Plugin}.
 * <p>
 * 如果你的插件不是 {@link org.bukkit.plugin.java.JavaPlugin}，请扩展此类。
 */
public abstract class PluginBase implements Plugin {
    @Override
    public final int hashCode() {
        return getName().hashCode();
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Plugin)) {
            return false;
        }
        return getName().equals(((Plugin) obj).getName());
    }

    @Override
    @NotNull
    public final String getName() {
        return getDescription().getName();
    }
}
