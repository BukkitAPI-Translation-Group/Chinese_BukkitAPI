package org.bukkit.block.data.type;

import org.bukkit.block.data.BlockData;

/**
 * 'moisture' 值的的大小表示耕地距离水源 (如果有的话) .
 * <br>
 * 'moisture' 的值越高会使该方块上种植作物的生长速度更快,
 * 但是无法比 {@link #getMaximumMoisture()} 的值更高.
 */
public interface Farmland extends BlockData {

    /**
     * 获取 'moisture' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'moisture' property.
     *
     * @return 属性 'moisture' 的值
     */
    int getMoisture();

    /**
     * 设置 'moisture' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'moisture' property.
     *
     * @param moisture 新的 'moisture' 属性值
     */
    void setMoisture(int moisture);

    /**
     * 获取 'moisture' 属性所允许的最大值.
     * <p>
     * 原文:
     * Gets the maximum allowed value of the 'moisture' property.
     *
     * @return 最大 'moisture' 属性值
     */
    int getMaximumMoisture();
}
