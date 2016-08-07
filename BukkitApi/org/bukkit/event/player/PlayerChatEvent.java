package org.bukkit.event.player;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.bukkit.Warning;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 存储玩家聊天和命令的信息。玩家聊天/使用命令会触发本事件。
 *
 * @deprecated 这个事件将被主线程触发，允许使用所有的 Bukkit API，不像{@link AsyncPlayerChatEvent}.
 *     <p>
 *     监听这个事件迫使聊天等待主线程，会导致聊天消息延迟展现。建议使用线程安全的{@link AsyncPlayerChatEvent}
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
     * 获取这个玩家尝试发送的消息。
     * <p>
     * 原文：Gets the message that the player is attempting to send
     *
     * @return 玩家尝试发送的消息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置这个玩家将发送的消息。
     * <p>
     * 原文：Sets the message that the player will send
     *
     * @param message 玩家将发送的新消息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 设置这条消息显示成的玩家，或谁将执行这条命令.
     * <p>
     * 原文:Sets the player that this message will display as, or command will be
     * executed as
     *
     * @param player 作为这个新玩家执行这个事件
     */
    public void setPlayer(final Player player) {
        Validate.notNull(player, "Player cannot be null");
        this.player = player;
    }

    /**
     * 获取用于展示这条消息的格式。
     * <p>
     * 原文:Gets the format to use to display this chat message
     *
     * @return 字符串格式:String.Format
     */
    public String getFormat() {
        return format;
    }

    /**
     * 设置用于展示这条消息的格式。
     * <p>
     * 原文:Sets the format to use to display this chat message
     *
     * @param format 字符串格式:String.Format
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
     * 获取一个将被展示这条消息的玩家的集合。
     * <p>
     * 原文:Gets a set of recipients that this chat message will be displayed to
     *
     * @return 将会看到本消息的所有玩家
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