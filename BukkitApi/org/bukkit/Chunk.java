package org.bukkit;

import java.util.Collection;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.generator.structure.GeneratedStructure;
import org.bukkit.generator.structure.Structure;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一个16*256*16的空间.
 * <p>
 * 如果区块尚未完全生成，但又被请求了数据，那么区块只会生成到足以提供所请求数据的程度。
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
     * 原文:Gets the Z-coordinate of this chunk
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
     * @param y 获取方块的Y轴坐标,在 [世界最低高度, 世界最高高度) 之间
     * @param z 获取方块的Z轴坐标,在0-15之间
     * @return 方块对象
     */
    @NotNull
    Block getBlock(int x, int y, int z);

    /**
     * 获取区块数据的线程安全只读快照.
     * <p>
     * 原文:Capture thread-safe read-only snapshot of chunk data
     *
     * @return 区块快照
     */
    @NotNull
    ChunkSnapshot getChunkSnapshot();

    /**
     * 获取区块数据的线程安全只读快照.
     * <p>
     * 原文:Capture thread-safe read-only snapshot of chunk data
     *
     * @param includeMaxblocky 如果为true，快照将包含每个坐标的最大Y轴高度值
     * @param includeBiome 如果为true，快照将包含每个坐标的生物群系类型
     * @param includeBiomeTempRain 如果为true，快照将包含每个坐标的原始生物群系温度和降雨量
     * @return 区块快照
     */
    @NotNull
    ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome, boolean includeBiomeTempRain);

    /**
     * 检查此区块中的实体是否已加载.
     * <p>
     * 原文:Checks if entities in this chunk are loaded.
     *
     * @return 如果实体已加载则返回true
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
     * 检查区块是否已完全生成.
     * <p>
     * 原文:Checks if the chunk is fully generated.
     *
     * @return 如果已完全生成则返回true
     */
    boolean isGenerated();

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
     * 检查此区块是否能在非沼泽生物群系中生成史莱姆.
     * <p>
     * 原文:Checks if this chunk can spawn slimes without being a swamp biome.
     *
     * @return 如果史莱姆能在此区块生成则返回true
     */
    boolean isSlimeChunk();

    /**
     * 获取指定坐标处的区块是否被强制加载.
     * <p>
     * 强制加载的区块不会因为缺少玩家活动而被卸载.
     * <p>
     * 原文:Gets whether the chunk at the specified chunk coordinates is force loaded.
     *
     * @return 强制加载状态
     * @see World#isChunkForceLoaded(int, int)
     */
    boolean isForceLoaded();

    /**
     * 设置指定坐标处的区块是否被强制加载.
     * <p>
     * 强制加载的区块不会因为缺少玩家活动而被卸载.
     * <p>
     * 原文:Sets whether the chunk at the specified chunk coordinates is force loaded.
     *
     * @param forced 强制加载状态
     * @see World#setChunkForceLoaded(int, int, boolean)
     */
    void setForceLoaded(boolean forced);

    /**
     * 为此区块添加一个插件票据，如果区块尚未加载则会加载该区块.
     * <p>
     * 插件票据会阻止区块被卸载，直到被显式移除。每个插件实例在每个区块上只能有一个票据，但每个区块可以有多个插件票据.
     * <p>
     * 原文:Adds a plugin ticket for this chunk, loading this chunk if it is not already loaded.
     *
     * @param plugin 拥有该票据的插件
     * @return 如果添加了插件票据则返回{@code true}，如果该插件的票据已存在则返回{@code false}
     * @throws IllegalStateException 如果指定的插件未启用
     * @see World#addPluginChunkTicket(int, int, Plugin)
     */
    boolean addPluginChunkTicket(@NotNull Plugin plugin);

    /**
     * 移除指定插件在此区块上的票据.
     * <p>
     * 插件票据会阻止区块被卸载，直到被显式移除。每个插件实例在每个区块上只能有一个票据，但每个区块可以有多个插件票据.
     * <p>
     * 原文:Removes the specified plugin's ticket for this chunk
     *
     * @param plugin 拥有该票据的插件
     * @return 如果移除了插件票据则返回{@code true}，如果该区块没有该插件的票据则返回{@code false}
     * @see World#removePluginChunkTicket(int, int, Plugin)
     */
    boolean removePluginChunkTicket(@NotNull Plugin plugin);

    /**
     * 获取指定哪些插件在此区块拥有票据的集合。当插件票据被添加或移除时，此集合不会更新.
     * <p>
     * 插件票据会阻止区块被卸载，直到被显式移除。每个插件实例在每个区块上只能有一个票据，但每个区块可以有多个插件票据.
     * <p>
     * 原文:Retrieves a collection specifying which plugins have tickets for this chunk.
     *
     * @return 包含在此区块拥有票据的插件的不可修改集合
     * @see World#getPluginChunkTickets(int, int)
     */
    @NotNull
    Collection<Plugin> getPluginChunkTickets();

    /**
     * 获取此区块已被居住的时间（以tick为单位）.
     * <p>
     * 注意：对于在怪物生成距离内的每个玩家，每个tick时间会增加一次.
     * <p>
     * 原文:Gets the amount of time in ticks that this chunk has been inhabited.
     *
     * @return 已被居住的时间
     */
    long getInhabitedTime();

    /**
     * 设置此区块已被居住的时间（以tick为单位）.
     * <p>
     * 原文:Sets the amount of time in ticks that this chunk has been inhabited.
     *
     * @param ticks 新的居住时间
     */
    void setInhabitedTime(long ticks);

    /**
     * 测试此区块是否包含指定的方块.
     * <p>
     * 原文:Tests if this chunk contains the specified block.
     *
     * @param block 要测试的方块
     * @return 如果区块包含该方块则返回true
     */
    boolean contains(@NotNull BlockData block);

    /**
     * 测试此区块是否包含指定的生物群系.
     * <p>
     * 原文:Tests if this chunk contains the specified biome.
     *
     * @param biome 要测试的生物群系
     * @return 如果区块包含该生物群系则返回true
     */
    boolean contains(@NotNull Biome biome);

    /**
     * 获取此区块的加载级别，该级别决定了会处理哪些游戏逻辑.
     * <p>
     * 原文:Gets the load level of this chunk, which determines what game logic is processed.
     *
     * @return 加载级别
     */
    @NotNull
    LoadLevel getLoadLevel();

    /**
     * 获取与此区块相交的所有已生成结构.
     * <p>
     * 如果没有结构存在，将返回空集合.
     * <p>
     * 原文:Gets all generated structures that intersect this chunk.
     *
     * @return 此区块中已放置结构的集合
     */
    @NotNull
    Collection<GeneratedStructure> getStructures();

    /**
     * 获取与此区块相交的所有给定 {@link Structure} 类型的已生成结构.
     * <p>
     * 如果没有结构存在，将返回空集合.
     * <p>
     * 原文:Gets all generated structures of a given {@link Structure} that intersect this chunk.
     *
     * @param structure 要查找的结构类型
     * @return 此区块中已放置结构的集合
     */
    @NotNull
    Collection<GeneratedStructure> getStructures(@NotNull Structure structure);

    /**
     * 获取所有能从客户端查看此区块的玩家列表.
     * <p>
     * 如果没有玩家正在查看此区块，或区块已卸载，则此列表为空.
     * <p>
     * 原文:Get a list of all players who are can view the chunk from their client
     *
     * @return 能看到此区块的玩家集合
     */
    @NotNull
    public Collection<Player> getPlayersSeeingChunk();

    /**
     * 用于指定区块加载级别的枚举.
     */
    public enum LoadLevel {

        /**
         * 不处理任何游戏逻辑，但世界生成可能仍然发生.
         */
        INACCESSIBLE,
        /**
         * 大部分游戏逻辑不会被处理，包括实体和红石.
         */
        BORDER,
        /**
         * 除实体外的所有游戏逻辑都会被处理.
         */
        TICKING,
        /**
         * 所有游戏逻辑都会被处理.
         */
        ENTITY_TICKING,
        /**
         * 此区块未加载.
         */
        UNLOADED;
    }
}
