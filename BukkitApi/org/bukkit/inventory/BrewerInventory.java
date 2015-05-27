package org.bukkit.inventory;

import org.bukkit.block.BrewingStand;

/**
 * 酿造台的用户界面接口.
 */
public interface BrewerInventory extends Inventory {

    /**
     * 获取当前酿造台的原料.
     * <p>
     * 原文:Get the current ingredient for brewing.
     *
     * @return 原料成分.
     */
    ItemStack getIngredient();

    /**
     * 设置当前酿造台的原料成分.
     * <p>
     * 原文:Set the current ingredient for brewing.
     *
     * @param ingredient 原料成分
     */
    void setIngredient(ItemStack ingredient);

    BrewingStand getHolder();
}