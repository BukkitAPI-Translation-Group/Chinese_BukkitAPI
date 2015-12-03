package org.bukkit.plugin.messaging;

/**
 * 代表插件通道的不同方向.
 */
public enum PluginChannelDirection {

    /**
     * 插件通道正在从客户端发往服务器(正在传入).
     */
    INCOMING,

    /**
     * 插件通道正在从服务器发往客户端(正在传出).
     */
    OUTGOING
}