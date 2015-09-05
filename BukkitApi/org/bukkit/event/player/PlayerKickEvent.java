package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 玩家被服务器踢出事件.
 */
public class PlayerKickEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private String leaveMessage;
    private String kickReason;
    private Boolean cancel;

    public PlayerKickEvent(final Player playerKicked, final String kickReason, final String leaveMessage) {
        super(playerKicked);
        this.kickReason = kickReason;
        this.leaveMessage = leaveMessage;
        this.cancel = false;
    }

    /**
     * 获取某被踢出的玩家的踢出原因. <p>
     * 原文:Gets the reason why the player is getting kicked
     *
     * @return 玩家的踢出原因
     */
    public String getReason() {
        return kickReason;
    }

    /**
     * 获取某玩家被踢出后，发送给全体玩家的留言. <p>
     * 原文:Gets the leave message send to all online players
     *
     * @return 玩家的踢出原因
     */
    public String getLeaveMessage() {
        return leaveMessage;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 设置将要踢出某玩家的踢出原因. <p>
     * 原文:Sets the reason why the player is getting kicked
     *
     * @param kickReason kick reason
     */
    public void setReason(String kickReason) {
        this.kickReason = kickReason;
    }

    /**
     * 设置将要踢出某玩家被踢出后，发送给全体玩家的留言. <p>
     * 原文:Sets the leave message send to all online players
     *
     * @param leaveMessage leave message
     */
    public void setLeaveMessage(String leaveMessage) {
        this.leaveMessage = leaveMessage;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
