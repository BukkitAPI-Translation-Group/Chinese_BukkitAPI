package org.bukkit.block.data.type;

import org.bukkit.block.data.Waterlogged;
import org.jetbrains.annotations.NotNull;

/**
 * 'type' 值代表台阶 (/半砖) 的状态 - 上台阶, 下台阶, 或占据了整个方块的双层台阶.
 */
public interface Slab extends Waterlogged {

    /**
     * 获取 'type' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'type' property.
     *
     * @return 属性 'type' 的值
     */
    @NotNull
    Type getType();

    /**
     * 设置 'type' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'type' property.
     *
     * @param type 新的 'type' 属性值
     */
    void setType(@NotNull Type type);

    /**
     * 台阶的类型.
     */
    public enum Type {
        /**
         * 台阶占据方块的上半部分
         */
        TOP,
        /**
         * 台阶占据方块的下半部分
         */
        BOTTOM,
        /**
         * (双层) 台阶占据了整个方块
         */
        DOUBLE;
    }
}
