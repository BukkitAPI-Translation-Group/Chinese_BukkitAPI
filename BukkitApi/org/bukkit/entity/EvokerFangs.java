package org.bukkit.entity;

import org.jetbrains.annotations.Nullable;

/**
 * 代表唤魔者召唤的尖牙.
 */
public interface EvokerFangs extends Entity {

    /**
     * 获取召唤此尖牙的{@link LivingEntity 生物}.
     * <p>
     * 原文:Gets the {@link LivingEntity} which summoned the fangs.
     *
     * @return 召唤此尖牙的{@link LivingEntity 生物}
     */
    @Nullable
    LivingEntity getOwner();

    /**
     * 设置召唤此尖牙的{@link LivingEntity 生物}.
     * <p>
     * 原文:Sets the {@link LivingEntity} which summoned the fangs.
     *
     * @param owner 召唤此尖牙的{@link LivingEntity 生物}
     */
    void setOwner(@Nullable LivingEntity owner);

    /**
     * 获取尖牙攻击前的延迟 (tick).
     * <p>
     * 原文：
     * Get the delay in ticks until the fang attacks.
     *
     * @return 延迟时间
     */
    int getAttackDelay();

    /**
     * 设置尖牙攻击前的延迟 (tick).
     * <p>
     * 原文：
     * Set the delay in ticks until the fang attacks.
     *
     * @param delay 延迟时间, 必须为正数
     */
    void setAttackDelay(int delay);
}
