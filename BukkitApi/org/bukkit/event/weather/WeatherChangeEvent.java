package org.bukkit.event.weather;

import org.bukkit.World;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 天气改变事件
 */
public class WeatherChangeEvent extends WeatherEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean canceled;
    private final boolean to;

    public WeatherChangeEvent(@NotNull final World world, final boolean to) {
        super(world);
        this.to = to;
    }

    @Override
    public boolean isCancelled() {
        return canceled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        canceled = cancel;
    }

    /**
     * 获取世界是否将要下雨/雪.
     * <p>
     * 原文:
     * Gets the state of weather that the world is being set to
     *
     * @return true 代表世界将下雨/雪，false 反之
     */
    public boolean toWeatherState() {
        return to;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}