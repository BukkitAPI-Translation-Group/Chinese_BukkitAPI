package org.bukkit.inventory;

import org.bukkit.block.Furnace;

/**
 * 熔炉的.用户界面接口
 */
public interface FurnaceInventory extends Inventory {

    /**
     * 获取当前熔炉生成的的Item项目.
     * <p>
     * 原文:Get the current item in the result slot.
     *
     * @return Item项目
     */
    ItemStack getResult();

    /**
     * 获取当前熔炉的燃料Item项目.
     *
     * @return 燃料Item项目
     */
    ItemStack getFuel();

    /**
     * 获取当前熔炉的被冶炼Item项目?
     * <p>
     * 原文:Get the item currently smelting.
     *
     * @return Item项目
     */
    ItemStack getSmelting();

    /**
     * 设置当前熔炉的燃料Item项目.
     * <p>
     * 原文:Set the current fuel.
     *
     * @param stack 燃料Item
     */
    void setFuel(ItemStack stack);

    /**
     * 设置当前熔炉的生成物Item项目.
     * <p>
     * 原文:Set the current item in the result slot.
     *
     * @param stack Item项目
     */
    void setResult(ItemStack stack);

    /**
     * 设置当前熔炉的被冶炼物Item项目?
     * <p>
     * 原文:Set the item currently smelting.
     *
     * @param stack Item项目
     */
    void setSmelting(ItemStack stack);

    Furnace getHolder();
}