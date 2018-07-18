package org.bukkit.event.entity;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当一个人类实体的饥饿值发生变化时触发本事件
 */
public class FoodLevelChangeEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private int level;

    public FoodLevelChangeEvent(final HumanEntity what, final int level) {
        super(what);
        this.level = level;
    }

    @Override
    public HumanEntity getEntity() {
        return (HumanEntity) entity;
    }

    /**
     * 获取本事件涉及的实体将被设置的饥饿值
     * <p>
     * 20为饱和状态，0为饥饿状态.
     * <p>
     * 原文:
     * Gets the resultant food level that the entity involved in this event
     * should be set to.
     * <p>
     * Where 20 is a full food bar and 0 is an empty one.
     *
     * @return 饥饿值
     */
    public int getFoodLevel() {
        return level;
    }

    /**
     * 设置实体将被设置的饥饿值
     * <p>
     * 原文:
     * Sets the resultant food level that the entity involved in this event
     * should be set to
     *
     * @param level 饥饿值
     */
    public void setFoodLevel(int level) {
        if (level < 0) level = 0;

        this.level = level;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}