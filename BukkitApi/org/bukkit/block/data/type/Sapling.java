package org.bukkit.block.data.type;

import org.bukkit.block.data.BlockData;

/**
 * 'stage' 值代表树苗的成长阶段.
 * <br>
 * 当树苗的成长阶段达到 {@link #getMaximumStage()} 时,
 * 它会尝试在下一个成长阶段长成一棵树.
 */
public interface Sapling extends BlockData {

    /**
     * 获取 'stage' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'stage' property.
     *
     * @return 属性 'stage' 的值
     */
    int getStage();

    /**
     * 设置 'stage' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'stage' property.
     *
     * @param stage 新的 'stage' 属性值
     */
    void setStage(int stage);

    /**
     * 获取 'stage' 属性所能允许的最大值.
     * <p>
     * 原文:
     * Gets the maximum allowed value of the 'stage' property.
     *
     * @return 最大 'stage' 属性值
     */
    int getMaximumStage();
}
