package org.bukkit;

import java.io.File;
import org.bukkit.generator.ChunkGenerator;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.messaging.PluginMessageRecipient;
import org.bukkit.util.Vector;

/**
 * 代表一个世界,包含了实体({@link Entity}),区块({@link Chunk}),方块({@link Block})
 */
public interface World extends PluginMessageRecipient, Metadatable {

    /**
     * 得到坐标所指的方块<p>
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
     * 得到指定位置({@link Location})的方块({@link Block})<p>
     * 原文：Gets the {@link Block} at the given {@link Location}
     *
     * @param location 要得到的方块的位置
     * @return 在指定位置的方块
     * @see #getBlockTypeIdAt(org.bukkit.Location) 返回这个位置({@link Location})所在方块的ID
     */
    public Block getBlockAt(Location location);

    /**
     * 得到指定坐标的方块ID<p>
     * 原文：Gets the block type ID at the given coordinates
     *
     * @param x 方块的X坐标
     * @param y 方块的Y坐标
     * @param z 方块的Z坐标
     * @return 指定坐标所在的方块的ID
     * @see #getBlockAt(int, int, int) 返回这个坐标所在的方块
     * @deprecated Magic value
     */
    @Deprecated
    public int getBlockTypeIdAt(int x, int y, int z);

    /**
     * 得到指定位置{@link Location}的方块{@link Block}的ID
     * 原文：Gets the block type ID at the given {@link Location}
     *
     * @param location 要得到的方块ID的位置
     * @return 指定位置的方块的ID
     * @see #getBlockAt(org.bukkit.Location) 返回一个位置({@link Location})所在的方块({@link Block})对象
     * @deprecated Magic value
     */
    @Deprecated
    public int getBlockTypeIdAt(Location location);

    /**
     * 得到指定坐标的最顶上的方块的Y坐标(不是空气)
     * 原文：Gets the highest non-air coordinate at the given coordinates
     * 译注：就是说,获取某个坐标最上面的方块的高度(Y坐标).Essentials插件的top就是这个原理.
     *
     * @param x 给定的X坐标
     * @param z 给定的Z坐标
     * @return 在x,y位置的最高的方块的高度(忽略空气)
     */
    public int getHighestBlockYAt(int x, int z);

    /**
     * 得到指定位置({@link Location})的最顶上的方块的Y坐标(不是空气)
     * 原文：Gets the highest non-air coordinate at the given {@link Location}
     * 译注：就是说,获取某个坐标最上面的方块的高度(Y坐标).Essentials插件的top就是这个原理.
     *
     * @param location 给定的位置({@link Location})
     * @return 在给定的位置中的x坐标,y坐标位置中最高的方块的高度(忽略空气)
     */
    public int getHighestBlockYAt(Location location);

    /**
     * 得到指定坐标的最顶上的不是空气的方块
     * 原文：Gets the highest non-empty block at the given coordinates
     * 译注：就是说,获取某个坐标最上面的方块.Essentials插件的top就是这个原理.
     *
     * @param x X坐标
     * @param z Z坐标
     * @return x,z坐标内,最上面的一个不是空气的方块
     */
    public Block getHighestBlockAt(int x, int z);

    /**
     * 得到指定位置({@link Location})最顶上的不是空气的方块
     * 原文：Gets the highest non-empty block at the given coordinates
     * 译注：相当于getHightestBlockYAt(location),只不过那是获得方块Y坐标,而这个是获取方块对象
     *
     * @param location 需要得到最高的方块的位置
     * @return 最高的不是空气的方块
     */
    public Block getHighestBlockAt(Location location);

    /**
     * 得到给定坐标所在的区块({@link Chunk})
     * 原文：Gets the {@link Chunk} at the given coordinates
     *
     * @param x X坐标
     * @param z Z坐标
     * @return 给定坐标所在的区块
     */
    public Chunk getChunkAt(int x, int z);

    /**
     * 得到给定方位{@link Location}所在的区块{@link Chunk}
     * <p>
     * 原文：
     * Gets the {@link Chunk} at the given {@link Location}
     *
     * @param location 方块的方位
     * @return 给定方位的区块
     */
    public Chunk getChunkAt(Location location);

    /**
     * 得到包含给定方块{@link Block}的区块{@link Chunk}
     * <p>
     * 原文：
     * Gets the {@link Chunk} that contains the given {@link Block}
     *
     * @param block 用于获取包含此方块的区块的方块（很拗口是吧。。。希望有更好的翻译）
     * @return 包含指定方块的区块
     */
    public Chunk getChunkAt(Block block);

    /**
     * 检查指定区块{@link Chunk}是否已经被加载
     * <p>
     * 原文：
     * Checks if the specified {@link Chunk} is loaded
     *
     * @param chunk 需要检查的区块
     * @return 如果区块已经被加载则返回true，否则返回false
     */
    public boolean isChunkLoaded(Chunk chunk);

    /**
     * 得到一个所有被加载的区块{@link Chunk}的数组
     * <p>
     * 原文：
     * Gets an array of all loaded {@link Chunk}s
     *
     * @return 包含所有被加载区块的数组Chunk[]
     */
    public Chunk[] getLoadedChunks();

    /**
     * 加载指定的区块{@link Chunk}
     * <p>
     * 原文：
     * Loads the specified {@link Chunk}
     *
     * @param chunk 待加载的区块
     */
    public void loadChunk(Chunk chunk);

    /**
     * 检查在指定坐标的区块{@link Chunk}是否被加载
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
     * 检查指定坐标的区块{@link Chunk}是否被加载且被一个或更多的玩家使用
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
     * 加载指定坐标的区块{@link Chunk}
     * <p>
     * 如果区块不存在则会被生成。
     * <p>
     * 这个方法类似于当generate值为true时的{@link #loadChunk(int, int, boolean)}。
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
     * 加载指定坐标的区块{@link Chunk}
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
     * 安全的卸载并保存指定坐标的区块{@link Chunk}
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
     * 安全的卸载并保存指定坐标的区块{@link Chunk}
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
     * 安全的卸载并选择是否保存指定坐标的区块{@link Chunk}
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
     * 卸载并选择是否保存指定坐标的区块{@link Chunk}
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
     */
    public boolean unloadChunk(int x, int z, boolean save, boolean safe);

    /**
     * 安全地将卸载指定坐标的区块{@link Chunk}列入队列
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
     * 将卸载指定坐标的区块{@link Chunk}列入队列
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
     * 重新生成指定坐标的区块{@link Chunk}
     * <p>
     * 原文：
     * Regenerates the {@link Chunk} at the specified coordinates
     *
     * @param x 区块的x坐标
     * @param z 区块的z坐标
     * @return 区块是否真的被重新生成
     */
    public boolean regenerateChunk(int x, int z);

    /**
     * 将区块{@link Chunk}重新发送给所有的客户端
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
     * 在指定的方位{@link Location}丢出一个物品
     * <p>
     * 原文：
     * Drops an item at the specified {@link Location}
     *
     * @param location 丢出物品的方位
     * @param item 丢出的物品堆
     * @return 这个方法会创建一个ItemDrop（物品掉落）实体作为结果
     */
    public Item dropItem(Location location, ItemStack item);

    /**
     * 在指定的方位{@link Location}丢出一个随机偏移的物品
     * <p>
     * 原文：
     * Drops an item at the specified {@link Location} with a random offset
     *
     * @param location 丢出物品的方位
     * @param item 丢出的物品堆
     * @return 这个方法会创建一个ItemDrop（物品掉落）实体作为结果
     */
    public Item dropItemNaturally(Location location, ItemStack item);

    /**
     * 在指定的方位{@link Location}创建一个箭{@link Arrow}的实体
     * <p>
     * 原文：
     * Creates an {@link Arrow} entity at the given {@link Location}
     *
     * @param location 生成箭的方位
     * @param direction 箭射向的方向
     * @param speed 箭的射速。建议为0.6
     * @param spread 箭的范围。建议为12（可能是距离或者箭存在的时间，确认后请校对员修改并删除括号）
     * @return 这个方法会生成一个Arrow（箭）实体作为结果
     */
    public Arrow spawnArrow(Location location, Vector direction, float speed, float spread);

    /**
     * 在指定的方位{@link Location}创建一颗树
     * <p>
     * 原文：
     * Creates a tree at the given {@link Location}
     *
     * @param location 生成树的方位
     * @param type 创建的树的类型
     * @return 如果树被成功生成则返回true，否则返回false
     */
    public boolean generateTree(Location location, TreeType type);

    /**
     * 在指定的方位{@link Location}创建一颗树
     * <p>
     * 原文：
     * Creates a tree at the given {@link Location}
     *
     * @param loc 生成树的方位
     * @param type 创建的树的类型
     * @param delegate 这个方法会返回一个用于调用每个方块的改变的类作为结果
     * @return 如果树被成功生成则返回true，否则返回false
     */
    public boolean generateTree(Location loc, TreeType type, BlockChangeDelegate delegate);

    /**
     * 在指定的方位{@link Location}创建一个实体
     * <p>
     * 原文：
     * Creates a entity at the given {@link Location}
     *
     * @param loc 生成实体的方位
     * @param type 生成的实体
     * @return 生成成功则返回此方法创建的实体，否则返回null
     */
    public Entity spawnEntity(Location loc, EntityType type);

    /**
     * 在指定的方位{@link Location}创建一个生物
     * <p>
     * 原文：
     * Creates a creature at the given {@link Location}
     *
     * @param loc 生成生物的方位
     * @param type 生成的生物
     * @return 生成成功则返回此方法创建的LivingEntity（生物实体），否则返回null
     * @deprecated 生成非LivingEntity（生物实体）有问题。使用{@link
     *     #spawnEntity(Location, EntityType) spawnEntity} 代替。
     */
    @Deprecated
    public LivingEntity spawnCreature(Location loc, EntityType type);

    /**
     * 在指定的方位{@link Location}创建一个生物
     * <p>
     * 原文：
     * Creates a creature at the given {@link Location}
     *
     * @param loc 生成生物的方位
     * @param type 生成的生物
     * @return 生成成功则返回此方法创建的LivingEntity（生物实体），否则返回null
     */
    @Deprecated
    public LivingEntity spawnCreature(Location loc, CreatureType type);

    /**
     * 在指定的方位{@link Location}劈下闪电
     * <p>
     * 原文：
     * Strikes lightning at the given {@link Location}
     *
     * @param loc 劈下闪电的方位
     * @return lightning（闪电）实体。
     */
    public LightningStrike strikeLightning(Location loc);

    /**
     * 在指定的方位{@link Location}劈下不造成伤害的闪电
     * <p>
     * 原文：
     * Strikes lightning at the given {@link Location} without doing damage
     *
     * @param loc 劈下闪电的方位
     * @return lightning（闪电）实体。
     */
    public LightningStrike strikeLightningEffect(Location loc);

    /**
     * 获取一个这个世界所有实体的列表
     * <p>
     * 原文：
     * Get a list of all entities in this World
     *
     * @return 一个当前处在这个世界的所有实体的列表
     */
    public List<Entity> getEntities();

    /**
     * 获取一个这个世界所有生物实体的列表
     * <p>
     * 原文：
     * Get a list of all living entities in this World
     *
     * @return 一个当前处在这个世界的所有生物实体的列表
     */
    public List<LivingEntity> getLivingEntities();

    /**
     * 获取一个在这个世界的所有与指定的类/接口相匹配的实体的集合
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
     * 获取一个在这个世界的所有与指定的类/接口相匹配的实体的集合
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
     * 获取一个在这个世界的所有与任一指定的类/接口相匹配的实体的集合
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
     * 获取一个这个世界的所有玩家的列表
     * <p>
     * 原文：
     * Get a list of all players in this World
     *
     * @return 一个当前处在这个世界的所有玩家的列表
     */
    public List<Player> getPlayers();

    /**
     * 返回一个在指定范围内的实体的列表。（译注：此为意译，直译不符合中文习惯）
     * 
     * 一些执行器可能会对搜索的范围的大小施加限制。（同上）
     * <p>
     * 原文：
     * Returns a list of entities within a bounding box centered around a Location.
     *
     * Some implementations may impose artificial restrictions on the size of the search bounding box.
     *
     * @param location 搜索范围的中心
     * @param x 搜索范围的x半轴长度
     * @param y 搜索范围的y半轴长度
     * @param z 搜索范围的z半轴长度
     * @return 在方位附近的实体的集合。一般不为空。
     */
    public Collection<Entity> getNearbyEntities(Location location, double x, double y, double z);

    /**
     * 获取世界的唯一名称
     * <p>
     * 原文：
     * Gets the unique name of this world
     *
     * @return 世界的名称
     */
    public String getName();

    /**
     * 获取世界的唯一ID
     * <p>
     * 原文：
     * Gets the Unique ID of this world
     *
     * @return 世界的唯一ID。
     */
    public UUID getUID();

    /**
     * 获取这个世界的默认出生点方位{@link Location}
     * <p>
     * 原文：
     * Gets the default spawn {@link Location} of this world
     *
     * @return 这个世界的出生点方位
     */
    public Location getSpawnLocation();

    /**
     * 设置这个世界的出生点方位
     * <p>
     * 原文：
     * Sets the spawn location of the world
     *
     * @param x x坐标
     * @param y y坐标
     * @param z z坐标
     * @return 如果成功设置则返回true。
     */
    public boolean setSpawnLocation(int x, int y, int z);

    /**
     * 获取这个世界在游戏中的相对时间。
     * <p>
     * 相对时间类似于小时数*1000（译注：意思是，如果这个世界在游戏中的时间为一个小时则相对时间显示为1000，一小时十二分为1200）
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
     * 设置服务器的在游戏中的相对时间。
     * <p>
     * 相对时间类似于小时数*1000（译注：意思是，如果这个世界在游戏中的时间为一个小时则相对时间显示为1000，一小时十二分为1200） 
     * <p>
     * 注意设置的相对时间如果小于当前相对时间则实际上是将时钟向前移动了一天。如果你要倒回时间，请使用{@link #setFullTime(long)}
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
     * 获取这个世界完整的游戏时间
     * <p>
     * 原文：
     * Gets the full in-game time on this world
     *
     * @return 当前绝对时间
     * @see #getTime() 返回这个世界的相对时间
     */
    public long getFullTime();

    /**
     * 设置服务器的游戏时间
     * <p>
     * 注意这是设置世界的全部时间，可能产生不好的影响，比如破坏红石钟或任一预定事件
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
     * 返回世界现在是否有风暴。
     * <p>
     * 原文：
     * Returns whether the world has an ongoing storm.
     *
     * @return 是否有风暴
     */
    public boolean hasStorm();

    /**
     * 设置是否有风暴。会为当前新的天气设置一段持续时间。
     * <p>
     * 原文：
     * Set whether there is a storm. A duration will be set for the new
     * current conditions.
     *
     * @param hasStorm 是否下雨或下雪
     */
    public void setStorm(boolean hasStorm);

    /**
     * 获取当前天气的剩余时间，单位为tick。
     * <p> 
     * 原文：
     * Get the remaining time in ticks of the current conditions.
     *
     * @return 时间，单位为tick
     */
    public int getWeatherDuration();

    /**
     * 设置当前天气的剩余时间，单位为tick。
     * <p>
     * 原文：
     * Set the remaining time in ticks of the current conditions.
     *
     * @param duration 时间，单位为tick
     */
    public void setWeatherDuration(int duration);

    /**
     * 返回是否打雷。
     * <p>
     * 原文：
     * Returns whether there is thunder.
     *
     * @return 是否打雷
     */
    public boolean isThundering();

    /**
     * 设置是否打雷。
     * <p>
     * 原文：
     * Set whether it is thundering.
     *
     * @param thundering 是否打雷
     */
    public void setThundering(boolean thundering);

    /**
     * 获取打雷持续时间。
     * <p>
     * 原文：
     * Get the thundering duration.
     *
     * @return 持续时间，单位为tick
     */
    public int getThunderDuration();

    /**
     * 设置打雷持续时间。
     * <p>
     * 原文：
     * Set the thundering duration.
     *
     * @param duration 持续时间，单位为tick
     */
    public void setThunderDuration(int duration);

    /**
     * 在指定坐标生成指定威力的爆炸
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
     * 在指定的坐标生成指定威力的爆炸并设置方块是否会着火。
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
     * 在指定的坐标生成指定威力的爆炸并设置方块是否会着火或被破坏。
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
     * 在指定坐标生成指定威力的爆炸
     * <p>
     * 原文：
     * Creates explosion at given coordinates with given power
     *
     * @param loc 爆炸方位
     * @param power 爆炸的威力，一个TNT当量为4F
     * @return 如果爆炸被取消则返回false，否则返回true
     */
    public boolean createExplosion(Location loc, float power);

    /**
     * 在指定的坐标生成指定威力的爆炸并设置方块是否会着火。
     * <p>
     * 原文：
     * Creates explosion at given coordinates with given power and optionally
     * setting blocks on fire.
     *
     * @param loc 爆炸方位
     * @param power 爆炸的威力，一个TNT当量为4F
     * @param setFire 方块是否会着火
     * @return 如果爆炸被取消则返回false，否则返回true
     */
    public boolean createExplosion(Location loc, float power, boolean setFire);

    /**
     * 获取世界的环境{@link Environment}类型
     * <p>
     * 原文：
     * Gets the {@link Environment} type of this world
     *
     * @return 这个世界的环境类型
     */
    public Environment getEnvironment();

    /**
     * 获取世界的种子。
     * <p>
     * 原文：
     * Gets the Seed for this world.
     *
     * @return 这个世界的种子
     */
    public long getSeed();

    /**
     * 获取世界的当前PVP设置。
     * <p>
     * 原文：
     * Gets the current PVP setting for this world.
     *
     * @return 如果允许PVP则返回true
     */
    public boolean getPVP();

    /**
     * 设置世界的PVP设置。
     * <p>
     * 原文：
     * Sets the PVP setting for this world.
     *
     * @param pvp 是否允许PVP，允许为True，不允许为False。
     */
    public void setPVP(boolean pvp);

    /**
     * 获取世界的区块生成器
     * <p>
     * 原文：
     * Gets the chunk generator for this world
     *
     * @return 这个世界相关的区块生成器（ChunkGenerator）。
     */
    public ChunkGenerator getGenerator();

    /**
     * 保存世界到磁盘
     * <p>
     * 原文：
     * Saves world to disk
     */
    public void save();

    /**
     * 获取一个这个世界使用的所有方块填充器{@link BlockPopulator}的列表
     * <p>
     * 原文：
     * Gets a list of all applied {@link BlockPopulator}s for this World
     *
     * @return 包含方块填充器的列表
     */
    public List<BlockPopulator> getPopulators();

    /**
     * 在指定的方位{@link Location}根据给定的类生成一个实体
     * <p>
     * 原文：
     * Spawn an entity of a specific class at the given {@link Location}
     *
     * @param location 生成实体的方位{@link Location}
     * @param clazz 生成实体{@link Entity}的类
     * @param <T> 生成实体{@link Entity}的类
     * @return 一个生成的实体{@link Entity}实例
     * @throws IllegalArgumentException 如果参数为空或被要求生成的实体{@link Entity}不能被生成则抛出错误
     */
    public <T extends Entity> T spawn(Location location, Class<T> clazz) throws IllegalArgumentException;

    /**
     * 在指定的方位{@link Location}根据给定的材料{@link Material}生成一个下落方块{@link FallingBlock}实体。材料决定下落的东西。当下落方块碰到地时就会放置这个方块。
     * <p>
     * 材料必须是一个经过{@link Material#isBlock()material.isBlock()}检验的方块类型。可能不是空气。
     * <p>
     * 原文：
     * Spawn a {@link FallingBlock} entity at the given {@link Location} of
     * the specified {@link Material}. The material dictates what is falling.
     * When the FallingBlock hits the ground, it will place that block.
     * <p>
     * The Material must be a block type, check with {@link Material#isBlock()
     * material.isBlock()}. The Material may not be air.
     *
     * @param location 生成下落方块的方位{@link Location}
     * @param material 方块材料{@link Material}类型
     * @param data 方块数据
     * @return 生成的下落方块{@link FallingBlock}实例
     * @throws IllegalArgumentException 如果方位{@link Location}或材料{@link Material} 为空或材料{@link Material}不是一个方块则抛出错误。
     * @deprecated 不安全的参数
     */
    @Deprecated
    public FallingBlock spawnFallingBlock(Location location, Material material, byte data) throws IllegalArgumentException;

    /**
     * 在指定的方位{@link Location}根据指定的方块ID（会被转换为材料{@link Material}）生成一个下落方块{@link FallingBlock}实体
     * <p>
     * 原文：
     * Spawn a {@link FallingBlock} entity at the given {@link Location} of
     * the specified blockId (converted to {@link Material})
     *
     * @param location 生成下落方块的方位{@link Location}
     * @param blockId 材料相应的ID
     * @param blockData 方块数据
     * @return 生成的下落方块实例
     * @throws IllegalArgumentException 如果方位为空或方块无效则抛出错误
     * @see #spawnFallingBlock(org.bukkit.Location, org.bukkit.Material, byte)
     * @deprecated 不安全的参数
     */
    @Deprecated
    public FallingBlock spawnFallingBlock(Location location, int blockId, byte blockData) throws IllegalArgumentException;

    /**
     * 向在以指定方位为圆心的默认半径的圆内的所有玩家施加一个效果（译注：不确定的翻译，可能是演奏一个效果）。
     * <p>
     * 原文：
     * Plays an effect to all players within a default radius around a given
     * location.
     *
     * @param location 玩家一定听得到声音的圆心方位{@link Location}
     * @param effect 效果{@link Effect}
     * @param data 一些效果需要的数据
     */
    public void playEffect(Location location, Effect effect, int data);

    /**
     * 向在以指定方位为圆心的指定半径的圆内的所有玩家施加一个效果（译注：不确定的翻译，可能是演奏一个效果）。
     * <p>
     * 原文：
     * Plays an effect to all players within a given radius around a location.
     *
     * @param location 玩家一定听得到效果的圆心方位{@link Location}
     * @param effect 效果{@link Effect}
     * @param data 一些效果需要的数据
     * @param radius 半径
     */
    public void playEffect(Location location, Effect effect, int data, int radius);

    /**
     * 向在以指定方位为圆心的默认半径的圆内的所有玩家施加一个效果（译注：不确定的翻译，可能是演奏一个效果）。
     * <p>
     * 原文：
     * Plays an effect to all players within a default radius around a given
     * location.
     *
     * @param <T> 取决于效果类型的数据
     * @param location 玩家一定听得到声音的圆心方位{@link Location}
     * @param effect 效果{@link Effect}
     * @param data 一些效果需要的数据
     */
    public <T> void playEffect(Location location, Effect effect, T data);

    /**
     * 向在以指定方位为圆心的指定半径的圆内的所有玩家施加一个效果（译注：不确定的翻译，可能是演奏一个效果）。
     * <p>
     * 原文：
     * Plays an effect to all players within a given radius around a location.
     *
     * @param <T> 取决于效果类型的数据
     * @param location 玩家一定听得到效果的圆心方位{@link Location}
     * @param effect 效果{@link Effect}
     * @param data 一些效果需要的数据
     * @param radius 半径
     */
    public <T> void playEffect(Location location, Effect effect, T data, int radius);

    /**
     * 获取空区块的快照（相当于所有空气方块），
     * <p>
     * 原文：
     * Get empty chunk snapshot (equivalent to all air blocks), optionally
     * including valid biome data. Used for representing an ungenerated chunk,
     * or for fetching only biome data without loading a chunk.
     *
     * @param x - chunk x coordinate
     * @param z - chunk z coordinate
     * @param includeBiome - if true, snapshot includes per-coordinate biome
     *     type
     * @param includeBiomeTempRain - if true, snapshot includes per-coordinate
     *     raw biome temperature and rainfall
     * @return The empty snapshot.
     */
    public ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome, boolean includeBiomeTempRain);

    /**
     * Sets the spawn flags for this.
     *
     * @param allowMonsters - if true, monsters are allowed to spawn in this
     *     world.
     * @param allowAnimals - if true, animals are allowed to spawn in this
     *     world.
     */
    public void setSpawnFlags(boolean allowMonsters, boolean allowAnimals);

    /**
     * Gets whether animals can spawn in this world.
     *
     * @return whether animals can spawn in this world.
     */
    public boolean getAllowAnimals();

    /**
     * Gets whether monsters can spawn in this world.
     *
     * @return whether monsters can spawn in this world.
     */
    public boolean getAllowMonsters();

    /**
     * Gets the biome for the given block coordinates.
     *
     * @param x X coordinate of the block
     * @param z Z coordinate of the block
     * @return Biome of the requested block
     */
    Biome getBiome(int x, int z);

    /**
     * Sets the biome for the given block coordinates
     *
     * @param x X coordinate of the block
     * @param z Z coordinate of the block
     * @param bio new Biome type for this block
     */
    void setBiome(int x, int z, Biome bio);

    /**
     * Gets the temperature for the given block coordinates.
     * <p>
     * It is safe to run this method when the block does not exist, it will
     * not create the block.
     *
     * @param x X coordinate of the block
     * @param z Z coordinate of the block
     * @return Temperature of the requested block
     */
    public double getTemperature(int x, int z);

    /**
     * Gets the humidity for the given block coordinates.
     * <p>
     * It is safe to run this method when the block does not exist, it will
     * not create the block.
     *
     * @param x X coordinate of the block
     * @param z Z coordinate of the block
     * @return Humidity of the requested block
     */
    public double getHumidity(int x, int z);

    /**
     * Gets the maximum height of this world.
     * <p>
     * If the max height is 100, there are only blocks from y=0 to y=99.
     *
     * @return Maximum height of the world
     */
    public int getMaxHeight();

    /**
     * Gets the sea level for this world.
     * <p>
     * This is often half of {@link #getMaxHeight()}
     *
     * @return Sea level
     */
    public int getSeaLevel();

    /**
     * Gets whether the world's spawn area should be kept loaded into memory
     * or not.
     *
     * @return true if the world's spawn area will be kept loaded into memory.
     */
    public boolean getKeepSpawnInMemory();

    /**
     * Sets whether the world's spawn area should be kept loaded into memory
     * or not.
     *
     * @param keepLoaded if true then the world's spawn area will be kept
     *     loaded into memory.
     */
    public void setKeepSpawnInMemory(boolean keepLoaded);

    /**
     * Gets whether or not the world will automatically save
     *
     * @return true if the world will automatically save, otherwise false
     */
    public boolean isAutoSave();

    /**
     * Sets whether or not the world will automatically save
     *
     * @param value true if the world should automatically save, otherwise
     *     false
     */
    public void setAutoSave(boolean value);

    /**
     * Sets the Difficulty of the world.
     *
     * @param difficulty the new difficulty you want to set the world to
     */
    public void setDifficulty(Difficulty difficulty);

    /**
     * Gets the Difficulty of the world.
     *
     * @return The difficulty of the world.
     */
    public Difficulty getDifficulty();

    /**
     * Gets the folder of this world on disk.
     *
     * @return The folder of this world.
     */
    public File getWorldFolder();

    /**
     * Gets the type of this world.
     *
     * @return Type of this world.
     */
    public WorldType getWorldType();

    /**
     * Gets whether or not structures are being generated.
     *
     * @return True if structures are being generated.
     */
    public boolean canGenerateStructures();

    /**
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
     * @return The world's ticks per animal spawns value
     */
    public long getTicksPerAnimalSpawns();

    /**
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
     * @param ticksPerAnimalSpawns the ticks per animal spawns value you want
     *     to set the world to
     */
    public void setTicksPerAnimalSpawns(int ticksPerAnimalSpawns);

    /**
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
     * @return The world's ticks per monster spawns value
     */
    public long getTicksPerMonsterSpawns();

    /**
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
     * @param ticksPerMonsterSpawns the ticks per monster spawns value you
     *     want to set the world to
     */
    public void setTicksPerMonsterSpawns(int ticksPerMonsterSpawns);

    /**
     * Gets limit for number of monsters that can spawn in a chunk in this
     * world
     *
     * @return The monster spawn limit
     */
    int getMonsterSpawnLimit();

    /**
     * Sets the limit for number of monsters that can spawn in a chunk in this
     * world
     * <p>
     * <b>Note:</b> If set to a negative number the world will use the
     * server-wide spawn limit instead.
     * 
     * @param limit the new mob limit
     */
    void setMonsterSpawnLimit(int limit);

    /**
     * Gets the limit for number of animals that can spawn in a chunk in this
     * world
     *
     * @return The animal spawn limit
     */
    int getAnimalSpawnLimit();

    /**
     * Sets the limit for number of animals that can spawn in a chunk in this
     * world
     * <p>
     * <b>Note:</b> If set to a negative number the world will use the
     * server-wide spawn limit instead.
     * 
     * @param limit the new mob limit
     */
    void setAnimalSpawnLimit(int limit);

    /**
     * Gets the limit for number of water animals that can spawn in a chunk in
     * this world
     *
     * @return The water animal spawn limit
     */
    int getWaterAnimalSpawnLimit();

    /**
     * Sets the limit for number of water animals that can spawn in a chunk in
     * this world
     * <p>
     * <b>Note:</b> If set to a negative number the world will use the
     * server-wide spawn limit instead.
     * 
     * @param limit the new mob limit
     */
    void setWaterAnimalSpawnLimit(int limit);

    /**
     * Gets the limit for number of ambient mobs that can spawn in a chunk in
     * this world
     *
     * @return The ambient spawn limit
     */
    int getAmbientSpawnLimit();

    /**
     * Sets the limit for number of ambient mobs that can spawn in a chunk in
     * this world
     * <p>
     * <b>Note:</b> If set to a negative number the world will use the
     * server-wide spawn limit instead.
     * 
     * @param limit the new mob limit
     */
    void setAmbientSpawnLimit(int limit);

    /**
     * Play a Sound at the provided Location in the World
     * <p>
     * This function will fail silently if Location or Sound are null.
     *
     * @param location The location to play the sound
     * @param sound The sound to play
     * @param volume The volume of the sound
     * @param pitch The pitch of the sound
     */
    void playSound(Location location, Sound sound, float volume, float pitch);

    /**
     * Get existing rules
     *
     * @return An array of rules
     */
    public String[] getGameRules();

    /**
     * Gets the current state of the specified rule
     * <p>
     * Will return null if rule passed is null
     *
     * @param rule Rule to look up value of
     * @return String value of rule
     */
    public String getGameRuleValue(String rule);

    /**
     * Set the specified gamerule to specified value.
     * <p>
     * The rule may attempt to validate the value passed, will return true if
     * value was set.
     * <p>
     * If rule is null, the function will return false.
     *
     * @param rule Rule to set
     * @param value Value to set rule to
     * @return True if rule was set
     */
    public boolean setGameRuleValue(String rule, String value);

    /**
     * Checks if string is a valid game rule
     *
     * @param rule Rule to check
     * @return True if rule exists
     */
    public boolean isGameRule(String rule);

    /**
     * Gets the world border for this world.
     *
     * @return The world border for this world.
     */
    public WorldBorder getWorldBorder();

    /**
     * Represents various map environment types that a world may be
     */
    public enum Environment {

        /**
         * Represents the "normal"/"surface world" map
         */
        NORMAL(0),
        /**
         * Represents a nether based map ("hell")
         */
        NETHER(-1),
        /**
         * Represents the "end" map
         */
        THE_END(1);

        private final int id;
        private static final Map<Integer, Environment> lookup = new HashMap<Integer, Environment>();

        private Environment(int id) {
            this.id = id;
        }

        /**
         * Gets the dimension ID of this environment
         *
         * @return dimension ID
         * @deprecated Magic value
         */
        @Deprecated
        public int getId() {
            return id;
        }

        /**
         * Get an environment by ID
         *
         * @param id The ID of the environment
         * @return The environment
         * @deprecated Magic value
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
