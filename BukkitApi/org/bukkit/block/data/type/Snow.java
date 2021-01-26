package org.bukkit.block.data.type;

import org.bukkit.block.data.BlockData;

/**
 * 'layers' 值代表该方块堆积了多少层雪片.
 * <br>
 * 值不可小于 {@link #getMinimumLayers()} 且不可大于 {@link #getMaximumLayers()}.
 */
public interface Snow extends BlockData {

    /**
     * 获取 'layers' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'layers' property.
     *
     * @return 属性 'layers' 的值
     */
    int getLayers();

    /**
     * 设置 'layers' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'layers' property.
     *
     * @param layers 新的 'layers' 属性值
     */
    void setLayers(int layers);

    /**
     * 获取 'layers' 属性所允许的最小值.
     * <p>
     * 原文:
     * Gets the minimum allowed value of the 'layers' property.
     *
     * @return 最小 'layers' 属性值
     */
    int getMinimumLayers();

    /**
     * 获取 'layers' 属性所允许的最大值.
     * <p>
     * 原文:
     * Gets the maximum allowed value of the 'layers' property.
     *
     * @return 最大 'layers' 属性值
     */
    int getMaximumLayers();
}
