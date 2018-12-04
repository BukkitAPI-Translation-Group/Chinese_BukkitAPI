package org.bukkit;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

/**
 * 代表一个16*256*16的空间
 */
public interface Chunk {

    /**
     * 获取该区块的X轴坐标.
     * <p>
     * 原文:Gets the X-coordinate of this chunk
     *
     * @return 区块X轴坐标
     */
    int getX();

    /**
     * 获取该区块的Z轴坐标.
     * <p>
     * Gets the Z-coordinate of this chunk
     *
     * @return 区块的Z轴坐标
     */
    int getZ();

    /**
     * 获取该区块属于哪个世界.
     * <p>
     * 原文:Gets the world containing this chunk
     *
     * @return 世界名
     */
    World getWorld();

    /**
     * 从区块中获取某个方块({@link Block}).
     * <p>
     * 原文:Gets a block from this chunk
     *
     * @param x 获取方块的X轴坐标,在0-15之间
     * @param y 获取方块的Y轴坐标,在0-255之间
     * @param z 获取方块的Z轴坐标,在0-15之间
     * @return 方块对象
     */
    Block getBlock(int x, int y, int z);

    /**
     * Capture thread-safe read-only snapshot of chunk data
     *
     * @return ChunkSnapshot
     */
    ChunkSnapshot getChunkSnapshot();

    /**
     * Capture thread-safe read-only snapshot of chunk data
     *
     * @param includeMaxblocky - if true, snapshot includes per-coordinate
     *     maximum Y values
     * @param includeBiome - if true, snapshot includes per-coordinate biome
     *     type
     * @param includeBiomeTempRain - if true, snapshot includes per-coordinate
     *     raw biome temperature and rainfall
     * @return ChunkSnapshot
     */
    ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome, boolean includeBiomeTempRain);

    /**
     * 获取该区块内所有实体({@link Entity})列表数组. <p>
     * Get a list of all entities in the chunk.
     *
     * @return The entities.
     */
    Entity[] getEntities();

    /**
     * 获取该区块内所有的TileEntity的列表.
     * <p>
     * 原文:Get a list of all tile entities in the chunk.
     * 
     * @return 实体列表数组
     */
    BlockState[] getTileEntities();

    /**
     * 返回该区块是否被加载.
     * <p>
     * 原文:Checks if the chunk is loaded.
     * 
     * @return 成功加载返回true,否则返回false
     */
    boolean isLoaded();
    //TODO
    /**
     * 加载区块.
     * 
     * @param generate 如果该区块不存在是否自动生成
     * @return 成功加载返回true,反之返回false
     */
    boolean load(boolean generate);

    /**
     * 加载区块.
     *
     * @return 成功加载返回true,反之返回false
     */
    boolean load();

    /**
     * 卸载并可选是否保存区块-安全模式.
     * <p>
     * 原文:Unloads and optionally saves the Chunk
     * 
     * @param save 卸载时是否保存
     * @param safe 当该区块内存在玩家时是否继续卸载
     * @return 成功卸载返回true,反之返回false
     * @deprecated 移除一个正在使用的区块从不安全
     */
    @Deprecated
    boolean unload(boolean save, boolean safe);

    /**
     * 卸载该区块.可以选择是否保存.
     * <p>
     * 原文:Unloads and optionally saves the Chunk
     *
     * @param save 卸载时是否保存.
     * @return 成功卸载返回true,反之返回false
     */
    boolean unload(boolean save);

    /**
     * 卸载并可选是否保存区块.
     * <p>
     * 原文:Unloads and optionally saves the Chunk
     *
     * @return 成功卸载返回true,反之返回false
     */
    boolean unload();
 
    /**
     * Checks if this chunk can spawn slimes without being a swamp biome.
     *
     * @return true if slimes are able to spawn in this chunk
     */
    boolean isSlimeChunk();
}
