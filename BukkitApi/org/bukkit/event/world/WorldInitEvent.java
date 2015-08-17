package org.bukkit.event.world;

import org.bukkit.World;
import org.bukkit.event.HandlerList;

/**
 * 当一个世界被初始化时调用.
 */
public class WorldInitEvent extends WorldEvent {
    private static final HandlerList handlers = new HandlerList();

    public WorldInitEvent(final World world) {
        super(world);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}