package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 玩家进入飞行状态则调用此事件.
 */
public class PlayerToggleFlightEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final boolean isFlying;
    private boolean cancel = false;

    public PlayerToggleFlightEvent(final Player player, final boolean isFlying) {
        super(player);
        this.isFlying = isFlying;
    }

    /**
     * 返回玩家是否正在飞行或没有飞行.
     * <p>
     * 原文:Returns whether the player is trying to start or stop flying.
     *
     * @return 飞行状态
     */
    public boolean isFlying() {
        return isFlying;
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
