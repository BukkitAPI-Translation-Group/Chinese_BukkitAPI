package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Explosive;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当实体决定爆炸时调用。
 */
public class ExplosionPrimeEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;
    private float radius;
    private boolean fire;

    public ExplosionPrimeEvent(@NotNull final Entity what, final float radius, final boolean fire) {
        super(what);
        this.cancel = false;
        this.radius = radius;
        this.fire = fire;
    }

    public ExplosionPrimeEvent(@NotNull final Explosive explosive) {
        this(explosive, explosive.getYield(), explosive.isIncendiary());
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 获取爆炸半径。
     * <p>
     * 原文：
     * Gets the radius of the explosion
     *
     * @return 返回爆炸半径
     */
    public float getRadius() {
        return radius;
    }

    /**
     * 设置爆炸半径。
     * <p>
     * 原文：
     * Sets the radius of the explosion
     *
     * @param radius 爆炸半径
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }

    /**
     * 获取此爆炸是否会创造火。
     * <p>
     * 原文：
     * Gets whether this explosion will create fire or not
     *
     * @return 如果此爆炸会创造火则返回 true
     */
    public boolean getFire() {
        return fire;
    }

    /**
     * 设置此爆炸是否会创造火。
     * <p>
     * 原文：
     * Sets whether this explosion will create fire or not
     *
     * @param fire 如果你希望此爆炸创造火则设置为 true
     */
    public void setFire(boolean fire) {
        this.fire = fire;
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
