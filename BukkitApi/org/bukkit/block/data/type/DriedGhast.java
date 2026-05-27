package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Waterlogged;

/**
 * 'hydration' 表示方块的水合程度.
 */
public interface DriedGhast extends Directional, Waterlogged {

    /**
     * 获取 'hydration' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'hydration' property.
     *
     * @return 'hydration' 的值
     */
    int getHydration();

    /**
     * 设置 'hydration' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'hydration' property.
     *
     * @param hydration 新的 'hydration' 值
     */
    void setHydration(int hydration);

    /**
     * 获取 'hydration' 属性允许的最大值.
     * <p>
     * 原文：
     * Gets the maximum allowed value of the 'hydration' property.
     *
     * @return 'hydration' 的最大值
     */
    int getMaximumHydration();
}
