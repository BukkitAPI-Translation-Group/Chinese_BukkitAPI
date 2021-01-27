package org.bukkit.block.data;

import org.jetbrains.annotations.NotNull;

/**
 * 'half' 值表示该方块是一个两格高方块的哪一部分.
 * <br>
 * 在游戏中, (top, bottom) 或 (upper, lower) 两种叫法可能都存在.
 */
public interface Bisected extends BlockData {

    /**
     * 获取 'half' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'half' property.
     *
     * @return 属性 'half' 的值
     */
    @NotNull
    Half getHalf();

    /**
     * 设置 'half' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'half' property.
     *
     * @param half 新的 'half' 属性值
     */
    void setHalf(@NotNull Half half);

    /**
     * 垂直方向上一个方块的二分部分.
     */
    public enum Half {
        /**
         * 上半部分方块, 通常情况下 y 值更高
         */
        TOP,
        /**
         * 下半部分方块, 通常情况下 y 值更低
         */
        BOTTOM;
    }
}
