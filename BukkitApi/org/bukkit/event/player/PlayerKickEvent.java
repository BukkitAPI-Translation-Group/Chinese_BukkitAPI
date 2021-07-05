package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 玩家被服务器踢出事件.
 */
public class PlayerKickEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private String leaveMessage;
    private String kickReason;
    private Boolean cancel;

    public PlayerKickEvent(@NotNull final Player playerKicked, @NotNull final String kickReason, @NotNull final String leaveMessage) {
        super(playerKicked);
        this.kickReason = kickReason;
        this.leaveMessage = leaveMessage;
        this.cancel = false;
    }

    /**
     * 获取踢出的玩家的理由.
     * <p>
     * 原文:Gets the reason why the player is getting kicked
     *
     * @return 踢出玩家的理由
     */
    @NotNull
    public String getReason() {
        return kickReason;
    }

    /**
     * 获取某玩家被踢出后,发送给全体玩家的离开消息.
     * <p>
     * 原文:Gets the leave message send to all online players
     *
     * @return 离开消息
     */
    @NotNull
    public String getLeaveMessage() {
        return leaveMessage;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 设置踢出某玩家的理由.
     * <p>
     * 原文:Sets the reason why the player is getting kicked
     *
     * @param kickReason kick reason
     */
    public void setReason(@NotNull String kickReason) {
        this.kickReason = kickReason;
    }

    /**
     * 设置某玩家被踢出后,发送给全体玩家的离开消息.
     * <p>
     * 原文:Sets the leave message send to all online players
     *
     * @param leaveMessage 离开消息
     */
    public void setLeaveMessage(@NotNull String leaveMessage) {
        this.leaveMessage = leaveMessage;
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