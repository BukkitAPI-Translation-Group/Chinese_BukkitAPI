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
import java.util.logging.Logger;

import org.bukkit.Warning.WarningState;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
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
import org.bukkit.inventory.Recipe;
import org.bukkit.map.MapView;
import org.bukkit.permissions.Permissible;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.plugin.messaging.PluginMessageRecipient;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;

import com.avaje.ebean.config.ServerConfig;
import com.google.common.collect.ImmutableList;
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
     * 以数组形式获得当前所有在线的玩家
     * <p>
     * 原文:
     * Gets an array copy of all currently logged in players.
     * <p>
     * This method exists for legacy reasons to provide backwards
     * compatibility. It will not exist at runtime and should not be used
     * under any circumstances.
     *
     * @deprecated 被 {@link #getOnlinePlayers()}取代
     * @return 一个当前所有在线玩家的数组
     */
    @Deprecated
    public Player[] _INVALID_getOnlinePlayers();

    /**
     * 获得一个当前所有已登录玩家的集合
     * Gets a view of all currently logged in players. This {@linkplain
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
     * @return a view of currently online players.
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
     * 向服务器所有玩家发送一个消息
     * <p>
     * 原文:Broadcast a message to all players.
     * <p>
     * 这相当于调用 {@link #broadcast(java.lang.String,
     * java.lang.String)} 至 {@link #BROADCAST_CHANNEL_USERS}
     *
     * @param message 需要发送的消息
     * @return 收到消息的玩家数量
     */
    public int broadcastMessage(String message);

    /**
     * 获得更新文件夹的路径,这个文件夹里的文件将在插件加载时选择一个正确的时间更新插件(注意:该文件夹路径相对于插件的文件夹)
     * <p>
     * 原文:Gets the name of the update folder. The update folder is used to safely
     * update plugins at the right moment on a plugin load.
     *
     * @return 更新文件夹的路径
     */
    public String getUpdateFolder();

    /**
     * 获得更新文件夹的File实例,这个文件夹里的文件将在插件加载时选择一个正确的时间更新插件
     * <p>
     * 原文:Gets the update folder. The update folder is used to safely update
     * plugins at the right moment on a plugin load.
     *
     * @return 更新文件夹的File实例
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
     * 重新加载服务器并刷新设置和插件信息.
     * <p>
     * 原文:Reloads the server, refreshing settings and plugin information.
     */
    public void reload();

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
     * 通过{@link ServerConfig}给服务器填充给定的属性
     * <p>
     * 原文:Populates a given {@link ServerConfig} with values attributes to this
     * server.
     *
     * @param config 填充给服务器的属性
     */
    public void configureDbConfig(ServerConfig config);

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
     * 获得服务器是否开启了生存模式.
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
     * Gets whether to use vanilla (false) or exact behaviour (true).
     *
     * <ul>
     * <li>Vanilla behaviour: check for collisions and move the player if
     *     needed.
     * <li>Exact behaviour: spawn players exactly where they should be.
     * </ul>
     *
     * @return true if exact location locations are used for spawning, false
     *     for vanilla collision detection or otherwise
     *
     * @deprecated non standard and unused feature.
     */
    @Deprecated
    public boolean useExactLoginLocation();

    /**
     * 彻底关闭服务器.
     * <p>
     * 原文:Shutdowns the server, stopping everything.
     */
    public void shutdown();

    /**
     * 向具有给定权限的玩家发送一条信息
     * <p>
     * 原文:Broadcasts the specified message to every user with the given
     * permission name.
     *
     * @param message 需要公告的信息
     * @param permission 需要的权限{@link Permissible permissibles}
     * @return 收到公告的玩家数量
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
     * Creates an empty inventory of the specified type. If the type is {@link
     * InventoryType#CHEST}, the new inventory has a size of 27; otherwise the
     * new inventory has the normal size for its type.
     *
     * @param owner the holder of the inventory, or null to indicate no holder
     * @param type the type of inventory to create
     * @return a new inventory
     */
    Inventory createInventory(InventoryHolder owner, InventoryType type);

    /**
     * Creates an empty inventory with the specified type and title. If the type
     * is {@link InventoryType#CHEST}, the new inventory has a size of 27;
     * otherwise the new inventory has the normal size for its type.<br>
     * It should be noted that some inventory types do not support titles and
     * may not render with said titles on the Minecraft client.
     *
     * @param owner The holder of the inventory; can be null if there's no holder.
     * @param type The type of inventory to create.
     * @param title The title of the inventory, to be displayed when it is viewed.
     * @return The new inventory.
     */
    Inventory createInventory(InventoryHolder owner, InventoryType type, String title);

    /**
     * Creates an empty inventory of type {@link InventoryType#CHEST} with the
     * specified size.
     *
     * @param owner the holder of the inventory, or null to indicate no holder
     * @param size a multiple of 9 as the size of inventory to create
     * @return a new inventory
     * @throws IllegalArgumentException if the size is not a multiple of 9
     */
    Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException;

    /**
     * Creates an empty inventory of type {@link InventoryType#CHEST} with the
     * specified size and title.
     *
     * @param owner the holder of the inventory, or null to indicate no holder
     * @param size a multiple of 9 as the size of inventory to create
     * @param title the title of the inventory, displayed when inventory is
     *     viewed
     * @return a new inventory
     * @throws IllegalArgumentException if the size is not a multiple of 9
     */
    Inventory createInventory(InventoryHolder owner, int size, String title) throws IllegalArgumentException;

    /**
     * Gets user-specified limit for number of monsters that can spawn in a
     * chunk.
     *
     * @return the monster spawn limit
     */
    int getMonsterSpawnLimit();

    /**
     * Gets user-specified limit for number of animals that can spawn in a
     * chunk.
     *
     * @return the animal spawn limit
     */
    int getAnimalSpawnLimit();

    /**
     * Gets user-specified limit for number of water animals that can spawn in
     * a chunk.
     *
     * @return the water animal spawn limit
     */
    int getWaterAnimalSpawnLimit();

    /**
     * Gets user-specified limit for number of ambient mobs that can spawn in
     * a chunk.
     *
     * @return the ambient spawn limit
     */
    int getAmbientSpawnLimit();

    /**
     * Checks the current thread against the expected primary thread for the
     * server.
     * <p>
     * <b>Note:</b> this method should not be used to indicate the current
     * synchronized state of the runtime. A current thread matching the main
     * thread indicates that it is synchronized, but a mismatch <b>does not
     * preclude</b> the same assumption.
     *
     * @return true if the current thread matches the expected primary thread,
     *     false otherwise
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
     * Gets the default message that is displayed when the server is stopped.
     *
     * @return the shutdown message
     */
    String getShutdownMessage();

    /**
     * Gets the current warning state for the server.
     *
     * @return the configured warning state
     */
    public WarningState getWarningState();

    /**
     * Gets the instance of the item factory (for {@link ItemMeta}).
     *
     * @return the item factory
     * @see ItemFactory
     */
    ItemFactory getItemFactory();

    /**
     * Gets the instance of the scoreboard manager.
     * <p>
     * This will only exist after the first world has loaded.
     *
     * @return the scoreboard manager or null if no worlds are loaded.
     */
    ScoreboardManager getScoreboardManager();

    /**
     * Gets an instance of the server's default server-icon.
     *
     * @return the default server-icon; null values may be used by the
     *     implementation to indicate no defined icon, but this behavior is
     *     not guaranteed
     */
    CachedServerIcon getServerIcon();

    /**
     * Loads an image from a file, and returns a cached image for the specific
     * server-icon.
     * <p>
     * Size and type are implementation defined. An incompatible file is
     * guaranteed to throw an implementation-defined {@link Exception}.
     *
     * @param file the file to load the from
     * @throws IllegalArgumentException if image is null
     * @throws Exception if the image does not meet current server server-icon
     *     specifications
     * @return a cached server-icon that can be used for a {@link
     *     ServerListPingEvent#setServerIcon(CachedServerIcon)}
     */
    CachedServerIcon loadServerIcon(File file) throws IllegalArgumentException, Exception;

    /**
     * Creates a cached server-icon for the specific image.
     * <p>
     * Size and type are implementation defined. An incompatible file is
     * guaranteed to throw an implementation-defined {@link Exception}.
     *
     * @param image the image to use
     * @throws IllegalArgumentException if image is null
     * @throws Exception if the image does not meet current server
     *     server-icon specifications
     * @return a cached server-icon that can be used for a {@link
     *     ServerListPingEvent#setServerIcon(CachedServerIcon)}
     */
    CachedServerIcon loadServerIcon(BufferedImage image) throws IllegalArgumentException, Exception;

    /**
     * Set the idle kick timeout. Any players idle for the specified amount of
     * time will be automatically kicked.
     * <p>
     * A value of 0 will disable the idle kick timeout.
     *
     * @param threshold the idle timeout in minutes
     */
    public void setIdleTimeout(int threshold);

    /**
     * Gets the idle kick timeout.
     *
     * @return the idle timeout in minutes
     */
    public int getIdleTimeout();

    /**
     * Create a ChunkData for use in a generator.
     * 
     * See {@link ChunkGenerator#generateChunkData(org.bukkit.World, java.util.Random, int, int, org.bukkit.generator.ChunkGenerator.BiomeGrid)}
     * 
     * @param world the world to create the ChunkData for
     * @return a new ChunkData for the world
     * 
     */
    public ChunkGenerator.ChunkData createChunkData(World world);

    /**
     * Creates a boss bar instance to display to players. The progress
     * defaults to 1.0
     *
     * @param title the title of the boss bar
     * @param color the color of the boss bar
     * @param style the style of the boss bar
     * @param flags an optional list of flags to set on the boss bar
     * @return the created boss bar
     */
    BossBar createBossBar(String title, BarColor color, BarStyle style, BarFlag ...flags);

    /**
     * @see UnsafeValues
     * @return the unsafe values instance
     */
    @Deprecated
    UnsafeValues getUnsafe();
}
