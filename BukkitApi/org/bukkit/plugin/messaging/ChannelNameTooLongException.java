package org.bukkit.plugin.messaging;

/**
 * 如果插件通道(Plugin Channel)过长则抛出此异常。
 */
@SuppressWarnings("serial")
public class ChannelNameTooLongException extends RuntimeException {
    public ChannelNameTooLongException() {
        super("Attempted to send a Plugin Message to a channel that was too large. The maximum length a channel may be is " + Messenger.MAX_CHANNEL_SIZE + " chars.");
    }

    public ChannelNameTooLongException(String channel) {
        super("Attempted to send a Plugin Message to a channel that was too large. The maximum length a channel may be is " + Messenger.MAX_CHANNEL_SIZE + " chars (attempted " + channel.length() + " - '" + channel + ".");
    }
}