package org.bukkit.block.data.type;

import org.bukkit.block.data.BlockData;

/**
 * 'hatch' 值为这些海龟蛋中孵化出海龟的数量.
 * <br>
 * 'eggs' 值为该方块中出现的海龟蛋的数量.
 */
public interface TurtleEgg extends BlockData {

    /**
     * 获取 'eggs' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'eggs' property.
     *
     * @return 属性 'eggs' 的值
     */
    int getEggs();

    /**
     * 设置 'eggs' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'eggs' property.
     *
     * @param eggs 新的 'eggs' 属性值
     */
    void setEggs(int eggs);

    /**
     * 获取 'eggs' 属性所能允许的最小值.
     * <p>
     * 原文:
     * Gets the minimum allowed value of the 'eggs' property.
     *
     * @return 最小 'eggs' 属性值
     */
    int getMinimumEggs();

    /**
     * 获取 'eggs' 属性所能允许的最大值.
     * <p>
     * 原文:
     * Gets the maximum allowed value of the 'eggs' property.
     *
     * @return 最大 'eggs' 属性值
     */
    int getMaximumEggs();

    /**
     * 获取 'hatch' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'hatch' property.
     *
     * @return 属性 'hatch' 的值
     */
    int getHatch();

    /**
     * 设置 'hatch' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'hatch' property.
     *
     * @param hatch 新的 'hatch' 属性值
     */
    void setHatch(int hatch);

    /**
     * 获取 'hatch' 属性所能允许的最大值.
     * <p>
     * 原文:
     * Gets the maximum allowed value of the 'hatch' property.
     *
     * @return 最大 'hatch' 属性值.
     */
    int getMaximumHatch();
}
