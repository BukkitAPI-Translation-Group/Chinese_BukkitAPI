package org.bukkit.generator;

import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

/**
 * 用于生成一定小区域的方块的方块填充器。
 * <p>
 * 例如，在地狱中或生成的填满宝藏的地牢中生成萤石。
 */
public abstract class BlockPopulator {

    /**
     * 在指定的区块附近或内部填充一定区域的方块。
     * <p>
     * 在指定区块四周的区块必须已经存在；就是说，指定方块的东南西北都必须有一个区块存在，
     * 角落区块可以不存在。当准备好时填充器会记录那些区块所有的修改请求并执行修改。
     * <p>
     * 译注：存在的意思可能是加载。
     * <p>
     * 原文：
     * Populates an area of blocks at or around the given chunk.
     * <p>
     * The chunks on each side of the specified chunk must already exist; that
     * is, there must be one north, east, south and west of the specified
     * chunk. The "corner" chunks may not exist, in which scenario the
     * populator should record any changes required for those chunks and
     * perform the changes when they are ready.
     *
     * @param world 用于生成的世界
     * @param random 使用的随机生成器
     * @param source 用于生成的区块
     * @deprecated 建议使用 {@link #populate(WorldInfo, Random, int, int, LimitedRegion)}
     */
    @Deprecated
    public void populate(@NotNull World world, @NotNull Random random, @NotNull Chunk source) {
    }

    /**
     * Populates an area of blocks at or around the given chunk.
     * <p>
     * Notes:
     * <p>
     * This method should <b>never</b> attempt to get the Chunk at the passed
     * coordinates, as doing so may cause an infinite loop
     * <p>
     * This method should <b>never</b> modify a {@link LimitedRegion} at a later
     * point of time.
     * <p>
     * This method <b>must</b> be completely thread safe and able to handle
     * multiple concurrent callers.
     * <p>
     * No physics are applied, whether or not it is set to true in
     * {@link org.bukkit.block.BlockState#update(boolean, boolean)}
     * <p>
     * <b>Only</b> use the {@link org.bukkit.block.BlockState} returned by
     * {@link LimitedRegion},
     * <b>never</b> use methods from a {@link World} to modify the chunk.
     *
     * @param worldInfo The world info of the world to generate in
     * @param random The random generator to use
     * @param x The X-coordinate of the chunk
     * @param z The Z-coordinate of the chunk
     * @param limitedRegion The chunk region to populate
     */
    public void populate(@NotNull WorldInfo worldInfo, @NotNull Random random, int x, int z, @NotNull LimitedRegion limitedRegion) {
    }
}