package org.bukkit.event.server;

import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;

/**
 * 这个事件当服务器后台发送指令时调用.
 * 这是命令开始处理过程之前被触发的.
 * <p>
 * 很多插件<b>都不使用此事件</b>.如果这个事件不是必要的,你应该尽量避免使用它!
 * <p>
 * 正确使用该事件的事例如下:
 * <ul>
 * <li>Logging executed commands to a separate file
 * <li>Variable substitution. For example, replacing <code>${ip:Steve}</code>
 *     with the connection IP of the player named Steve, or simulating the
 *     <code>@a</code> and <code>@p</code> decorators used by Command Blocks
 *     for plugins that do not handle it.
 * <li>Conditionally blocking commands belonging to other plugins.
 * <li>Per-sender command aliases. For example, after the console runs the
 *     command <code>/calias cr gamemode creative</code>, the next time they
 *     run <code>/cr</code>, it gets replaced into
 *     <code>/gamemode creative</code>. (Global command aliases should be
 *     done by registering the alias.)
 * </ul>
 * <p>
 * 不正确使用该事件的事例如下:
 * <ul>
 * <li>Using this event to run command logic
 * </ul>
 * <p>
 * 如果事件被取消,处理命令将停止.
 */
public class ServerCommandEvent extends ServerEvent {
    private static final HandlerList handlers = new HandlerList();
    private String command;
    private final CommandSender sender;

    public ServerCommandEvent(final CommandSender sender, final String command) {
        this.command = command;
        this.sender = sender;
    }

    /**
     * 得到从控制台执行的命令(触发这个事件的命令).
     * <p>
     * 原文:Gets the command that the user is attempting to execute from the
     * console
     *
     * @return 尝试执行的命令
     */
    public String getCommand() {
        return command;
    }

    /**
     * 设置将要执行的命令.
     * <p>
     * 原文:Sets the command that the server will execute
     *
     * @param message 控制台将会执行的命令
     */
    public void setCommand(String message) {
        this.command = message;
    }

    /**
     * 得到命令发送者(后台).
     * <p>
     * 原文:Get the command sender.
     *
     * @return 发送者
     */
    public CommandSender getSender() {
        return sender;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
