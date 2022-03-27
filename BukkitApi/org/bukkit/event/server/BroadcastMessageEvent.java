package org.bukkit.event.server;

import java.util.Set;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 当服务器发送广播消息 (比如使用 
 * {@link org.bukkit.Server#broadcast(String, String)} 方法) 时调用.
 *
 * <b>这个事件与 {@link AsyncPlayerChatEvent} 表现相似,
 * 如果这个事件从一个异步线程触发, 那这个事件也应是异步的.
 * 前往 {@link AsyncPlayerChatEvent} 了解更多信息.</b>
 */
public class BroadcastMessageEvent extends ServerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private String message;
    private final Set<CommandSender> recipients;
    private boolean cancelled = false;

    @Deprecated
    public BroadcastMessageEvent(@NotNull String message, @NotNull Set<CommandSender> recipients) {
        this(false, message, recipients);
    }

    public BroadcastMessageEvent(boolean isAsync, @NotNull String message, @NotNull Set<CommandSender> recipients) {
        super(isAsync);
        this.message = message;
        this.recipients = recipients;
    }

    /**
     * 获取将广播的消息.
     * <p>
     * 原文:
     * Get the message to broadcast.
     *
     * @return 广播的消息
     */
    @NotNull
    public String getMessage() {
        return message;
    }

    /**
     * 设置将广播的消息.
     * <p>
     * 原文:
     * Set the message to broadcast.
     *
     * @param message 广播的消息
     */
    public void setMessage(@NotNull String message) {
        this.message = message;
    }

    /**
     * 获取一个将显示这条消息的接收者的集合.
     * <p>
     * 本方法返回的集合不保证可以改变和访问时可能自动填充.
     * 任何访问这个集合的监听器都应注意对于一个 lazy set 的实现可能会降低性能.
     * <p>
     * 监听器应注意到如果事件传唤者提供了一个不可修改的Set集合的话修改这个列表可能会抛出{@link
     * UnsupportedOperationException}异常.
     * <p>
     * 原文:
     * Gets a set of recipients that this chat message will be displayed to.
     * <p>
     * The set returned is not guaranteed to be mutable and may auto-populate
     * on access. Any listener accessing the returned set should be aware that
     * it may reduce performance for a lazy set implementation.
     * <p>
     * Listeners should be aware that modifying the list may throw {@link
     * UnsupportedOperationException} if the event caller provides an
     * unmodifiable set.
     *
     * @return 所有会看到这条消息的接收者
     */
    @NotNull
    public Set<CommandSender> getRecipients() {
        return recipients;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
