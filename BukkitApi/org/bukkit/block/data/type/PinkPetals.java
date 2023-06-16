package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;

/**
 * “flower_amount” 表示花瓣的数量。
 */
public interface PinkPetals extends Directional {

    /**
     * 获取“flower_amount”属性的值。
     * <p>
     * 原文：
     * Gets the value of the 'flower_amount' property.
     *
     * @return “flower_amount”属性的值
     */
    int getFlowerAmount();

    /**
     * 设置“flower_amount”属性的值。
     * <p>
     * 原文：
     * Sets the value of the 'flower_amount' property.
     *
     * @param flower_amount “flower_amount”属性的新值
     */
    void setFlowerAmount(int flower_amount);

    /**
     * 获取“flower_amount”属性允许的最大值。
     * <p>
     * 原文：
     * Gets the maximum allowed value of the 'flower_amount' property.
     *
     * @return “flower_amount”属性允许的最大值
     */
    int getMaximumFlowerAmount();
}
