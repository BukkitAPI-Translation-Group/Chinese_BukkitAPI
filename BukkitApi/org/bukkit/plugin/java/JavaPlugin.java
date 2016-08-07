package org.bukkit.plugin.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.Validate;
import org.bukkit.Server;
import org.bukkit.Warning.WarningState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.AuthorNagException;
import org.bukkit.plugin.PluginAwareness;
import org.bukkit.plugin.PluginBase;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginLogger;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebeaninternal.api.SpiEbeanServer;
import com.avaje.ebeaninternal.server.ddl.DdlGenerator;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;

/**
 * 一个Java插件的基类
 */
public abstract class JavaPlugin extends PluginBase {
    private boolean isEnabled = false;
    private PluginLoader loader = null;
    private Server server = null;
    private File file = null;
    private PluginDescriptionFile description = null;
    private File dataFolder = null;
    private ClassLoader classLoader = null;
    private boolean naggable = true;
    private EbeanServer ebean = null;
    private FileConfiguration newConfig = null;
    private File configFile = null;
    private PluginLogger logger = null;

    public JavaPlugin() {
        final ClassLoader classLoader = this.getClass().getClassLoader();
        if (!(classLoader instanceof PluginClassLoader)) {
            throw new IllegalStateException("JavaPlugin requires " + PluginClassLoader.class.getName());
        }
        ((PluginClassLoader) classLoader).initialize(this);
    }

    /**
     * @deprecated 这个方法在单元测试时使用, 其它时候不能使用, 它的存在可能是暂时的.
	 * <p>
	 * 原文:
     * @deprecated This method is intended for unit testing purposes when the
     *     other {@linkplain #JavaPlugin(JavaPluginLoader,
     *     PluginDescriptionFile, File, File) constructor} cannot be used.
     *     <p>
     *     Its existence may be temporary.
     * @param loader 插件加载器
     * @param server 服务器对象
     * @param description 插件的描述
     * @param dataFolder 插件的数据文件夹
     * @param file 插件文件的位置
     */
    @Deprecated
    protected JavaPlugin(final PluginLoader loader, final Server server, final PluginDescriptionFile description, final File dataFolder, final File file) {
        final ClassLoader classLoader = this.getClass().getClassLoader();
        if (classLoader instanceof PluginClassLoader) {
            throw new IllegalStateException("Cannot use initialization constructor at runtime");
        }
        init(loader, server, description, dataFolder, file, classLoader);
    }

    protected JavaPlugin(final JavaPluginLoader loader, final PluginDescriptionFile description, final File dataFolder, final File file) {
        final ClassLoader classLoader = this.getClass().getClassLoader();
        if (classLoader instanceof PluginClassLoader) {
            throw new IllegalStateException("Cannot use initialization constructor at runtime");
        }
        init(loader, loader.server, description, dataFolder, file, classLoader);
    }

    /**
	 * 返回插件数据存放文件夹.
	 * 文件夹可能不存在.
	 * <p>
	 * 原文:
     * Returns the folder that the plugin data's files are located in. The
     * folder may not yet exist.
     *
     * @return 文件夹.
     */
    @Override
    public final File getDataFolder() {
        return dataFolder;
    }

    /**
	 * 获取这个插件关联的PluginLoader.
	 * <p>
	 * <p>
	 * 原文:
     * Gets the associated PluginLoader responsible for this plugin
     *
     * @return PluginLoader控制的插件.
     */
    @Override
    public final PluginLoader getPluginLoader() {
        return loader;
    }

    /**
	 * 返回正在运行此插件的服务器对象.
	 * <p>
	 * 原文:
     * Returns the Server instance currently running this plugin
     *
     * @return 服务器正在运行的插件
     */
    @Override
    public final Server getServer() {
        return server;
    }

    /**
	 * 返回一个值表示此插件是否开启.
	 * <p>
	 * 原文:
     * Returns a value indicating whether or not this plugin is currently
     * enabled
     *
     * @return 返回true就是表示开启, false就表示没有开启.
     */
    @Override
    public final boolean isEnabled() {
        return isEnabled;
    }

    /**
	 * 返回这个插件的文件.
	 * <p>
	 * 原文:
     * Returns the file which contains this plugin
     *
     * @return 插件的核心文件
     */
    protected File getFile() {
        return file;
    }

    /**
	 * 返回插件的plugin.yml的内容的描述信息.
	 * <p>
	 * 原文:
     * Returns the plugin.yaml file containing the details for this plugin
     *
     * @return plugin.yml的内容描述信息
     */
    @Override
    public final PluginDescriptionFile getDescription() {
        return description;
    }

    @Override
    public FileConfiguration getConfig() {
        if (newConfig == null) {
            reloadConfig();
        }
        return newConfig;
    }

    /**
	 * 提供jar中文本文件的读取器.
	 * 此方法依赖 {@link PluginAwareness.Flags#UTF8} 提供编码, 在没有
     * 定义的情况下, 如果指定了 {@link FileConfiguration#UTF8_OVERRIDE} 将使用UTF8编码
     * 否则使用系统默认的编码.
	 * <p>
	 * 原文:
     * Provides a reader for a text file located inside the jar. The behavior
     * of this method adheres to {@link PluginAwareness.Flags#UTF8}, or if not
     * defined, uses UTF8 if {@link FileConfiguration#UTF8_OVERRIDE} is
     * specified, or system default otherwise.
     *
     * @param file 需要加载的文本资源文件名
     * @return null 如果 {@link #getResource(String)} 返回 null
     * @throws 如果文件为空, 抛出无效的参数(IllegalArgumentException)错误
     * @see ClassLoader#getResourceAsStream(String)
     */
    @SuppressWarnings("deprecation")
    protected final Reader getTextResource(String file) {
        final InputStream in = getResource(file);

        return in == null ? null : new InputStreamReader(in, Charsets.UTF_8);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void reloadConfig() {
        newConfig = YamlConfiguration.loadConfiguration(configFile);

        final InputStream defConfigStream = getResource("config.yml");
        if (defConfigStream == null) {
            return;
        }

        newConfig.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
    }

    @Override
    public void saveConfig() {
        try {
            getConfig().save(configFile);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not save config to " + configFile, ex);
        }
    }

    @Override
    public void saveDefaultConfig() {
        if (!configFile.exists()) {
            saveResource("config.yml", false);
        }
    }

    @Override
    public void saveResource(String resourcePath, boolean replace) {
        if (resourcePath == null || resourcePath.equals("")) {
            throw new IllegalArgumentException("ResourcePath cannot be null or empty");
        }

        resourcePath = resourcePath.replace('\\', '/');
        InputStream in = getResource(resourcePath);
        if (in == null) {
            throw new IllegalArgumentException("The embedded resource '" + resourcePath + "' cannot be found in " + file);
        }

        File outFile = new File(dataFolder, resourcePath);
        int lastIndex = resourcePath.lastIndexOf('/');
        File outDir = new File(dataFolder, resourcePath.substring(0, lastIndex >= 0 ? lastIndex : 0));

        if (!outDir.exists()) {
            outDir.mkdirs();
        }

        try {
            if (!outFile.exists() || replace) {
                OutputStream out = new FileOutputStream(outFile);
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.close();
                in.close();
            } else {
                logger.log(Level.WARNING, "Could not save " + outFile.getName() + " to " + outFile + " because " + outFile.getName() + " already exists.");
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not save " + outFile.getName() + " to " + outFile, ex);
        }
    }

    @Override
    public InputStream getResource(String filename) {
        if (filename == null) {
            throw new IllegalArgumentException("Filename cannot be null");
        }

        try {
            URL url = getClassLoader().getResource(filename);

            if (url == null) {
                return null;
            }

            URLConnection connection = url.openConnection();
            connection.setUseCaches(false);
            return connection.getInputStream();
        } catch (IOException ex) {
            return null;
        }
    }

    /**
	 * 返回这个插件的ClassLoader.
	 * <p>
	 * 原文:
     * Returns the ClassLoader which holds this plugin
     *
     * @return ClassLoader控制的这个插件
     */
    protected final ClassLoader getClassLoader() {
        return classLoader;
    }

    /**
	 * 设置插件开启的状态.
	 * <p>
	 * 原文:
     * Sets the enabled state of this plugin
     *
     * @param true表示设置插件为开启, false就是设置插件为关闭
     */
    protected final void setEnabled(final boolean enabled) {
        if (isEnabled != enabled) {
            isEnabled = enabled;

            if (isEnabled) {
                onEnable();
            } else {
                onDisable();
            }
        }
    }

    /**
     * @param loader 插件加载器
     * @param server 服务器对象
     * @param description 插件的描述
     * @param dataFolder 插件的数据文件夹
     * @param file 插件文件的位置
     * @param classLoader 类加载器
     * @deprecated 这个方法已被废弃, 将要被移除 - 它们必须
     *     由专门的构造器替换
     */
    @Deprecated
    protected final void initialize(PluginLoader loader, Server server, PluginDescriptionFile description, File dataFolder, File file, ClassLoader classLoader) {
        if (server.getWarningState() == WarningState.OFF) {
            return;
        }
        getLogger().log(Level.WARNING, getClass().getName() + " is already initialized", server.getWarningState() == WarningState.DEFAULT ? null : new AuthorNagException("Explicit initialization"));
    }

    final void init(PluginLoader loader, Server server, PluginDescriptionFile description, File dataFolder, File file, ClassLoader classLoader) {
        this.loader = loader;
        this.server = server;
        this.file = file;
        this.description = description;
        this.dataFolder = dataFolder;
        this.classLoader = classLoader;
        this.configFile = new File(dataFolder, "config.yml");
        this.logger = new PluginLogger(this);

        if (description.isDatabaseEnabled()) {
            ServerConfig db = new ServerConfig();

            db.setDefaultServer(false);
            db.setRegister(false);
            db.setClasses(getDatabaseClasses());
            db.setName(description.getName());
            server.configureDbConfig(db);

            DataSourceConfig ds = db.getDataSourceConfig();

            ds.setUrl(replaceDatabaseString(ds.getUrl()));
            dataFolder.mkdirs();

            ClassLoader previous = Thread.currentThread().getContextClassLoader();

            Thread.currentThread().setContextClassLoader(classLoader);
            ebean = EbeanServerFactory.create(db);
            Thread.currentThread().setContextClassLoader(previous);
        }
    }

    /**
	 * 提供所有应该存留在数据库中的类的列表
	 * <p>
	 * 原文:
     * Provides a list of all classes that should be persisted in the database
     *
     * @return Ebeans类的列表
     */
    public List<Class<?>> getDatabaseClasses() {
        return new ArrayList<Class<?>>();
    }

    private String replaceDatabaseString(String input) {
        input = input.replaceAll("\\{DIR\\}", dataFolder.getPath().replaceAll("\\\\", "/") + "/");
        input = input.replaceAll("\\{NAME\\}", description.getName().replaceAll("[^\\w_-]", ""));
        return input;
    }

    /**
	 * 获取此插件的初始化状态.
	 * <p>
	 * 原文:
     * Gets the initialization status of this plugin
     *
     * @return true表示插件已初始化, false就是插件未初始化
     * @deprecated 这个方法永远不会返回false, 因为在 {@link
     *     JavaPlugin} 已经在构造函数里初始化
     */
    @Deprecated
    public final boolean isInitialized() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }

    /**
     * 获取这个插件在plugin.yml里注册的命令
     * 命令需要在{@link PluginDescriptionFile#getCommands()
     * PluginDescriptionFile}里已被注册
     * <p>
     * 原文:
     * Gets the command with the given name, specific to this plugin. Commands
     * need to be registered in the {@link PluginDescriptionFile#getCommands()
     * PluginDescriptionFile} to exist at runtime.
     *
     * @param name 一个属于这个插件注册了的命令
     * @return 如果有返回值表示命令存在, 否则返回null
     */
    public PluginCommand getCommand(String name) {
        String alias = name.toLowerCase(java.util.Locale.ENGLISH);
        PluginCommand command = getServer().getPluginCommand(alias);

        if (command == null || command.getPlugin() != this) {
            command = getServer().getPluginCommand(description.getName().toLowerCase(java.util.Locale.ENGLISH) + ":" + alias);
        }

        if (command != null && command.getPlugin() == this) {
            return command;
        } else {
            return null;
        }
    }

    @Override
    public void onLoad() {}

    @Override
    public void onDisable() {}

    @Override
    public void onEnable() {}

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return null;
    }

    @Override
    public final boolean isNaggable() {
        return naggable;
    }

    @Override
    public final void setNaggable(boolean canNag) {
        this.naggable = canNag;
    }

    @Override
    public EbeanServer getDatabase() {
        Preconditions.checkState(description.isDatabaseEnabled(), "Plugin does not have database: true in plugin.yml");

        return ebean;
    }

    protected void installDDL() {
        SpiEbeanServer serv = (SpiEbeanServer) getDatabase();
        DdlGenerator gen = serv.getDdlGenerator();

        gen.runScript(false, gen.generateCreateDdl());
    }

    protected void removeDDL() {
        SpiEbeanServer serv = (SpiEbeanServer) getDatabase();
        DdlGenerator gen = serv.getDdlGenerator();

        gen.runScript(true, gen.generateDropDdl());
    }

    @Override
    public final Logger getLogger() {
        return logger;
    }

    @Override
    public String toString() {
        return description.getFullName();
    }

  /**
	 * 这个方法可以通过{@link
     * #getProvidingPlugin(Class) provided} 的类来快速访问插件对象 .
	 * 这通常是创建插件对象.
	 * <p>
	 * 例外:如果插件jar中的类不能继承类, 将可能是不同的jar/类加载器.
	 * <p>
	 * 原文:
     * This method provides fast access to the plugin that has {@link
     * #getProvidingPlugin(Class) provided} the given plugin class, which is
     * usually the plugin that implemented it.
     * <p>
     * An exception to this would be if plugin's jar that contained the class
     * does not extend the class, where the intended plugin would have
     * resided in a different jar / classloader.
     *
     * @param <T> 任何一个继承了JavaPlugin的类
     * @param 类所需的类
     * @return 该插件提供的类
     * @throws 如果这个类为null, 抛出无效的参数(IllegalArgumentException)错误
     * @throws 如果插件没有继承此类 {@link
     *     JavaPlugin} , 抛出无效的参数(IllegalArgumentException)错误
     * @throws 如果这个类不是插件提供的,抛出无效的状态(IllegalStateException)错误
     *     for example, if called with
     *     <code>JavaPlugin.getPlugin(JavaPlugin.class)</code>
     * @throws IllegalStateException if called from the static initializer for
     *     given JavaPlugin
     * @throws 如果插件提供的类没有继承类, 抛出(ClassCastException)错误
     */
    public static <T extends JavaPlugin> T getPlugin(Class<T> clazz) {
        Validate.notNull(clazz, "Null class cannot have a plugin");
        if (!JavaPlugin.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException(clazz + " does not extend " + JavaPlugin.class);
        }
        final ClassLoader cl = clazz.getClassLoader();
        if (!(cl instanceof PluginClassLoader)) {
            throw new IllegalArgumentException(clazz + " is not initialized by " + PluginClassLoader.class);
        }
        JavaPlugin plugin = ((PluginClassLoader) cl).plugin;
        if (plugin == null) {
            throw new IllegalStateException("Cannot get plugin for " + clazz + " from a static initializer");
        }
        return clazz.cast(plugin);
    }

  /**
	 * 此方法给给定的类提供了快速访问.
	 * <p>
	 * 原文:
     * This method provides fast access to the plugin that has provided the
     * given class.
     *
     * @param clazz 这个类归属的插件
     * @return 这个插件提供的类
     * @throws IllegalArgumentException 如果这个类不是JavaPlugin提供的,
     * 抛出无效的参数(IllegalArgumentException)错误
     * @throws IllegalArgumentException 如果这个类为null,
	 * 抛出无效的参数(IllegalArgumentException)错误
     * @throws IllegalStateException 如果从给定的JavaPlugin静态初始化,
     * 抛出无效的状态(IllegalStateException)错误
     */
    public static JavaPlugin getProvidingPlugin(Class<?> clazz) {
        Validate.notNull(clazz, "Null class cannot have a plugin");
        final ClassLoader cl = clazz.getClassLoader();
        if (!(cl instanceof PluginClassLoader)) {
            throw new IllegalArgumentException(clazz + " is not provided by " + PluginClassLoader.class);
        }
        JavaPlugin plugin = ((PluginClassLoader) cl).plugin;
        if (plugin == null) {
            throw new IllegalStateException("Cannot get plugin for " + clazz + " from a static initializer");
        }
        return plugin;
    }
}