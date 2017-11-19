package org.bukkit.inventory;

import org.bukkit.block.Furnace;

/**
 * 熔炉用户界面接口
 */
public interface FurnaceInventory extends Inventory {

    /**
     * 获取当前熔炉生成的的物品.
     * <p>
     * 原文:Get the current item in the result slot.
     *
     * @return ItemStack
     */
    ItemStack getResult();

    /**
     * 获取当前熔炉的燃料物品.
     *
     * @return ItemStack
     */
    ItemStack getFuel();

    /**
     * 获取当前熔炉的被冶炼的物品.
     * <p>
     * 原文:Get the item currently smelting.
     *
     * @return 物品
     */
    ItemStack getSmelting();

    /**
     * 设置当前熔炉的燃料物品.
     * <p>
     * 原文:Set the current fuel.
     *
     * @param stack 燃料物品
     */
    void setFuel(ItemStack stack);

    /**
     * 设置当前熔炉的生成物.
     * <p>
     * 原文:Set the current item in the result slot.
     *
     * @param stack 生成物
     */
    void setResult(ItemStack stack);

    /**
     * 设置当前熔炉的被冶炼物物品.
     * <p>
     * 原文:Set the item currently smelting.
     *
     * @param stack 物品
     */
    void setSmelting(ItemStack stack);

    Furnace getHolder();
}
