package org.bukkit;

import com.google.common.collect.ImmutableList;
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
import org.bukkit.advancement.Advancement;
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
import org.bukkit.entity.SpawnCategory;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.loot.LootTable;
import org.bukkit.map.MapView;
import org.bukkit.packs.DataPackManager;
import org.bukkit.permissions.Permissible;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.structure.StructureManager;
import org.bukkit.util.CachedServerIcon;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
     * 原文:Gets the current {@link Server} singleton
     *
     * @return 正在运行的服务器的实例
     */
    @NotNull
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
    public static void setServer(@NotNull Server server) {
        if (Bukkit.server != null) {
            throw new UnsupportedOperationException("Cannot redefine singleton Server");
        }

        Bukkit.server = server;
        server.getLogger().info("This server is running " + getName() + " version " + getVersion() + " (Implementing API version " + getBukkitVersion() + ")");
    }

    /**
     * 获取这个 {@link Server} 实例的名字.
     * <p>
     * 原文:Gets the name of this server implementation.
     *
     * @return 这个服务器实例的名字
     */
    @NotNull
    public static String getName() {
        return server.getName();
    }

    /**
     * 获取这个 {@link Server} 实例的版本.
     * <p>
     * 原文:Gets the version string of this server implementation.
     *
     * @return 这个服务器实例的版本
     */
    @NotNull
    public static String getVersion() {
        return server.getVersion();
    }

    /**
     * 获得服务器运行的Bukkit版本.
     * <p>
     * 原文:Gets the Bukkit version that this server is running.
     *
     * @return Bukkit版本
     */
    @NotNull
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
     * 任何对这个集合的异步操作都是不安全的. 
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
    @NotNull
    public static Collection<? extends Player> getOnlinePlayers() {
        return server.getOnlinePlayers();
    }

    /**
     * 获取服务器允许进入的最大玩家数.
     * <p>
     * 原文:Get the maximum amount of players which can login to this server.
     *
     * @return 服务器的最大玩家数
     */
    public static int getMaxPlayers() {
        return server.getMaxPlayers();
    }

    /**
     * 设置服务器允许进入的最大玩家数.
     * <p>
     * 原文:Set the maximum amount of players allowed to be logged in at once.
     *
     * @param maxPlayers 服务器的最大玩家数
     */
    public static void setMaxPlayers(int maxPlayers) {
        server.setMaxPlayers(maxPlayers);
    }

    /**
     * 获取服务器监听的端口号.
     * <p>
     * 原文:Get the game port that the server runs on.
     *
     * @return 服务器端口
     */
    public static int getPort() {
        return server.getPort();
    }

    /**
     * 获取服务器的视距.
     * <p>
     * 原文:Get the view distance from this server.
     *
     * @return 服务器当前设置的视距
     */
    public static int getViewDistance() {
        return server.getViewDistance();
    }

    /**
     * Get the simulation distance from this server.
     *
     * @return the simulation distance from this server.
     */
    public static int getSimulationDistance() {
        return server.getSimulationDistance();
    }

    /**
     * 获取服务器绑定的IP, 如果未指定就返回空字符串.
     * <p>
     * 原文:Get the IP that this server is bound to, or empty string if not
     * specified.
     *
     * @return 服务器绑定的IP, 如果未指定就返回空字符串
     */
    @NotNull
    public static String getIp() {
        return server.getIp();
    }

    /**
     * 获取默认世界的世界类型 (level-type 设置).
     * <p>
     * 原文:Get world type (level-type setting) for default world.
     *
     * @return 默认世界的世界类型 (例： DEFAULT, FLAT, DEFAULT_1_1)
     */
    @NotNull
    public static String getWorldType() {
        return server.getWorldType();
    }

    /**
     * 获取此服务器是否自然生成结构.
     * <p>
     * 原文:Get generate-structures setting.
     *
     * @return true表示服务器可自然生成结构, false反之
     */
    public static boolean getGenerateStructures() {
        return server.getGenerateStructures();
    }

    /**
     * 获取最大世界大小.
     * <p>
     * 原文:Get max world size.
     *
     * @return 为服务器指定的最大世界大小
     */
    public static int getMaxWorldSize() {
        return server.getMaxWorldSize();
    }

    /**
     * 获取此服务器是否开启了末路之地.
     * <p>
     * 原文:Gets whether this server allows the End or not.
     *
     * @return 是否可以进入末路之地
     */
    public static boolean getAllowEnd() {
        return server.getAllowEnd();
    }

    /**
     * 获取此服务器是否开启了下界.
     * <p>
     * 原文:Gets whether this server allows the Nether or not.
     *
     * @return 是否可以进入下界
     */
    public static boolean getAllowNether() {
        return server.getAllowNether();
    }

    @NotNull
    public static List<String> getInitialEnabledPacks() {
        return server.getInitialEnabledPacks();
    }

    @NotNull
    public static List<String> getInitialDisabledPacks() {
        return server.getInitialDisabledPacks();
    }

    /**
     * Get the DataPack Manager.
     *
     * @return the manager
     */
    @NotNull
    public static DataPackManager getDataPackManager() {
        return server.getDataPackManager();
    }

    /**
     * Gets the server resource pack uri, or empty string if not specified.
     *
     * @return the server resource pack uri, otherwise empty string
     */
    @NotNull
    public static String getResourcePack() {
        return server.getResourcePack();
    }

    /**
     * Gets the SHA-1 digest of the server resource pack, or empty string if
     * not specified.
     *
     * @return the SHA-1 digest of the server resource pack, otherwise empty
     *     string
     */
    @NotNull
    public static String getResourcePackHash() {
        return server.getResourcePackHash();
    }

    /**
     * Gets the custom prompt message to be shown when the server resource
     * pack is required, or empty string if not specified.
     *
     * @return the custom prompt message to be shown when the server resource,
     *     otherwise empty string
     */
    @NotNull
    public static String getResourcePackPrompt() {
        return server.getResourcePackPrompt();
    }

    /**
     * Gets whether the server resource pack is enforced.
     *
     * @return whether the server resource pack is enforced
     */
    public static boolean isResourcePackRequired() {
        return server.isResourcePackRequired();
    }

    /**
     * 获取此服务器是否开启了白名单.
     * <p>
     * 原文:Gets whether this server has a whitelist or not.
     *
     * @return 是否开启了白名单
     */
    public static boolean hasWhitelist() {
        return server.hasWhitelist();
    }

    /**
     * 设置此服务器是否开启白名单.
     * <p>
     * 原文:Sets if the server is whitelisted.
     *
     * @param value true为开, false为关
     */
    public static void setWhitelist(boolean value) {
        server.setWhitelist(value);
    }

    /**
     * Gets whether the server whitelist is enforced.
     *
     * If the whitelist is enforced, non-whitelisted players will be
     * disconnected when the server whitelist is reloaded.
     *
     * @return whether the server whitelist is enforced
     */
    public static boolean isWhitelistEnforced() {
        return server.isWhitelistEnforced();
    }

    /**
     * Sets if the server whitelist is enforced.
     *
     * If the whitelist is enforced, non-whitelisted players will be
     * disconnected when the server whitelist is reloaded.
     *
     * @param value true for enforced, false for not
     */
    public static void setWhitelistEnforced(boolean value) {
        server.setWhitelistEnforced(value);
    }

    /**
     * 获取所有已被添加到白名单的玩家.
     * <p>
     * 原文:Gets a list of whitelisted players.
     *
     * @return 用Set存储的所有被添加到白名单的玩家
     */
    @NotNull
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
     * <p>
     * 原文:Broadcast a message to all players.
     * <p>
     * This is the same as calling {@link #broadcast(java.lang.String,
     * java.lang.String)} to {@link Server#BROADCAST_CHANNEL_USERS}
     *
     * @param message 要广播的消息
     * @return 成功接收此消息的玩家数
     */
    public static int broadcastMessage(@NotNull String message) {
        return server.broadcastMessage(message);
    }

    /**
     * 获取更新文件夹的名字. 系统将会在插件加载时选择适当的时机利用此文件夹来安全地更新插件.
     * <p>
     * 更新文件夹的位置相对于插件文件夹(译注:一般指服务端plugins文件夹下的update文件夹).
     * <p>
     * Tips：如何使用更新文件夹来实现更新您的插件呢? (服主和开发者都可以了解下)：
     * <ol>
     * <li>创建更新文件夹，已有则跳过此步.
     * <li>下载您要更新的插件到此目录(plugins/update) (注意：jar文件名必须和在插件目录下的jar文件名一样，否则不起作用).
     * <li>重载/重启服务器.
     * <li>OK，看效果吧.
     * </ol>
     * <p>
     * 原文:
     * Gets the name of the update folder. The update folder is used to safely
     * update plugins at the right moment on a plugin load.
     * <p>
     * The update folder name is relative to the plugins folder.
     *
     * @return 更新文件夹的名字
     */
    @NotNull
    public static String getUpdateFolder() {
        return server.getUpdateFolder();
    }

    /**
     * 获取更新文件夹的 File 实例. 
     * <p>
     * 系统将会在插件加载时选择适当的时机利用此文件夹来安全地更新插件.
     * <p>
     * 原文:Gets the update folder. The update folder is used to safely update
     * plugins at the right moment on a plugin load.
     *
     * @return 表示更新文件夹的 File 实例
     */
    @NotNull
    public static File getUpdateFolderFile() {
        return server.getUpdateFolderFile();
    }

    /**
     * 获取服务器的最小连接间隔设定.
     * <p>
     * 译注:单位为毫秒.
     * <p>
     * 原文:Gets the value of the connection throttle setting.
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
     * @return 每隔多少tick应该生成一次动物
     * @deprecated 建议使用 {@link #getTicksPerSpawns(SpawnCategory)}
     */
    @Deprecated
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
     * @return 每隔多少tick应该生成一次怪物
     * @deprecated 建议使用 {@link #getTicksPerSpawns(SpawnCategory)}
     */
    @Deprecated
    public static int getTicksPerMonsterSpawns() {
        return server.getTicksPerMonsterSpawns();
    }

    /**
     * 获取每隔多少tick应该生成一次水生动物.
     * <p>
     * <b>例如:</b>
     * <ul>
     * <li>此值为 1 表示服务器会在每个tick尝试生成水生动物.
     * <li>此值为 400 表示服务器会每隔400tick尝试生成水生动物.
     * <li>此值小于 0 表示会使用Minecraft的默认设置.
     * </ul>
     * <p>
     * <b>注意:</b> 如果设为 0, 水生动物生成会被禁用.
     * <p>
     * Minecraft使用的默认值: 1.
     * <p>
     * 原文:Gets the default ticks per water mob spawns value.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn water mobs
     *     every tick.
     * <li>A value of 400 will mean the server will attempt to spawn water mobs
     *     every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b> If set to 0, water mobs spawning will be disabled.
     * <p>
     * Minecraft default: 1.
     *
     * @return 每隔多少tick应该生成一次怪物
     * @deprecated 建议使用 {@link #getTicksPerSpawns(SpawnCategory)}
     */
    @Deprecated
    public static int getTicksPerWaterSpawns() {
        return server.getTicksPerWaterSpawns();
    }

    /**
     * 获取每隔多少tick应该生成一次环境生物(即蝙蝠).
     * <p>
     * <b>例如:</b>
     * <ul>
     * <li>此值为 1 表示服务器会在每个tick尝试生成环境生物.
     * <li>此值为 400 表示服务器会每隔400tick尝试生成环境生物.
     * <li>此值小于 0 表示会使用Minecraft的默认设置.
     * </ul>
     * <p>
     * <b>注意:</b> 如果设为 0, 环境生物生成会被禁用.
     * <p>
     * Minecraft使用的默认值: 1.
     * <p>
     * 原文:Gets the default ticks per ambient mob spawns value.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn ambient mobs
     *     every tick.
     * <li>A value of 400 will mean the server will attempt to spawn ambient mobs
     *     every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b> If set to 0, ambient mobs spawning will be disabled.
     * <p>
     * Minecraft default: 1.
     *
     * @return 每隔多少tick应该生成一次环境生物
     * @deprecated 建议使用 {@link #getTicksPerSpawns(SpawnCategory)}
     */
    @Deprecated
    public static int getTicksPerAmbientSpawns() {
        return server.getTicksPerAmbientSpawns();
    }

    /**
     * 获取每隔多少tick应该生成一次水生环境生物(通常指鱼类).
     * <p>
     * <b>例如:</b>
     * <ul>
     * <li>此值为 1 表示服务器会在每个tick尝试生成水生环境生物.
     * <li>此值为 400 表示服务器会每隔400tick尝试生成水生环境生物.
     * <li>此值小于 0 表示会使用Minecraft的默认设置.
     * </ul>
     * <p>
     * <b>注意:</b> 如果设为 0, 水生环境生物生成会被禁用.
     * <p>
     * Minecraft使用的默认值: 1.
     * <p>
     * 原文:Gets the default ticks per water ambient mob spawns value.
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
     * @return 每隔多少tick应该生成一次水生环境生物
     * @deprecated 建议使用 {@link #getTicksPerSpawns(SpawnCategory)}
     */
    @Deprecated
    public static int getTicksPerWaterAmbientSpawns() {
        return server.getTicksPerAmbientSpawns();
    }

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
     * @deprecated 建议使用 {@link #getTicksPerSpawns(SpawnCategory)}
     */
    @Deprecated
    public static int getTicksPerWaterUndergroundCreatureSpawns() {
        return server.getTicksPerWaterUndergroundCreatureSpawns();
    }

    /**
     * Gets the default ticks per {@link SpawnCategory} spawns value.
     * <p>
     * <b>Example Usage:</b>
     * <ul>
     * <li>A value of 1 will mean the server will attempt to spawn {@link SpawnCategory} mobs
     *     every tick.
     * <li>A value of 400 will mean the server will attempt to spawn {@link SpawnCategory} mobs
     *     every 400th tick.
     * <li>A value below 0 will be reset back to Minecraft's default.
     * </ul>
     * <p>
     * <b>Note:</b> If set to 0, {@link SpawnCategory} mobs spawning will be disabled.
     * <p>
     * Minecraft default: 1.
     * <br>
     * <b>Note: </b> the {@link SpawnCategory#MISC} are not consider.
     *
     * @param spawnCategory the category of spawn
     * @return the default ticks per {@link SpawnCategory} mobs spawn value
     */
    public static int getTicksPerSpawns(@NotNull SpawnCategory spawnCategory) {
        return server.getTicksPerSpawns(spawnCategory);
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
     * @param name 用来查找的玩家名
     * @return 如果找到了则返回玩家对象, 否则返回null
     */
    @Nullable
    public static Player getPlayer(@NotNull String name) {
        return server.getPlayer(name);
    }

    /**
     * 使用给定玩家名精确查找玩家, 不区分大小写.
     * <p>
     * 原文:Gets the player with the exact given name, case insensitive. 
     *
     * @param name 用于检索的精确玩家名称, 不区分大小写 
     * @return 如果找到了则返回玩家对象, 否则返回null
     */
    @Nullable
    public static Player getPlayerExact(@NotNull String name) {
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
     * @param name 需要匹配的(部分)名称
     * @return 包含所有可能的匹配结果的列表
     */
    @NotNull
    public static List<Player> matchPlayer(@NotNull String name) {
        return server.matchPlayer(name);
    }

    /**
     * 使用给定{@link UUID}获取玩家.
     * <p>
     * 原文:Gets the player with the given UUID.
     *
     * @param id 要获取的玩家的{@link UUID}
     * @return 如果找到了则返回玩家对象, 否则返回null
     */
    @Nullable
    public static Player getPlayer(@NotNull UUID id) {
        return server.getPlayer(id);
    }

    /**
     * 获取插件管理器以与其他插件进行交互.
     * <p>
     * 原文:Gets the plugin manager for interfacing with plugins.
     *
     * @return 此服务器的插件管理器
     */
    @NotNull
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
    @NotNull
    public static BukkitScheduler getScheduler() {
        return server.getScheduler();
    }

    /**
     * 获取服务管理器.
     * <p>
     * 原文:Gets a services manager.
     *
     * @return 服务管理器
     */
    @NotNull
    public static ServicesManager getServicesManager() {
        return server.getServicesManager();
    }

    /**
     * 获取当前服务器加载的所有世界的列表.
     * <p>
     * 原文:Gets a list of all worlds on this server.
     *
     * @return 所有已经被服务器加载的世界列表
     */
    @NotNull
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
    @Nullable
    public static World createWorld(@NotNull WorldCreator creator) {
        return server.createWorld(creator);
    }

    /**
     * 卸载给定名称对应的世界.
     * <p>
     * 原文: Unloads a world with the given name.
     *
     * @param name 要卸载的世界的名字
     * @param save 是否在卸载世界前保存区块数据
     * @return 如果成功返回true, 否则返回false
     */
    public static boolean unloadWorld(@NotNull String name, boolean save) {
        return server.unloadWorld(name, save);
    }

    /**
     * 卸载指定的世界.
     * <p>
     * 原文: Unloads a world with the given name.
     *
     * @param world 要卸载的世界
     * @param save 是否在卸载世界前保存区块数据
     * @return 如果成功返回true, 否则返回false
     */
    public static boolean unloadWorld(@NotNull World world, boolean save) {
        return server.unloadWorld(world, save);
    }

    /**
     * 使用给定的名称查找世界.
     * <p>
     * 原文: Gets the world with the given name.
     *
     * @param name 世界名称
     * @return 给定名称对应世界的实例, 没找到则返回null
     */
    @Nullable
    public static World getWorld(@NotNull String name) {
        return server.getWorld(name);
    }

    /**
     * 使用给定{@linkplain UUID 唯一ID}查找世界. 
     * <p>
     * 原文:Gets the world from the given Unique ID.
     *
     * @param uid 要查找的世界的唯一ID
     * @return 没找到则返回null
     */
    @Nullable
    public static World getWorld(@NotNull UUID uid) {
        return server.getWorld(uid);
    }

    /**
     * 创建一个虚拟{@link WorldBorder 世界边界}.
     * <p>
     * 原文:
     * Create a new virtual {@link WorldBorder}.
     *
     * @return 新创建的虚拟世界边界实例
     *
     * @see Player#setWorldBorder(WorldBorder)
     */
    @NotNull
    public static WorldBorder createWorldBorder() {
        return server.createWorldBorder();
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
    @Nullable
    public static MapView getMap(int id) {
        return server.getMap(id);
    }

    /**
     * 创建一个新地图并自动分配一个ID.
     * <p>
     * 原文:Create a new map with an automatically assigned ID.
     *
     * @param world 地图所属的世界
     * @return 新创建的 {@link MapView}
     */
    @NotNull
    public static MapView createMap(@NotNull World world) {
        return server.createMap(world);
    }

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
    @NotNull
    public static ItemStack createExplorerMap(@NotNull World world, @NotNull Location location, @NotNull StructureType structureType) {
        return server.createExplorerMap(world, location, structureType);
    }

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
    @NotNull
    public static ItemStack createExplorerMap(@NotNull World world, @NotNull Location location, @NotNull StructureType structureType, int radius, boolean findUnexplored) {
        return server.createExplorerMap(world, location, structureType, radius, findUnexplored);
    }

    /**
     * 重新加载服务器并刷新设置和插件信息.
     * <p>
     * 原文:Reloads the server, refreshing settings and plugin information.
     */
    public static void reload() {
        server.reload();
        org.spigotmc.CustomTimingsHandler.reload(); // Spigot
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
     * 原文:Returns the primary logger associated with this server instance.
     *
     * @return 与此服务器绑定的 {@link Logger}
     */
    @NotNull
    public static Logger getLogger() {
        return server.getLogger();
    }

    /**
     * 用给定命令名或别名获取 {@link PluginCommand}.
     * <p>
     * 原文:Gets a {@link PluginCommand} with the given name or alias.
     *
     * @param name 命令名或命令别名
     * @return 若找到则返回对应的命令实例, 找不到则返回null
     */
    @Nullable
    public static PluginCommand getPluginCommand(@NotNull String name) {
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
     * 在服务器执行一个命令 (如果命令存在).
     * <p>
     * 原文:Dispatches a command on this server, and executes it if found.
     *
     * @param sender 执行该命令的发送者
     * @param commandLine 命令 + 参数. 例如: <code>test abc 123</code>
     * @return 若命令未找到返回false
     * @throws CommandException 当执行命令期间出现未捕获的异常时抛出
     */
    public static boolean dispatchCommand(@NotNull CommandSender sender, @NotNull String commandLine) throws CommandException {
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
    @Contract("null -> false")
    public static boolean addRecipe(@Nullable Recipe recipe) {
        return server.addRecipe(recipe);
    }

    /**
     * 获取对指定物品适用的所有合成配方的列表.
     * 在比对过程中物品堆叠数量会被忽略.
     * 如果给定物品堆的耐久度为 -1, 将匹配任意的数据值.
     * <p>
     * 原文:Get a list of all recipes for a given item. The stack size is ignored
     * in comparisons. If the durability is -1, it will match any data value.
     *
     * @param result 要匹配的物品
     * @return 对指定物品适用的所有合成配方的列表
     */
    @NotNull
    public static List<Recipe> getRecipesFor(@NotNull ItemStack result) {
        return server.getRecipesFor(result);
    }

    /**
     * 根据指定的 key 获取{@link Recipe 配方}.
     * <p>
     * 原文:Get the {@link Recipe} for the given key.
     *
     * @param recipeKey 配方的 key
     * @return 给定 key 对应的配方, 若未找到返回 null
     */
    @Nullable
    public static Recipe getRecipe(@NotNull NamespacedKey recipeKey) {
        return server.getRecipe(recipeKey);
    }

    /**
     * Get the {@link Recipe} for the list of ItemStacks provided.
     *
     * <p>The list is formatted as a crafting matrix where the index follow
     * the pattern below:</p>
     *
     * <pre>
     * [ 0 1 2 ]
     * [ 3 4 5 ]
     * [ 6 7 8 ]
     * </pre>
     *
     * <p>NOTE: This method will not modify the provided ItemStack array, for that, use
     * {@link #craftItem(ItemStack[], World, Player)}.</p>
     *
     * @param craftingMatrix list of items to be crafted from.
     *                       Must not contain more than 9 items.
     * @param world The world the crafting takes place in.
     * @return the {@link Recipe} resulting from the given crafting matrix.
     */
    @Nullable
    public static Recipe getCraftingRecipe(@NotNull ItemStack[] craftingMatrix, @NotNull World world) {
        return server.getCraftingRecipe(craftingMatrix, world);
    }

    /**
     * Get the crafted item using the list of {@link ItemStack} provided.
     *
     * <p>The list is formatted as a crafting matrix where the index follow
     * the pattern below:</p>
     *
     * <pre>
     * [ 0 1 2 ]
     * [ 3 4 5 ]
     * [ 6 7 8 ]
     * </pre>
     *
     * <p>The {@link World} and {@link Player} arguments are required to fulfill the Bukkit Crafting
     * events.</p>
     *
     * <p>Calls {@link org.bukkit.event.inventory.PrepareItemCraftEvent} to imitate the {@link Player}
     * initiating the crafting event.</p>
     *
     * @param craftingMatrix list of items to be crafted from.
     *                       Must not contain more than 9 items.
     * @param world The world the crafting takes place in.
     * @param player The player to imitate the crafting event on.
     * @return the {@link ItemStack} resulting from the given crafting matrix, if no recipe is found
     * an ItemStack of {@link Material#AIR} is returned.
     */
    @NotNull
    public static ItemStack craftItem(@NotNull ItemStack[] craftingMatrix, @NotNull World world, @NotNull Player player) {
        return server.craftItem(craftingMatrix, world, player);
    }

    /**
     * 获取合成配方列表迭代器.
     * <p>
     * 原文:Get an iterator through the list of crafting recipes.
     *
     * @return 迭代器
     */
    @NotNull
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
     * 重置自定义合成配方列表至默认状态.
     * <p>
     * 原文:Resets the list of crafting recipes to the default.
     */
    public static void resetRecipes() {
        server.resetRecipes();
    }

    /**
     * 从服务器移除指定的合成配方.
     *
     * <b>注意:移除一个合成配方可能导致与此配方有关的数据的永久丢失
     * (例如配方是否已被玩家发现).</b>
     * <p>
     * 原文:Remove a recipe from the server.
     *
     * <b>Note that removing a recipe may cause permanent loss of data
     * associated with that recipe (eg whether it has been discovered by
     * players).</b>
     *
     * @param key 要移除的配方的NamespacedKey
     * @return 若配方成功移除返回true
     */
    public static boolean removeRecipe(@NotNull NamespacedKey key) {
        return server.removeRecipe(key);
    }

    /**
     * 获取服务器配置定义的命令别名列表.
     * <p>
     * 原文:Gets a list of command aliases defined in the server properties.
     *
     * @return 命令别名map
     */
    @NotNull
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
     * Gets whether the server should send a preview of the player's chat
     * message to the client when the player sends a message
     *
     * @return true if the server should send a preview, false otherwise
     * @deprecated chat previews have been removed
     */
    @Deprecated
    public static boolean shouldSendChatPreviews() {
        return server.shouldSendChatPreviews();
    }

    /**
     * Gets whether the server only allow players with Mojang-signed public key
     * to join
     *
     * @return true if only Mojang-signed players can join, false otherwise
     */
    public static boolean isEnforcingSecureProfiles() {
        return server.isEnforcingSecureProfiles();
    }

    /**
     * Gets whether the Server hide online players in server status.
     *
     * @return true if the server hide online players, false otherwise
     */
    public static boolean getHideOnlinePlayers() {
        return server.getHideOnlinePlayers();
    }

    /**
     * 获取服务器是否开启了正版模式.
     * <p>
     * 原文:Gets whether the Server is in online mode or not.
     *
     * @return true则开启/false反之
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
     * 获取服务器是否处于极限生存模式.
     * <p>
     * 原文:Gets whether the server is in hardcore mode or not.
     *
     * @return 服务器是否处于极限生存模式
     */
    public static boolean isHardcore() {
        return server.isHardcore();
    }

    /**
     * 关闭服务器, 停止一切在运行的东西.
     * <p>
     * 原文:Shutdowns the server, stopping everything.
     */
    public static void shutdown() {
        server.shutdown();
    }

    /**
     * 向有给定权限的用户广播一条消息.
     * <p>
     * 原文:Broadcasts the specified message to every user with the given
     * permission name.
     *
     * @param message 要广播的消息
     * @param permission 接受这条公告需要拥有的{@link Permissible
     *     权限许可}
     * @return 成功接收此消息的玩家数
     */
    public static int broadcast(@NotNull String message, @NotNull String permission) {
        return server.broadcast(message, permission);
    }

    /**
     * 以给定名字获取玩家对象, 无论玩家是否在线.
     * <p>
     * 这个方法可能因通过web请求获取玩家名对应UUID而阻塞.
     * <p>
     * 即使此玩家不存在也会返回一个对象. 对于此方法, 任何玩家都是存在的.
     * <p>
     * 原文:Gets the player by the given name, regardless if they are offline or
     * online.
     * <p>
     * This method may involve a blocking web request to get the UUID for the
     * given name.
     * <p>
     * This will return an object even if the player does not exist. To this
     * method, all players will exist.
     *
     * @param name 此玩家的玩家名
     * @return 表示此玩家的OfflinePlayer对象
     * @see #getOfflinePlayer(java.util.UUID)
     * @deprecated 由于玩家名在某个会话后(某次游戏后)不再唯一,
     应使用uuid作为唯一标识来持久化存储用户.
     (译注:正版玩家更改它们的玩家名后,其uuid不会改变,其他正版玩家可以使用这些玩家的曾用名,
     可能会出现同一玩家名对应两个或多个不同玩家的情况)
     */
    @Deprecated
    @NotNull
    public static OfflinePlayer getOfflinePlayer(@NotNull String name) {
        return server.getOfflinePlayer(name);
    }

    /**
     * 以给定名字获取玩家对象, 无论玩家是否在线.
     * <p>
     * 即使此玩家不存在也会返回一个对象. 对于此方法, 任何玩家都是存在的.
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
    @NotNull
    public static OfflinePlayer getOfflinePlayer(@NotNull UUID id) {
        return server.getOfflinePlayer(id);
    }

    /**
     * 创建一份新的{@link PlayerProfile 玩家资料}.
     * <p>
     * 原文:Creates a new {@link PlayerProfile}.
     *
     * @param uniqueId 唯一 id
     * @param name 玩家名
     * @return 新 PlayerProfile
     * @throws IllegalArgumentException 如果唯一 id 和玩家名均为 <code>null</code> 或玩家名为空白字符串
     */
    @NotNull
    public static PlayerProfile createPlayerProfile(@Nullable UUID uniqueId, @Nullable String name) {
        return server.createPlayerProfile(uniqueId, name);
    }

    /**
     * 创建一份新的{@link PlayerProfile 玩家资料}.
     * <p>
     * 原文:Creates a new {@link PlayerProfile}.
     *
     * @param uniqueId 唯一 id
     * @return 新 PlayerProfile
     * @throws IllegalArgumentException 如果唯一 id 为 <code>null</code>
     */
    @NotNull
    public static PlayerProfile createPlayerProfile(@NotNull UUID uniqueId) {
        return server.createPlayerProfile(uniqueId);
    }

    /**
     * 创建一份新的{@link PlayerProfile 玩家资料}.
     * <p>
     * 原文:Creates a new {@link PlayerProfile}.
     *
     * @param name 玩家名
     * @return 新 PlayerProfile
     * @throws IllegalArgumentException 如果玩家名为 <code>null</code> 或空白字符串
     */
    @NotNull
    public static PlayerProfile createPlayerProfile(@NotNull String name) {
        return server.createPlayerProfile(name);
    }

    /**
     * 获取所有已被封禁的IP地址.
     * <p>
     * 原文:Gets a set containing all current IPs that are banned.
     *
     * @return 被封禁IP集合
     */
    @NotNull
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
    public static void banIP(@NotNull String address) {
        server.banIP(address);
    }

    /**
     * 解禁指定的IP地址.
     * <p>
     * 原文:Unbans the specified address from the server.
     *
     * @param address 要解禁的IP地址
     */
    public static void unbanIP(@NotNull String address) {
        server.unbanIP(address);
    }

    /**
     * 获取所有已被封禁的玩家.
     * <p>
     * 原文:Gets a set containing all banned players.
     *
     * @return 已被封禁的玩家
     */
    @NotNull
    public static Set<OfflinePlayer> getBannedPlayers() {
        return server.getBannedPlayers();
    }

    /**
     * 获取指定类型的封禁列表.
     * <p>
     * ban玩家名将不受支持(截至1.16.4还是支持的), 建议封禁玩家的uuid.
     * <p>
     * 原文:Gets a ban list for the supplied type.
     * <p>
     * Bans by name are no longer supported and this method will return
     * null when trying to request them. The replacement is bans by UUID.
     *
     * @param type 要获取的封禁列表的类型, 不能为null
     * @return 指定类型的封禁列表
     */
    @NotNull
    public static BanList getBanList(@NotNull BanList.Type type) {
        return server.getBanList(type);
    }

    /**
     * 获取服务器的所有OP(管理员).
     * <p>
     * 原文:Gets a set containing all player operators.
     *
     * @return 服务器OP
     */
    @NotNull
    public static Set<OfflinePlayer> getOperators() {
        return server.getOperators();
    }

    /**
     * 获取新玩家的默认{@link GameMode 游戏模式}.
     * <p>
     * 原文:Gets the default {@link GameMode} for new players.
     *
     * @return 默认游戏模式
     */
    @NotNull
    public static GameMode getDefaultGameMode() {
        return server.getDefaultGameMode();
    }

    /**
     * 设置新玩家的默认 {@link GameMode}.
     * <p>
     * 原文:Sets the default {@link GameMode} for new players.
     *
     * @param mode 新的游戏模式
     */
    public static void setDefaultGameMode(@NotNull GameMode mode) {
        server.setDefaultGameMode(mode);
    }

    /**
     * 获取服务器的{@link ConsoleCommandSender},
     * 将被作为服务器的标准输入.
     * <p>
     * 译注:该方法用于获取控制台.
     * <p>
     * 原文:Gets a {@link ConsoleCommandSender} that may be used as an input source
     * for this server.
     *
     * @return 控制台命令发送者对象
     */
    @NotNull
    public static ConsoleCommandSender getConsoleSender() {
        return server.getConsoleSender();
    }

    /**
     * 获取包含所有{@link World 世界}数据的文件夹.
     * <p>
     * 译注:通常此文件夹就是服务端根目录.
     * <p>
     * 原文:Gets the folder that contains all of the various {@link World}s.
     *
     * @return 包含所有世界数据的文件夹
     */
    @NotNull
    public static File getWorldContainer() {
        return server.getWorldContainer();
    }

    /**
     * 获取所有登陆过服务器的玩家.
     * <p>
     * 原文:Gets every player that has ever played on this server.     
     * @return 包含所有登录过的玩家的数组
     */
    @NotNull
    public static OfflinePlayer[] getOfflinePlayers() {
        return server.getOfflinePlayers();
    }

    /**
     * 获取服务器上管理plugin channel(插件通道)通信的{@link Messenger}实例.
     * <p>
     * 原文:Gets the {@link Messenger} responsible for this server.
     *
     * @return Messenger实例
     */
    @NotNull
    public static Messenger getMessenger() {
        return server.getMessenger();
    }

    /**
     * 获取服务器上提供所有帮助主题的{@link HelpMap}实例.
     * <p>
     * 原文:Gets the {@link HelpMap} providing help topics for this server.
     *
     * @return HelpMap实例
     */
    @NotNull
    public static HelpMap getHelpMap() {
        return server.getHelpMap();
    }

    /**
     * 以指定类型创建一个空物品栏. 如果type是{@link InventoryType#CHEST}(箱子类型),
     * 新的物品栏的大小则是27, 否则是与物品栏类型对应的正常大小.
     * <br>
     * 如果type是{@link InventoryType#WORKBENCH}, 则这个物品栏不会处理合成配方.
     * 请使用{@link Player#openWorkbench(Location, boolean)}.
     * <br>
     * 同理, 以{@link InventoryType#ENCHANTING}创建的附魔台物品栏也不起作用.
     * 请使用{@link Player#openEnchanting(Location, boolean)}.
     * <p>
     * 原文:Creates an empty inventory with the specified type. If the type
     * is {@link InventoryType#CHEST}, the new inventory has a size of 27;
     * otherwise the new inventory has the normal size for its type.
     * <br>
     * {@link InventoryType#WORKBENCH} will not process crafting recipes if
     * created with this method. Use
     * {@link Player#openWorkbench(Location, boolean)} instead.
     * <br>
     * {@link InventoryType#ENCHANTING} will not process {@link ItemStack}s
     * for possible enchanting results. Use
     * {@link Player#openEnchanting(Location, boolean)} instead.
     *
     * @param owner 物品栏的持有者, 不指定持有者为null
     * @param type 要创建的物品栏的种类
     * @return 新的物品栏
     * @throws IllegalArgumentException 如果这种 {@link InventoryType} 物品栏不能显示给玩家
     *
     * @see InventoryType#isCreatable()
     */
    @NotNull
    public static Inventory createInventory(@Nullable InventoryHolder owner, @NotNull InventoryType type) {
        return server.createInventory(owner, type);
    }

    /**
     * 以指定类型和标题创建一个空物品栏. 如果type是{@link InventoryType#CHEST}(箱子类型),
     * 新的物品栏的大小则是27, 否则是与物品栏类型对应的正常大小.
     * <br>
     * 如果type是{@link InventoryType#WORKBENCH}, 则这个物品栏不会处理合成配方.
     * 请使用{@link Player#openWorkbench(Location, boolean)}.
     * <br>
     * 同理, 以{@link InventoryType#ENCHANTING}创建的附魔台物品栏也不起作用.
     * 请使用{@link Player#openEnchanting(Location, boolean)}.
     * <p>
     * 原文:Creates an empty inventory with the specified type and title. If the type
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
     * @param owner 物品栏的持有者, 如果没有持有者可为null
     * @param type 要创建的物品栏的种类
     * @param title 物品栏的标题, 会显示给玩家
     * @return 新的物品栏
     * @throws IllegalArgumentException 如果这种 {@link InventoryType} 物品栏不能显示给玩家
     *
     * @see InventoryType#isCreatable()
     */
    @NotNull
    public static Inventory createInventory(@Nullable InventoryHolder owner, @NotNull InventoryType type, @NotNull String title) {
        return server.createInventory(owner, type, title);
    }

    /**
     * 创建一个类型为{@link InventoryType#CHEST}, 有指定大小的空物品栏.
     * <p>
     * 原文:Creates an empty inventory of type {@link InventoryType#CHEST} with the
     * specified size.
     *
     * @param owner 物品栏的持有者, 不指定持有者为null
     * @param size 物品栏的大小, 必须为9的倍数
     * @return 新的物品栏
     * @throws IllegalArgumentException 如果大小不是9的倍数
     */
    @NotNull
    public static Inventory createInventory(@Nullable InventoryHolder owner, int size) throws IllegalArgumentException {
        return server.createInventory(owner, size);
    }

    /**
     * 创建一个类型为{@link InventoryType#CHEST}, 有指定大小和标题的空物品栏.
     * <p>
     * 原文:Creates an empty inventory of type {@link InventoryType#CHEST} with the
     * specified size and title.
     *
     * @param owner 物品栏的持有者, 不指定持有者为null
     * @param size 物品栏的大小, 必须为9的倍数
     * @param title 物品栏的标题, 会显示给玩家
     * @return 新的物品栏
     * @throws IllegalArgumentException 如果大小不是9的倍数
     */
    @NotNull
    public static Inventory createInventory(@Nullable InventoryHolder owner, int size, @NotNull String title) throws IllegalArgumentException {
        return server.createInventory(owner, size, title);
    }

    /**
     * 创建一个空的商人.
     * <p>
     * 原文:Creates an empty merchant.
     *
     * @param title 查看商人物品栏时显示的标题
     * @return 新的商人
     */
    @NotNull
    public static Merchant createMerchant(@Nullable String title) {
        return server.createMerchant(title);
    }

    /**
     * Gets the amount of consecutive neighbor updates before skipping
     * additional ones.
     *
     * @return the amount of consecutive neighbor updates, if the value is
     * negative then the limit it's not used
     */
    public static int getMaxChainedNeighborUpdates() {
        return server.getMaxChainedNeighborUpdates();
    }

    /**
     * 获取一个区块最大可生成的怪物数量.
     * <p>
     * 原文:Gets user-specified limit for number of monsters that can spawn in a
     * chunk.
     *
     * @return 生成限制数
     * @deprecated 建议使用 {@link #getSpawnLimit(SpawnCategory)}
     */
    @Deprecated
    public static int getMonsterSpawnLimit() {
        return server.getMonsterSpawnLimit();
    }

    /**
     * 获取一个区块最大可生成的动物数量.
     * <p>
     * 原文:
     * Gets user-specified limit for number of animals that can spawn in a
     * chunk.
     *
     * @return 生成限制数
     * @deprecated 建议使用 {@link #getSpawnLimit(SpawnCategory)}
     */
    @Deprecated
    public static int getAnimalSpawnLimit() {
        return server.getAnimalSpawnLimit();
    }

    /**
     * 获取一个区块最大可生成的水生动物数量.
     * <p>
     * 原文:Gets user-specified limit for number of water animals that can spawn in
     * a chunk.
     *
     * @return 生成限制数
     * @deprecated 建议使用 {@link #getSpawnLimit(SpawnCategory)}
     */
    @Deprecated
    public static int getWaterAnimalSpawnLimit() {
        return server.getWaterAnimalSpawnLimit();
    }

    /**
     * 获取一个区块最大可生成的水生环境数量.
     * <p>
     * 原文:Gets user-specified limit for number of water ambient mobs that can spawn
     * in a chunk.
     *
     * @return 生成限制数
     * @deprecated 建议使用 {@link #getSpawnLimit(SpawnCategory)}
     */
    @Deprecated
    public static int getWaterAmbientSpawnLimit() {
        return server.getAmbientSpawnLimit();
    }

    /**
     * Get user-specified limit for number of water creature underground that can spawn
     * in a chunk.
     *
     * @return the water underground creature limit
     * @deprecated Deprecated in favor of {@link #getSpawnLimit(SpawnCategory)}
     */
    @Deprecated
    public static int getWaterUndergroundCreatureSpawnLimit() {
        return server.getWaterUndergroundCreatureSpawnLimit();
    }

    /**
     * 获取一个区块最大可生成的环境生物(一般指蝙蝠)数量.
     * <p>
     * 原文:Gets user-specified limit for number of ambient mobs that can spawn in
     * a chunk.
     *
     * @return 生成限制数
     * @deprecated 建议使用 {@link #getSpawnLimit(SpawnCategory)}
     */
    @Deprecated
    public static int getAmbientSpawnLimit() {
        return server.getAmbientSpawnLimit();
    }

    /**
     * Gets user-specified limit for number of {@link SpawnCategory} mobs that can spawn in
     * a chunk.
     *
     * <b>Note: the {@link SpawnCategory#MISC} are not consider.</b>
     *
     * @param spawnCategory the category spawn
     * @return the {@link SpawnCategory} spawn limit
     */
    public static int getSpawnLimit(@NotNull SpawnCategory spawnCategory) {
        return server.getSpawnLimit(spawnCategory);
    }

    /**
     * 检查当前方法是否在主线程执行。
     * <p>
     * <b>注意:</b> 该方法不应该用于检查当前同步状态,当前线程为主线程表明它确实为同步,但是不能排除其他原因.
     * <p>
     * 原文:Checks the current thread against the expected primary thread for the
     * server.
     * <p>
     * <b>Note:</b> this method should not be used to indicate the current
     * synchronized state of the runtime. A current thread matching the main
     * thread indicates that it is synchronized, but a mismatch <b>does not
     * preclude</b> the same assumption.
     *
     * @return 为主线程返回true否则返回false
     */
    public static boolean isPrimaryThread() {
        return server.isPrimaryThread();
    }

    /**
     * 获取在客户端服务器列表里显示的消息(服务器的欢迎消息，又称message of the day, 展示在mc客户端的服务器列表).
     * <p>
     * 原文:Gets the message that is displayed on the server list.
     *
     * @return 服务器motd
     */
    @NotNull
    public static String getMotd() {
        return server.getMotd();
    }

    /**
     * 设置在客户端服务器列表里显示的消息.
     * <p>
     * 原文:Set the message that is displayed on the server list.
     *
     * @param motd 服务器motd
     */
    public static void setMotd(@NotNull String motd) {
        server.setMotd(motd);
    }

    /**
     * 获取服务器关闭时广播给玩家的默认提示消息.
     * <p>
     * 原文:Gets the default message that is displayed when the server is stopped.
     *
     * @return 关服消息
     */
    @Nullable
    public static String getShutdownMessage() {
        return server.getShutdownMessage();
    }

    /**
     * 获取服务器的警告状态.
     * <p>
     * 原文:Gets the current warning state for the server.
     *
     * @return 预先配置的警告状态
     */
    @NotNull
    public static WarningState getWarningState() {
        return server.getWarningState();
    }

    /**
     * 获取ItemFactory实例 (用于{@link ItemMeta}).
     * <p>
     * 原文:Gets the instance of the item factory (for {@link ItemMeta}).
     *
     * @return ItemFactory实例
     * @see ItemFactory
     */
    @NotNull
    public static ItemFactory getItemFactory() {
        return server.getItemFactory();
    }

    /**
     * 获取计分板管理器实例.
     * <p>
     * 只在第一个世界加载后存在.
     * <p>
     * 原文:Gets the instance of the scoreboard manager.
     * <p>
     * This will only exist after the first world has loaded.
     *
     * @return 计分板管理器实例, 如果未加载任何世界则为null
     */
    @Nullable
    public static ScoreboardManager getScoreboardManager() {
        return server.getScoreboardManager();
    }

    /**
     * Get (or create) a new {@link Criteria} by its name.
     *
     * @param name the criteria name
     * @return the criteria
     * @see Criteria Criteria for a list of constants
     */
    @NotNull
    public static Criteria getScoreboardCriteria(@NotNull String name) {
        return server.getScoreboardCriteria(name);
    }

    /**
     * 获取服务器默认图标.
     * <p>
     * 原文:Gets an instance of the server's default server-icon.
     *
     * @return 服务器默认图标,当未定义服务器图标时将返回null(该行为无法担保)
     */
    @Nullable
    public static CachedServerIcon getServerIcon() {
        return server.getServerIcon();
    }

    /**
     * 为指定文件创建一个缓存的服务器图标.
     * <p>
     * 大小和类型必须在允许范围内(由底层实现定义),否则将会抛出{@link Exception}.
     * <p>
     * 原文:Loads an image from a file, and returns a cached image for the specific
     * server-icon.
     * <p>
     * Size and type are implementation defined. An incompatible file is
     * guaranteed to throw an implementation-defined {@link Exception}.
     *
     * @param file 需要被加载的文件
     * @return 一个CachedServerIcon实例,可用于 {@link
     *     ServerListPingEvent#setServerIcon(CachedServerIcon)}
     * @throws IllegalArgumentException 如果图片为null
     * @throws Exception 如果图片规格不适合作为服务器图标
     */
    @NotNull
    public static CachedServerIcon loadServerIcon(@NotNull File file) throws IllegalArgumentException, Exception {
        return server.loadServerIcon(file);
    }

    /**
     * 为指定图片创建一个缓存的服务器图标.
     * <p>
     * 大小和类型必须在允许范围内(由底层实现定义),否则将会抛出{@link Exception}.
     * <p>
     * 原文:Creates a cached server-icon for the specific image.
     * <p>
     * Size and type are implementation defined. An incompatible file is
     * guaranteed to throw an implementation-defined {@link Exception}.
     *
     * @param image 用于缓存的图片
     * @return 一个CachedServerIcon实例,可用于 {@link
     *     ServerListPingEvent#setServerIcon(CachedServerIcon)}
     * @throws IllegalArgumentException 若image为null
     * @throws Exception 如果图片规格不适合作为服务器图标
     */
    @NotNull
    public static CachedServerIcon loadServerIcon(@NotNull BufferedImage image) throws IllegalArgumentException, Exception {
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
     * 获取自动踢出闲置玩家的时间.
     * <p>
     * 原文:Gets the idle kick timeout.
     *
     * @return the 闲置超时的分钟数
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
     */
    @NotNull
    public static ChunkGenerator.ChunkData createChunkData(@NotNull World world) {
        return server.createChunkData(world);
    }

    /**
     * 创建一个Boss血量条实例. 血量条的进度默认为1.0.
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
    @NotNull
    public static BossBar createBossBar(@Nullable String title, @NotNull BarColor color, @NotNull BarStyle style, @NotNull BarFlag... flags) {
        return server.createBossBar(title, color, style, flags);
    }

    /**
     * 创建一个Boss血量条实例. 血量条的进度默认为1.0.
     * <br>
     * 该方法创建的实例会被添加到服务器的持久化存储空间中, 命令将可以编辑它们, 服务器重启后会被恢复.
     * <p>
     * 原文:Creates a boss bar instance to display to players. The progress defaults
     * to 1.0.
     * <br>
     * This instance is added to the persistent storage of the server and will
     * be editable by commands and restored after restart.
     *
     * @param key boss血量条的key, 将用于获取血量条
     * @param title 血量条的标题
     * @param color 血量条的颜色
     * @param style 血量条的样式
     * @param flags 血量条的附加属性列表（可选）
     * @return 创建的Boss血量条实例
     */
    @NotNull
    public static KeyedBossBar createBossBar(@NotNull NamespacedKey key, @Nullable String title, @NotNull BarColor color, @NotNull BarStyle style, @NotNull BarFlag... flags) {
        return server.createBossBar(key, title, color, style, flags);
    }

    /**
     * 获取一个不可编辑的用于迭代所有持久存储的boss血量条的迭代器.
     * <ul>
     *   <li>这个血量条<b>不</b>绑定到某一具体的{@link org.bukkit.entity.Boss}</li>
     *   <li>这个血量条<b>不是</b>由{@link #createBossBar(String, BarColor, BarStyle, BarFlag...)}创建的
     *   </li>
     * </ul>
     * 例如:使用bossbar命令创建的boss血量条 (它是持久存储的, 可由此迭代器访问).
     * <p>
     * 原文:Gets an unmodifiable iterator through all persistent bossbars.
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
     * @return bossbar迭代器
     */
    @NotNull
    public static Iterator<KeyedBossBar> getBossBars() {
        return server.getBossBars();
    }

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
    @Nullable
    public static KeyedBossBar getBossBar(@NotNull NamespacedKey key) {
        return server.getBossBar(key);
    }

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
    public static boolean removeBossBar(@NotNull NamespacedKey key) {
        return server.removeBossBar(key);
    }

    /**
     * 用UUID获取实体.
     * <p>
     * 原文:Gets an entity on the server by its UUID
     *
     * @param uuid 实体的UUID
     * @return 该UUID代表的实体，如果不存在为null
     */
    @Nullable
    public static Entity getEntity(@NotNull UUID uuid) {
        return server.getEntity(uuid);
    }

    /**
     * 通过Key获得特定的进度对象.
     * <p>
     * 原文: Get the advancement specified by this key.
     *
     * @param key 寻找进度对象所需的key
     * @return 一个进度对象. 如果它不存在，将返回null.
     */
    @Nullable
    public static Advancement getAdvancement(@NotNull NamespacedKey key) {
        return server.getAdvancement(key);
    }

    /**
     * 获取一个用以遍历所有进度的迭代器对象。
     * 进度不能够从该迭代器上删除。
     * <p>
     * 原文: Get an iterator through all advancements. Advancements cannot be removed
     * from this iterator,
     *
     * @return 一个进度迭代器对象
     */
    @NotNull
    public static Iterator<Advancement> advancementIterator() {
        return server.advancementIterator();
    }

    /**
     * Creates a new {@link BlockData} instance for the specified Material, with
     * all properties initialized to unspecified defaults.
     *
     * @param material the material
     * @return new data instance
     */
    @NotNull
    public static BlockData createBlockData(@NotNull Material material) {
        return server.createBlockData(material);
    }

    /**
     * Creates a new {@link BlockData} instance for the specified Material, with
     * all properties initialized to unspecified defaults.
     *
     * @param material the material
     * @param consumer consumer to run on new instance before returning
     * @return new data instance
     */
    @NotNull
    public static BlockData createBlockData(@NotNull Material material, @Nullable Consumer<BlockData> consumer) {
        return server.createBlockData(material, consumer);
    }

    /**
     * Creates a new {@link BlockData} instance with material and properties
     * parsed from provided data.
     *
     * @param data data string
     * @return new data instance
     * @throws IllegalArgumentException if the specified data is not valid
     */
    @NotNull
    public static BlockData createBlockData(@NotNull String data) throws IllegalArgumentException {
        return server.createBlockData(data);
    }

    /**
     * Creates a new {@link BlockData} instance for the specified Material, with
     * all properties initialized to unspecified defaults, except for those
     * provided in data.
     *
     * @param material the material
     * @param data data string
     * @return new data instance
     * @throws IllegalArgumentException if the specified data is not valid
     */
    @NotNull
    @Contract("null, null -> fail")
    public static BlockData createBlockData(@Nullable Material material, @Nullable String data) throws IllegalArgumentException {
        return server.createBlockData(material, data);
    }

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
    @Nullable
    public static <T extends Keyed> Tag<T> getTag(@NotNull String registry, @NotNull NamespacedKey tag, @NotNull Class<T> clazz) {
        return server.getTag(registry, tag, clazz);
    }

    /**
     * 获取服务器定义的所有标签.
     * <br>
     * Server implementations are allowed to handle only the registries
     * indicated in {@link Tag}.
     * <br>
     * 对返回的迭代器的可变性不作保证.
     * 原文:Gets a all tags which have been defined within the server.
     * <br>
     * Server implementations are allowed to handle only the registries
     * indicated in {@link Tag}.
     * <br>
     * No guarantees are made about the mutability of the returned iterator.
     *
     * @param <T> tag的类型
     * @param registry the tag registry to look at
     * @param clazz the class of the tag entries
     * @return all defined tags
     */
    @NotNull
    public static <T extends Keyed> Iterable<Tag<T>> getTags(@NotNull String registry, @NotNull Class<T> clazz) {
        return server.getTags(registry, clazz);
    }

    /**
     * 获取指定的 {@link LootTable 战利品表}.
     * <p>
     * 原文:Gets the specified {@link LootTable}.
     *
     * @param key LootTable的名称
     * @return LootTable实例, 若找不到返回null
     */
    @Nullable
    public static LootTable getLootTable(@NotNull NamespacedKey key) {
        return server.getLootTable(key);
    }

    /**
     * 以给定的原版选择器选择筛选实体.
     * <br>
     * 既不保证选择器的格式, 也不保证.
     *
     * 原文:Selects entities using the given Vanilla selector.
     * <br>
     * No guarantees are made about the selector format, other than they match
     * the Vanilla format for the active Minecraft version.
     * <br>
     * Usually a selector will start with '@', unless selecting a Player in
     * which case it may simply be the Player's name or UUID.
     * <br>
     * Note that in Vanilla, elevated permissions are usually required to use
     * '@' selectors, but this method should not check such permissions from the
     * sender.
     *
     * @param sender the sender to execute as, must be provided
     * @param selector the selection string
     * @return a list of the selected entities. The list will not be null, but
     * no further guarantees are made.
     * @throws IllegalArgumentException if the selector is malformed in any way
     * or a parameter is null
     */
    @NotNull
    public static List<Entity> selectEntities(@NotNull CommandSender sender, @NotNull String selector) throws IllegalArgumentException {
        return server.selectEntities(sender, selector);
    }

    /**
     * Gets the structure manager for loading and saving structures.
     *
     * @return the structure manager
     */
    @NotNull
    public static StructureManager getStructureManager() {
        return server.getStructureManager();
    }

    /**
     * Returns the registry for the given class.
     * <br>
     * If no registry is present for the given class null will be returned.
     * <br>
     * Depending on the implementation not every registry present in
     * {@link Registry} will be returned by this method.
     *
     * @param tClass of the registry to get
     * @param <T> type of the registry
     * @return the corresponding registry or null if not present
     */
    @Nullable
    public static <T extends Keyed> Registry<T> getRegistry(@NotNull Class<T> tClass) {
        return server.getRegistry(tClass);
    }

    /**
     * @return UnsafeValues实例
     * @see UnsafeValues
     */
    @Deprecated
    @NotNull
    public static UnsafeValues getUnsafe() {
        return server.getUnsafe();
    }

    @NotNull
    public static Server.Spigot spigot() {
        return server.spigot();
    }
}
