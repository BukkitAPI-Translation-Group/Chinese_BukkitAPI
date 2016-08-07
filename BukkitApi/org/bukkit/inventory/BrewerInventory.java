package org.bukkit.inventory;

import org.bukkit.Material;
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

    /**
     * 获取当前用来酿造的燃料.
     * <p>
     * 原文:Get the current fuel for brewing.
     *
     * @return 燃料
     */
    ItemStack getFuel();

    /**
     * 设置当前用来酿造的燃料.一般只有{@link Material#BLAZE_POWDER}将使用此方法.
     * <p>
     * 原文:Set the current fuel for brewing. Generally only
     * {@link Material#BLAZE_POWDER} will be of use.
     *
     * @param fuel 燃料
     */
    void setFuel(ItemStack fuel);

    BrewingStand getHolder();
}