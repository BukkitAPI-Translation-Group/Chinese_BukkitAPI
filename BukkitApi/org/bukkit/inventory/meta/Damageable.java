package org.bukkit.inventory.meta;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表有耐久度、可损耗的物品.
 */
public interface Damageable extends ItemMeta {

    /**
     * 检测此物品是否有耐久度.
     * <p>
     * 原文:
     * Checks to see if this item has damage
     *
     * @return 此物品是否有耐久度
     */
    boolean hasDamage();

    /**
     * 获取物品的耐久度.
     * <p>
     * 原文:
     * Gets the damage
     *
     * @return 耐久度
     */
    int getDamage();

    /**
     * 设置物品的耐久度.
     * <p>
     * 原文:
     * Sets the damage
     *
     * @param damage 物品耐久度
     */
    void setDamage(int damage);

    /**
     * Checks to see if this item has a maximum amount of damage.
     *
     * @return true if this has maximum amount of damage
     */
    boolean hasMaxDamage();

    /**
     * Gets the maximum amount of damage.
     *
     * Plugins should check {@link #hasMaxDamage()} before calling this method.
     *
     * @return the maximum amount of damage
     */
    int getMaxDamage();

    /**
     * Sets the maximum amount of damage.
     *
     * @param maxDamage maximum amount of damage
     */
    void setMaxDamage(@Nullable Integer maxDamage);

    @NotNull
    @Override
    Damageable clone();
}
