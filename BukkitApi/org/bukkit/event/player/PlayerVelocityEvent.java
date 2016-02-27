package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.util.Vector;

/**
 * 玩家移动速度变化事件.
 */
public class PlayerVelocityEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private Vector velocity;

    public PlayerVelocityEvent(final Player player, final Vector velocity) {
        super(player);
        this.velocity = velocity;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 得到玩家目前的移动速度.
     * <p>
     * 原文:Gets the velocity vector that will be sent to the player
     *
     * @return 玩家移动速度
     */
    public Vector getVelocity() {
        return velocity;
    }

    /**
     * 设置玩家移动速度.
     * <p>
     * 原文:Sets the velocity vector that will be sent to the player
     *
     * @param velocity 玩家速度
     */
    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}