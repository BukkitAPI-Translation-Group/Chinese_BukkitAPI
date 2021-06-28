package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

/**
 * 玩家移动速度变化事件.
 */
public class PlayerVelocityEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private Vector velocity;

    public PlayerVelocityEvent(@NotNull final Player player, @NotNull final Vector velocity) {
        super(player);
        this.velocity = velocity;
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
     * 得到玩家目前的移动速度.
     * <p>
     * 原文:Gets the velocity vector that will be sent to the player
     *
     * @return 玩家移动速度
     */
    @NotNull
    public Vector getVelocity() {
        return velocity;
    }

    /**
     * 设置玩家移动速度 (单位: 米每tick).
     * <p>
     * 原文:Sets the velocity vector in meters per tick that will be sent to the player
     *
     * @param velocity 玩家速度
     */
    public void setVelocity(@NotNull Vector velocity) {
        this.velocity = velocity;
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