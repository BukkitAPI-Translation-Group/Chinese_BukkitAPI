package org.bukkit.event.server;

import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 这个事件当服务器后台发送指令时调用.
 * 这是命令开始处理过程之前被触发的.
 * <p>
 * 很多插件<b>都不使用此事件</b>.如果这个事件不是必要的,你应该尽量避免使用它!
 * <p>
 * 正确使用该事件的事例如下:
 * <ul>
 * <li>将执行的文件记录在一个单独的文件里</li>
 * <li>变量替换.例如，用玩家Steve的ip替换<code>${ip:Steve}</code>，或者模拟<code>@a</code>和<code>@p</code>作为装饰命令方块，插件不处理它.</li>
 * <li>有条件地阻止其它插件的命令.</li>
 * <li>个人发送者命令别名.例如，在控制台运行命令<code>/calias cr gamemode creative</code>后，下一次运行命令<code>/cr</code>，它将会被替换成<code>/gamemode creative</code>(全局命令别名应该通过注册的别名来完成)</li>
 * </ul>
 * <p>
 * 不正确使用该事件的事例如下:
 * <ul>
 * <li>使用该事件来运行命令逻辑</li>
 * </ul>
 * <p>
 * 如果事件被取消,处理命令将停止.
 */
public class ServerCommandEvent extends ServerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private String command;
    private final CommandSender sender;
    private boolean cancel = false;

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

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
}