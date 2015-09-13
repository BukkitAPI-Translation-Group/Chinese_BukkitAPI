package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 玩家进入潜行状态则调用此事件.
 */
public class PlayerToggleSneakEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final boolean isSneaking;
    private boolean cancel = false;

    public PlayerToggleSneakEvent(final Player player, final boolean isSneaking) {
        super(player);
        this.isSneaking = isSneaking;
    }

    /**
     * 获得玩家目前的潜行状态(正在潜行/没有潜行).
     * <p>
     * 原文:Returns whether the player is now sneaking or not.
     *
     * @return 潜行状态
     */
    public boolean isSneaking() {
        return isSneaking;
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
