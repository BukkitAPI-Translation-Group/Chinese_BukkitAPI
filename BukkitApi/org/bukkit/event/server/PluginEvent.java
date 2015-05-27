package org.bukkit.event.server;

import org.bukkit.plugin.Plugin;

/**
 * 用于插件的启用和禁用事件.
 * <p>
 * 原文:Used for plugin enable and disable events
 */
public abstract class PluginEvent extends ServerEvent {
    private final Plugin plugin;

    public PluginEvent(final Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Gets the plugin involved in this event
     *
     * @return Plugin for this event
     */
    public Plugin getPlugin() {
        return plugin;
    }
}
