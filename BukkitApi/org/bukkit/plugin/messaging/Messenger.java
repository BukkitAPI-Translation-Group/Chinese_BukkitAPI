package org.bukkit.plugin.messaging;

import java.util.Set;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * 负责管理插件通道和它们注册的监听器的类.
 */
public interface Messenger {

    /**
     * 代表单个插件消息的最大大小.
     */
    public static final int MAX_MESSAGE_SIZE = 32766;

    /**
     * 代表单个插件通道的最大大小.
     */
    public static final int MAX_CHANNEL_SIZE = 20;

    /**
     * 检测指定的通道名称是否为保留名称.
     * <p>
     * 原文：Checks if the specified channel is a reserved name.
     *
     * @param channel 要检测的通道名称
     * @return 如果这个通道是保留的则为true，false反之
     * @throws IllegalArgumentException 如果参数channel为null
     */
    public boolean isReservedChannel(String channel);

    /**
     * 注册特定插件所请求的传出插件通道，允许它通过这个通道向任何通道发送消息.
     * <p>
     * 原文：Registers the specific plugin to the requested outgoing plugin channel,
     * allowing it to send messages through that channel to any clients.
     *
     * @param plugin 希望通过该通过发送消息的插件
     * @param channel 要注册的通道
     * @throws IllegalArgumentException 如果参数plugin或channel为null
     */
    public void registerOutgoingPluginChannel(Plugin plugin, String channel);

    /**
     * 原文：Unregisters the specific plugin from the requested outgoing plugin
     * channel, no longer allowing it to send messages through that channel to
     * any clients.
     *
     * @param plugin Plugin that no longer wishes to send messages through the
     *     channel.
     * @param channel 要注销的通道
     * @throws IllegalArgumentException 如果参数plugin或channel为null
     */
    public void unregisterOutgoingPluginChannel(Plugin plugin, String channel);

    /**
     * 原文：Unregisters the specific plugin from all outgoing plugin channels, no
     * longer allowing it to send any plugin messages.
     *
     * @param plugin Plugin that no longer wishes to send plugin messages.
     * @throws IllegalArgumentException 如果参数plugin为null
     */
    public void unregisterOutgoingPluginChannel(Plugin plugin);

    /**
     * 原文：Registers the specific plugin for listening on the requested incoming
     * plugin channel, allowing it to act upon any plugin messages.
     *
     * @param plugin 希望注册这个通道的插件
     * @param channel 要注册的通道
     * @param listener Listener to receive messages on.
     * @return The resulting registration that was made as a result of this
     *     method.
     * @throws IllegalArgumentException 如果参数plugin,channel或listener为null或这个监听器已注册这个通道
     */
    public PluginMessageListenerRegistration registerIncomingPluginChannel(Plugin plugin, String channel, PluginMessageListener listener);

    /**
     * 原文：Unregisters the specific plugin's listener from listening on the
     * requested incoming plugin channel, no longer allowing it to act upon
     * any plugin messages.
     *
     * @param plugin 希望注销这个通道的插件
     * @param channel 要注销的通道
     * @param listener Listener to stop receiving messages on.
     * @throws IllegalArgumentException 如果参数plugin,channel或listener为null
     */
    public void unregisterIncomingPluginChannel(Plugin plugin, String channel, PluginMessageListener listener);

    /**
     * 原文：Unregisters the specific plugin from listening on the requested
     * incoming plugin channel, no longer allowing it to act upon any plugin
     * messages.
     *
     * @param plugin 希望注销这个通道的插件
     * @param channel 要注销的通道
     * @throws IllegalArgumentException 如果参数plugin或channel为null
     */
    public void unregisterIncomingPluginChannel(Plugin plugin, String channel);

    /**
     * 原文：Unregisters the specific plugin from listening on all plugin channels
     * through all listeners.
     *
     * @param plugin 希望注销这个通道的插件
     * @throws IllegalArgumentException 如果参数plugin为null
     */
    public void unregisterIncomingPluginChannel(Plugin plugin);

    /**
     * 原文：Gets a set containing all the outgoing plugin channels.
     *
     * @return List of all registered outgoing plugin channels.
     */
    public Set<String> getOutgoingChannels();

    /**
     * 原文：Gets a set containing all the outgoing plugin channels that the
     * specified plugin is registered to.
     *
     * @param plugin Plugin to retrieve channels for.
     * @return List of all registered outgoing plugin channels that a plugin
     *     is registered to.
     * @throws IllegalArgumentException Thrown if plugin is null.
     */
    public Set<String> getOutgoingChannels(Plugin plugin);

    /**
     * 原文：Gets a set containing all the incoming plugin channels.
     *
     * @return List of all registered incoming plugin channels.
     */
    public Set<String> getIncomingChannels();

    /**
     * 原文：Gets a set containing all the incoming plugin channels that the
     * specified plugin is registered for.
     *
     * @param plugin Plugin to retrieve channels for.
     * @return List of all registered incoming plugin channels that the plugin
     *     is registered for.
     * @throws IllegalArgumentException 如果参数plugin为null
     */
    public Set<String> getIncomingChannels(Plugin plugin);

    /**
     * 原文：Gets a set containing all the incoming plugin channel registrations
     * that the specified plugin has.
     *
     * @param plugin Plugin to retrieve registrations for.
     * @return List of all registrations that the plugin has.
     * @throws IllegalArgumentException 如果参数plugin为null
     */
    public Set<PluginMessageListenerRegistration> getIncomingChannelRegistrations(Plugin plugin);

    /**
     * 原文：Gets a set containing all the incoming plugin channel registrations
     * that are on the requested channel.
     *
     * @param channel Channel to retrieve registrations for.
     * @return List of all registrations that are on the channel.
     * @throws IllegalArgumentException 如果参数channel为null
     */
    public Set<PluginMessageListenerRegistration> getIncomingChannelRegistrations(String channel);

    /**
     * 原文：Gets a set containing all the incoming plugin channel registrations
     * that the specified plugin has on the requested channel.
     *
     * @param plugin Plugin to retrieve registrations for.
     * @param channel Channel to filter registrations by.
     * @return List of all registrations that the plugin has.
     * @throws IllegalArgumentException 如果参数plugin或channel为null
     */
    public Set<PluginMessageListenerRegistration> getIncomingChannelRegistrations(Plugin plugin, String channel);

    /**
     * 原文：Checks if the specified plugin message listener registration is valid.
     * <p>
     * A registration is considered valid if it has not be unregistered and
     * that the plugin is still enabled.
     *
     * @param registration Registration to check.
     * @return True if the registration is valid, otherwise false.
     */
    public boolean isRegistrationValid(PluginMessageListenerRegistration registration);

    /**
     * 原文：Checks if the specified plugin has registered to receive incoming
     * messages through the requested channel.
     *
     * @param plugin Plugin to check registration for.
     * @param channel 要检测的通道
     * @return 如果通道已注册则为true，false反之
     */
    public boolean isIncomingChannelRegistered(Plugin plugin, String channel);

    /**
     * 原文：Checks if the specified plugin has registered to send outgoing messages
     * through the requested channel.
     *
     * @param plugin Plugin to check registration for.
     * @param channel 要检测的通道
     * @return 如果通道已注册则为true，false反之
     */
    public boolean isOutgoingChannelRegistered(Plugin plugin, String channel);

    /**
     * 原文：Dispatches the specified incoming message to any registered listeners.
     *
     * @param source 消息源
     * @param channel 通过什么通道发送的消息
     * @param message 消息的原始有效载荷
     */
    public void dispatchIncomingMessage(Player source, String channel, byte[] message);
}