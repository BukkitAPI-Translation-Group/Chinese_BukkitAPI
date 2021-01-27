package org.bukkit.block.data.type;

import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Waterlogged;
import org.jetbrains.annotations.NotNull;

/**
 * 该类包含 'north', 'east', 'south', 'west', 的高度标识,
 * 用于设置墙在此朝向的高度.
 *
 * 'up' 值表示墙是否中心凸起 (有一个柱垛).
 */
public interface Wall extends Waterlogged {

    /**
     * 获取 'up' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'up' property.
     *
     * @return 属性 'up' 的值
     */
    boolean isUp();

    /**
     * 设置 'up' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'up' property.
     *
     * @param up 新的 'up' 属性值
     */
    void setUp(boolean up);

    /**
     * 获取墙在指定朝向上的高度.
     * <p>
     * 原文:
     * Gets the height of the specified face.
     *
     * @param face 指定朝向
     * @return 墙在该朝向上的高度
     */
    @NotNull
    Height getHeight(@NotNull BlockFace face);

    /**
     * 设置墙在指定朝向上的高度.
     * <p>
     * 原文:
     * Set the height of the specified face.
     *
     * @param face 指定朝向
     * @param height 要设置的高度
     */
    void setHeight(@NotNull BlockFace face, @NotNull Height height);

    /**
     * 墙在一个朝向上可能存在的不同高度.
     */
    public enum Height {
        /**
         * 没有墙连接
         */
        NONE,
        /**
         * 矮墙连接
         */
        LOW,
        /**
         * 高墙连接
         */
        TALL;
    }
}
