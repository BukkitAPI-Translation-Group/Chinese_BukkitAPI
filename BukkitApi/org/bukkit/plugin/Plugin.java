package org.bukkit.plugin;

import java.io.File;
import java.io.InputStream;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.generator.ChunkGenerator;

/**
 * 表示插件<br>
 * 对于实际实现,建议使用 {@link PluginBase}. 
 * <p>
 * 原文: Represents a Plugin. The use of {@link PluginBase} is recommended for actual Implementation
 */
public interface Plugin extends TabExecutor {
    /**
     * 返回插件数据文件所在的文件夹. 文件夹可能尚未存在. 
     * <p>
     * 原文:Returns the folder that the plugin data's files are located in. The
     * folder may not yet exist.
     *
     * @return 此文件夹
     */
    public File getDataFolder();

    /**
     * 返回包含该插件详细信息的plugin.yaml文件. 
     * <p>
     * 原文:Returns the plugin.yaml file containing the details for this plugin
     *
     * @return plugin.yaml文件内容
     */
    public PluginDescriptionFile getDescription();

    /**
     * 获取此插件的{@link FileConfiguration},读入"config.yml".<br>
     * 如果在这个插件中嵌入了默认的config.yml,它将作为这个配置的默认设置.
     * <p>
     * 原文: Gets a {@link FileConfiguration} for this plugin, read through
     * "config.yml"</br>
     * If there is a default config.yml embedded in this plugin, it will be
     * provided as a default for this Configuration.
     *
     * @return Plugin 配置
     */
    public FileConfiguration getConfig();

    /**
     * 获取此插件中的嵌入资源
     * <p>
     * 原文: Gets an embedded resource in this plugin
     *
     * @param filename 资源文件名
     * @return 如果文件找到则返回相应的InputStream,否则为null
     */
    public InputStream getResource(String filename);

    /**
     * 保存{@link FileConfiguration},可通过{@link #getConfig()}检索. 
     * <p>
     * 原文: Saves the {@link FileConfiguration} retrievable by {@link #getConfig()}.
     */
    public void saveConfig();

    /**
	 * 将默认config.yml文件的原始内容保存到由{@link #getConfig()}检索的位置.<br>
	 * 如果config.yml已经存在，这将是必然失败.
     * <p>
     * 原文:Saves the raw contents of the default config.yml file to the location
     * retrievable by {@link #getConfig()}.<br>
     * This should fail silently if the config.yml already exists.
     */
    public void saveDefaultConfig();

	/**
	 * 用插件的.jar文件保存所有资源的原始内容,确保可以使用{@link #getResource(String)}找到.<br>
	 * 使用与.jar文件相同的层次结构将资源保存到插件的数据文件夹中(保存子目录).
	 * <p>
	 * 原文:Saves the raw contents of any resource embedded with a plugin's .jar file
	 * assuming it can be found using {@link #getResource(String)}.<br>
	 * The resource is saved into the plugin's data folder using the same hierarchy
	 * as the .jar file (subdirectories are preserved).
	 *
	 * @param resourcePath 在插件的.jar文件中查找的嵌入式资源路径.(没有前面的斜杠)
	 * @param replace 如果为true，则嵌入的资源将覆盖现有文件的内容
	 * @throws IllegalArgumentException 如果资源路径为null/空,或指向不存在的资源
	 */
    public void saveResource(String resourcePath, boolean replace);

    /**
     * 丢弃 {@link #getConfig()}中所有数据 并且从磁盘重载.
     * <p>
     * 原文:Discards any data in {@link #getConfig()} and reloads from disk.
     */
    public void reloadConfig();

    /**
     * 获取负责此插件的关联PluginLoader.
     * <p>
     * 原文:Gets the associated PluginLoader responsible for this plugin
     *
     * @return 控制插件的PluginLoader
     */
    public PluginLoader getPluginLoader();

    /**
     * 返回当前运行此插件的服务器实例.
     * <p>
     * 原文:Returns the Server instance currently running this plugin
     *
     * @return 运行此插件的服务器
     */
    public Server getServer();

    /**
     * 返回一个布尔值,该值指示当前是否启用此插件
     * <p>
     * 原文:Returns a value indicating whether or not this plugin is currently
     * enabled
     *
     * @return 如果启用此插件,则为true，否则为false.
     */
    public boolean isEnabled();

    /**
     * 当这个插件被关闭时调用.
     * <p>
     * 原文:Called when this plugin is disabled
     */
    public void onDisable();

    /**
     * 加载插件后调用,但在启用之前调用.<br>
     * 当加载多个插件时,在调用任何onEnable()之前调用所有插件的onLoad().
     * <p>
     * 原文:Called after a plugin is loaded but before it has been enabled.<br>
     * When multiple plugins are loaded, the onLoad() for all plugins is
     * called before any onEnable() is called.
     */
    public void onLoad();

    /**
     * 启用此插件时调用.
     * <p>
     * 原文:Called when this plugin is enabled
     */
    public void onEnable();

    /**
     * 使用一个简单的布尔值表达 我们是否可以把一些东西记录到日志文件.
     * <p>
     * 原文:Simple boolean if we can still nag to the logs about things
     *
     * @return 返回一个布尔值如果这个插件是否可以进行记录
     */
    public boolean isNaggable();

    /**
     * 设置 Naggable 状态
     * <p>
     * 原文: Set naggable state
     *
     * @param canNag 这个插件是可以被记录的吗
     */
    public void setNaggable(boolean canNag);

    /**
     * 获取在服务器配置中指定的默认世界中使用的{@link ChunkGenerator}.
     * <p>
     * 原文:Gets a {@link ChunkGenerator} for use in a default world, as specified
     * in the server configuration
     *
     * @param worldName 将应用于世界的名称
     * @param id Unique ID,如果有的话,被指定来指示哪个生成器被调用
     * @return 用于默认世界生成的 ChunkGenerator
     */
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id);

    /**
     * 返回与此服务器记录器关联的插件记录器.返回的记录器自动地用插件的名称标记所有日志消息.
     * <p>
     * 原文: Returns the plugin logger associated with this server's logger. The
     * returned logger automatically tags all log messages with the plugin's
     * name.
     *
     * @return 与此插件相关联的记录器
     */
    public Logger getLogger();

    /**
     * 返回插件的名称.<br>
     * 这应该返回插件的裸名,并且应该用于比较.
     * <p>
     * 原文:Returns the name of the plugin.<br>
     * This should return the bare name of the plugin and should be used for
     * comparison.
     *
     * @return 插件名称
     */
    public String getName();
}
