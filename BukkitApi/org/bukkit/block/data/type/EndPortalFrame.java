package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;

/**
 * 'eye' 值表示该末地传送门上是否放置了一个末影之眼 (被激活).
 */
public interface EndPortalFrame extends Directional {

    /**
     * 获取 'eye' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'eye' property.
     *
     * @return 属性 'eye' 的值
     */
    boolean hasEye();

    /**
     * 设置 'eye' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'eye' property.
     *
     * @param eye 新的 'eye' 属性值
     */
    void setEye(boolean eye);
}
