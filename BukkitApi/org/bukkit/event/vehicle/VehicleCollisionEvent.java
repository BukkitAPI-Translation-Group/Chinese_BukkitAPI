package org.bukkit.event.vehicle;

import org.bukkit.entity.Vehicle;
import org.jetbrains.annotations.NotNull;

/**
 * 两个载具碰撞的事件
 */
public abstract class VehicleCollisionEvent extends VehicleEvent {
    public VehicleCollisionEvent(@NotNull final Vehicle vehicle) {
        super(vehicle);
    }
}
