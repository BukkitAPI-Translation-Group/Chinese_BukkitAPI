package org.bukkit;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.logging.Logger;

import org.bukkit.Warning.WarningState;
import org.bukkit.block.data.BlockData;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.Recipe;
import org.bukkit.loot.LootTable;
import org.bukkit.map.MapView;
import org.bukkit.permissions.Permissible;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.plugin.messaging.PluginMessageRecipient;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;

import com.google.common.collect.ImmutableList;
import org.bukkit.advancement.Advancement;
import org.bukkit.generator.ChunkGenerator;

import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * 代表执行插件的服务器.
 */
public interface Server extends PluginMessageRecipient {

    /**
     * 用于所有的操作命令，如控制台命令.
     * <p>
     * 原文:Used for all administrative messages, such as an operator using a
     * command.
     * <p>
     * 用于{@link #broadcast(java.lang.String, java.lang.String)}.
     */
    public static final String BROADCAST_CHANNEL_ADMINISTRATIVE = "bukkit.broadcast.admin";

    /**
     * 用于所有的公告信息，如通知玩家已加入的用户.
     * <p>
     * 原文:Used for all announcement messages, such as informing users that a
     * player has joined.
     * <p>
     * 用于{@link #broadcast(java.lang.String, java.lang.String)}.
     */
    public static final String BROADCAST_CHANNEL_USERS = "bukkit.broadcast.user";

    /**
     * 获得服务器名字.
     * <p>
     * 原文:Gets the name of this server implementation.
     *
     * @return 服务器名字
     */
    public String getName();

    /**
     * 获得服务器版本字符串.
     * <p>
     * 原文:Gets the version string of this server implementation.
     *
     * @return 服务器版本字符串
     */
    public String getVersion();

    /**
     * 获得服务器运行的Bukkit版本.
     * <p>
     * 原文:Gets the Bukkit version that this server is running.
     *
     * @return Bukkit版本
     */
    public String getBukkitVersion();

    /**
     * 获得一个当前所有已登录玩家的集合.
     * <p>
     * 原文:Gets a view of all currently logged in players. This {@linkplain
     * Collections#unmodifiableCollection(Collection) view} is a reused
     * object, making some operations like {@link Collection#size()}
     * zero-allocation.
     * <p>
     * The collection is a view backed by the internal representation, such
     * that, changes to the internal state of the server will be reflected
     * immediately. However, the reuse of the returned collection (identity)
     * is not strictly guaranteed for future or all implementations. Casting
     * the collection, or relying on interface implementations (like {@link
     * Serializable} or {@link List}), is deprecated.
     * <p>
     * Iteration behavior is undefined outside of self-contained main-thread
     * uses. Normal and immediate iterator use without consequences that
     * affect the collection are fully supported. The effects following
     * (non-exhaustive) {@link Entity#teleport(Location) teleportation},
     * {@link Player#setHealth(double) death}, and {@link Player#kickPlayer(
     * String) kicking} are undefined. Any use of this collection from
     * asynchronous threads is unsafe.
     * <p>
     * For safe consequential iteration or mimicking the old array behavior,
     * using {@link Collection#toArray(Object[])} is recommended. For making
     * snapshots, {@link ImmutableList#copyOf(Collection)} is recommended.
     *
     * @return 当前所有已登录玩家的集合.
     */
    public Collection<? extends Player> getOnlinePlayers();

    /**
     * 获得服务器可同时在线玩家最高人数.
     * <p>
     * 原文:Get the maximum amount of players which can login to this server.
     *
     * @return 同时在线玩家最高人数
     */
    public int getMaxPlayers();

    /**
     * 获得服务器端口.
     * <p>
     * 原文:Get the game port that the server runs on.
     *
     * @return 服务器端口
     */
    public int getPort();

    /**
     * 获得当前设置的视距
     * <p>
     * 原文:Get the view distance from this server.
     *
     * @return 服务器当前设置的视距.
     */
    public int getViewDistance();

    /**
     * 获得当前服务器绑定的IP,当未设置时返回为空
     * <p>
     * 原文:Get the IP that this server is bound to, or empty string if not
     * specified.
     *
     * @return 获得当前服务器绑定的IP,未绑定则为空
     */
    public String getIp();

    /**
     * 获得服务器名字.
     * <p>
     * 原文:Get the name of this server.
     *
     * @return 服务器名字
     */
    public String getServerName();

    /**
     * 获得服务器的ID,该ID通常由数字和字母组成,这个ID可以用于识别服务器
     * <p>
     * 原文:Get an ID of this server. The ID is a simple generally alphanumeric ID
     * that can be used for uniquely identifying this server.
     *
     * @return 服务器的ID
     */
    public String getServerId();

    /**
     * 获得主世界的世界类型(检测主世界的世界类型).
     * <p>
     * 原文:Get world type (level-type setting) for default world.
     *
     * @return 世界类型(比如:DEFAULT, FLAT, DEFAULT_1_1)
     */
    public String getWorldType();

    /**
     * 获得是否允许生成器构造(对应server.properties文件中的generate-structures)
     * <p>
     * 原文:Get generate-structures setting.
     *
     * @return 当启用时返回true否则返回false
     */
    public boolean getGenerateStructures();

    /**
     * 获取该服务器是否允许末地
     * <p>
     * 原文:Gets whether this server allows the End or not.
     *
     * @return 允许则返回true,否则返回false
     */
    public boolean getAllowEnd();

    /**
     * 
     * Gets whether this server allows the Nether or not.
     *
     * @return whether this server allows the Nether or not
     */
    public boolean getAllowNether();

    /**
     * 获取该服务器是否有白名单
     * <p>
     * 原文:Gets whether this server has a whitelist or not.
     *
     * @return 有则返回true,否则返回false
     */
    public boolean hasWhitelist();

    /**
     * 设置该服务器是是否开启白名单
     * <p>
     * 原文:Sets if the server is whitelisted.
     *
     * @param value 为true时则开启白名单,false则关闭白名单
     */
    public void setWhitelist(boolean value);

    /**
     * 获得所有在白名单中的玩家.
     * <p>
     * 原文:Gets a list of whitelisted players.
     *
     * @return 白名单中的玩家
     */
    public Set<OfflinePlayer> getWhitelistedPlayers();

    /**
     * 重新加载服务器白名单配置.
     * <p>
     * 原文:Reloads the whitelist from disk.
     */
    public void reloadWhitelist();

    /**
     * 广播一条消息到所有玩家.
     * <p>
     * 这与调用{@link #broadcast(java.lang.String,
     * java.lang.String)}(第二个参数为{@link #BROADCAST_CHANNEL_USERS})相当。
     * <p>
     * 原文:Broadcast a message to all players.
     * <p>
     * This is the same as calling {@link #broadcast(java.lang.String,
     * java.lang.String)} to {@link Server#BROADCAST_CHANNEL_USERS}
     *
     * @param message 要广播的消息
     * @return 成功接收此消息的玩家数
     */
    public int broadcastMessage(String message);

    /**
     * 获取更新文件夹的名字. 系统将会在插件加载时选择适当的时机利用此文件夹来安全地更新插件.
     * <p>
     * 更新文件夹相对于插件文件夹.
     * <p>
     * Tips：如何使用更新文件夹来实现更新您的插件呢？（服主和开发者都可以了解下)：
     * <ol>
     * <li>创建更新文件夹，已有则跳过此步.
     * <li>下载您要更新的插件到此目录 (注意：jar文件名必须和在插件目录下的jar文件名一样，否则不起作用。).
     * <li>重载/重启服务器.
     * <li>OK，看效果吧.
     * </ol>
     *
     * 原文:
     * Gets the name of the update folder. The update folder is used to safely
     * update plugins at the right moment on a plugin load.
     * <p>
     * The update folder name is relative to the plugins folder.
     *
     * @return 更新文件夹的名字
     */
    public String getUpdateFolder();

    /**
     * 获取表示更新文件夹的 File 实例. 系统将会在插件加载时选择适当的时机利用此文件夹来安全地更新插件.
     * <p>
     * 原文:
     * Gets the update folder. The update folder is used to safely update
     * plugins at the right moment on a plugin load.
     *
     * @return 表示更新文件夹的 File 实例
     */
    public File getUpdateFolderFile();

    /**
     * 获取玩家重连服务器的间隔(-1则为无限制)
     * <p>
     * 原文:Gets the value of the connection throttle setting.
     *
     * @return 返回玩家重连服务器的间隔
     */
    public long getConnectionThrottle();

    /**
     * 获得每隔多少ticks生成动物
     * <p>
     * 原文:Gets default ticks per animal spawns value.
     * <p>
     * <b>示例:</b>
     * <ul>
     * <li>值为1时服务器将尝试每tick都生成动物
     * <li>值为400服务器将每400tick尝试生成一次动物
     * <li>一个低于0的值将会被重置设为默认值(默认为400)
     * </ul>
     * <p>
     * <b>注意:</b>如果设置为0,动物生成将会被禁止,我们推荐使用spawn-animals代替用于控制动物生成
     * <p>
     *
     * @return 返回生成动物间隔的tick
     */
    public int getTicksPerAnimalSpawns();

    /**
     * 获得每隔多少ticks生成怪物
     * <p>
     * 原文:Gets the default ticks per monster spawns value.
     * <p>
     * <b>示例:</b>
     * <ul>
     * <li>值为1时服务器将尝试每tick都生成怪物
     * <li>值为400服务器将每400tick尝试生成一次怪物
     * <li>一个低于0的值将会被重重设为默认值(默认为1)
     * </ul>
     * <p>
     * <b>注意:</b>如果设置为0,动物生成将会被禁止,我们推荐使用spawn-monsters代替用于控制动物生成
     * <p>
     *
     * @return 返回生成怪物间隔的tick
     */
    public int getTicksPerMonsterSpawns();

    /**
     * 根据玩家的名字来获取一个玩家的实例
     * <p>
     * 原文:Gets a player object by the given username.
     * <p>
     * 这个方法不会返回不在线玩家的实例(意思就是说获取的玩家必须在线,否则返回null)
     *
     * @deprecated 请使用 {@link #getPlayer(UUID)} 用玩家名查找无法保证唯一性
     * @param name 被查找玩家的名字
     * @return 一个在线玩家实例或者null
     */
    @Deprecated
    public Player getPlayer(String name);

    /**
     * 通过玩家名准确的查找来获得一个玩家实例,避免大小写问题(译注:该方法使用频率极低)
     * <p>
     * 原文:Gets the player with the exact given name, case insensitive.
     *
     * @deprecated 请使用 {@link #getPlayer(UUID)} 用玩家名查找无法保证唯一性
     * @param name 被查找玩家的准确名字
     * @return 一个在线玩家的实例或者null
     */
    @Deprecated
    public Player getPlayerExact(String name);

    /**
     * 尝试用name匹配所有玩家并且返回一个所有匹配玩家的List
     * <p>
     * 原文:Attempts to match any players with the given name, and returns a list
     * of all possibly matches.
     * <p>
     * 该list未排序,如果准确匹配到某个玩家则该List仅包含该玩家
     * <p>
     * 原文:This list is not sorted in any particular order. If an exact match is
     * found, the returned list will only contain a single result.
     *
     * @deprecated 请使用 {@link #getPlayer(UUID)} 用玩家名查找无法保证唯一性
     * @param name 匹配玩家名
     * @return 所有匹配玩家的List(译注:遍历该List时记得检测玩家是否在线)
     */
    @Deprecated
    public List<Player> matchPlayer(String name);

    /**
     * 通过UUID获取玩家的实例
     * <p>
     * 原文:Gets the player with the given UUID.
     *
     * @param id 用于检索玩家的UUID
     * @return 一个在线玩家的实例或者null
     */
    public Player getPlayer(UUID id);

    /**
     * 获取PluginManager接口的实例
     * <p>
     * 原文:Gets the plugin manager for interfacing with plugins.
     *
     * @return 返回PluginManager接口的实例
     */
    public PluginManager getPluginManager();

    /**
     * 获取BukkitScheduler接口的实例用来安排任务
     * <p>
     * 原文:Gets the scheduler for managing scheduled events.
     *
     * @return BukkitScheduler接口的实例
     */
    public BukkitScheduler getScheduler();

    /**
     * 获取ServicesManager
     * <p>
     * 原文:Gets a services manager.
     *
     * @return 返回ServicesManager
     */
    public ServicesManager getServicesManager();

    /**
     * 获取服务器以List封装的所有World
     * <p>
     * 原文:Gets a list of all worlds on this server.
     *
     * @return 一个包含服务器所有World的List
     */
    public List<World> getWorlds();

    /**
     * 使用给定的名字和配置来创建或者加载一个World
     * <p>
     * 原文:Creates or loads a world with the given name using the specified
     * options.
     * <p>
     * 如果该World已经被加载,它相当于返回getWorld(creator.name())
     * <p>
     * 原文:If the world is already loaded, it will just return the equivalent of
     * getWorld(creator.name()).
     *
     * @param creator 世界生成器
     * @return 返回新建的World或者已被服务器加载的World实例
     */
    public World createWorld(WorldCreator creator);

    /**
     * 通过给定的名字从服务器卸载一个World
     * <p>
     * 原文:Unloads a world with the given name.
     *
     * @param name 需要被卸载的世界的名字
     * @param save 是否在卸载World前保存区块数据
     * @return 成功则返回true否则返回fasle
     */
    public boolean unloadWorld(String name, boolean save);

    /**
     * 通过给定的Wrold实例从服务器卸载一个World
     * <p>
     * 原文:Unloads the given world.
     *
     * @param world 被卸载的World实例
     * @param save 是否在卸载World前保存区块数据
     * @return  成功则返回true否则返回fasle
     */
    public boolean unloadWorld(World world, boolean save);

    /**
     * 通过给定的name获取一个World实例
     * <p>
     * 原文:Gets the world with the given name.
     *
     * @param name 被获取世界的name
     * @return World实例,当世界不存在时将返回null
     */
    public World getWorld(String name);

    /**
     * 通过UUID获取World实例
     * <p>
     * 原文:Gets the world from the given Unique ID.
     *
     * @param uid 被获取的World的UUID
     * @return  World实例,当世界不存在时将返回null
     */
    public World getWorld(UUID uid);

    /**
     * 通过给定的item ID获取MapView实例
     * <p>
     * 原文:Gets the map from the given item ID.
     *
     * @param id 需要被获取的Map的id
     * @return MapView实例,当Map不存在时将返回null
     * @deprecated 不安全的参数
     */
    @Deprecated
    public MapView getMap(short id);

    /**
     * 创建一个新的MapView实例并且自动分配ID
     * <p>
     * Create a new map with an automatically assigned ID.
     *
     * @param world 该Map所属的World
     * @return 一个新的MapView实例
     */
    public MapView createMap(World world);

    /**
     * Create a new explorer map targeting the closest nearby structure of a
     * given {@link StructureType}.
     * <br>
     * This method uses implementation default values for radius and
     * findUnexplored (usually 100, true).
     *
     * @param world the world the map will belong to
     * @param location the origin location to find the nearest structure
     * @param structureType the type of structure to find
     * @return a newly created item stack
     *
     * @see World#locateNearestStructure(org.bukkit.Location,
     *      org.bukkit.StructureType, int, boolean)
     */
    public ItemStack createExplorerMap(World world, Location location, StructureType structureType);

    /**
     * Create a new explorer map targeting the closest nearby structure of a
     * given {@link StructureType}.
     * <br>
     * This method uses implementation default values for radius and
     * findUnexplored (usually 100, true).
     *
     * @param world the world the map will belong to
     * @param location the origin location to find the nearest structure
     * @param structureType the type of structure to find
     * @param radius radius to search, see World#locateNearestStructure for more
     *               information
     * @param findUnexplored whether to find unexplored structures
     * @return the newly created item stack
     *
     * @see World#locateNearestStructure(org.bukkit.Location,
     *      org.bukkit.StructureType, int, boolean)
     */
    public ItemStack createExplorerMap(World world, Location location, StructureType structureType, int radius, boolean findUnexplored);

    /**
     * 重新加载服务器并刷新设置和插件信息.
     * <p>
     * 原文:Reloads the server, refreshing settings and plugin information.
     */
    public void reload();

    /**
     * 只重载Minecraft游戏数据. 这包括自定义的进度和掉落表.
     * <p>
     * 原文:Reload only the Minecraft data for the server. This includes custom
     * advancements and loot tables.
     */
    public void reloadData();  

    /**
     * 返回此服务器的日志记录.
     * <p>
     * 原文:Returns the primary logger associated with this server instance.
     *
     * @return 服务器日志
     */
    public Logger getLogger();

    /**
     * 获取一个{@link PluginCommand}通过给定的name或者别称
     * <p>
     * 原文:Gets a {@link PluginCommand} with the given name or alias.
     *
     * @param name 命令名
     * @return 如果找到该名字的Command则返回PluginCommand实例,否则返回null
     */
    public PluginCommand getPluginCommand(String name);

    /**
     * 将以记载的玩家储存到硬盘
     * <p>
     * 原文:Writes loaded players to disk.
     */
    public void savePlayers();

    /**
     * 在服务器执行一个命令
     * <p>
     * 原文:Dispatches a command on this server, and executes it if found.
     *
     * @param sender 执行该命令的对象
     * @param commandLine sender执行的命令,由命令和参数组成. 示例: <code>test abc
     *     123</code>
     * @return 如果无法找到目标则返回false,否则返回true
     * @throws CommandException 抛出执行期间出现的未捕获的异常
     */
    public boolean dispatchCommand(CommandSender sender, String commandLine) throws CommandException;

    /**
     * 向服务器添加一个配方
     * <p>
     * 原文:Adds a recipe to the crafting manager.
     *
     * @param recipe 被添加的配方
     * @return 当配方成功添加时返回true,否则返回false
     */
    public boolean addRecipe(Recipe recipe);

    /**
     * 获取一个合成ItemStack的所有配方,如果副ID为-1将匹配所有的数据值
     * <p>
     * 原文:Get a list of all recipes for a given item. The stack size is ignored
     * in comparisons. If the durability is -1, it will match any data value.
     *
     * @param result 被获取配方的ItemStack
     * @return 配方的List实例
     */
    public List<Recipe> getRecipesFor(ItemStack result);

    /**
     * 获取配方迭代器
     * <p>
     * 原文:Get an iterator through the list of crafting recipes.
     *
     * @return 配方的迭代器
     */
    public Iterator<Recipe> recipeIterator();

    /**
     * 清空配方
     * <p>
     * 原文:Clears the list of crafting recipes.
     */
    public void clearRecipes();

    /**
     * 重置配方
     * <p>
     * 原文:Resets the list of crafting recipes to the default.
     */
    public void resetRecipes();

    /**
     * 获取一个定义于服务器配置文件中的命令别名列表
     * <p>
     * 原文:Gets a list of command aliases defined in the server properties.
     *
     * @return 储存有命令及其别名List的Map实例
     */
    public Map<String, String[]> getCommandAliases();

    /**
     * 获得此世界的出生点保护半径.
     * <p>
     * 原文:Gets the radius, in blocks, around each worlds spawn point to protect.
     *
     * @return 半径(如果没有则返回0)
     */
    public int getSpawnRadius();

    /**
     * 设置这个世界的出生点保护半径.
     * <p>
     * 原文:Sets the radius, in blocks, around each worlds spawn point to protect.
     *
     * @param value 新的半径(若没有则设置0)
     */
    public void setSpawnRadius(int value);

    /**
     * 获得服务器是否开启了正版模式.
     * <p>
     * 原文:Gets whether the Server is in online mode or not.
     *
     * @return true则开启/false反之
     */
    public boolean getOnlineMode();

    /**
     * 获得服务器是否开启了飞行模式.
     * <p>
     * 原文:Gets whether this server allows flying or not.
     *
     * @return true则开启/false反之
     */
    public boolean getAllowFlight();

    /**
     * 获得服务器是否开启了极限生存模式.
     * <p>
     * 原文:Gets whether the server is in hardcore mode or not.
     *
     * @return true则开启/false反之
     */
    public boolean isHardcore();

    /**
     * 彻底关闭服务器.
     * <p>
     * 原文:Shutdowns the server, stopping everything.
     */
    public void shutdown();

    /**
     * 向有给定权限的用户广播一条消息.
     * <p>
     * 原文:Broadcasts the specified message to every user with the given
     * permission name.
     *
     * @param message 需要广播的消息
     * @param permission 接受这条公告需要拥有的{@link Permissible
     *     权限许可}
     * @return 成功接收此消息的玩家数
     */
    public int broadcast(String message, String permission);

    /**
     * 通过给定的name获取OfflinePlayer实例
     * <p>
     * 原文:Gets the player by the given name, regardless if they are offline or
     * online.
     * <p>
     * 该方法将会阻塞式调用一个网络请求用于获取给定name的UUID
     * <p>
     * 原文:This method may involve a blocking web request to get the UUID for the
     * given name.
     * <p>
     * 对于该方法而言所有玩家都是存在的,即使玩家从未登录过服务器也会返回一个OfflinePlayer实例
     * <p>
     * 原文:This will return an object even if the player does not exist. To this
     * method, all players will exist.
     *
     * @deprecated UUID将会在不久后代替name
     * @param name 玩家的name
     * @return OfflinePlayer实例
     * @see #getOfflinePlayer(java.util.UUID)
     */
    @Deprecated
    public OfflinePlayer getOfflinePlayer(String name);

    /**
     * 通过UUID获取OfflinePlayer实例
     * <p>
     * 原文:Gets the player by the given UUID, regardless if they are offline or
     * online.
     * <p>
     * 对于该方法而言所有玩家都是存在的,即使玩家从未登录过服务器也会返回一个OfflinePlayer实例
     * <p>
     * 原文:This will return an object even if the player does not exist. To this
     * method, all players will exist.
     *
     * @param id 玩家的UUID
     * @return OfflinePlayer实例
     */
    public OfflinePlayer getOfflinePlayer(UUID id);

    /**
     * 获取一个被ban的IP的Set实例
     * <p>
     * 原文:Gets a set containing all current IPs that are banned.
     *
     * @return 一个包含被ban的IP的set实例
     */
    public Set<String> getIPBans();

    /**
     * 设置禁止此ip地址登陆到服务器.
     * <p>
     * 原文:Bans the specified address from the server.
     *
     * @param address 禁止登陆的IP地址
     */
    public void banIP(String address);

    /**
     * 解除禁止此ip地址登陆到服务器.
     * <p>
     * 原文:Unbans the specified address from the server.
     *
     * @param address 解除禁止登陆的IP地址
     */
    public void unbanIP(String address);

    /**
     * 获得一组所有被服务器封禁的玩家.
     * <p>
     * 原文:Gets a set containing all banned players.
     *
     * @return 一组玩家
     */
    public Set<OfflinePlayer> getBannedPlayers();

    /**
     * 通过提供的BanList.Type来获取一个BanList
     * <p>
     * 原文:Gets a ban list for the supplied type.
     * <p>
     * ban玩家name将不会受到支持,ban UUID更好
     * <p>
     * 原文:Bans by name are no longer supported and this method will return
     * null when trying to request them. The replacement is bans by UUID.
     *
     * @param type 需要获取的BanList的类型
     * @return BanList实例
     */
    public BanList getBanList(BanList.Type type);

    /**
     * 获取一个包含所有OP的Set实例
     * <p>
     * 原文:Gets a set containing all player operators.
     *
     * @return 一个包含所有OP的Set实例
     */
    public Set<OfflinePlayer> getOperators();

    /**
     * 获得新玩家的默认 {@link GameMode}.
     * <p>
     * 原文:Gets the default {@link GameMode} for new players.
     *
     * @return 默认游戏模式
     */
    public GameMode getDefaultGameMode();

    /**
     * 设置新玩家的默认 {@link GameMode}.
     * <p>
     * 原文:Sets the default {@link GameMode} for new players.
     *
     * @param mode 新的游戏模式
     */
    public void setDefaultGameMode(GameMode mode);

    /**
     * 获取一个{@link ConsoleCommandSender} 将被作为服务器的标准输入(译注:该方法用于获取控制台)
     *
     * @return 控制台对象
     */
    public ConsoleCommandSender getConsoleSender();

    /**
     * 获取 {@link World}的文件夹的File实例.
     *
     * @return 包含所有World的文件夹的File实例
     */
    public File getWorldContainer();

    /**
     * 获取所有登陆过服务器的玩家
     * <p>
     * 原文:Gets every player that has ever played on this server.     
     * @return 包含所有登录过的玩家的数组
     */
    public OfflinePlayer[] getOfflinePlayers();

    /**
     * 获取{@link Messenger}实例
     * <p>
     * 原文:Gets the {@link Messenger} responsible for this server.
     *
     * @return 负责该服务器的Messenger
     */
    public Messenger getMessenger();

    /**
     * 获取该服务器用于提供帮助的{@link HelpMap}
     * <p>
     * 原文:Gets the {@link HelpMap} providing help topics for this server.
     *
     * @return HelpMap实例
     */
    public HelpMap getHelpMap();

    /**
     * Creates an empty inventory with the specified type and title. If the type
     * is {@link InventoryType#CHEST}, the new inventory has a size of 27;
     * otherwise the new inventory has the normal size for its type.<br>
     * It should be noted that some inventory types do not support titles and
     * may not render with said titles on the Minecraft client.
     * <br>
     * {@link InventoryType#WORKBENCH} will not process crafting recipes if
     * created with this method. Use
     * {@link Player#openWorkbench(Location, boolean)} instead.
     * <br>
     * {@link InventoryType#ENCHANTING} will not process {@link ItemStack}s
     * for possible enchanting results. Use
     * {@link Player#openEnchanting(Location, boolean)} instead.
     *
     * @param owner the holder of the inventory, or null to indicate no holder
     * @param type the type of inventory to create
     * @return a new inventory
     * @throws IllegalArgumentException if the {@link InventoryType} cannot be
     * viewed.
     *
     * @see InventoryType#isCreatable()
     */
    Inventory createInventory(InventoryHolder owner, InventoryType type);

    /**
     * Creates an empty inventory with the specified type and title. If the type
     * is {@link InventoryType#CHEST}, the new inventory has a size of 27;
     * otherwise the new inventory has the normal size for its type.<br>
     * It should be noted that some inventory types do not support titles and
     * may not render with said titles on the Minecraft client.
     * <br>
     * {@link InventoryType#WORKBENCH} will not process crafting recipes if
     * created with this method. Use
     * {@link Player#openWorkbench(Location, boolean)} instead.
     * <br>
     * {@link InventoryType#ENCHANTING} will not process {@link ItemStack}s
     * for possible enchanting results. Use
     * {@link Player#openEnchanting(Location, boolean)} instead.
     *
     * @param owner The holder of the inventory; can be null if there's no holder.
     * @param type The type of inventory to create.
     * @param title The title of the inventory, to be displayed when it is viewed.
     * @return The new inventory.
     * @throws IllegalArgumentException if the {@link InventoryType} cannot be
     * viewed.
     *
     * @see InventoryType#isCreatable()
     */
    Inventory createInventory(InventoryHolder owner, InventoryType type, String title);

    /**
     * 使用{@link InventoryType#CHEST}创建一个给定大小的Inventory
     * <p>
     * 原文:Creates an empty inventory of type {@link InventoryType#CHEST} with the
     * specified size.
     *
     * @param owner 该物品栏的拥有者,为null则表明无拥有者
     * @param size 被创建的Inventory的大小,该值应为9的倍数
     * @return Inventory实例
     * @throws IllegalArgumentException 如果size不为9的倍数
     */
    Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException;

    /**
     * 通过一个特定的大小和标题使用{@link InventoryType#CHEST}来创建一个空的物品栏
     * <p>
     * 原文:Creates an empty inventory of type {@link InventoryType#CHEST} with the
     * specified size and title.
     *
     * @param owner 该物品栏的拥有者,为null则表明无拥有者
     * @param size 被创建的Inventory的大小,该值应为9的倍数
     * @param title 被创建的Inventory的标题
     * @return Inventory实例
     * @throws IllegalArgumentException 如果size不为9的倍数
     */
    Inventory createInventory(InventoryHolder owner, int size, String title) throws IllegalArgumentException;

    /**
     * Creates an empty merchant.
     *
     * @param title the title of the corresponding merchant inventory, displayed
     * when the merchant inventory is viewed
     * @return a new merchant
     */
    Merchant createMerchant(String title);

    /**
     * 获取一个区块最大可生成怪物数
     * <p>
     * 原文:Gets user-specified limit for number of monsters that can spawn in a
     * chunk.
     *
     * @return 生成限制数
     */
    int getMonsterSpawnLimit();

    /**
     * 获取一个区块最大可生成动物数
     * <p>
     * 原文:Gets user-specified limit for number of animals that can spawn in a
     * chunk.
     *
     * @return 生成限制数
     */
    int getAnimalSpawnLimit();

    /**
     * 获取一个区块最大可生成水生生物数
     * <p>
     * 原文:Gets user-specified limit for number of water animals that can spawn in
     * a chunk.
     *
     * @return 生成限制数
     */
    int getWaterAnimalSpawnLimit();

    /**
     * 获取一个区块最大生成环境怪物数(疑惑)
     * Gets user-specified limit for number of ambient mobs that can spawn in
     * a chunk.
     *
     * @return 生成限制数
     */
    int getAmbientSpawnLimit();

    /**
     * 检查当前方法是否在主线程执行
     * <p>
     * 原文:Checks the current thread against the expected primary thread for the
     * server.
     * <p>
     * <b>注意:</b> 该方法不应该用于检查当前同步状态,当前线程为主线程表明它确实为同步,但是不能排除其他原因.
     *
     * @return 为主线程返回true否则返回false
     */
    boolean isPrimaryThread();

    /**
     * 获得服务器列表中服务器所显示的消息(服务器MOTD).
     * <p>
     * 原文:Gets the message that is displayed on the server list.
     *
     * @return 服务器MOTD
     */
    String getMotd();

    /**
     * 获取服务器关闭时给玩家发送的默认消息
     * <p>
     * 原文:Gets the default message that is displayed when the server is stopped.
     *
     * @return 关服消息
     */
    String getShutdownMessage();

    /**
     * 获取当前警告状态
     * <p>
     * 原文:Gets the current warning state for the server.
     *
     * @return 被配置的警告状态
     */
    public WarningState getWarningState();

    /**
     * 获取ItemFactory的实例(用于 {@link ItemMeta})
     * <p>
     * 原文:Gets the instance of the item factory (for {@link ItemMeta}).
     *
     * @return ItenFactory实例
     * @see ItemFactory
     */
    ItemFactory getItemFactory();

    /**
     * 获取ScoreboardManager实例
     * <p>
     * 原文:Gets the instance of the scoreboard manager.
     * <p>
     * 该实例在至少有一个世界被加载后才会创建
     * <p>
     * 原文:This will only exist after the first world has loaded.
     *
     * @return 有任何世界被加载则返回ScoreboardManager实例,否则返回null.
     */
    ScoreboardManager getScoreboardManager();

    /**
     * 获取服务器默认图标
     * <p>
     * 原文:Gets an instance of the server's default server-icon.
     *
     * @return 服务器默认图标,当未定义服务器图标时将返回null(该行为无法担保)
     */
    CachedServerIcon getServerIcon();

    /**
     * 从文件中缓存图片为CachedServerIcon
     * <p>
     * 原文:Loads an image from a file, and returns a cached image for the specific
     * server-icon.
     * <p>
     * 大小和类型必须在允许范围内,否则将会抛出{@link Exception}.
     * <p>
     * 原文:Size and type are implementation defined. An incompatible file is
     * guaranteed to throw an implementation-defined {@link Exception}.
     *
     * @param file 需要被加载的文件
     * @throws IllegalArgumentException 如果图片为null
     * @throws Exception 如果图片规格不适用作为服务器图标
     * @return 一个已缓存的CachedServerIcon实例,可用于 {@link
     *     ServerListPingEvent#setServerIcon(CachedServerIcon)}
     */
    CachedServerIcon loadServerIcon(File file) throws IllegalArgumentException, Exception;

    /**
     * 从image中缓存为CachedServerIcon
     * <p>
     * 原文:Creates a cached server-icon for the specific image.
     * <p>
     * 大小和类型必须在允许范围内,否则将会抛出{@link Exception}.
     * <p>
     * 原文:Size and type are implementation defined. An incompatible file is
     * guaranteed to throw an implementation-defined {@link Exception}.
     *
     * @param image 用于缓存的图片
     * @throws IllegalArgumentException 如果图片为null
     * @throws Exception 如果图片规格不适用作为服务器图标
     * @return 一个已缓存的CachedServerIcon实例,可用于 {@link
     *     ServerListPingEvent#setServerIcon(CachedServerIcon)}
     */
    CachedServerIcon loadServerIcon(BufferedImage image) throws IllegalArgumentException, Exception;

    /**
     * 设置自动踢出闲置玩家的时间.
     * <p>
     * 原文:Set the idle kick timeout. Any players idle for the specified amount of
     * time will be automatically kicked.
     * <p>
     * 值为0时将不会踢出玩家
     *
     * @param threshold 闲置超时的分钟数
     */
    public void setIdleTimeout(int threshold);

    /**
     * 获取自动踢出闲置玩家的时间.
     * <p>
     * 原文:Gets the idle kick timeout.
     *
     * @return the 闲置超时的分钟数
     */
    public int getIdleTimeout();

    /**
     * 创建一个 ChunkData 实例，以用于区块生成。
     * <p>
     * 原文:
     * Create a ChunkData for use in a generator.
     * 
     * See {@link ChunkGenerator#generateChunkData(org.bukkit.World, java.util.Random, int, int, org.bukkit.generator.ChunkGenerator.BiomeGrid)}
     * 
     * @param world ChunkData对应的世界
     * @return 这个世界的新ChunkData实例
     * 
     */
    public ChunkGenerator.ChunkData createChunkData(World world);

    /**
     * 创建一个Boos血量条实例。血量条的进度默认为1.0。
     * <p>
     * 原文:
     * Creates a boss bar instance to display to players. The progress
     * defaults to 1.0
     *
     * @param title 血量条的标题
     * @param color 血量条的颜色
     * @param style 血量条的样式
     * @param flags 创建的Boss血量条实例
     * @return 创建的Boss血量条实例
     */
    BossBar createBossBar(String title, BarColor color, BarStyle style, BarFlag... flags);

    /**
     * Creates a boss bar instance to display to players. The progress defaults
     * to 1.0.
     * <br>
     * This instance is added to the persistent storage of the server and will
     * be editable by commands and restored after restart.
     *
     * @param key the key of the boss bar that is used to access the boss bar
     * @param title the title of the boss bar
     * @param color the color of the boss bar
     * @param style the style of the boss bar
     * @param flags an optional list of flags to set on the boss bar
     * @return the created boss bar
     */
    KeyedBossBar createBossBar(NamespacedKey key, String title, BarColor color, BarStyle style, BarFlag... flags);

    /**
     * Gets an unmodifiable iterator through all persistent bossbars.
     * <ul>
     *   <li><b>not</b> bound to a {@link org.bukkit.entity.Boss}</li>
     *   <li>
     *     <b>not</b> created using
     *     {@link #createBossBar(String, BarColor, BarStyle, BarFlag...)}
     *   </li>
     * </ul>
     *
     * e.g. bossbars created using the bossbar command
     *
     * @return a bossbar iterator
     */
    Iterator<KeyedBossBar> getBossBars();

    /**
     * Gets the {@link KeyedBossBar} specified by this key.
     * <ul>
     *   <li><b>not</b> bound to a {@link org.bukkit.entity.Boss}</li>
     *   <li>
     *     <b>not</b> created using
     *     {@link #createBossBar(String, BarColor, BarStyle, BarFlag...)}
     *   </li>
     * </ul>
     *
     * e.g. bossbars created using the bossbar command
     *
     * @param key unique bossbar key
     * @return bossbar or null if not exists
     */
    KeyedBossBar getBossBar(NamespacedKey key);

    /**
     * Removes a {@link KeyedBossBar} specified by this key.
     * <ul>
     *   <li><b>not</b> bound to a {@link org.bukkit.entity.Boss}</li>
     *   <li>
     *     <b>not</b> created using
     *     {@link #createBossBar(String, BarColor, BarStyle, BarFlag...)}
     *   </li>
     * </ul>
     *
     * e.g. bossbars created using the bossbar command
     *
     * @param key unique bossbar key
     * @return true if removal succeeded or false
     */
    boolean removeBossBar(NamespacedKey key);

    /**
	 * 用UUID获取实体.
	 * <p>
     * 原文:Gets an entity on the server by its UUID
     *
     * @param uuid 实体的UUID
     * @return 该UUID代表的实体，如果找不到为null
     */
    Entity getEntity(UUID uuid);

    /**
     * Get the advancement specified by this key.
     *
     * @param key unique advancement key
     * @return advancement or null if not exists
     */
    Advancement getAdvancement(NamespacedKey key);

    /**
     * Get an iterator through all advancements. Advancements cannot be removed
     * from this iterator,
     *
     * @return an advancement iterator
     */
    Iterator<Advancement> advancementIterator();

    /**
     * Creates a new {@link BlockData} instance for the specified Material, with
     * all properties initialized to unspecified defaults.
     *
     * @param material the material
     * @return new data instance
     */
    BlockData createBlockData(Material material);

    /**
     * Creates a new {@link BlockData} instance for the specified Material, with
     * all properties initialized to unspecified defaults.
     *
     * @param material the material
     * @param consumer consumer to run on new instance before returning
     * @return new data instance
     */
    public BlockData createBlockData(Material material, Consumer<BlockData> consumer);

    /**
     * Creates a new {@link BlockData} instance with material and properties
     * parsed from provided data.
     *
     * @param data data string
     * @return new data instance
     * @throws IllegalArgumentException if the specified data is not valid
     */
    BlockData createBlockData(String data) throws IllegalArgumentException;

    /**
     * Creates a new {@link BlockData} instance for the specified Material, with
     * all properties initialized to unspecified defaults, except for those
     * provided in data.
     * <br>
     * If <code>material</code> is specified, then the data string must not also
     * contain the material.
     *
     * @param material the material
     * @param data data string
     * @return new data instance
     * @throws IllegalArgumentException if the specified data is not valid
     */
    BlockData createBlockData(Material material, String data) throws IllegalArgumentException;

    /**
     * Gets a tag which has already been defined within the server. Plugins are
     * suggested to use the concrete tags in {@link Tag} rather than this method
     * which makes no guarantees about which tags are available, and may also be
     * less performant due to lack of caching.
     * <br>
     * Tags will be searched for in an implementation specific manner, but a
     * path consisting of namespace/tags/registry/key is expected.
     * <br>
     * Server implementations are allowed to handle only the registries
     * indicated in {@link Tag}.
     *
     * @param <T> type of the tag
     * @param registry the tag registry to look at
     * @param tag the name of the tag
     * @param clazz the class of the tag entries
     * @return the tag or null
     */
    <T extends Keyed> Tag<T> getTag(String registry, NamespacedKey tag, Class<T> clazz);

    /**
     * Gets the specified {@link LootTable}.
     *
     * @param key the name of the LootTable
     * @return the LootTable, or null if no LootTable is found with that name
     */
    LootTable getLootTable(NamespacedKey key);

    /**
     * @see UnsafeValues
     * @return UnsafeValues实例
     */
    @Deprecated
    UnsafeValues getUnsafe();
}
