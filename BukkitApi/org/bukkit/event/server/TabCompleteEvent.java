package org.bukkit.event.server;

import java.util.List;
import org.apache.commons.lang.Validate;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerCommandSendEvent;

/**
 * 当一个 {@link CommandSender} 尝试补全命令时触发本事件.
 * <br>
 * 请注意由于客户端的更改, 如果命令发起者是玩家, 本事件
 * 将只有在指定了命令参数后触发, 而不是命令本身.建议希望从tab补全列表删除命令的插件
 * 确保客户端没有相关命令的执行权限, 或使用{@link PlayerCommandSendEvent}.
 */
public class TabCompleteEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    //
    private final CommandSender sender;
    private final String buffer;
    private List<String> completions;
    private boolean cancelled;

    public TabCompleteEvent(CommandSender sender, String buffer, List<String> completions) {
        Validate.notNull(sender, "sender");
        Validate.notNull(buffer, "buffer");
        Validate.notNull(completions, "completions");

        this.sender = sender;
        this.buffer = buffer;
        this.completions = completions;
    }

    /**
     * 获取正在补全这个命令的发送者.
     * <p>
     * 原文：Get the sender completing this command.
     *
     * @return {@link CommandSender} 实例
     */
    public CommandSender getSender() {
        return sender;
    }

    /**
     * 返回构成这个补全项的命令缓冲区.
     * <p>
     * 译注：命令缓冲区是什么？比如您对命令”/tp no”进行补全，”/tp no”即为这个buffer
     * <p>
     * 原文:Return the entire buffer which formed the basis of this completion.
     *
     * @return 命令缓冲区，即为你输入的
     */
    public String getBuffer() {
        return buffer;
    }

    /**
     * 提供给发送者的补全项的列表.
     * 这个列表是可变的，可以编辑该列表以实现更改补全项.
     * <p>
     * 原文：The list of completions which will be offered to the sender, in order.
     * This list is mutable and reflects what will be offered.
     *
     * @return 提供的补全项的列表
     */
    public List<String> getCompletions() {
        return completions;
    }

    /**
     * 设置提供的补全项，会覆盖已设置的补全项.
     * <p>
     * 原文：Set the completions offered, overriding any already set.
     *
     * @param completions 新的补全项
     */
    public void setCompletions(List<String> completions) {
        Validate.notNull(completions);
        this.completions = completions;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
