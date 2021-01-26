package org.bukkit.block.data.type;

import org.bukkit.block.data.Waterlogged;

/**
 * 'bottom' 值表示脚手架是否浮空.
 * <br>
 * 'distance' 值表示一个脚手架方块与 'bottom' 脚手架方块的距离.
 * <br>
 * 当 'distance' 值达到 {@link #getMaximumDistance()} 时, 方块就会坠落.
 */
public interface Scaffolding extends Waterlogged {

    /**
     * 获取 'bottom' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'bottom' property.
     *
     * @return 属性 'bottom' 的值
     */
    boolean isBottom();

    /**
     * 设置 'bottom' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'bottom' property.
     *
     * @param bottom 新的 'bottom' 属性值
     */
    void setBottom(boolean bottom);

    /**
     * 获取 'distance' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'distance' property.
     *
     * @return 属性 'distance' 的值
     */
    int getDistance();

    /**
     * 设置 'distance' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'distance' property.
     *
     * @param distance 新的 'distance' 属性值
     */
    void setDistance(int distance);

    /**
     * 获取 'distance' 属性所能允许的最大值.
     * <p>
     * 原文:
     * Gets the maximum allowed value of the 'distance' property.
     *
     * @return 最大 'distance' 属性值
     */
    int getMaximumDistance();
}
