package org.bukkit.block;

import org.bukkit.inventory.FurnaceInventory;

/**
 * 代表一个熔炉.
 */
public interface Furnace extends BlockState, ContainerBlock {

    /**
     * 获取燃烧时间.
     * <p>
     * 原文:
     * Get burn time.
     *
     * @return 燃烧时间
     */
    public short getBurnTime();

    /**
     * 设置燃烧时间.
     * <p>
     * 原文:
     * Set burn time.
     *
     * @param burnTime 燃烧时间
     */
    public void setBurnTime(short burnTime);

    /**
     * 获取烹饪时间.
     * <p>
     * 原文:
     * Get cook time.
     *
     * @return 烹饪时间
     */
    public short getCookTime();

    /**
     * 设置烹饪时间.
     * <p>
     * 原文:
     * Set cook time.
     *
     * @param cookTime 烹饪时间
     */
    public void setCookTime(short cookTime);

    public FurnaceInventory getInventory();
}