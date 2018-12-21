package org.bukkit;

import java.io.File;
import org.bukkit.generator.ChunkGenerator;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;

import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.*;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.messaging.PluginMessageRecipient;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Consumer;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

/**
 * 代表一个世界,包含了{@link Entity 实体},{@link Chunk 区块},{@link Block 方块}
 */
public interface World extends PluginMessageRecipient, Metadatable {

    /**
     * 获取坐标所指的{@link Block 方块}.
     * <p>
     * 原文：Gets the {@link Block} at the given coordinates
     *
     * @param x 方块的X坐标
     * @param y 方块的Y坐标
     * @param z 方块的Z坐标
     * @return 在指定坐标的方块
     * @see #getBlockTypeIdAt(int, int, int) 返回这个坐标所在方块的ID
     */
    public Block getBlockAt(int x, int y, int z);

    /**
     * 获取指定{@link Location 位置}的{@link Block 方块}.
     * <p>
     * 原文：Gets the {@link Block} at the given {@link Location}
     *
     * @param location 要获取的方块的位置
     * @return 在指定位置的方块
     * @see #getBlockTypeIdAt(org.bukkit.Location) 返回这个位置({@link Location})所在方块的ID
     */
    public Block getBlockAt(Location location);

    /**
     * 获取指定坐标的方块ID.
     * <p>
     * 原文：Gets the block type ID at the given coordinates
     *
     * @param x 方块的X坐标
     * @param y 方块的Y坐标
     * @param z 方块的Z坐标
     * @return 指定坐标所在的方块的ID
     * @see #getBlockAt(int, int, int) 返回这个坐标所在的方块
     * @deprecated 不安全的参数
     */
    @Deprecated
    public int getBlockTypeIdAt(int x, int y, int z);

    /**
     * Gets the y coordinate of the lowest block at the given {@link Location}
     * such that the block and all blocks above it are transparent for lighting
     * purposes.
     *
     * @param location Location of the blocks
     * @return Y-coordinate of the highest non-air block
     */
    public int getHighestBlockYAt(Location location);

    /**
     * 获取指定坐标的最顶上的方块(不是空气).
     * <p>
     * 译注：就是说,获取某个坐标最上面的方块.Essentials插件的top就是这个原理.
     * <p>
     * 原文：Gets the highest non-empty block at the given coordinates
     *
     * @param x X坐标
     * @param z Z坐标
     * @return x,z坐标内,最上面的一个不是空气的方块
     */
    public Block getHighestBlockAt(int x, int z);

    /**
     * 获取指定{@link Location 位置}的最顶上的方块(不是空气).
     * <p>
     * 译注：相当于getHightestBlockYAt(location),只不过那是获得方块Y坐标,而这个是获取方块对象.
     * 原文：Gets the highest non-empty block at the given coordinates
     *
     * @param location 需要获取最高的方块的位置
     * @return 最高的不是空气的方块
     */
    public Block getHighestBlockAt(Location location);

    /**
     * 获取给定坐标所在的{@link Chunk 区块}.
     * <p>
     * 原文：Gets the {@link Chunk} at the given coordinates
     *
     * @param x X坐标
     * @param z Z坐标
     * @return 给定坐标所在的区块
     */
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
    public Chunk getChunkAt(Location location);

    /**
     * 获取这个{@link Block 方块}所处的{@link Chunk 区块}.
     * <p>
     * 原文：
     * Gets the {@link Chunk} that contains the given {@link Block}
     *
     * @param block 需要检测的方块
     * @return 方块所处的区块
     */
    public Chunk getChunkAt(Block block);

    /**
     * 检查指定{@link Chunk 区块}是否已经被加载.
     * <p>
     * 原文：
     * Checks if the specified {@link Chunk} is loaded
     *
     * @param chunk 需要检查的区块
     * @return 如果区块已经被加载则返回true，否则返回false
     */
    public boolean isChunkLoaded(Chunk chunk);

    /**
     * Checks if the {@link Chunk} at the specified coordinates is generated
     *
     * @param x X-coordinate of the chunk
     * @param z Z-coordinate of the chunk
     * @return true if the chunk is generated, otherwise false
     */
    public boolean isChunkGenerated(int x, int z);

    /**
     * 获取一个所有被加载的{@link Chunk 区块}的数组.
     * <p>
     * 原文：
     * Gets an array of all loaded {@link Chunk}s
     *
     * @return 包含所有被加载区块的数组Chunk[]
     */
    public Chunk[] getLoadedChunks();

    /**
     * 加载指定的{@link Chunk 区块}.
     * <p>
     * 原文：
     * Loads the specified {@link Chunk}
     *
     * @param chunk 待加载的区块
     */
    public void loadChunk(Chunk chunk);

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
     * 检查指定坐标的{@link Chunk 区块}是否被加载且被一个或更多的玩家使用.
     * <p>
     * 原文：
     * Checks if the {@link Chunk} at the specified coordinates is loaded and
     * in use by one or more players
     *
     * @param x 区块的x坐标
     * @param z 区块的z坐标
     * @return 如果区块被加载且被一个或更多的玩家使用则返回true，否则返回false
     */
    public boolean isChunkInUse(int x, int z);

    /**
     * 加载指定坐标的{@link Chunk 区块}.
     * <p>
     * 如果区块不存在则会被生成。
     * <p>
     * 这个方法类似于当generate值为true时的{@link #loadChunk(int, int, boolean)}.
     * <p>
     * 原文：
     * Loads the {@link Chunk} at the specified coordinates
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
     * 原文：
     * Loads the {@link Chunk} at the specified coordinates
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
     * 这个方法类似于当safe值和saveis值为true时的{@link #unloadChunk(int, int, boolean,boolean)}
     * <p>
     * 原文：
     * Safely unloads and saves the {@link Chunk} at the specified coordinates
     * <p>
     * This method is analogous to {@link #unloadChunk(int, int, boolean,
     * boolean)} where safe and saveis true
     *
     * @param chunk 卸载的区块
     * @return 如果区块被成功卸载则返回true，否则返回false
     */
    public boolean unloadChunk(Chunk chunk);

    /**
     * 安全的卸载并保存指定坐标的{@link Chunk 区块}.
     * <p>
     * 这个方法类似于当safe值和saveis值为true时的{@link #unloadChunk(int, int, boolean,boolean)}
     * <p>
     * 原文：
     * Safely unloads and saves the {@link Chunk} at the specified coordinates
     * <p>
     * This method is analogous to {@link #unloadChunk(int, int, boolean,
     * boolean)} where safe and saveis true
     *
     * @param x 区块的x坐标
     * @param z 区块的z坐标
     * @return 如果区块被成功卸载则返回true，否则返回false
     */
    public boolean unloadChunk(int x, int z);

    /**
     * 安全的卸载并选择是否保存指定坐标的{@link Chunk 区块}.
     * <p>
     * 这个方法类似于当safe值为true时的{@link #unloadChunk(int, int, boolean,boolean)}
     * <p>
     * 原文：
     * Safely unloads and optionally saves the {@link Chunk} at the specified
     * coordinates
     * <p>
     * This method is analogous to {@link #unloadChunk(int, int, boolean,
     * boolean)} where save is true
     *
     * @param x 区块的x坐标
     * @param z 区块的z坐标
     * @param save 是否保存区块
     * @return 如果区块被成功卸载则返回true，否则返回false
     */
    public boolean unloadChunk(int x, int z, boolean save);

    /**
     * 卸载并选择是否保存指定坐标的{@link Chunk 区块}.
     * <p>
     * 原文：
     * Unloads and optionally saves the {@link Chunk} at the specified
     * coordinates
     *
     * @param x 区块的x坐标
     * @param z 区块的z坐标
     * @param save 控制是否保存区块
     * @param safe 控制当附近有玩家时是否卸载区块
     * @return 如果区块被成功卸载则返回true，否则返回false
     * @deprecated 移除一个正在使用的区块从不安全
     */
    @Deprecated
    public boolean unloadChunk(int x, int z, boolean save, boolean safe);

    /**
     * 安全地将卸载指定坐标的{@link Chunk 区块}列入队列.
     * <p>
     * 这个方法类似于当safe值为true时的{@link #unloadChunkRequest(int, int,boolean)}
     * <p>
     * 原文：
     * Safely queues the {@link Chunk} at the specified coordinates for
     * unloading
     * <p>
     * This method is analogous to {@link #unloadChunkRequest(int, int,
     * boolean)} where safe is true
     *
     * @param x 区块的x坐标
     * @param z 区块的z坐标
     * @return 如果尝试列入队列成功则返回true，否则返回false
     */
    public boolean unloadChunkRequest(int x, int z);

    /**
     * 将卸载指定坐标的{@link Chunk 区块}列入队列.
     * <p>
     * 原文：
     * Queues the {@link Chunk} at the specified coordinates for unloading
     *
     * @param x 区块的x坐标
     * @param z 区块的z坐标
     * @param safe 控制当附近有玩家时是否卸载区块
     * @return 区块是否真的被列入队列
     */
    public boolean unloadChunkRequest(int x, int z, boolean safe);

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
     * @deprecated 无法保证重新生成单个区块会产生与之前相同的区块, 因为地形装饰可分布在区块上
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
     * 在指定的{@link Location 位置}丢出一个物品.
     * <p>
     * 原文：
     * Drops an item at the specified {@link Location}
     *
     * @param location 丢出物品的位置
     * @param item 丢出的物品堆
     * @return 这个方法会创建一个ItemDrop（物品掉落）实体作为结果
     */
    public Item dropItem(Location location, ItemStack item);

    /**
     * 在指定的{@link Location 位置}丢出一个随机偏移的物品.
     * <p>
     * 原文：
     * Drops an item at the specified {@link Location} with a random offset
     *
     * @param location 丢出物品的位置
     * @param item 丢出的物品堆
     * @return 这个方法会创建一个ItemDrop（物品掉落）实体作为结果
     */
    public Item dropItemNaturally(Location location, ItemStack item);

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
    public Arrow spawnArrow(Location location, Vector direction, float speed, float spread);

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
    public <T extends Arrow> T spawnArrow(Location location, Vector direction, float speed, float spread, Class<T> clazz);

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
    public boolean generateTree(Location location, TreeType type);

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
     */
    public boolean generateTree(Location loc, TreeType type, BlockChangeDelegate delegate);

    /**
     * 在指定的{@link Location 位置}创建一个实体.
     * <p>
     * 原文：
     * Creates a entity at the given {@link Location}
     *
     * @param loc 生成实体的位置
     * @param type 生成的实体
     * @return 生成成功则返回此方法创建的实体，否则返回null
     */
    public Entity spawnEntity(Location loc, EntityType type);

    /**
     * 在指定的{@link Location 位置}劈下闪电.
     * <p>
     * 原文：
     * Strikes lightning at the given {@link Location}
     *
     * @param loc 劈下闪电的位置
     * @return lightning（闪电）实体
     */
    public LightningStrike strikeLightning(Location loc);

    /**
     * 在指定的{@link Location 位置}劈下不会造成伤害的闪电.
     * <p>
     * 原文：
     * Strikes lightning at the given {@link Location} without doing damage
     *
     * @param loc 劈下闪电的位置
     * @return lightning（闪电）实体
     */
    public LightningStrike strikeLightningEffect(Location loc);

    /**
     * 获取一个这个世界所有实体的列表.
     * <p>
     * 原文：
     * Get a list of all entities in this World
     *
     * @return 一个当前处在这个世界的所有实体的列表
     */
    public List<Entity> getEntities();

    /**
     * 获取一个这个世界所有生物实体的列表.
     * <p>
     * 原文：
     * Get a list of all living entities in this World
     *
     * @return 一个当前处在这个世界的所有生物实体的列表
     */
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
    public <T extends Entity> Collection<T> getEntitiesByClass(Class<T>... classes);

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
    public <T extends Entity> Collection<T> getEntitiesByClass(Class<T> cls);

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
    public Collection<Entity> getEntitiesByClasses(Class<?>... classes);

    /**
     * 获取一个这个世界的所有玩家的列表.
     * <p>
     * 原文：
     * Get a list of all players in this World
     *
     * @return 一个当前处在这个世界的所有玩家的列表
     */
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
    public Collection<Entity> getNearbyEntities(Location location, double x, double y, double z);

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
    public Collection<Entity> getNearbyEntities(Location location, double x, double y, double z, Predicate<Entity> filter);

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
    public Collection<Entity> getNearbyEntities(BoundingBox boundingBox);

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
    public Collection<Entity> getNearbyEntities(BoundingBox boundingBox, Predicate<Entity> filter);

    /**
     * Performs a ray trace that checks for entity collisions.
     * <p>
     * This may not consider entities in currently unloaded chunks. Some
     * implementations may impose artificial restrictions on the maximum
     * distance.
     *
     * @param start the start position
     * @param direction the ray direction
     * @param maxDistance the maximum distance
     * @return the closest ray trace hit result, or <code>null</code> if there
     *     is no hit
     * @see #rayTraceEntities(Location, Vector, double, double, Predicate)
     */
    public RayTraceResult rayTraceEntities(Location start, Vector direction, double maxDistance);

    /**
     * Performs a ray trace that checks for entity collisions.
     * <p>
     * This may not consider entities in currently unloaded chunks. Some
     * implementations may impose artificial restrictions on the maximum
     * distance.
     *
     * @param start the start position
     * @param direction the ray direction
     * @param maxDistance the maximum distance
     * @param raySize entity bounding boxes will be uniformly expanded (or
     *     shrinked) by this value before doing collision checks
     * @return the closest ray trace hit result, or <code>null</code> if there
     *     is no hit
     * @see #rayTraceEntities(Location, Vector, double, double, Predicate)
     */
    public RayTraceResult rayTraceEntities(Location start, Vector direction, double maxDistance, double raySize);

    /**
     * Performs a ray trace that checks for entity collisions.
     * <p>
     * This may not consider entities in currently unloaded chunks. Some
     * implementations may impose artificial restrictions on the maximum
     * distance.
     *
     * @param start the start position
     * @param direction the ray direction
     * @param maxDistance the maximum distance
     * @param filter only entities that fulfill this predicate are considered,
     *     or <code>null</code> to consider all entities
     * @return the closest ray trace hit result, or <code>null</code> if there
     *     is no hit
     * @see #rayTraceEntities(Location, Vector, double, double, Predicate)
     */
    public RayTraceResult rayTraceEntities(Location start, Vector direction, double maxDistance, Predicate<Entity> filter);

    /**
     * Performs a ray trace that checks for entity collisions.
     * <p>
     * This may not consider entities in currently unloaded chunks. Some
     * implementations may impose artificial restrictions on the maximum
     * distance.
     *
     * @param start the start position
     * @param direction the ray direction
     * @param maxDistance the maximum distance
     * @param raySize entity bounding boxes will be uniformly expanded (or
     *     shrinked) by this value before doing collision checks
     * @param filter only entities that fulfill this predicate are considered,
     *     or <code>null</code> to consider all entities
     * @return the closest ray trace hit result, or <code>null</code> if there
     *     is no hit
     */
    public RayTraceResult rayTraceEntities(Location start, Vector direction, double maxDistance, double raySize, Predicate<Entity> filter);

    /**
     * Performs a ray trace that checks for block collisions using the blocks'
     * precise collision shapes.
     * <p>
     * This takes collisions with passable blocks into account, but ignores
     * fluids.
     * <p>
     * This may cause loading of chunks! Some implementations may impose
     * artificial restrictions on the maximum distance.
     *
     * @param start the start location
     * @param direction the ray direction
     * @param maxDistance the maximum distance
     * @return the ray trace hit result, or <code>null</code> if there is no hit
     * @see #rayTraceBlocks(Location, Vector, double, FluidCollisionMode, boolean)
     */
    public RayTraceResult rayTraceBlocks(Location start, Vector direction, double maxDistance);

    /**
     * Performs a ray trace that checks for block collisions using the blocks'
     * precise collision shapes.
     * <p>
     * This takes collisions with passable blocks into account.
     * <p>
     * This may cause loading of chunks! Some implementations may impose
     * artificial restrictions on the maximum distance.
     *
     * @param start the start location
     * @param direction the ray direction
     * @param maxDistance the maximum distance
     * @param fluidCollisionMode the fluid collision mode
     * @return the ray trace hit result, or <code>null</code> if there is no hit
     * @see #rayTraceBlocks(Location, Vector, double, FluidCollisionMode, boolean)
     */
    public RayTraceResult rayTraceBlocks(Location start, Vector direction, double maxDistance, FluidCollisionMode fluidCollisionMode);

    /**
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
     * @param start the start location
     * @param direction the ray direction
     * @param maxDistance the maximum distance
     * @param fluidCollisionMode the fluid collision mode
     * @param ignorePassableBlocks whether to ignore passable but collidable
     *     blocks (ex. tall grass, signs, fluids, ..)
     * @return the ray trace hit result, or <code>null</code> if there is no hit
     */
    public RayTraceResult rayTraceBlocks(Location start, Vector direction, double maxDistance, FluidCollisionMode fluidCollisionMode, boolean ignorePassableBlocks);

    /**
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
     * @param start the start location
     * @param direction the ray direction
     * @param maxDistance the maximum distance
     * @param fluidCollisionMode the fluid collision mode
     * @param ignorePassableBlocks whether to ignore passable but collidable
     *     blocks (ex. tall grass, signs, fluids, ..)
     * @param raySize entity bounding boxes will be uniformly expanded (or
     *     shrinked) by this value before doing collision checks
     * @param filter only entities that fulfill this predicate are considered,
     *     or <code>null</code> to consider all entities
     * @return the closest ray trace hit result with either a block or an
     *     entity, or <code>null</code> if there is no hit
     */
    public RayTraceResult rayTrace(Location start, Vector direction, double maxDistance, FluidCollisionMode fluidCollisionMode, boolean ignorePassableBlocks, double raySize, Predicate<Entity> filter);

    /**
     * 获取世界的唯一名称.
     * <p>
     * 原文：
     * Gets the unique name of this world
     *
     * @return 世界的名称
     */
    public String getName();

    /**
     * 获取世界的唯一UUID.
     * <p>
     * 原文：
     * Gets the Unique ID of this world
     *
     * @return 世界的唯一UUID
     */
    public UUID getUID();

    /**
     * 获取这个世界的默认出生点{@link Location 位置}.
     * <p>
     * 原文：
     * Gets the default spawn {@link Location} of this world
     *
     * @return 这个世界的出生点位置
     */
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
    public boolean setSpawnLocation(Location location);

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
     * 返回世界现在是否有雷暴.
     * <p>
     * 原文：
     * Returns whether the world has an ongoing storm.
     *
     * @return 是否有雷暴
     */
    public boolean hasStorm();

    /**
     * 设置是否有风暴。会为当前新的天气设置一段持续时间.
     * <p>
     * 原文：
     * Set whether there is a storm. A duration will be set for the new
     * current conditions.
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
     * <p>
     * 原文：
     * Set whether it is thundering.
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
     * 在指定坐标生成指定威力的爆炸.
     * <p>
     * 原文：
     * Creates explosion at given coordinates with given power
     *
     * @param loc 爆炸位置
     * @param power 爆炸的威力，一个TNT当量为4F
     * @return 如果爆炸被取消则返回false，否则返回true
     */
    public boolean createExplosion(Location loc, float power);

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
    public boolean createExplosion(Location loc, float power, boolean setFire);

    /**
     * 获取世界的{@link Environment 环境}类型.
     * <p>
     * 原文：
     * Gets the {@link Environment} type of this world
     *
     * @return 这个世界的环境类型
     */
    public Environment getEnvironment();

    /**
     * 获取世界的种子.
     * <p>
     * 原文：
     * Gets the Seed for this world.
     *
     * @return 这个世界的种子
     */
    public long getSeed();

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
    public ChunkGenerator getGenerator();

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
    public List<BlockPopulator> getPopulators();

    /**
     * 在指定的{@link Location 位置}根据给定的类生成一个实体.
     * <p>
     * 原文：
     * Spawn an entity of a specific class at the given {@link Location}
     *
     * @param location 生成实体的{@link Location 位置}
     * @param clazz 生成{@link Entity 实体}的类
     * @param <T> 生成{@link Entity 实体}的类
     * @return 一个生成的{@link Entity 实体}实例
     * @throws IllegalArgumentException 如果参数为空或被要求生成的{@link Entity 实体}不能被生成则抛出错误
     */
    public <T extends Entity> T spawn(Location location, Class<T> clazz) throws IllegalArgumentException;

    /**
     * Spawn an entity of a specific class at the given {@link Location}, with
     * the supplied function run before the entity is added to the world.
     * <br>
     * Note that when the function is run, the entity will not be actually in
     * the world. Any operation involving such as teleporting the entity is undefined
     * until after this function returns.
     *
     * @param location the {@link Location} to spawn the entity at
     * @param clazz the class of the {@link Entity} to spawn
     * @param function the function to be run before the entity is spawned.
     * @param <T> the class of the {@link Entity} to spawn
     * @return an instance of the spawned {@link Entity}
     * @throws IllegalArgumentException if either parameter is null or the
     *     {@link Entity} requested cannot be spawned
     */
    public <T extends Entity> T spawn(Location location, Class<T> clazz, Consumer<T> function) throws IllegalArgumentException;

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
    public FallingBlock spawnFallingBlock(Location location, MaterialData data) throws IllegalArgumentException;

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
    public FallingBlock spawnFallingBlock(Location location, BlockData data) throws IllegalArgumentException;

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
     * @param @param material 方块 {@link Material} 类型
     * @param data 方块数据
     * @return 生成的{@link FallingBlock 正在下落的方块}实例
     * @throws IllegalArgumentException 如果 {@link Location} 或 {@link
     *     Material} 为null 或 {@link Material} 不是方块
     * @deprecated 不安全的参数
     */
    @Deprecated
    public FallingBlock spawnFallingBlock(Location location, Material material, byte data) throws IllegalArgumentException;

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
    public void playEffect(Location location, Effect effect, int data);

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
    public void playEffect(Location location, Effect effect, int data, int radius);

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
    public <T> void playEffect(Location location, Effect effect, T data);

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
    public <T> void playEffect(Location location, Effect effect, T data, int radius);

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
     */
    Biome getBiome(int x, int z);

    /**
     * 设置指定方块坐标的生物群系
     * <p>
     * 原文：
     * Sets the biome for the given block coordinates
     *
     * @param x 方块的x坐标
     * @param z 方块的z坐标
     * @param bio 这个方块的新生物群系类型
     */
    void setBiome(int x, int z, Biome bio);

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
     */
    public double getTemperature(int x, int z);

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
     */
    public double getHumidity(int x, int z);

    /**
     * 获取这个世界的最大高度。
     * <p>
     * 如果最大高度为100，则只有y=0到y=99才有方块。
     * <p>
     * 原文：
     * Gets the maximum height of this world.
     * <p>
     * If the max height is 100, there are only blocks from y=0 to y=99.
     *
     * @return 世界的最大高度
     */
    public int getMaxHeight();

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
    public void setDifficulty(Difficulty difficulty);

    /**
     * 获取世界的游戏难度。
     * <p>
     * 原文：
     * Gets the Difficulty of the world.
     *
     * @return 世界的难度
     */
    public Difficulty getDifficulty();

    /**
     * 获取这个世界保存在磁盘的哪个文件夹。
     * <p>
     * 原文：
     * Gets the folder of this world on disk.
     *
     * @return 这个世界所在的文件夹
     */
    public File getWorldFolder();

    /**
     * 获取世界类型。
     * <p>
     * 原文：
     * Gets the type of this world.
     *
     * @return 世界类型
     */
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
    void playSound(Location location, Sound sound, float volume, float pitch);

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
    void playSound(Location location, String sound, float volume, float pitch);

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
    void playSound(Location location, Sound sound, SoundCategory category, float volume, float pitch);

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
    void playSound(Location location, String sound, SoundCategory category, float volume, float pitch);

    /**
     * 获取包含所有{@link GameRule 游戏规则}的数组.
     * <p>
     * 原文:Get an array containing the names of all the {@link GameRule}s.
     *
     * @return {@link GameRule 游戏规则}名列表.
     */
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
    public String getGameRuleValue(String rule);

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
    public boolean setGameRuleValue(String rule, String value);

    /**
     * 检查字符串是否是一个有效的游戏规则.
     * <p>
     * 原文：
     * Checks if string is a valid game rule
     *
     * @param rule 要检测的规则
     * @return 如果规则存在则返回true
     */
    public boolean isGameRule(String rule);

    /**
     * 获取给定的{@link GameRule 游戏规则}的数据值.
     * <p>
     * 原文:Get the current value for a given {@link GameRule}.
     *
     * @param rule 游戏规则
     * @param <T> 游戏规则数据类型
     * @return 游戏规则值
     */
    public <T> T getGameRuleValue(GameRule<T> rule);

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
    public <T> T getGameRuleDefault(GameRule<T> rule);

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
    public <T> boolean setGameRule(GameRule<T> rule, T newValue);

    /**
     * 获取这个世界的世界边界对象。
     * <p>
     * 原文：
     * Gets the world border for this world.
     *
     * @return 这个世界的世界边界对象
     */
    public WorldBorder getWorldBorder();

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     */
    public void spawnParticle(Particle particle, Location location, int count);

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
    public void spawnParticle(Particle particle, double x, double y, double z, int count);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    public <T> void spawnParticle(Particle particle, Location location, int count, T data);


    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, T data);

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
    public void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ);

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
    public void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ);

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
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    public <T> void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, T data);

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
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, T data);

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
    public void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, double extra);

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
    public void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra);

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
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    public <T> void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, double extra, T data);

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
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, T data);

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
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     * @param force whether to send the particle to players within an extended
     *              range and encourage their client to render it regardless of
     *              settings
     */
    public <T> void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, double extra, T data, boolean force);

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
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     * @param force whether to send the particle to players within an extended
     *              range and encourage their client to render it regardless of
     *              settings
     */
    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, T data, boolean force);

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
    public Location locateNearestStructure(Location origin, StructureType structureType, int radius, boolean findUnexplored);

    /**
     * 表示世界可能的各种地图环境类型.
     */
    public enum Environment {

        /**
         * 表示"normal"/"surface world"地图。
         */
        NORMAL(0),
        /**
         * 表示一个基于"hell"地图的地狱。
         */
        NETHER(-1),
        /**
         * 表示"end"地图。
         */
        THE_END(1);

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