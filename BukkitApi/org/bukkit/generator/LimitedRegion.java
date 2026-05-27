package org.bukkit.generator;

import java.util.List;
import org.bukkit.Location;
import org.bukkit.RegionAccessor;
import org.bukkit.block.BlockState;
import org.jetbrains.annotations.NotNull;

/**
 * 有限区域用于世界生成中跨越区块的特性，例如树木或矿石.
 *
 * 使用 {@link #getBuffer()} 来了解你可以超出中心区块多少.
 * 缓冲区可能已经填充，也可能尚未填充.
 *
 * 坐标是相对于世界原点的<b>绝对</b>坐标.
 */
public interface LimitedRegion extends RegionAccessor {

    /**
     * 获取中心区块周围可访问的缓冲区大小.
     * 返回值采用正常的世界坐标比例.
     * <p>
     * 原文：
     * Gets the buffer around the central chunk which is accessible.
     * The returned value is in normal world coordinate scale.
     * <p>
     * For example: If the method returns 16 you have a working area of 48x48.
     *
     * @return X和Z方向上的缓冲区大小
     */
    int getBuffer();

    /**
     * 检查给定的 {@link Location} 是否在区域内.
     * <p>
     * 原文：
     * Checks if the given {@link Location} is in the region.
     *
     * @param location 要检查的位置
     * @return 如果位置在区域内则返回true，否则返回false
     */
    boolean isInRegion(@NotNull Location location);

    /**
     * 检查给定的坐标是否在区域内.
     * <p>
     * 原文：
     * Checks if the given coordinates are in the region.
     *
     * @param x 要检查的X坐标
     * @param y 要检查的Y坐标
     * @param z 要检查的Z坐标
     * @return 如果坐标在区域内则返回true，否则返回false
     */
    boolean isInRegion(int x, int y, int z);

    /**
     * 获取有限区域中所有方块实体的列表，包括缓冲区.
     * <p>
     * 原文：
     * Gets a list of all tile entities in the limited region including the
     * buffer zone.
     *
     * @return 方块实体的列表
     */
    @NotNull
    List<BlockState> getTileEntities();
}
