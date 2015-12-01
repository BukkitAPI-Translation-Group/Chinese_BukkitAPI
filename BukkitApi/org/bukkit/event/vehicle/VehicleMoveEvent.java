package org.bukkit.event.vehicle;

import org.bukkit.Location;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.HandlerList;

/**
 * 载具移动事件
 */
public class VehicleMoveEvent extends VehicleEvent {
    private static final HandlerList handlers = new HandlerList();
    private final Location from;
    private final Location to;

    public VehicleMoveEvent(final Vehicle vehicle, final Location from, final Location to) {
        super(vehicle);

        this.from = from;
        this.to = to;
    }

    /**
     * 获取载具的上一个位置.
     * <p>
     * 原文:Get the previous position.
     *
     * @return 旧的位置
     */
    public Location getFrom() {
        return from;
    }

    /**
     * 获取载具新的位置.
     * <p>
     * 原文:Get the next position.
     *
     * @return 新的位置
     */
    public Location getTo() {
        return to;
    }


    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}