package org.bukkit.event.entity;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当人类实体经历饥饿时调用。
 *
 * 饥饿等级大于 4.0 会导致饱和度降低 1。
 */
public class EntityExhaustionEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final ExhaustionReason exhaustionReason;
    private float exhaustion;
    private boolean cancel;

    public EntityExhaustionEvent(@NotNull HumanEntity who, @NotNull ExhaustionReason exhaustionReason, float exhaustion) {
        super(who);
        this.exhaustionReason = exhaustionReason;
        this.exhaustion = exhaustion;
    }

    /**
     * 获取此事件的 {@link ExhaustionReason}。
     * <p>
     * 原文：
     * Gets the {@link ExhaustionReason} for this event
     *
     * @return 饥饿原因
     */
    @NotNull
    public ExhaustionReason getExhaustionReason() {
        return exhaustionReason;
    }

    /**
     * 获取要添加到玩家当前饥饿值的饥饿量。
     * <p>
     * 原文：
     * Get the amount of exhaustion to add to the player's current exhaustion.
     *
     * @return 饥饿量
     */
    public float getExhaustion() {
        return exhaustion;
    }

    /**
     * 设置要应用于玩家的饥饿值。
     * <p>
     * 玩家最大饥饿值为 40。达到此限制时不会抛出错误。此值可以为负数，但当饥饿值低于 0 时行为未知。
     * <p>
     * 原文：
     * Set the exhaustion to apply to the player.
     *
     * The maximum exhaustion that a player can have is 40. No error will be
     * thrown if this limit is hit. This value may be negative, but there is
     * unknown behavior for when exhaustion is below 0.
     *
     * @param exhaustion 要添加的新饥饿值
     */
    public void setExhaustion(float exhaustion) {
        this.exhaustion = exhaustion;
    }

    @NotNull
    @Override
    public HumanEntity getEntity() {
        return (HumanEntity) super.getEntity();
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
     * 玩家饥饿事件发生的原因。
     */
    public enum ExhaustionReason {

        /**
         * 玩家挖掘方块。
         */
        BLOCK_MINED,
        /**
         * 玩家拥有饥饿药水效果。
         */
        HUNGER_EFFECT,
        /**
         * 玩家受到伤害。
         */
        DAMAGED,
        /**
         * 玩家攻击其他实体。
         */
        ATTACK,
        /**
         * 玩家冲刺跳跃。
         */
        JUMP_SPRINT,
        /**
         * 玩家跳跃。
         */
        JUMP,
        /**
         * 玩家游泳一厘米。
         */
        SWIM,
        /**
         * 玩家在水下行走一厘米。
         */
        WALK_UNDERWATER,
        /**
         * 玩家在水面移动一厘米。
         */
        WALK_ON_WATER,
        /**
         * 玩家冲刺一厘米。
         */
        SPRINT,
        /**
         * 玩家潜行一厘米（不影响饥饿值，但仍会触发事件）。
         */
        CROUCH,
        /**
         * 玩家行走一厘米（不影响饥饿值，但仍会触发事件）。
         */
        WALK,
        /**
         * 玩家恢复生命值。
         */
        REGEN,
        /**
         * 未知饥饿原因。
         */
        UNKNOWN
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
