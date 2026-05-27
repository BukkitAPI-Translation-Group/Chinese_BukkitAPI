package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.PigZombie;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当猪灵被另一个实体激怒时调用。
 * <p>
 * 如果事件被取消，猪灵将不会被激怒。
 */
public class PigZombieAngerEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean canceled;
    private final Entity target;
    private int newAnger;

    public PigZombieAngerEvent(@NotNull final PigZombie pigZombie, @Nullable final Entity target, final int newAnger) {
        super(pigZombie);
        this.target = target;
        this.newAnger = newAnger;
    }

    /**
     * 获取触发此愤怒更新的实体（如果有）。
     * <p>
     * 原文：
     * Gets the entity (if any) which triggered this anger update.
     *
     * @return 触发实体，或 null
     */
    @Nullable
    public Entity getTarget() {
        return target;
    }

    /**
     * 获取此事件产生的新愤怒值。
     * <p>
     * 原文：
     * Gets the new anger resulting from this event.
     *
     * @return 新愤怒值
     * @see PigZombie#getAnger()
     */
    public int getNewAnger() {
        return newAnger;
    }

    /**
     * 设置此事件产生的新愤怒值。
     * <p>
     * 原文：
     * Sets the new anger resulting from this event.
     *
     * @param newAnger 新愤怒值
     * @see PigZombie#setAnger(int)
     */
    public void setNewAnger(int newAnger) {
        this.newAnger = newAnger;
    }

    @NotNull
    @Override
    public PigZombie getEntity() {
        return (PigZombie) entity;
    }

    @Override
    public boolean isCancelled() {
        return canceled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        canceled = cancel;
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
