package org.bukkit;

import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;

/**
 * 一个用于处理方块改变的代理.
 * <p>
 * 原文：
 * A delegate for handling block changes. This serves as a direct interface
 * between generation algorithms in the server implementation and utilizing
 * code.
 */
public interface BlockChangeDelegate {

    /**
     * 在指定坐标处设置方块数据.
     * <p>
     * 原文：Set a block data at the specified coordinates.
     *
     * @param x X 坐标
     * @param y Y 坐标
     * @param z Z 坐标
     * @param blockData 方块数据
     * @return 如果方块设置成功则返回 true
     */
    public boolean setBlockData(int x, int y, int z, @NotNull BlockData blockData);

    /**
     * 获取指定位置的方块数据.
     * <p>
     * 原文：Get the block data at the location.
     *
     * @param x X 坐标
     * @param y Y 坐标
     * @param z Z 坐标
     * @return 方块数据
     */
    @NotNull
    public BlockData getBlockData(int x, int y, int z);

    /**
     * 获取世界的高度.
     * <p>
     * 原文：Gets the height of the world.
     *
     * @return 世界的高度
     */
    public int getHeight();

    /**
     * 检查指定方块是否为空（空气）.
     * <p>
     * 原文：Checks if the specified block is empty (air) or not.
     *
     * @param x X 坐标
     * @param y Y 坐标
     * @param z Z 坐标
     * @return 如果方块被视为空则返回 true
     */
    public boolean isEmpty(int x, int y, int z);
}
