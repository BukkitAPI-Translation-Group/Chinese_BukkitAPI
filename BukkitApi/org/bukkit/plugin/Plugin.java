package org.bukkit.plugin;

import java.io.File;
import java.io.InputStream;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.generator.ChunkGenerator;

/**
 * Represents a Plugin
 * <p>
 * The use of {@link PluginBase} is recommended for actual Implementation
 */
public interface Plugin extends TabExecutor {
    /**
     * 返回用于存放插件数据的文件夹File对象. 
     * 文件夹可能不存在.
     * <p/>
     * 原文:
     * Returns the folder that the plugin data's files are located in. The
     * folder may not yet exist.
     *
     * @return 文件夹的File对象
     */
    public File getDataFolder();

    /**
     * Returns the plugin.yaml file containing the details for this plugin
     *
     * @return Contents of the plugin.yaml file
     */
    public PluginDescriptionFile getDescription();

    /**
     * Gets a {@link FileConfiguration} for this plugin, read through
     * "config.yml"
     * <p>
     * If there is a default config.yml embedded in this plugin, it will be
     * provided as a default for this Configuration.
     *
     * @return Plugin configuration
     */
    public FileConfiguration getConfig();

    /**
     * 获取插件jar内的资源文件. 
     * <p/>
     * 原文:
     * Gets an embedded resource in this plugin
     *
     * @param filename 资源文件的文件名
     * @return 如果文件存在返回文件File对象,否则返回null
     */
    public InputStream getResource(String filename);

    /**
     * Saves the {@link FileConfiguration} retrievable by {@link #getConfig()}.
     */
    public void saveConfig();

    /**
     * Saves the raw contents of the default config.yml file to the location
     * retrievable by {@link #getConfig()}.
     * <p>
     * This should fail silently if the config.yml already exists.
     */
    public void saveDefaultConfig();

    /**
     * Saves the raw contents of any resource embedded with a plugin's .jar
     * file assuming it can be found using {@link #getResource(String)}.
     * <p>
     * The resource is saved into the plugin's data folder using the same
     * hierarchy as the .jar file (subdirectories are preserved).
     *
     * @param resourcePath the embedded resource path to look for within the
     *     plugin's .jar file. (No preceding slash).
     * @param replace if true, the embedded resource will overwrite the
     *     contents of an existing file.
     * @throws IllegalArgumentException if the resource path is null, empty,
     *     or points to a nonexistent resource.
     */
    public void saveResource(String resourcePath, boolean replace);

    /**
     * Discards any data in {@link #getConfig()} and reloads from disk.
     */
    public void reloadConfig();

    /**
     * Gets the associated PluginLoader responsible for this plugin
     *
     * @return PluginLoader that controls this plugin
     */
    public PluginLoader getPluginLoader();

    /**
     * Returns the Server instance currently running this plugin
     *
     * @return Server running this plugin
     */
    public Server getServer();

    /**
     * Returns a value indicating whether or not this plugin is currently
     * enabled
     *
     * @return true if this plugin is enabled, otherwise false
     */
    public boolean isEnabled();

    /**
     * Called when this plugin is disabled
     */
    public void onDisable();

    /**
     * Called after a plugin is loaded but before it has been enabled.
     * <p>
     * When mulitple plugins are loaded, the onLoad() for all plugins is
     * called before any onEnable() is called.
     */
    public void onLoad();

    /**
     * Called when this plugin is enabled
     */
    public void onEnable();

    /**
     * Simple boolean if we can still nag to the logs about things
     *
     * @return boolean whether we can nag
     */
    public boolean isNaggable();

    /**
     * Set naggable state
     *
     * @param canNag is this plugin still naggable?
     */
    public void setNaggable(boolean canNag);

    /**
     * Gets a {@link ChunkGenerator} for use in a default world, as specified
     * in the server configuration
     *
     * @param worldName Name of the world that this will be applied to
     * @param id Unique ID, if any, that was specified to indicate which
     *     generator was requested
     * @return ChunkGenerator for use in the default world generation
     */
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id);

    /**
     * 返回与该服务器日志记录器关联的插件日志记录器. 
     * 返回的日志记录器会在日志内容的开头加上插件名称以表示该日志由指定插件输出. 
     * <p/>
     * 原文:
     * Returns the plugin logger associated with this server's logger. The
     * returned logger automatically tags all log messages with the plugin's
     * name.
     *
     * @return 与插件关联的日志记录器
     */
    public Logger getLogger();

    /**
     * 返回插件的名称. 
     * 本方法会返回插件的裸名(bare name),并且返回的文本应只用于比较.
     * <p/>
     * 原文: 
     * Returns the name of the plugin.
     * <p>
     * This should return the bare name of the plugin and should be used for
     * comparison.
     *
     * @return 返回插件的名称
     */
    public String getName();
}
