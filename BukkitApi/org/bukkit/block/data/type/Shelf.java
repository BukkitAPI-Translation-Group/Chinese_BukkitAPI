package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Powerable;
import org.bukkit.block.data.Waterlogged;
import org.jetbrains.annotations.NotNull;

/**
 * 'side_chain' 表示方块侧面的链条状态.
 */
public interface Shelf extends Directional, Powerable, Waterlogged {

    /**
     * 获取 'side_chain' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'side_chain' property.
     *
     * @return 'side_chain' 的值
     */
    @NotNull
    SideChain getSideChain();

    /**
     * 设置 'side_chain' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'side_chain' property.
     *
     * @param sideChain 新的 'side_chain' 值
     */
    void setSideChain(@NotNull SideChain sideChain);

    /**
     * 架子侧面链条的状态.
     */
    public enum SideChain {

        /**
         * 左侧链条.
         */
        LEFT,
        /**
         * 中间链条.
         */
        CENTER,
        /**
         * 右侧链条.
         */
        RIGHT,
        /**
         * 未连接的链条.
         */
        UNCONNECTED;
    }
}
