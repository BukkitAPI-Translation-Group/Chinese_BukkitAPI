package org.bukkit.block.data.type;

import org.bukkit.block.data.AnaloguePowerable;

/**
 * 'inverted' 值表示阳光探测器是否被调整了反转模式,
 * 即在光照不足时再激活.
 */
public interface DaylightDetector extends AnaloguePowerable {

    /**
     * 获取 'inverted' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'inverted' property.
     *
     * @return 属性 'inverted' 的值
     */
    boolean isInverted();

    /**
     * 设置 'inverted' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'inverted' property.
     *
     * @param inverted 新的 'inverted' 属性值
     */
    void setInverted(boolean inverted);
}
