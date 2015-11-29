package org.bukkit;

import java.util.Random;
import org.bukkit.command.CommandSender;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;

/**
 * 表示可能用于创建一个世界的各种类型的设置。
 */
public class WorldCreator {
    private final String name;
    private long seed;
    private World.Environment environment = World.Environment.NORMAL;
    private ChunkGenerator generator = null;
    private WorldType type = WorldType.NORMAL;
    private boolean generateStructures = true;
    private String generatorSettings = "";

    /**
     * 为指定世界的名称创建一个空的WorldCreationOptions类型。
     * <p>
     * 原文：
     * Creates an empty WorldCreationOptions for the given world name
     *
     * @param name 将被创建的世界的名称
     */
    public WorldCreator(String name) {
        if (name == null) {
            throw new IllegalArgumentException("World name cannot be null");
        }

        this.name = name;
        this.seed = (new Random()).nextLong();
    }

    /**
     * 从指定的世界复制设置。
     * <p>
     * 原文：
     * Copies the options from the specified world
     *
     * @param world 用于复制设置的世界来源
     * @return 用于连接的对象
     */
    public WorldCreator copy(World world) {
        if (world == null) {
            throw new IllegalArgumentException("World cannot be null");
        }

        seed = world.getSeed();
        environment = world.getEnvironment();
        generator = world.getGenerator();

        return this;
    }

    /**
     * 从指定的{@link WorldCreator}复制设置。
     * <p>
     * 原文：
     * Copies the options from the specified {@link WorldCreator}
     *
     * @param creator 用于复制设置的世界来源
     * @return 用于连接的对象
     */
    public WorldCreator copy(WorldCreator creator) {
        if (creator == null) {
            throw new IllegalArgumentException("Creator cannot be null");
        }

        seed = creator.seed();
        environment = creator.environment();
        generator = creator.generator();

        return this;
    }

    /**
     * 获取被加载或创建的世界的名称。
     * <p>
     * 原文：
     * Gets the name of the world that is to be loaded or created.
     *
     * @return 世界名称
     */
    public String name() {
        return name;
    }

    /**
     * 获取用于创建这个世界的种子。
     * <p>
     * 原文：
     * Gets the seed that will be used to create this world
     *
     * @return 世界种子
     */
    public long seed() {
        return seed;
    }

    /**
     * 设置用于创建这个世界的种子。
     * <p>
     * 原文：
     * Sets the seed that will be used to create this world
     *
     * @param seed 世界种子
     * @return 用于连接的对象
     */
    public WorldCreator seed(long seed) {
        this.seed = seed;

        return this;
    }

    /**
     * 获取用于创建或加载世界的环境。
     * <p>
     * 原文：
     * Gets the environment that will be used to create or load the world
     *
     * @return 世界的环境
     */
    public World.Environment environment() {
        return environment;
    }

    /**
     * 设置用于创建或加载世界的环境。
     * <p>
     * 原文：
     * Sets the environment that will be used to create or load the world
     *
     * @param env 世界的环境
     * @return 用于连接的对象
     */
    public WorldCreator environment(World.Environment env) {
        this.environment = env;

        return this;
    }

    /**
     * 获取将被创建或加载的世界的类型。
     * <p>
     * 原文：
     * Gets the type of the world that will be created or loaded
     *
     * @return 世界的类型
     */
    public WorldType type() {
        return type;
    }

    /**
     * 设置将被创建或加载的世界的类型。
     * <p>
     * 原文：
     * Sets the type of the world that will be created or loaded
     *
     * @param type 世界的类型
     * @return 用于连接的对象
     */
    public WorldCreator type(WorldType type) {
        this.type = type;

        return this;
    }

    /**
     * 获取用于创建或加载世界的生成器。
     * <p>
     * 可能为null值，在这种情况下会使用这个环境的"natural"型生成器。
     * <p>
     * 原文：
     * Gets the generator that will be used to create or load the world.
     * <p>
     * This may be null, in which case the "natural" generator for this
     * environment will be used.
     *
     * @return 区块生成器
     */
    public ChunkGenerator generator() {
        return generator;
    }

    /**
     * 设置将被用于创建或加载世界的生成器。
     * <p>
     * 可能为null值，在这种情况下会使用这个环境的"natural"型生成器。
     * <p>
     * 原文：
     * Sets the generator that will be used to create or load the world.
     * <p>
     * This may be null, in which case the "natural" generator for this
     * environment will be used.
     *
     * @param generator 区块生成器
     * @return 用于连接的对象
     */
    public WorldCreator generator(ChunkGenerator generator) {
        this.generator = generator;

        return this;
    }

    /**
     * 设置将被用于创建或加载世界的生成器。
     * <p>
     * 可能为null值，在这种情况下会使用这个环境的"natural"型生成器。
     * <p>
     * 如果找不到指定名字的生成器，就会使用自然环境生成器以代替并且会在控制台上输出一个警告。
     * <p>
     * 原文：
     * Sets the generator that will be used to create or load the world.
     * <p>
     * This may be null, in which case the "natural" generator for this
     * environment will be used.
     * <p>
     * If the generator cannot be found for the given name, the natural
     * environment generator will be used instead and a warning will be
     * printed to the console.
     *
     * @param generator 使用的生成器的名字，形式为"plugin:id" 
     * @return 用于连接的对象
     */
    public WorldCreator generator(String generator) {
        this.generator = getGeneratorForName(name, generator, Bukkit.getConsoleSender());

        return this;
    }

    /**
     * 设置将用于创建或加载的生成器。
     * <p>
     * 可能为null值，在这种情况下会使用这个环境的"natural"型生成器。
     * <p>
     * 如果找不到指定名字的生成器，就会使用自然环境生成器以代替并且会在控制台上输出一个警告。
     * <p>
     * 原文：
     * Sets the generator that will be used to create or load the world.
     * <p>
     * This may be null, in which case the "natural" generator for this
     * environment will be used.
     * <p>
     * If the generator cannot be found for the given name, the natural
     * environment generator will be used instead and a warning will be
     * printed to the specified output
     *
     * @param generator 使用的生成器的名字，形式为"plugin:id" 
     * @param output 将用于接受任何错误信息的{@link CommandSender}
     * @return 用于连接的对象
     */
    public WorldCreator generator(String generator, CommandSender output) {
        this.generator = getGeneratorForName(name, generator, output);

        return this;
    }

    /**
     * 设置将被用于创建或加载世界的生成器的配置。
     * <p>
     * 原文：
     * Sets the generator settings of the world that will be created or loaded
     *
     * @param generatorSettings 将被使用的生成器的配置
     * @return 用于连接的对象
     */
    public WorldCreator generatorSettings(String generatorSettings) {
        this.generatorSettings = generatorSettings;

        return this;
    }

    /**
     * 获取将被创建或加载的世界的生成器的配置。
     * <p>
     * 原文：
     * Gets the generator settings of the world that will be created or loaded
     *
     * @return 将被使用的生成器的配置
     */
    public String generatorSettings() {
        return generatorSettings;
    }

    /**
     * 设置被这个生成器创建或加载的世界是否会拥有建筑。
     * <p>
     * 原文：
     * Sets whether or not worlds created or loaded with this creator will
     * have structures.
     *
     * @param generate 是否生成建筑
     * @return 用于连接的对象
     */
    public WorldCreator generateStructures(boolean generate) {
        this.generateStructures = generate;

        return this;
    }

    /**
     * 获取世界是否生成建筑。
     * <p>
     * 原文:
     * Gets whether or not structures will be generated in the world.
     *
     * @return True 如果生成建筑则返回true
     */
    public boolean generateStructures() {
        return generateStructures;
    }

    /**
     * 使用指定的设置创建一个世界。
     * <p>
     * 如果世界存在，它就会从磁盘被加载，一些设置可能被忽略。
     * <p>
     * 原文：
     * Creates a world with the specified options.
     * <p>
     * If the world already exists, it will be loaded from disk and some
     * options may be ignored.
     *
     * @return 最近创建或加载的世界
     */
    public World createWorld() {
        return Bukkit.createWorld(this);
    }

    /**
     * 为指定的世界名创建一个新的{@link WorldCreator}。
     * <p>
     * 原文：
     * Creates a new {@link WorldCreator} for the given world name
     *
     * @param name 加载或创建的世界名
     * @return 创建的世界生成器
     */
    public static WorldCreator name(String name) {
        return new WorldCreator(name);
    }

    /**
     * 试图使用指定的名称获取{@link ChunkGenerator}。
     * <p>
     * 如果生成器找不到，则会返回null并会向指定的{@link CommandSender}输出一条信息来解释原因。
     * <p>
     * 名称的形式必须为"plugin:id"或"plugin"形式，请求的插件的"plugin"为一个插件的安全名称并且"id"是生成器的可选的唯一的标识符。
     * <p>
     * 原文：
     * Attempts to get the {@link ChunkGenerator} with the given name.
     * <p>
     * If the generator is not found, null will be returned and a message will
     * be printed to the specified {@link CommandSender} explaining why.
     * <p>
     * The name must be in the "plugin:id" notation, or optionally just
     * "plugin", where "plugin" is the safe-name of a plugin and "id" is an
     * optional unique identifier for the generator you wish to request from
     * the plugin.
     *
     * @param world 将被使用的世界名
     * @param name 检索的生成器的名字
     * @param output 错误发生时的输出处
     * @return 若存在则返回获取的生成器，否则返回null
     */
    public static ChunkGenerator getGeneratorForName(String world, String name, CommandSender output) {
        ChunkGenerator result = null;

        if (world == null) {
            throw new IllegalArgumentException("World name must be specified");
        }

        if (output == null) {
            output = Bukkit.getConsoleSender();
        }

        if (name != null) {
            String[] split = name.split(":", 2);
            String id = (split.length > 1) ? split[1] : null;
            Plugin plugin = Bukkit.getPluginManager().getPlugin(split[0]);

            if (plugin == null) {
                output.sendMessage("Could not set generator for world '" + world + "': Plugin '" + split[0] + "' does not exist");
            } else if (!plugin.isEnabled()) {
                output.sendMessage("Could not set generator for world '" + world + "': Plugin '" + plugin.getDescription().getFullName() + "' is not enabled");
            } else {
                result = plugin.getDefaultWorldGenerator(world, id);
            }
        }

        return result;
    }
}