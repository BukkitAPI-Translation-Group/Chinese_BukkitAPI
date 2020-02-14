package org.bukkit.event.entity;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当一个实体与传送门接触时触发本事件.
 */
public class EntityPortalEnterEvent extends EntityEvent {
    private static final HandlerList handlers = new HandlerList();
    private final Location location;

    public EntityPortalEnterEvent(@NotNull final Entity entity, @NotNull final Location location) {
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
    @NotNull
    public Location getLocation() {
        return location;
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