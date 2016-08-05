package org.bukkit.event.player;

import java.util.IllegalFormatException;
import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当玩家聊天时触发这个事件.
 * <p>
 * 构造器提供了一个表示事件同步触发还是异步触发的布尔值。当异步时，本事件可以被任何线程调用，无主线程，访问API受限。
 * <p>
 * The constructor provides a boolean to indicate if the event was fired
 * synchronously or asynchronously. When asynchronous, this event can be
 * called from any thread, sans the main thread, and has limited access to the
 * API.
 * <p>
 * If a player is the direct cause of this event by an incoming packet, this
 * event will be asynchronous. If a plugin triggers this event by compelling a
 * player to chat, this event will be synchronous.
 * <p>
 * Care should be taken to check {@link #isAsynchronous()} and treat the event
 * appropriately.
 */
public class AsyncPlayerChatEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private String message;
    private String format = "<%1$s> %2$s";
    private final Set<Player> recipients;

    /**
     *
     * @param async 设置该事件为同步事件
     * @param who 触发者
     * @param message 发送的信息
     * @param players 消息发送者
     */
    public AsyncPlayerChatEvent(final boolean async, final Player who, final String message, final Set<Player> players) {
        super(who, async);
        this.message = message;
        recipients = players;
    }

    /**
    /**
     * 获得这个玩家试图发送的信息。这个消息
     * 将以{@link #getFormat()}的格式被获取。
     *<p>
     * 原文:Gets the message that the player is attempting to send. This message
     * will be used with {@link #getFormat()}.
     *
     * @return 这个玩家试图发送的信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置这个玩家将发送的信息。这个消息
     * 将以{@link #getFormat()}的格式被设置。
     * <p>
     * 原文:Sets the message that the player will send. This message will be used
     * with {@link #getFormat()}.
     *
     * @param message 设置的这个玩家将发送的新消息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取用于展示这条字符消息的格式。
     * <p>
     * 这个事件执行完毕后，获取的格式的第一个部分是
     * {@link Player#getDisplayName()} 第二个部分是 {@link#getMessage()}
     * <p>
     * 原文:Gets the format to use to display this chat message.
     * <p>
     * When this event finishes execution, the first format parameter is the
     * {@link Player#getDisplayName()} and the second parameter is {@link
     * #getMessage()}
     *
     * @return 输出格式：{@link String#format(String, Object...)} 
     */
    public String getFormat() {
        return format;
    }

    /**
     * 设置用于展示这条字符消息的格式。
     * <p>
     * 这个事件执行完毕后，设置的格式的第一个部分是
     * {@link Player#getDisplayName()} 第二个部分是 {@link#getMessage()}
     * <p>
     * 原文:Sets the format to use to display this chat message.
     * <p>
     * When this event finishes execution, the first format parameter is the
     * {@link Player#getDisplayName()} and the second parameter is {@link
     * #getMessage()}
     *
     * @param format 输出格式：{@link String#format(String, Object...)}
     * @throws IllegalFormatException 底层API抛出错误
     * @throws NullPointerException 如果这个格式为null则抛出错误
     * @see String#format(String, Object...)
     */
    public void setFormat(final String format) throws IllegalFormatException, NullPointerException {
        // Oh for a better way to do this!
        try {
            String.format(format, player, message);
        } catch (RuntimeException ex) {
            ex.fillInStackTrace();
            throw ex;
        }

        this.format = format;
    }

    /**
     * 获取一个被展示这条字符消息的收件人的集合。
     * <p>
     * 原文:Gets a set of recipients that this chat message will be displayed to.
     * <p>
     * The set returned is not guaranteed to be mutable and may auto-populate
     * on access. Any listener accessing the returned set should be aware that
     * it may reduce performance for a lazy set implementation.
     * <p>
     * Listeners should be aware that modifying the list may throw {@link
     * UnsupportedOperationException} if the event caller provides an
     * unmodifiable set.
     *
     * @return 所有会看到这个消息的玩家
     */
    public Set<Player> getRecipients() {
        return recipients;
    }

    public boolean isCancelled() {
        return cancel ;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}