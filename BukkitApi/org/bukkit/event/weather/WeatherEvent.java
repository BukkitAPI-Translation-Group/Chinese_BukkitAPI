package org.bukkit.event.weather;

import org.bukkit.World;
import org.bukkit.event.Event;

/**
 * 和天气有关的事件
 */
public abstract class WeatherEvent extends Event {
    protected World world;

    public WeatherEvent(final World where) {
        world = where;
    }

    /**
     * 返回天气事件所发生的世界
     *
     * @return 天气事件所发生的世界
     */
    public final World getWorld() {
        return world;
    }
}
