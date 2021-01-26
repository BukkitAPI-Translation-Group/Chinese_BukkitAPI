package org.bukkit.block.data.type;

import org.bukkit.block.data.BlockData;

/**
 * 'drag' 值表示是否存在应用到实体上的力将其移向该方块.
 */
public interface BubbleColumn extends BlockData {

    /**
     * 获取 'drag' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'drag' property.
     *
     * @return 属性 'drag' 的值
     */
    boolean isDrag();

    /**
     * 设置 'drag' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'drag' property.
     *
     * @param drag 新的 'drag' 属性值
     */
    void setDrag(boolean drag);

}
