package org.bukkit.block.data.type;

import org.bukkit.block.data.Waterlogged;

/**
 * 'hanging' 值表示灯笼是否悬挂在一个方块下.
 */
public interface Lantern extends Waterlogged {

    /**
     * 获取 'hanging' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'hanging' property.
     *
     * @return 属性 'hanging' 的值
     */
    boolean isHanging();

    /**
     * 设置 'hanging' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'hanging' property.
     *
     * @param hanging 新的 'hanging' 属性值
     */
    void setHanging(boolean hanging);
}
