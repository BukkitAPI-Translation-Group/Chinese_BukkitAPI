package org.bukkit.event.vehicle;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 载具被损毁的事件（包含被玩家/自然损坏）。若有一个船直接被"删除"了，这个事件将不会被调用.
 */
public class VehicleDestroyEvent extends VehicleEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Entity attacker;
    private boolean cancelled;

    public VehicleDestroyEvent(final Vehicle vehicle, final Entity attacker) {
        super(vehicle);
        this.attacker = attacker;
    }

    /**
     * 获取损毁载具的实体，可能为null.
     * <p>
     * 原文:Gets the Entity that has destroyed the vehicle, potentially null
     *
     * @return 损毁载具的实体，可能为null
     */
    public Entity getAttacker() {
        return attacker;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}