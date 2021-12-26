package org.bukkit;

import java.util.Collection;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一个16*256*16的空间
 */
public interface Chunk extends PersistentDataHolder {

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
    @NotNull
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
    @NotNull
    Block getBlock(int x, int y, int z);

    /**
     * Capture thread-safe read-only snapshot of chunk data
     *
     * @return ChunkSnapshot
     */
    @NotNull
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
    @NotNull
    ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome, boolean includeBiomeTempRain);

    /**
     * Checks if entities in this chunk are loaded.
     *
     * @return True if entities are loaded.
     */
    boolean isEntitiesLoaded();

    /**
     * 获取该区块内的所有实体.
     * 这将强制加载尚未加载的任意实体. 
     * <p>
     * 原文:Get a list of all entities in the chunk.
     * This will force load any entities, which are not loaded.
     *
     * @return 所有实体
     */
    @NotNull
    Entity[] getEntities();

    /**
     * 获取该区块内所有的TileEntity的列表.
     * <p>
     * 原文:Get a list of all tile entities in the chunk.
     * 
     * @return 实体列表数组
     */
    @NotNull
    BlockState[] getTileEntities();

    /**
     * 返回该区块是否被加载.
     * <p>
     * 原文:Checks if the chunk is loaded.
     * 
     * @return 成功加载返回true,否则返回false
     */
    boolean isLoaded();

    /**
     * 加载区块.
     * <p>
     * 原文:Loads the chunk.
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

    /**
     * Gets whether the chunk at the specified chunk coordinates is force
     * loaded.
     * <p>
     * A force loaded chunk will not be unloaded due to lack of player activity.
     *
     * @return force load status
     * @see World#isChunkForceLoaded(int, int)
     */
    boolean isForceLoaded();

    /**
     * Sets whether the chunk at the specified chunk coordinates is force
     * loaded.
     * <p>
     * A force loaded chunk will not be unloaded due to lack of player activity.
     *
     * @param forced force load status
     * @see World#setChunkForceLoaded(int, int, boolean)
     */
    void setForceLoaded(boolean forced);

    /**
     * Adds a plugin ticket for this chunk, loading this chunk if it is not
     * already loaded.
     * <p>
     * A plugin ticket will prevent a chunk from unloading until it is
     * explicitly removed. A plugin instance may only have one ticket per chunk,
     * but each chunk can have multiple plugin tickets.
     * </p>
     *
     * @param plugin Plugin which owns the ticket
     * @return {@code true} if a plugin ticket was added, {@code false} if the
     * ticket already exists for the plugin
     * @throws IllegalStateException If the specified plugin is not enabled
     * @see World#addPluginChunkTicket(int, int, Plugin)
     */
    boolean addPluginChunkTicket(@NotNull Plugin plugin);

    /**
     * Removes the specified plugin's ticket for this chunk
     * <p>
     * A plugin ticket will prevent a chunk from unloading until it is
     * explicitly removed. A plugin instance may only have one ticket per chunk,
     * but each chunk can have multiple plugin tickets.
     * </p>
     *
     * @param plugin Plugin which owns the ticket
     * @return {@code true} if the plugin ticket was removed, {@code false} if
     * there is no plugin ticket for the chunk
     * @see World#removePluginChunkTicket(int, int, Plugin)
     */
    boolean removePluginChunkTicket(@NotNull Plugin plugin);

    /**
     * Retrieves a collection specifying which plugins have tickets for this
     * chunk. This collection is not updated when plugin tickets are added or
     * removed to this chunk.
     * <p>
     * A plugin ticket will prevent a chunk from unloading until it is
     * explicitly removed. A plugin instance may only have one ticket per chunk,
     * but each chunk can have multiple plugin tickets.
     * </p>
     *
     * @return unmodifiable collection containing which plugins have tickets for
     * this chunk
     * @see World#getPluginChunkTickets(int, int)
     */
    @NotNull
    Collection<Plugin> getPluginChunkTickets();

    /**
     * Gets the amount of time in ticks that this chunk has been inhabited.
     *
     * Note that the time is incremented once per tick per player in the chunk.
     *
     * @return inhabited time
     */
    long getInhabitedTime();

    /**
     * Sets the amount of time in ticks that this chunk has been inhabited.
     *
     * @param ticks new inhabited time
     */
    void setInhabitedTime(long ticks);

    /**
     * Tests if this chunk contains the specified block.
     *
     * @param block block to test
     * @return if the block is contained within
     */
    boolean contains(@NotNull BlockData block);
}
