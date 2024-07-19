package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当实体燃烧时触发该事件
 * <p>
 * 如果这个事件被取消,那么这个实体将不会燃烧.
 */
public class EntityCombustEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private float duration;
    private boolean cancel;

    @Deprecated
    public EntityCombustEvent(@NotNull final Entity combustee, final int duration) {
        this(combustee, (float) duration);
    }

    public EntityCombustEvent(@NotNull final Entity combustee, final float duration) {
        super(combustee);
        this.duration = duration;
        this.cancel = false;
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
     * @return 应被燃烧的时间长度(秒)
     */
    public float getDuration() {
        return duration;
    }

    /**
     * 应被燃烧的时间(秒).
     * <p>
     * 这个数值仅会延长燃烧的时间,不会减少现有的燃烧时间.
     * <p>
     * 原文:The number of seconds the combustee should be alight for.
     * <p>
     * This value will only ever increase the combustion time, not decrease
     * existing combustion times.
     * 
     * @param duration 燃烧的持续时间(秒).
     */
    public void setDuration(float duration) {
        this.duration = duration;
    }

    /**
     * 应被燃烧的时间(秒).
     * <p>
     * 这个数值仅会延长燃烧的时间,不会减少现有的燃烧时间.
     * <p>
     * 原文:The number of seconds the combustee should be alight for.
     * <p>
     * This value will only ever increase the combustion time, not decrease
     * existing combustion times.
     * 
     * @param duration 燃烧的持续时间(秒).
     * @see #setDuration(float)
     * @deprecated duration 现在为浮点数
     */
    @Deprecated(forRemoval = true)
    public void setDuration(int duration) {
        this.duration = duration;
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
