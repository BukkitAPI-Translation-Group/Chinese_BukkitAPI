package org.bukkit.event.player;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.bukkit.Warning;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * Holds information for player chat and commands
 *
 * @deprecated This event will fire from the main thread and allows the use of
 *     all of the Bukkit API, unlike the {@link AsyncPlayerChatEvent}.
 *     <p>package org.bukkit.event.player;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.bukkit.Warning;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 保存玩家使用质量和说话的信息
 * 
 * @deprecated 不像{@link AsyncPlayerChatEvent}, 这个事件会从主线程开始并且会影响整个服务器
 * <p>
 * 使用这个事件会促使主线程等待由此会产生发送消息的延迟. {@link AsyncPlayerChatEvent} 在这里更加推荐.
 * <p>
 * Holds information for player chat and commands
 *
 * @deprecated This event will fire from the main thread and allows the use of
 *     all of the Bukkit API, unlike the {@link AsyncPlayerChatEvent}.
 *     <p>
 *     Listening to this event forces chat to wait for the main thread which
 *     causes delays for chat. {@link AsyncPlayerChatEvent} is the encouraged
 *     alternative for thread safe implementations.
 */
@Deprecated
@Warning(reason="会导致主线程等待并且会增加发送消息的延迟.")
public class PlayerChatEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private String message;
    private String format;
    private final Set<Player> recipients;

    public PlayerChatEvent(final Player player, final String message) {
        super(player);
        this.message = message;
        this.format = "<%1$s> %2$s";
        this.recipients = new HashSet<Player>(player.getServer().getOnlinePlayers());
    }

    public PlayerChatEvent(final Player player, final String message, final String format, final Set<Player> recipients) {
        super(player);
        this.message = message;
        this.format = format;
        this.recipients = recipients;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 获得玩家尝试发送的消息
     * 
     * @return 玩家尝试发送的消息
     *<p>
     * Gets the message that the player is attempting to send
     *
     * @return Message the player is attempting to send
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置玩家最终会发送的消息
     * 
     * @param message 玩家最终发送的消息
     * <p>
     * Sets the message that the player will send
     *
     * @param message New message that the player will send
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 设置最终显示发送这条消息或者这条指令的玩家
     * 
     * @param player 最终会发送这条消息或者这条指令的玩家
     * <p>
     * Sets the player that this message will display as, or command will be
     * executed as
     *
     * @param player New player which this event will execute as
     */
    public void setPlayer(final Player player) {
        Validate.notNull(player, "玩家不能为null");
        this.player = player;
    }

    /**
     * 获取最终显示这条消息的格式
     * 
     * @return 以String返回消息格式
     * <p>
     * Gets the format to use to display this chat message
     *
     * @return String.Format compatible format string
     */
    public String getFormat() {
        return format;
    }

    /**
     * 设置最终显示这条消息的格式
     * 
     * @param format 以String格式设置消息格式
     * <p>
     * Sets the format to use to display this chat message
     *
     * @param format String.Format compatible format string
     */
    public void setFormat(final String format) {
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
     * 获得一个列表的接受这条信息的玩家
     * 
     * @return 所有能看见这条消息的玩家
     * <p>
     * Gets a set of recipients that this chat message will be displayed to
     *
     * @return All Players who will see this chat message
     */
    public Set<Player> getRecipients() {
        return recipients;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}

 *     Listening to this event forces chat to wait for the main thread which
 *     causes delays for chat. {@link AsyncPlayerChatEvent} is the encouraged
 *     alternative for thread safe implementations.
 */
@Deprecated
@Warning(reason="Listening to this event forces chat to wait for the main thread, delaying chat messages.")
public class PlayerChatEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private String message;
    private String format;
    private final Set<Player> recipients;

    public PlayerChatEvent(final Player player, final String message) {
        super(player);
        this.message = message;
        this.format = "<%1$s> %2$s";
        this.recipients = new HashSet<Player>(player.getServer().getOnlinePlayers());
    }

    public PlayerChatEvent(final Player player, final String message, final String format, final Set<Player> recipients) {
        super(player);
        this.message = message;
        this.format = format;
        this.recipients = recipients;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * Gets the message that the player is attempting to send
     *
     * @return Message the player is attempting to send
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message that the player will send
     *
     * @param message New message that the player will send
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Sets the player that this message will display as, or command will be
     * executed as
     *
     * @param player New player which this event will execute as
     */
    public void setPlayer(final Player player) {
        Validate.notNull(player, "Player cannot be null");
        this.player = player;
    }

    /**
     * Gets the format to use to display this chat message
     *
     * @return String.Format compatible format string
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the format to use to display this chat message
     *
     * @param format String.Format compatible format string
     */
    public void setFormat(final String format) {
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
     * Gets a set of recipients that this chat message will be displayed to
     *
     * @return All Players who will see this chat message
     */
    public Set<Player> getRecipients() {
        return recipients;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
