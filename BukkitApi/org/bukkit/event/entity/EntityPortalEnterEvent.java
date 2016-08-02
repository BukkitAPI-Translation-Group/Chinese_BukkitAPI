package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.Location;
import org.bukkit.event.HandlerList;

/**
 * 当一个实体与传送门接触时触发本事件.
 */
public class EntityPortalEnterEvent extends EntityEvent {
    private static final HandlerList handlers = new HandlerList();
    private final Location location;

    public EntityPortalEnterEvent(final Entity entity, final Location location) {
        super(entity);
        this.location = location;
    }

    /**
     * 获取实体接触的传送门方块.
     * <p>
     * 原文:Gets the portal block the entity is touching
     *
     * @return 实体接触的传送门方块
     */
    public Location getLocation() {
        return location;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}