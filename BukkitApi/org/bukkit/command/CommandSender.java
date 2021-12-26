package org.bukkit.command;

import java.util.UUID;
import org.bukkit.Server;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface CommandSender extends Permissible {

    /**
     * 向命令发送者发送消息.
     * <p>
     * 原文:
     * Sends this sender a message
     *
     * @param message 要发送的消息
     */
    public void sendMessage(@NotNull String message);

    /**
     * 向命令发送者发送多条消息.
     * <p>
     * 原文:
     * Sends this sender multiple messages
     *
     * @param messages 要发送的消息
     */
    public void sendMessage(@NotNull String... messages);

    /**
     * 向命令发送者发送消息.
     * <p>
     * 原文:
     * Sends this sender a message
     *
     * @param message 要发送的消息
     * @param sender 消息的发送者
     */
    public void sendMessage(@Nullable UUID sender, @NotNull String message);

    /**
     * 向命令发送者发送多条消息.
     * <p>
     * 原文:
     * Sends this sender multiple messages
     *
     * @param messages 要发送的消息
     * @param sender 消息的发送者
     */
    public void sendMessage(@Nullable UUID sender, @NotNull String... messages);

    /**
     * 返回运行此命令的服务器实例.
     * <p>
     * 原文:
     * Returns the server instance that this command is running on
     *
     * @return 服务器实例
     */
    @NotNull
    public Server getServer();

    /**
     * 获取命令发送者的名字.
     * <p>
     * 原文:
     * Gets the name of this command sender
     *
     * @return 发送者的名字
     */
    @NotNull
    public String getName();

    // Spigot start
    public class Spigot {

        /**
         * 向命令发送者发送一个聊天消息组件.
         * <p>
         * 原文:Sends this sender a chat component.
         *
         * @param component 要发送的聊天消息组件
         */
        public void sendMessage(@NotNull net.md_5.bungee.api.chat.BaseComponent component) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * 将多个聊天消息组件作为单条消息发送给命令发送者.
         * <p>
         * 原文:Sends an array of components as a single message to the sender.
         *
         * @param components 要发送的聊天消息组件
         */
        public void sendMessage(@NotNull net.md_5.bungee.api.chat.BaseComponent... components) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * 向命令发送者发送一个聊天消息组件.
         * <p>
         * 原文:Sends this sender a chat component.
         *
         * @param component 要发送的聊天消息组件
         * @param sender 消息的发送者
         */
        public void sendMessage(@Nullable UUID sender, @NotNull net.md_5.bungee.api.chat.BaseComponent component) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * 将多个聊天消息组件作为单条消息发送给命令发送者.
         * <p>
         * 原文:Sends an array of components as a single message to the sender.
         *
         * @param components 要发送的聊天消息组件
         * @param sender 消息的发送者
         */
        public void sendMessage(@Nullable UUID sender, @NotNull net.md_5.bungee.api.chat.BaseComponent... components) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @NotNull
    Spigot spigot();
    // Spigot end
}
