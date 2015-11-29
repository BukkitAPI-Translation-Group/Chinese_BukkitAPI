package org.bukkit.event.vehicle;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 实体进入载具的事件
 */
public class VehicleEnterEvent extends VehicleEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Entity entered;

    public VehicleEnterEvent(final Vehicle vehicle, final Entity entered) {
        super(vehicle);
        this.entered = entered;
    }

    /**
     * 获取进入到载具中的实体.
     * <p>
     * 原文:Gets the Entity that entered the vehicle.
     *
     * @return 进入到载具中的实体
     */
    public Entity getEntered() {
        return entered;
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