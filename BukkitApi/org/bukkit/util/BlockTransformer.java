package org.bukkit.util;

import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.generator.LimitedRegion;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * BlockTransformer 用于修改由结构放置的方块。
 */
@FunctionalInterface
@ApiStatus.Experimental
public interface BlockTransformer {

    /**
     * TransformationState 允许访问原始方块状态以及转换开始前世界中转换位置处方块的状态。
     */
    public static interface TransformationState {

        /**
         * 创建结构想要放置的原始方块状态的克隆，并为当前转换器缓存它。
         * <p>
         * 原文：
         * Creates a clone of the original block state that a structure wanted
         * to place and caches it for the current transformer.
         *
         * @return 原始方块状态的克隆。
         */
        @NotNull
        BlockState getOriginal();

        /**
         * 创建在转换过程开始时当前修改方块位置处方块状态的克隆，并为当前转换器缓存它。
         * <p>
         * 原文：
         * Creates a clone of the block state that was at the location of the
         * currently modified block at the start of the transformation process
         * and caches it for the current transformer.
         *
         * @return 世界方块状态的克隆。
         */
        @NotNull
        BlockState getWorld();

    }

    /**
     * 转换结构中的方块。
     * <p>
     * 原文：
     * Transforms a block in a structure.
     *
     * NOTE: The usage of {@link BlockData#createBlockState()} can provide even
     * more flexibility to return the exact block state you might want to
     * return.
     *
     * @param region 可访问区域
     * @param x 方块的 x 坐标
     * @param y 方块的 y 坐标
     * @param z 方块的 z 坐标
     * @param current 应放置的方块状态
     * @param state 此转换的状态
     *
     * @return 新的方块状态
     */
    @NotNull
    BlockState transform(@NotNull LimitedRegion region, int x, int y, int z, @NotNull BlockState current, @NotNull TransformationState state);
}
