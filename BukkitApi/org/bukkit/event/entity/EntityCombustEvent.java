package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当实体燃烧时触发该事件
 * <p>
 * 如果这个事件被取消,那么这个实体将不会燃烧.
 */
public class EntityCombustEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private int duration;
    private boolean cancel;

    public EntityCombustEvent(final Entity combustee, final int duration) {
        super(combustee);
        this.duration = duration;
        this.cancel = false;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * @return 应被燃烧的时间长度(秒)
     */
    public int getDuration() {
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
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
