package org.bukkit.event.player;

import java.util.IllegalFormatException;
import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当玩家聊天时触发这个事件.
 * <p>
 * 构造器提供了一个表示事件同步触发还是异步触发的布尔值。
 * 当异步时，本事件可以被任何线程调用，无主线程，访问API受限。
 * <p>
 * 如果玩家通过传入的聊天数据包导致触发本事件，本事件将是异步的。
 * 如果一个插件通过迫使玩家聊天（比如<code>Player.chat</code>）而触发本事件，本事件将是同步的。
 * <p>
 * 应注意通过{@link #isAsynchronous()}检查本事件是同步的还是异步的，适当地处理本事件。
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
     * 获得这个玩家试图发送的信息。这个消息
     * 将以{@link #getFormat()}的格式被获取。
     * <p>
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
     * 获取一个将看到这条消息的玩家的集合。
     * <p>
     * 本方法返回的集合不保证可以改变和访问时可能自动填充。
     * 任何监听器访问这个返回的集合应该知道对于一个lazy set的实现可能会降低性能.
     * <p>
     * 监听器应注意到如果事件传唤者提供了一个不可修改的Set集合的话修改这个列表可能会抛出{@link
     * UnsupportedOperationException}异常。
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
        return cancel;
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