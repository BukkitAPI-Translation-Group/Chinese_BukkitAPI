package org.bukkit.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;

/**
 * 区块生成器用于初始化一个整体的区块。比如说，地狱的区块生成器用于生成地狱岩和灵魂沙。
 * <p>
 * 原文：
 * A chunk generator is responsible for the initial shaping of an entire
 * chunk. For example, the nether chunk generator should shape netherrack and
 * soulsand
 */
public abstract class ChunkGenerator {

    /**
     * 被生成区块的生物群系数据的接口：根据世界类型和种子的默认值初始化。
	 * <p>
	 * 自定义生成器使用以下接口可以自由地访问和调整数值：generateBlockSections() 或 generateExtBlockSections()
	 * <p>
	 * 原文：
	 * Interface to biome data for chunk to be generated: initialized with
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
    @Deprecated
    /**
	 * 生成指定坐标的区块。
     * <p>
	 * 这个方法会按照下面的格式返回一个byte[32768]类型的数据。
     * <pre>
     * for (int x = 0; x &lt; 16; x++) {
     *     for (int z = 0; z &lt; 16; z++) {
     *         for (int y = 0; y &lt; 128; y++) {
     *             // result[(x * 16 + z) * 128 + y] = ??;
     *         }
     *     }
     * }
     * </pre>
     * <p>
	 * 注意这个方法<b>永远不要</b>试图去获取已经通过的坐标，不然就可能陷入死循环。
	 * <p>
	 * 注意这个过时的方法只有在 generateExtBlockSections() 和 generateBlockSections() 都失效并且返回null时才能被调用。
	 * <p>
   	 * 原文：
     * Shapes the chunk for the given coordinates.
     * <p>
     * This method should return a byte[32768] in the following format:
     * <pre>
     * for (int x = 0; x &lt; 16; x++) {
     *     for (int z = 0; z &lt; 16; z++) {
     *         for (int y = 0; y &lt; 128; y++) {
     *             // result[(x * 16 + z) * 128 + y] = ??;
     *         }
     *     }
     * }
     * </pre>
     * <p>
     * Note that this method should <b>never</b> attempt to get the Chunk at
     * the passed coordinates, as doing so may cause an infinite loop
     * <p>
     * Note this deprecated method will only be called when both
     * generateExtBlockSections() and generateBlockSections() are
     * unimplemented and return null.
     *
     * @param world 被指定区块的世界
     * @param random 使用的随机生成器
     * @param x 区块的X坐标
     * @param z 区块的Z坐标
     * @return 包含每个被这个生成器创造的方块的byte[]类型的数据
     */
    public byte[] generate(World world, Random random, int x, int z) {
        throw new UnsupportedOperationException("Custom generator is missing required methods: generate(), generateBlockSections() and generateExtBlockSections()");
    }

    /**
	 * 使用拓展方块的ID(0-4095)生成指定坐标的区块。
	 * <p>
	 * 截至1.2，区块被表示为一个三维数组,每个区块都由16*16*16个方块组成。如果一部分是空的(都是ID为0的方块，即空气)，那么这个部分就不再需要被维持以减少内存占用
	 * <p>
	 * 这个方法会按照下面的格式返回一个short[][]类型的数据。
     * <pre>
     *     short[][] result = new short[world-height / 16][];
     * </pre>
	 * 每个拥有方块的部分 {@code (sectionID = (Y>>4))} 需要为这部分中的4096个方块分配空间：
     * <pre>
     *     result[sectionID] = new short[4096];
     * </pre>
     * 没有内容的部分可以被保留为空。
	 * <p>
	 * 使用下面的映射函数可以在X,Y,Z坐标放置一个在区块内的方块：
     * <pre>
     *    void setBlock(short[][] result, int x, int y, int z, short blkid) {
     *        {@code if (result[y >> 4] == null) {}
     *            {@code result[y >> 4] = new short[4096];}
     *        }
     *        {@code result[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = blkid;}
     *    }
     * </pre>
	 * 使用下面的映射函数可以读取一个方块的ID：
     * <pre>
     *    short getBlock(short[][] result, int x, int y, int z) {
     *        {@code if (result[y >> 4] == null) {}
     *            return (short)0;
     *        }
     *        {@code return result[y >> 4][((y & 0xF) << 8) | (z << 4) | x];}
     *    }
     * </pre>
	 * <p>
	 * 注意这个方法<b>永远不要</b>试图去获取已经通过的坐标，不然就可能陷入死循环。
	 * <p>
	 * 注意不能返回255以上方块ID的生成器不应该执行此方法，否则会返回空(generateBlockSections()方法被调用时的结果)。
	 * <p>
	 * 原文：
     * Shapes the chunk for the given coordinates, with extended block IDs
     * supported (0-4095).
     * <p>
     * As of 1.2, chunks are represented by a vertical array of chunk
     * sections, each of which is 16 x 16 x 16 blocks. If a section is empty
     * (all zero), the section does not need to be supplied, reducing memory
     * usage.
     * <p>
     * This method must return a short[][] array in the following format:
     * <pre>
     *     short[][] result = new short[world-height / 16][];
     * </pre>
     * Each section {@code (sectionID = (Y>>4))} that has blocks needs to be allocated
     * space for the 4096 blocks in that section:
     * <pre>
     *     result[sectionID] = new short[4096];
     * </pre>
     * while sections that are not populated can be left null.
     * <p>
     * Setting a block at X, Y, Z within the chunk can be done with the
     * following mapping function:
     * <pre>
     *    void setBlock(short[][] result, int x, int y, int z, short blkid) {
     *        {@code if (result[y >> 4] == null) {}
     *            {@code result[y >> 4] = new short[4096];}
     *        }
     *        {@code result[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = blkid;}
     *    }
     * </pre>
     * while reading a block ID can be done with the following mapping
     * function:
     * <pre>
     *    short getBlock(short[][] result, int x, int y, int z) {
     *        {@code if (result[y >> 4] == null) {}
     *            return (short)0;
     *        }
     *        {@code return result[y >> 4][((y & 0xF) << 8) | (z << 4) | x];}
     *    }
     * </pre>
     * <p>
     * Note that this method should <b>never</b> attempt to get the Chunk at
     * the passed coordinates, as doing so may cause an infinite loop
     * <p>
     * Note generators that do not return block IDs above 255 should not
     * implement this method, or should have it return null (which will result
     * in the generateBlockSections() method being called).
     *
     * @param world 被指定区块的世界
     * @param random 使用的随机生成器
     * @param x 区块的X坐标
     * @param z 区块的Z坐标
     * @param biomes 区块预期的生物群系数值，可以被生成器更新
     * @return 包含每个被这个生成器创造的方块的short[][]类型的数据
     * @deprecated 不安全的参数
     */
    @Deprecated
    public short[][] generateExtBlockSections(World world, Random random, int x, int z, BiomeGrid biomes) {
        return null; // Default - returns null, which drives call to generateBlockSections()
    }

    /**
	 * 在指定的坐标生成区块。
	 * <p>
	 * 截至1.2，区块被表示为一个三维数组,每个区块都由16*16*16个方块组成。如果一部分是空的(都是ID为0的方块，即空气)，那么这个部分就不再需要被维持以减少内存占用
	 * <p>
	 * 这个方法会按照下面的格式返回一个byte[][]类型的数据。
     * <pre>
     *     byte[][] result = new byte[world-height / 16][];
     * </pre>
	 * 每个拥有方块的部分 {@code (sectionID = (Y>>4))} 需要为这部分中的4096个方块分配空间：
     * <pre>
     *     result[sectionID] = new byte[4096];
     * </pre>
     * 没有内容的部分可以被保留为空。
	 * 使用下面的映射函数可以在X,Y,Z坐标放置一个在区块内的方块：
     * <pre>
     *    void setBlock(byte[][] result, int x, int y, int z, byte blkid) {
     *        {@code if (result[y >> 4) == null) {}
     *            {@code result[y >> 4] = new byte[4096];}
     *        }
     *        {@code result[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = blkid;}
     *    }
     * </pre>
	 * 使用下面的映射函数可以读取一个方块的ID：
     * <pre>
     *    byte getBlock(byte[][] result, int x, int y, int z) {
     *        {@code if (result[y >> 4) == null) {}
     *            return (byte)0;
     *        }
     *        {@code return result[y >> 4][((y & 0xF) << 8) | (z << 4) | x];}
     *    }
     * </pre>
     * 注意这个方法<b>永远不要</b>试图去获取已经通过的坐标，不然就可能陷入死循环。
	 * <p>
	 * 原文：
     * Shapes the chunk for the given coordinates.
     * <p>
     * As of 1.2, chunks are represented by a vertical array of chunk
     * sections, each of which is 16 x 16 x 16 blocks.  If a section is empty
     * (all zero), the section does not need to be supplied, reducing memory
     * usage.
     * <p>
     * This method must return a byte[][] array in the following format:
     * <pre>
     *     byte[][] result = new byte[world-height / 16][];
     * </pre>
     * Each section {@code (sectionID = (Y>>4))} that has blocks needs to be allocated
     * space for the 4096 blocks in that section:
     * <pre>
     *     result[sectionID] = new byte[4096];
     * </pre>
     * while sections that are not populated can be left null.
     * <p>
     * Setting a block at X, Y, Z within the chunk can be done with the
     * following mapping function:
     * <pre>
     *    void setBlock(byte[][] result, int x, int y, int z, byte blkid) {
     *        {@code if (result[y >> 4) == null) {}
     *            {@code result[y >> 4] = new byte[4096];}
     *        }
     *        {@code result[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = blkid;}
     *    }
     * </pre>
     * while reading a block ID can be done with the following mapping
     * function:
     * <pre>
     *    byte getBlock(byte[][] result, int x, int y, int z) {
     *        {@code if (result[y >> 4) == null) {}
     *            return (byte)0;
     *        }
     *        {@code return result[y >> 4][((y & 0xF) << 8) | (z << 4) | x];}
     *    }
     * </pre>
     *
     * Note that this method should <b>never</b> attempt to get the Chunk at
     * the passed coordinates, as doing so may cause an infinite loop
     *
     * @param world 被指定区块的世界
     * @param random 使用的随机生成器
     * @param x 区块的X坐标
     * @param z 区块的Z坐标
     * @param biomes 区块预期的生物群系数值，可以被生成器更新
     * @return 包含每个被这个生成器创造的方块的short[][]类型的数据
     * @deprecated 不安全的参数
     */
    @Deprecated
    public byte[][] generateBlockSections(World world, Random random, int x, int z, BiomeGrid biomes) {
        return null; // Default - returns null, which drives call to generate()
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
	 * 得到一个用于提供指定世界的默认的{@link BlockPopulator}列表
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
}
