package org.bukkit.block.data.type;

import org.bukkit.block.data.BlockData;

/**
 * 'bloom' 表示幽匿催发体是否正在积极传播幽匿块.
 */
public interface SculkCatalyst extends BlockData {

    /**
     * 获取 'bloom' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'bloom' property.
     *
     * @return 'bloom' 的值
     */
    boolean isBloom();

    /**
     * 设置 'bloom' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'bloom' property.
     *
     * @param bloom 新的 'bloom' 值
     */
    void setBloom(boolean bloom);
}
