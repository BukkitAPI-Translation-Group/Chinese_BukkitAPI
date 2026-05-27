package org.bukkit.block.data.type;

import org.bukkit.block.data.Lightable;
import org.bukkit.block.data.Waterlogged;

/**
 * 'candles' 表示存在的蜡烛数量.
 */
public interface Candle extends Lightable, Waterlogged {

    /**
     * 获取 'candles' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'candles' property.
     *
     * @return 'candles' 的值
     */
    int getCandles();

    /**
     * 设置 'candles' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'candles' property.
     *
     * @param candles 新的 'candles' 值
     */
    void setCandles(int candles);

    /**
     * 获取 'candles' 属性允许的最大值.
     * <p>
     * 原文：
     * Gets the maximum allowed value of the 'candles' property.
     *
     * @return 'candles' 的最大值
     */
    int getMaximumCandles();
}
