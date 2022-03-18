package org.bukkit.block;

import org.bukkit.inventory.FurnaceInventory;
import org.jetbrains.annotations.NotNull;

/**
 * 代表熔炉.
 * <p>
 * 译注:本页出现的时间均以tick为单位, tick(刻)是服务器内部表示时间的方式, 理想状态下1 tick为50ms.
 */
public interface Furnace extends Container {

    /**
     * 获取燃烧持续时间.
     * <p>
     * 原文:
     * Get burn time.
     *
     * @return 燃烧持续时间
     */
    public short getBurnTime();

    /**
     * 设置燃烧持续时间.
     * 大于0的燃烧持续时间将使熔炉燃烧, 同时小于0的时间将熄灭它.
     * <p>
     * 原文:
     * Set burn time.
     *
     * A burn time greater than 0 will cause this block to be lit, whilst a time
     * less than 0 will extinguish it.
     *
     * @param burnTime 燃烧持续时间
     */
    public void setBurnTime(short burnTime);

    /**
     * 获取物品已烧炼时间.
     * <p>
     * 原文:
     * Get cook time.
     *
     * This is the amount of time the item has been cooking for.
     *
     * @return 物品已烧炼时间
     */
    public short getCookTime();

    /**
     * 设置物品已烧炼时间.
     * <p>
     * 原文:
     * Set cook time.
     *
     * This is the amount of time the item has been cooking for.
     *
     * @param cookTime 物品已烧炼时间
     */
    public void setCookTime(short cookTime);

    /**
     * 获取烧炼总时间.
     * 本时间表示烧炼物品所需的时间.
     * <p>
     * 原文:Get cook time total.
     *
     * This is the amount of time the item is required to cook for.
     *
     * @return 烧炼总时间
     */
    public int getCookTimeTotal();

    /**
     * 设置烧炼总时间.
     * 本时间表示烧炼物品所需的时间.
     * <p>
     * 原文:Set cook time.
     *
     * This is the amount of time the item is required to cook for.
     *
     * @param cookTimeTotal 烧炼总时间
     */
    public void setCookTimeTotal(int cookTimeTotal);

    @NotNull
    @Override
    public FurnaceInventory getInventory();

    @NotNull
    @Override
    public FurnaceInventory getSnapshotInventory();
}