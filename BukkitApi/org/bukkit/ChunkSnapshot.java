package org.bukkit;

import org.bukkit.block.Biome;
import org.bukkit.block.data.BlockData;

/**
 * 表示一个静态的，线程安全的方块的区块的快照.
 * <p>
 * 目的是允许清洁高效地复制一个区块的数据，然后在另一个线程（例如，地图渲染）中处理.
 */
public interface ChunkSnapshot {

    /**
     * 获取指定区块的X坐标.
     * 原文：
     * Gets the X-coordinate of this chunk
     *
     * @return X坐标
     */
    int getX();

    /**
     * 获取指定区块的Z坐标.
     * 原文：
     * Gets the Z-coordinate of this chunk
     *
     * @return Z坐标
     */
    int getZ();

    /**
     * 获取指定区块所在世界的名称.
     * 原文：
     * Gets name of the world containing this chunk
     *
     * @return 所在世界的名称
     */
    String getWorldName();

    /**
     * 获取区块中对应坐标方块的方块类型.
     * <p>
     * 原文:Get block type for block at corresponding coordinate in the chunk
     *
     * @param x 0-15
     * @param y 0-255
     * @param z 0-15
     * @return 方块物品类型
     */
    Material getBlockType(int x, int y, int z);

    /**
     * Get block data for block at corresponding coordinate in the chunk
     *
     * @param x 0-15
     * @param y 0-255
     * @param z 0-15
     * @return block material type
     */
    BlockData getBlockData(int x, int y, int z);

    /**
     * 获取区块中对应坐标方块的方块数据.
     * 原文：
     * Get block data for block at corresponding coordinate in the chunk
     *
     * @param x 0-15
     * @param y 0-255
     * @param z 0-15
     * @return 0-15
     * @deprecated 不安全的参数
     */
    @Deprecated
    int getData(int x, int y, int z);

    /**
     * 获取区块中对应坐标方块的天空亮度等级.
     * 原文：
     * Get sky light level for block at corresponding coordinate in the chunk
     *
     * @param x 0-15
     * @param y 0-255
     * @param z 0-15
     * @return 0-15
     */
    int getBlockSkyLight(int x, int y, int z);

    /**
     * 获取区块中对应坐标方块的发光亮度等级.
     * 原文：
     * Get light level emitted by block at corresponding coordinate in the
     * chunk
     *
     * @param x 0-15
     * @param y 0-255
     * @param z 0-15
     * @return 0-15
     */
    int getBlockEmittedLight(int x, int y, int z);

    /**
     * 获取指定坐标最高非空气方块的Y坐标.
     * 原文：
     * Gets the highest non-air coordinate at the given coordinates
     *
     * @param x 方块X坐标 (0-15)
     * @param z 方块Z坐标 (0-15)
     * @return 最高非空气方块的Y坐标
     */
    int getHighestBlockYAt(int x, int z);

    /**
     * 获取指定坐标的生物群系.
     * 原文：
     * Get biome at given coordinates
     *
     * @param x X坐标 (0-15)
     * @param z Z坐标 (0-15)
     * @return 指定坐标的生物群系
     */
    Biome getBiome(int x, int z);

    /**
     * 获取指定坐标原始生物群系的温度（范围为0.0到1.0）.
     * 原文：
     * Get raw biome temperature (0.0-1.0) at given coordinate
     *
     * @param x X坐标 (0-15)
     * @param z Z坐标 (0-15)
     * @return 指定坐标的温度
     */
    double getRawBiomeTemperature(int x, int z);

    /**
     * 抓取区块快照时获取世界的完整时间.
     * 原文：
     * Get world full time when chunk snapshot was captured
     *
     * @return 时间，用tick表示
     */
    long getCaptureFullTime();

    /**
     * 测试区块是否为空.
     * 原文：
     * Test if section is empty
     *
     * @param sy -区块的Y坐标（方块Y坐标整除16, 0-255）
     * @return 如果为空则返回true，否则返回false
     */
    boolean isSectionEmpty(int sy);
}