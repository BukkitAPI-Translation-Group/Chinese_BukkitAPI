package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;

/**
 * 'honey_level' 值代表该蜂箱中存储蜂蜜的值.
 */
public interface Beehive extends Directional {

    /**
     * 获取 'honey_level' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'honey_level' property.
     *
     * @return the 'honey_level' value
     */
    int getHoneyLevel();

    /**
     * 设置 'honey_level' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'honey_level' property.
     *
     * @param honeyLevel 新的 'honey_level' 属性值
     */
    void setHoneyLevel(int honeyLevel);

    /**
     * 获取 'honey_level' 属性所允许的最大值.
     * <p>
     * 原文:
     * Gets the maximum allowed value of the 'honey_level' property.
     *
     * @return 属性 'honey_level' 的最大值
     */
    int getMaximumHoneyLevel();
}
