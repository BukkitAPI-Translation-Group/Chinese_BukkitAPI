package org.bukkit.event.vehicle;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 实体退出载具的事件
 */
public class VehicleExitEvent extends VehicleEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final LivingEntity exited;

    public VehicleExitEvent(@NotNull final Vehicle vehicle, @NotNull final LivingEntity exited) {
        super(vehicle);
        this.exited = exited;
    }

    /**
     * 获取退出载具事件的实体.
     * <p>
     * 原文:Get the living entity that exited the vehicle.
     *
     * @return 退出载具的实体
     */
    @NotNull
    public LivingEntity getExited() {
        return exited;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
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