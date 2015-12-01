package org.bukkit.generator;

import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.World;

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
     */
    public abstract void populate(World world, Random random, Chunk source);
}