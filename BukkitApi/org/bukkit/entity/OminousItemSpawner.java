package org.bukkit.entity;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一个不祥物品生成器。
 */
public interface OminousItemSpawner extends Entity {

    /**
     * 获取此生成器将生成的物品。
     * <p>原文：Gets the item which will be spawned by this spawner.
     *
     * @return the item
     */
    @Nullable
    ItemStack getItem();

    /**
     * 设置此生成器将生成的物品。
     * <p>原文：Sets the item which will be spawned by this spawner.
     *
     * @param item the item
     */
    void setItem(@Nullable ItemStack item);

    /**
     * 获取此物品将在多少tick后生成。
     * <p>原文：Gets the ticks after which this item will be spawned.
     *
     * @return total spawn ticks
     */
    long getSpawnItemAfterTicks();

    /**
     * 设置此物品将在多少tick后生成。
     * <p>原文：Sets the ticks after which this item will be spawned.
     *
     * @param ticks total spawn ticks
     */
    void setSpawnItemAfterTicks(long ticks);
}
