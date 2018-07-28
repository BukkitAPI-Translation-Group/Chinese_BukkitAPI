package org.bukkit.block.data;

/**
 * 'waterlogged'表示方块是否处于流体之中.
 */
public interface Waterlogged extends BlockData {

    /**
     * 获取'waterlogged'属性值.
     * <p>
     * 原文:Gets the value of the 'waterlogged' property.
     *
     * @return 方块是否处于流体之中
     */
    boolean isWaterlogged();

    /**
     * 设置'waterlogged'属性值.
     * <p>
     * 原文:Sets the value of the 'waterlogged' property.
     *
     * @param waterlogged 方块是否处于流体之中
     */
    void setWaterlogged(boolean waterlogged);
}
