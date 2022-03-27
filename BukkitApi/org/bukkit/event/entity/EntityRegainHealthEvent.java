package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当实体恢复生命值时触发本事件.
 */
public class EntityRegainHealthEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private double amount;
    private final RegainReason regainReason;

    public EntityRegainHealthEvent(@NotNull final Entity entity, final double amount, @NotNull final RegainReason regainReason) {
        super(entity);
        this.amount = amount;
        this.regainReason = regainReason;
    }

    /**
     * 获取实体本次恢复的生命值.
     * <p>
     * 原文:
     * Gets the amount of regained health
     *
     * @return 恢复的生命值
     */
    public double getAmount() {
        return amount;
    }

    /**
     * 设置实体恢复的生命值.
     * <p>
     * 原文:
     * Sets the amount of regained health
     *
     * @param amount 实体将恢复的生命值
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    /**
     * 获取实体恢复生命值的原因.
     * <p>
     * 原文:
     * Gets the reason for why the entity is regaining health
     *
     * @return 详细说明生命值恢复原因的 RegainReason 枚举
     */
    @NotNull
    public RegainReason getRegainReason() {
        return regainReason;
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

    /**
     * 详细说明实体生命值恢复原因的枚举.
     */
    public enum RegainReason {

        /**
         * 玩家因和平模式 (difficulty=0) 带来的再生效果恢复生命值.
         */
        REGEN,
        /**
         * 玩家因饥饿度已满, 自然恢复生命值.
         */
        SATIATED,
        /**
         * 玩家通过食用食物恢复生命值.
         */
        EATING,
        /**
         * 末影龙通过末影水晶恢复生命值.
         */
        ENDER_CRYSTAL,
        /**
         * 玩家被药水或魔法治愈.
         */
        MAGIC,
        /**
         * 玩家被药水或魔法随时间持续治疗.
         */
        MAGIC_REGEN,
        /**
         * 凋零生成时填补其生命值.
         */
        WITHER_SPAWN,
        /**
         * 实体因凋零效果受到伤害.
         */
        WITHER,
        /**
         * 上述原因未能涵盖的任何其它原因.
         */
        CUSTOM
    }
}
