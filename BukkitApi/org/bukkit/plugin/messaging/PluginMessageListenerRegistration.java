package org.bukkit.plugin.messaging;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * 包含了关于{@link Plugin}注册的插件通道的信息.
 */
public final class PluginMessageListenerRegistration {
    private final Messenger messenger;
    private final Plugin plugin;
    private final String channel;
    private final PluginMessageListener listener;

    public PluginMessageListenerRegistration(@NotNull Messenger messenger, @NotNull Plugin plugin, @NotNull String channel, @NotNull PluginMessageListener listener) {
        if (messenger == null) {
            throw new IllegalArgumentException("Messenger cannot be null!");
        }
        if (plugin == null) {
            throw new IllegalArgumentException("Plugin cannot be null!");
        }
        if (channel == null) {
            throw new IllegalArgumentException("Channel cannot be null!");
        }
        if (listener == null) {
            throw new IllegalArgumentException("Listener cannot be null!");
        }

        this.messenger = messenger;
        this.plugin = plugin;
        this.channel = channel;
        this.listener = listener;
    }

    /**
     * 获取插件注册的插件通道.
     * <p>
     * 原文：Gets the plugin channel that this registration is about.
     *
     * @return 插件通道
     */
    @NotNull
    public String getChannel() {
        return channel;
    }

    /**
     * 获取这个注册所描述的监听器.
     * <p>
     * 原文：Gets the registered listener described by this registration.
     *
     * @return 注册的监听器
     */
    @NotNull
    public PluginMessageListener getListener() {
        return listener;
    }

    /**
     * 获取这个注册的相关的插件.
     * <p>
     * 原文：Gets the plugin that this registration is for.
     *
     * @return 注册的插件
     */
    @NotNull
    public Plugin getPlugin() {
        return plugin;
    }

    /**
     * 检测这个注册是否仍然有效.
     * <p>
     * 原文：Checks if this registration is still valid.
     *
     * @return 如果这个注册还有效则为true，false反之
     */
    public boolean isValid() {
        return messenger.isRegistrationValid(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PluginMessageListenerRegistration other = (PluginMessageListenerRegistration) obj;
        if (this.messenger != other.messenger && !this.messenger.equals(other.messenger)) {
            return false;
        }
        if (this.plugin != other.plugin && !this.plugin.equals(other.plugin)) {
            return false;
        }
        if (!this.channel.equals(other.channel)) {
            return false;
        }
        if (this.listener != other.listener && !this.listener.equals(other.listener)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.messenger.hashCode();
        hash = 53 * hash + this.plugin.hashCode();
        hash = 53 * hash + this.channel.hashCode();
        hash = 53 * hash + this.listener.hashCode();
        return hash;
    }
}