package org.bukkit.event.vehicle;

import org.bukkit.entity.Vehicle;

/**
 * 两个载具碰撞的事件
 */
public abstract class VehicleCollisionEvent extends VehicleEvent {
    public VehicleCollisionEvent(final Vehicle vehicle) {
        super(vehicle);
    }
}
