package org.bukkit.event.entity;

import com.google.common.base.Preconditions;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当箭矢射进实体或从实体上拔出(脱落)时触发本事件.
 */
public class ArrowBodyCountChangeEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    //
    private boolean cancelled;
    private final boolean isReset;
    private final int oldAmount;
    private int newAmount;

    public ArrowBodyCountChangeEvent(@NotNull LivingEntity entity, int oldAmount, int newAmount, boolean isReset) {
        super(entity);

        this.oldAmount = oldAmount;
        this.newAmount = newAmount;
        this.isReset = isReset;
    }

    // TODO:reset代表的含义
    /**
     * 返回本事件是否因为实体被重置而触发.
     * <p>
     * 原文:Whether the event was called because the entity was reset.
     *
     * @return 实体是否被重置
     */
    public boolean isReset() {
        return isReset;
    }

    /**
     * 获取事件发生前实体身上有多少支箭.
     * <p>
     * 原文:Gets the old amount of arrows in the entity's body.
     *
     * @return 实体身上曾有多少支箭
     */
    public int getOldAmount() {
        return oldAmount;
    }

    /**
     * 获取在此事件后实体身上有多少支箭.
     * <p>
     * 原文:Get the new amount of arrows in the entity's body.
     *
     * @return 实体身上将有多少支箭
     */
    public int getNewAmount() {
        return newAmount;
    }

    /**
     * 设置此事件后实体身上最终的箭矢数量.
     * <p>
     * 原文:Sets the final amount of arrows in the entity's body.
     *
     * @param newAmount 实体身上将有多少支箭
     */
    public void setNewAmount(int newAmount) {
        Preconditions.checkArgument(newAmount >= 0, "New arrow amount must be >= 0");
        this.newAmount = newAmount;
    }

    @Override
    @NotNull
    public LivingEntity getEntity() {
        return (LivingEntity) entity;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    @NotNull
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
