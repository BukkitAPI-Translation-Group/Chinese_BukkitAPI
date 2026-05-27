package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;

/**
 * 'segment_amount' 表示片段的数量.
 */
public interface LeafLitter extends Directional {

    /**
     * 获取 'segment_amount' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'segment_amount' property.
     *
     * @return 'segment_amount' 的值
     */
    int getSegmentAmount();

    /**
     * 设置 'segment_amount' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'segment_amount' property.
     *
     * @param segment_amount 新的 'segment_amount' 值
     */
    void setSegmentAmount(int segment_amount);

    /**
     * 获取 'segment_amount' 属性允许的最大值.
     * <p>
     * 原文：
     * Gets the maximum allowed value of the 'segment_amount' property.
     *
     * @return 'segment_amount' 的最大值
     */
    int getMaximumSegmentAmount();
}
