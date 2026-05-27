package org.bukkit.inventory.meta.components;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.ApiStatus;

/**
 * 表示一个决定物品攻击范围的组件。
 */
@ApiStatus.Experimental
public interface AttackRangeComponent extends ConfigurationSerializable {

    /**
     * 获取目标必须距离攻击者的最小距离。
     * <p>原文：Gets the minimum distance the target must be from the attacker.
     *
     * @return 最小reach距离
     */
    float getMinReach();

    /**
     * 设置目标必须距离攻击者的最小距离。
     * <p>原文：Sets the minimum distance the target must be from the attacker.
     *
     * @param reach 最小reach距离
     */
    void setMinReach(float reach);

    /**
     * 获取目标必须距离攻击者的最大距离。
     * <p>原文：Gets the maximum distance the target must be from the attacker.
     *
     * @return 最大reach距离
     */
    float getMaxReach();

    /**
     * 设置目标必须距离攻击者的最大距离。
     * <p>原文：Sets the maximum distance the target must be from the attacker.
     *
     * @param reach 最大reach距离
     */
    void setMaxReach(float reach);

    /**
     * 获取当攻击者处于创造模式时目标必须距离攻击者的最小距离。
     * <p>原文：Gets the minimum distance the target must be from the attacker when the attacker is in creative mode.
     *
     * @return 最小reach距离
     */
    float getMinCreativeReach();

    /**
     * 设置当攻击者处于创造模式时目标必须距离攻击者的最小距离。
     * <p>原文：Sets the minimum distance the target must be from the attacker when the attacker is in creative mode.
     *
     * @param reach 最小reach距离
     */
    void setMinCreativeReach(float reach);

    /**
     * 获取当攻击者处于创造模式时目标必须距离攻击者的最大距离。
     * <p>原文：Gets the maximum distance the target must be from the attacker when the attacker is in creative mode.
     *
     * @return 最大reach距离
     */
    float getMaxCreativeReach();

    /**
     * 设置当攻击者处于创造模式时目标必须距离攻击者的最大距离。
     * <p>原文：Sets the maximum distance the target must be from the attacker when the attacker is in creative mode.
     *
     * @param reach 最大reach距离
     */
    void setMaxCreativeReach(float reach);

    /**
     * 获取应用于目标碰撞箱的边距。
     * <p>原文：Gets the margin applied to the target hitbox.
     *
     * @return 边距
     */
    float getHitboxMargin();

    /**
     * 设置应用于目标碰撞箱的边距。
     * <p>原文：Sets the margin applied to the target hitbox.
     *
     * @param margin 目标碰撞箱边距
     */
    void setHitboxMargin(float margin);

    /**
     * 获取当物品被生物使用时应用于reach的倍率。
     * <p>原文：Gets the multiplier applied to reach when the item is used by a mob.
     *
     * @return 倍率
     */
    float getMobFactor();

    /**
     * 设置当物品被生物使用时应用于reach的倍率。
     * <p>原文：Sets the multiplier applied to reach when the item is used by a mob.
     *
     * @param factor 生物使用倍率
     */
    void setMobFactor(float factor);
}
