package org.bukkit.event.server;

import org.bukkit.event.HandlerList;
import org.bukkit.map.MapView;

/**
 * 地图初始化时调用.
 */
public class MapInitializeEvent extends ServerEvent {
    private static final HandlerList handlers = new HandlerList();
    private final MapView mapView;

    public MapInitializeEvent(final MapView mapView) {
        this.mapView = mapView;
    }

    /**
     * 获得地图初始化信息.
     * <p>
     * 原文:Gets the map initialized in this event.
     *
     * @return 地图事件.
     */
    public MapView getMap() {
        return mapView;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
