package org.bukkit.command;

import org.bukkit.Server;
import org.bukkit.permissions.Permissible;

public interface CommandSender extends Permissible {

    /**
     * 给命令发送者发送消息.
     * <p>
     * 原文:
     * Sends this sender a message
     *
     * @param message 要显示的消息
     */
    public void sendMessage(String message);

    /**
     * 给命令发送者发送多条消息.
     * <p>
     * 原文:
     * Sends this sender multiple messages
     *
     * @param messages 要显示的消息(必须为数组)
     */
    public void sendMessage(String[] messages);

    /**
     * 返回服务器运行此命令的对象.
     * <p>
     * 原文:
     * Returns the server instance that this command is running on
     *
     * @return 服务器对象
     */
    public Server getServer();

    /**
     * 获取命令发送者的名字.
     * <p>
     * 原文:
     * Gets the name of this command sender
     *
     * @return 发送者的名字
     */
    public String getName();
}
