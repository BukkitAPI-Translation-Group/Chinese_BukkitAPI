package org.bukkit.block.data.type;

import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 此类包含 'north'、'east'、'south'、'west' 高度标志，
 * 用于设置面的高度.
 *
 * 'bottom' 表示这是否是底部方块.
 */
@ApiStatus.Experimental
public interface MossyCarpet extends BlockData {

    /**
     * 获取 'bottom' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'bottom' property.
     *
     * @return 'bottom' 的值
     */
    boolean isBottom();

    /**
     * 设置 'bottom' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'bottom' property.
     *
     * @param bottom 新的 'bottom' 值
     */
    void setBottom(boolean bottom);

    /**
     * 获取指定面的高度.
     * <p>
     * 原文：
     * Gets the height of the specified face.
     *
     * @param face 要检查的面
     * @return 面是否启用
     */
    @NotNull
    Height getHeight(@NotNull BlockFace face);

    /**
     * 设置指定面的高度.
     * <p>
     * 原文：
     * Set the height of the specified face.
     *
     * @param face 要设置的面
     * @param height 高度
     */
    void setHeight(@NotNull BlockFace face, @NotNull Height height);

    /**
     * 面可能具有的不同高度.
     */
    public enum Height {
        /**
         * 不存在.
         */
        NONE,
        /**
         * 低面存在.
         */
        LOW,
        /**
         * 高面存在.
         */
        TALL;
    }
}
