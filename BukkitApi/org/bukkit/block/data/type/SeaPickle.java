package org.bukkit.block.data.type;

import org.bukkit.block.data.Waterlogged;

/**
 * 'pickles' 值表示该方块哪有多少个海泡菜.
 */
public interface SeaPickle extends Waterlogged {

    /**
     * 获取 'pickles' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'pickles' property.
     *
     * @return 属性 'pickles' 的值
     */
    int getPickles();

    /**
     * 设置 'pickles' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'pickles' property.
     *
     * @param pickles 新的 'pickles' 属性值
     */
    void setPickles(int pickles);

    /**
     * 获取 'pickles' 属性所允许的最小值.
     * <p>
     * 原文:
     * Gets the minimum allowed value of the 'pickles' property.
     *
     * @return 最小 'pickles' 属性值
     */
    int getMinimumPickles();

    /**
     * 获取 'pickles' 属性所允许的最大值.
     * <p>
     * 原文:
     * Gets the maximum allowed value of the 'pickles' property.
     *
     * @return 最大 'pickles' 属性值
     */
    int getMaximumPickles();
}
