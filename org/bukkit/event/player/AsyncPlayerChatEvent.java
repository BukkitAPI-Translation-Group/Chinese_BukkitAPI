package org.bukkit.event.player;

import java.util.IllegalFormatException;
import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 这个事件有时候会同时激发，要看它是如何被触发的。
 * <p>
 * 这个构造函数提供了一个布尔来表示这个事件
 * 该构造提供了一个布尔值，表明如果该事件是同步或异步触发的。如果是异步的，这个事件可以
 * 从任何线程，并且限制访问API。
 * <p>
 * 如果一名玩家是这个事件的直接原因，这
 * 个事件将是异步的。如果一个插件触发此事件，本次活动将是同步的。
 * <p>
 * 应该注意检查 {@link #isAsynchronous()} 并且合适地处理
 */
public class AsyncPlayerChatEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private String message;
    private String format = "<%1$s> %2$s";
    private final Set<Player> recipients;

    /**
     *
     * @param async 把事件改变成同步.
     * @param who 发送这段话的玩家.
     * @param message 发送的这段话.
     * @param players 收到的玩家.
     */
    public AsyncPlayerChatEvent(final boolean async, final Player who, final String message, final Set<Player> players) {
        super(who, async);
        this.message = message;
        recipients = players;
    }

    /**
     * 获取玩家尝试发送的语句，这个语句会和 {@link #getFormat()} 一起使用
     * @return 玩家尝试发送的信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置玩家最终发送的语句，会和 {@link #getFormat()}一起使用.
     *
     * @param message 玩家最终发送的语句
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获得最终显示信息的格式.
     * <p>
     * 当这个事件完成的时候, 第一个参数是
     * {@link Player#getDisplayName()} ，第二个参数是 {@link
     * #getMessage()}
     *
     * @return {@link String#format(String, Object...)} String格式
     */
    public String getFormat() {
        return format;
    }

    /**
     * 设置最终显示信息的格式.
     * <p>
     * 当这个事件执行完成的时候, 第一个参数是
     * {@link Player#getDisplayName()} ,第二个参数是 {@link
     * #getMessage()}
     *
     * @param format {@link String#format(String, Object...)} 格式(String)
     * @throws IllegalFormatException if the underlying API throws the exception
     * @throws NullPointerException 如果格式为null
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
     * 获得所有接受到这个消息的玩家.
     * <p>
     * 返回的数组不一定是可以编辑的, 并且有可能在访问的时候被系统自动填充.
     * 所有涉及到这个方法的应该注意应为可能会降低性能
     * <p>
     * 你应该注意应为如果在输出的不可编辑的列表仍然尝试编辑这个列表可能会扔出 {@link
     * @return All 所有看到这个消息的玩家
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