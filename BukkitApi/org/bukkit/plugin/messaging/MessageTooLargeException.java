package org.bukkit.plugin.messaging;

/**
 * 如果要发送的插件信息(Plugin Message)过大则抛出此异常。
 */
@SuppressWarnings("serial")
public class MessageTooLargeException extends RuntimeException {
    public MessageTooLargeException() {
        this("Attempted to send a plugin message that was too large. The maximum length a plugin message may be is " + Messenger.MAX_MESSAGE_SIZE + " bytes.");
    }

    public MessageTooLargeException(byte[] message) {
        this(message.length);
    }

    public MessageTooLargeException(int length) {
        this("Attempted to send a plugin message that was too large. The maximum length a plugin message may be is " + Messenger.MAX_MESSAGE_SIZE + " bytes (tried to send one that is " + length + " bytes long).");
    }

    public MessageTooLargeException(String msg) {
        super(msg);
    }
}