package org.bukkit.event.vehicle;

import org.bukkit.block.Block;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.HandlerList;

/**
 * 载具撞击方块的事件
 */
public class VehicleBlockCollisionEvent extends VehicleCollisionEvent {
    private static final HandlerList handlers = new HandlerList();
    private final Block block;

    public VehicleBlockCollisionEvent(final Vehicle vehicle, final Block block) {
        super(vehicle);
        this.block = block;
    }

    /**
     * 获取载具撞到的方块.
     * <p>
     * 原文:Gets the block the vehicle collided with
     *
     * @return 载具撞到的方块
     */
    public Block getBlock() {
        return block;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}