package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当实体的氧气值发生变化时触发本事件
 */
public class EntityAirChangeEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    //
    private int amount;
    //
    private boolean cancelled;

    public EntityAirChangeEvent(Entity what, int amount) {
        super(what);
        this.amount = amount;
    }

    /**
     * 获取实体剩余的氧气值 (单位为刻)
     * <p>
     * 原文:Gets the amount of air the entity has left (measured in ticks).
     *
     * @return 实体剩余的氧气值
     */
    public int getAmount() {
        return amount;
    }

    /**
     * 设置实体剩余的氧气值 (单位为刻)
     * <p>
     * 原文:Sets the amount of air remaining for the entity (measured in ticks.
     *
     * @param amount 实体剩余的氧气值
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}