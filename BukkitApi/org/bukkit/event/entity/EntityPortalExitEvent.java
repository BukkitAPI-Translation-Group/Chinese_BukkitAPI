package org.bukkit.event.entity;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

/**
 * 在实体退出传送门前触发本事件.
 * <p>
 * 本事件允许你修改实体退出传送门之后的速度.
 */
public class EntityPortalExitEvent extends EntityTeleportEvent {
    private static final HandlerList handlers = new HandlerList();
    private Vector before;
    private Vector after;

    public EntityPortalExitEvent(@NotNull final Entity entity, @NotNull final Location from, @NotNull final Location to, @NotNull final Vector before, @NotNull final Vector after) {
        super(entity, from, to);
        this.before = before;
        this.after = after;
    }

    /**
     * 获取实体进入传送门前的速度的副本.
     * <p>
     * 原文:Gets a copy of the velocity that the entity has before entering the
     * portal.
     *
     * @return 实体进入传送门前的速度的副本
     */
    @NotNull
    public Vector getBefore() {
        return this.before.clone();
    }

    /**
     * 获取实体退出传送门后的速度的副本.
     * <p>
     * 原文:Gets a copy of the velocity that the entity will have after exiting the
     * portal.
     *
     * @return 实体退出传送门后的速度的副本
     */
    @NotNull
    public Vector getAfter() {
        return this.after.clone();
    }

    /**
     * 设置实体退出传送门后的速度.
     * <p>
     * 原文:Sets the velocity that the entity will have after exiting the portal.
     *
     * @param after 实体退出传送门后的速度
     */
    public void setAfter(@NotNull Vector after) {
        this.after = after.clone();
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
