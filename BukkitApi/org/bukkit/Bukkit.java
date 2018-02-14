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
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;

import com.google.common.collect.ImmutableList;
import org.bukkit.advancement.Advancement;
import org.bukkit.generator.ChunkGenerator;

import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * 代表一个 Bukkit 核心, 用来转发 {@link Server} 单例的调用.  
 */
public final class Bukkit {
    private static Server server;

    /**
     * 工具类不能被初始化
     */
    private Bukkit() {}

    /**
     * 获取当前持有的 {@link Server} 实例. 
     * <p>
     * 原文:
     * Gets the current {@link Server} singleton
     *
     * @return 正在运行的服务器的实例
     */
    public static Server getServer() {
        return server;
    }

    /**
     * 请求设置所持有的 {@link Server} 实例.
     * 如果 Server 已经被设定过了, 这个操作无法完成. 
     * <p>
     * 原文:
     * Attempts to set the {@link Server} singleton.
     * This cannot be done if the Server is already set.
     *
     * @param server 服务器实例
     */
    public static void setServer(Server server) {
        if (Bukkit.server != null) {
            throw new UnsupportedOperationException("Cannot redefine singleton Server");
        }

        Bukkit.server = server;
        server.getLogger().info("This server is running " + getName() + " version " + getVersion() + " (Implementing API version " + getBukkitVersion() + ")");
    }

    /**
     * 获取这个 {@link Server} 实例的名字. 
     * <p>
     * 原文:
     * Gets the name of this server implementation.
     *
     * @return 这个服务器实例的名字
     */
    public static String getName() {
        return server.getName();
    }

    /**
     * 获取这个 {@link Server} 实例的版本. 
     * <p>
     * 原文:
     * Gets the version string of this server implementation.
     *
     * @return 这个服务器实例的版本
     */
    public static String getVersion() {
        return server.getVersion();
    }

    /**
     * 获取正在运行的服务器的Bukkit版本. 
     * <p>
     * 原文:
     * Gets the Bukkit version that this server is running.
     *
     * @return Bukkit版本
     */
    public static String getBukkitVersion() {
        return server.getBukkitVersion();
    }

    /**
     * 获取所有在线玩家的集合的视图. 
     * <p>
     * 此 {@linkplain Collections#unmodifiableCollection(Collection) 视图} is a reused
     * object, making some operations like {@link Collection#size()}
     * zero-allocation.
     * (以下翻译仅供参考)
     * <p>
     * 此集合是由内部表示支持的视图, 因此, 一切修改服务器内部状态的操作将会
     * 立即反映到此集合上. 并不严格保证未来或所有实现都会遵守
     * 返回一个可再利用集合 (一致性)的约定. 不赞成对这个集合执行强制转换或
     * 依赖于接口实现 (例如 {@link Serializable} or {@link List}). 
     * <p>
     * 迭代操作 is undefined outside of self-contained main-thread
     * uses. 正常且立即的迭代器会影响集合是否被完全支持. 
     * {@link Entity#teleport(Location) 传送}, 
     * {@link Player#setHealth(double) 死亡}, 
     * {@link Player#kickPlayer(String) 踢出} 等操作的结果是未知的 (没有罗列完全). 
     * 任何对这个集合的异步操作都是安全的. 
     * <p>
     * For safe consequential iteration or mimicking the old array behavior,
     * using {@link Collection#toArray(Object[])} is recommended. For making
     * snapshots, {@link ImmutableList#copyOf(Collection)} is recommended.
     * <p>
     * 原文: 
     * This {@linkplain
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
     * @return 所有在线玩家的视图
     */
    public static Collection<? extends Player> getOnlinePlayers() {
        return server.getOnlinePlayers();
    }

    /**
     * 获取服务器允许进入的最大玩家数. 
     * <p>
     * 原文:
     * Get the maximum amount of players which can login to this server.
     *
     * @return 服务器的最大玩家数
     */
    public static int getMaxPlayers() {
        return server.getMaxPlayers();
    }

    /**
     * 获取运行的服务器所在的端口号. 
     * <p>
     * 原文:Get the game port that the server runs on.
     *
     * @return 服务器的端口
     */
    public static int getPort() {
        return server.getPort();
    }

    /**
     * 获取服务器的视距. 
     * <p>
     * 原文:
     * Get the view distance from this server.
     *
     * @return 服务器的视距
     */
    public static int getViewDistance() {
        return server.getViewDistance();
    }

    /**
     * 获取服务器绑定的IP, 如果没有就返回空字符串. 
     * <p>
     * 原文:
     * Get the IP that this server is bound to, or empty string if not
     * specified.
     *
     * @return 服务器绑定的IP，如果没有就返回空
     *     字符串
     */
    public static String getIp() {
        return server.getIp();
    }

    /**
     * 获取服务器的名称. 
     * <p>
     * 原文:
     * Get the name of this server.
     *
     * @return 服务器名
     */
    public static String getServerName() {
        return server.getServerName();
    }

    /**
     * 获取服务器的ID. 这是一个简单的字母标识, 
     * 可以用来唯一地识别此服务器.
     * <p>
     * 原文:
     * Get an ID of this server. The ID is a simple generally alphanumeric ID
     * that can be used for uniquely identifying this server.
     *
     * @return 服务器的唯一标识
     */
    public static String getServerId() {
        return server.getServerId();
    }
    
    /**
     * 获取默认世界的世界类型 (level-type 设置). 
     * <p>
     * 原文:
     * Get world type (level-type setting) for default world.
     *
     * @return 默认世界的世界类型 (例： DEFAULT, FLAT, DEFAULT_1_1)
     */
    public static String getWorldType() {
        return server.getWorldType();
    }

    /**
     * 获取此服务器是否自然生成结构. 
     * <p>
     * 原文:
     * Get generate-structures setting.
     *
     * @return 是否生成结构
     */
    public static boolean getGenerateStructures() {
        return server.getGenerateStructures();
    }

    /**
     * 获取此服务器是否开启了末路之地. 
     * <p>
     * 原文:
     * Gets whether this server allows the End or not.
     *
     * @return 是否可以进入末路之地
     */
    public static boolean getAllowEnd() {
        return server.getAllowEnd();
    }

    /**
     * 获取此服务器是否开启了下界. 
     * <p>
     * 原文：
     * Gets whether this server allows the Nether or not.
     *
     * @return 是否可以进入下界
     */
    public static boolean getAllowNether() {
        return server.getAllowNether();
    }

    /**
     * 获取此服务器是否开启了白名单. 
     * <p>
     * 原文:
     * Gets whether this server has a whitelist or not.
     *
     * @return 是否开启白名单
     */
    public static boolean hasWhitelist() {
        return server.hasWhitelist();
    }

    /**
     * 设置此服务器是否开启白名单. 
     * <p>
     * 原文:
     * Sets if the server is whitelisted.
     *
     * @param value true为开, false为关
     */
    public static void setWhitelist(boolean value) {
        server.setWhitelist(value);
    }

    /**
     * 获取所有已被添加到白名单的玩家. 
     * <p>
     * 原文:
     * Gets a list of whitelisted players.
     *
     * @return 用Set存储的所有被添加到白名单的玩家
     */
    public static Set<OfflinePlayer> getWhitelistedPlayers() {
        return server.getWhitelistedPlayers();
    }

    /**
     * 从硬盘重载白名单列表. 
     * <p>
     * 原文:Reloads the whitelist from disk.
     */
    public static void reloadWhitelist() {
        server.reloadWhitelist();
    }

    /**
     * 广播一条消息到所有在线玩家. 
     * <p>
     * 这与调用 {@link #broadcast(java.lang.String,
     * java.lang.String)} 并将第二个参数设为 {@link 
     * Server#BROADCAST_CHANNEL_USERS} 等效. 
     *
     * 原文: 
     * Broadcast a message to all players.
     * <p>
     * This is the same as calling {@link #broadcast(java.lang.String,
     * java.lang.String)} to {@link Server#BROADCAST_CHANNEL_USERS}
     *
     * @param message 要广播的消息
     * @return 成功接收此消息的玩家数
     */
    public static int broadcastMessage(String message) {
        return server.broadcastMessage(message);
    }

    /**
     * 获取更新文件夹的名字. 
     * <p>
     * 系统将会在插件加载时选择适当的时机利用此文件夹来安全地更新插件.
     * <p>
     * 更新文件夹的位置相对于插件文件夹.
     * <p>
     * 
     * 原文:
     * Gets the name of the update folder. The update folder is used to safely
     * update plugins at the right moment on a plugin load.
     * <p>
     * The update folder name is relative to the plugins folder.
     *
     * @return 更新文件夹的名字
     */
    public static String getUpdateFolder() {
        return server.getUpdateFolder();
    }

    /**
     * 获取更新文件夹的 {@link File} 实例. 
     * <p>
     * 系统将会在插件加载时选择适当的时机利用此文件夹来安全地更新插件.
     * <p>
     * 原文:
     * Gets the update folder. The update folder is used to safely update
     * plugins at the right moment on a plugin load.
     *
     * @return 表示更新文件夹的 File 实例
     */
    public static File getUpdateFolderFile() {
        return server.getUpdateFolderFile();
    }

    /**
     * 获取服务器的最小连接间隔设定. 
     * <p>
     * 译注: 单位为毫秒. 
     * <p>
     * 
     * 原文: Gets the value of the connection throttle setting.
     * @return 服务器的最小连接间隔数设定
     */
    public static long getConnectionThrottle() {
        return server.getConnectionThrottle();
    }

    /**
     * 获取每隔多少tick应该生成一次动物. 
     * <b>例如:</b>
     * <ul>
     * <li>此值为 1 表示服务器会在每个tick尝试生成动物. 
     * <li>此值为 400 表示服务器会每隔400tick尝试生成动物. 
     * <li>此值小于 0 表示会使用Minecraft的默认设置. 
     * </ul>
     * <b>注意:</b> 如果设为 0, 动物生成会被禁用. 
     * 我们推荐使用 spawn-animals 选项来代替将其设为0.
     * <p>
     * Minecraft使用的默认值: 400.
     * <p>
     * 原文: <hr>
     * Gets default ticks per animal spawns value.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn monsters
     *     every tick.
     * <li>A value of 400 will mean the server will attempt to spawn monsters
     *     every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b> If set to 0, animal spawning will be disabled. 
     * We recommend using spawn-animals to control this instead.
     * <p>
     * Minecraft default: 400.
     *
     * @return 每个动物生成的默认刻
     */
    public static int getTicksPerAnimalSpawns() {
        return server.getTicksPerAnimalSpawns();
    }

    /**
     * 获取每隔多少tick应该生成一次怪物. 
     * <b>例如:</b>
     * <ul>
     * <li>此值为 1 表示服务器会在每个tick尝试生成怪物. 
     * <li>此值为 400 表示服务器会每隔400tick尝试生成怪物. 
     * <li>此值小于 0 表示会使用Minecraft的默认设置. 
     * </ul>
     * <b>注意:</b> 如果设为 0, 怪物生成会被禁用. 
     * 我们推荐使用 spawn-monsters 选项来代替将其设为0.
     * <p>
     * Minecraft使用的默认值: 1.
     * <p>
     * 原文: 
     * Gets default ticks per monster spawns value.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn monsters
     *     every tick.
     * <li>A value of 400 will mean the server will attempt to spawn monsters
     *     every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b> If set to 0, monster spawning will be disabled. 
     * We recommend using spawn-monsters to control this instead.
     * <p>
     * Minecraft default: 1.
     *
     * @return 每个动物生成的默认刻
     */
    public static int getTicksPerMonsterSpawns() {
        return server.getTicksPerMonsterSpawns();
    }

    /**
     * 使用给定玩家名模糊搜索玩家. 
     * 这个方法不可能返回离线玩家的对象. 
     * <p>
     * 译注: 注意此方法用于模糊搜索——当服务器内有玩家 aaa, aab, abc 时, 
     * 使用 <code>getPlayer("ab")</code> 会返回玩家 abc 的实例, 而如果 ab 在线则会返回 ab 的实例
     * 因此<b>可能存在严重的安全问题</b>, 需要精确搜索(例如给予OP时)请用
     * {@link #getPlayerExact(java.lang.String) } 或 {@link 
     * #getPlayer(java.util.UUID) } 代替. 
     * <p>
     * 原文: 
     * Gets a player object by the given username.
     * This method may not return objects for offline players.
     *
     * @deprecated 被 {@link #getPlayer(UUID)} 取代, 因为玩家名不再一定是唯一的. 
     * @param name 用来查找的玩家名
     * @return 如果找到了则返回玩家对象, 否则返回null
     */
    @Deprecated
    public static Player getPlayer(String name) {
        return server.getPlayer(name);
    }

    /**
     * 使用给定玩家名精确查找玩家, 不区分大小写. 
     * <p>
     * 原文: Gets the player with the exact given name, case insensitive. 
     *
     * @deprecated 被 {@link #getPlayer(UUID)} 取代, 因为玩家名不再一定是唯一的. 
     * @param name 用于检索的精确玩家名称, 不区分大小写 
     * @return 如果找到了则返回玩家对象, 否则返回null
     */
    @Deprecated
    public static Player getPlayerExact(String name) {
        return server.getPlayerExact(name);
    }

    /**
     * 尝试获取所有匹配给定名称的玩家, 并返回包含了一切可能匹配的列表. 
     * <p>
     * 这个列表没有经过任何特殊排序. 如果能在在线玩家内精确匹配到给定名称,
     * 则返回一个只包含单个结果的列表. 
     * <p>
     * 译注: 设有在线玩家 abcd, efg, dbca 那么 <code>matchPlayer("bc")</code> 会
     * 返回一个包含 [abcd, dbca] 的列表. 但如果此时玩家 bc 上线了, 再执行相同的查找
     * 就只会返回包含一个结果的列表 [bc]. 
     * <p>
     * 原文: 
     * Attempts to match any players with the given name, and returns a list
     * of all possibly matches.
     * <p>
     * This list is not sorted in any particular order. If an exact match is
     * found, the returned list will only contain a single result.
     *
     * @deprecated 被 {@link #getPlayer(UUID)} 取代, 因为玩家名不再一定是唯一的. 
     * @param name 需要匹配的(部分)名称
     * @return 包含所有可能的匹配结果的列表
     */
    @Deprecated
    public static List<Player> matchPlayer(String name) {
        return server.matchPlayer(name);
    }

    /**
     * 使用给定{@link UUID}获取玩家. 
     * <p>
     * 原文: Gets the player with the given UUID.
     *
     * @param id 要获取的玩家的{@link UUID}
     * @return 如果找到了则返回玩家对象, 否则返回null
     */
    public static Player getPlayer(UUID id) {
        return server.getPlayer(id);
    }

    /**
     * 获取插件管理器以与其他插件进行交互. 
     * <p>
     * 原文: Gets the plugin manager for interfacing with plugins.
     *
     * @return 此服务器的插件管理器
     */
    public static PluginManager getPluginManager() {
        return server.getPluginManager();
    }

    /**
     * 获取用于管理调度任务的调度器. 
     * <p>
     * 原文: Gets the scheduler for managing scheduled events.
     *
     * @return 此服务器的调度器服务
     */
    public static BukkitScheduler getScheduler() {
        return server.getScheduler();
    }

    /**
     * 获取服务管理器. 
     * <p>
     * 原文: Gets a services manager.
     *
     * @return 服务管理器. 
     */
    public static ServicesManager getServicesManager() {
        return server.getServicesManager();
    }

    /**
     * 获取当前服务器加载的所有世界的列表. 
     * <p>
     * 原文: Gets a list of all worlds on this server.
     *
     * @return 所有已经被服务器加载的世界列表
     */
    public static List<World> getWorlds() {
        return server.getWorlds();
    }

    /**
     * 用给定的世界生成器来创建或者加载一个世界. 
     * <p>
     * 如果这个世界已经被加载了, 那么就会返回等同于调用 
     * <code>getWorld(creator.name())</code> 的结果. 
     * <p>
     * 原文: Creates or loads a world with the given name using the specified
     * options.
     * <p>
     * If the world is already loaded, it will just return the equivalent of
     * getWorld(creator.name()).
     *
     * @param creator 加载或者创建这个世界的时候要用的世界生成器
     * @return 生成的或者加载的世界对象
     */
    public static World createWorld(WorldCreator creator) {
        return server.createWorld(creator);
    }

    /**
     * 卸载给定名称对应的世界. 
     * <p>
     * 原文: Unloads a world with the given name.
     *
     * @param name 要卸载的世界的名字
     * @param save 卸载时是否要保存数据
     * @return 如果成功返回true, 否则返回false
     */
    public static boolean unloadWorld(String name, boolean save) {
        return server.unloadWorld(name, save);
    }

    /**
     * 卸载指定的世界. 
     * <p>
     * 原文: Unloads a world with the given name.
     *
     * @param world 要卸载的世界
     * @param save 卸载时是否要保存数据
     * @return 如果成功返回true, 否则返回false
     */
    public static boolean unloadWorld(World world, boolean save) {
        return server.unloadWorld(world, save);
    }

    /**
     * 使用给定名称查找世界. 
     * <p>
     * 原文: Gets the world with the given name.
     *
     * @param name 世界名称
     * @return 没找到则返回null
     */
    public static World getWorld(String name) {
        return server.getWorld(name);
    }

    /**
     * 使用给定{@linkplain UUID 唯一ID}查找世界. 
     * <p>
     * 原文: Gets the world from the given Unique ID.
     *
     * @param uid 要查找的世界的唯一ID
     * @return 没找到则返回null
     */
    public static World getWorld(UUID uid) {
        return server.getWorld(uid);
    }

    /**
     * 使用给定物品ID获取地图. 
     * <p>
     * 原文: Gets the map from the given item ID. 
     *
     * @param id 要获取的地图的ID
     * @return 如果找到则返回对应的 {@link MapView}, 否则返回null
     * @deprecated 不安全的参数
     */
    @Deprecated
    public static MapView getMap(short id) {
        return server.getMap(id);
    }

    /**
     * 创建一个新地图并自动分配一个ID. 
     * <p>
     * 原文: Create a new map with an automatically assigned ID.
     *
     * @param world 地图所属的世界
     * @return 新创建的 {@link MapView}
     */
    public static MapView createMap(World world) {
        return server.createMap(world);
    }

    /**
     * 重载服务器, 刷新设置与插件信息.
     * <p>
     * 原文: Reloads the server, refreshing settings and plugin information.
     */
    public static void reload() {
        server.reload();
    }

    /**
     * 只重载Minecraft游戏数据. 这包括自定义的进度和掉落表.
     * <p>
     * 原文:Reload only the Minecraft data for the server. This includes custom
     * advancements and loot tables.
     */
    public static void reloadData() {
        server.reloadData();
    }

    /**
     * 返回与此服务器实例绑定的主{@link Logger}. 
     * <p>
     * 原文: Returns the primary logger associated with this server instance.
     *
     * @return 与此服务器绑定的 {@link Logger}
     */
    public static Logger getLogger() {
        return server.getLogger();
    }

    /**
     * 用给定命令名或别名获取 {@link PluginCommand}. 
     * <p>
     * 原文: Gets a {@link PluginCommand} with the given name or alias.
     *
     * @param name 命令名或命令别名
     * @return 找不到则返回null
     */
    public static PluginCommand getPluginCommand(String name) {
        return server.getPluginCommand(name);
    }

    /**
     * 保存已加载的玩家信息.
     * <p>
     * 原文:Writes loaded players to disk.
     */
    public static void savePlayers() {
        server.savePlayers();
    }
    
    /**
     * Dispatches a command on this server, and executes it if found.
     *
     * @param sender the apparent sender of the command
     * @param commandLine the command + arguments. Example: <code>test abc
     *     123</code>
     * @return returns false if no target is found
     * @throws CommandException thrown when the executor for the given command
     *     fails with an unhandled exception
     */
    public static boolean dispatchCommand(CommandSender sender, String commandLine) throws CommandException {
        return server.dispatchCommand(sender, commandLine);
    }

    /**
     * 向合成管理器添加一个合成配方.
     * <p>
     * 原文:Adds a recipe to the crafting manager.
     *
     * @param recipe 要添加的合成配方
     * @return 是否成功的地添加了合成配方
     */
    public static boolean addRecipe(Recipe recipe) {
        return server.addRecipe(recipe);
    }

    /**
     * Get a list of all recipes for a given item. The stack size is ignored
     * in comparisons. If the durability is -1, it will match any data value.
     *
     * @param result the item to match against recipe results
     * @return a list of recipes with the given result
     */
    public static List<Recipe> getRecipesFor(ItemStack result) {
        return server.getRecipesFor(result);
    }

    /**
     * 通过自定义合成配方列表获取迭代器.
     * <p>
     * 原文:Get an iterator through the list of crafting recipes.
     *
     * @return 迭代器
     */
    public static Iterator<Recipe> recipeIterator() {
        return server.recipeIterator();
    }

    /**
     * 清理所有已添加的合成配方.
     * <p>
     * 原文:Clears the list of crafting recipes.
     */
    public static void clearRecipes() {
        server.clearRecipes();
    }

    /**
     * 重置自定义合成配方列表值至默认.
     * <p>
     * 原文:Resets the list of crafting recipes to the default.
     */
    public static void resetRecipes() {
        server.resetRecipes();
    }
    
    /**
     * 获取服务器配置定义的命令别名列表.
     * <p>
     * 原文:Gets a list of command aliases defined in the server properties.
     *
     * @return 命令别名map
     */
    public static Map<String, String[]> getCommandAliases() {
        return server.getCommandAliases();
    }

    /**
     * 获取出生地保护的范围（以方块为单位）.
     * <p>
     * 原文:Gets the radius, in blocks, around each worlds spawn point to protect.
     *
     * @return 出生地保护范围，0为没有保护
     */
    public static int getSpawnRadius() {
        return server.getSpawnRadius();
    }

    /**
     * 设置出生地保护的范围.
     * <p>
     * 原文:Sets the radius, in blocks, around each worlds spawn point to protect.
     *
     * @param value 新的出生地保护的范围，0设为没有保护
     */
    public static void setSpawnRadius(int value) {
        server.setSpawnRadius(value);
    }

    /**
     * 获取服务器的正版准入设定.
     * <p>
     * 原文:Gets whether the Server is in online mode or not.
     *
     * @return 服务器是否处于正版模式
     */
    public static boolean getOnlineMode() {
        return server.getOnlineMode();
    }

    /**
     * 获取服务器是否允许飞行.
     * <p>
     * 原文:Gets whether this server allows flying or not.
     *
     * @return 服务器是否允许飞行
     */
    public static boolean getAllowFlight() {
        return server.getAllowFlight();
    }

    /**
     * 获取服务器是否处于极限模式.
     * <p>
     * 原文:Gets whether the server is in hardcore mode or not.
     *
     * @return 服务器是否处于极限模式
     */
    public static boolean isHardcore() {
        return server.isHardcore();
    }

    /**
     * 关闭服务器，停止一切在运行的东西.
     * <p>
     * 原文:Shutdowns the server, stopping everything.
     */
    public static void shutdown() {
        server.shutdown();
    }

    /**
     * Broadcasts the specified message to every user with the given
     * permission name.
     *
     * @param message message to broadcast
     * @param permission the required permission {@link Permissible
     *     permissibles} must have to receive the broadcast
     * @return number of message recipients
     */
    public static int broadcast(String message, String permission) {
        return server.broadcast(message, permission);
    }

    /**
     * Gets the player by the given name, regardless if they are offline or
     * online.
     * <p>
     * This method may involve a blocking web request to get the UUID for the
     * given name.
     * <p>
     * This will return an object even if the player does not exist. To this
     * method, all players will exist.
     *
     * @deprecated Persistent storage of users should be by UUID as names are no longer
     *             unique past a single session.
     * @param name the name the player to retrieve
     * @return an offline player
     * @see #getOfflinePlayer(java.util.UUID)
     */
    @Deprecated
    public static OfflinePlayer getOfflinePlayer(String name) {
        return server.getOfflinePlayer(name);
    }

    /**
     * 以指定的UUID获取玩家，无论他们使用正版模式还是离线模式.
     * <p>
     * 本方法都将返回一个对象，甚至此玩家并不存在.对于此方法来说，任何玩家都存在.
     * <p>
     * 原文:Gets the player by the given UUID, regardless if they are offline or
     * online.
     * <p>
     * This will return an object even if the player does not exist. To this
     * method, all players will exist.
     *
     * @param id 要检索的玩家UUID
     * @return 表示此玩家的OfflinePlayer对象
     */
    public static OfflinePlayer getOfflinePlayer(UUID id) {
        return server.getOfflinePlayer(id);
    }

    /**
     * 获取已被封禁的IP地址.
     * <p>
     * 原文:Gets a set containing all current IPs that are banned.
     *
     * @return 被封禁IP集合
     */
    public static Set<String> getIPBans() {
        return server.getIPBans();
    }

    /**
     * 封禁指定的IP地址.
     * <p>
     * 原文:Bans the specified address from the server.
     *
     * @param address 要封禁的IP地址
     */
    public static void banIP(String address) {
        server.banIP(address);
    }

    /**
     * 解禁指定的IP地址.
     * <p>
     * 原文:Unbans the specified address from the server.
     *
     * @param address 要解禁的IP地址
     */
    public static void unbanIP(String address) {
        server.unbanIP(address);
    }

    /**
     * 获取已被封禁的玩家.
     * <p>
     * 原文:Gets a set containing all banned players.
     *
     * @return 已被封禁的玩家
     */
    public static Set<OfflinePlayer> getBannedPlayers() {
        return server.getBannedPlayers();
    }

    /**
     * 获取指定类型的封禁列表.
     * <p>
     * 以玩家名封禁已不再支持，尝试请求获取将返回null（Is it true? 经测试并没有返回null）.替代方法是封禁UUID.
     * <p>
     * 原文:Gets a ban list for the supplied type.
     * <p>
     * Bans by name are no longer supported and this method will return
     * null when trying to request them. The replacement is bans by UUID.
     *
     * @param type 要获取的封禁列表的类型，不能为null
     * @return 指定类型的封禁列表
     */
    public static BanList getBanList(BanList.Type type){
        return server.getBanList(type);
    }

    /**
     * 获取服务器的所有OP(管理员).
     * <p>
     * 原文:Gets a set containing all player operators.
     *
     * @return 服务器OP
     */
    public static Set<OfflinePlayer> getOperators() {
        return server.getOperators();
    }

    /**
     * 获取服务器的的默认{@link GameMode 游戏模式}.
     * <p>
     * 原文:Gets the default {@link GameMode} for new players.
     *
     * @return 默认游戏模式
     */
    public static GameMode getDefaultGameMode() {
        return server.getDefaultGameMode();
    }

    /**
     * 设置服务器的默认游戏模式.
     * <p>
     * 原文:Sets the default {@link GameMode} for new players.
     *
     * @param mode 新的默认游戏模式
     */
    public static void setDefaultGameMode(GameMode mode) {
        server.setDefaultGameMode(mode);
    }

    /**
     * Gets a {@link ConsoleCommandSender} that may be used as an input source
     * for this server.
     *
     * @return a console command sender
     */
    public static ConsoleCommandSender getConsoleSender() {
        return server.getConsoleSender();
    }

    /**
     * Gets the folder that contains all of the various {@link World}s.
     *
     * @return folder that contains all worlds
     */
    public static File getWorldContainer() {
        return server.getWorldContainer();
    }

    /**
     * 获取曾在此服务器游戏的玩家.
     * <p>
     * 原文:Gets every player that has ever played on this server.
     *
     * @return 曾在此服务器游戏的玩家
     */
    public static OfflinePlayer[] getOfflinePlayers() {
        return server.getOfflinePlayers();
    }

    /**
     * Gets the {@link Messenger} responsible for this server.
     *
     * @return messenger responsible for this server
     */
    public static Messenger getMessenger() {
        return server.getMessenger();
    }

    /**
     * Gets the {@link HelpMap} providing help topics for this server.
     *
     * @return a help map for this server
     */
    public static HelpMap getHelpMap() {
        return server.getHelpMap();
    }

    /**
     * Creates an empty inventory of the specified type. If the type is {@link
     * InventoryType#CHEST}, the new inventory has a size of 27; otherwise the
     * new inventory has the normal size for its type.
     *
     * @param owner the holder of the inventory, or null to indicate no holder
     * @param type the type of inventory to create
     * @return a new inventory
     */
    public static Inventory createInventory(InventoryHolder owner, InventoryType type) {
        return server.createInventory(owner, type);
    }

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
    public static Inventory createInventory(InventoryHolder owner, InventoryType type, String title) {
        return server.createInventory(owner, type, title);
    }

    /**
     * Creates an empty inventory of type {@link InventoryType#CHEST} with the
     * specified size.
     *
     * @param owner the holder of the inventory, or null to indicate no holder
     * @param size a multiple of 9 as the size of inventory to create
     * @return a new inventory
     * @throws IllegalArgumentException if the size is not a multiple of 9
     */
    public static Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException {
        return server.createInventory(owner, size);
    }

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
    public static Inventory createInventory(InventoryHolder owner, int size, String title) throws IllegalArgumentException {
        return server.createInventory(owner, size, title);
    }

    /**
     * Creates an empty merchant.
     *
     * @param title the title of the corresponding merchant inventory, displayed
     * when the merchant inventory is viewed
     * @return a new merchant
     */
    public static Merchant createMerchant(String title) {
        return server.createMerchant(title);
    }

    /**
     * Gets user-specified limit for number of monsters that can spawn in a
     * chunk.
     *
     * @return the monster spawn limit
     */
    public static int getMonsterSpawnLimit() {
        return server.getMonsterSpawnLimit();
    }

    /**
     * 获取用户指定的可以在一个区块内生成的动物的数量的限制.
     * <p>
     * 原文:
     * Gets user-specified limit for number of animals that can spawn in a
     * chunk.
     *
     * @return 同一区块内的动物数量限制
     */
    public static int getAnimalSpawnLimit() {
        return server.getAnimalSpawnLimit();
    }

    /**
     * Gets user-specified limit for number of water animals that can spawn in
     * a chunk.
     *
     * @return the water animal spawn limit
     */
    public static int getWaterAnimalSpawnLimit() {
        return server.getWaterAnimalSpawnLimit();
    }
    
    /**
     * Gets user-specified limit for number of ambient mobs that can spawn in
     * a chunk.
     *
     * @return the ambient spawn limit
     */
    public static int getAmbientSpawnLimit() {
        return server.getAmbientSpawnLimit();
    }

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
    public static boolean isPrimaryThread() {
        return server.isPrimaryThread();
    }

    /**
     * 获取在客户端服务器列表里显示的消息(服务器的欢迎消息，又称message of the day).
     * <p>
     * 原文:Gets the message that is displayed on the server list.
     *
     * @return 服务器motd
     */
    public static String getMotd() {
        return server.getMotd();
    }

    /**
     * 获取服务器关闭时显示的提示消息.
     * <p>
     * 原文:Gets the default message that is displayed when the server is stopped.
     *
     * @return 服务器关闭提示消息内容
     */
    public static String getShutdownMessage() {
        return server.getShutdownMessage();
    }

    /**
     * Gets the current warning state for the server.
     *
     * @return the configured warning state
     */
    public static WarningState getWarningState() {
        return server.getWarningState();
    }

    /**
     * Gets the instance of the item factory (for {@link ItemMeta}).
     *
     * @return the item factory
     * @see ItemFactory
     */
    public static ItemFactory getItemFactory() {
        return server.getItemFactory();
    }

    /**
     * Gets the instance of the scoreboard manager.
     * <p>
     * This will only exist after the first world has loaded.
     *
     * @return the scoreboard manager or null if no worlds are loaded.
     */
    public static ScoreboardManager getScoreboardManager() {
        return server.getScoreboardManager();
    }

    /**
     * Gets an instance of the server's default server-icon.
     *
     * @return the default server-icon; null values may be used by the
     *     implementation to indicate no defined icon, but this behavior is
     *     not guaranteed
     */
    public static CachedServerIcon getServerIcon() {
        return server.getServerIcon();
    }

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
    public static CachedServerIcon loadServerIcon(File file) throws IllegalArgumentException, Exception {
        return server.loadServerIcon(file);
    }

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
    public static CachedServerIcon loadServerIcon(BufferedImage image) throws IllegalArgumentException, Exception {
        return server.loadServerIcon(image);
    }

    /**
     * 设置一个空闲超时阈值(IDLE_KICK). 玩家空闲达到这个特定的时间后会被自动踢出服务器.
     * 如果设置为0，该功能将被关闭.
     * <p>
     * 原文: Set the idle kick timeout. Any players idle for the specified amount of
     * time will be automatically kicked.
     * <p>
     * A value of 0 will disable the idle kick timeout.
     *
     * @param threshold 玩家空闲时间阈值，以分钟为单位
     */
    public static void setIdleTimeout(int threshold) {
        server.setIdleTimeout(threshold);
    }

    /**
     * 获取服务器空闲超时阈值(IDLE_KICK).
     * <p>
     * 原文: Gets the idle kick timeout.
     *
     * @return 以分钟为单位的空闲超时阈值
     */
    public static int getIdleTimeout() {
        return server.getIdleTimeout();
    }

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
    public static ChunkGenerator.ChunkData createChunkData(World world) {
        return server.createChunkData(world);
    }

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
     * @param flags 血量条的附加属性列表（可选）
     * @return 创建的Boss血量条实例
     */
    public static BossBar createBossBar(String title, BarColor color, BarStyle style, BarFlag... flags) {
        return server.createBossBar(title, color, style, flags);
    }

    /**
     * 用UUID获取实体.
     * <p>
     * 原文:Gets an entity on the server by its UUID
     *
     * @param uuid 实体的UUID
     * @return 该UUID代表的实体，如果不存在为null
     */
    public static Entity getEntity(UUID uuid) {
        return server.getEntity(uuid);
    }

    /**
     * 通过Key获得特定的进度对象.
     * <p>
     * 原文: Get the advancement specified by this key.
     *
     * @param 寻找进度对象所需的key
     * @return 一个进度对象. 如果它不存在，将返回null.
     */
    public static Advancement getAdvancement(NamespacedKey key) {
        return server.getAdvancement(key);
    }

    /**
     * 获取一个用以遍历所有进度的迭代器对象。
     * 进度不能够从该迭代器上被删除。
     * <p>
     * 原文: Get an iterator through all advancements. Advancements cannot be removed
     * from this iterator,
     *
     * @return 一个进度迭代器对象
     */
    public static Iterator<Advancement> advancementIterator() {
        return server.advancementIterator();
    }

    /**
     * @see UnsafeValues
     * @return UnsafeValues实例
     */
    @Deprecated
    public static UnsafeValues getUnsafe() {
        return server.getUnsafe();
    }
}
