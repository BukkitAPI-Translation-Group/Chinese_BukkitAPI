package org.bukkit.event.weather;

import org.bukkit.World;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

/**
 * 和天气有关的事件
 */
public abstract class WeatherEvent extends Event {
    protected World world;

    public WeatherEvent(@NotNull final World where) {
        world = where;
    }

    /**
     * 返回发生此次天气事件所在的世界.
     * <p>
     * 原文:
     * Returns the World where this event is occurring
     *
     * @return 天气事件所在的世界
     */
    @NotNull
    public final World getWorld() {
        return world;
    }
}
