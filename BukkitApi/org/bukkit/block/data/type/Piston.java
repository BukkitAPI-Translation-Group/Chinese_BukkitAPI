package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;

/**
 * 'extended' 值表示当前活塞臂是否伸出.
 */
public interface Piston extends Directional {

    /**
     * 获取 'extended' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'extended' property.
     *
     * @return 属性 'extended' 的值
     */
    boolean isExtended();

    /**
     * 设置 'extended' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'extended' property.
     *
     * @param extended 新的 'extended' 属性值
     */
    void setExtended(boolean extended);
}
