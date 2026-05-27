package org.bukkit;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.boss.DragonBattle;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Item;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.SpawnCategory;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.bukkit.generator.structure.GeneratedStructure;
import org.bukkit.generator.structure.Structure;
import org.bukkit.generator.structure.StructureType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.Metadatable;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.messaging.PluginMessageRecipient;
import org.bukkit.util.BiomeSearchResult;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.StructureSearchResult;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一个世界,包含了{@link Entity 实体},{@link Chunk 区块},{@link Block 方块}
 */
public interface World extends RegionAccessor, WorldInfo, PluginMessageRecipient, Metadatable, PersistentDataHolder, Keyed {

    /**
     * 获取坐标所指的{@link Block 方块}.
     * <p>
     * 原文：Gets the {@link Block} at the given coordinates
     *
     * @param x 方块的X坐标
     * @param y 方块的Y坐标
     * @param z 方块的Z坐标
     * @return 在指定坐标的方块
     */
    @NotNull
    public Block getBlockAt(int x, int y, int z);

    /**
     * 获取指定{@link Location 位置}的{@link Block 方块}.
     * <p>
     * 原文：Gets the {@link Block} at the given {@link Location}
     *
     * @param location 要获取的方块的位置
     * @return 在指定位置的方块
     */
    @NotNull
    public Block getBlockAt(@NotNull Location location);

    /**
     * 获取指定坐标最高处不是空气且不可逾越的方块.
     * <p>
     * 原文:Gets the highest non-empty (impassable) block at the given coordinates.
     *
     * @param x 方块X坐标
     * @param z 方块Z坐标
     * @return 最高处不是空气的方块.
     */
    @NotNull
    public Block getHighestBlockAt(int x, int z);

    /**
     * 获取指定{@link Location 位置}最高处不是空气且不可逾越的方块.
     * <p>
     * 原文:Gets the highest non-empty (impassable) block at the given coordinates.
     *
     * @param location 需要获取最高的方块的位置
     * @return 最高的不是空气的方块
     */
    @NotNull
    public Block getHighestBlockAt(@NotNull Location location);

    /**
     * 获取给定坐标处对应于指定{@link HeightMap 高度映射}的最高方块.
     * <p>
     * 原文：Gets the highest block corresponding to the {@link HeightMap} at the
     * given coordinates.
     *
     * @param x 方块的X坐标
     * @param z 方块的Z坐标
     * @param heightMap 用于确定最高点的高度映射
     * @return 对应于指定{@link HeightMap 高度映射}的最高方块
     */
    @NotNull
    public Block getHighestBlockAt(int x, int z, @NotNull HeightMap heightMap);

    /**
     * 获取给定{@link Location 位置}处对应于指定{@link HeightMap 高度映射}的最高方块.
     * <p>
     * 原文：Gets the highest block corresponding to the {@link HeightMap} at the
     * given coordinates.
     *
     * @param location 获取最高方块的坐标位置
     * @param heightMap 用于确定最高点的高度映射
     * @return 对应于指定{@link HeightMap 高度映射}的最高方块
     */
    @NotNull
    public Block getHighestBlockAt(@NotNull Location location, @NotNull HeightMap heightMap);

    /**
     * 获取给定坐标所在的{@link Chunk 区块}.
     * <p>
     * 原文：Gets the {@link Chunk} at the given coordinates
     *
     * @param x X坐标
     * @param z Z坐标
     * @return 给定坐标所在的区块
     */
    @NotNull
    public Chunk getChunkAt(int x, int z);

    /**
     * 获取给定坐标所在的{@link Chunk 区块}.
     * <p>
     * 原文：Gets the {@link Chunk} at the given coordinates
     *
     * @param x 区块的X坐标
     * @param z 区块的Z坐标
     * @param generate 如果区块未完全生成, 是否应该被完整生成
     * @return 给定坐标所在的区块
     */
    @NotNull
    public Chunk getChunkAt(int x, int z, boolean generate);

    /**
     * 获取给定{@link Location 位置}所在的{@link Chunk 区块}.
     * <p>
     * 原文：
     * Gets the {@link Chunk} at the given {@link Location}
     *
     * @param location 方块的位置
     * @return 给定位置的区块
     */
    @NotNull
    public Chunk getChunkAt(@NotNull Location location);

    /**
     * 获取这个{@link Block 方块}所处的{@link Chunk 区块}.
     * <p>
     * 原文：
     * Gets the {@link Chunk} that contains the given {@link Block}
     *
     * @param block 需要检测的方块
     * @return 方块所处的区块
     */
    @NotNull
    public Chunk getChunkAt(@NotNull Block block);

    /**
     * 检查指定{@link Chunk 区块}是否已经被加载.
     * <p>
     * 原文：
     * Checks if the specified {@link Chunk} is loaded
     *
     * @param chunk 需要检查的区块
     * @return 如果区块已经被加载则返回true，否则返回false
     */
    public boolean isChunkLoaded(@NotNull Chunk chunk);

    /**
     * 获取一个所有被加载的{@link Chunk 区块}的数组.
     * <p>
     * 原文：
     * Gets an array of all loaded {@link Chunk}s
     *
     * @return 包含所有被加载区块的数组Chunk[]
     */
    @NotNull
    public Chunk[] getLoadedChunks();

    /**
     * 加载指定的{@link Chunk 区块}.
     * <p>
     * <b>本方法将使指定的区块保持加载状态直到卸载方法被手动调用.
     * 建议开发者使用 getChunkAt 方法, 其方法只会临时加载请求的区块, 而不是本方法.</b>
     * <p>
     * 原文：
     * Loads the specified {@link Chunk}.
     * <p>
     * <b>This method will keep the specified chunk loaded until one of the
     * unload methods is manually called. Callers are advised to instead use
     * getChunkAt which will only temporarily load the requested chunk.</b>
     *
     * @param chunk 待加载的区块
     */
    public void loadChunk(@NotNull Chunk chunk);

    /**
     * 检查在指定坐标的{@link Chunk 区块}是否被加载.
     * <p>
     * 原文：
     * Checks if the {@link Chunk} at the specified coordinates is loaded
     *
     * @param x 区块的x坐标
     * @param z 区块的z坐标
     * @return 如果区块已经被加载则返回true，否则返回false
     */
    public boolean isChunkLoaded(int x, int z);

    /**
     * 检查指定坐标处的{@link Chunk 区块}是否已生成.
     * <p>
     * 原文:Checks if the {@link Chunk} at the specified coordinates is generated
     *
     * @param x 区块x坐标
     * @param z 区块z坐标
     * @return 区块已生成则返回true, 反之为false
     */
    public boolean isChunkGenerated(int x, int z);

    /**
     * 检查指定坐标的{@link Chunk 区块}是否被加载且被一个或更多的玩家使用.
     * <p>
     * 原文：
     * Checks if the {@link Chunk} at the specified coordinates is loaded and
     * in use by one or more players
     *
     * @param x 区块的x坐标
     * @param z 区块的z坐标
     * @return 如果区块被加载且被一个或更多的玩家使用则返回true，否则返回false
     * @deprecated 本方法曾被添加用于促进区块的垃圾回收.
     * 由于当前 Minecraft 的区块被严格管理, 并且除非那些区块正被使用, 否则不会加载超过1tick时长
     * (意思是mc现在对区块管理更好了, 不用的区块会被及时卸载并回收)
     */
    @Deprecated(since = "1.14")
    public boolean isChunkInUse(int x, int z);

    /**
     * 加载指定坐标的{@link Chunk 区块}.
     * <p>
     * <b>本方法将使指定的区块保持加载状态直到卸载方法被手动调用.
     * 建议开发者使用 getChunkAt 方法, 其方法只会临时加载请求的区块, 而不是本方法.</b>
     * <p>
     * 如果区块不存在则会被生成。
     * <p>
     * 这个方法类似于当generate值为true时的{@link #loadChunk(int, int, boolean)}.
     * <p>
     * 原文：
     * Loads the {@link Chunk} at the specified coordinates.
     * <p>
     * <b>This method will keep the specified chunk loaded until one of the
     * unload methods is manually called. Callers are advised to instead use
     * getChunkAt which will only temporarily load the requested chunk.</b>
     * <p>
     * If the chunk does not exist, it will be generated.
     * <p>
     * This method is analogous to {@link #loadChunk(int, int, boolean)} where
     * generate is true.
     *
     * @param x 区块的x坐标
     * @param z 区块的z坐标
     */
    public void loadChunk(int x, int z);

    /**
     * 加载指定坐标的{@link Chunk 区块}.
     * <p>
     * <b>本方法将使指定的区块保持加载状态直到卸载方法被手动调用.
     * 建议开发者使用 getChunkAt 方法, 其方法只会临时加载请求的区块, 而不是本方法.</b>
     * <p>
     * 原文：
     * Loads the {@link Chunk} at the specified coordinates.
     * <p>
     * <b>This method will keep the specified chunk loaded until one of the
     * unload methods is manually called. Callers are advised to instead use
     * getChunkAt which will only temporarily load the requested chunk.</b>
     *
     * @param x 区块的x坐标
     * @param z 区块的z坐标
     * @param generate 如果区块不存在是否生成
     * @return 如果区块被成功加载则返回true，否则返回false
     */
    public boolean loadChunk(int x, int z, boolean generate);

    /**
     * 安全的卸载并保存指定坐标的{@link Chunk 区块}.
     * <p>
     * 这个方法类似于当safe值为true时的{@link #unloadChunk(int, int, boolean)}.
     * <p>
     * 原文：
     * Safely unloads and saves the {@link Chunk} at the specified coordinates
     * <p>
     * This method is analogous to {@link #unloadChunk(int, int, boolean)}
     * where save is true.
     *
     * @param chunk 卸载的区块
     * @return 如果区块被成功卸载则返回true，否则返回false
     */
    public boolean unloadChunk(@NotNull Chunk chunk);

    /**
     * 安全的卸载并保存指定坐标的{@link Chunk 区块}.
     * <p>
     * 这个方法类似于当safe值为true时的{@link #unloadChunk(int, int, boolean)}.
     * <p>
     * 原文：
     * Safely unloads and saves the {@link Chunk} at the specified coordinates
     * <p>
     * This method is analogous to {@link #unloadChunk(int, int, boolean)}
     * where save is true.
     *
     * @param x 区块的x坐标
     * @param z 区块的z坐标
     * @return 如果区块被成功卸载则返回true，否则返回false
     */
    public boolean unloadChunk(int x, int z);

    /**
     * 安全的卸载并选择是否保存指定坐标的{@link Chunk 区块}.
     * <p>
     * 原文：
     * Safely unloads and optionally saves the {@link Chunk} at the specified
     * coordinates
     *
     * @param x 区块的x坐标
     * @param z 区块的z坐标
     * @param save 是否保存区块
     * @return 如果区块被成功卸载则返回true，否则返回false
     */
    public boolean unloadChunk(int x, int z, boolean save);

    /**
     * 安全地将卸载指定坐标的{@link Chunk 区块}请求列入队列.
     * <p>
     * 原文：
     * Safely queues the {@link Chunk} at the specified coordinates for
     * unloading
     *
     * @param x 区块的x坐标
     * @param z 区块的z坐标
     * @return 如果尝试列入队列成功则返回true，否则返回false
     */
    public boolean unloadChunkRequest(int x, int z);

    /**
     * 重新生成指定坐标的{@link Chunk 区块}.
     * <p>
     * 原文：
     * Regenerates the {@link Chunk} at the specified coordinates
     *
     * @param x 区块的x坐标
     * @param z 区块的z坐标
     * @return 区块是否真的被重新生成
     * 
     * @deprecated 无法保证重新生成单个区块会产生与之前相同的区块, 因为地形装饰可分布在区块上.
     * 应避免使用本方法, 由于已知本方法易产生bug
     */
    @Deprecated(since = "1.13")
    public boolean regenerateChunk(int x, int z);

    /**
     * 将{@link Chunk 区块}重新发送给所有的客户端.
     * <p>
     * 原文：
     * Resends the {@link Chunk} to all clients
     *
     * @param x 区块的x坐标
     * @param z 区块的z坐标
     * @return 区块是否真的被刷新
     * 
     * @deprecated 这个方法不能保证在所有的客户端接口都正常地工作。
     */
    @Deprecated(since = "1.8")
    public boolean refreshChunk(int x, int z);

    /**
     * 获取可以从客户端查看指定{@link Chunk 区块}的所有玩家列表.
     * <p>
     * 如果没有玩家正在查看该区块, 或者该区块已卸载, 则此列表为空.
     * <p>
     * 原文：Get a list of all players who are can view the specified chunk from their
     * client
     * <p>
     * This list will be empty if no players are viewing the chunk, or the chunk
     * is unloaded.
     *
     * @param chunk 要检查的区块
     * @return 可以看到该区块的玩家集合
     */
    @NotNull
    public Collection<Player> getPlayersSeeingChunk(@NotNull Chunk chunk);

    /**
     * 获取可以从客户端查看指定{@link Chunk 区块}的所有玩家列表.
     * <p>
     * 如果没有玩家正在查看该区块, 或者该区块已卸载, 则此列表为空.
     * <p>
     * 原文：Get a list of all players who are can view the specified chunk from their
     * client
     * <p>
     * This list will be empty if no players are viewing the chunk, or the chunk
     * is unloaded.
     *
     * @param x 区块的X坐标
     * @param z 区块的Z坐标
     * @return 可以看到该区块的玩家集合
     */
    @NotNull
    public Collection<Player> getPlayersSeeingChunk(int x, int z);

    /**
     * 获取指定坐标处的{@link Chunk 区块}是否被强制加载.
     * <p>
     * 被强制加载的区块不会因缺少玩家活动而被卸载.
     * <p>
     * 原文：Gets whether the chunk at the specified chunk coordinates is force
     * loaded.
     * <p>
     * A force loaded chunk will not be unloaded due to lack of player activity.
     *
     * @param x 区块的X坐标
     * @param z 区块的Z坐标
     * @return 强制加载状态
     */
    public boolean isChunkForceLoaded(int x, int z);

    /**
     * 设置指定坐标处的{@link Chunk 区块}是否被强制加载.
     * <p>
     * 被强制加载的区块不会因缺少玩家活动而被卸载.
     * <p>
     * 原文：Sets whether the chunk at the specified chunk coordinates is force
     * loaded.
     * <p>
     * A force loaded chunk will not be unloaded due to lack of player activity.
     *
     * @param x 区块的X坐标
     * @param z 区块的Z坐标
     * @param forced 强制加载状态
     */
    public void setChunkForceLoaded(int x, int z, boolean forced);

    /**
     * 返回这个世界中所有被强制加载的区块.
     * <p>
     * 被强制加载的区块不会因缺少玩家活动而被卸载.
     * <p>
     * 原文：Returns all force loaded chunks in this world.
     * <p>
     * A force loaded chunk will not be unloaded due to lack of player activity.
     *
     * @return 不可修改的强制加载区块集合
     */
    @NotNull
    public Collection<Chunk> getForceLoadedChunks();

    /**
     * 为指定区块添加一个插件票证, 如果该区块尚未加载则会加载它.
     * <p>
     * 插件票证会阻止区块被卸载, 直到该票证被显式移除. 每个插件实例对每个区块只能持有一张票证,
     * 但每个区块可以拥有多张来自不同插件的票证.
     * </p>
     * <p>
     * 原文：Adds a plugin ticket for the specified chunk, loading the chunk if it is
     * not already loaded.
     * <p>
     * A plugin ticket will prevent a chunk from unloading until it is
     * explicitly removed. A plugin instance may only have one ticket per chunk,
     * but each chunk can have multiple plugin tickets.
     *
     * @param x 区块的X坐标
     * @param z 区块的Z坐标
     * @param plugin 拥有该票证的插件
     * @return {@code true} 如果成功添加了插件票证, {@code false} 如果该插件已持有该区块的票证
     * @throws IllegalStateException 如果指定的插件未启用
     * @see #removePluginChunkTicket(int, int, Plugin)
     */
    public boolean addPluginChunkTicket(int x, int z, @NotNull Plugin plugin);

    /**
     * 移除指定插件对指定区块的票证.
     * <p>
     * 插件票证会阻止区块被卸载, 直到该票证被显式移除. 每个插件实例对每个区块只能持有一张票证,
     * 但每个区块可以拥有多张来自不同插件的票证.
     * </p>
     * <p>
     * 原文：Removes the specified plugin's ticket for the specified chunk
     * <p>
     * A plugin ticket will prevent a chunk from unloading until it is
     * explicitly removed. A plugin instance may only have one ticket per chunk,
     * but each chunk can have multiple plugin tickets.
     *
     * @param x 区块的X坐标
     * @param z 区块的Z坐标
     * @param plugin 拥有该票证的插件
     * @return {@code true} 如果成功移除了插件票证, {@code false} 如果该区块没有来自该插件的票证
     * @see #addPluginChunkTicket(int, int, Plugin)
     */
    public boolean removePluginChunkTicket(int x, int z, @NotNull Plugin plugin);

    /**
     * 移除指定插件的所有票证.
     * <p>
     * 插件票证会阻止区块被卸载, 直到该票证被显式移除. 每个插件实例对每个区块只能持有一张票证,
     * 但每个区块可以拥有多张来自不同插件的票证.
     * </p>
     * <p>
     * 原文：Removes all plugin tickets for the specified plugin
     * <p>
     * A plugin ticket will prevent a chunk from unloading until it is
     * explicitly removed. A plugin instance may only have one ticket per chunk,
     * but each chunk can have multiple plugin tickets.
     *
     * @param plugin 指定的插件
     * @see #addPluginChunkTicket(int, int, Plugin)
     * @see #removePluginChunkTicket(int, int, Plugin)
     */
    public void removePluginChunkTickets(@NotNull Plugin plugin);

    /**
     * 获取一个集合, 指定哪些插件对指定区块持有票证. 当对该区块添加或移除插件票证时, 该集合不会被更新.
     * <p>
     * 插件票证会阻止区块被卸载, 直到该票证被显式移除. 每个插件实例对每个区块只能持有一张票证,
     * 但每个区块可以拥有多张来自不同插件的票证.
     * </p>
     * <p>
     * 原文：Retrieves a collection specifying which plugins have tickets for the
     * specified chunk. This collection is not updated when plugin tickets are
     * added or removed to the chunk.
     * <p>
     * A plugin ticket will prevent a chunk from unloading until it is
     * explicitly removed. A plugin instance may only have one ticket per chunk,
     * but each chunk can have multiple plugin tickets.
     *
     * @param x 区块的X坐标
     * @param z 区块的Z坐标
     * @return 不可修改的集合, 包含对该区块持有票证的插件
     * @see #addPluginChunkTicket(int, int, Plugin)
     * @see #removePluginChunkTicket(int, int, Plugin)
     */
    @NotNull
    public Collection<Plugin> getPluginChunkTickets(int x, int z);

    /**
     * 返回一个映射, 包含哪些插件对哪些区块持有票证. 返回的映射在添加或移除插件票证时不会被更新.
     * 如果某个插件没有持有任何票证, 则不会出现在映射中.
     * <p>
     * 插件票证会阻止区块被卸载, 直到该票证被显式移除. 每个插件实例对每个区块只能持有一张票证,
     * 但每个区块可以拥有多张来自不同插件的票证.
     * </p>
     * <p>
     * 原文：Returns a map of which plugins have tickets for what chunks. The returned
     * map is not updated when plugin tickets are added or removed to chunks. If
     * a plugin has no tickets, it will be absent from the map.
     * <p>
     * A plugin ticket will prevent a chunk from unloading until it is
     * explicitly removed. A plugin instance may only have one ticket per chunk,
     * but each chunk can have multiple plugin tickets.
     *
     * @return 不可修改的映射, 包含哪些插件对哪些区块持有票证
     * @see #addPluginChunkTicket(int, int, Plugin)
     * @see #removePluginChunkTicket(int, int, Plugin)
     */
    @NotNull
    public Map<Plugin, Collection<Chunk>> getPluginChunkTickets();

    /**
     * 获取与给定{@link BoundingBox 边界框}相交的所有区块.
     * <p>
     * 原文：Gets all Chunks intersecting the given BoundingBox.
     *
     * @param box 要检查的边界框
     * @return 与给定边界框相交的区块集合
     */
    @NotNull
    public Collection<Chunk> getIntersectingChunks(@NotNull BoundingBox box);

    /**
     * 在指定的{@link Location 位置}丢出一个物品.
     * <p>
     * 原文：
     * Drops an item at the specified {@link Location}
     *
     * @param location 丢出物品的位置
     * @param item 丢出的物品堆
     * @return 这个方法会创建一个ItemDrop（物品掉落）实体作为结果
     */
    @NotNull
    public Item dropItem(@NotNull Location location, @NotNull ItemStack item);

    /**
     * 在指定的{@link Location 位置}丢出一个物品.
     * <p>
     * 注意, 函数将在实体生成之前运行.
     * <p>
     * 原文：Drops an item at the specified {@link Location}
     * Note that functions will run before the entity is spawned
     *
     * @param location 丢出物品的位置
     * @param item 丢出的物品堆
     * @param function 在实体生成之前运行的函数
     * @return 这个方法会创建一个ItemDrop（物品掉落）实体作为结果
     */
    @NotNull
    public Item dropItem(@NotNull Location location, @NotNull ItemStack item, @Nullable Consumer<? super Item> function);

    /**
     * 在指定的{@link Location 位置}丢出一个随机偏移的物品.
     * <p>
     * 原文:Drops an item at the specified {@link Location} with a random offset
     *
     * @param location 丢出物品的位置
     * @param item 丢出的物品堆
     * @return 这个方法会创建一个ItemDrop（物品掉落）实体作为结果
     */
    @NotNull
    public Item dropItemNaturally(@NotNull Location location, @NotNull ItemStack item);

    /**
     * 在指定的{@link Location 位置}丢出一个随机偏移的物品.
     * <p>
     * 注意, 函数将在实体生成之前运行.
     * <p>
     * 原文：Drops an item at the specified {@link Location} with a random offset
     * Note that functions will run before the entity is spawned
     *
     * @param location 丢出物品的位置
     * @param item 丢出的物品堆
     * @param function 在实体生成之前运行的函数
     * @return 这个方法会创建一个ItemDrop（物品掉落）实体作为结果
     */
    @NotNull
    public Item dropItemNaturally(@NotNull Location location, @NotNull ItemStack item, @Nullable Consumer<? super Item> function);

    /**
     * 在指定的{@link Location 位置}创建一个{@link Arrow 箭}的实体.
     * <p>
     * 原文：
     * Creates an {@link Arrow} entity at the given {@link Location}
     *
     * @param location 生成箭的位置
     * @param direction 箭射向的方向
     * @param speed 箭的射速,建议为0.6
     * @param spread 箭存在的时间(箭在多久后会消失)
     * @return 这个方法会生成一个Arrow（箭）实体作为结果
     */
    @NotNull
    public Arrow spawnArrow(@NotNull Location location, @NotNull Vector direction, float speed, float spread);

    /**
     * 在给定的{@link Location 位置}生成指定类型的箭矢实体.
     * <p>
     * 原文：Creates an arrow entity of the given class at the given {@link Location}
     *
     * @param <T> 要生成的箭矢类型
     * @param location 生成箭矢的位置
     * @param direction 箭矢射击的方向
     * @param speed 箭矢的速度, 建议值为0.6
     * @param spread 箭矢的散射度, 建议值为12
     * @param clazz 箭矢的实体类
     * {@link org.bukkit.entity.SpectralArrow},{@link org.bukkit.entity.Arrow},{@link org.bukkit.entity.TippedArrow}
     * @return 作为此方法结果生成的箭矢实体
     */
    @NotNull
    public <T extends AbstractArrow> T spawnArrow(@NotNull Location location, @NotNull Vector direction, float speed, float spread, @NotNull Class<T> clazz);

    /**
     * 在指定的{@link Location 位置}创建一颗树.
     * <p>
     * 原文：
     * Creates a tree at the given {@link Location}
     *
     * @param location 生成树的位置
     * @param type 创建的树的类型
     * @return 如果树被成功生成则返回true，否则返回false
     */
    public boolean generateTree(@NotNull Location location, @NotNull TreeType type);

    /**
     * 在指定的{@link Location 位置}创建一颗树.
     * <p>
     * 原文：
     * Creates a tree at the given {@link Location}
     *
     * @param loc 生成树的位置
     * @param type 创建的树的类型
     * @param delegate 这个方法会返回一个用于调用每个方块的改变的类作为结果
     * @return 如果树被成功生成则返回true，否则返回false
     * @see #generateTree(org.bukkit.Location, java.util.Random, org.bukkit.TreeType, java.util.function.Consumer)
     * @deprecated 此方法不处理方块实体（蜂巢）
     */
    @Deprecated(since = "1.17.1")
    public boolean generateTree(@NotNull Location loc, @NotNull TreeType type, @NotNull BlockChangeDelegate delegate);

    /**
     * 在指定的{@link Location 位置}劈下闪电.
     * <p>
     * 原文：
     * Strikes lightning at the given {@link Location}
     *
     * @param loc 劈下闪电的位置
     * @return lightning（闪电）实体
     */
    @NotNull
    public LightningStrike strikeLightning(@NotNull Location loc);

    /**
     * 在指定的{@link Location 位置}劈下不会造成伤害的闪电.
     * <p>
     * 原文：
     * Strikes lightning at the given {@link Location} without doing damage
     *
     * @param loc 劈下闪电的位置
     * @return lightning（闪电）实体
     */
    @NotNull
    public LightningStrike strikeLightningEffect(@NotNull Location loc);

    /**
     * 获取一个这个世界所有实体的列表.
     * <p>
     * 原文：
     * Get a list of all entities in this World
     *
     * @return 一个当前处在这个世界的所有实体的列表
     */
    @NotNull
    public List<Entity> getEntities();

    /**
     * 获取一个这个世界所有生物实体的列表.
     * <p>
     * 原文：
     * Get a list of all living entities in this World
     *
     * @return 一个当前处在这个世界的所有生物实体的列表
     */
    @NotNull
    public List<LivingEntity> getLivingEntities();

    /**
     * 获取一个在这个世界的所有与指定的类/接口相匹配的实体的集合.
     * <p>
     * 原文：
     * Get a collection of all entities in this World matching the given
     * class/interface
     *
     * @param <T> 一个实体子类
     * @param classes 用于匹配的表示实体类型的类
     * @return 一个当前处在这个世界的所有与指定的类/接口相匹配的实体的列表
     */
    @Deprecated(since = "1.1")
    @NotNull
    public <T extends Entity> Collection<T> getEntitiesByClass(@NotNull Class<T>... classes);

    /**
     * 获取一个在这个世界的所有与指定的类/接口相匹配的实体的集合.
     * <p>
     * 原文：
     * Get a collection of all entities in this World matching the given
     * class/interface
     *
     * @param <T> 一个实体子类
     * @param cls 用于匹配的表示实体类型的类
     * @return  一个当前处在这个世界的所有与指定的类/接口相匹配的实体的列表
     */
    @NotNull
    public <T extends Entity> Collection<T> getEntitiesByClass(@NotNull Class<T> cls);

    /**
     * 获取一个在这个世界的所有与任一指定的类/接口相匹配的实体的集合.
     * <p>
     * 原文：
     * Get a collection of all entities in this World matching any of the
     * given classes/interfaces
     *
     * @param classes 用于匹配的表示实体类型的类
     * @return 一个当前处在这个世界的所有与一个或更多指定的类/接口相匹配的实体的列表
     */
    @NotNull
    public Collection<Entity> getEntitiesByClasses(@NotNull Class<?>... classes);

    /**
     * 获取一个这个世界的所有玩家的列表.
     * <p>
     * 原文：
     * Get a list of all players in this World
     *
     * @return 一个当前处在这个世界的所有玩家的列表
     */
    @NotNull
    public List<Player> getPlayers();

    /**
     * 返回一个以这个位置为中心的包围着的所有实体的列表(译注:这个可能不太好理解，就是在这个位置，按指定的搜索范围，搜索这个范围里的所有实体).
     * <p>
     * 这可能不会考虑当前尚未加载的区块中的实体. 一些实现可能会对搜索的范围的大小施加限制.
     * <p>
     * 原文：
     * Returns a list of entities within a bounding box centered around a
     * Location.
     * <p>
     * This may not consider entities in currently unloaded chunks. Some
     * implementations may impose artificial restrictions on the size of the
     * search bounding box.
     *
     * @param location 搜索范围的中心
     * @param x 搜索范围的x半轴长度
     * @param y 搜索范围的y半轴长度
     * @param z 搜索范围的z半轴长度
     * @return 在位置附近的实体的集合,一般不为空
     */
    @NotNull
    public Collection<Entity> getNearbyEntities(@NotNull Location location, double x, double y, double z);

    /**
     * 返回一个以这个位置为中心的包围着的所有实体的列表.
     * <p>
     * 这可能不会考虑当前尚未加载的区块中的实体. 一些实现可能会对搜索的范围的大小施加限制.
     * <p>
     * 原文：Returns a list of entities within a bounding box centered around a
     * Location.
     * <p>
     * This may not consider entities in currently unloaded chunks. Some
     * implementations may impose artificial restrictions on the size of the
     * search bounding box.
     *
     * @param location 搜索范围的中心
     * @param x 搜索范围的x半轴长度
     * @param y 搜索范围的y半轴长度
     * @param z 搜索范围的z半轴长度
     * @param filter 只考虑满足此过滤器的实体, 或者 <code>null</code> 考虑所有实体
     * @return 在位置附近的实体的集合, 一般不为空
     */
    @NotNull
    public Collection<Entity> getNearbyEntities(@NotNull Location location, double x, double y, double z, @Nullable Predicate<? super Entity> filter);

    /**
     * 返回给定{@link BoundingBox 边界框}内的所有实体列表.
     * <p>
     * 这可能不会考虑当前尚未加载的区块中的实体. 一些实现可能会对搜索的范围的大小施加限制.
     * <p>
     * 原文：Returns a list of entities within the given bounding box.
     * <p>
     * This may not consider entities in currently unloaded chunks. Some
     * implementations may impose artificial restrictions on the size of the
     * search bounding box.
     *
     * @param boundingBox 边界框
     * @return 边界框内的实体集合, 总是非null的集合
     */
    @NotNull
    public Collection<Entity> getNearbyEntities(@NotNull BoundingBox boundingBox);

    /**
     * 返回给定{@link BoundingBox 边界框}内的所有实体列表.
     * <p>
     * 这可能不会考虑当前尚未加载的区块中的实体. 一些实现可能会对搜索的范围的大小施加限制.
     * <p>
     * 原文：Returns a list of entities within the given bounding box.
     * <p>
     * This may not consider entities in currently unloaded chunks. Some
     * implementations may impose artificial restrictions on the size of the
     * search bounding box.
     *
     * @param boundingBox 边界框
     * @param filter 只考虑满足此过滤器的实体, 或者 <code>null</code> 考虑所有实体
     * @return 边界框内的实体集合, 总是非null的集合
     */
    @NotNull
    public Collection<Entity> getNearbyEntities(@NotNull BoundingBox boundingBox, @Nullable Predicate<? super Entity> filter);

    /**
     * 执行检查实体碰撞的射线跟踪.
     * <p>
     * 这可能不考虑当前已经卸载的区块中的实体. 一些实现可能会对最大距离施加人为限制.
     * <p>
     * 原文:
     * Performs a ray trace that checks for entity collisions.
     * <p>
     * This may not consider entities in currently unloaded chunks. Some
     * implementations may impose artificial restrictions on the maximum
     * distance.
     * <p>
     * <b>Note:</b> Due to display entities having a zero size hitbox, this method will not detect them.
     * To detect display entities use {@link #rayTraceEntities(Location, Vector, double, double)} with a positive raySize
     *
     * @param start 起始位置
     * @param direction 射线方向
     * @param maxDistance 最大距离
     * @return 最近的射线跟踪命中结果, 如果没有命中, 则为<code>null</code>
     * @see #rayTraceEntities(Location, Vector, double, double, Predicate)
     */
    @Nullable
    public RayTraceResult rayTraceEntities(@NotNull Location start, @NotNull Vector direction, double maxDistance);

    /**
     * 执行检查实体碰撞的射线跟踪.
     * <p>
     * 这可能不考虑当前已经卸载的区块中的实体. 一些实现可能会对最大距离施加人为限制.
     * <p>
     * 原文:
     * Performs a ray trace that checks for entity collisions.
     * <p>
     * This may not consider entities in currently unloaded chunks. Some
     * implementations may impose artificial restrictions on the maximum
     * distance.
     *
     * @param start 起始位置
     * @param direction 射线方向
     * @param maxDistance 最大距离
     * @param raySize 在进行碰撞检查之前, 实体边界框将按此值均匀地放大(或缩小)
     * @return 最近的射线跟踪命中结果, 如果没有命中, 则为<code>null</code>
     * @see #rayTraceEntities(Location, Vector, double, double, Predicate)
     */
    @Nullable
    public RayTraceResult rayTraceEntities(@NotNull Location start, @NotNull Vector direction, double maxDistance, double raySize);

    /**
     * 执行检查实体碰撞的射线跟踪.
     * <p>
     * 这可能不考虑当前已经卸载的区块中的实体. 一些实现可能会对最大距离施加人为限制.
     * <p>
     * 原文:
     * Performs a ray trace that checks for entity collisions.
     * <p>
     * This may not consider entities in currently unloaded chunks. Some
     * implementations may impose artificial restrictions on the maximum
     * distance.
     * <p>
     * <b>Note:</b> Due to display entities having a zero size hitbox, this method will not detect them.
     * To detect display entities use {@link #rayTraceEntities(Location, Vector, double, double, Predicate)} with a positive raySize
     *
     * @param start 起始位置
     * @param direction 射线方向
     * @param maxDistance 最大距离
     * @param filter 只考虑满足此过滤器的实体, 或者 <code>null</code> 考虑所有实体
     * @return 最近的射线跟踪命中结果, 如果没有命中, 则为<code>null</code>
     * @see #rayTraceEntities(Location, Vector, double, double, Predicate)
     */
    @Nullable
    public RayTraceResult rayTraceEntities(@NotNull Location start, @NotNull Vector direction, double maxDistance, @Nullable Predicate<? super Entity> filter);

    /**
     * 执行检查实体碰撞的射线跟踪.
     * <p>
     * 这可能不考虑当前已经卸载的区块中的实体. 一些实现可能会对最大距离施加人为限制.
     * <p>
     * 原文:
     * Performs a ray trace that checks for entity collisions.
     * <p>
     * This may not consider entities in currently unloaded chunks. Some
     * implementations may impose artificial restrictions on the maximum
     * distance.
     *
     * @param start 起始位置
     * @param direction 射线方向
     * @param maxDistance 最大距离
     * @param raySize 在进行碰撞检查之前, 实体边界框将按此值均匀地放大(或缩小)
     * @param filter 只考虑满足此过滤器的实体, 或者 <code>null</code> 考虑所有实体
     * @return 最近的射线跟踪命中结果, 如果没有命中, 则为<code>null</code>
     */
    @Nullable
    public RayTraceResult rayTraceEntities(@NotNull Location start, @NotNull Vector direction, double maxDistance, double raySize, @Nullable Predicate<? super Entity> filter);

    /**
     * 执行射线跟踪, 使用方块的精确碰撞形状来检查方块碰撞.
     * <p>
     * 这将考虑与可穿过的方块的碰撞, 但忽略流体.
     * <p>
     * 这可能会导致区块加载! 一些实现可能会对最大距离施加人为限制.
     * <p>
     * 原文:
     * Performs a ray trace that checks for block collisions using the blocks'
     * precise collision shapes.
     * <p>
     * This takes collisions with passable blocks into account, but ignores
     * fluids.
     * <p>
     * This may cause loading of chunks! Some implementations may impose
     * artificial restrictions on the maximum distance.
     *
     * @param start 起始位置
     * @param direction 射线方向
     * @param maxDistance 最大距离
     * @return 最近的射线跟踪命中结果, 如果没有命中, 则为<code>null</code>
     * @see #rayTraceBlocks(Location, Vector, double, FluidCollisionMode, boolean)
     */
    @Nullable
    public RayTraceResult rayTraceBlocks(@NotNull Location start, @NotNull Vector direction, double maxDistance);

    /**
     * 执行射线跟踪, 使用方块的精确碰撞形状来检查方块碰撞.
     * <p>
     * 这将考虑与可穿过的方块的碰撞.
     * <p>
     * 这可能会导致区块加载! 一些实现可能会对最大距离施加人为限制.
     * <p>
     * 原文:
     * Performs a ray trace that checks for block collisions using the blocks'
     * precise collision shapes.
     * <p>
     * This takes collisions with passable blocks into account.
     * <p>
     * This may cause loading of chunks! Some implementations may impose
     * artificial restrictions on the maximum distance.
     *
     * @param start 起始位置
     * @param direction 射线方向
     * @param maxDistance 最大距离
     * @param fluidCollisionMode 流体碰撞模式
     * @return 最近的射线跟踪命中结果, 如果没有命中, 则为<code>null</code>
     * @see #rayTraceBlocks(Location, Vector, double, FluidCollisionMode, boolean)
     */
    @Nullable
    public RayTraceResult rayTraceBlocks(@NotNull Location start, @NotNull Vector direction, double maxDistance, @NotNull FluidCollisionMode fluidCollisionMode);

    /**
     * 执行射线跟踪, 使用方块的精确碰撞形状来检查方块碰撞.
     * <p>
     * 如果忽略与可穿过的方块的碰撞, 则无论流体碰撞模式如何, 也会忽略流体碰撞.
     * <p>
     * 只有当射线从传送门方块内部开始时, 其才被认为是可穿过的. 除此之外, 即使忽略了与可穿过方块的碰撞, 也将考虑与传送门方块的碰撞.
     * <p>
     * 这可能会导致区块加载! 一些实现可能会对最大距离施加人为限制.
     * <p>
     * 原文:
     * Performs a ray trace that checks for block collisions using the blocks'
     * precise collision shapes.
     * <p>
     * If collisions with passable blocks are ignored, fluid collisions are
     * ignored as well regardless of the fluid collision mode.
     * <p>
     * Portal blocks are only considered passable if the ray starts within
     * them. Apart from that collisions with portal blocks will be considered
     * even if collisions with passable blocks are otherwise ignored.
     * <p>
     * This may cause loading of chunks! Some implementations may impose
     * artificial restrictions on the maximum distance.
     *
     * @param start 起始位置
     * @param direction 射线方向
     * @param maxDistance 最大距离
     * @param fluidCollisionMode 流体碰撞模式
     * @param ignorePassableBlocks 是否忽略可穿过但可碰撞的方块(例如高草丛、告示牌、液体等)
     * @return 最近的射线跟踪命中结果, 如果没有命中, 则为<code>null</code>
     */
    @Nullable
    public RayTraceResult rayTraceBlocks(@NotNull Location start, @NotNull Vector direction, double maxDistance, @NotNull FluidCollisionMode fluidCollisionMode, boolean ignorePassableBlocks);

    /**
     * 执行射线跟踪, 检查方块碰撞和实体碰撞.
     * <p>
     * 方块碰撞使用方块的精确碰撞形状. <code>raySize</code> 参数仅用于实体的碰撞检查.
     * <p>
     * 如果忽略与可穿过方块的碰撞, 则无论流体碰撞模式如何, 也会忽略流体碰撞.
     * <p>
     * 只有当射线从传送门方块内部开始时, 其才被认为是可穿过的. 除此之外, 即使忽略了与可穿过方块的碰撞, 也将考虑与传送门方块的碰撞.
     * <p>
     * 这可能会导致区块加载! 一些实现可能会对最大距离施加人为限制.
     * <p>
     * 原文:
     * Performs a ray trace that checks for both block and entity collisions.
     * <p>
     * Block collisions use the blocks' precise collision shapes. The
     * <code>raySize</code> parameter is only taken into account for entity
     * collision checks.
     * <p>
     * If collisions with passable blocks are ignored, fluid collisions are
     * ignored as well regardless of the fluid collision mode.
     * <p>
     * Portal blocks are only considered passable if the ray starts within them.
     * Apart from that collisions with portal blocks will be considered even if
     * collisions with passable blocks are otherwise ignored.
     * <p>
     * This may cause loading of chunks! Some implementations may impose
     * artificial restrictions on the maximum distance.
     *
     * @param start 起始位置
     * @param direction 射线方向
     * @param maxDistance 最大距离
     * @param fluidCollisionMode 流体碰撞模式
     * @param ignorePassableBlocks 是否忽略可穿过但可碰撞的方块(例如高草丛、告示牌、液体等)
     * @param raySize 在进行碰撞检查之前, 实体边界框将按此值均匀地放大(或缩小)
     * @param filter 只考虑满足此过滤器的实体, 或者 <code>null</code> 考虑所有实体
     * @return 最近的方块或实体的射线跟踪命中结果, 如果没有命中, 则为<code>null</code>
     */
    @Nullable
    public RayTraceResult rayTrace(@NotNull Location start, @NotNull Vector direction, double maxDistance, @NotNull FluidCollisionMode fluidCollisionMode, boolean ignorePassableBlocks, double raySize, @Nullable Predicate<? super Entity> filter);

    /**
     * 获取这个世界的默认出生点{@link Location 位置}.
     * <p>
     * 原文：
     * Gets the default spawn {@link Location} of this world
     *
     * @return 这个世界的出生点位置
     */
    @NotNull
    public Location getSpawnLocation();

    /**
     * 设置这个世界的出生点位置.
     * <br>
     * 提供的位置所处世界必须与这个世界相同.
     * <p>
     * 原文:Sets the spawn location of the world.
     * <br>
     * The location provided must be equal to this world.
     *
     * @param location 要设置的出生点位置
     * @return 若成功设置返回true
     */
    public boolean setSpawnLocation(@NotNull Location location);

    /**
     * 设置这个世界的出生点位置.
     * <p>
     * 原文:Sets the spawn location of the world
     *
     * @param x X 坐标
     * @param y Y 坐标
     * @param z Z 坐标
     * @param angle 角度
     * @return 若成功设置返回true
     */
    public boolean setSpawnLocation(int x, int y, int z, float angle);

    /**
     * 设置这个世界的出生点位置.
     * <p>
     * 原文：
     * Sets the spawn location of the world
     *
     * @param x x坐标
     * @param y y坐标
     * @param z z坐标
     * @return 如果成功设置则返回true
     */
    public boolean setSpawnLocation(int x, int y, int z);

    /**
     * 获取这个世界在游戏中的相对时间.
     * <p>
     * 相对时间类似于小时数*1000（译注：意思是，如果这个世界在游戏中的时间为一个小时则相对时间显示为1000，一小时十二分为1200).
     * <p>
     * 原文：
     * Gets the relative in-game time of this world.
     * <p>
     * The relative time is analogous to hours * 1000
     *
     * @return 当前相对时间
     * @see #getFullTime() 返回这个世界的绝对时间
     */
    public long getTime();

    /**
     * 设置服务器的在游戏中的相对时间.
     * <p>
     * 相对时间类似于小时数*1000（译注：意思是，如果这个世界在游戏中的时间为一个小时则相对时间显示为1000，一小时十二分为1200).
     * <p>
     * 注意设置的相对时间如果小于当前相对时间则实际上是将时钟向前移动了一天。如果你要倒回时间，请使用{@link #setFullTime(long)}.
     * <p>
     * 原文：
     * Sets the relative in-game time on the server.
     * <p>
     * The relative time is analogous to hours * 1000
     * <p>
     * Note that setting the relative time below the current relative time
     * will actually move the clock forward a day. If you require to rewind
     * time, please see {@link #setFullTime(long)}
     *
     * @param time 设置的在游戏中的新的相对时间（格式为小时数*1000）
     * @see #setFullTime(long) 设置这个世界的绝对时间
     */
    public void setTime(long time);

    /**
     * 获取这个世界完整的游戏时间.
     * <p>
     * 原文：
     * Gets the full in-game time on this world
     *
     * @return 当前绝对时间
     * @see #getTime() 返回这个世界的相对时间
     */
    public long getFullTime();

    /**
     * 设置服务器的游戏时间.
     * <p>
     * 注意这是设置全世界的时间，可能产生不好的影响，比如破坏红石钟或任一预定事件.
     * <p>
     * 原文：
     * Sets the in-game time on the server
     * <p>
     * Note that this sets the full time of the world, which may cause adverse
     * effects such as breaking redstone clocks and any scheduled events
     *
     * @param time 设置的世界的新绝对时间
     * @see #setTime(long) 设置世界的相对时间
     */
    public void setFullTime(long time);

    /**
     * 获取这个世界自世界生成以来的完整游戏时间.
     * <p>
     * 原文：Gets the full in-game time on this world since the world generation
     *
     * @return 自世界生成以来的当前绝对时间
     * @see #getTime() 返回这个世界的相对时间
     * @see #getFullTime() 返回这个世界的绝对时间
     */
    public long getGameTime();

    /**
     * 返回世界现在是否有雷暴.
     * <p>
     * 原文：
     * Returns whether the world has an ongoing storm.
     *
     * @return 是否有雷暴
     */
    public boolean hasStorm();

    /**
     * 设置是否有风暴. 会为新的天气设置一段持续时间.
     *
     * 本方法会隐式调用 {@link #setClearWeatherDuration(int)}, 指定 0 tick 来重置世界的晴朗天气.
     * <p>
     * 原文：
     * Set whether there is a storm. A duration will be set for the new
     * current conditions.
     *
     * This will implicitly call {@link #setClearWeatherDuration(int)} with 0
     * ticks to reset the world's clear weather.
     *
     * @param hasStorm 是否下雨或下雪
     */
    public void setStorm(boolean hasStorm);

    /**
     * 获取当前天气的剩余时间，单位为tick.
     * <p> 
     * 原文：
     * Get the remaining time in ticks of the current conditions.
     *
     * @return 时间，单位为tick
     */
    public int getWeatherDuration();

    /**
     * 设置当前天气的剩余时间，单位为tick.
     * <p>
     * 原文：
     * Set the remaining time in ticks of the current conditions.
     *
     * @param duration 时间，单位为tick
     */
    public void setWeatherDuration(int duration);

    /**
     * 返回这个世界是否在打雷.
     * <p>
     * 原文：
     * Returns whether there is thunder.
     *
     * @return 是否打雷
     */
    public boolean isThundering();

    /**
     * 设置这个世界是否在打雷.
     *
     * 本方法会隐式调用 {@link #setClearWeatherDuration(int)}, 指定 0 tick 来重置世界的晴朗天气.
     * <p>
     * 原文：
     * Set whether it is thundering.
     *
     * This will implicitly call {@link #setClearWeatherDuration(int)} with 0
     * ticks to reset the world's clear weather.
     *
     * @param thundering 是否打雷
     */
    public void setThundering(boolean thundering);

    /**
     * 获取这个世界打雷的持续时间.
     * <p>
     * 原文：
     * Get the thundering duration.
     *
     * @return 持续时间，单位为tick
     */
    public int getThunderDuration();

    /**
     * 设置这个世界打雷持续时间。
     * <p>
     * 原文：
     * Set the thundering duration.
     *
     * @param duration 持续时间，单位为tick
     */
    public void setThunderDuration(int duration);

    /**
     * 返回世界是否为晴天.
     *
     * {@link #isThundering() 雷}{@link #hasStorm() 雨}退散, 便是晴天.
     * <p>
     * 原文:Returns whether the world has clear weather.
     *
     * This will be true such that {@link #isThundering()} and
     * {@link #hasStorm()} are both false.
     *
     * @return 是否为晴天
     */
    public boolean isClearWeather();

    /**
     * 设置晴朗天气的持续时间 (单位为 tick).
     *
     * 晴朗天气的持续时间决定着是否允许世界下雨或打雷.
     * 如果持续时间为 &gt; 0, 那么在持续时间过后, 世界也不会自然地下雨/雪.
     *
     * 本方法等效于 {@code /weather clear 持续时间}.
     * <p>
     * 原文:Set the clear weather duration.
     *
     * The clear weather ticks determine whether or not the world will be
     * allowed to rain or storm. If clear weather ticks are &gt; 0, the world will
     * not naturally do either until the duration has elapsed.
     *
     * This method is equivalent to calling {@code /weather clear} with a set
     * amount of ticks.
     *
     * @param duration 持续时间, 单位为 tick
     */
    public void setClearWeatherDuration(int duration);

    /**
     * 获取晴朗天气的持续时间.
     * <p>
     * 原文:Get the clear weather duration.
     *
     * @return 持续时间, 单位为 tick
     */
    public int getClearWeatherDuration();

    /**
     * 在指定坐标生成指定威力的爆炸.
     * <p>
     * 原文：
     * Creates explosion at given coordinates with given power
     *
     * @param x x坐标
     * @param y y坐标
     * @param z z坐标
     * @param power 爆炸的威力，一个TNT当量为4F
     * @return 如果爆炸被取消则返回false，否则返回true
     */
    public boolean createExplosion(double x, double y, double z, float power);

    /**
     * 在指定的坐标生成指定威力的爆炸并设置方块是否会着火.
     * <p>
     * 原文：
     * Creates explosion at given coordinates with given power and optionally
     * setting blocks on fire.
     *
     * @param x x坐标
     * @param y y坐标
     * @param z z坐标
     * @param power 爆炸的威力，一个TNT当量为4F
     * @param setFire 方块是否会着火
     * @return  如果爆炸被取消则返回false，否则返回true
     */
    public boolean createExplosion(double x, double y, double z, float power, boolean setFire);

    /**
     * 在指定的坐标生成指定威力的爆炸并设置方块是否会着火或被破坏.
     * <p>
     * 原文：
     * Creates explosion at given coordinates with given power and optionally
     * setting blocks on fire or breaking blocks.
     *
     * @param x x坐标
     * @param y y坐标
     * @param z z坐标
     * @param power 爆炸的威力，一个TNT当量为4F
     * @param setFire 方块是否会着火
     * @param breakBlocks 是否破坏方块
     * @return 如果爆炸被取消则返回false，否则返回true
     */
    public boolean createExplosion(double x, double y, double z, float power, boolean setFire, boolean breakBlocks);

    /**
     * 在指定的坐标生成指定威力的爆炸并设置方块是否会着火或被破坏.
     * <p>
     * 注意, 如果提供了非null的{@code source}实体且{@code breakBlocks}为{@code true},
     * 当爆炸所在世界中的{@link GameRule#MOB_GRIEFING}为{@code false}时,
     * {@code breakBlocks}的值将被忽略. 换言之, 如果不允许爆炸, mob griefing游戏规则将优先于{@code breakBlocks}.
     * <p>
     * 原文：Creates explosion at given coordinates with given power and optionally
     * setting blocks on fire or breaking blocks.
     * <p>
     * Note that if a non-null {@code source} Entity is provided and {@code
     * breakBlocks} is {@code true}, the value of {@code breakBlocks} will be
     * ignored if {@link GameRule#MOB_GRIEFING} is {@code false} in the world
     * in which the explosion occurs. In other words, the mob griefing gamerule
     * will take priority over {@code breakBlocks} if explosions are not allowed.
     *
     * @param x X坐标
     * @param y Y坐标
     * @param z Z坐标
     * @param power 爆炸的威力, 其中4F相当于TNT
     * @param setFire 是否设置方块着火
     * @param breakBlocks 是否允许方块被破坏
     * @param source 用于追踪伤害来源的实体
     * @return 如果爆炸被取消则返回false, 否则返回true
     */
    public boolean createExplosion(double x, double y, double z, float power, boolean setFire, boolean breakBlocks, @Nullable Entity source);

    /**
     * 在指定坐标生成指定威力的爆炸.
     * <p>
     * 原文：
     * Creates explosion at given coordinates with given power
     *
     * @param loc 爆炸位置
     * @param power 爆炸的威力，一个TNT当量为4F
     * @return 如果爆炸被取消则返回false，否则返回true
     */
    public boolean createExplosion(@NotNull Location loc, float power);

    /**
     * 在指定的坐标生成指定威力的爆炸并设置方块是否会着火.
     * <p>
     * 原文：
     * Creates explosion at given coordinates with given power and optionally
     * setting blocks on fire.
     *
     * @param loc 爆炸位置
     * @param power 爆炸的威力，一个TNT当量为4F
     * @param setFire 方块是否会着火
     * @return 如果爆炸被取消则返回false，否则返回true
     */
    public boolean createExplosion(@NotNull Location loc, float power, boolean setFire);

    /**
     * 在指定位置生成指定威力的爆炸并设置方块是否会着火或被破坏.
     * <p>
     * 原文：Creates explosion at given coordinates with given power and optionally
     * setting blocks on fire or breaking blocks.
     *
     * @param loc 爆炸位置
     * @param power 爆炸的威力, 其中4F相当于TNT
     * @param setFire 是否设置方块着火
     * @param breakBlocks 是否允许方块被破坏
     * @return 如果爆炸被取消则返回false, 否则返回true
     */
    public boolean createExplosion(@NotNull Location loc, float power, boolean setFire, boolean breakBlocks);

    /**
     * 在指定位置生成指定威力的爆炸并设置方块是否会着火或被破坏.
     * <p>
     * 注意, 如果提供了非null的{@code source}实体且{@code breakBlocks}为{@code true},
     * 当爆炸所在世界中的{@link GameRule#MOB_GRIEFING}为{@code false}时,
     * {@code breakBlocks}的值将被忽略. 换言之, 如果不允许爆炸, mob griefing游戏规则将优先于{@code breakBlocks}.
     * <p>
     * 原文：Creates explosion at given coordinates with given power and optionally
     * setting blocks on fire or breaking blocks.
     * <p>
     * Note that if a non-null {@code source} Entity is provided and {@code
     * breakBlocks} is {@code true}, the value of {@code breakBlocks} will be
     * ignored if {@link GameRule#MOB_GRIEFING} is {@code false} in the world
     * in which the explosion occurs. In other words, the mob griefing gamerule
     * will take priority over {@code breakBlocks} if explosions are not allowed.
     *
     * @param loc 爆炸位置
     * @param power 爆炸的威力, 其中4F相当于TNT
     * @param setFire 是否设置方块着火
     * @param breakBlocks 是否允许方块被破坏
     * @param source 用于追踪伤害来源的实体
     * @return 如果爆炸被取消则返回false, 否则返回true
     */
    public boolean createExplosion(@NotNull Location loc, float power, boolean setFire, boolean breakBlocks, @Nullable Entity source);

    /**
     * 获取世界当前的PVP设置.
     * <p>
     * 原文：
     * Gets the current PVP setting for this world.
     *
     * @return 如果允许PVP则返回true
     */
    public boolean getPVP();

    /**
     * 设置世界的PVP设置.
     * <p>
     * 原文：
     * Sets the PVP setting for this world.
     *
     * @param pvp 是否允许PVP，允许为true，不允许为false.
     */
    public void setPVP(boolean pvp);

    /**
     * 获取世界的区块生成器.
     * <p>
     * 原文：
     * Gets the chunk generator for this world
     *
     * @return 这个世界相关的{@link ChunkGenerator 区块生成器}
     */
    @Nullable
    public ChunkGenerator getGenerator();

    /**
     * 获取这个世界使用的{@link BiomeProvider 生物群系提供器}.
     * <p>
     * 原文：Gets the biome provider for this world
     *
     * @return 与这个世界关联的生物群系提供器
     */
    @Nullable
    public BiomeProvider getBiomeProvider();

    /**
     * 保存世界到磁盘.
     * <p>
     * 原文：Saves world to disk
     */
    public void save();

    /**
     * 获取一个这个世界使用的所有{@link BlockPopulator 方块填充器}的列表.
     * <p>
     * 原文：
     * Gets a list of all applied {@link BlockPopulator}s for this World
     *
     * @return 这个世界使用的所有方块填充器的列表
     */
    @NotNull
    public List<BlockPopulator> getPopulators();

    /**
     * 在给定的{@link Location 位置}创建一个新实体, 并在实体被添加到世界之前运行提供的函数.
     * <br>
     * 注意, 当函数运行时, 实体实际上还未进入世界. 在此函数返回之前, 任何涉及该实体的操作(如传送实体)都是未定义的.
     * 但是, 传入的函数在潜在实体的生成随机化之后运行, 因此已经允许访问生物的值,
     * 无论这些值是否被随机化, 例如属性或实体装备.
     * <p>
     * 原文：Creates a new entity at the given {@link Location} with the supplied
     * function run before the entity is added to the world.
     * <br>
     * Note that when the function is run, the entity will not be actually in
     * the world. Any operation involving such as teleporting the entity is undefined
     * until after this function returns.
     * The passed function however is run after the potential entity's spawn
     * randomization and hence already allows access to the values of the mob,
     * whether or not those were randomized, such as attributes or the entity
     * equipment.
     *
     * @param location      实体将被生成的位置.
     * @param clazz         要生成的{@link LivingEntity 生物实体}的类.
     * @param <T>           正在创建的实体的泛型类型.
     * @param spawnReason   在{@link CreatureSpawnEvent}调用期间提供的原因.
     * @param randomizeData 实体的数据是否应该在生成前被随机化. 默认情况下, 实体在生成前会对其装备、年龄、属性等进行随机化.
     *                      这种随机化的示例包括羊的颜色、生物装备上的随机附魔, 甚至僵尸变成骑鸡僵尸.
     *                      如果设置为false, 实体在生成前不会被随机化, 意味着所有数据将保持默认状态, 不会对实体进行进一步修改.
     *                      值得注意的是, 只有继承{@link org.bukkit.entity.Mob}接口的实体才提供生成随机化逻辑.
     *                      因此此参数对任何其他类型的实体无用.
     * @param function      在实体生成之前运行的函数.
     * @return 生成的实体实例.
     * @throws IllegalArgumentException 如果world或clazz参数为null.
     */
    @NotNull
    public <T extends LivingEntity> T spawn(@NotNull Location location, @NotNull Class<T> clazz, @NotNull CreatureSpawnEvent.SpawnReason spawnReason, boolean randomizeData, @Nullable Consumer<? super T> function) throws IllegalArgumentException;

    /**
     * 在给定的{@link Location 位置}生成一个{@link FallingBlock 掉落中的方块}实体, 使用指定的{@link MaterialData}.
     * MaterialData决定下落的内容. 当下落方块碰到地面时, 它将放置该方块.
     * <p>
     * Material必须是方块类型, 可通过{@link Material#isBlock()
     * data.getItemType().isBlock()}检查. Material不能是空气.
     * <p>
     * 原文：Spawn a {@link FallingBlock} entity at the given {@link Location} of
     * the specified {@link MaterialData}. The MaterialData dictates what is falling.
     * When the FallingBlock hits the ground, it will place that block.
     * <p>
     * The Material must be a block type, check with {@link Material#isBlock()
     * data.getItemType().isBlock()}. The Material may not be air.
     *
     * @param location 生成{@link FallingBlock 掉落中的方块}的{@link Location 位置}
     * @param data 方块数据
     * @return 生成的{@link FallingBlock 掉落中的方块}实例
     * @throws IllegalArgumentException 如果{@link Location}或{@link
     *     MaterialData}为null, 或{@link MaterialData}的{@link Material}不是方块
     */
    @NotNull
    public FallingBlock spawnFallingBlock(@NotNull Location location, @NotNull MaterialData data) throws IllegalArgumentException;

    /**
     * 在指定的{@link Location 位置}根据给定的{@link BlockData}生成一个{@link FallingBlock 掉落中的方块}实体。
     * BlockData决定下落的东西。当下落方块碰到地时就会放置这个方块.
     * <p>
     * 原文：
     * Spawn a {@link FallingBlock} entity at the given {@link Location} of
     * the specified {@link BlockData}. The BlockData dictates what is falling.
     * When the FallingBlock hits the ground, it will place that block.
     *
     * @param location 生成下落方块的{@link Location 位置}
     * @param data FallingBlock的{@link BlockData 方块数据}
     * @return 生成的{@link FallingBlock 正在下落的方块}实例
     * @throws IllegalArgumentException 如果 {@link Location} 或 {@link BlockData} 为null
     */
    @NotNull
    public FallingBlock spawnFallingBlock(@NotNull Location location, @NotNull BlockData data) throws IllegalArgumentException;

    /**
     * 在指定的{@link Location 位置}根据指定的方块{@link Material 物品}生成一个{@link FallingBlock 掉落中的方块}实体.
     * 物品决定下落的东西。当下落方块碰到地时就会放置这个方块.
     * <p>
     * 物品必须是一个经过{@link Material#isBlock()}检验的方块类型,可能不是空气.
     * <p>
     * 原文：
     * Spawn a {@link FallingBlock} entity at the given {@link Location} of the
     * specified {@link Material}. The material dictates what is falling.
     * When the FallingBlock hits the ground, it will place that block.
     * <p>
     * The Material must be a block type, check with {@link Material#isBlock()
     * material.isBlock()}. The Material may not be air.
     *
     * @param location 生成下落方块的{@link Location 位置}
     * @param material 方块 {@link Material} 类型
     * @param data 方块数据
     * @return 生成的{@link FallingBlock 正在下落的方块}实例
     * @throws IllegalArgumentException 如果 {@link Location} 或 {@link
     *     Material} 为null 或 {@link Material} 不是方块
     * @deprecated 不安全的参数
     */
    @Deprecated(since = "1.7.5")
    @NotNull
    public FallingBlock spawnFallingBlock(@NotNull Location location, @NotNull Material material, byte data) throws IllegalArgumentException;

    /**
     * 向以指定位置为圆心的默认半径内的所有玩家施加(给予)一个效果.
     * <p>
     * 原文：
     * Plays an effect to all players within a default radius around a given
     * location.
     *
     * @param location 在这个{@link Location 位置}周围给玩家施加效果
     * @param effect {@link Effect 效果}
     * @param data 一些效果需要的数据
     */
    public void playEffect(@NotNull Location location, @NotNull Effect effect, int data);

    /**
     * 向在以指定位置为圆心的指定半径内的所有玩家施加(给予)一个效果。
     * <p>
     * 原文：
     * Plays an effect to all players within a given radius around a location.
     *
     * @param location 在这个{@link Location 位置}周围给玩家施加效果
     * @param effect {@link Effect 效果}
     * @param data 一些效果需要的数据
     * @param radius 半径
     */
    public void playEffect(@NotNull Location location, @NotNull Effect effect, int data, int radius);

    /**
     * 向在以指定位置为圆心的默认半径内的所有玩家施加(给予)一个效果。
     * <p>
     * 原文：
     * Plays an effect to all players within a default radius around a given
     * location.
     *
     * @param <T> 与效果类型相关的数据
     * @param location 在这个{@link Location 位置}周围给玩家施加效果
     * @param effect {@link Effect 效果}
     * @param data 一些效果需要的数据
     */
    public <T> void playEffect(@NotNull Location location, @NotNull Effect effect, @Nullable T data);

    /**
     * 向在以指定位置为圆心的指定半径内的所有玩家施加(给予)一个效果。
     * <p>
     * 原文：
     * Plays an effect to all players within a given radius around a location.
     *
     * @param <T> 与效果类型相关的数据
     * @param location 在这个{@link Location 位置}周围给玩家施加效果
     * @param effect {@link Effect 效果}
     * @param data 一些效果需要的数据
     * @param radius 半径
     */
    public <T> void playEffect(@NotNull Location location, @NotNull Effect effect, @Nullable T data, int radius);

    /**
     * 获取空区块的快照（相当于所有空气方块），可设置包含有效生物群系数据。用于表示一个未生成的区块，或者只用于获取生物群系数据而不加载区块。
     * <p>
     * 原文：
     * Get empty chunk snapshot (equivalent to all air blocks), optionally
     * including valid biome data. Used for representing an ungenerated chunk,
     * or for fetching only biome data without loading a chunk.
     *
     * @param x 区块x坐标
     * @param z 区块z坐标
     * @param includeBiome 如果为true，则快照会包含每个坐标的生物群系类型
     * @param includeBiomeTemp 如果为true，则快照会包含每个坐标的原始生物群系温度
     * @return 空快照
     */
    @NotNull
    public ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome, boolean includeBiomeTemp);

    /**
     * 为这个世界设置出生标识。
     * <p>
     * 原文：
     * Sets the spawn flags for this.
     *
     * @param allowMonsters 如果为true，则允许怪物在这个世界生成
     * @param allowAnimals 如果为true，则允许动物在这个世界生成
     */
    public void setSpawnFlags(boolean allowMonsters, boolean allowAnimals);

    /**
     * 获取动物能不能在这个世界生成。
     * <p>
     * 原文：
     * Gets whether animals can spawn in this world.
     *
     * @return 动物能不能在这个世界生成
     */
    public boolean getAllowAnimals();

    /**
     * 获取怪物能不能在这个世界生成。
     * <p>
     * 原文：
     * Gets whether monsters can spawn in this world.
     *
     * @return 怪物能不能在这个世界生成
     */
    public boolean getAllowMonsters();

    /**
     * 获取指定方块坐标的生物群系。
     * <p>
     * 原文：
     * Gets the biome for the given block coordinates.
     *
     * @param x 方块的x坐标
     * @param z 方块的z坐标
     * @return 所查方块的生物群系
     * @deprecated 1.15更新后生物群系已三维化
     */
    @NotNull
    @Deprecated(since = "1.15")
    Biome getBiome(int x, int z);

    /**
     * 设置指定方块坐标的生物群系.
     * <p>
     * 原文:Sets the biome for the given block coordinates
     *
     * @param x 方块的x坐标
     * @param z 方块的z坐标
     * @param bio 这个方块的新生物群系类型
     * @deprecated 1.15更新后生物群系已三维化
     */
    @Deprecated(since = "1.15")
    void setBiome(int x, int z, @NotNull Biome bio);

    /**
     * 获取指定方块坐标的温度。
     * <p>
     * 方块不存在时运行这个方法是安全的，它不会创建方块.
     * <p>
     * 本方法将返回原始温度值, 不以方块高度所带来的影响而判断.
     * <p>
     * 原文：
     * Gets the temperature for the given block coordinates.
     * <p>
     * It is safe to run this method when the block does not exist, it will
     * not create the block.
     * <p>
     * This method will return the raw temperature without adjusting for block
     * height effects.
     *
     * @param x 方块的x坐标
     * @param z 方块的z坐标
     * @return 查询方块的温度
     * @deprecated 1.15更新后生物群系已三维化
     */
    @Deprecated(since = "1.15")
    public double getTemperature(int x, int z);

    /**
     * 获取指定方块坐标的温度.
     * <p>
     * 方块不存在时运行这个方法是安全的, 它不会创建方块.
     * <p>
     * 本方法将返回原始温度值, 不以方块高度所带来的影响而判断.
     * <p>
     * 原文：Gets the temperature for the given block coordinates.
     * <p>
     * It is safe to run this method when the block does not exist, it will
     * not create the block.
     * <p>
     * This method will return the raw temperature without adjusting for block
     * height effects.
     *
     * @param x 方块的X坐标
     * @param y 方块的Y坐标
     * @param z 方块的Z坐标
     * @return 查询方块的温度
     */
    public double getTemperature(int x, int y, int z);

    /**
     * 获取指定方块坐标的湿度。
     * <p>
     * 方块不存在时运行这个方法是安全的，它不会创建方块。
     * <p>
     * 原文：
     * Gets the humidity for the given block coordinates.
     * <p>
     * It is safe to run this method when the block does not exist, it will
     * not create the block.
     *
     * @param x 方块的x坐标
     * @param z 方块的z坐标
     * @return 查询方块的湿度
     * @deprecated 1.15更新后生物群系已三维化
     */
    @Deprecated(since = "1.15")
    public double getHumidity(int x, int z);

    /**
     * 获取指定方块坐标的湿度.
     * <p>
     * 方块不存在时运行这个方法是安全的, 它不会创建方块.
     * <p>
     * 原文：Gets the humidity for the given block coordinates.
     * <p>
     * It is safe to run this method when the block does not exist, it will
     * not create the block.
     *
     * @param x 方块的X坐标
     * @param y 方块的Y坐标
     * @param z 方块的Z坐标
     * @return 查询方块的湿度
     */
    public double getHumidity(int x, int y, int z);

    /**
     * 获取紫颂果和下界传送门可以将玩家传送到此维度的最大高度.
     * <p>
     * 这不包括已在限制之上建造的传送门, 因为它们仍然可以正常连接. 不会大于{@link #getMaxHeight()}.
     * <p>
     * 原文：Gets the maximum height to which chorus fruits and nether portals can
     * bring players within this dimension.
     *
     * This excludes portals that were already built above the limit as they
     * still connect normally. May not be greater than {@link #getMaxHeight()}.
     *
     * @return 紫颂果和下界传送门的最大逻辑高度
     */
    public int getLogicalHeight();

    /**
     * 获取这个世界是否为自然世界.
     * <p>
     * 当为false时, 指南针会随机旋转, 使用床设置重生点或睡觉将被禁用. 当为true时, 下界传送门可以生成僵尸猪灵.
     * <p>
     * 原文：Gets if this world is natural.
     *
     * When false, compasses spin randomly, and using a bed to set the respawn
     * point or sleep, is disabled. When true, nether portals can spawn
     * zombified piglins.
     *
     * @return 如果世界是自然世界则返回true
     */
    public boolean isNatural();

    /**
     * 获取床在这个世界是否有效.
     * <p>
     * 无效的床在尝试睡觉时会爆炸. {@link #isNatural()}定义了床是否可用于设置重生点.
     * <p>
     * 原文：Gets if beds work in this world.
     *
     * A non-working bed will blow up when trying to sleep. {@link #isNatural()}
     * defines if a bed can be used to set spawn point.
     *
     * @return 如果床在此世界有效则返回true
     */
    public boolean isBedWorks();

    /**
     * 获取这个世界是否有天空光照.
     * <p>
     * 原文：Gets if this world has skylight access.
     *
     * @return 如果这个世界有天空光照则返回true
     */
    public boolean hasSkyLight();

    /**
     * 获取这个世界是否有天花板.
     * <p>
     * 原文：Gets if this world has a ceiling.
     *
     * @return 如果这个世界有基岩天花板则返回true
     */
    public boolean hasCeiling();

    /**
     * 获取这个世界是否允许猪灵在不颤抖和不变身为僵尸猪灵的情况下存活.
     * <p>
     * 原文：Gets if this world allow to piglins to survive without shaking and
     * transforming to zombified piglins.
     *
     * @return 如果猪灵不会变身为僵尸猪灵则返回true
     */
    public boolean isPiglinSafe();

    /**
     * 获取这个世界是否允许玩家充能和使用重生锚.
     * <p>
     * 原文：Gets if this world allows players to charge and use respawn anchors.
     *
     * @return 如果玩家可以充能和使用重生锚则返回true
     */
    public boolean isRespawnAnchorWorks();

    /**
     * 获取在此世界中带有不祥之兆效果的玩家是否将触发袭击.
     * <p>
     * 原文：Gets if players with the bad omen effect in this world will trigger a
     * raid.
     *
     * @return 如果袭击将被触发则返回true
     */
    public boolean hasRaids();

    /**
     * 获取此世界是否会触发各种水/岩浆机制, 例如:
     * <br>
     * <ul>
     * <li>水被蒸发</li>
     * <li>海绵变干</li>
     * <li>岩浆扩散更快更远</li>
     * </ul>
     * <p>
     * 原文：Gets if various water/lava mechanics will be triggered in this world, eg:
     * <br>
     * <ul>
     * <li>Water is evaporated</li>
     * <li>Sponges dry</li>
     * <li>Lava spreads faster and further</li>
     * </ul>
     *
     * @return 如果这个世界有上述机制则返回true
     */
    public boolean isUltraWarm();

    /**
     * 获取世界的海平面。
     * <p>
     * 这个值总是{@link #getMaxHeight()}的一半
     * <p>
     * 原文：
     * Gets the sea level for this world.
     * <p>
     * This is often half of {@link #getMaxHeight()}
     *
     * @return 海平面高度
     */
    public int getSeaLevel();

    /**
     * 获取世界的出生点是否会在内存中保存加载。
     * <p>
     * 原文：
     * Gets whether the world's spawn area should be kept loaded into memory
     * or not.
     *
     * @return 如果世界的出生地区会在内存中保存加载则返回true
     * @deprecated "出生点区块"的概念已被移除, 使用
     * {@link #isChunkForceLoaded(int, int)} 以更好地控制
     */
    @Deprecated(since = "1.20.5")
    public boolean getKeepSpawnInMemory();

    /**
     * 设置世界的出生点是否会在内存中保存加载。
     * <p>
     * 原文：
     * Sets whether the world's spawn area should be kept loaded into memory
     * or not.
     *
     * @param keepLoaded 如果为true则世界的出生地区会在内存中保存加载
     * @deprecated 使用 {@link GameRule#SPAWN_CHUNK_RADIUS} 以更好地控制
     * @deprecated "出生点区块"的概念已被移除, 使用
     * {@link #setChunkForceLoaded(int, int, boolean)} 以更好地控制
     */
    @Deprecated(since = "1.20.5")
    public void setKeepSpawnInMemory(boolean keepLoaded);

    /**
     * 获取世界是否会自动保存。
     * <p>
     * 原文：
     * Gets whether or not the world will automatically save
     *
     * @return 如果世界会自动保存则返回true，否则返回false
     */
    public boolean isAutoSave();

    /**
     * 设置世界是否会自动保存。
     * <p>
     * 原文：
     * Sets whether or not the world will automatically save
     *
     * @param value 如果为true则世界会自动保存，否则为false
     */
    public void setAutoSave(boolean value);

    /**
     * 设置世界的游戏难度。
     * <p>
     * 原文：
     * Sets the Difficulty of the world.
     *
     * @param difficulty 设置的世界的新难度
     */
    public void setDifficulty(@NotNull Difficulty difficulty);

    /**
     * 获取世界的游戏难度。
     * <p>
     * 原文：
     * Gets the Difficulty of the world.
     *
     * @return 世界的难度
     */
    @NotNull
    public Difficulty getDifficulty();

    /**
     * 获取这个世界使用的视距.
     * <p>
     * 原文：Returns the view distance used for this world.
     *
     * @return 这个世界使用的视距
     */
    int getViewDistance();

    /**
     * 获取这个世界使用的模拟距离.
     * <p>
     * 原文：Returns the simulation distance used for this world.
     *
     * @return 这个世界使用的模拟距离
     */
    int getSimulationDistance();

    /**
     * 获取这个世界保存在磁盘的哪个文件夹。
     * <p>
     * 原文：
     * Gets the folder of this world on disk.
     *
     * @return 这个世界所在的文件夹
     */
    @NotNull
    public File getWorldFolder();

    /**
     * 获取世界类型。
     * <p>
     * 原文：
     * Gets the type of this world.
     *
     * @return 世界类型
     * @deprecated 世界类型仅用于选择默认的世界生成设置, 且不会存储在原版世界中, 因此此方法无法始终返回正确的值.
     */
    @Nullable
    @Deprecated(since = "1.16.1")
    public WorldType getWorldType();

    /**
     * 获取建筑物是否会被生成。
     * <p>
     * 原文：
     * Gets whether or not structures are being generated.
     *
     * @return 如果建筑物会被生成则返回true
     */
    public boolean canGenerateStructures();

    /**
     * 获取这个世界是否为极限模式.
     * <p>
     * 在极限模式世界中, 难度被锁定为困难.
     * <p>
     * 原文：Gets whether the world is hardcore or not.
     *
     * In a hardcore world the difficulty is locked to hard.
     *
     * @return 极限模式状态
     */
    public boolean isHardcore();

    /**
     * 设置这个世界是否为极限模式.
     * <p>
     * 在极限模式世界中, 难度被锁定为困难.
     * <p>
     * 原文：Sets whether the world is hardcore or not.
     *
     * In a hardcore world the difficulty is locked to hard.
     *
     * @param hardcore 世界是否为极限模式
     */
    public void setHardcore(boolean hardcore);

    /**
     * 获取世界生成动物的时间间隔（单位为tick）。
     * <p>
     * 这个数值决定每次尝试生成动物之间的时间间隔（单位为tick）。
     * <p>
     * <b>用法示例：</b>
     * <ul>
     * <li>数值为1意味着服务器每1tick都会尝试在这个世界生成动物。
     * <li>数值为400意味着服务器每400tick会尝试在这个世界生成动物。
     * <li>数值低于0则会被重置为Minecraft的默认值。
     * </ul>
     * <p>
     * <b>注意：</b>
     * 如果设置为0，则会禁止这个世界生成动物。我们一般使用{@link #setSpawnFlags(boolean, boolean)}来代替。
     * <p>
     * Minecraft的默认值：400。
     * <p>
     * 原文：
     * Gets the world's ticks per animal spawns value
     * <p>
     * This value determines how many ticks there are between attempts to
     * spawn animals.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn animals in
     *     this world every tick.
     * <li>A value of 400 will mean the server will attempt to spawn animals
     *     in this world every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b>
     * If set to 0, animal spawning will be disabled for this world. We
     * recommend using {@link #setSpawnFlags(boolean, boolean)} to control
     * this instead.
     * <p>
     * Minecraft default: 400.
     *
     * @return 世界生成动物的时间间隔（单位为tick）
     * @deprecated 建议使用 {@link #getTicksPerSpawns(SpawnCategory)}
     */
    @Deprecated(since = "1.18.1")
    public long getTicksPerAnimalSpawns();

    /**
     * 设置世界生成动物的时间间隔（单位为tick）。
     * <p>
     * 这个数值决定每次尝试生成动物之间的时间间隔（单位为tick）。
     * <p>
     * <b>用法示例：</b>
     * <ul>
     * <li>数值为1意味着服务器每1tick都会尝试在这个世界生成动物。
     * <li>数值为400意味着服务器每400tick会尝试在这个世界生成动物。
     * <li>数值低于0则会被重置为Minecraft的默认值。
     * </ul>
     * <p>
     * <b>注意：</b>
     * 如果设置为0，则会禁止这个世界生成动物。我们一般使用{@link #setSpawnFlags(boolean, boolean)}来代替。
     * <p>
     * Minecraft的默认值：400。
     * <p>
     * 原文：
     * Sets the world's ticks per animal spawns value
     * <p>
     * This value determines how many ticks there are between attempts to
     * spawn animals.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn animals in
     *     this world every tick.
     * <li>A value of 400 will mean the server will attempt to spawn animals
     *     in this world every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b>
     * If set to 0, animal spawning will be disabled for this world. We
     * recommend using {@link #setSpawnFlags(boolean, boolean)} to control
     * this instead.
     * <p>
     * Minecraft default: 400.
     *
     * @param ticksPerAnimalSpawns 设置的世界生成动物的时间间隔（单位为tick）
     * @deprecated 建议使用 {@link #setTicksPerSpawns(SpawnCategory, int)}
     */
    @Deprecated(since = "1.18.1")
    public void setTicksPerAnimalSpawns(int ticksPerAnimalSpawns);

    /**
     * 获取世界生成怪物的时间间隔（单位为tick）。
     * <p>
     * 这个数值决定每次尝试生成怪物之间的时间间隔（单位为tick）。
     * <p>
     * <b>用法示例：</b>
     * <ul>
     * <li>数值为1意味着服务器每1tick都会尝试在这个世界生成怪物。
     * <li>数值为400意味着服务器每400tick会尝试在这个世界生成怪物。
     * <li>数值低于0则会被重置为Minecraft的默认值。
     * </ul>
     * <p>
     * <b>注意：</b>
     * 如果设置为0，则会禁止这个世界生成怪物。我们一般使用{@link #setSpawnFlags(boolean, boolean)}来代替。
     * <p>
     * Minecraft的默认值：1。
     * <p>
     * 原文：
     * Gets the world's ticks per monster spawns value
     * <p>
     * This value determines how many ticks there are between attempts to
     * spawn monsters.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn monsters in
     *     this world every tick.
     * <li>A value of 400 will mean the server will attempt to spawn monsters
     *     in this world every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b>
     * If set to 0, monsters spawning will be disabled for this world. We
     * recommend using {@link #setSpawnFlags(boolean, boolean)} to control
     * this instead.
     * <p>
     * Minecraft default: 1.
     *
     * @return 世界生成怪物的时间间隔（单位为tick）
     * @deprecated 建议使用 {@link #getTicksPerSpawns(SpawnCategory)}
     */
    @Deprecated(since = "1.18.1")
    public long getTicksPerMonsterSpawns();

    /**
     * 设置世界生成怪物的时间间隔（单位为tick）。
     * <p>
     * 这个数值决定每次尝试生成怪物之间的时间间隔（单位为tick）。
     * <p>
     * <b>用法示例：</b>
     * <ul>
     * <li>数值为1意味着服务器每1tick都会尝试在这个世界生成怪物。
     * <li>数值为400意味着服务器每400tick会尝试在这个世界生成怪物。
     * <li>数值低于0则会被重置为Minecraft的默认值。
     * </ul>
     * <p>
     * <b>注意：</b>
     * 如果设置为0，则会禁止这个世界生成怪物。我们一般使用{@link #setSpawnFlags(boolean, boolean)}来代替。
     * <p>
     * Minecraft的默认值：1。
     * <p>
     * 原文：
     * Sets the world's ticks per monster spawns value
     * <p>
     * This value determines how many ticks there are between attempts to
     * spawn monsters.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn monsters in
     *     this world on every tick.
     * <li>A value of 400 will mean the server will attempt to spawn monsters
     *     in this world every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b>
     * If set to 0, monsters spawning will be disabled for this world. We
     * recommend using {@link #setSpawnFlags(boolean, boolean)} to control
     * this instead.
     * <p>
     * Minecraft default: 1.
     *
     * @param ticksPerMonsterSpawns 设置的世界生成怪物的时间间隔（单位为tick）
     * @deprecated 建议使用 {@link #setTicksPerSpawns(SpawnCategory, int)}
     */
    @Deprecated(since = "1.18.1")
    public void setTicksPerMonsterSpawns(int ticksPerMonsterSpawns);

    /**
     * 获取世界生成水生生物的时间间隔（单位为tick）.
     * <p>
     * 这个数值决定每次尝试生成水生生物之间的时间间隔（单位为tick）.
     * <p>
     * <b>用法示例：</b>
     * <ul>
     * <li>数值为1意味着服务器每1tick都会尝试在这个世界生成水生生物.
     * <li>数值为400意味着服务器每400tick会尝试在这个世界生成水生生物.
     * <li>数值低于0则会被重置为Minecraft的默认值.
     * </ul>
     * <p>
     * <b>注意：</b>
     * 如果设置为0, 则会禁止这个世界生成水生生物.
     * <p>
     * Minecraft的默认值：1.
     * <p>
     * 原文：Gets the world's ticks per water mob spawns value
     * <p>
     * This value determines how many ticks there are between attempts to
     * spawn water mobs.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn water mobs in
     *     this world every tick.
     * <li>A value of 400 will mean the server will attempt to spawn water mobs
     *     in this world every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b>
     * If set to 0, water mobs spawning will be disabled for this world.
     * <p>
     * Minecraft default: 1.
     *
     * @return 世界生成水生生物的时间间隔（单位为tick）
     * @deprecated 建议使用 {@link #getTicksPerSpawns(SpawnCategory)}
     */
    @Deprecated(since = "1.18.1")
    public long getTicksPerWaterSpawns();

    /**
     * 设置世界生成水生生物的时间间隔（单位为tick）.
     * <p>
     * 这个数值决定每次尝试生成水生生物之间的时间间隔（单位为tick）.
     * <p>
     * <b>用法示例：</b>
     * <ul>
     * <li>数值为1意味着服务器每1tick都会尝试在这个世界生成水生生物.
     * <li>数值为400意味着服务器每400tick会尝试在这个世界生成水生生物.
     * <li>数值低于0则会被重置为Minecraft的默认值.
     * </ul>
     * <p>
     * <b>注意：</b>
     * 如果设置为0, 则会禁止这个世界生成水生生物.
     * <p>
     * Minecraft的默认值：1.
     * <p>
     * 原文：Sets the world's ticks per water mob spawns value
     * <p>
     * This value determines how many ticks there are between attempts to
     * spawn water mobs.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn water mobs in
     *     this world on every tick.
     * <li>A value of 400 will mean the server will attempt to spawn water mobs
     *     in this world every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b>
     * If set to 0, water mobs spawning will be disabled for this world.
     * <p>
     * Minecraft default: 1.
     *
     * @param ticksPerWaterSpawns 要设置的世界生成水生生物的时间间隔（单位为tick）
     * @deprecated 建议使用 {@link #setTicksPerSpawns(SpawnCategory, int)}
     */
    @Deprecated(since = "1.18.1")
    public void setTicksPerWaterSpawns(int ticksPerWaterSpawns);

    /**
     * 获取默认的水生环境生物生成时间间隔（单位为tick）.
     * <p>
     * <b>用法示例：</b>
     * <ul>
     * <li>数值为1意味着服务器每1tick都会尝试生成水生环境生物.
     * <li>数值为400意味着服务器每400tick会尝试生成水生环境生物.
     * <li>数值低于0则会被重置为Minecraft的默认值.
     * </ul>
     * <p>
     * <b>注意：</b> 如果设置为0, 则水生环境生物的生成将被禁用.
     * <p>
     * Minecraft的默认值：1.
     * <p>
     * 原文：Gets the default ticks per water ambient mob spawns value.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn water ambient mobs
     *     every tick.
     * <li>A value of 400 will mean the server will attempt to spawn water ambient mobs
     *     every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b> If set to 0, ambient mobs spawning will be disabled.
     * <p>
     * Minecraft default: 1.
     *
     * @return 默认的水生环境生物生成时间间隔（单位为tick）
     * @deprecated 建议使用 {@link #getTicksPerSpawns(SpawnCategory)}
     */
    @Deprecated(since = "1.18.1")
    public long getTicksPerWaterAmbientSpawns();

    /**
     * 设置世界生成水生环境生物的时间间隔（单位为tick）.
     * <p>
     * 这个数值决定每次尝试生成水生环境生物之间的时间间隔（单位为tick）.
     * <p>
     * <b>用法示例：</b>
     * <ul>
     * <li>数值为1意味着服务器每1tick都会尝试在这个世界生成水生环境生物.
     * <li>数值为400意味着服务器每400tick会尝试在这个世界生成水生环境生物.
     * <li>数值低于0则会被重置为Minecraft的默认值.
     * </ul>
     * <p>
     * <b>注意：</b>
     * 如果设置为0, 则会禁止这个世界生成水生环境生物.
     * <p>
     * Minecraft的默认值：1.
     * <p>
     * 原文：Sets the world's ticks per water ambient mob spawns value
     * <p>
     * This value determines how many ticks there are between attempts to
     * spawn water ambient mobs.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn water ambient mobs in
     *     this world on every tick.
     * <li>A value of 400 will mean the server will attempt to spawn water ambient mobs
     *     in this world every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b>
     * If set to 0, water ambient mobs spawning will be disabled for this world.
     * <p>
     * Minecraft default: 1.
     *
     * @param ticksPerAmbientSpawns 要设置的世界生成水生环境生物的时间间隔（单位为tick）
     * @deprecated 建议使用 {@link #setTicksPerSpawns(SpawnCategory, int)}
     */
    @Deprecated(since = "1.18.1")
    public void setTicksPerWaterAmbientSpawns(int ticksPerAmbientSpawns);

    /**
     * 获取默认的水生地下生物生成时间间隔（单位为tick）.
     * <p>
     * <b>用法示例：</b>
     * <ul>
     * <li>数值为1意味着服务器每1tick都会尝试生成水生地下生物.
     * <li>数值为400意味着服务器每400tick会尝试生成水生地下生物.
     * <li>数值低于0则会被重置为Minecraft的默认值.
     * </ul>
     * <p>
     * <b>注意：</b> 如果设置为0, 则水生地下生物的生成将被禁用.
     * <p>
     * Minecraft的默认值：1.
     * <p>
     * 原文：Gets the default ticks per water underground creature spawns value.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn water underground creature
     *     every tick.
     * <li>A value of 400 will mean the server will attempt to spawn water underground creature
     *     every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b> If set to 0, water underground creature spawning will be disabled.
     * <p>
     * Minecraft default: 1.
     *
     * @return 默认的水生地下生物生成时间间隔（单位为tick）
     * @deprecated 建议使用 {@link #getTicksPerSpawns(SpawnCategory)}
     */
    @Deprecated(since = "1.18.1")
    public long getTicksPerWaterUndergroundCreatureSpawns();

    /**
     * 设置世界生成水生地下生物的时间间隔（单位为tick）.
     * <p>
     * 这个数值决定每次尝试生成水生地下生物之间的时间间隔（单位为tick）.
     * <p>
     * <b>用法示例：</b>
     * <ul>
     * <li>数值为1意味着服务器每1tick都会尝试在这个世界生成水生地下生物.
     * <li>数值为400意味着服务器每400tick会尝试在这个世界生成水生地下生物.
     * <li>数值低于0则会被重置为Minecraft的默认值.
     * </ul>
     * <p>
     * <b>注意：</b>
     * 如果设置为0, 则会禁止这个世界生成水生地下生物.
     * <p>
     * Minecraft的默认值：1.
     * <p>
     * 原文：Sets the world's ticks per water underground creature spawns value
     * <p>
     * This value determines how many ticks there are between attempts to
     * spawn water underground creature.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn water underground creature in
     *     this world on every tick.
     * <li>A value of 400 will mean the server will attempt to spawn water underground creature
     *     in this world every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b>
     * If set to 0, water underground creature spawning will be disabled for this world.
     * <p>
     * Minecraft default: 1.
     *
     * @param ticksPerWaterUndergroundCreatureSpawns 要设置的世界生成水生地下生物的时间间隔（单位为tick）
     * @deprecated 建议使用 {@link #setTicksPerSpawns(SpawnCategory, int)}
     */
    @Deprecated(since = "1.18.1")
    public void setTicksPerWaterUndergroundCreatureSpawns(int ticksPerWaterUndergroundCreatureSpawns);

    /**
     * 获取世界生成环境生物的时间间隔（单位为tick）.
     * <p>
     * 这个数值决定每次尝试生成环境生物之间的时间间隔（单位为tick）.
     * <p>
     * <b>用法示例：</b>
     * <ul>
     * <li>数值为1意味着服务器每1tick都会尝试在这个世界生成环境生物.
     * <li>数值为400意味着服务器每400tick会尝试在这个世界生成环境生物.
     * <li>数值低于0则会被重置为Minecraft的默认值.
     * </ul>
     * <p>
     * <b>注意：</b>
     * 如果设置为0, 则会禁止这个世界生成环境生物.
     * <p>
     * Minecraft的默认值：1.
     * <p>
     * 原文：Gets the world's ticks per ambient mob spawns value
     * <p>
     * This value determines how many ticks there are between attempts to
     * spawn ambient mobs.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn ambient mobs in
     *     this world every tick.
     * <li>A value of 400 will mean the server will attempt to spawn ambient mobs
     *     in this world every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b>
     * If set to 0, ambient mobs spawning will be disabled for this world.
     * <p>
     * Minecraft default: 1.
     *
     * @return 默认的环境生物生成时间间隔（单位为tick）
     * @deprecated 建议使用 {@link #getTicksPerSpawns(SpawnCategory)}
     */
    @Deprecated(since = "1.18.1")
    public long getTicksPerAmbientSpawns();

    /**
     * 设置世界生成环境生物的时间间隔（单位为tick）.
     * <p>
     * 这个数值决定每次尝试生成环境生物之间的时间间隔（单位为tick）.
     * <p>
     * <b>用法示例：</b>
     * <ul>
     * <li>数值为1意味着服务器每1tick都会尝试在这个世界生成环境生物.
     * <li>数值为400意味着服务器每400tick会尝试在这个世界生成环境生物.
     * <li>数值低于0则会被重置为Minecraft的默认值.
     * </ul>
     * <p>
     * <b>注意：</b>
     * 如果设置为0, 则会禁止这个世界生成环境生物.
     * <p>
     * Minecraft的默认值：1.
     * <p>
     * 原文：Sets the world's ticks per ambient mob spawns value
     * <p>
     * This value determines how many ticks there are between attempts to
     * spawn ambient mobs.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn ambient mobs in
     *     this world on every tick.
     * <li>A value of 400 will mean the server will attempt to spawn ambient mobs
     *     in this world every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b>
     * If set to 0, ambient mobs spawning will be disabled for this world.
     * <p>
     * Minecraft default: 1.
     *
     * @param ticksPerAmbientSpawns 要设置的世界生成环境生物的时间间隔（单位为tick）
     * @deprecated 建议使用 {@link #setTicksPerSpawns(SpawnCategory, int)}
     */
    @Deprecated(since = "1.18.1")
    public void setTicksPerAmbientSpawns(int ticksPerAmbientSpawns);

    /**
     * 获取世界生成指定{@link SpawnCategory 生成类别}生物的时间间隔（单位为tick）.
     * <p>
     * 这个数值决定每次尝试生成指定{@link SpawnCategory 生成类别}生物之间的时间间隔（单位为tick）.
     * <p>
     * <b>用法示例：</b>
     * <ul>
     * <li>数值为1意味着服务器每1tick都会尝试在这个世界生成指定{@link SpawnCategory 生成类别}的生物.
     * <li>数值为400意味着服务器每400tick会尝试在这个世界生成指定{@link SpawnCategory 生成类别}的生物.
     * <li>数值低于0则会被重置为Minecraft的默认值.
     * </ul>
     * <p>
     * <b>注意：</b>
     * 如果设置为0, 则会禁止这个世界生成指定{@link SpawnCategory 生成类别}的生物.
     * <p>
     * Minecraft的默认值：1.
     * <p>
     * 原文：Gets the world's ticks per {@link SpawnCategory} mob spawns value
     * <p>
     * This value determines how many ticks there are between attempts to
     * spawn {@link SpawnCategory} mobs.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn {@link SpawnCategory} mobs in
     *     this world every tick.
     * <li>A value of 400 will mean the server will attempt to spawn {@link SpawnCategory} mobs
     *     in this world every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b>
     * If set to 0, {@link SpawnCategory} mobs spawning will be disabled for this world.
     * <p>
     * Minecraft default: 1.
     *
     * @param spawnCategory 生成类别
     * @return 世界生成指定{@link SpawnCategory 生成类别}生物的时间间隔（单位为tick）
     */
    public long getTicksPerSpawns(@NotNull SpawnCategory spawnCategory);

    /**
     * 设置世界生成指定{@link SpawnCategory 生成类别}生物的时间间隔（单位为tick）.
     * <p>
     * 这个数值决定每次尝试生成指定{@link SpawnCategory 生成类别}生物之间的时间间隔（单位为tick）.
     * <p>
     * <b>用法示例：</b>
     * <ul>
     * <li>数值为1意味着服务器每1tick都会尝试在这个世界生成指定{@link SpawnCategory 生成类别}的生物.
     * <li>数值为400意味着服务器每400tick会尝试在这个世界生成指定{@link SpawnCategory 生成类别}的生物.
     * <li>数值低于0则会被重置为Minecraft的默认值.
     * </ul>
     * <p>
     * <b>注意：</b>
     * 如果设置为0, 则会禁止这个世界生成指定{@link SpawnCategory 生成类别}的生物.
     * <p>
     * Minecraft的默认值：1.
     * <p>
     * 原文：Sets the world's ticks per {@link SpawnCategory} mob spawns value
     * <p>
     * This value determines how many ticks there are between attempts to
     * spawn {@link SpawnCategory} mobs.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn {@link SpawnCategory} mobs in
     *     this world on every tick.
     * <li>A value of 400 will mean the server will attempt to spawn {@link SpawnCategory} mobs
     *     in this world every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b>
     * If set to 0, {@link SpawnCategory} mobs spawning will be disabled for this world.
     * <p>
     * Minecraft default: 1.
     *
     * @param spawnCategory 生成类别
     * @param ticksPerCategorySpawn 要设置的世界生成指定{@link SpawnCategory 生成类别}生物的时间间隔（单位为tick）
     */
    public void setTicksPerSpawns(@NotNull SpawnCategory spawnCategory, int ticksPerCategorySpawn);

    /**
     * 获取这个世界一个区块内的怪物生成数限制。
     * <p>
     * 原文：
     * Gets limit for number of monsters that can spawn in a chunk in this
     * world
     *
     * @return 怪物生成限制
     * @deprecated 建议使用 {@link #getSpawnLimit(SpawnCategory)}
     */
    @Deprecated(since = "1.18.1")
    int getMonsterSpawnLimit();

    /**
     * 设置这个世界一个区块内的怪物生成数限制。
     * <p>
     * <b>注意：</b>如果设置为负数则这个世界会使用服务器普遍的生成限制来代替。
     * <p>
     * 原文：
     * Sets the limit for number of monsters that can spawn in a chunk in this
     * world
     * <p>
     * <b>Note:</b> If set to a negative number the world will use the
     * server-wide spawn limit instead.
     * 
     * @param limit 新的怪物限制
     * @deprecated 建议使用 {@link #setSpawnLimit(SpawnCategory, int)}
     */
    @Deprecated(since = "1.18.1")
    void setMonsterSpawnLimit(int limit);

    /**
     * 获取这个世界一个区块内的动物生成数限制。
     * <p>
     * 原文：
     * Gets the limit for number of animals that can spawn in a chunk in this
     * world
     *
     * @return 动物生成限制
     * @deprecated 建议使用 {@link #getSpawnLimit(SpawnCategory)}
     */
    @Deprecated(since = "1.18.1")
    int getAnimalSpawnLimit();

    /**
     * 设置这个世界一个区块内的动物生成数限制。
     * <p>
     * <b>注意：</b>如果设置为负数则这个世界会使用服务器普遍的生成限制来代替。
     * <p>
     * 原文：
     * Sets the limit for number of animals that can spawn in a chunk in this
     * world
     * <p>
     * <b>Note:</b> If set to a negative number the world will use the
     * server-wide spawn limit instead.
     * 
     * @param limit 新的动物限制
     * @deprecated 建议使用 {@link #getSpawnLimit(SpawnCategory)}
     */
    @Deprecated(since = "1.18.1")
    void setAnimalSpawnLimit(int limit);

    /**
     * 获取这个世界一个区块内的水生动物生成数限制。
     * <p>
     * 原文：
     * Gets the limit for number of water animals that can spawn in a chunk in
     * this world
     *
     * @return 水生动物生成限制
     * @deprecated 建议使用 {@link #getSpawnLimit(SpawnCategory)}
     */
    @Deprecated(since = "1.18.1")
    int getWaterAnimalSpawnLimit();

    /**
     * 设置这个世界一个区块内的水生动物生成数限制。
     * <p>
     * <b>注意：</b>如果设置为负数则这个世界会使用服务器普遍的生成限制来代替。
     * <p>
     * 原文：
     * Sets the limit for number of water animals that can spawn in a chunk in
     * this world
     * <p>
     * <b>Note:</b> If set to a negative number the world will use the
     * server-wide spawn limit instead.
     * 
     * @param limit 新的水生动物限制
     * @deprecated 建议使用 {@link #setSpawnLimit(SpawnCategory, int)}
     */
    @Deprecated(since = "1.18.1")
    void setWaterAnimalSpawnLimit(int limit);

    /**
     * 获取这个世界一个区块内的水生地下生物生成数限制.
     * <p>
     * 原文：Gets the limit for number of water underground creature that can spawn in a chunk in
     * this world
     *
     * @return 水生地下生物生成限制
     * @deprecated 建议使用 {@link #getSpawnLimit(SpawnCategory)}
     */
    @Deprecated(since = "1.18.1")
    int getWaterUndergroundCreatureSpawnLimit();

    /**
     * 设置这个世界一个区块内的水生地下生物生成数限制.
     * <p>
     * <b>注意：</b>如果设置为负数则这个世界会使用服务器普遍的生成限制来代替.
     * <p>
     * 原文：Sets the limit for number of water underground creature that can spawn in a chunk in
     * this world
     * <p>
     * <b>Note:</b> If set to a negative number the world will use the
     * server-wide spawn limit instead.
     *
     * @param limit 新的生物限制
     * @deprecated 建议使用 {@link #setSpawnLimit(SpawnCategory, int)}
     */
    @Deprecated(since = "1.18.1")
    void setWaterUndergroundCreatureSpawnLimit(int limit);

    /**
     * 获取这个世界一个区块内的水生环境生物生成数限制.
     * <p>
     * 原文：Gets user-specified limit for number of water ambient mobs that can spawn
     * in a chunk.
     *
     * @return 水生环境生物生成限制
     * @deprecated 建议使用 {@link #getSpawnLimit(SpawnCategory)}
     */
    @Deprecated(since = "1.18.1")
    int getWaterAmbientSpawnLimit();

    /**
     * 设置这个世界一个区块内的水生环境生物生成数限制.
     * <p>
     * <b>注意：</b>如果设置为负数则这个世界会使用服务器普遍的生成限制来代替.
     * <p>
     * 原文：Sets the limit for number of water ambient mobs that can spawn in a chunk
     * in this world
     * <p>
     * <b>Note:</b> If set to a negative number the world will use the
     * server-wide spawn limit instead.
     *
     * @param limit 新的生物限制
     * @deprecated 建议使用 {@link #setSpawnLimit(SpawnCategory, int)}
     */
    @Deprecated(since = "1.18.1")
    void setWaterAmbientSpawnLimit(int limit);

    /**
     * 获取这个世界一个区块内周围的怪物的生成数限制。
     * <p>
     * 原文：
     * Gets the limit for number of ambient mobs that can spawn in a chunk in
     * this world
     *
     * @return 周围的怪物的生成限制
     * @deprecated 建议使用 {@link #getSpawnLimit(SpawnCategory)}
     */
    @Deprecated(since = "1.18.1")
    int getAmbientSpawnLimit();

    /**
     * 设置这个世界一个区块内周围的怪物的生成数限制。
     * <p>
     * <b>注意：</b>如果设置为负数则这个世界会使用服务器普遍的生成限制来代替。
     * <p>
     * 原文：
     * Sets the limit for number of ambient mobs that can spawn in a chunk in
     * this world
     * <p>
     * <b>Note:</b> If set to a negative number the world will use the
     * server-wide spawn limit instead.
     * 
     * @param limit 新的周围的怪物的限制
     * @deprecated 建议使用 {@link #setSpawnLimit(SpawnCategory, int)}
     */
    @Deprecated(since = "1.18.1")
    void setAmbientSpawnLimit(int limit);

    /**
     * 获取这个世界一个区块内指定{@link SpawnCategory 生成类别}实体的生成数限制.
     * <p>
     * 原文：Gets the limit for number of {@link SpawnCategory} entities that can spawn in a chunk in
     * this world
     *
     * @param spawnCategory 实体生成类别
     * @return 指定类别的生成限制
     */
    int getSpawnLimit(@NotNull SpawnCategory spawnCategory);

    /**
     * 设置这个世界一个区块内指定{@link SpawnCategory 生成类别}实体的生成数限制.
     * <p>
     * <b>注意：</b>如果设置为负数则这个世界会使用服务器普遍的生成限制来代替.
     * <p>
     * 原文：Sets the limit for number of {@link SpawnCategory} entities that can spawn in a chunk in
     * this world
     * <p>
     * <b>Note:</b> If set to a negative number the world will use the
     * server-wide spawn limit instead.
     *
     * @param spawnCategory 实体生成类别
     * @param limit 新的生物限制
     */
    void setSpawnLimit(@NotNull SpawnCategory spawnCategory, int limit);

    /**
     * 在世界中指定的位置播放一个音符. <br>
     * 这个方法<i>可以</i>与蛋糕一起使用.
     * <p>
     * 当使用{@link Instrument#CUSTOM_HEAD}调用时, 此方法会静默失败.
     * <p>
     * 原文：Play a note at the provided Location in the World. <br>
     * This <i>will</i> work with cake.
     * <p>
     * This method will fail silently when called with {@link Instrument#CUSTOM_HEAD}.
     *
     * @param loc 播放音符的位置
     * @param instrument 乐器
     * @param note 音符
     */
    void playNote(@NotNull Location loc, @NotNull Instrument instrument, @NotNull Note note);

    /**
     * 在世界中指定的位置播放一个声音。
     * <p>
     * 如果位置或声音为空则这个函数会失效。
     * <p>
     * 原文：
     * Play a Sound at the provided Location in the World
     * <p>
     * This function will fail silently if Location or Sound are null.
     *
     * @param location 演奏声音的位置
     * @param sound 要播放的声音
     * @param volume 声音音量
     * @param pitch 声音音调
     */
    void playSound(@NotNull Location location, @NotNull Sound sound, float volume, float pitch);

    /**
     * 在世界中指定的位置播放一个声音.
     * <p>
     * 如果位置或声音为空则这个函数会失效. 如果客户端没有对应传入值的声音, 玩家将不会听到任何声音.
     * <p>
     * 原文：Play a Sound at the provided Location in the World.
     * <p>
     * This function will fail silently if Location or Sound are null. No
     * sound will be heard by the players if their clients do not have the
     * respective sound for the value passed.
     *
     * @param location 播放声音的位置
     * @param sound 要播放的内部声音名称
     * @param volume 声音音量
     * @param pitch 声音音调
     */
    void playSound(@NotNull Location location, @NotNull String sound, float volume, float pitch);

	/**
     * 在世界中指定的位置播放一个声音.
     * <p>
     * 如果位置或声音为空则这个函数会失效.
     * <p>
     * 原文：Play a Sound at the provided Location in the World.
     * <p>
     * This function will fail silently if Location or Sound are null.
     *
     * @param location 播放声音的位置
     * @param sound 要播放的声音
     * @param category 声音类别
     * @param volume 声音音量
     * @param pitch 声音音调
     */
    void playSound(@NotNull Location location, @NotNull Sound sound, @NotNull SoundCategory category, float volume, float pitch);

    /**
     * 在世界中指定的位置播放一个声音.
     * <p>
     * 如果位置或声音为空则这个函数会失效. 如果客户端没有对应传入值的声音, 玩家将不会听到任何声音.
     * <p>
     * 原文：Play a Sound at the provided Location in the World.
     * <p>
     * This function will fail silently if Location or Sound are null. No sound
     * will be heard by the players if their clients do not have the respective
     * sound for the value passed.
     *
     * @param location 播放声音的位置
     * @param sound 要播放的内部声音名称
     * @param category 声音类别
     * @param volume 声音音量
     * @param pitch 声音音调
     */
    void playSound(@NotNull Location location, @NotNull String sound, @NotNull SoundCategory category, float volume, float pitch);

    /**
     * 在世界中指定的位置播放一个声音. 对于有多个变体的声音, 传递相同的种子将始终播放相同的变体.
     * <p>
     * 如果位置或声音为空则这个函数会失效.
     * <p>
     * 原文：Play a Sound at the provided Location in the World. For sounds with multiple
     * variations passing the same seed will always play the same variation.
     * <p>
     * This function will fail silently if Location or Sound are null.
     *
     * @param location 播放声音的位置
     * @param sound 要播放的声音
     * @param category 声音类别
     * @param volume 声音音量
     * @param pitch 声音音调
     * @param seed 声音种子
     */
    void playSound(@NotNull Location location, @NotNull Sound sound, @NotNull SoundCategory category, float volume, float pitch, long seed);

    /**
     * 在世界中指定的位置播放一个声音. 对于有多个变体的声音, 传递相同的种子将始终播放相同的变体.
     * <p>
     * 如果位置或声音为空则这个函数会失效. 如果客户端没有对应传入值的声音, 玩家将不会听到任何声音.
     * <p>
     * 原文：Play a Sound at the provided Location in the World. For sounds with multiple
     * variations passing the same seed will always play the same variation.
     * <p>
     * This function will fail silently if Location or Sound are null. No sound will
     * be heard by the players if their clients do not have the respective sound for
     * the value passed.
     *
     * @param location 播放声音的位置
     * @param sound 要播放的内部声音名称
     * @param category 声音类别
     * @param volume 声音音量
     * @param pitch 声音音调
     * @param seed 声音种子
     */
    void playSound(@NotNull Location location, @NotNull String sound, @NotNull SoundCategory category, float volume, float pitch, long seed);

    /**
     * 在世界中指定实体的位置播放一个声音.
     * <p>
     * 如果实体或声音为空则这个函数会失效.
     * <p>
     * 原文：Play a Sound at the location of the provided entity in the World.
     * <p>
     * This function will fail silently if Entity or Sound are null.
     *
     * @param entity 播放声音的实体
     * @param sound 要播放的声音
     * @param volume 声音音量
     * @param pitch 声音音调
     */
    void playSound(@NotNull Entity entity, @NotNull Sound sound, float volume, float pitch);

    /**
     * 在世界中指定实体的位置播放一个声音.
     * <p>
     * 如果实体或声音为空则这个函数会失效.
     * <p>
     * 原文：Play a Sound at the location of the provided entity in the World.
     * <p>
     * This function will fail silently if Entity or Sound are null.
     *
     * @param entity 播放声音的实体
     * @param sound 要播放的声音
     * @param volume 声音音量
     * @param pitch 声音音调
     */
    void playSound(@NotNull Entity entity, @NotNull String sound, float volume, float pitch);

    /**
     * 在世界中指定实体的位置播放一个声音.
     * <p>
     * 如果实体或声音为空则这个函数会失效.
     * <p>
     * 原文：Play a Sound at the location of the provided entity in the World.
     * <p>
     * This function will fail silently if Entity or Sound are null.
     *
     * @param entity 播放声音的实体
     * @param sound 要播放的声音
     * @param category 声音类别
     * @param volume 声音音量
     * @param pitch 声音音调
     */
    void playSound(@NotNull Entity entity, @NotNull Sound sound, @NotNull SoundCategory category, float volume, float pitch);

    /**
     * 在世界中指定实体的位置播放一个声音.
     * <p>
     * 如果实体或声音为空则这个函数会失效.
     * <p>
     * 原文：Play a Sound at the location of the provided entity in the World.
     * <p>
     * This function will fail silently if Entity or Sound are null.
     *
     * @param entity 播放声音的实体
     * @param sound 要播放的声音
     * @param category 声音类别
     * @param volume 声音音量
     * @param pitch 声音音调
     */
    void playSound(@NotNull Entity entity, @NotNull String sound, @NotNull SoundCategory category, float volume, float pitch);

    /**
     * 在世界中指定实体的位置播放一个声音. 对于有多个变体的声音, 传递相同的种子将始终播放相同的变体.
     * <p>
     * 如果实体或声音为空则这个函数会失效.
     * <p>
     * 原文：Play a Sound at the location of the provided entity in the World. For sounds
     * with multiple variations passing the same seed will always play the same
     * variation.
     * <p>
     * This function will fail silently if Entity or Sound are null.
     *
     * @param entity 播放声音的实体
     * @param sound 要播放的声音
     * @param category 声音类别
     * @param volume 声音音量
     * @param pitch 声音音调
     * @param seed 声音种子
     */
    void playSound(@NotNull Entity entity, @NotNull Sound sound, @NotNull SoundCategory category, float volume, float pitch, long seed);

    /**
     * 在世界中指定实体的位置播放一个声音. 对于有多个变体的声音, 传递相同的种子将始终播放相同的变体.
     * <p>
     * 如果实体或声音为空则这个函数会失效.
     * <p>
     * 原文：Play a Sound at the location of the provided entity in the World. For sounds
     * with multiple variations passing the same seed will always play the same
     * variation.
     * <p>
     * This function will fail silently if Entity or Sound are null.
     *
     * @param entity 播放声音的实体
     * @param sound 要播放的声音
     * @param category 声音类别
     * @param volume 声音音量
     * @param pitch 声音音调
     * @param seed 声音种子
     */
    void playSound(@NotNull Entity entity, @NotNull String sound, @NotNull SoundCategory category, float volume, float pitch, long seed);

    /**
     * 获取包含所有{@link GameRule 游戏规则}的数组.
     * <p>
     * 原文:Get an array containing the names of all the {@link GameRule}s.
     *
     * @return {@link GameRule 游戏规则}名列表.
     * @deprecated 请使用 {@link Registry#iterator()}.
     */
    @NotNull
    @Deprecated(since = "1.21.11")
    public String[] getGameRules();

    /**
     * 检查字符串是否是一个有效的游戏规则.
     * <p>
     * 原文：
     * Checks if string is a valid game rule
     *
     * @param rule 要检测的规则
     * @return 如果规则存在则返回true
     * @deprecated 请使用 {@link Registry#get(NamespacedKey)} instead.
     */
    @Deprecated(since = "1.21.11")
    public boolean isGameRule(@NotNull String rule);

    /**
     * 获取给定的{@link GameRule 游戏规则}的数据值.
     * <p>
     * 原文:Get the current value for a given {@link GameRule}.
     *
     * @param rule 游戏规则
     * @param <T> 游戏规则数据类型
     * @return 游戏规则值
     */
    @Nullable
    public <T> T getGameRuleValue(@NotNull GameRule<T> rule);

    /**
     * 获取给定{@link GameRule 游戏规则}的默认值. 不保证该值与当前值匹配.
     * <p>
     * 原文:Get the default value for a given {@link GameRule}. This value is not
     * guaranteed to match the current value.
     *
     * @param rule 游戏规则
     * @param <T> 游戏规则数据类型
     * @return 游戏规则默认值
     */
    @Nullable
    public <T> T getGameRuleDefault(@NotNull GameRule<T> rule);

    /**
     * 设置给定{@link GameRule 游戏规则}的数据值.
     * <p>
     * 原文:Set the given {@link GameRule}'s new value.
     *
     * @param rule 要更新的游戏规则
     * @param newValue 值
     * @param <T> 对应游戏规则的数据类型
     * @return 若设置成功返回true
     */
    public <T> boolean setGameRule(@NotNull GameRule<T> rule, @NotNull T newValue);

    /**
     * 获取这个世界的世界边界对象。
     * <p>
     * 原文：
     * Gets the world border for this world.
     *
     * @return 这个世界的世界边界对象
     */
    @NotNull
    public WorldBorder getWorldBorder();

    /**
     * 在目标位置生成粒子（由count指定数量）.
     * <p>
     * 原文：Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param particle 要生成的粒子
     * @param location 生成粒子的位置
     * @param count 粒子数量
     */
    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count);

    /**
     * 在目标位置生成粒子（由count指定数量）.
     * <p>
     * 原文：Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param particle 要生成的粒子
     * @param x 生成粒子的X轴位置
     * @param y 生成粒子的Y轴位置
     * @param z 生成粒子的Z轴位置
     * @param count 粒子数量
     */
    public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count);

    /**
     * 在目标位置生成粒子（由count指定数量）.
     * <p>
     * 原文：Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param <T> 粒子数据类型（参见{@link Particle#getDataType()}）
     * @param particle 要生成的粒子
     * @param location 生成粒子的位置
     * @param count 粒子数量
     * @param data 用于粒子的数据或null, 其类型取决于{@link Particle#getDataType()}
     */
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, @Nullable T data);


    /**
     * 在目标位置生成粒子（由count指定数量）.
     * <p>
     * 原文：Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param <T> 粒子数据类型（参见{@link Particle#getDataType()}）
     * @param particle 要生成的粒子
     * @param x 生成粒子的X轴位置
     * @param y 生成粒子的Y轴位置
     * @param z 生成粒子的Z轴位置
     * @param count 粒子数量
     * @param data 用于粒子的数据或null, 其类型取决于{@link Particle#getDataType()}
     */
    public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, @Nullable T data);

    /**
     * 在目标位置生成粒子（由count指定数量）. 每个粒子的位置将根据偏移参数在每个轴上进行正向和负向的随机偏移.
     * <p>
     * 原文：Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param particle 要生成的粒子
     * @param location 生成粒子的位置
     * @param count 粒子数量
     * @param offsetX X轴上的最大随机偏移量
     * @param offsetY Y轴上的最大随机偏移量
     * @param offsetZ Z轴上的最大随机偏移量
     */
    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ);

    /**
     * 在目标位置生成粒子（由count指定数量）. 每个粒子的位置将根据偏移参数在每个轴上进行正向和负向的随机偏移.
     * <p>
     * 原文：Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param particle 要生成的粒子
     * @param x 生成粒子的X轴位置
     * @param y 生成粒子的Y轴位置
     * @param z 生成粒子的Z轴位置
     * @param count 粒子数量
     * @param offsetX X轴上的最大随机偏移量
     * @param offsetY Y轴上的最大随机偏移量
     * @param offsetZ Z轴上的最大随机偏移量
     */
    public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ);

    /**
     * 在目标位置生成粒子（由count指定数量）. 每个粒子的位置将根据偏移参数在每个轴上进行正向和负向的随机偏移.
     * <p>
     * 原文：Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> 粒子数据类型（参见{@link Particle#getDataType()}）
     * @param particle 要生成的粒子
     * @param location 生成粒子的位置
     * @param count 粒子数量
     * @param offsetX X轴上的最大随机偏移量
     * @param offsetY Y轴上的最大随机偏移量
     * @param offsetZ Z轴上的最大随机偏移量
     * @param data 用于粒子的数据或null, 其类型取决于{@link Particle#getDataType()}
     */
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, @Nullable T data);

    /**
     * 在目标位置生成粒子（由count指定数量）. 每个粒子的位置将根据偏移参数在每个轴上进行正向和负向的随机偏移.
     * <p>
     * 原文：Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> 粒子数据类型（参见{@link Particle#getDataType()}）
     * @param particle 要生成的粒子
     * @param x 生成粒子的X轴位置
     * @param y 生成粒子的Y轴位置
     * @param z 生成粒子的Z轴位置
     * @param count 粒子数量
     * @param offsetX X轴上的最大随机偏移量
     * @param offsetY Y轴上的最大随机偏移量
     * @param offsetZ Z轴上的最大随机偏移量
     * @param data 用于粒子的数据或null, 其类型取决于{@link Particle#getDataType()}
     */
    public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, @Nullable T data);

    /**
     * 在目标位置生成粒子（由count指定数量）. 每个粒子的位置将根据偏移参数在每个轴上进行正向和负向的随机偏移.
     * <p>
     * 原文：Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param particle 要生成的粒子
     * @param location 生成粒子的位置
     * @param count 粒子数量
     * @param offsetX X轴上的最大随机偏移量
     * @param offsetY Y轴上的最大随机偏移量
     * @param offsetZ Z轴上的最大随机偏移量
     * @param extra 此粒子的额外数据, 取决于使用的粒子（通常是速度）
     */
    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, double extra);

    /**
     * 在目标位置生成粒子（由count指定数量）. 每个粒子的位置将根据偏移参数在每个轴上进行正向和负向的随机偏移.
     * <p>
     * 原文：Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param particle 要生成的粒子
     * @param x 生成粒子的X轴位置
     * @param y 生成粒子的Y轴位置
     * @param z 生成粒子的Z轴位置
     * @param count 粒子数量
     * @param offsetX X轴上的最大随机偏移量
     * @param offsetY Y轴上的最大随机偏移量
     * @param offsetZ Z轴上的最大随机偏移量
     * @param extra 此粒子的额外数据, 取决于使用的粒子（通常是速度）
     */
    public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra);

    /**
     * 在目标位置生成粒子（由count指定数量）. 每个粒子的位置将根据偏移参数在每个轴上进行正向和负向的随机偏移.
     * <p>
     * 原文：Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> 粒子数据类型（参见{@link Particle#getDataType()}）
     * @param particle 要生成的粒子
     * @param location 生成粒子的位置
     * @param count 粒子数量
     * @param offsetX X轴上的最大随机偏移量
     * @param offsetY Y轴上的最大随机偏移量
     * @param offsetZ Z轴上的最大随机偏移量
     * @param extra 此粒子的额外数据, 取决于使用的粒子（通常是速度）
     * @param data 用于粒子的数据或null, 其类型取决于{@link Particle#getDataType()}
     */
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data);

    /**
     * 在目标位置生成粒子（由count指定数量）. 每个粒子的位置将根据偏移参数在每个轴上进行正向和负向的随机偏移.
     * <p>
     * 原文：Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> 粒子数据类型（参见{@link Particle#getDataType()}）
     * @param particle 要生成的粒子
     * @param x 生成粒子的X轴位置
     * @param y 生成粒子的Y轴位置
     * @param z 生成粒子的Z轴位置
     * @param count 粒子数量
     * @param offsetX X轴上的最大随机偏移量
     * @param offsetY Y轴上的最大随机偏移量
     * @param offsetZ Z轴上的最大随机偏移量
     * @param extra 此粒子的额外数据, 取决于使用的粒子（通常是速度）
     * @param data 用于粒子的数据或null, 其类型取决于{@link Particle#getDataType()}
     */
    public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data);

    /**
     * 在目标位置生成粒子（由count指定数量）. 每个粒子的位置将根据偏移参数在每个轴上进行正向和负向的随机偏移.
     * <p>
     * 原文：Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> 粒子数据类型（参见{@link Particle#getDataType()}）
     * @param particle 要生成的粒子
     * @param location 生成粒子的位置
     * @param count 粒子数量
     * @param offsetX X轴上的最大随机偏移量
     * @param offsetY Y轴上的最大随机偏移量
     * @param offsetZ Z轴上的最大随机偏移量
     * @param extra 此粒子的额外数据, 取决于使用的粒子（通常是速度）
     * @param data 用于粒子的数据或null, 其类型取决于{@link Particle#getDataType()}
     * @param force 是否将粒子发送给扩展范围内的玩家并强制其客户端渲染, 无论设置如何
     */
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data, boolean force);

    /**
     * 在目标位置生成粒子（由count指定数量）. 每个粒子的位置将根据偏移参数在每个轴上进行正向和负向的随机偏移.
     * <p>
     * 原文：Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> 粒子数据类型（参见{@link Particle#getDataType()}）
     * @param particle 要生成的粒子
     * @param x 生成粒子的X轴位置
     * @param y 生成粒子的Y轴位置
     * @param z 生成粒子的Z轴位置
     * @param count 粒子数量
     * @param offsetX X轴上的最大随机偏移量
     * @param offsetY Y轴上的最大随机偏移量
     * @param offsetZ Z轴上的最大随机偏移量
     * @param extra 此粒子的额外数据, 取决于使用的粒子（通常是速度）
     * @param data 用于粒子的数据或null, 其类型取决于{@link Particle#getDataType()}
     * @param force 是否将粒子发送给扩展范围内的玩家并强制其客户端渲染, 无论设置如何
     */
    public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data, boolean force);

    /**
     * 查找最近的指定{@link StructureType 结构类型}的结构.
     * 查找未探索的结构可能会阻塞, 如果世界正在查看尚未生成的区块. 这可能导致世界在定位未探索的结构时暂时冻结.
     * <p>
     * {@code radius}不是严格的方形半径. 每种结构可能改变每次迭代检查的区块数量. 不要假设只会检查半径*半径的区块区域. 例如,
     * {@link StructureType#WOODLAND_MANSION}可能会检查距离20000个方块（或更多）远的地方, 无论使用的半径是多少.
     * <p>
     * 此方法<i>不会</i>加载或生成区块. 如果你只查找未探索的结构, 这也可能导致服务器挂起的情况. 这是因为它会不断向外寻找以找到该结构.
     * <p>
     * 原文：Find the closest nearby structure of a given {@link StructureType}.
     * Finding unexplored structures can, and will, block if the world is
     * looking in chunks that gave not generated yet. This can lead to the world
     * temporarily freezing while locating an unexplored structure.
     * <p>
     * The {@code radius} is not a rigid square radius. Each structure may alter
     * how many chunks to check for each iteration. Do not assume that only a
     * radius x radius chunk area will be checked. For example,
     * {@link StructureType#WOODLAND_MANSION} can potentially check up to 20,000
     * blocks away (or more) regardless of the radius used.
     * <p>
     * This will <i>not</i> load or generate chunks. This can also lead to
     * instances where the server can hang if you are only looking for
     * unexplored structures. This is because it will keep looking further and
     * further out in order to find the structure.
     *
     * @param origin 开始查找结构的位置
     * @param structureType 要查找的结构类型
     * @param radius 搜索半径（以区块为单位）
     * @param findUnexplored 是否只查找未探索的结构
     * @return 最近的{@link Location 位置}, 如果不存在指定类型的结构则返回null
     * @see #locateNearestStructure(Location, Structure, int, boolean)
     * @see #locateNearestStructure(Location, StructureType, int, boolean)
     * @deprecated 建议使用
     * {@link #locateNearestStructure(Location, Structure, int, boolean)} 或
     * {@link #locateNearestStructure(Location, StructureType, int, boolean)}
     */
    @Nullable
    @Deprecated(since = "1.19")
    public Location locateNearestStructure(@NotNull Location origin, @NotNull org.bukkit.StructureType structureType, int radius, boolean findUnexplored);

    /**
     * 查找最近的指定{@link StructureType 结构类型}的结构.
     * 查找未探索的结构可能会阻塞, 如果世界正在查看尚未生成的区块. 这可能导致世界在定位未探索的结构时暂时冻结.
     * <p>
     * {@code radius}不是严格的方形半径. 每种结构可能改变每次迭代检查的区块数量. 不要假设只会检查半径*半径的区块区域. 例如,
     * {@link StructureType#WOODLAND_MANSION}可能会检查距离20000个方块（或更多）远的地方, 无论使用的半径是多少.
     * <p>
     * 此方法<i>不会</i>加载或生成区块. 如果你只查找未探索的结构, 这也可能导致服务器挂起的情况. 这是因为它会不断向外寻找以找到该结构.
     * <p>
     * 搜索{@link StructureType}和{@link Structure}的区别在于, {@link StructureType}可以引用多个{@link Structure 结构},
     * 而搜索{@link Structure}只会搜索给定的{@link Structure}.
     * <p>
     * 原文：Find the closest nearby structure of a given {@link StructureType}.
     * Finding unexplored structures can, and will, block if the world is
     * looking in chunks that gave not generated yet. This can lead to the world
     * temporarily freezing while locating an unexplored structure.
     * <p>
     * The {@code radius} is not a rigid square radius. Each structure may alter
     * how many chunks to check for each iteration. Do not assume that only a
     * radius x radius chunk area will be checked. For example,
     * {@link StructureType#WOODLAND_MANSION} can potentially check up to 20,000
     * blocks away (or more) regardless of the radius used.
     * <p>
     * This will <i>not</i> load or generate chunks. This can also lead to
     * instances where the server can hang if you are only looking for
     * unexplored structures. This is because it will keep looking further and
     * further out in order to find the structure.
     * <p>
     * The difference between searching for a {@link StructureType} and a
     * {@link Structure} is, that a {@link StructureType} can refer to multiple
     * {@link Structure Structures} while searching for a {@link Structure}
     * while only search for the given {@link Structure}.
     *
     * @param origin 开始查找结构的位置
     * @param structureType 要查找的结构类型
     * @param radius 搜索半径（以区块为单位）
     * @param findUnexplored 是否只查找未探索的结构
     * @return 最近的{@link Location 位置}和{@link Structure 结构}, 如果不存在指定类型的结构则返回null
     * @see #locateNearestStructure(Location, Structure, int, boolean)
     */
    @Nullable
    StructureSearchResult locateNearestStructure(@NotNull Location origin, @NotNull StructureType structureType, int radius, boolean findUnexplored);

    /**
     * 查找最近的指定{@link Structure 结构}的结构.
     * 查找未探索的结构可能会阻塞, 如果世界正在查看尚未生成的区块. 这可能导致世界在定位未探索的结构时暂时冻结.
     * <p>
     * {@code radius}不是严格的方形半径. 每种结构可能改变每次迭代检查的区块数量. 不要假设只会检查半径*半径的区块区域. 例如,
     * {@link Structure#MANSION}可能会检查距离20000个方块（或更多）远的地方, 无论使用的半径是多少.
     * <p>
     * 此方法<i>不会</i>加载或生成区块. 如果你只查找未探索的结构, 这也可能导致服务器挂起的情况. 这是因为它会不断向外寻找以找到该结构.
     * <p>
     * 搜索{@link StructureType}和{@link Structure}的区别在于, {@link StructureType}可以引用多个{@link Structure 结构},
     * 而搜索{@link Structure}只会搜索给定的{@link Structure}.
     * <p>
     * 原文：Find the closest nearby structure of a given {@link Structure}. Finding
     * unexplored structures can, and will, block if the world is looking in
     * chunks that gave not generated yet. This can lead to the world
     * temporarily freezing while locating an unexplored structure.
     * <p>
     * The {@code radius} is not a rigid square radius. Each structure may alter
     * how many chunks to check for each iteration. Do not assume that only a
     * radius x radius chunk area will be checked. For example,
     * {@link Structure#MANSION} can potentially check up to 20,000 blocks away
     * (or more) regardless of the radius used.
     * <p>
     * This will <i>not</i> load or generate chunks. This can also lead to
     * instances where the server can hang if you are only looking for
     * unexplored structures. This is because it will keep looking further and
     * further out in order to find the structure.
     * <p>
     * The difference between searching for a {@link StructureType} and a
     * {@link Structure} is, that a {@link StructureType} can refer to multiple
     * {@link Structure Structures} while searching for a {@link Structure}
     * while only search for the given {@link Structure}.
     *
     * @param origin 开始查找结构的位置
     * @param structure 要查找的结构
     * @param radius 搜索半径（以区块为单位）
     * @param findUnexplored 是否只查找未探索的结构
     * @return 最近的{@link Location 位置}和{@link Structure 结构}, 如果未找到结构则返回null
     * @see #locateNearestStructure(Location, StructureType, int, boolean)
     */
    @Nullable
    StructureSearchResult locateNearestStructure(@NotNull Location origin, @NotNull Structure structure, int radius, boolean findUnexplored);

    // Spigot start
    public class Spigot {

        /**
         * 在给定的{@link Location 位置}劈下闪电, 可能不发出声音.
         * <p>
         * 原文：Strikes lightning at the given {@link Location} and possibly without sound
         *
         * @param loc 劈下闪电的位置
         * @param isSilent 此次闪电是否不发出声音
         * @return 闪电实体
         * @deprecated 声音现在是客户端侧的, 无法移除
         * @see World#strikeLightning(org.bukkit.Location)
         */
        @NotNull
        @Deprecated(since = "1.20.4")
        public LightningStrike strikeLightning(@NotNull Location loc, boolean isSilent) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * 在给定的{@link Location 位置}劈下不会造成伤害的闪电, 可能不发出声音.
         * <p>
         * 原文：Strikes lightning at the given {@link Location} without doing damage and possibly without sound
         *
         * @param loc 劈下闪电的位置
         * @param isSilent 此次闪电是否不发出声音
         * @return 闪电实体
         * @deprecated 声音现在是客户端侧的, 无法移除
         * @see World#strikeLightningEffect(org.bukkit.Location)
         */
        @NotNull
        @Deprecated(since = "1.20.4")
        public LightningStrike strikeLightningEffect(@NotNull Location loc, boolean isSilent) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @NotNull
    Spigot spigot();
    // Spigot end

    /**
     * 查找最近的与提供的{@link Biome 生物群系}匹配的位置.
     * 查找生物群系可能会阻塞, 如果世界正在查看尚未生成的区块. 这可能导致世界在定位生物群系时暂时冻结.
     * <p>
     * <b>注意：</b>此方法<i>不会</i>反映世界生成后所做的更改, 此方法只能看到世界生成时的生物群系.
     * 此方法<i>不会</i>加载或生成区块.
     * <p>
     * 如果提供了多个生物群系, {@link BiomeSearchResult#getBiome()}将指示定位到的是哪一个.
     * <p>
     * 此方法将使用32的水平间隔和64的垂直间隔, 等同于/locate命令.
     * <p>
     * 原文：Find the closest nearby location with a biome matching the provided
     * {@link Biome}(s). Finding biomes can, and will, block if the world is looking
     * in chunks that have not generated yet. This can lead to the world temporarily
     * freezing while locating a biome.
     * <p>
     * <b>Note:</b> This will <i>not</i> reflect changes made to the world after
     * generation, this method only sees the biome at the time of world generation.
     * This will <i>not</i> load or generate chunks.
     * <p>
     * If multiple biomes are provided {@link BiomeSearchResult#getBiome()} will
     * indicate which one was located.
     * <p>
     * This method will use a horizontal interval of 32 and a vertical interval of
     * 64, equal to the /locate command.
     *
     * @param origin 开始查找生物群系的位置
     * @param radius 搜索半径（以方块为单位）
     * @param biomes 要搜索的生物群系
     * @return 包含最近的{@link Location 位置}和{@link Biome 生物群系}的BiomeSearchResult, 如果未找到生物群系则返回null
     * @see #locateNearestBiome(Location, int, int, int, Biome...)
     */
    @Nullable
    BiomeSearchResult locateNearestBiome(@NotNull Location origin, int radius, @NotNull Biome... biomes);

    /**
     * 查找最近的与提供的{@link Biome 生物群系}匹配的位置.
     * 查找生物群系可能会阻塞, 如果世界正在查看尚未生成的区块. 这可能导致世界在定位生物群系时暂时冻结.
     * <p>
     * <b>注意：</b>此方法<i>不会</i>反映世界生成后所做的更改, 此方法只能看到世界生成时的生物群系.
     * 此方法<i>不会</i>加载或生成区块.
     * <p>
     * 如果提供了多个生物群系, {@link BiomeSearchResult#getBiome()}将指示定位到的是哪一个.
     * 较高的{@code horizontalInterval}和{@code verticalInterval}值将导致更快的搜索, 但可能会遗漏较小的生物群系.
     * <p>
     * 原文：Find the closest nearby location with a biome matching the provided
     * {@link Biome}(s). Finding biomes can, and will, block if the world is looking
     * in chunks that have not generated yet. This can lead to the world temporarily
     * freezing while locating a biome.
     * <p>
     * <b>Note:</b> This will <i>not</i> reflect changes made to the world after
     * generation, this method only sees the biome at the time of world generation.
     * This will <i>not</i> load or generate chunks.
     * <p>
     * If multiple biomes are provided {@link BiomeSearchResult#getBiome()} will
     * indicate which one was located. Higher values for {@code horizontalInterval}
     * and {@code verticalInterval} will result in faster searches, but may lead to
     * small biomes being missed.
     *
     * @param origin             开始查找生物群系的位置
     * @param radius             搜索半径（以方块为单位）
     * @param horizontalInterval 每次检查之间的水平距离
     * @param verticalInterval   每次检查之间的垂直距离
     * @param biomes             要搜索的生物群系
     * @return 包含最近的{@link Location 位置}和{@link Biome 生物群系}的BiomeSearchResult, 如果未找到生物群系则返回null
     * @see #locateNearestBiome(Location, int, Biome...)
     */
    @Nullable
    BiomeSearchResult locateNearestBiome(@NotNull Location origin, int radius, int horizontalInterval, int verticalInterval, @NotNull Biome... biomes);

    /**
     * 寻找与给定位置相距最近的袭击.
     * <p>
     * 原文:Finds the nearest raid close to the given location.
     *
     * @param location 源位置
     * @param radius 搜索半径
     * @return 最近的{@link Raid 袭击}, 如果没有找到袭击事件返回null.
     */
    @Nullable
    public Raid locateNearestRaid(@NotNull Location location, int radius);

    /**
     * 获取本世界正在进行的所有袭击.
     * <p>
     * 原文:Gets all raids that are going on over this world.
     *
     * @return 本世界所有活跃的袭击
     */
    @NotNull
    public List<Raid> getRaids();

    /**
     * 获取与此世界关联的{@link DragonBattle 末影龙战斗}.
     * <p>
     * 如果此世界的环境不是{@link Environment#THE_END}, 将返回null.
     * <p>
     * 如果是末地世界, 无论世界中是否存在末影龙或是否已激活战斗序列, 都将返回一个末影龙战斗实例. 末影龙战斗实例用作状态持有者.
     * <p>
     * 原文：Get the {@link DragonBattle} associated with this world.
     *
     * If this world's environment is not {@link Environment#THE_END}, null will
     * be returned.
     * <p>
     * If an end world, a dragon battle instance will be returned regardless of
     * whether or not a dragon is present in the world or a fight sequence has
     * been activated. The dragon battle instance acts as a state holder.
     *
     * @return 末影龙战斗实例
     */
    @Nullable
    public DragonBattle getEnderDragonBattle();

    /**
     * 获取此世界启用的所有{@link FeatureFlag 功能标志}.
     * <p>
     * 原文：Get all {@link FeatureFlag} enabled in this world.
     *
     * @return 所有启用的{@link FeatureFlag 功能标志}
     */
    @NotNull
    public Set<FeatureFlag> getFeatureFlags();

    /**
     * 获取与给定坐标区块相交的所有已生成结构. <br>
     * 如果不存在结构, 则返回空集合.
     * <p>
     * 原文：Gets all generated structures that intersect the chunk at the given
     * coordinates. <br>
     * If no structures are present an empty collection will be returned.
     *
     * @param x 区块的X坐标
     * @param z 区块的Z坐标
     * @return 给定坐标区块中已放置的结构集合
     */
    @NotNull
    public Collection<GeneratedStructure> getStructures(int x, int z);

    /**
     * 获取与给定坐标区块相交的所有指定{@link Structure 结构}的已生成结构. <br>
     * 如果不存在结构, 则返回空集合.
     * <p>
     * 原文：Gets all generated structures of a given {@link Structure} that intersect
     * the chunk at the given coordinates. <br>
     * If no structures are present an empty collection will be returned.
     *
     * @param x 区块的X坐标
     * @param z 区块的Z坐标
     * @param structure 要查找的结构
     * @return 给定坐标区块中已放置的结构集合
     */
    @NotNull
    public Collection<GeneratedStructure> getStructures(int x, int z, @NotNull Structure structure);

    /**
     * 表示世界可能的各种地图环境类型.
     */
    public enum Environment {

        /**
         * 表示"normal"/"surface world"地图.
         */
        NORMAL(0),
        /**
         * 表示一个基于"hell"地图的地狱.
         */
        NETHER(-1),
        /**
         * 表示"end"地图.
         */
        THE_END(1),
        /**
         * 代表自定义维度.
         */
        CUSTOM(-999);

        private final int id;
        private static final Map<Integer, Environment> lookup = new HashMap<Integer, Environment>();

        private Environment(int id) {
            this.id = id;
        }

        /**
         * 获取这个环境的ID.
         * <p>
         * 原文：
         * Gets the dimension ID of this environment
         *
         * @return ID
         * @deprecated 不安全的参数
         */
        @Deprecated(since = "1.6.2")
        public int getId() {
            return id;
        }

        /**
         * 根据ID获取环境.
         * <p>
         * 原文：
         * Get an environment by ID
         *
         * @param id 环境ID
         * @return 环境
         * @deprecated 不安全的参数
         */
        @Deprecated(since = "1.6.2")
        @Nullable
        public static Environment getEnvironment(int id) {
            return lookup.get(id);
        }

        static {
            for (Environment env : values()) {
                lookup.put(env.getId(), env);
            }
        }
    }
}