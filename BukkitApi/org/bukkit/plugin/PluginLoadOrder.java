package org.bukkit.plugin;

/**
 * 代表插件应被初始化并启用的时机.
 */
public enum PluginLoadOrder {

    /**
     * 表示插件会在服务器启动时加载
     */
    STARTUP,
    /**
     * 表示插件会在第一个/默认世界被创建/加载后加载
     */
    POSTWORLD
}
