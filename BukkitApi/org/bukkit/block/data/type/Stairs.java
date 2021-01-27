package org.bukkit.block.data.type;

import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Waterlogged;
import org.jetbrains.annotations.NotNull;

/**
 * 'shape' 值代表阶梯方块的材质和碰撞箱的类型.
 */
public interface Stairs extends Bisected, Directional, Waterlogged {

    /**
     * 获取 'shape' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'shape' property.
     *
     * @return 属性 'shape' 的值
     */
    @NotNull
    Shape getShape();

    /**
     * 设置 'shape' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'shape' property.
     *
     * @param shape 新的 'shape' 属性值
     */
    void setShape(@NotNull Shape shape);

    /**
     * 一个阶梯方块可能的的形状 - 用于创建转角的阶梯.
     */
    public enum Shape {
        /**
         * 普通的阶梯方块
         */
        STRAIGHT,
        /**
         * 左侧凸出的内角阶梯
         */
        INNER_LEFT,
        /**
         * 右侧凸出的内角阶梯
         */
        INNER_RIGHT,
        /**
         * 左侧突出的外角阶梯
         */
        OUTER_LEFT,
        /**
         * 右侧凸出的外角阶梯
         */
        OUTER_RIGHT;
    }
}
