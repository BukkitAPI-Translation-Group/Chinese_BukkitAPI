package org.bukkit.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.HeightMap;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.material.MaterialData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 用于初始化一个整体的区块的区块生成器。比如说，地狱的区块生成器用于生成地狱岩和灵魂沙.
 *
 * A chunk is generated in multiple steps, those steps are always in the same
 * order. Between those steps however an unlimited time may pass. This means, a
 * chunk may generated until the surface step and continue with the bedrock step
 * after one or multiple server restarts or even after multiple Minecraft
 * versions.
 *
 * The order of generation is as follows
 * <ol>
 * <li>{@link #generateNoise(WorldInfo, Random, int, int, ChunkData)}</li>
 * <li>{@link #generateSurface(WorldInfo, Random, int, int, ChunkData)}</li>
 * <li>{@link #generateBedrock(WorldInfo, Random, int, int, ChunkData)}</li>
 * <li>{@link #generateCaves(WorldInfo, Random, int, int, ChunkData)}</li>
 * </ol>
 *
 * Every method listed above as well as
 * {@link #getBaseHeight(WorldInfo, Random, int, int, HeightMap)}
 * <b>must</b> be completely thread safe and able to handle multiple concurrent
 * callers.
 *
 * Some aspects of world generation can be delegated to the Vanilla generator.
 * The following methods can be overridden to enable this:
 * <ul>
 * <li>{@link ChunkGenerator#shouldGenerateNoise()} or {@link ChunkGenerator#shouldGenerateNoise(WorldInfo, Random, int, int)}</li>
 * <li>{@link ChunkGenerator#shouldGenerateSurface()} or {@link ChunkGenerator#shouldGenerateSurface(WorldInfo, Random, int, int)}</li>
 * <li>{@link ChunkGenerator#shouldGenerateCaves()} or {@link ChunkGenerator#shouldGenerateCaves(WorldInfo, Random, int, int)}</li>
 * <li>{@link ChunkGenerator#shouldGenerateDecorations()} or {@link ChunkGenerator#shouldGenerateDecorations(WorldInfo, Random, int, int)}</li>
 * <li>{@link ChunkGenerator#shouldGenerateMobs()} or {@link ChunkGenerator#shouldGenerateMobs(WorldInfo, Random, int, int)}</li>
 * <li>{@link ChunkGenerator#shouldGenerateStructures()} or {@link ChunkGenerator#shouldGenerateStructures(WorldInfo, Random, int, int)}</li>
 * </ul>
 */
public abstract class ChunkGenerator {

    /**
     * 为给定坐标塑造区块噪声.
     * <p>
     * 原文：
     * Shapes the Chunk noise for the given coordinates.
     * <p>
     * Notes:
     * <p>
     * This method should <b>never</b> attempt to get the Chunk at the passed
     * coordinates, as doing so may cause an infinite loop.
     * <p>
     * This method should <b>never</b> modify the {@link ChunkData} at a later
     * point of time.
     * <p>
     * The Y-coordinate range should <b>never</b> be hardcoded, to get the
     * Y-coordinate range use the methods {@link ChunkData#getMinHeight()} and
     * {@link ChunkData#getMaxHeight()}.
     * <p>
     * If {@link #shouldGenerateNoise()} is set to true, the given
     * {@link ChunkData} contains already the Vanilla noise generation.
     *
     * @param worldInfo 此区块将用于的世界的世界信息
     * @param random 要使用的随机数生成器
     * @param chunkX 区块的X坐标
     * @param chunkZ 区块的Z坐标
     * @param chunkData 要修改的区块数据
     */
    public void generateNoise(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ, @NotNull ChunkData chunkData) {
    }

    /**
     * 为给定坐标塑造区块表面.
     * <p>
     * 原文：
     * Shapes the Chunk surface for the given coordinates.
     * <p>
     * Notes:
     * <p>
     * This method should <b>never</b> attempt to get the Chunk at the passed
     * coordinates, as doing so may cause an infinite loop.
     * <p>
     * This method should <b>never</b> modify the {@link ChunkData} at a later
     * point of time.
     * <p>
     * The Y-coordinate range should <b>never</b> be hardcoded, to get the
     * Y-coordinate range use the methods {@link ChunkData#getMinHeight()} and
     * {@link ChunkData#getMaxHeight()}.
     * <p>
     * If {@link #shouldGenerateSurface()} is set to true, the given
     * {@link ChunkData} contains already the Vanilla surface generation.
     *
     * @param worldInfo 此区块将用于的世界的世界信息
     * @param random 要使用的随机数生成器
     * @param chunkX 区块的X坐标
     * @param chunkZ 区块的Z坐标
     * @param chunkData 要修改的区块数据
     */
    public void generateSurface(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ, @NotNull ChunkData chunkData) {
    }

    /**
     * 为给定坐标塑造区块基岩层.
     * <p>
     * 原文：
     * Shapes the Chunk bedrock layer for the given coordinates.
     * <p>
     * Notes:
     * <p>
     * This method should <b>never</b> attempt to get the Chunk at the passed
     * coordinates, as doing so may cause an infinite loop.
     * <p>
     * This method should <b>never</b> modify the {@link ChunkData} at a later
     * point of time.
     * <p>
     * The Y-coordinate range should <b>never</b> be hardcoded, to get the
     * Y-coordinate range use the methods {@link ChunkData#getMinHeight()} and
     * {@link ChunkData#getMaxHeight()}.
     *
     * @param worldInfo 此区块将用于的世界的世界信息
     * @param random 要使用的随机数生成器
     * @param chunkX 区块的X坐标
     * @param chunkZ 区块的Z坐标
     * @param chunkData 要修改的区块数据
     */
    public void generateBedrock(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ, @NotNull ChunkData chunkData) {
    }

    /**
     * 为给定坐标塑造区块洞穴.
     * <p>
     * 原文：
     * Shapes the Chunk caves for the given coordinates.
     * <p>
     * Notes:
     * <p>
     * This method should <b>never</b> attempt to get the Chunk at the passed
     * coordinates, as doing so may cause an infinite loop.
     * <p>
     * This method should <b>never</b> modify the {@link ChunkData} at a later
     * point of time.
     * <p>
     * The Y-coordinate range should <b>never</b> be hardcoded, to get the
     * Y-coordinate range use the methods {@link ChunkData#getMinHeight()} and
     * {@link ChunkData#getMaxHeight()}.
     * <p>
     * If {@link #shouldGenerateCaves()} is set to true, the given
     * {@link ChunkData} contains already the Vanilla cave generation.
     *
     * @param worldInfo 此区块将用于的世界的世界信息
     * @param random 要使用的随机数生成器
     * @param chunkX 区块的X坐标
     * @param chunkZ 区块的Z坐标
     * @param chunkData 要修改的区块数据
     */
    public void generateCaves(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ, @NotNull ChunkData chunkData) {
    }

    /**
     * 当在 {@link org.bukkit.WorldCreator} 或服务器配置文件中未设置 {@link BiomeProvider} 时调用此方法.
     * 因此，一个插件可以提供生物群系，另一个插件可以提供生成.
     * <p>
     * 原文：
     * Gets called when no {@link BiomeProvider} is set in
     * {@link org.bukkit.WorldCreator} or via the server configuration files. It
     * is therefore possible that one plugin can provide the Biomes and another
     * one the generation.
     * <p>
     * Notes:
     * <p>
     * If <code>null</code> is returned, than Vanilla biomes are used.
     * <p>
     * This method only gets called once when the world is loaded. Returning
     * another {@link BiomeProvider} later one is not respected.
     *
     * @param worldInfo 生物群系提供器将用于的世界的世界信息
     * @return 用于填充区块生物群系的BiomeProvider
     */
    @Nullable
    public BiomeProvider getDefaultBiomeProvider(@NotNull WorldInfo worldInfo) {
        return null;
    }

    /**
     * 此方法类似于 {@link World#getHighestBlockAt(int, int, HeightMap)}.
     * 区别在于，最高的y坐标应该是应用任何表面、基岩、洞穴或装饰之前的方块.
     * 换句话说，就是区块中只有噪声存在时的最高方块.
     * <p>
     * 原文：
     * This method is similar to
     * {@link World#getHighestBlockAt(int, int, HeightMap)}. With the difference
     * being, that the highest y coordinate should be the block before any
     * surface, bedrock, caves or decoration is applied. Or in other words the
     * highest block when only the noise is present at the chunk.
     * <p>
     * Notes:
     * <p>
     * When this method is not overridden, the Vanilla base height is used.
     * <p>
     * This method should <b>never</b> attempt to get the Chunk at the passed
     * coordinates, or use the method
     * {@link World#getHighestBlockAt(int, int, HeightMap)}, as doing so may
     * cause an infinite loop.
     *
     * @param worldInfo 此区块将用于的世界的世界信息
     * @param random 要使用的随机数生成器
     * @param x 世界原点的X坐标
     * @param z 世界原点的Z坐标
     * @param heightMap 从哪个高度图获取最高方块
     * @return 给定位置最高方块的y坐标
     */
    public int getBaseHeight(@NotNull WorldInfo worldInfo, @NotNull Random random, int x, int z, @NotNull HeightMap heightMap) {
        throw new UnsupportedOperationException("Not implemented");
    }

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
     * @deprecated 现在使用 {@link BiomeProvider} 设置生物群系
     */
    @Deprecated(since = "1.17.1")
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
         * @deprecated biomes are now 3-dimensional
         */
        @NotNull
        @Deprecated(since = "1.15")
        Biome getBiome(int x, int z);

        /**
         * 获取在区块内x, z位置的生物群系.
         * <p>
         * 原文：
         * Get biome at x, z within chunk being generated
         *
         * @param x - 0-15
         * @param y - 世界最小高度（包含） - 世界最大高度（不包含）
         * @param z - 0-15
         * @return 生物群系值
         */
        @NotNull
        Biome getBiome(int x, int y, int z);

        /**
         * 根据被生成区块的X，Z坐标设置生物群系。
         * <p>
         * 原文：
         * Set biome at x, z within chunk being generated
         *
         * @param x - 0-15
         * @param z - 0-15
         * @param bio - 生物群系数值
         * @deprecated biomes are now 3-dimensional
         */
        @Deprecated(since = "1.15")
        void setBiome(int x, int z, @NotNull Biome bio);

        /**
         * 设置在区块内x, z位置的生物群系.
         * <p>
         * 原文：
         * Set biome at x, z within chunk being generated
         *
         * @param x - 0-15
         * @param y - 世界最小高度（包含） - 世界最大高度（不包含）
         * @param z - 0-15
         * @param bio - 生物群系值
         */
        void setBiome(int x, int y, int z, @NotNull Biome bio);
    }

    /**
     * 为给定坐标塑造区块.
     *
     * 此方法必须返回一个ChunkData.
     * <p>
     * 原文：
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
     * @param world 此区块将用于的世界
     * @param random 要使用的随机数生成器
     * @param x 区块的X坐标
     * @param z 区块的Z坐标
     * @param biome 区块的建议生物群系值 - 可以被生成器更新
     * @return 包含此生成器创建的每个方块类型的ChunkData
     * @deprecated 生成现在已拆分，应使用新方法，参见 {@link ChunkGenerator}
     */
    @NotNull
    @Deprecated(since = "1.17.1")
    public ChunkData generateChunkData(@NotNull World world, @NotNull Random random, int x, int z, @NotNull BiomeGrid biome) {
        throw new UnsupportedOperationException("Not implemented, no longer needed");
    }

    /**
     * 为世界创建一个ChunkData.
     * <p>
     * 原文：
     * Create a ChunkData for a world.
     * @param world ChunkData所用于的世界
     * @return 为世界创建的新ChunkData
     * @deprecated {@link ChunkData} 现在直接提供
     */
    @NotNull
    @Deprecated(since = "1.17.1")
    protected final ChunkData createChunkData(@NotNull World world) {
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
    public boolean canSpawn(@NotNull World world, int x, int z) {
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
    @NotNull
    public List<BlockPopulator> getDefaultPopulators(@NotNull World world) {
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
    @Nullable
    public Location getFixedSpawnLocation(@NotNull World world, @NotNull Random random) {
        return null;
    }

    /**
     * 获取此ChunkGenerator是否支持并行.
     * <p>
     * 原文：
     * Gets if this ChunkGenerator is parallel capable.
     *
     * See {@link ChunkGenerator} for more information.
     *
     * @return 并行支持状态
     * @deprecated 区块生成代码应该是线程安全的
     */
    @Deprecated(since = "1.17.1")
    public boolean isParallelCapable() {
        return false;
    }

    /**
     * 获取服务器是否应该生成原版噪声.
     * <p>
     * 原文：
     * Gets if the server should generate Vanilla noise.
     * <p>
     * The Vanilla noise is generated <b>before</b>
     * {@link #generateNoise(WorldInfo, Random, int, int, ChunkData)} is called.
     * <p>
     * This is method is not called (and has therefore no effect), if
     * {@link #shouldGenerateNoise(WorldInfo, Random, int, int)} is overridden.
     *
     * @return 如果服务器应该生成原版噪声则返回true
     * @see #shouldGenerateNoise(WorldInfo, Random, int, int)
     */
    public boolean shouldGenerateNoise() {
        return false;
    }

    /**
     * 获取服务器是否应该生成原版噪声.
     * <p>
     * 原文：
     * Gets if the server should generate Vanilla noise.
     * <p>
     * The Vanilla noise is generated <b>before</b>
     * {@link #generateNoise(WorldInfo, Random, int, int, ChunkData)} is called.
     * <p>
     * Only this method is called if both this and
     * {@link #shouldGenerateNoise()} are overridden.
     *
     * @param worldInfo 此区块将用于的世界的世界信息
     * @param random 要使用的随机数生成器
     * @param chunkX 区块的X坐标
     * @param chunkZ 区块的Z坐标
     * @return 如果服务器应该生成原版噪声则返回true
     * @see #shouldGenerateNoise()
     */
    public boolean shouldGenerateNoise(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ) {
        return shouldGenerateNoise();
    }

    /**
     * 获取服务器是否应该生成原版表面.
     * <p>
     * 原文：
     * Gets if the server should generate Vanilla surface.
     * <p>
     * The Vanilla surface is generated <b>before</b>
     * {@link #generateSurface(WorldInfo, Random, int, int, ChunkData)} is
     * called.
     * <p>
     * This is method is not called (and has therefore no effect), if
     * {@link #shouldGenerateSurface(WorldInfo, Random, int, int)} is overridden.
     *
     * @return 如果服务器应该生成原版表面则返回true
     * @see #shouldGenerateSurface(WorldInfo, Random, int, int)
     */
    public boolean shouldGenerateSurface() {
        return false;
    }

    /**
     * 获取服务器是否应该生成原版表面.
     * <p>
     * 原文：
     * Gets if the server should generate Vanilla surface.
     * <p>
     * The Vanilla surface is generated <b>before</b>
     * {@link #generateSurface(WorldInfo, Random, int, int, ChunkData)} is
     * called.
     * <p>
     * Only this method is called if both this and
     * {@link #shouldGenerateSurface()} are overridden.
     *
     * @param worldInfo 此区块将用于的世界的世界信息
     * @param random 要使用的随机数生成器
     * @param chunkX 区块的X坐标
     * @param chunkZ 区块的Z坐标
     * @return 如果服务器应该生成原版表面则返回true
     * @see #shouldGenerateSurface()
     */
    public boolean shouldGenerateSurface(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ) {
        return shouldGenerateSurface();
    }

    /**
     * 获取服务器是否应该生成原版基岩.
     * <p>
     * 原文：
     * Gets if the server should generate Vanilla bedrock.
     * <p>
     * The Vanilla bedrock is generated <b>before</b>
     * {@link #generateBedrock(WorldInfo, Random, int, int, ChunkData)} is
     * called.
     *
     * @return 如果服务器应该生成原版基岩则返回true
     * @deprecated 无效果，基岩生成是表面步骤的一部分，参见 {@link #shouldGenerateSurface()}
     */
    @Deprecated(since = "1.19.2")
    public boolean shouldGenerateBedrock() {
        return false;
    }

    /**
     * 获取服务器是否应该生成原版洞穴.
     * <p>
     * 原文：
     * Gets if the server should generate Vanilla caves.
     * <p>
     * The Vanilla caves are generated <b>before</b>
     * {@link #generateCaves(WorldInfo, Random, int, int, ChunkData)} is called.
     * <p>
     * This is method is not called (and has therefore no effect), if
     * {@link #shouldGenerateCaves(WorldInfo, Random, int, int)} is overridden.
     *
     * @return 如果服务器应该生成原版洞穴则返回true
     * @see #shouldGenerateCaves(WorldInfo, Random, int, int)
     */
    public boolean shouldGenerateCaves() {
        return false;
    }

    /**
     * 获取服务器是否应该生成原版洞穴.
     * <p>
     * 原文：
     * Gets if the server should generate Vanilla caves.
     * <p>
     * The Vanilla caves are generated <b>before</b>
     * {@link #generateCaves(WorldInfo, Random, int, int, ChunkData)} is called.
     * <p>
     * Only this method is called if both this and
     * {@link #shouldGenerateCaves()} are overridden.
     *
     * @param worldInfo 此区块将用于的世界的世界信息
     * @param random 要使用的随机数生成器
     * @param chunkX 区块的X坐标
     * @param chunkZ 区块的Z坐标
     * @return 如果服务器应该生成原版洞穴则返回true
     * @see #shouldGenerateCaves()
     */
    public boolean shouldGenerateCaves(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ) {
        return shouldGenerateCaves();
    }
    /**
     * 获取服务器是否应该在此ChunkGenerator之后生成原版装饰.
     * <p>
     * 原文：
     * Gets if the server should generate Vanilla decorations after this
     * ChunkGenerator.
     * <p>
     * The Vanilla decoration are generated <b>before</b> any
     * {@link BlockPopulator} are called.
     * <p>
     * This is method is not called (and has therefore no effect), if
     * {@link #shouldGenerateDecorations(WorldInfo, Random, int, int)} is overridden.
     *
     * @return 如果服务器应该生成原版装饰则返回true
     * @see #shouldGenerateDecorations(WorldInfo, Random, int, int)
     */
    public boolean shouldGenerateDecorations() {
        return false;
    }

    /**
     * 获取服务器是否应该在此ChunkGenerator之后生成原版装饰.
     * <p>
     * 原文：
     * Gets if the server should generate Vanilla decorations after this
     * ChunkGenerator.
     * <p>
     * The Vanilla decoration are generated <b>before</b> any
     * {@link BlockPopulator} are called.
     * <p>
     * Only this method is called if both this and
     * {@link #shouldGenerateDecorations()} are overridden.
     *
     * @param worldInfo 此区块将用于的世界的世界信息
     * @param random 要使用的随机数生成器
     * @param chunkX 区块的X坐标
     * @param chunkZ 区块的Z坐标
     * @return 如果服务器应该生成原版装饰则返回true
     * @see #shouldGenerateDecorations()
     */
    public boolean shouldGenerateDecorations(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ) {
        return shouldGenerateDecorations();
    }

    /**
     * 获取服务器是否应该在此ChunkGenerator之后生成原版生物.
     * <p>
     * 原文：
     * Gets if the server should generate Vanilla mobs after this
     * ChunkGenerator.
     * <p>
     * This is method is not called (and has therefore no effect), if
     * {@link #shouldGenerateMobs(WorldInfo, Random, int, int)} is overridden.
     *
     * @return 如果服务器应该生成原版生物则返回true
     * @see #shouldGenerateMobs(WorldInfo, Random, int, int)
     */
    public boolean shouldGenerateMobs() {
        return false;
    }

    /**
     * 获取服务器是否应该在此ChunkGenerator之后生成原版生物.
     * <p>
     * 原文：
     * Gets if the server should generate Vanilla mobs after this
     * ChunkGenerator.
     * <p>
     * Only this method is called if both this and
     * {@link #shouldGenerateMobs()} are overridden.
     *
     * @param worldInfo 此区块将用于的世界的世界信息
     * @param random 要使用的随机数生成器
     * @param chunkX 区块的X坐标
     * @param chunkZ 区块的Z坐标
     * @return 如果服务器应该生成原版生物则返回true
     * @see #shouldGenerateMobs()
     */
    public boolean shouldGenerateMobs(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ) {
        return shouldGenerateMobs();
    }

    /**
     * 获取服务器是否应该在此ChunkGenerator之后生成原版结构.
     * <p>
     * 原文：
     * Gets if the server should generate Vanilla structures after this
     * ChunkGenerator.
     * <p>
     * This is method is not called (and has therefore no effect), if
     * {@link #shouldGenerateStructures(WorldInfo, Random, int, int)} is overridden.
     *
     * @return 如果服务器应该生成原版结构则返回true
     * @see #shouldGenerateStructures(WorldInfo, Random, int, int)
     */
    public boolean shouldGenerateStructures() {
        return false;
    }

    /**
     * 获取服务器是否应该在此ChunkGenerator之后生成原版结构.
     * <p>
     * 原文：
     * Gets if the server should generate Vanilla structures after this
     * ChunkGenerator.
     * <p>
     * Only this method is called if both this and
     * {@link #shouldGenerateStructures()} are overridden.
     *
     * @param worldInfo 此区块将用于的世界的世界信息
     * @param random 要使用的随机数生成器
     * @param chunkX 区块的X坐标
     * @param chunkZ 区块的Z坐标
     * @return 如果服务器应该生成原版结构则返回true
     * @see #shouldGenerateStructures()
     */
    public boolean shouldGenerateStructures(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ) {
        return shouldGenerateStructures();
    }

    /**
     * 区块的数据.
     */
    public static interface ChunkData {
        /**
         * 获取此ChunkData的最小高度.
         * <p>
         * 原文：
         * Get the minimum height for this ChunkData.
         * <p>
         * It is not guaranteed that this method will return the same value as
         * {@link World#getMinHeight()}.
         * <p>
         * Setting blocks below this height will do nothing.
         *
         * @return 最小高度
         */
        public int getMinHeight();

        /**
         * 获取此ChunkData的最大高度.
         * <p>
         * 原文：
         * Get the maximum height for this ChunkData.
         * <p>
         * It is not guaranteed that this method will return the same value as
         * {@link World#getMaxHeight()}.
         * <p>
         * Setting blocks at or above this height will do nothing.
         *
         * @return 最大高度
         */
        public int getMaxHeight();

        /**
         * 获取在区块内x, y, z位置的生物群系.
         * <p>
         * 原文：
         * Get the biome at x, y, z within chunk being generated
         *
         * @param x 区块中的x位置，范围0-15（包含）
         * @param y 区块中的y位置，范围从最小高度（包含）到最大高度（不包含）
         * @param z 区块中的z位置，范围0-15（包含）
         * @return 生物群系值
         */
        @NotNull
        public Biome getBiome(int x, int y, int z);

        /**
         * 将区块数据中x,y,z位置的方块设置为指定材质.
         * <p>
         * 原文：
         * Set the block at x,y,z in the chunk data to material.
         *
         * Note: setting blocks outside the chunk's bounds does nothing.
         *
         * @param x 区块中的x位置，范围0-15（包含）
         * @param y 区块中的y位置，范围从最小高度（包含）到最大高度（不包含）
         * @param z 区块中的z位置，范围0-15（包含）
         * @param material 要设置的方块类型
         */
        public void setBlock(int x, int y, int z, @NotNull Material material);

        /**
         * 将区块数据中x,y,z位置的方块设置为指定材质.
         * <p>
         * 原文：
         * Set the block at x,y,z in the chunk data to material.
         *
         * Setting blocks outside the chunk's bounds does nothing.
         *
         * @param x 区块中的x位置，范围0-15（包含）
         * @param y 区块中的y位置，范围从最小高度（包含）到最大高度（不包含）
         * @param z 区块中的z位置，范围0-15（包含）
         * @param material 要设置的方块类型
         */
        public void setBlock(int x, int y, int z, @NotNull MaterialData material);

        /**
         * 将区块数据中x,y,z位置的方块设置为指定方块数据.
         * <p>
         * 原文：
         * Set the block at x,y,z in the chunk data to material.
         *
         * Setting blocks outside the chunk's bounds does nothing.
         *
         * @param x 区块中的x位置，范围0-15（包含）
         * @param y 区块中的y位置，范围从最小高度（包含）到最大高度（不包含）
         * @param z 区块中的z位置，范围0-15（包含）
         * @param blockData 要设置的方块数据
         */
        public void setBlock(int x, int y, int z, @NotNull BlockData blockData);

        /**
         * 将区块中从xMin, yMin, zMin（包含）到xMax, yMax, zMax（不包含）的区域设置为指定材质.
         * <p>
         * 原文：
         * Set a region of this chunk from xMin, yMin, zMin (inclusive)
         * to xMax, yMax, zMax (exclusive) to material.
         *
         * Setting blocks outside the chunk's bounds does nothing.
         *
         * @param xMin 要设置的区块中最小x位置（包含）
         * @param yMin 要设置的区块中最小y位置（包含）
         * @param zMin 要设置的区块中最小z位置（包含）
         * @param xMax 要设置的区块中最大x位置（不包含）
         * @param yMax 要设置的区块中最大y位置（不包含）
         * @param zMax 要设置的区块中最大z位置（不包含）
         * @param material 要设置的方块类型
         */
        public void setRegion(int xMin, int yMin, int zMin, int xMax, int yMax, int zMax, @NotNull Material material);

        /**
         * 将区块中从xMin, yMin, zMin（包含）到xMax, yMax, zMax（不包含）的区域设置为指定材质.
         * <p>
         * 原文：
         * Set a region of this chunk from xMin, yMin, zMin (inclusive)
         * to xMax, yMax, zMax (exclusive) to material.
         *
         * Setting blocks outside the chunk's bounds does nothing.
         *
         * @param xMin 要设置的区块中最小x位置（包含）
         * @param yMin 要设置的区块中最小y位置（包含）
         * @param zMin 要设置的区块中最小z位置（包含）
         * @param xMax 要设置的区块中最大x位置（不包含）
         * @param yMax 要设置的区块中最大y位置（不包含）
         * @param zMax 要设置的区块中最大z位置（不包含）
         * @param material 要设置的方块类型
         */
        public void setRegion(int xMin, int yMin, int zMin, int xMax, int yMax, int zMax, @NotNull MaterialData material);

        /**
         * 将区块中从xMin, yMin, zMin（包含）到xMax, yMax, zMax（不包含）的区域设置为指定材质.
         * <p>
         * 原文：
         * Set a region of this chunk from xMin, yMin, zMin (inclusive)
         * to xMax, yMax, zMax (exclusive) to material.
         *
         * Setting blocks outside the chunk's bounds does nothing.
         *
         * @param xMin 要设置的区块中最小x位置（包含）
         * @param yMin 要设置的区块中最小y位置（包含）
         * @param zMin 要设置的区块中最小z位置（包含）
         * @param xMax 要设置的区块中最大x位置（不包含）
         * @param yMax 要设置的区块中最大y位置（不包含）
         * @param zMax 要设置的区块中最大z位置（不包含）
         * @param material 要设置的方块类型
         */
        public void setRegion(int xMin, int yMin, int zMin, int xMax, int yMax, int zMax, @NotNull BlockData blockData);

        /**
         * 获取x, y, z位置的方块类型.
         * <p>
         * 原文：
         * Get the type of the block at x, y, z.
         *
         * Getting blocks outside the chunk's bounds returns air.
         *
         * @param x 区块中的x位置，范围0-15（包含）
         * @param y 区块中的y位置，范围从最小高度（包含）到最大高度（不包含）
         * @param z 区块中的z位置，范围0-15（包含）
         * @return 方块的类型，如果x, y或z超出区块边界则返回Material.AIR
         */
        @NotNull
        public Material getType(int x, int y, int z);

        /**
         * 获取x, y, z位置的方块类型和数据.
         * <p>
         * 原文：
         * Get the type and data of the block at x, y, z.
         *
         * Getting blocks outside the chunk's bounds returns air.
         *
         * @param x 区块中的x位置，范围0-15（包含）
         * @param y 区块中的y位置，范围从最小高度（包含）到最大高度（不包含）
         * @param z 区块中的z位置，范围0-15（包含）
         * @return 方块的类型和数据，如果x, y或z超出区块边界则返回空气的MaterialData
         */
        @NotNull
        public MaterialData getTypeAndData(int x, int y, int z);

        /**
         * 获取x, y, z位置的方块数据.
         * <p>
         * 原文：
         * Get the type and data of the block at x, y, z.
         *
         * Getting blocks outside the chunk's bounds returns air.
         *
         * @param x 区块中的x位置，范围0-15（包含）
         * @param y 区块中的y位置，范围从最小高度（包含）到最大高度（不包含）
         * @param z 区块中的z位置，范围0-15（包含）
         * @return 方块的数据，如果x, y或z超出区块边界则返回空气的BlockData
         */
        @NotNull
        public BlockData getBlockData(int x, int y, int z);

        /**
         * 获取区块数据中x,y,z位置的方块数据.
         * <p>
         * 原文：
         * Get the block data at x,y,z in the chunk data.
         *
         * Getting blocks outside the chunk's bounds returns 0.
         *
         * @param x 区块中的x位置，范围0-15（包含）
         * @param y 区块中的y位置，范围从最小高度（包含）到最大高度（不包含）
         * @param z 区块中的z位置，范围0-15（包含）
         * @return 方块的数据值，如果x, y或z超出区块边界则返回空气
         * @deprecated 使用魔法值
         */
        @Deprecated(since = "1.8.8")
        public byte getData(int x, int y, int z);
    }
}