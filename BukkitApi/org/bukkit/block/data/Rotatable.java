package org.bukkit.block.data;

import org.bukkit.block.BlockFace;

/**
 * 'rotation'表示方块的旋转方向.
 */
public interface Rotatable extends BlockData {

    /**
     * 获取'rotation'属性值.
     * <p>
     * 原文:Gets the value of the 'rotation' property.
     *
     * @return 方块的旋转方向
     */
    BlockFace getRotation();

    /**
     * 设置'rotation'属性值.
     * <p>
     * 原文:Sets the value of the 'rotation' property.
     *
     * @param rotation 方块的旋转方向
     */
    void setRotation(BlockFace rotation);
}
