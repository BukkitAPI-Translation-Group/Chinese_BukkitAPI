package org.bukkit.block.data.type;

import java.util.Set;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Waterlogged;
import org.jetbrains.annotations.NotNull;

/**
 * 'thickness' 表示滴水石锥的粗细程度.
 * <br>
 * 'vertical_direction' 表示滴水石锥的朝向.
 * <br>
 * 某些方块可能无法朝向所有方向，使用 {@link #getVerticalDirections()} 获取此方块所有可能的方向.
 */
public interface PointedDripstone extends Waterlogged {

    /**
     * 获取 'vertical_direction' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'vertical_direction' property.
     *
     * @return 'vertical_direction' 的值
     */
    @NotNull
    BlockFace getVerticalDirection();

    /**
     * 设置 'vertical_direction' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'vertical_direction' property.
     *
     * @param direction 新的 'vertical_direction' 值
     */
    void setVerticalDirection(@NotNull BlockFace direction);

    /**
     * 获取此方块适用的面.
     * <p>
     * 原文：
     * Gets the faces which are applicable to this block.
     *
     * @return 允许的 'vertical_direction' 值
     */
    @NotNull
    Set<BlockFace> getVerticalDirections();

    /**
     * 获取 'thickness' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'thickness' property.
     *
     * @return 'thickness' 的值
     */
    @NotNull
    Thickness getThickness();

    /**
     * 设置 'thickness' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'thickness' property.
     *
     * @param thickness 新的 'thickness' 值
     */
    void setThickness(@NotNull Thickness thickness);

    /**
     * 滴水石锥的粗细程度，对应于其在多块滴水石锥结构中的位置.
     */
    public enum Thickness {
        /**
         * 延伸的尖端.
         */
        TIP_MERGE,
        /**
         * 仅尖端.
         */
        TIP,
        /**
         * 顶部部分.
         */
        FRUSTUM,
        /**
         * 中间部分.
         */
        MIDDLE,
        /**
         * 底部.
         */
        BASE;
    }
}
