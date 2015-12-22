package org.bukkit.plugin.messaging;

import java.util.Set;
import org.bukkit.plugin.Plugin;

/**
 * 代表插件消息(Plugin Message)可能的接收者.
 */
public interface PluginMessageRecipient {
    /**
     * 在指定的通道向接收者发送插件消息(Plugin Message).
     * <p>
     * 这个消息可能不大于{@link Messenger#MAX_MESSAGE_SIZE}字节，还有插件必须注册到指定的通道上发消息.
     * <p>
     * 原文：Sends this recipient a Plugin Message on the specified outgoing
     * channel.
     * <p>
     * The message may not be larger than {@link Messenger#MAX_MESSAGE_SIZE}
     * bytes, and the plugin must be registered to send messages on the
     * specified channel.
     *
     * @param source 要让插件发送的消息
     * @param channel The channel to send this message on.在某通道上发送这个消息
     * @param message 要发送的原始消息The raw message to send.
     * @throws IllegalArgumentException 如果插件被禁用则抛出
     * @throws IllegalArgumentException 如果参数source,channel或message为null则抛出
     * @throws MessageTooLargeException 如果消息过大则抛出
     * @throws ChannelNotRegisteredException 如果这个通道不是为这个插件注册的则抛出
     */
    public void sendPluginMessage(Plugin source, String channel, byte[] message);

    /**
     * 获取包含了客户端正在监听的插件通道(Plugin Channel)的set集合.
     * <p>
     * 原文：Gets a set containing all the Plugin Channels that this client is
     * listening on.
     *
     * @return 包含了客户端可以接受的通道的set集合
     */
    public Set<String> getListeningPluginChannels();
}