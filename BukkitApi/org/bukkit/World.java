package org.bukkit;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.messaging.PluginMessageRecipient;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Consumer;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一个世界,包含了{@link Entity 实体},{@link Chunk 区块},{@link Block 方块}
 */
public interface World extends RegionAccessor, WorldInfo, PluginMessageRecipient, Metadatable {

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
     * 获取指定坐标最高处不是空气且不可逾越的方块的y坐标.
     * <p>
     * 原文:Gets the highest non-empty (impassable) coordinate at the given
     * coordinates.
     *
     * @param x 方块x坐标
     * @param z 方块y坐标
     * @return 指定坐标最高处不是空气且不可逾越的方块的y坐标
     */
    public int getHighestBlockYAt(int x, int z);

    /**
     * 获取指定{@link Location 位置}最高处不是空气且不可逾越的方块的y坐标.
     * <p>
     * 原文:Gets the highest non-empty (impassable) coordinate at the given
     * {@link Location}.
     *
     * @param location 方块坐标
     * @return 指定位置最高处不是空气且不可逾越的方块的y坐标
     */
    public int getHighestBlockYAt(@NotNull Location location);

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
     * Gets the highest coordinate corresponding to the {@link HeightMap} at the
     * given coordinates.
     *
     * @param x X-coordinate of the blocks
     * @param z Z-coordinate of the blocks
     * @param heightMap the heightMap that is used to determine the highest
     * point
     *
     * @return Y-coordinate of the highest block corresponding to the
     * {@link HeightMap}
     */
    public int getHighestBlockYAt(int x, int z, @NotNull HeightMap heightMap);

    /**
     * Gets the highest coordinate corresponding to the {@link HeightMap} at the
     * given {@link Location}.
     *
     * @param location Location of the blocks
     * @param heightMap the heightMap that is used to determine the highest
     * point
     * @return Y-coordinate of the highest block corresponding to the
     * {@link HeightMap}
     */
    public int getHighestBlockYAt(@NotNull Location location, @NotNull HeightMap heightMap);

    /**
     * Gets the highest block corresponding to the {@link HeightMap} at the
     * given coordinates.
     *
     * @param x X-coordinate of the block
     * @param z Z-coordinate of the block
     * @param heightMap the heightMap that is used to determine the highest
     * point
     * @return Highest block corresponding to the {@link HeightMap}
     */
    @NotNull
    public Block getHighestBlockAt(int x, int z, @NotNull HeightMap heightMap);

    /**
     * Gets the highest block corresponding to the {@link HeightMap} at the
     * given coordinates.
     *
     * @param location Coordinates to get the highest block
     * @param heightMap the heightMap that is used to determine the highest
     * point
     * @return Highest block corresponding to the {@link HeightMap}
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
    @Deprecated
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
    @Deprecated
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
    @Deprecated
    public boolean refreshChunk(int x, int z);

    /**
     * Gets whether the chunk at the specified chunk coordinates is force
     * loaded.
     * <p>
     * A force loaded chunk will not be unloaded due to lack of player activity.
     *
     * @param x X-coordinate of the chunk
     * @param z Z-coordinate of the chunk
     * @return force load status
     */
    public boolean isChunkForceLoaded(int x, int z);

    /**
     * Sets whether the chunk at the specified chunk coordinates is force
     * loaded.
     * <p>
     * A force loaded chunk will not be unloaded due to lack of player activity.
     *
     * @param x X-coordinate of the chunk
     * @param z Z-coordinate of the chunk
     * @param forced force load status
     */
    public void setChunkForceLoaded(int x, int z, boolean forced);

    /**
     * Returns all force loaded chunks in this world.
     * <p>
     * A force loaded chunk will not be unloaded due to lack of player activity.
     *
     * @return unmodifiable collection of force loaded chunks
     */
    @NotNull
    public Collection<Chunk> getForceLoadedChunks();

    /**
     * Adds a plugin ticket for the specified chunk, loading the chunk if it is
     * not already loaded.
     * <p>
     * A plugin ticket will prevent a chunk from unloading until it is
     * explicitly removed. A plugin instance may only have one ticket per chunk,
     * but each chunk can have multiple plugin tickets.
     * </p>
     *
     * @param x X-coordinate of the chunk
     * @param z Z-coordinate of the chunk
     * @param plugin Plugin which owns the ticket
     * @return {@code true} if a plugin ticket was added, {@code false} if the
     * ticket already exists for the plugin
     * @throws IllegalStateException If the specified plugin is not enabled
     * @see #removePluginChunkTicket(int, int, Plugin)
     */
    public boolean addPluginChunkTicket(int x, int z, @NotNull Plugin plugin);

    /**
     * Removes the specified plugin's ticket for the specified chunk
     * <p>
     * A plugin ticket will prevent a chunk from unloading until it is
     * explicitly removed. A plugin instance may only have one ticket per chunk,
     * but each chunk can have multiple plugin tickets.
     * </p>
     *
     * @param x X-coordinate of the chunk
     * @param z Z-coordinate of the chunk
     * @param plugin Plugin which owns the ticket
     * @return {@code true} if the plugin ticket was removed, {@code false} if
     * there is no plugin ticket for the chunk
     * @see #addPluginChunkTicket(int, int, Plugin)
     */
    public boolean removePluginChunkTicket(int x, int z, @NotNull Plugin plugin);

    /**
     * Removes all plugin tickets for the specified plugin
     * <p>
     * A plugin ticket will prevent a chunk from unloading until it is
     * explicitly removed. A plugin instance may only have one ticket per chunk,
     * but each chunk can have multiple plugin tickets.
     * </p>
     *
     * @param plugin Specified plugin
     * @see #addPluginChunkTicket(int, int, Plugin)
     * @see #removePluginChunkTicket(int, int, Plugin)
     */
    public void removePluginChunkTickets(@NotNull Plugin plugin);

    /**
     * Retrieves a collection specifying which plugins have tickets for the
     * specified chunk. This collection is not updated when plugin tickets are
     * added or removed to the chunk.
     * <p>
     * A plugin ticket will prevent a chunk from unloading until it is
     * explicitly removed. A plugin instance may only have one ticket per chunk,
     * but each chunk can have multiple plugin tickets.
     * </p>
     *
     * @param x X-coordinate of the chunk
     * @param z Z-coordinate of the chunk
     * @return unmodifiable collection containing which plugins have tickets for
     * the chunk
     * @see #addPluginChunkTicket(int, int, Plugin)
     * @see #removePluginChunkTicket(int, int, Plugin)
     */
    @NotNull
    public Collection<Plugin> getPluginChunkTickets(int x, int z);

    /**
     * Returns a map of which plugins have tickets for what chunks. The returned
     * map is not updated when plugin tickets are added or removed to chunks. If
     * a plugin has no tickets, it will be absent from the map.
     * <p>
     * A plugin ticket will prevent a chunk from unloading until it is
     * explicitly removed. A plugin instance may only have one ticket per chunk,
     * but each chunk can have multiple plugin tickets.
     * </p>
     *
     * @return unmodifiable map containing which plugins have tickets for what
     * chunks
     * @see #addPluginChunkTicket(int, int, Plugin)
     * @see #removePluginChunkTicket(int, int, Plugin)
     */
    @NotNull
    public Map<Plugin, Collection<Chunk>> getPluginChunkTickets();

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
     * Drops an item at the specified {@link Location}
     * Note that functions will run before the entity is spawned
     *
     * @param location Location to drop the item
     * @param item ItemStack to drop
     * @param function the function to be run before the entity is spawned.
     * @return ItemDrop entity created as a result of this method
     */
    @NotNull
    public Item dropItem(@NotNull Location location, @NotNull ItemStack item, @Nullable Consumer<Item> function);

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
     * Drops an item at the specified {@link Location} with a random offset
     * Note that functions will run before the entity is spawned
     *
     * @param location Location to drop the item
     * @param item ItemStack to drop
     * @param function the function to be run before the entity is spawned.
     * @return ItemDrop entity created as a result of this method
     */
    @NotNull
    public Item dropItemNaturally(@NotNull Location location, @NotNull ItemStack item, @Nullable Consumer<Item> function);

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
     * Creates an arrow entity of the given class at the given {@link Location}
     *
     * @param <T> type of arrow to spawn
     * @param location Location to spawn the arrow
     * @param direction Direction to shoot the arrow in
     * @param speed Speed of the arrow. A recommend speed is 0.6
     * @param spread Spread of the arrow. A recommend spread is 12
     * @param clazz the Entity class for the arrow
     * {@link org.bukkit.entity.SpectralArrow},{@link org.bukkit.entity.Arrow},{@link org.bukkit.entity.TippedArrow}
     * @return Arrow entity spawned as a result of this method
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
     * @see #generateTree(org.bukkit.Location, java.util.Random, org.bukkit.TreeType, org.bukkit.util.Consumer)
     * @deprecated this method does not handle tile entities (bee nests)
     */
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
    @Deprecated
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
     * Returns a list of entities within a bounding box centered around a
     * Location.
     * <p>
     * This may not consider entities in currently unloaded chunks. Some
     * implementations may impose artificial restrictions on the size of the
     * search bounding box.
     *
     * @param location The center of the bounding box
     * @param x 1/2 the size of the box along x axis
     * @param y 1/2 the size of the box along y axis
     * @param z 1/2 the size of the box along z axis
     * @param filter only entities that fulfill this predicate are considered,
     *     or <code>null</code> to consider all entities
     * @return the collection of entities near location. This will always be a
     *     non-null collection.
     */
    @NotNull
    public Collection<Entity> getNearbyEntities(@NotNull Location location, double x, double y, double z, @Nullable Predicate<Entity> filter);

    /**
     * Returns a list of entities within the given bounding box.
     * <p>
     * This may not consider entities in currently unloaded chunks. Some
     * implementations may impose artificial restrictions on the size of the
     * search bounding box.
     *
     * @param boundingBox the bounding box
     * @return the collection of entities within the bounding box, will always
     *     be a non-null collection
     */
    @NotNull
    public Collection<Entity> getNearbyEntities(@NotNull BoundingBox boundingBox);

    /**
     * Returns a list of entities within the given bounding box.
     * <p>
     * This may not consider entities in currently unloaded chunks. Some
     * implementations may impose artificial restrictions on the size of the
     * search bounding box.
     *
     * @param boundingBox the bounding box
     * @param filter only entities that fulfill this predicate are considered,
     *     or <code>null</code> to consider all entities
     * @return the collection of entities within the bounding box, will always
     *     be a non-null collection
     */
    @NotNull
    public Collection<Entity> getNearbyEntities(@NotNull BoundingBox boundingBox, @Nullable Predicate<Entity> filter);

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
     *
     * @param start 起始位置
     * @param direction 射线方向
     * @param maxDistance 最大距离
     * @param filter 只考虑满足此过滤器的实体, 或者 <code>null</code> 考虑所有实体
     * @return 最近的射线跟踪命中结果, 如果没有命中, 则为<code>null</code>
     * @see #rayTraceEntities(Location, Vector, double, double, Predicate)
     */
    @Nullable
    public RayTraceResult rayTraceEntities(@NotNull Location start, @NotNull Vector direction, double maxDistance, @Nullable Predicate<Entity> filter);

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
    public RayTraceResult rayTraceEntities(@NotNull Location start, @NotNull Vector direction, double maxDistance, double raySize, @Nullable Predicate<Entity> filter);

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
    public RayTraceResult rayTrace(@NotNull Location start, @NotNull Vector direction, double maxDistance, @NotNull FluidCollisionMode fluidCollisionMode, boolean ignorePassableBlocks, double raySize, @Nullable Predicate<Entity> filter);

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
     * Gets the full in-game time on this world since the world generation
     *
     * @return The current absolute time since the world generation
     * @see #getTime() Returns a relative time of this world
     * @see #getFullTime() Returns an absolute time of this world
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
     * Creates explosion at given coordinates with given power and optionally
     * setting blocks on fire or breaking blocks.
     *
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     * @param power The power of explosion, where 4F is TNT
     * @param setFire Whether or not to set blocks on fire
     * @param breakBlocks Whether or not to have blocks be destroyed
     * @param source the source entity, used for tracking damage
     * @return false if explosion was canceled, otherwise true
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
     * Creates explosion at given coordinates with given power and optionally
     * setting blocks on fire or breaking blocks.
     *
     * @param loc Location to blow up
     * @param power The power of explosion, where 4F is TNT
     * @param setFire Whether or not to set blocks on fire
     * @param breakBlocks Whether or not to have blocks be destroyed
     * @return false if explosion was canceled, otherwise true
     */
    public boolean createExplosion(@NotNull Location loc, float power, boolean setFire, boolean breakBlocks);

    /**
     * Creates explosion at given coordinates with given power and optionally
     * setting blocks on fire or breaking blocks.
     *
     * @param loc Location to blow up
     * @param power The power of explosion, where 4F is TNT
     * @param setFire Whether or not to set blocks on fire
     * @param breakBlocks Whether or not to have blocks be destroyed
     * @param source the source entity, used for tracking damage
     * @return false if explosion was canceled, otherwise true
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
     * Gets the biome provider for this world
     *
     * @return BiomeProvider associated with this world
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
     * Spawn a {@link FallingBlock} entity at the given {@link Location} of
     * the specified {@link Material}. The material dictates what is falling.
     * When the FallingBlock hits the ground, it will place that block.
     * <p>
     * The Material must be a block type, check with {@link Material#isBlock()
     * material.isBlock()}. The Material may not be air.
     *
     * @param location The {@link Location} to spawn the FallingBlock
     * @param data The block data
     * @return The spawned {@link FallingBlock} instance
     * @throws IllegalArgumentException if {@link Location} or {@link
     *     MaterialData} are null or {@link Material} of the {@link MaterialData} is not a block
     */
    @NotNull
    public FallingBlock spawnFallingBlock(@NotNull Location location, @NotNull MaterialData data) throws IllegalArgumentException;

    /**
     * 在指定的{@link Location 位置}根据给定的{@link Material 物品}生成一个{@link FallingBlock 掉落中的方块}实体。物品决定下落的东西。当下落方块碰到地时就会放置这个方块.
     * <p>
     * 物品必须是一个经过{@link Material#isBlock()}检验的方块类型,可能不是空气.
     * <p>
     * 原文：
     * Spawn a {@link FallingBlock} entity at the given {@link Location} of
     * the specified {@link Material}. The material dictates what is falling.
     * When the FallingBlock hits the ground, it will place that block.
     * <p>
     * The Material must be a block type, check with {@link Material#isBlock()
     * material.isBlock()}. The Material may not be air.
     *
     * @param location 生成下落方块的{@link Location 位置}
     * @param data 方块数据
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
    @Deprecated
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
    @Deprecated
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
    @Deprecated
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
    @Deprecated
    public double getTemperature(int x, int z);

    /**
     * Gets the temperature for the given block coordinates.
     * <p>
     * It is safe to run this method when the block does not exist, it will
     * not create the block.
     * <p>
     * This method will return the raw temperature without adjusting for block
     * height effects.
     *
     * @param x X coordinate of the block
     * @param y Y coordinate of the block
     * @param z Z coordinate of the block
     * @return Temperature of the requested block
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
    @Deprecated
    public double getHumidity(int x, int z);

    /**
     * Gets the humidity for the given block coordinates.
     * <p>
     * It is safe to run this method when the block does not exist, it will
     * not create the block.
     *
     * @param x X coordinate of the block
     * @param y Y coordinate of the block
     * @param z Z coordinate of the block
     * @return Humidity of the requested block
     */
    public double getHumidity(int x, int y, int z);

    /**
     * Gets the maximum height to which chorus fruits and nether portals can
     * bring players within this dimension.
     *
     * This excludes portals that were already built above the limit as they
     * still connect normally. May not be greater than {@link #getMaxHeight()}.
     *
     * @return maximum logical height for chorus fruits and nether portals
     */
    public int getLogicalHeight();

    /**
     * Gets if this world is natural.
     *
     * When false, compasses spin randomly, and using a bed to set the respawn
     * point or sleep, is disabled. When true, nether portals can spawn
     * zombified piglins.
     *
     * @return true if world is natural
     */
    public boolean isNatural();

    /**
     * Gets if beds work in this world.
     *
     * A non-working bed will blow up when trying to sleep. {@link #isNatural()}
     * defines if a bed can be used to set spawn point.
     *
     * @return true if beds work in this world
     */
    public boolean isBedWorks();

    /**
     * Gets if this world has skylight access.
     *
     * @return true if this world has skylight access
     */
    public boolean hasSkyLight();

    /**
     * Gets if this world has a ceiling.
     *
     * @return true if this world has a bedrock ceiling
     */
    public boolean hasCeiling();

    /**
     * Gets if this world allow to piglins to survive without shaking and
     * transforming to zombified piglins.
     *
     * @return true if piglins will not transform to zombified piglins
     */
    public boolean isPiglinSafe();

    /**
     * Gets if this world allows players to charge and use respawn anchors.
     *
     * @return true if players can charge and use respawn anchors
     */
    public boolean isRespawnAnchorWorks();

    /**
     * Gets if players with the bad omen effect in this world will trigger a
     * raid.
     *
     * @return true if raids will be triggered
     */
    public boolean hasRaids();

    /**
     * Gets if various water/lava mechanics will be triggered in this world, eg:
     * <br>
     * <ul>
     * <li>Water is evaporated</li>
     * <li>Sponges dry</li>
     * <li>Lava spreads faster and further</li>
     * </ul>
     *
     * @return true if this world has the above mechanics
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
     */
    public boolean getKeepSpawnInMemory();

    /**
     * 设置世界的出生点是否会在内存中保存加载。
     * <p>
     * 原文：
     * Sets whether the world's spawn area should be kept loaded into memory
     * or not.
     *
     * @param keepLoaded 如果为true则世界的出生地区会在内存中保存加载
     */
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
     * @deprecated world type is only used to select the default word generation
     * settings and is not stored in Vanilla worlds, making it impossible for
     * this method to always return the correct value.
     */
    @Nullable
    @Deprecated
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
     * Gets whether the world is hardcore or not.
     *
     * In a hardcore world the difficulty is locked to hard.
     *
     * @return hardcore status
     */
    public boolean isHardcore();

    /**
     * Sets whether the world is hardcore or not.
     *
     * In a hardcore world the difficulty is locked to hard.
     *
     * @param hardcore Whether the world is hardcore
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
     */
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
     */
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
     */
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
     */
    public void setTicksPerMonsterSpawns(int ticksPerMonsterSpawns);

    /**
     * Gets the world's ticks per water mob spawns value
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
     * @return The world's ticks per water mob spawns value
     */
    public long getTicksPerWaterSpawns();

    /**
     * Sets the world's ticks per water mob spawns value
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
     * @param ticksPerWaterSpawns the ticks per water mob spawns value you
     *     want to set the world to
     */
    public void setTicksPerWaterSpawns(int ticksPerWaterSpawns);

    /**
     * Gets the default ticks per water ambient mob spawns value.
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
     * @return the default ticks per water ambient mobs spawn value
     */
    public long getTicksPerWaterAmbientSpawns();

    /**
     * Sets the world's ticks per water ambient mob spawns value
     * <p>
     * This value determines how many ticks there are between attempts to
     * spawn water ambient mobs.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn water ambient mobs in
     *     this world on every tick.
     * <li>A value of 400 will mean the server will attempt to spawn weater ambient mobs
     *     in this world every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b>
     * If set to 0, water ambient mobs spawning will be disabled for this world.
     * <p>
     * Minecraft default: 1.
     *
     * @param ticksPerAmbientSpawns the ticks per water ambient mob spawns value you
     *     want to set the world to
     */
    public void setTicksPerWaterAmbientSpawns(int ticksPerAmbientSpawns);

    /**
     * Gets the default ticks per water underground creature spawns value.
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
     * @return the default ticks per water underground creature spawn value
     */
    public long getTicksPerWaterUndergroundCreatureSpawns();

    /**
     * Sets the world's ticks per water underground creature spawns value
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
     * @param ticksPerWaterUndergroundCreatureSpawns the ticks per water underground creature spawns value you
     *     want to set the world to
     */
    public void setTicksPerWaterUndergroundCreatureSpawns(int ticksPerWaterUndergroundCreatureSpawns);

    /**
     * Gets the world's ticks per ambient mob spawns value
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
     * @return The world's ticks per ambient mob spawns value
     */
    public long getTicksPerAmbientSpawns();

    /**
     * Sets the world's ticks per ambient mob spawns value
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
     * @param ticksPerAmbientSpawns the ticks per ambient mob spawns value you
     *     want to set the world to
     */
    public void setTicksPerAmbientSpawns(int ticksPerAmbientSpawns);

    /**
     * 获取这个世界一个区块内的怪物生成数限制。
     * <p>
     * 原文：
     * Gets limit for number of monsters that can spawn in a chunk in this
     * world
     *
     * @return 怪物生成限制
     */
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
     */
    void setMonsterSpawnLimit(int limit);

    /**
     * 获取这个世界一个区块内的动物生成数限制。
     * <p>
     * 原文：
     * Gets the limit for number of animals that can spawn in a chunk in this
     * world
     *
     * @return 动物生成限制
     */
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
     */
    void setAnimalSpawnLimit(int limit);

    /**
     * 获取这个世界一个区块内的水生动物生成数限制。
     * <p>
     * 原文：
     * Gets the limit for number of water animals that can spawn in a chunk in
     * this world
     *
     * @return 水生动物生成限制
     */
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
     */
    void setWaterAnimalSpawnLimit(int limit);

    /**
     * Gets the limit for number of water underground creature that can spawn in a chunk in
     * this world
     *
     * @return The water underground creature spawn limit
     */
    int getWaterUndergroundCreatureSpawnLimit();

    /**
     * Sets the limit for number of water underground creature that can spawn in a chunk in
     * this world
     * <p>
     * <b>Note:</b> If set to a negative number the world will use the
     * server-wide spawn limit instead.
     *
     * @param limit the new mob limit
     */
    void setWaterUndergroundCreatureSpawnLimit(int limit);

    /**
     * Gets user-specified limit for number of water ambient mobs that can spawn
     * in a chunk.
     *
     * @return the water ambient spawn limit
     */
    int getWaterAmbientSpawnLimit();

    /**
     * Sets the limit for number of water ambient mobs that can spawn in a chunk
     * in this world
     * <p>
     * <b>Note:</b> If set to a negative number the world will use the
     * server-wide spawn limit instead.
     *
     * @param limit the new mob limit
     */
    void setWaterAmbientSpawnLimit(int limit);

    /**
     * 获取这个世界一个区块内周围的怪物的生成数限制。
     * <p>
     * 原文：
     * Gets the limit for number of ambient mobs that can spawn in a chunk in
     * this world
     *
     * @return 周围的怪物的生成限制
     */
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
     */
    void setAmbientSpawnLimit(int limit);

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
     * Play a Sound at the provided Location in the World.
     * <p>
     * This function will fail silently if Location or Sound are null. No
     * sound will be heard by the players if their clients do not have the
     * respective sound for the value passed.
     *
     * @param location the location to play the sound
     * @param sound the internal sound name to play
     * @param volume the volume of the sound
     * @param pitch the pitch of the sound
     */
    void playSound(@NotNull Location location, @NotNull String sound, float volume, float pitch);

	/**
     * Play a Sound at the provided Location in the World.
     * <p>
     * This function will fail silently if Location or Sound are null.
     *
     * @param location The location to play the sound
     * @param sound The sound to play
     * @param category the category of the sound
     * @param volume The volume of the sound
     * @param pitch The pitch of the sound
     */
    void playSound(@NotNull Location location, @NotNull Sound sound, @NotNull SoundCategory category, float volume, float pitch);

    /**
     * Play a Sound at the provided Location in the World.
     * <p>
     * This function will fail silently if Location or Sound are null. No sound
     * will be heard by the players if their clients do not have the respective
     * sound for the value passed.
     *
     * @param location the location to play the sound
     * @param sound the internal sound name to play
     * @param category the category of the sound
     * @param volume the volume of the sound
     * @param pitch the pitch of the sound
     */
    void playSound(@NotNull Location location, @NotNull String sound, @NotNull SoundCategory category, float volume, float pitch);

    /**
     * 获取包含所有{@link GameRule 游戏规则}的数组.
     * <p>
     * 原文:Get an array containing the names of all the {@link GameRule}s.
     *
     * @return {@link GameRule 游戏规则}名列表.
     */
    @NotNull
    public String[] getGameRules();

    /**
     * 获取指定游戏规则的当前状态.
     * <p>
     * 如果rule为null则会返回null.
     * <p>
     * 原文：
     * Gets the current state of the specified rule
     * <p>
     * Will return null if rule passed is null
     *
     * @param rule 要查找的规则
     * @return 规则的字符串数值
     * @deprecated 请使用 {@link #getGameRuleValue(GameRule)}
     */
    @Deprecated
    @Contract("null -> null; !null -> !null")
    @Nullable
    public String getGameRuleValue(@Nullable String rule);

    /**
     * 将指定的游戏规则设置为指定数值.
     * <p>
     * 规则可能会尝试验证值，如果数值被设置则会返回true.
     * <p>
     * 如果rule为null，则这个函数会返回false.
     * <p>
     * 原文：
     * Set the specified gamerule to specified value.
     * <p>
     * The rule may attempt to validate the value passed, will return true if
     * value was set.
     * <p>
     * If rule is null, the function will return false.
     *
     * @param rule 要设置的规则
     * @param value 要设置的规则数值
     * @return 规则被设置则返回true
     * @deprecated 请使用 {@link #setGameRule(GameRule, Object)}
     */
    @Deprecated
    public boolean setGameRuleValue(@NotNull String rule, @NotNull String value);

    /**
     * 检查字符串是否是一个有效的游戏规则.
     * <p>
     * 原文：
     * Checks if string is a valid game rule
     *
     * @param rule 要检测的规则
     * @return 如果规则存在则返回true
     */
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
     * Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     */
    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     */
    public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param <T> type of particle data (see {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, @Nullable T data);


    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param <T> type of particle data (see {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, @Nullable T data);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     */
    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     */
    public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> type of particle data (see {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, @Nullable T data);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> type of particle data (see {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, @Nullable T data);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param extra the extra data for this particle, depends on the
     *              particle used (normally speed)
     */
    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, double extra);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param extra the extra data for this particle, depends on the
     *              particle used (normally speed)
     */
    public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> type of particle data (see {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param extra the extra data for this particle, depends on the
     *              particle used (normally speed)
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> type of particle data (see {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param extra the extra data for this particle, depends on the
     *              particle used (normally speed)
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> type of particle data (see {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param extra the extra data for this particle, depends on the
     *              particle used (normally speed)
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     * @param force whether to send the particle to players within an extended
     *              range and encourage their client to render it regardless of
     *              settings
     */
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data, boolean force);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> type of particle data (see {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param extra the extra data for this particle, depends on the
     *              particle used (normally speed)
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     * @param force whether to send the particle to players within an extended
     *              range and encourage their client to render it regardless of
     *              settings
     */
    public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data, boolean force);

    /**
     * Find the closest nearby structure of a given {@link StructureType}.
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
     * @param origin where to start looking for a structure
     * @param structureType the type of structure to find
     * @param radius the radius, in chunks, around which to search
     * @param findUnexplored true to only find unexplored structures
     * @return the closest {@link Location}, or null if no structure of the
     * specified type exists.
     */
    @Nullable
    public Location locateNearestStructure(@NotNull Location origin, @NotNull StructureType structureType, int radius, boolean findUnexplored);

    // Spigot start
    /**
     * Returns the view distance used for this world.
     *
     * @return the view distance used for this world
     */
    int getViewDistance();

    /**
     * Returns the simulation distance used for this world.
     *
     * @return the simulation distance used for this world
     */
    int getSimulationDistance();
    // Spigot end

    // Spigot start
    public class Spigot {

        /**
         * Strikes lightning at the given {@link Location} and possibly without sound
         *
         * @param loc The location to strike lightning
         * @param isSilent Whether this strike makes no sound
         * @return The lightning entity.
         */
        @NotNull
        public LightningStrike strikeLightning(@NotNull Location loc, boolean isSilent) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * Strikes lightning at the given {@link Location} without doing damage and possibly without sound
         *
         * @param loc The location to strike lightning
         * @param isSilent Whether this strike makes no sound
         * @return The lightning entity.
         */
        @NotNull
        public LightningStrike strikeLightningEffect(@NotNull Location loc, boolean isSilent) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @NotNull
    Spigot spigot();
    // Spigot end

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
     * Get the {@link DragonBattle} associated with this world.
     *
     * If this world's environment is not {@link Environment#THE_END}, null will
     * be returned.
     * <p>
     * If an end world, a dragon battle instance will be returned regardless of
     * whether or not a dragon is present in the world or a fight sequence has
     * been activated. The dragon battle instance acts as a state holder.
     *
     * @return the dragon battle instance
     */
    @Nullable
    public DragonBattle getEnderDragonBattle();

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
        @Deprecated
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
        @Deprecated
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