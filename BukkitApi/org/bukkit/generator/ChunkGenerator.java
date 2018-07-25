package org.bukkit.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.material.MaterialData;

/**
 * 用于初始化一个整体的区块的区块生成器。比如说，地狱的区块生成器用于生成地狱岩和灵魂沙。
 */
public abstract class ChunkGenerator {

    /**
     * 被生成区块的生物群系数据的接口：根据世界类型和种子的默认值初始化。
     * <p>
     * 自定义生成器使用以下接口可以自由地访问和调整数值：generateBlockSections() 或 generateExtBlockSections()
     * <p>
     * 原文：
     * Interface to biome section for chunk to be generated: initialized with
     * default values for world type and seed.
     * <p>
     * Custom generator is free to access and tailor values during
     * generateBlockSections() or generateExtBlockSections().
     */
    public interface BiomeGrid {

        /**
         * 根据被生成区块的X，Z坐标获取生物群系。
         * <p>
         * 原文：
         * Get biome at x, z within chunk being generated
         *
         * @param x - 0-15
         * @param z - 0-15
         * @return Biome 数值
         */
        Biome getBiome(int x, int z);

        /**
         * 根据被生成区块的X，Z坐标设置生物群系。
         * <p>
         * 原文：
         * Set biome at x, z within chunk being generated
         *
         * @param x - 0-15
         * @param z - 0-15
         * @param bio - 生物群系数值
         */
        void setBiome(int x, int z, Biome bio);
    }

    /**
     * Shapes the chunk for the given coordinates.
     * 
     * This method must return a ChunkData.
     * <p>
     * Notes:
     * <p>
     * This method should <b>never</b> attempt to get the Chunk at
     * the passed coordinates, as doing so may cause an infinite loop
     * <p>
     * This method should <b>never</b> modify a ChunkData after it has
     * been returned.
     * <p>
     * This method <b>must</b> return a ChunkData returned by {@link ChunkGenerator#createChunkData(org.bukkit.World)}
     * 
     * @param world The world this chunk will be used for
     * @param random The random generator to use
     * @param x The X-coordinate of the chunk
     * @param z The Z-coordinate of the chunk
     * @param biome Proposed biome values for chunk - can be updated by
     *     generator
     * @return ChunkData containing the types for each block created by this
     *     generator
     */
    public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid biome) {
        throw new UnsupportedOperationException("Custom generator is missing required method generateChunkData");
    }

    /**
     * Create a ChunkData for a world.
     * @param world the world the ChunkData is for
     * @return a new ChunkData for world
     */
    protected final ChunkData createChunkData(World world) {
        return Bukkit.getServer().createChunkData(world);
    }

    /**
     * 测试指定方位是否对自然生成的方位有效。
     * <p>
     * 原文：
     * Tests if the specified location is valid for a natural spawn position
     *
     * @param world 用于测试的世界
     * @param x 用于测试的方块的X坐标
     * @param z 用于测试的方块的Z坐标
     * @return 如果方位有效则返回true，否则返回false
     */
    public boolean canSpawn(World world, int x, int z) {
        Block highest = world.getBlockAt(x, world.getHighestBlockYAt(x, z), z);

        switch (world.getEnvironment()) {
        case NETHER:
            return true;
        case THE_END:
            return highest.getType() != Material.AIR && highest.getType() != Material.WATER && highest.getType() != Material.LAVA;
        case NORMAL:
        default:
            return highest.getType() == Material.SAND || highest.getType() == Material.GRAVEL;
        }
    }

    /**
	    * 得到一个用于提供指定世界的默认的{@link BlockPopulator}列表。
     * <p>
     * 原文：
     * Gets a list of default {@link BlockPopulator}s to apply to a given
     * world
     *
     * @param world 用于提供的世界
     * @return 包含所有方块填充器的列表
     */
    public List<BlockPopulator> getDefaultPopulators(World world) {
        return new ArrayList<BlockPopulator>();
    }

    /**
	    * 获取一个固定出生方位用于一个指定的世界。
	    * <p>
	    * 如果一个世界没有使用一个固定出生点就会返回空值，并且会试图随机寻找一个以代替。
	    * <p>
	    * 原文：
     * Gets a fixed spawn location to use for a given world.
     * <p>
     * A null value is returned if a world should not use a fixed spawn point,
     * and will instead attempt to find one randomly.
     *
     * @param world 用于定位出生点的世界
     * @param random 这个计算器中使用的随机生成器
     * @return 包含一个新的出生点的方位，若不存在则返回null
     */
    public Location getFixedSpawnLocation(World world, Random random) {
        return null;
    }

    /**
     * Data for a Chunk.
     */
    public static interface ChunkData {
        /**
         * Get the maximum height for the chunk.
         * 
         * Setting blocks at or above this height will do nothing.
         * 
         * @return the maximum height
         */
        public int getMaxHeight();

        /**
         * Set the block at x,y,z in the chunk data to material.
         *
         * Note: setting blocks outside the chunk's bounds does nothing.
         *
         * @param x the x location in the chunk from 0-15 inclusive
         * @param y the y location in the chunk from 0 (inclusive) - maxHeight (exclusive)
         * @param z the z location in the chunk from 0-15 inclusive
         * @param material the type to set the block to
         */
        public void setBlock(int x, int y, int z, Material material);

        /**
         * Set the block at x,y,z in the chunk data to material.
         *
         * Setting blocks outside the chunk's bounds does nothing.
         *
         * @param x the x location in the chunk from 0-15 inclusive
         * @param y the y location in the chunk from 0 (inclusive) - maxHeight (exclusive)
         * @param z the z location in the chunk from 0-15 inclusive
         * @param material the type to set the block to
         */
        public void setBlock(int x, int y, int z, MaterialData material);

        /**
         * Set the block at x,y,z in the chunk data to material.
         *
         * Setting blocks outside the chunk's bounds does nothing.
         *
         * @param x the x location in the chunk from 0-15 inclusive
         * @param y the y location in the chunk from 0 (inclusive) - maxHeight (exclusive)
         * @param z the z location in the chunk from 0-15 inclusive
         * @param blockData the type to set the block to
         */
        public void setBlock(int x, int y, int z, BlockData blockData);

        /**
         * Set a region of this chunk from xMin, yMin, zMin (inclusive)
         * to xMax, yMax, zMax (exclusive) to material.
         *
         * Setting blocks outside the chunk's bounds does nothing.
         *
         * @param xMin minimum x location (inclusive) in the chunk to set
         * @param yMin minimum y location (inclusive) in the chunk to set
         * @param zMin minimum z location (inclusive) in the chunk to set
         * @param xMax maximum x location (exclusive) in the chunk to set
         * @param yMax maximum y location (exclusive) in the chunk to set
         * @param zMax maximum z location (exclusive) in the chunk to set
         * @param material the type to set the blocks to
         */
        public void setRegion(int xMin, int yMin, int zMin, int xMax, int yMax, int zMax, Material material);

        /**
         * Set a region of this chunk from xMin, yMin, zMin (inclusive)
         * to xMax, yMax, zMax (exclusive) to material.
         *
         * Setting blocks outside the chunk's bounds does nothing.
         *
         * @param xMin minimum x location (inclusive) in the chunk to set
         * @param yMin minimum y location (inclusive) in the chunk to set
         * @param zMin minimum z location (inclusive) in the chunk to set
         * @param xMax maximum x location (exclusive) in the chunk to set
         * @param yMax maximum y location (exclusive) in the chunk to set
         * @param zMax maximum z location (exclusive) in the chunk to set
         * @param material the type to set the blocks to
         */
        public void setRegion(int xMin, int yMin, int zMin, int xMax, int yMax, int zMax, MaterialData material);

        /**
         * Set a region of this chunk from xMin, yMin, zMin (inclusive) to xMax,
         * yMax, zMax (exclusive) to material.
         *
         * Setting blocks outside the chunk's bounds does nothing.
         *
         * @param xMin minimum x location (inclusive) in the chunk to set
         * @param yMin minimum y location (inclusive) in the chunk to set
         * @param zMin minimum z location (inclusive) in the chunk to set
         * @param xMax maximum x location (exclusive) in the chunk to set
         * @param yMax maximum y location (exclusive) in the chunk to set
         * @param zMax maximum z location (exclusive) in the chunk to set
         * @param blockData the type to set the blocks to
         */
        public void setRegion(int xMin, int yMin, int zMin, int xMax, int yMax, int zMax, BlockData blockData);

        /**
         * Get the type of the block at x, y, z.
         *
         * Getting blocks outside the chunk's bounds returns air.
         *
         * @param x the x location in the chunk from 0-15 inclusive
         * @param y the y location in the chunk from 0 (inclusive) - maxHeight (exclusive)
         * @param z the z location in the chunk from 0-15 inclusive
         * @return the type of the block or Material.AIR if x, y or z are outside the chunk's bounds
         */
        public Material getType(int x, int y, int z);

        /**
         * Get the type and data of the block at x, y ,z.
         *
         * Getting blocks outside the chunk's bounds returns air.
         *
         * @param x the x location in the chunk from 0-15 inclusive
         * @param y the y location in the chunk from 0 (inclusive) - maxHeight (exclusive)
         * @param z the z location in the chunk from 0-15 inclusive
         * @return the type and data of the block or the MaterialData for air if x, y or z are outside the chunk's bounds
         */
        public MaterialData getTypeAndData(int x, int y, int z);

        /**
         * Get the type and data of the block at x, y ,z.
         *
         * Getting blocks outside the chunk's bounds returns air.
         *
         * @param x the x location in the chunk from 0-15 inclusive
         * @param y the y location in the chunk from 0 (inclusive) - maxHeight (exclusive)
         * @param z the z location in the chunk from 0-15 inclusive
         * @return the data of the block or the MaterialData for air if x, y or z are outside the chunk's bounds
         */
        public BlockData getBlockData(int x, int y, int z);

        /**
         * Get the block data at x,y,z in the chunk data.
         *
         * Getting blocks outside the chunk's bounds returns 0.
         *
         * @param x the x location in the chunk from 0-15 inclusive
         * @param y the y location in the chunk from 0 (inclusive) - maxHeight (exclusive)
         * @param z the z location in the chunk from 0-15 inclusive
         * @return the block data value or air if x, y or z are outside the chunk's bounds
         * @deprecated Uses magic values
         */
        @Deprecated
        public byte getData(int x, int y, int z);
    }
}