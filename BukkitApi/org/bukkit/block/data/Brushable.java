package org.bukkit.block.data;

/**
 * 'dusted' 表示方块被刷子清除的程度，即露出的程度。
 */
public interface Brushable extends BlockData {

    /**
     * 获取 'dusted' 属性的值。
     * <p>
     * 原文:
     * Gets the value of the 'dusted' property.
     *
     * @return 'dusted' 属性的值
     */
    int getDusted();

    /**
     * 设置 'dusted' 属性的值。
     * <p>
     * 原文:
     * Sets the value of the 'dusted' property.
     *
     * @param dusted 'dusted' 属性的新值
     */
    void setDusted(int dusted);

    /**
     * 获取 'dusted' 属性允许的最大值。
     * <p>
     * 原文:
     * Gets the maximum allowed value of the 'dusted' property.
     *
     * @return 'dusted' 属性允许的最大值
     */
    int getMaximumDusted();
}
