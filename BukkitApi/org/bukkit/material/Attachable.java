package org.bukkit.material;

import org.bukkit.block.BlockFace;

/**
 * 表示可以与另一个方块连接的方块(比如箱子、门).
 */
public interface Attachable extends Directional {

    /**
     * 获取这个方块的朝向.
     * <p>
     * 译注：比如箱子，箱子可以有东西南北四个朝向。
     * <p>
     * 原文：
     * Gets the face that this block is attached on
     *
     * @return 朝向
     */
    public BlockFace getAttachedFace();
}