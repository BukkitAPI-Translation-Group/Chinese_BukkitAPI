package org.bukkit.event.server;

import org.bukkit.event.HandlerList;
import org.bukkit.map.MapView;
import org.jetbrains.annotations.NotNull;

/**
 * 地图初始化时调用.
 */
public class MapInitializeEvent extends ServerEvent {
    private static final HandlerList handlers = new HandlerList();
    private final MapView mapView;

    public MapInitializeEvent(@NotNull final MapView mapView) {
        this.mapView = mapView;
    }

    /**
     * 获得本事件初始化的地图.
     * <p>
     * 原文:Gets the map initialized in this event.
     *
     * @return 地图物品.
     */
    @NotNull
    public MapView getMap() {
        return mapView;
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
