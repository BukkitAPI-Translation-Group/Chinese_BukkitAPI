package org.bukkit.plugin.messaging;

/**
 * 如果插件尝试向未注册的通道发消息则抛出此异常。
 */
@SuppressWarnings("serial")
public class ChannelNotRegisteredException extends RuntimeException {
    public ChannelNotRegisteredException() {
        this("Attempted to send a plugin message through an unregistered channel.");
    }

    public ChannelNotRegisteredException(String channel) {
        super("Attempted to send a plugin message through the unregistered channel `" + channel + "'.");
    }
}