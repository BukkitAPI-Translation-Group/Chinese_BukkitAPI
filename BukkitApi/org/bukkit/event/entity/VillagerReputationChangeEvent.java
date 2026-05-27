package org.bukkit.event.entity;

import com.google.common.base.Preconditions;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Villager;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当实体与村民的声望发生变化时调用。
 */
public class VillagerReputationChangeEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID targetUUID;
    private final Villager.ReputationEvent reason;
    private final Villager.ReputationType reputationType;
    private final int oldValue;
    private int newValue;
    private final int maxValue;

    public VillagerReputationChangeEvent(@NotNull Villager villager, @NotNull UUID targetUUID, @NotNull Villager.ReputationEvent reason, @NotNull Villager.ReputationType reputationType, int oldValue, int newValue, int maxValue) {
        super(villager);
        this.targetUUID = targetUUID;
        this.reason = reason;
        this.reputationType = reputationType;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.maxValue = maxValue;
    }

    /**
     * 获取与村民声望发生变化的实体的 UUID。
     * <p>
     * 原文：
     * Get UUID of the entity for whom the reputation with a villager changes.
     *
     * @return 与村民声望发生变化的实体的 UUID
     */
    @NotNull
    public UUID getTargetUUID() {
        return targetUUID;
    }

    /**
     * 获取与村民声望发生变化的实体。
     * <p>
     * 原文：
     * Get the Entity for whom the reputation with a villager changes.
     *
     * @return 与村民声望发生变化的实体，如果未找到则返回 {@code null}
     */
    @Nullable
    public Entity getTarget() {
        return Bukkit.getEntity(targetUUID);
    }

    /**
     * 获取此声望变化的原因。
     * <p>
     * 原文：
     * Get the reason of this reputation change.
     *
     * @return 此声望变化的原因
     */
    @NotNull
    public Villager.ReputationEvent getReason() {
        return reason;
    }

    /**
     * 获取变化的声望类型。
     * <p>
     * 原文：
     * Get the type of changed reputation.
     *
     * @return 变化的声望类型
     */
    @NotNull
    public Villager.ReputationType getReputationType() {
        return reputationType;
    }

    /**
     * 获取变化前的声望值。
     * <p>
     * 原文：
     * Get the reputation value before the change.
     *
     * @return 变化前的声望值
     */
    public int getOldValue() {
        return oldValue;
    }

    /**
     * 获取变化后的新声望值。
     * <p>
     * 原文：
     * Get new reputation value after the change.
     *
     * @return 变化后的声望值
     */
    public int getNewValue() {
        return newValue;
    }

    /**
     * 设置此事件的新声望值。
     * <p>
     * 如果最终值低于声望丢弃阈值，与此声望类型相关的闲话将被移除。
     * <p>
     * 提供的值必须介于 0 和 {@link VillagerReputationChangeEvent#getMaxValue()} 之间，否则将抛出 {@link IllegalArgumentException}。每种声望类型可能有不同的最大值。
     * <p>
     * 原文：
     * Set new reputation value for this event.
     *
     * <p>If the final value is below the reputation discard threshold, gossip
     * associated with this reputation type will be removed.
     *
     * <p>The provided value must be between 0 and
     * {@link VillagerReputationChangeEvent#getMaxValue()}, otherwise an
     * {@link IllegalArgumentException} will be thrown. Each reputation type
     * may have a different maximum value.
     *
     * @param newValue 变化后的声望值
     * @see Villager.ReputationType#getMaxValue()
     */
    public void setNewValue(int newValue) {
        Preconditions.checkArgument(0 <= newValue && newValue <= maxValue, "new value (%s) must be between [0, %s]", newValue, maxValue);
        this.newValue = newValue;
    }

    /**
     * 获取此事件受影响的声望类型的最大值。
     * <p>
     * 原文：
     * Get maximum value for the reputation type affected by this event.
     *
     * @return 此事件受影响的声望类型的最大值
     * @see Villager.ReputationType#getMaxValue()
     */
    public int getMaxValue() {
        return maxValue;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    @NotNull
    @Override
    public Villager getEntity() {
        return (Villager) super.getEntity();
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
