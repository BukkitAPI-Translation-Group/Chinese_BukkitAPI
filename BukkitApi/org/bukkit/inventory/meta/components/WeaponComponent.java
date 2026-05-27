package org.bukkit.inventory.meta.components;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.ApiStatus;

/**
 * 表示一个可以将任何物品转变为武器的组件。
 */
@ApiStatus.Experimental
public interface WeaponComponent extends ConfigurationSerializable {

    /**
     * 获取每次攻击的武器伤害。
     * <p>原文：Get the weapon damage per attack.
     *
     * @return 每次攻击的伤害
     */
    int getItemDamagePerAttack();

    /**
     * 设置每次攻击的武器伤害。
     * <p>原文：Set the weapon damage per attack.
     *
     * @param damage 要设置的伤害值。必须为0或正整数
     */
    void setItemDamagePerAttack(int damage);

    /**
     * 获取此武器禁用格挡的时间（以秒为单位）。
     * <p>原文：Get the time in seconds which this weapon disabled blocking for.
     *
     * @return 禁用格挡的时间（以秒为单位）
     */
    float getDisableBlockingForSeconds();

    /**
     * 设置此武器禁用格挡的时间（以秒为单位）。
     * <p>原文：Set the time in seconds which this weapon disabled blocking for.
     *
     * @param time 禁用格挡的时间（以秒为单位）
     */
    void setDisableBlockingForSeconds(float time);
}
