package org.bukkit.inventory.meta;

import org.jetbrains.annotations.NotNull;

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

    @NotNull
    @Override
    Damageable clone();
}
