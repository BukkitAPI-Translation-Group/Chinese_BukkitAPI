package org.bukkit.event.player;

import java.util.IllegalFormatException;
import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当玩家聊天时触发这个事件.
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
     * @param message 发送信息
     * @param players 消息发送者
     */
    public AsyncPlayerChatEvent(final boolean async, final Player who, final String message, final Set<Player> players) {
        super(who, async);
        this.message = message;
        recipients = players;
    }

    /**
    /**
     * 获得这个玩家试图发送的信息. 这个消息
     * 将与 {@link #getFormat()} 伴随着发送.
     *<p>
     * 原文:Gets the message that the player is attempting to send. This message
     * will be used with {@link #getFormat()}.
     *
     * @return Message the player is attempting to send
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置这个玩家将发送的信息.这个消息
     * 将与 {@link #getFormat()} 伴随着发送.
     * <p>
     * 原文:Sets the message that the player will send. This message will be used
     * with {@link #getFormat()}.
     *
     * @param message 这个玩家将发送的新消息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取这个消息的输出格式.
     * <p>
     * 当这个事件被触发,这个格式的第一个部分是
     * {@link Player#getDisplayName()} 第二个部分是 {@link#getMessage()}
     * <p>
     * 原文:Gets the format to use to display this chat message.
     * <p>
     * When this event finishes execution, the first format parameter is the
     * {@link Player#getDisplayName()} and the second parameter is {@link
     * #getMessage()}
     *
     * @return {@link String#format(String, Object...)} 输出格式
     */
    public String getFormat() {
        return format;
    }

    /**
     * 设置这个消息的输出格式
     * <p>
     * 当这个事件被触发,这个格式的第一个部分是
     * {@link Player#getDisplayName()} 第二个部分是 {@link#getMessage()}
     * <p>
     * 原文:Sets the format to use to display this chat message.
     * <p>
     * When this event finishes execution, the first format parameter is the
     * {@link Player#getDisplayName()} and the second parameter is {@link
     * #getMessage()}
     *
     * @param format {@link String#format(String, Object...)} 输出格式
     * @throws IllegalFormatException 底层API抛出错误
     * @throws NullPointerException 如果这个格式为null
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
     * 获取这个消息的最终接收玩家.
     * 
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
