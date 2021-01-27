package org.bukkit.block.data.type;

import org.bukkit.block.data.BlockData;

/**
 * 'unstable' 值表示该 TNT 是否会在破坏后引爆.
 */
public interface TNT extends BlockData {

    /**
     * 获取 'unstable' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'unstable' property.
     *
     * @return 属性 'unstable' 的值
     */
    boolean isUnstable();

    /**
     * 设置 'unstable' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'unstable' property.
     *
     * @param unstable 新的 'unstable' 属性值
     */
    void setUnstable(boolean unstable);
}
