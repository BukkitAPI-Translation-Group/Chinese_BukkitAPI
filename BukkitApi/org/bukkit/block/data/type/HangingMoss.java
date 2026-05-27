package org.bukkit.block.data.type;

import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.ApiStatus;

/**
 * 'tip' 表示此方块是否为尖端.
 */
@ApiStatus.Experimental
public interface HangingMoss extends BlockData {

    /**
     * 获取 'tip' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'tip' property.
     *
     * @return 'tip' 的值
     */
    boolean isTip();

    /**
     * 设置 'tip' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'tip' property.
     *
     * @param tip 新的 'tip' 值
     */
    void setTip(boolean tip);
}
