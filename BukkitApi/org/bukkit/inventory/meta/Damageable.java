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
     * 检查此物品是否有最大耐久度设置.
     * <p>
     * 原文:
     * Checks to see if this item has a maximum amount of damage.
     *
     * @return 如果设置了最大耐久度则返回 true
     */
    boolean hasMaxDamage();

    /**
     * 获取最大耐久度.
     * <p>
     * 插件在调用此方法前应检查 {@link #hasMaxDamage()} 是否返回 true.
     * <p>
     * 原文:
     * Gets the maximum amount of damage.
     * <p>
     * Plugins should check {@link #hasMaxDamage()} before calling this method.
     *
     * @return 最大耐久度
     */
    int getMaxDamage();

    /**
     * 设置最大耐久度.
     * <p>
     * 原文:
     * Sets the maximum amount of damage.
     *
     * @param maxDamage 最大耐久度
     */
    void setMaxDamage(@Nullable Integer maxDamage);

    @NotNull
    @Override
    Damageable clone();
}
