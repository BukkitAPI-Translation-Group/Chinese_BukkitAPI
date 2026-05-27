package org.bukkit.block.data.type;

import org.bukkit.block.data.BlockData;

/**
 * 'berries' 表示方块是否带有浆果.
 */
public interface CaveVinesPlant extends BlockData {

    /**
     * 获取 'berries' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'berries' property.
     *
     * @return 'berries' 的值
     */
    boolean isBerries();

    /**
     * 设置 'berries' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'berries' property.
     *
     * @param berries 新的 'berries' 值
     */
    void setBerries(boolean berries);
}
