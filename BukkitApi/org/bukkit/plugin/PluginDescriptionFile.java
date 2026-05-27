package org.bukkit.plugin;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.AbstractConstruct;
import org.yaml.snakeyaml.constructor.SafeConstructor;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

/**
 * 这个类是用于储存插件plugin.yml内的数据.
 * 所有的插件都必须有自己的plugin.yml.对于插件来说 plguin.yml是必须使用的标准
 * 这个文件必须位于jar的根目录下.
 * <p>
 * 当Bukkit加载插件时,它必须知道一些基础的关于这个插件的信息.
 * Bukkit从plugin.yml读取数据.
 * plugin.yml由一组属性构成,每个属性位于单独的一行并且没有缩进.
 * <p>
 * 每一个方法(几乎每一个) 都在plugin.yml有其对应的条目.
 * 下面是每一个插件<b>所需</b>的条目.
 *
 * <ul>
 * <li>{@link #getName()} - <code>name</code>
 * <li>{@link #getVersion()} - <code>version</code>
 * <li>{@link #getMain()} - <code>main</code>
 * </ul>
 * <p>
 * 未能填写以上条目,将导致一个异常并且使Bukkit忽视你的插件.
 * <p>
 * 下面是plugin.yml可能拥有的条目表格,具体细节包括各自的方法:
 * <table border=1>
 * <caption>The description of the plugin.yml layout</caption>
 * <tr>
 *     <th>条目</th>
 *     <th>方法</th>
 *     <th>概要</th>
 * </tr><tr>
 *     <td><code>name</code></td>
 *     <td>{@link #getName()}</td>
 *     <td>该插件的名字</td>
 * </tr><tr>
 *     <td><code>provides</code></td>
 *     <td>{@link #getProvides()}</td>
 *     <td>The plugin APIs which this plugin provides</td>
 * </tr><tr>
 *     <td><code>version</code></td>
 *     <td>{@link #getVersion()}</td>
 *     <td>插件的版本</td>
 * </tr><tr>
 *     <td><code>main</code></td>
 *     <td>{@link #getMain()}</td>
 *     <td>插件主类的位置</td>
 * </tr><tr>
 *     <td><code>author</code><br><code>authors</code></td>
 *     <td>{@link #getAuthors()}</td>
 *     <td>插件的作者们</td>
 * </tr><tr>
 *     <td><code>contributors</code></td>
 *     <td>{@link #getContributors()}</td>
 *     <td>插件的贡献者们</td>
 * </tr><tr>
 *     <td><code>description</code></td>
 *     <td>{@link #getDescription()}</td>
 *     <td>可读的插件描述</td>
 * </tr><tr>
 *     <td><code>website</code></td>
 *     <td>{@link #getWebsite()}</td>
 *     <td>插件的网址</td>
 * </tr><tr>
 *     <td><code>prefix</code></td>
 *     <td>{@link #getPrefix()}</td>
 *     <td>用于控制台的插件前缀</td>
 * </tr><tr>
 *     <td><code>load</code></td>
 *     <td>{@link #getLoad()}</td>
 *     <td>载入插件的时机</td>
 * </tr><tr>
 *     <td><code>depend</code></td>
 *     <td>{@link #getDepend()}</td>
 *     <td>必须的前置插件</td>
 * </tr><tr>
 *     <td><code>softdepend</code></td>
 *     <td>{@link #getSoftDepend()}</td>
 *     <td>非必须的前置插件</td>
 * </tr><tr>
 *     <td><code>loadbefore</code></td>
 *     <td>{@link #getLoadBefore()}</td>
 *     <td>反softdepend,可理解为在某些插件前加载</td>
 * </tr><tr>
 *     <td><code>commands</code></td>
 *     <td>{@link #getCommands()}</td>
 *     <td>插件将被注册的命令</td>
 * </tr><tr>
 *     <td><code>permissions</code></td>
 *     <td>{@link #getPermissions()}</td>
 *     <td>插件将被注册的权限</td>
 * </tr><tr>
 *     <td><code>default-permission</code></td>
 *     <td>{@link #getPermissionDefault()}</td>
 *     <td>插件将注册的基本的{@link Permission#getDefault() default} 权限 {@link #getPermissions() permissions}</td>
 * </tr><tr>
 *     <td><code>awareness</code></td>
 *     <td>{@link #getAwareness()}</td>
 *     <td>插件的概念</td>
 * </tr><tr>
 *     <td><code>api-version</code></td>
 *     <td>{@link #getAPIVersion()}</td>
 *     <td>开发插件时针对的API版本</td>
 * </tr><tr>
 *     <td><code>libraries</code></td>
 *     <td>{@link #getLibraries() ()}</td>
 *     <td>插件使用到的类库</td>
 * </tr>
 * </table>
 * <p>
 * 一个plugin.yml的例子:<blockquote><pre>
 *name: Inferno
 *provides: [Hell]
 *version: 1.4.1
 *description: This plugin is so 31337. You can set yourself on fire.
 *# We could place every author in the authors list, but chose not to for illustrative purposes
 *# Also, having an author distinguishes that person as the project lead, and ensures their
 *# name is displayed first
 *author: CaptainInflamo
 *authors: [Cogito, verrier, EvilSeph]
 *contributors: [Choco, md_5]
 *website: http://www.curse.com/server-mods/minecraft/myplugin
 *
 *main: com.captaininflamo.bukkit.inferno.Inferno
 *depend: [NewFire, FlameWire]
 *api-version: 1.13
 *libraries:
    - com.squareup.okhttp3:okhttp:4.9.0
 *
 *commands:
 *  flagrate:
 *    description: Set yourself on fire.
 *    aliases: [combust_me, combustMe]
 *    permission: inferno.flagrate
 *    usage: Syntax error! Simply type /&lt;command&gt; to ignite yourself.
 *  burningdeaths:
 *    description: List how many times you have died by fire.
 *    aliases: [burning_deaths, burningDeaths]
 *    permission: inferno.burningdeaths
 *    usage: |
 *      /&lt;command&gt; [player]
 *      Example: /&lt;command&gt; - see how many times you have burned to death
 *      Example: /&lt;command&gt; CaptainIce - see how many times CaptainIce has burned to death
 *
 *permissions:
 *  inferno.*:
 *    description: Gives access to all Inferno commands
 *    children:
 *      inferno.flagrate: true
 *      inferno.burningdeaths: true
 *      inferno.burningdeaths.others: true
 *  inferno.flagrate:
 *    description: Allows you to ignite yourself
 *    default: true
 *  inferno.burningdeaths:
 *    description: Allows you to see how many times you have burned to death
 *    default: true
 *  inferno.burningdeaths.others:
 *    description: Allows you to see how many times others have burned to death
 *    default: op
 *    children:
 *      inferno.burningdeaths: true
 *</pre></blockquote>
 */
public final class PluginDescriptionFile {
    private static final Pattern VALID_NAME = Pattern.compile("^[A-Za-z0-9 _.-]+$");
    private static final ThreadLocal<Yaml> YAML = new ThreadLocal<Yaml>() {
        @Override
        @NotNull
        protected Yaml initialValue() {
            DumperOptions dumperOptions = new DumperOptions();
            return new Yaml(new SafeConstructor(new LoaderOptions()) {
                {
                    yamlConstructors.put(null, new AbstractConstruct() {
                        @NotNull
                        @Override
                        public Object construct(@NotNull final Node node) {
                            if (!node.getTag().startsWith("!@")) {
                                // Unknown tag - will fail
                                return SafeConstructor.undefinedConstructor.construct(node);
                            }
                            // Unknown awareness - provide a graceful substitution
                            return new PluginAwareness() {
                                @Override
                                public String toString() {
                                    return node.toString();
                                }
                            };
                        }
                    });
                    for (final PluginAwareness.Flags flag : PluginAwareness.Flags.values()) {
                        yamlConstructors.put(new Tag("!@" + flag.name()), new AbstractConstruct() {
                            @NotNull
                            @Override
                            public PluginAwareness.Flags construct(@NotNull final Node node) {
                                return flag;
                            }
                        });
                    }
                }
            }, new Representer(dumperOptions), dumperOptions, new PluginDescriptionResolver());
        }
    };
    String rawName = null;
    private String name = null;
    private List<String> provides = ImmutableList.of();
    private String main = null;
    private String classLoaderOf = null;
    private List<String> depend = ImmutableList.of();
    private List<String> softDepend = ImmutableList.of();
    private List<String> loadBefore = ImmutableList.of();
    private String version = null;
    private Map<String, Map<String, Object>> commands = ImmutableMap.of();
    private String description = null;
    private List<String> authors = null;
    private List<String> contributors = null;
    private String website = null;
    private String prefix = null;
    private PluginLoadOrder order = PluginLoadOrder.POSTWORLD;
    private List<Permission> permissions = null;
    private Map<?, ?> lazyPermissions = null;
    private PermissionDefault defaultPerm = PermissionDefault.OP;
    private Set<PluginAwareness> awareness = ImmutableSet.of();
    private String apiVersion = null;
    private List<String> libraries = ImmutableList.of();

    public PluginDescriptionFile(@NotNull final InputStream stream) throws InvalidDescriptionException {
        loadMap(asMap(YAML.get().load(stream)));
    }

    /**
     * 从指定的 Reader 中读取 PluginDescriptionFile.
     * <p>
     * 原文：
     * Loads a PluginDescriptionFile from the specified reader
     *
     * @param reader Reader 对象
     * @throws InvalidDescriptionException 如果 PluginDescriptionFile 是无效的
     */
    public PluginDescriptionFile(@NotNull final Reader reader) throws InvalidDescriptionException {
        loadMap(asMap(YAML.get().load(reader)));
    }

    /**
     * 构造一个新的 PluginDescriptionFile.
     * <p>
     * 原文：
     * Creates a new PluginDescriptionFile with the given detailed
     *
     * @param pluginName 插件名称
     * @param pluginVersion 插件版本
     * @param mainClass 插件主类的完整路径
     */
    public PluginDescriptionFile(@NotNull final String pluginName, @NotNull final String pluginVersion, @NotNull final String mainClass) {
        name = rawName = pluginName;

        if (!VALID_NAME.matcher(name).matches()) {
            throw new IllegalArgumentException("name '" + name + "' contains invalid characters.");
        }
        name = name.replace(' ', '_');
        version = pluginVersion;
        main = mainClass;
    }

    /**
     * 获取插件的名称. 此名称是插件的唯一标识符.
     * <ul>
     * <li>必须由字母数字字符、下划线、连字符和句点 (a-z,A-Z,0-9, _.-) 组成. 任何其他字符将导致 plugin.yml 加载失败.
     * <li>用于确定插件数据文件夹的名称. 数据文件夹默认放置在 ./plugins/ 目录下, 但不应依赖此行为. 应使用 {@link Plugin#getDataFolder()} 来引用数据文件夹.
     * <li>建议将 jar 文件命名与此一致, 例如 'MyPlugin.jar'.
     * <li>区分大小写.
     * <li>这是在 {@link #getDepend()}, {@link #getSoftDepend()} 和 {@link #getLoadBefore()} 中引用的标识.
     * <li>在插件名称中使用空格已被弃用.
     * </ul>
     * <p>
     * 原文：
     * Gives the name of the plugin. This name is a unique identifier for plugins.
     *
     * @return 插件的名称
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * 获取此插件提供的其他插件 API 列表. 其他插件可以依赖这些 API.
     * <ul>
     * <li>必须由字母数字字符、下划线、连字符和句点 (a-z,A-Z,0-9, _.-) 组成. 任何其他字符将导致 plugin.yml 加载失败.
     * <li>其他插件提供相同 API 或将其用作名称不会导致插件加载失败.
     * <li>区分大小写.
     * <li>此列表中的条目可在 {@link #getDepend()}, {@link #getSoftDepend()} 和 {@link #getLoadBefore()} 中引用.
     * <li><code>provides</code> 必须使用 <a href="https://en.wikipedia.org/wiki/YAML#Lists">YAML 列表格式</a>.
     * </ul>
     * <p>
     * 原文：
     * Gives the list of other plugin APIs which this plugin provides. These are usable for other plugins to depend on.
     *
     * @return 此插件提供的插件 API 不可变列表
     */
    @NotNull
    public List<String> getProvides() {
        return provides;
    }

    /**
     * 获取插件的版本.
     * <ul>
     * <li>版本是一个任意字符串, 但最常用的格式是 主版本.次版本.构建版本 (例如: 1.4.1).
     * <li>通常在每次发布新功能或修复 bug 时递增版本号.
     * <li>当用户输入 <code>/version PluginName</code> 时显示.
     * </ul>
     * <p>
     * 原文：
     * Gives the version of the plugin.
     *
     * @return 插件的版本
     */
    @NotNull
    public String getVersion() {
        return version;
    }

    /**
     * 获取插件主类的完整限定名. 格式应遵循 {@link ClassLoader#loadClass(String)} 语法, 以便在运行时成功解析. 对于大多数插件, 这是扩展 {@link JavaPlugin} 的类.
     * <ul>
     * <li>必须包含完整的命名空间, 包括类文件本身.
     * <li>如果命名空间是 <code>org.bukkit.plugin</code>, 且类文件名为 <code>MyPlugin</code>, 则必须为 <code>org.bukkit.plugin.MyPlugin</code>
     * <li>任何插件都不能使用 <code>org.bukkit.</code> 作为<b>任何类</b> (包括主类) 的基础包.
     * </ul>
     * <p>
     * 原文：
     * Gives the fully qualified name of the main class for a plugin. The format should follow the ClassLoader#loadClass(String) syntax to successfully be resolved at runtime. For most plugins, this is the class that extends JavaPlugin.
     *
     * @return 插件的完整限定主类名
     */
    @NotNull
    public String getMain() {
        return main;
    }

    /**
     * 获取插件功能的人类可读描述.
     * <ul>
     * <li>描述可以有多行.
     * <li>当用户输入 <code>/version PluginName</code> 时显示.
     * </ul>
     * <p>
     * 原文：
     * Gives a human-friendly description of the functionality the plugin provides.
     *
     * @return 插件的描述, 如果未指定则返回 null
     */
    @Nullable
    public String getDescription() {
        return description;
    }

    /**
     * 获取插件应在服务器启动的哪个阶段加载.
     * <ul>
     * <li>可能的值见 {@link PluginLoadOrder}.
     * <li>默认为 {@link PluginLoadOrder#POSTWORLD}.
     * <li>每个阶段有特定的注意事项.
     * <li>当不同时, {@link #getDepend()}, {@link #getSoftDepend()} 和 {@link #getLoadBefore()} 在每个阶段内的加载顺序变为相对的. 如果一个插件在 <code>STARTUP</code> 阶段加载, 但其依赖在 <code>POSTWORLD</code> 阶段加载, 则依赖不会在该插件加载之前被加载.
     * </ul>
     * <p>
     * 原文：
     * Gives the phase of server startup that the plugin should be loaded.
     *
     * @return 插件应加载的阶段
     */
    @NotNull
    public PluginLoadOrder getLoad() {
        return order;
    }

    /**
     * 获取插件的作者列表.
     * <ul>
     * <li>用于标识开发者.
     * <li>在某些服务器错误消息中使用, 以提供有关出现错误时联系谁的有用反馈.
     * <li>建议使用 SpigotMC 论坛账号或电子邮件地址.
     * <li>当用户输入 <code>/version PluginName</code> 时显示.
     * <li><code>authors</code> 必须使用 <a href="https://en.wikipedia.org/wiki/YAML#Lists">YAML 列表格式</a>.
     * </ul>
     * <p>
     * 原文：
     * Gives the list of authors for the plugin.
     *
     * @return 插件作者的不可变列表
     */
    @NotNull
    public List<String> getAuthors() {
        return authors;
    }

    /**
     * 获取插件的贡献者列表.
     * <ul>
     * <li>用于标识对插件有贡献但不足以获得作者资格的人员.
     * <li>与 {@link #getAuthors()} 不同, 贡献者不会在服务器错误消息中作为联系方式被提及.
     * <li>建议使用 SpigotMC 论坛账号或电子邮件地址.
     * <li>当用户输入 <code>/version PluginName</code> 时显示.
     * <li><code>contributors</code> 必须使用 <a href="https://en.wikipedia.org/wiki/YAML#Lists">YAML 列表格式</a>.
     * </ul>
     * <p>
     * 原文：
     * Gives the list of contributors for the plugin.
     *
     * @return 插件贡献者的不可变列表
     */
    @NotNull
    public List<String> getContributors() {
        return contributors;
    }

    /**
     * 获取插件或插件作者的网站.
     * <ul>
     * <li>强烈建议提供包含文档和下载的 Curse 页面链接.
     * <li>当用户输入 <code>/version PluginName</code> 时显示.
     * </ul>
     * <p>
     * 原文：
     * Gives the plugin's or plugin's author's website.
     *
     * @return 插件的网站, 如果未指定则返回 null
     */
    @Nullable
    public String getWebsite() {
        return website;
    }

    /**
     * 获取此插件所需的其他插件列表.
     * <ul>
     * <li>使用目标插件 {@link #getName()} 中的值来指定依赖.
     * <li>如果此处列出的任何插件未找到, 你的插件将在启动时加载失败.
     * <li>如果多个插件在 <code>depend</code> 中相互引用, 形成一个没有单独插件在 <a href="https://en.wikipedia.org/wiki/Circular_dependency">网络</a> 中列出另一个插件的循环依赖, 则该网络中的所有插件都将失败.
     * <li><code>depend</code> 必须使用 <a href="https://en.wikipedia.org/wiki/YAML#Lists">YAML 列表格式</a>.
     * </ul>
     * <p>
     * 原文：
     * Gives a list of other plugins that the plugin requires.
     *
     * @return 插件依赖的不可变列表
     */
    @NotNull
    public List<String> getDepend() {
        return depend;
    }

    /**
     * 获取插件完整功能所需的其他插件列表. {@link PluginManager} 会尽力将此处所有条目视为 {@link #getDepend() 依赖}, 但不会因为这些条目中的任何一个而失败.
     * <ul>
     * <li>使用目标插件 {@link #getName()} 中的值来指定依赖.
     * <li>当列出的插件无法解析时, 它将被忽略且不影响加载顺序.
     * <li>当发生循环依赖 (插件网络相互依赖或软依赖) 时, 将任意选择一个在忽略软依赖时可以解析的插件.
     * <li><code>softdepend</code> 必须使用 <a href="https://en.wikipedia.org/wiki/YAML#Lists">YAML 列表格式</a>.
     * </ul>
     * <p>
     * 原文：
     * Gives a list of other plugins that the plugin requires for full functionality. The PluginManager will make best effort to treat all entries here as if they were a dependency, but will never fail because of one of these entries.
     *
     * @return 插件首选依赖的不可变列表
     */
    @NotNull
    public List<String> getSoftDepend() {
        return softDepend;
    }

    /**
     * 获取应将此插件视为软依赖的插件列表.
     * <ul>
     * <li>使用目标插件 {@link #getName()} 中的值来指定依赖.
     * <li>此插件应在列出的所有其他插件之前加载.
     * <li>在此处指定另一个插件严格等同于让指定插件的 {@link #getSoftDepend()} 包含 {@link #getName() 此插件}.
     * <li><code>loadbefore</code> 必须使用 <a href="https://en.wikipedia.org/wiki/YAML#Lists">YAML 列表格式</a>.
     * </ul>
     * <p>
     * 原文：
     * Gets the list of plugins that should consider this plugin a soft-dependency.
     *
     * @return 应将此插件视为软依赖的插件不可变列表
     */
    @NotNull
    public List<String> getLoadBefore() {
        return loadBefore;
    }

    /**
     * 获取用于插件特定日志消息前缀的标识.
     * <ul>
     * <li>包括所有使用 {@link Plugin#getLogger()} 的消息.
     * <li>如果未指定, 服务器使用插件的 {@link #getName() 名称}.
     * <li>应清楚地指示正在记录的是哪个插件.
     * </ul>
     * <p>
     * 原文：
     * Gives the token to prefix plugin-specific logging messages with.
     *
     * @return 日志前缀标识, 如果未指定则返回 null
     */
    @Nullable
    public String getPrefix() {
        return prefix;
    }

    /**
     * 获取命令名称到命令属性的映射. 此映射中的每个条目对应一个单独的命令, 其各自的值是该命令的属性. 除别名外, 每个属性都可以在运行时使用 {@link PluginCommand} 中的方法定义, 在此处定义仅为方便.
     * <table border=1>
     * <caption>命令部分描述</caption>
     * <tr>
     *     <th>节点</th>
     *     <th>方法</th>
     *     <th>类型</th>
     *     <th>描述</th>
     *     <th>示例</th>
     * </tr><tr>
     *     <td><code>description</code></td>
     *     <td>{@link PluginCommand#setDescription(String)}</td>
     *     <td>String</td>
     *     <td>命令的用户友好描述. 适用于文档编写以及游戏内帮助.</td>
     *     <td><blockquote><pre>description: Set yourself on fire</pre></blockquote></td>
     * </tr><tr>
     *     <td><code>aliases</code></td>
     *     <td>{@link PluginCommand#setAliases(List)}</td>
     *     <td>字符串或字符串 <a href="https://en.wikipedia.org/wiki/YAML#Lists">列表</a></td>
     *     <td>替代命令名称, 对于已注册的命令特别有用. <i>别名在运行时定义无效,</i> 因此插件描述文件是正确定义别名的唯一方式.
     *         <p>
     *         注意: 命令别名中不能包含冒号.</td>
     *     <td>单个别名格式:
     *         <blockquote><pre>aliases: combust_me</pre></blockquote> 或
     *         多个别名格式:
     *         <blockquote><pre>aliases: [combust_me, combustMe]</pre></blockquote></td>
     * </tr><tr>
     *     <td><code>permission</code></td>
     *     <td>{@link PluginCommand#setPermission(String)}</td>
     *     <td>String</td>
     *     <td>使用该命令所需的 {@link Permission} 名称. 没有权限的用户将收到指定消息 (见下方 {@linkplain PluginCommand#setPermissionMessage(String)}), 如果未定义特定消息则使用标准消息. 没有权限节点, 任何 {@link PluginCommand#setExecutor(CommandExecutor) CommandExecutor} 或 {@link PluginCommand#setTabCompleter(TabCompleter)} 都不会被调用.</td>
     *     <td><blockquote><pre>permission: inferno.flagrate</pre></blockquote></td>
     * </tr><tr>
     *     <td><code>permission-message</code></td>
     *     <td>{@link PluginCommand#setPermissionMessage(String)}</td>
     *     <td>String</td>
     *     <td><ul>
     *         <li>显示给尝试使用命令但没有所需权限的玩家. 见上方 {@link PluginCommand#getPermission()}.
     *         <li>&lt;permission&gt; 是一个宏, 会被替换为使用该命令所需的权限节点.
     *         <li>使用空引号是表示不向玩家显示任何内容的有效方式.
     *         </ul></td>
     *     <td><blockquote><pre>permission-message: You do not have /&lt;permission&gt;</pre></blockquote></td>
     * </tr><tr>
     *     <td><code>usage</code></td>
     *     <td>{@link PluginCommand#setUsage(String)}</td>
     *     <td>String</td>
     *     <td>当 {@link PluginCommand#setExecutor(CommandExecutor)} {@linkplain CommandExecutor#onCommand(CommandSender, Command, String, String[]) 返回 false} 时显示此消息. &lt;command&gt; 是一个宏, 会被替换为发出的命令.</td>
     *     <td><blockquote><pre>usage: Syntax error! Perhaps you meant /&lt;command&gt; PlayerName?</pre></blockquote>
     *         值得注意的是, 要在 yaml 中使用冒号, 如 <code>usage: Usage: /god [player]</code>, 需要 <a href="http://yaml.org/spec/current.html#id2503232">用双引号包围消息</a>:
     *         <blockquote><pre>usage: "Usage: /god [player]"</pre></blockquote></td>
     * </tr>
     * </table>
     * 命令以 <a href="http://yaml.org/spec/current.html#id2502325">嵌套映射</a> 层次结构组织. 主 (顶层, 无缩进) 节点是 <code>commands</code>, 每个单独的命令名是缩进的, 表示它映射到某个值 (即上表中的属性).
     * <p>
     * 原文：
     * Gives the map of command-name to command-properties. Each entry in this map corresponds to a single command and the respective values are the properties of the command.
     *
     * @return 此插件将注册的命令
     */
    @NotNull
    public Map<String, Map<String, Object>> getCommands() {
        return commands;
    }

    /**
     * 获取插件将在运行时注册的权限列表, 在启用后立即生效. 定义权限的格式是从权限名称到属性的映射. 要表示没有任何特定属性的映射, 可以使用空花括号 (<code>&#123;&#125;</code>) (与上面的命令不同, 不接受 null 值).
     * <p>
     * 权限的可选属性列表:
     * <table border=1>
     * <caption>权限部分描述</caption>
     * <tr>
     *     <th>节点</th>
     *     <th>描述</th>
     *     <th>示例</th>
     * </tr><tr>
     *     <td><code>description</code></td>
     *     <td>权限用途的明文 (用户友好) 描述.</td>
     *     <td><blockquote><pre>description: Allows you to set yourself on fire</pre></blockquote></td>
     * </tr><tr>
     *     <td><code>default</code></td>
     *     <td>权限的默认状态, 由 {@link Permission#getDefault()} 定义. 如果未定义, 将设置为 {@link PluginDescriptionFile#getPermissionDefault()} 的值.
     *         <p>
     *         参考:<ul>
     *         <li><code>true</code> - 表示对 {@link Permissible 可授权对象} 的正面赋权.
     *         <li><code>false</code> - 表示不对 {@link Permissible 可授权对象} 赋权.
     *         <li><code>op</code> - 表示对 {@link Permissible#isOp() 管理员可授权对象} 的正面赋权.
     *         <li><code>notop</code> - 表示对 {@link Permissible#isOp() 非管理员可授权对象} 的正面赋权.
     *         </ul></td>
     *     <td><blockquote><pre>default: true</pre></blockquote></td>
     * </tr><tr>
     *     <td><code>children</code></td>
     *     <td>允许将其他权限设置为父权限的 {@linkplain Permission#getChildren() 关联} 权限. 当父权限被赋权时, 子权限也会相应地被赋权.
     *         <ul>
     *         <li>当父权限被负面赋权时, 子权限基于其关联关系的反转进行赋权.
     *         <li>当父权限被正面赋权时, 子权限基于其关联关系进行赋权.
     *         </ul>
     *         <p>
     *         子权限可以通过多种方式定义:<ul>
     *         <li>子权限可以定义为名称的 <a href="https://en.wikipedia.org/wiki/YAML#Lists">列表</a>. 使用列表将使所有子权限与其父权限正面关联.
     *         <li>子权限可以定义为映射. 每个权限名称映射到一个布尔值 (表示关联关系) 或一个嵌套的权限定义 (就像另一个权限). 使用嵌套定义将使子权限视为正面关联.
     *         <li>嵌套权限定义必须是这些相同属性的映射. 要定义有效的嵌套权限而不定义任何特定属性, 必须使用空花括号 (<code>&#123;&#125;</code>).
     *          <li>嵌套权限可以拥有自己的嵌套权限作为子权限, 它们也可以有嵌套权限, 依此类推. 权限树的定义深度没有直接限制.
     *         </ul></td>
     *     <td>作为列表:
     *         <blockquote><pre>children: [inferno.flagrate, inferno.burningdeaths]</pre></blockquote>
     *         或作为映射:
     *         <blockquote><pre>children:
     *  inferno.flagrate: true
     *  inferno.burningdeaths: true</pre></blockquote>
     *         展示基本嵌套值的附加示例可在 <a href="doc-files/permissions-example_plugin.yml">此处</a> 查看.
     *         </td>
     * </tr>
     * </table>
     * 权限以 <a href="http://yaml.org/spec/current.html#id2502325">嵌套映射</a> 层次结构组织. 主 (顶层, 无缩进) 节点是 <code>permissions</code>, 每个单独的权限名是缩进的, 表示它映射到某个值 (即上表中的属性).
     * <p>
     * 原文：
     * Gives the list of permissions the plugin will register at runtime, immediately proceding enabling. The format for defining permissions is a map from permission name to properties.
     *
     * @return 此插件将注册的权限
     */
    @NotNull
    public List<Permission> getPermissions() {
        if (permissions == null) {
            if (lazyPermissions == null) {
                permissions = ImmutableList.<Permission>of();
            } else {
                permissions = ImmutableList.copyOf(Permission.loadPermissions(lazyPermissions, "Permission node '%s' in plugin description file for " + getFullName() + " is invalid", defaultPerm));
                lazyPermissions = null;
            }
        }
        return permissions;
    }

    /**
     * 获取插件注册权限的默认 {@link Permission#getDefault() 默认} 状态.
     * <ul>
     * <li>如果未指定, 将为 {@link PermissionDefault#OP}.
     * <li>使用 {@link PermissionDefault#getByName(String)} 进行匹配.
     * <li>仅影响未定义 <code>default</code> 节点的权限.
     * <li>可以是 {@link PermissionDefault} 中的任何值.
     * </ul>
     * <p>
     * 原文：
     * Gives the default default state of permissions registered for the plugin.
     *
     * @return 插件权限的默认值
     */
    @NotNull
    public PermissionDefault getPermissionDefault() {
        return defaultPerm;
    }

    /**
     * 获取插件的每个 {@link PluginAwareness} 集合. 感知表示插件开发者在编译插件时所确认的内容. 某些实现可能定义了 API 中未包含的额外感知. 任何未识别的感知 (不支持的或未来版本中的) 将导致创建一个虚拟对象, 而不是失败.
     * <ul>
     * <li>目前仅支持 {@link PluginAwareness.Flags} 中的枚举值.
     * <li>每个感知以 bang-at (<code>!@</code>) 开头作为标识符.
     * <li>未识别的 (未来的/未实现的) 条目会被静默替换为实现了 PluginAwareness 的通用对象.
     * <li>感知类型必须由运行时定义并由 API 确认, 实际上排除了任何插件类路径中的派生类型.
     * <li><code>awareness</code> 必须使用 <a href="https://en.wikipedia.org/wiki/YAML#Lists">YAML 列表格式</a>.
     * </ul>
     * <p>
     * 原文：
     * Gives a set of every PluginAwareness for a plugin. An awareness dictates something that a plugin developer acknowledges when the plugin is compiled.
     *
     * @return 包含插件每个感知的集合
     */
    @NotNull
    public Set<PluginAwareness> getAwareness() {
        return awareness;
    }

    /**
     * 返回插件的名称, 包括版本. 此方法为便捷方法, 使用 {@link #getName()} 和 {@link #getVersion()} 条目.
     * <p>
     * 原文：
     * Returns the name of a plugin, including the version. This method is provided for convenience; it uses the getName() and getVersion() entries.
     *
     * @return 插件及其版本的描述性名称
     */
    @NotNull
    public String getFullName() {
        return name + " v" + version;
    }

    /**
     * 获取此插件设计支持的 API 版本. 不保证特定格式.
     * <ul>
     * <li>有关支持的 API 版本, 请参阅发行说明.
     * </ul>
     * <p>
     * 原文：
     * Gives the API version which this plugin is designed to support. No specific format is guaranteed.
     *
     * @return 插件的 API 版本
     */
    @Nullable
    public String getAPIVersion() {
        return apiVersion;
    }

    /**
     * 获取此插件所需的类库. 这是一个预览功能.
     * <ul>
     * <li>类库必须是 GAV 说明符, 从 Maven Central 加载.
     * </ul>
     * <p>
     * 原文：
     * Gets the libraries this plugin requires. This is a preview feature.
     *
     * @return 所需的类库
     */
    @NotNull
    public List<String> getLibraries() {
        return libraries;
    }

    /**
     * @return unused
     * @deprecated unused
     */
    @Deprecated(since = "1.7.2")
    @Nullable
    public String getClassLoaderOf() {
        return classLoaderOf;
    }

    /**
     * 将此 PluginDescriptionFile 保存到给定的 writer.
     * <p>
     * 原文：
     * Saves this PluginDescriptionFile to the given writer
     *
     * @param writer 输出此文件的 Writer 对象
     */
    public void save(@NotNull Writer writer) {
        YAML.get().dump(saveMap(), writer);
    }

    private void loadMap(@NotNull Map<?, ?> map) throws InvalidDescriptionException {
        try {
            name = rawName = map.get("name").toString();

            if (!VALID_NAME.matcher(name).matches()) {
                throw new InvalidDescriptionException("name '" + name + "' contains invalid characters.");
            }
            name = name.replace(' ', '_');
        } catch (NullPointerException ex) {
            throw new InvalidDescriptionException(ex, "name is not defined");
        } catch (ClassCastException ex) {
            throw new InvalidDescriptionException(ex, "name is of wrong type");
        }

        provides = makePluginNameList(map, "provides");

        try {
            version = map.get("version").toString();
        } catch (NullPointerException ex) {
            throw new InvalidDescriptionException(ex, "version is not defined");
        } catch (ClassCastException ex) {
            throw new InvalidDescriptionException(ex, "version is of wrong type");
        }

        try {
            main = map.get("main").toString();
            if (main.startsWith("org.bukkit.")) {
                throw new InvalidDescriptionException("main may not be within the org.bukkit namespace");
            }
        } catch (NullPointerException ex) {
            throw new InvalidDescriptionException(ex, "main is not defined");
        } catch (ClassCastException ex) {
            throw new InvalidDescriptionException(ex, "main is of wrong type");
        }

        if (map.get("commands") != null) {
            ImmutableMap.Builder<String, Map<String, Object>> commandsBuilder = ImmutableMap.<String, Map<String, Object>>builder();
            try {
                for (Map.Entry<?, ?> command : ((Map<?, ?>) map.get("commands")).entrySet()) {
                    ImmutableMap.Builder<String, Object> commandBuilder = ImmutableMap.<String, Object>builder();
                    if (command.getValue() != null) {
                        for (Map.Entry<?, ?> commandEntry : ((Map<?, ?>) command.getValue()).entrySet()) {
                            if (commandEntry.getValue() instanceof Iterable) {
                                // This prevents internal alias list changes
                                ImmutableList.Builder<Object> commandSubList = ImmutableList.<Object>builder();
                                for (Object commandSubListItem : (Iterable<?>) commandEntry.getValue()) {
                                    if (commandSubListItem != null) {
                                        commandSubList.add(commandSubListItem);
                                    }
                                }
                                commandBuilder.put(commandEntry.getKey().toString(), commandSubList.build());
                            } else if (commandEntry.getValue() != null) {
                                commandBuilder.put(commandEntry.getKey().toString(), commandEntry.getValue());
                            }
                        }
                    }
                    commandsBuilder.put(command.getKey().toString(), commandBuilder.build());
                }
            } catch (ClassCastException ex) {
                throw new InvalidDescriptionException(ex, "commands are of wrong type");
            }
            commands = commandsBuilder.build();
        }

        if (map.get("class-loader-of") != null) {
            classLoaderOf = map.get("class-loader-of").toString();
        }

        depend = makePluginNameList(map, "depend");
        softDepend = makePluginNameList(map, "softdepend");
        loadBefore = makePluginNameList(map, "loadbefore");

        if (map.get("website") != null) {
            website = map.get("website").toString();
        }

        if (map.get("description") != null) {
            description = map.get("description").toString();
        }

        if (map.get("load") != null) {
            try {
                order = PluginLoadOrder.valueOf(((String) map.get("load")).toUpperCase(Locale.ROOT).replaceAll("\\W", ""));
            } catch (ClassCastException ex) {
                throw new InvalidDescriptionException(ex, "load is of wrong type");
            } catch (IllegalArgumentException ex) {
                throw new InvalidDescriptionException(ex, "load is not a valid choice");
            }
        }

        if (map.get("authors") != null) {
            ImmutableList.Builder<String> authorsBuilder = ImmutableList.<String>builder();
            if (map.get("author") != null) {
                authorsBuilder.add(map.get("author").toString());
            }
            try {
                for (Object o : (Iterable<?>) map.get("authors")) {
                    authorsBuilder.add(o.toString());
                }
            } catch (ClassCastException ex) {
                throw new InvalidDescriptionException(ex, "authors are of wrong type");
            } catch (NullPointerException ex) {
                throw new InvalidDescriptionException(ex, "authors are improperly defined");
            }
            authors = authorsBuilder.build();
        } else if (map.get("author") != null) {
            authors = ImmutableList.of(map.get("author").toString());
        } else {
            authors = ImmutableList.<String>of();
        }

        if (map.get("contributors") != null) {
            ImmutableList.Builder<String> contributorsBuilder = ImmutableList.<String>builder();
            try {
                for (Object o : (Iterable<?>) map.get("contributors")) {
                    contributorsBuilder.add(o.toString());
                }
            } catch (ClassCastException ex) {
                throw new InvalidDescriptionException(ex, "contributors are of wrong type");
            }
            contributors = contributorsBuilder.build();
        } else {
            contributors = ImmutableList.<String>of();
        }

        if (map.get("default-permission") != null) {
            try {
                defaultPerm = PermissionDefault.getByName(map.get("default-permission").toString());
            } catch (ClassCastException ex) {
                throw new InvalidDescriptionException(ex, "default-permission is of wrong type");
            } catch (IllegalArgumentException ex) {
                throw new InvalidDescriptionException(ex, "default-permission is not a valid choice");
            }
        }

        if (map.get("awareness") instanceof Iterable) {
            Set<PluginAwareness> awareness = new HashSet<PluginAwareness>();
            try {
                for (Object o : (Iterable<?>) map.get("awareness")) {
                    awareness.add((PluginAwareness) o);
                }
            } catch (ClassCastException ex) {
                throw new InvalidDescriptionException(ex, "awareness has wrong type");
            }
            this.awareness = ImmutableSet.copyOf(awareness);
        }

        if (map.get("api-version") != null) {
            apiVersion = map.get("api-version").toString();
        }

        if (map.get("libraries") != null) {
            ImmutableList.Builder<String> contributorsBuilder = ImmutableList.<String>builder();
            try {
                for (Object o : (Iterable<?>) map.get("libraries")) {
                    contributorsBuilder.add(o.toString());
                }
            } catch (ClassCastException ex) {
                throw new InvalidDescriptionException(ex, "libraries are of wrong type");
            }
            libraries = contributorsBuilder.build();
        } else {
            libraries = ImmutableList.<String>of();
        }

        try {
            lazyPermissions = (Map<?, ?>) map.get("permissions");
        } catch (ClassCastException ex) {
            throw new InvalidDescriptionException(ex, "permissions are of the wrong type");
        }

        if (map.get("prefix") != null) {
            prefix = map.get("prefix").toString();
        }
    }

    @NotNull
    private static List<String> makePluginNameList(@NotNull final Map<?, ?> map, @NotNull final String key) throws InvalidDescriptionException {
        final Object value = map.get(key);
        if (value == null) {
            return ImmutableList.of();
        }

        final ImmutableList.Builder<String> builder = ImmutableList.<String>builder();
        try {
            for (final Object entry : (Iterable<?>) value) {
                builder.add(entry.toString().replace(' ', '_'));
            }
        } catch (ClassCastException ex) {
            throw new InvalidDescriptionException(ex, key + " is of wrong type");
        } catch (NullPointerException ex) {
            throw new InvalidDescriptionException(ex, "invalid " + key + " format");
        }
        return builder.build();
    }

    @NotNull
    private Map<String, Object> saveMap() {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("name", name);
        if (provides != null) {
            map.put("provides", provides);
        }
        map.put("main", main);
        map.put("version", version);
        map.put("order", order.toString());
        map.put("default-permission", defaultPerm.toString());

        if (commands != null) {
            map.put("command", commands);
        }
        if (depend != null) {
            map.put("depend", depend);
        }
        if (softDepend != null) {
            map.put("softdepend", softDepend);
        }
        if (website != null) {
            map.put("website", website);
        }
        if (description != null) {
            map.put("description", description);
        }

        if (authors.size() == 1) {
            map.put("author", authors.get(0));
        } else if (authors.size() > 1) {
            map.put("authors", authors);
        }

        if (contributors != null) {
            map.put("contributors", contributors);
        }

        if (apiVersion != null) {
            map.put("api-version", apiVersion);
        }

        if (libraries != null) {
            map.put("libraries", libraries);
        }

        if (classLoaderOf != null) {
            map.put("class-loader-of", classLoaderOf);
        }

        if (prefix != null) {
            map.put("prefix", prefix);
        }

        return map;
    }

    @NotNull
    private Map<?, ?> asMap(@NotNull Object object) throws InvalidDescriptionException {
        if (object instanceof Map) {
            return (Map<?, ?>) object;
        }
        throw new InvalidDescriptionException("Plugin description file is empty or not properly structured. Is " + object + "but should be a map.");
    }

    /**
     * @return internal use
     * @apiNote Internal use
     */
    @ApiStatus.Internal
    @NotNull
    public String getRawName() {
        return rawName;
    }
}