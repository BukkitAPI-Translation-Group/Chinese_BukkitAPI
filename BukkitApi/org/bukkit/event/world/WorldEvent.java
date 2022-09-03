package org.bukkit.event.world;

import org.bukkit.World;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

/**
 * 代表世界范围内的事件.
 */
public abstract class WorldEvent extends Event {
    private final World world;

    public WorldEvent(@NotNull final World world) {
        this(world, false);
    }

    public WorldEvent(@NotNull World world, boolean isAsync) {
        super(isAsync);
        this.world = world;
    }

    /**
     * 获取这个事件主要涉及的世界.
     * <p>
     * 原文:
     * Gets the world primarily involved with this event
     *
     * @return 引发这个事件的世界
     */
    @NotNull
    public World getWorld() {
        return world;
    }
}