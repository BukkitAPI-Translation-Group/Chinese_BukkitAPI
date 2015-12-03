package org.bukkit.plugin.messaging;

import org.bukkit.entity.Player;

/**
 * 一个指定通道的一个监听器，将接收从客户端发送的消息的通知.
 */
public interface PluginMessageListener {

    /**
     * 当PluginMessageSource(插件消息源)在已注册的通道上发送了插件消息调用此方法.
     * <p>
     * 原文：A method that will be thrown when a PluginMessageSource sends a plugin
     * message on a registered channel.
     *
     * @param channel 通过某通道发送的消息
     * @param player 消息来源
     * @param message 已发送的消息
     */
    public void onPluginMessageReceived(String channel, Player player, byte[] message);
}