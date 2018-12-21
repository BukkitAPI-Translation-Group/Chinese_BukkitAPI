package org.bukkit.plugin.messaging;

import java.util.Set;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * 负责管理注册插件通道和监听器的类.
 *
 * Channel names must contain a colon separator and consist of only [a-z0-9/._-]
 * - i.e. they MUST be valid {@link NamespacedKey}. The "BungeeCord" channel is
 * an exception and may only take this form.
 */
public interface Messenger {

    /**
     * 代表单个插件消息的最大大小.
     */
    public static final int MAX_MESSAGE_SIZE = 32766;

    /**
     * 代表单个插件通道的最大大小.
     */
    public static final int MAX_CHANNEL_SIZE = 32;

    /**
     * 检测指定的通道名称是否为保留名称.
     * <br>
     * 所有处于"minecraft"命名空间的通道都是被保留的, 除了"minecraft:brand".
     * <p>
     * 原文：Checks if the specified channel is a reserved name.
     * <br>
     * All channels within the "minecraft" namespace except for
     * "minecraft:brand" are reserved.
     *
     * @param channel 要检测的通道名称
     * @return 如果这个通道是保留的则为true，反之为false
     * @throws IllegalArgumentException 如果参数channel为null
     */
    public boolean isReservedChannel(String channel);

    /**
     * 注册指定插件所请求的发送插件通道，允许它通过这个通道向任何客户端发送消息.
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
     * 注销指定插件请求的插件发送通道，不再允许它通过这个通道发送消息到任何客户端.
     * <p>
     * 原文：Unregisters the specific plugin from the requested outgoing plugin
     * channel, no longer allowing it to send messages through that channel to
     * any clients.
     *
     * @param plugin 不再希望通过此通道发送消息的插件
     * @param channel 要注销的通道
     * @throws IllegalArgumentException 如果参数plugin或channel为null
     */
    public void unregisterOutgoingPluginChannel(Plugin plugin, String channel);

    /**
     * 注销指定插件的所有向外发送插件通道，不再允许它发送任何插件消息.
     * <p>
     * 原文：Unregisters the specific plugin from all outgoing plugin channels, no
     * longer allowing it to send any plugin messages.
     *
     * @param plugin 不再希望发送插件消息的插件
     * @throws IllegalArgumentException 如果参数plugin为null
     */
    public void unregisterOutgoingPluginChannel(Plugin plugin);

    /**
     * 注册指定的监听指定的接收的插件通道的插件，允许它在任何插件消息上做动作.
     * <p>
     * 原文：Registers the specific plugin for listening on the requested incoming
     * plugin channel, allowing it to act upon any plugin messages.
     *
     * @param plugin 希望注册这个通道的插件
     * @param channel 要注册的通道
     * @param listener 要接收消息的监听器
     * @return 注册后的结果(一个对象)
     * @throws IllegalArgumentException 如果参数plugin,channel或listener为null或这个监听器已注册这个通道
     */
    public PluginMessageListenerRegistration registerIncomingPluginChannel(Plugin plugin, String channel, PluginMessageListener listener);

    /**
     * 注销指定插件请求的监听接收的插件通道的监听器，不再允许它在任何插件消息上做任何动作.
     * <p>
     * 原文：Unregisters the specific plugin's listener from listening on the
     * requested incoming plugin channel, no longer allowing it to act upon
     * any plugin messages.
     *
     * @param plugin 希望注销这个通道的插件
     * @param channel 要注销的通道
     * @param listener 要停止接收消息的监听器
     * @throws IllegalArgumentException 如果参数plugin,channel或listener为null
     */
    public void unregisterIncomingPluginChannel(Plugin plugin, String channel, PluginMessageListener listener);

    /**
     * 注销指定插件请求的监听的接收的插件通道，不再允许它在任何插件消息上做动作.
     * <p>
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
     * 注销指定插件在所有监听器上监听的插件通道.
     * <p>
     * 原文：Unregisters the specific plugin from listening on all plugin channels
     * through all listeners.
     *
     * @param plugin 希望注销这些通道的插件
     * @throws IllegalArgumentException 如果参数plugin为null
     */
    public void unregisterIncomingPluginChannel(Plugin plugin);

    /**
     * 获取包含了所有向外发送的插件通道的set集合.
     * <p>
     * 原文：Gets a set containing all the outgoing plugin channels.
     *
     * @return 已注册的所有发送插件通道的列表
     */
    public Set<String> getOutgoingChannels();

    /**
     * 获取一个包含了指定插件注册的全部向外发送的插件通道的set集合.
     * <p>
     * 原文：Gets a set containing all the outgoing plugin channels that the
     * specified plugin is registered to.
     *
     * @param plugin 要检索通道的插件
     * @return 所有这个插件注册的正在发送的插件通道的列表
     * @throws IllegalArgumentException 如果参数plugin为null
     */
    public Set<String> getOutgoingChannels(Plugin plugin);

    /**
     * 获取包含了所有接收的插件通道的set集合.
     * <p>
     * 原文：Gets a set containing all the incoming plugin channels.
     *
     * @return 已注册的所有正在接收的插件通道的列表
     */
    public Set<String> getIncomingChannels();

    /**
     * 获取一个包含了指定插件注册的所有接收的插件通道的set集合.
     * <p>
     * 原文：Gets a set containing all the incoming plugin channels that the
     * specified plugin is registered for.
     *
     * @param plugin 要检索通道的插件
     * @return 所有这个插件注册的正在接收的插件通道的列表
     * @throws IllegalArgumentException 如果参数plugin为null
     */
    public Set<String> getIncomingChannels(Plugin plugin);

    /**
     * 获取一个包含了指定插件拥有的所有接收的插件通道的注册的set集合.
     * <p>
     * 原文：Gets a set containing all the incoming plugin channel registrations
     * that the specified plugin has.
     *
     * @param plugin 要检索注册的插件
     * @return 这个插件注册的所有注册的列表
     * @throws IllegalArgumentException 如果参数plugin为null
     */
    public Set<PluginMessageListenerRegistration> getIncomingChannelRegistrations(Plugin plugin);

    /**
     * 获取一个包含了所有在请求通道上的接收的插件通道的注册的set集合.
     * <p>
     * 原文：Gets a set containing all the incoming plugin channel registrations
     * that are on the requested channel.
     *
     * @param channel 要检索注册的通道
     * @return 在这个通道上注册的所有注册的列表
     * @throws IllegalArgumentException 如果参数channel为null
     */
    public Set<PluginMessageListenerRegistration> getIncomingChannelRegistrations(String channel);

    /**
     * 获取一个包含了指定插件在请求的通道上的所有接收的插件通道的注册的set集合.
     * <p>
     * 原文：Gets a set containing all the incoming plugin channel registrations
     * that the specified plugin has on the requested channel.
     *
     * @param plugin 要检索注册的插件
     * @param channel 由某个通道过滤注册
     * @return 这个插件拥有的所有注册的列表
     * @throws IllegalArgumentException 如果参数plugin或channel为null
     */
    public Set<PluginMessageListenerRegistration> getIncomingChannelRegistrations(Plugin plugin, String channel);

    /**
     * 检测指定插件消息监听器的注册是否有效.
     * <p>
     * 如果它没有注册以及插件仍然启用，那么注册就是有效的.
     * <p>
     * 原文：Checks if the specified plugin message listener registration is valid.
     * <p>
     * A registration is considered valid if it has not be unregistered and
     * that the plugin is still enabled.
     *
     * @param registration 要检测的注册
     * @return 如果注册是有效的则为true,false反之
     */
    public boolean isRegistrationValid(PluginMessageListenerRegistration registration);

    /**
     * 检测指定插件注册的传入的消息是否通过了请求的通道.
     * <p>
     * 译注：按方法名来看，应该是检测指定正在接收的通道是否在这个插件上注册过.
     * <p>
     * 原文：Checks if the specified plugin has registered to receive incoming
     * messages through the requested channel.
     *
     * @param plugin 要检测注册的插件
     * @param channel 要检测的通道
     * @return 如果通道已注册则为true，false反之
     */
    public boolean isIncomingChannelRegistered(Plugin plugin, String channel);

    /**
     * 检测指定插件注册的发送的消息是否通过了请求的通道.
     * <p>
     * 译注：按方法名来看，应该是检测指定正在发送的通道是否在这个插件上注册过.
     * <p>
     * 原文：Checks if the specified plugin has registered to send outgoing messages
     * through the requested channel.
     *
     * @param plugin 要检测注册的插件
     * @param channel 要检测的通道
     * @return 如果通道已注册则为true，false反之
     */
    public boolean isOutgoingChannelRegistered(Plugin plugin, String channel);

    /**
     * 调度指定接收消息的任何注册过的监听器.
     * <p>
     * 原文：Dispatches the specified incoming message to any registered listeners.
     *
     * @param source 消息源
     * @param channel 通过什么通道发送的消息
     * @param message 消息的原始有效载荷
     */
    public void dispatchIncomingMessage(Player source, String channel, byte[] message);
}