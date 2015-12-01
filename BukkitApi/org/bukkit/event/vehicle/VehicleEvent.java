package org.bukkit.event.vehicle;

import org.bukkit.entity.Vehicle;
import org.bukkit.event.Event;

/**
 * 代表所有和载具有关的事件
 */
public abstract class VehicleEvent extends Event {
    protected Vehicle vehicle;

    public VehicleEvent(final Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * 获取发生事件的载具.
     * <p>
     * 原文:Get the vehicle
     *
     * @return 发生事件的载具
     */
    public final Vehicle getVehicle() {
        return vehicle;
    }
}