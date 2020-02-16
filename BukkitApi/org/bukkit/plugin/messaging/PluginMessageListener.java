package org.bukkit.plugin.messaging;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

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
     * @param channel 发送消息通过的通道
     * @param player 消息来源
     * @param message 发送的原始消息
     */
    public void onPluginMessageReceived(@NotNull String channel, @NotNull Player player, @NotNull byte[] message);
}