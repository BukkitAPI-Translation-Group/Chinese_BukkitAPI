package org.bukkit.event.server;

import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;

/**
 * 这个事件当服务器后台发送指令时调用.
 * 这是命令处理过程早期方法.
 * 修改在这个事件({@link #setCommand(String)})所示的方法.
 * <p>
 * 很多插件<b>都不使用此事件</b>.如果这个事件不是必要的,你应该尽量避免适用它！
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
 * <p>
 * 原文:This event is called when a command is run from the server console. It is
 * called early in the command handling process, and modifications in this
 * event (via {@link #setCommand(String)}) will be shown in the behavior.
 * <p>
 * Many plugins will have <b>no use for this event</b>, and you should
 * attempt to avoid using it if it is not necessary.
 * <p>
 * Some examples of valid uses for this event are:
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
 * Examples of incorrect uses are:
 * <ul>
 * <li>Using this event to run command logic
 * </ul>
 * <p>
 * If the event is cancelled, processing of the command will halt.
 * <p>
 * The state of whether or not there is a slash (<code>/</code>) at the
 * beginning of the message should be preserved. If a slash is added or
 * removed, unexpected behavior may result.
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
     * 得到从控制台执行的命令.
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
     * 设置将执行的命令.
     * <p>
     * 原文:Sets the command that the server will execute
     *
     * @param message 控制台执行的命令
     */
    public void setCommand(String message) {
        this.command = message;
    }

    /**
     * 得到命令发送者.
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
