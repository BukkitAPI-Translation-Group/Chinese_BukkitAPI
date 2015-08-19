package org.bukkit.event.world;

import org.bukkit.World;
import org.bukkit.Location;
import org.bukkit.event.HandlerList;

/**
 * 一个在世界的出生点被改变时调用的事件.包含这个世界之前的出生点.
 */
public class SpawnChangeEvent extends WorldEvent {
    private static final HandlerList handlers = new HandlerList();
    private final Location previousLocation;

    public SpawnChangeEvent(final World world, final Location previousLocation) {
        super(world);
        this.previousLocation = previousLocation;
    }

    /**
     * 获取之前的出生点位置.
     * <p>
     * 原文:
     * Gets the previous spawn location
     *
     * @return 用于出生点的位置
     */
    public Location getPreviousLocation() {
        return previousLocation;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}