package org.bukkit.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表凋零boss.
 */
public interface Wither extends Monster, Boss {

    /**
     * {@inheritDoc}
     * <p>
     * 此方法将设置凋零的 {@link Head#CENTER 中心头颅} 的目标.
     * <p>
     * 原文：This method will set the target of the {@link Head#CENTER center head} of the wither.
     *
     * @see #setTarget(org.bukkit.entity.Wither.Head, org.bukkit.entity.LivingEntity)
     */
    @Override
    void setTarget(@Nullable LivingEntity target);

    /**
     * 此方法将设置凋零的单个头颅 {@link Head} 的目标.
     * <p>
     * 原文：This method will set the target of individual heads {@link Head} of the wither.
     *
     * @param head 单个头颅
     * @param target 应被作为目标的实体
     */
    void setTarget(@NotNull Head head, @Nullable LivingEntity target);

    /**
     * 此方法将获取凋零的单个头颅 {@link Head} 的目标.
     * <p>
     * 原文：This method will get the target of individual heads {@link Head} of the wither.
     *
     * @param head 单个头颅
     * @return 被指定头颅作为目标的实体，如果没有目标则返回 null
     */
    @Nullable
    LivingEntity getTarget(@NotNull Head head);

    /**
     * 返回凋零当前的无敌刻.
     * <p>
     * 原文：Returns the wither's current invulnerability ticks.
     *
     * @return 无敌刻的数量
     */
    int getInvulnerabilityTicks();

    /**
     * 设置凋零当前的无敌刻.
     * <p>
     * 当无敌刻降为 0 时，凋零将触发一次爆炸.
     * <p>
     * 原文：Sets the wither's current invulnerability ticks. When invulnerability ticks reach 0, the wither will trigger an explosion.
     *
     * @param ticks 无敌刻的数量
     */
    void setInvulnerabilityTicks(int ticks);

    /**
     * 代表凋零的一个头颅.
     */
    enum Head {

        CENTER,
        LEFT,
        RIGHT
    }
}