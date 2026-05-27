package org.bukkit.block.data.type;

import org.bukkit.block.data.Waterlogged;

/**
 * 'can_summon' 表示幽匿尖啸体是否可以召唤监守者.
 * <p>
 * 'shrieking' 表示幽匿尖啸体是否正在尖啸.
 */
public interface SculkShrieker extends Waterlogged {

    /**
     * 获取 'can_summon' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'can_summon' property.
     *
     * @return 'can_summon' 的值
     */
    boolean isCanSummon();

    /**
     * 设置 'can_summon' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'can_summon' property.
     *
     * @param can_summon 新的 'can_summon' 值
     */
    void setCanSummon(boolean can_summon);

    /**
     * 获取 'shrieking' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'shrieking' property.
     *
     * @return 'shrieking' 的值
     */
    boolean isShrieking();

    /**
     * 设置 'shrieking' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'shrieking' property.
     *
     * @param shrieking 新的 'shrieking' 值
     */
    void setShrieking(boolean shrieking);
}
