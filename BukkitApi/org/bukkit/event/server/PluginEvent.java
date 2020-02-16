package org.bukkit.event.server;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * 用于插件的启用和禁用事件.
 */
public abstract class PluginEvent extends ServerEvent {
    private final Plugin plugin;

    public PluginEvent(@NotNull final Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * 得到启用/禁用的插件.
     * <p>
     * 原文： Gets the plugin involved in this event
     *
     * @return 激活这个事件的插件
     */
    @NotNull
    public Plugin getPlugin() {
        return plugin;
    }
}