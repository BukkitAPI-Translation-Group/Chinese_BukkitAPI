package org.bukkit.block.data.type;

import org.bukkit.block.data.BlockData;

/**
 * 'charges' 值代表重生锚还能使用几次.
 */
public interface RespawnAnchor extends BlockData {

    /**
     * 获取 'charges' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'charges' property.
     *
     * @return 属性 'charges' 的值
     */
    int getCharges();

    /**
     * 设置 'charges' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'charges' property.
     *
     * @param charges 新的 'charges' 属性值
     */
    void setCharges(int charges);

    /**
     * 获取 'charges' 属性所能允许的最大值.
     * <p>
     * 原文:
     * Gets the maximum allowed value of the 'charges' property.
     *
     * @return 最大 'charges' 属性值
     */
    int getMaximumCharges();
}
