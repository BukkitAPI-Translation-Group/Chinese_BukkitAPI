package org.bukkit.configuration;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//未完成翻译: 魔法值@12020113
//汉化未完成: 魔法值@11110154
//格式整理到: 完成
/**
 * {@link Configuration}的基类. 
 * 所有用于扩展配置文件读取的类都应当实现以下方法. 
 * <p>
 * Represents a section of a {@link Configuration}
 */
public interface ConfigurationSection {

    /**
     * 获取此配置文件的键集合. 
     * <p>
     * 如果为 true, 则返回包括所有的能访问到的键的集合. 
     * 类似于获取硬盘中第一层目录还是遍历全部子目录. 
     * <p>
     * 例如:
     * <p>
     * top1. Second1
     * <p>
     * top1. Second2
     * <p>
     * top2. Second1
     * <p>
     * top2. Second2
     * <p>原文: 
     * Gets a set containing all keys in this section. 
     * <p>
     * If deep is set to true, then this will contain all the keys within any child {@link ConfigurationSection}s (and their children, etc). 
     * These will be in a valid path notation for you to use. 
     * <p>
     * If deep is set to false, then this will contain only the keys of any direct children, and not their own children. 
     *
     * @param deep 获取全部键, 或者仅仅获取表层键. 
     * @return 将返回一个 set, 装载着符合要求的键. 
     */
    @NotNull
    public Set<String> getKeys(boolean deep);

    /**
     * 获取这个配置文件的键值集合. 
     * <p>
     * 如果为 true, 则返回包括所有的能访问到的键和值的集合. 
     * 类似于获取硬盘中第一层目录还是遍历全部子目录. 
     * <p>
     * 如果为 false, 则返回表层的键和值的集合. 
     * <p>原文: 
     * Gets a Map containing all keys and their values for this section. 
     * <p>
     * If deep is set to true, then this will contain all the keys and values within any child {@link ConfigurationSection}s (and their children, etc). 
     * These keys will be in a valid path notation for you to use. 
     * <p>
     * If deep is set to false, then this will contain only the keys and values of any direct children, and not their own children. 
     *
     * @param deep 获取全部键值集合(true), 或者仅仅获取表层键值集合(false). 
     * @return 返回一个 Map. 
     */
    @NotNull
    public Map<String, Object> getValues(boolean deep);

    /**
     * 检查 {@link ConfigurationSection} 是否包含指定路径. 
     * <p>
     * 如果这个路径不存在, 但已指定一个缺省值, 也将返回 true. 
     * <p>原文: 
     * Checks if this {@link ConfigurationSection} contains the given path. 
     * <p>
     * If the value for the requested path does not exist but a default value has been specified, this will return true. 
     *
     * @param path 要检查的路径
     * @return 如果此部分包含请求的路径，可以通过默认的或者被设置. 
     * @throws IllegalArgumentException 如果路径是 null 时抛出此异常. 
     */
    public boolean contains(@NotNull String path);

    /**
     * Checks if this {@link ConfigurationSection} contains the given path.
     * <p>
     * If the value for the requested path does not exist, the boolean parameter
     * of true has been specified, a default value for the path exists, this
     * will return true.
     * <p>
     * If a boolean parameter of false has been specified, true will only be
     * returned if there is a set value for the specified path.
     *
     * @param path Path to check for existence.
     * @param ignoreDefault Whether or not to ignore if a default value for the
     * specified path exists.
     * @return True if this section contains the requested path, or if a default
     * value exist and the boolean parameter for this method is true.
     * @throws IllegalArgumentException Thrown when path is null.
     */
    public boolean contains(@NotNull String path, boolean ignoreDefault);

    /**
     * 检查指定路径是否是 Set. 
     * <p>
     * 如果路径存在, 但不是 Set, 则返回 false. 
     * <p>
     * 如果路径不存在, 则返回 false. 
     * <p>
     * 如果路径不存在, 但在缺省列表中存在该路径, 则在缺省列表中重复匹配该规则, 直到返回一个适当的值. 
     * <p>原文: 
     * Checks if this {@link ConfigurationSection} has a value set for the given path. 
     * <p>
     * If the value for the requested path does not exist but a default value has been specified, this will still return false. 
     *
     * @param path 检查路径.
     * @return True if this section contains the requested path, regardless of having a default. 
     * @throws IllegalArgumentException 如果路径为 null 则会抛出此异常. 
     *///魔法值@12020113
    public boolean isSet(@NotNull String path);

    /**
     * 从根 {@link Configuration} 中获取这个 {@link ConfigurationSection} 的路径. 
     * <p>
     * 如果这个 {@link ConfigurationSection} 已经是根目录, 将返回一个空字符串.
     * <p>
     * 如果这个 {@link ConfigurationSection} 不属于任何根目录, 将返回 null.
     * <p>
     * 如果要获取这个 {@link ConfigurationSection} 名字,也就是路径中的最后一节, 你应该使用 {@link #getName()} 来获取.
     * <p>原文: 
     * Gets the path of this {@link ConfigurationSection} from its root {@link Configuration}.
     * <p>
     * For any {@link Configuration} themselves, this will return an empty string. 
     * <p>
     * If the section is no longer contained within its root for any reason, such as being replaced with a different value, this may return null. 
     * <p>
     * To retrieve the single name of this section, that is, the final part of the path returned by this method, you may use {@link #getName()}. 
     *
     * @return 这个片段相对于其根的路径.
     */
    @Nullable
    public String getCurrentPath();

    /**
     * Gets the name of this individual {@link ConfigurationSection}, in the path. 
     * <p>
     * This will always be the final part of {@link #getCurrentPath()}, unless the section is orphaned. 
     *
     * @return Name of this section
     *///魔法值@11110154
    @NotNull
    public String getName();

    /**
     * Gets the root {@link Configuration} that contains this {@link ConfigurationSection}
     * <p>
     * For any {@link Configuration} themselves, this will return its own object. 
     * <p>
     * If the section is no longer contained within its root for any reason, such as being replaced with a different value, this may return null. 
     *
     * @return Root configuration containing this section. 
     */
    @Nullable
    public Configuration getRoot();

    /**
     * Gets the parent {@link ConfigurationSection} that directly contains this {@link ConfigurationSection}. 
     * <p>
     * For any {@link Configuration} themselves, this will return null. 
     * <p>
     * If the section is no longer contained within its parent for any reason, such as being replaced with a different value, this may return null. 
     *
     * @return Parent section containing this section. 
     */
    @Nullable
    public ConfigurationSection getParent();

    /**
     * 在指定路径获取一个 Object 类型的值. 
     * <p>
     * 如果这个 Object 不存在, 但已指定一个缺省值, 这将返回缺省值. 
     * <p>
     * 如果这个 Object 不存在, 并且没有指定缺省值, 则返回 null. 
     * <p>原文: 
     * Gets the requested Object by path. 
     * <p>
     * If the Object does not exist but a default value has been specified, this will return the default value. 
     * If the Object does not exist and no default value was specified, this will return null. 
     *
     * @param path 获取 Object 的路径. 
     * @return 返回一个 Object. 
     */
    @Nullable
    public Object get(@NotNull String path);

    /**
     * 在指定路径上获取一个 Object , 如果无法获取, 则直接返回默认值. 
     * <p>
     * 如果 Object 无法在 {@link Configuration} 中被获取, 则不会尝试去缺省列表中去寻找, 而是直接返回指定的默认值. 
     * <p>原文: 
     * Gets the requested Object by path, returning a default value if not found. 
     * <p>
     * If the Object does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}. 
     *
     * @param path 获取 Object 的路径. 
     * @param def 当指定路径上没有值, 返回这个值. 
     * @return 返回一个Object. 
     */
    @Contract("_, !null -> !null")
    @Nullable
    public Object get(@NotNull String path, @Nullable Object def);

    /**
     * Sets the specified path to the given value. 
     * <p>
     * If value is null, the entry will be removed. 
     * Any existing entry will be replaced, regardless of what the new value is. 
     * <p>
     * Some implementations may have limitations on what you may store. 
     * See their individual javadocs for details. 
     * No implementations should allow you to store {@link Configuration}s or {@link ConfigurationSection}s, please use {@link #createSection(java.lang.String)} for that. 
     *
     * @param path Path of the object to set. 
     * @param value New value to set the path to. 
     */
    public void set(@NotNull String path, @Nullable Object value);

    /**
     * Creates an empty {@link ConfigurationSection} at the specified path. 
     * <p>
     * Any value that was previously set at this path will be overwritten. 
     * If the previous value was itself a {@link ConfigurationSection}, it will be orphaned. 
     *
     * @param path Path to create the section at. 
     * @return Newly created section
     */
    @NotNull
    public ConfigurationSection createSection(@NotNull String path);

    /**
     * Creates a {@link ConfigurationSection} at the specified path, with specified values. 
     * <p>
     * Any value that was previously set at this path will be overwritten. 
     * If the previous value was itself a {@link ConfigurationSection}, it will be orphaned. 
     *
     * @param path Path to create the section at. 
     * @param map The values to used. 
     * @return Newly created section
     */
    @NotNull
    public ConfigurationSection createSection(@NotNull String path, @NotNull Map<?, ?> map);

    // Primitives
    /**
     * 在指定路径获取一个 String 类型的值. 
     * <p>
     * 如果这个 String 不存在, 但已指定一个缺省值, 这将返回缺省值. 
     * <p>
     * 如果这个 String 不存在, 并且没有指定缺省值, 则返回 null. 
     * <p>原文: 
     * Gets the requested String by path. 
     * <p>
     * If the String does not exist but a default value has been specified, this will return the default value. 
     * If the String does not exist and no default value was specified, this will return null. 
     *
     * @param path 获取 String 的路径. 
     * @return 返回一个 String. 
     *///魔法值@11110152
    @Nullable
    public String getString(@NotNull String path);

    /**
     * 在指定路径上获取一个 String , 如果无法获取, 则直接返回默认值. 
     * <p>
     * 如果无法获取到一个 String, 将不会尝试去缺省列表中去获取, 而是直接返回指定的默认值. 
     * <p>原文: 
     * Gets the requested String by path, returning a default value if not found. 
     * <p>
     * If the String does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}. 
     *
     * @param path 获取 String 的路径. 
     * @param def 当指定路径上没有值, 或者不是 String 类型时, 返回这个值. 
     * @return 返回一个 String. 
     */
    @Contract("_, !null -> !null")
    @Nullable
    public String getString(@NotNull String path, @Nullable String def);

    /**
     * 检查指定路径是否是 String. 
     * <p>
     * 如果路径存在, 但不是 String, 则返回 false. 
     * <p>
     * 如果路径不存在, 则返回 false. 
     * <p>
     * 如果路径不存在, 但在缺省列表中存在该路径, 则在缺省列表中重复匹配该规则, 直到返回一个适当的值. 
     * <p>原文: 
     * Checks if the specified path is a String. 
     * <p>
     * If the path exists but is not a String, this will return false. 
     * If the path does not exist, this will return false. 
     * If the path does not exist but a default value has been specified, this will check if that default value is a String and return appropriately. 
     *
     * @param path 检查指定路径是否是 String. 
     * @return 指定路径是否是 String. 
     */
    public boolean isString(@NotNull String path);

    /**
     * 在指定路径获取一个 int 类型的值. 
     * <p>
     * 如果这个 int 不存在, 但已指定一个缺省值, 这将返回缺省值.
     * <p>
     * 如果这个 int 不存在, 并且没有指定缺省值, 则返回 0 . 
     * <p>原文: 
     * Gets the requested int by path. 
     * <p>
     * If the int does not exist but a default value has been specified, this will return the default value. 
     * If the int does not exist and no default value was specified, this will return 0. 
     *
     * @param path 获取 int 的路径. 
     * @return 返回一个 int. 
     */
    public int getInt(@NotNull String path);

    /**
     * 在指定路径上获取一个 int, 如果无法获取, 则直接返回默认值. 
     * <p>
     * 如果无法获取到一个 int, 将不会尝试去缺省列表中去获取, 而是直接返回指定的默认值. 
     * <p>原文: 
     * Gets the requested int by path, returning a default value if not found. 
     * <p>
     * If the int does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}. 
     *
     * @param path 获取 int 的路径. 
     * @param def 当指定路径上没有值, 或者不是 int 类型时, 返回这个值. 
     * @return 返回一个 int. 
     */
    public int getInt(@NotNull String path, int def);

    /**
     * 检查指定路径是否是 int. 
     * <p>
     * 如果路径存在, 但不是 int, 则返回 false. 
     * <p>
     * 如果路径不存在, 则返回 false. 
     * <p>
     * 如果路径不存在, 但在缺省列表中存在该路径, 则在缺省列表中重复匹配该规则, 直到返回一个适当的值. 
     * <p>原文: 
     * Checks if the specified path is a int. 
     * <p>
     * If the path exists but is not a int, this will return false. 
     * If the path does not exist, this will return false. 
     * If the path does not exist but a default value has been specified, this will check if that default value is a int and return appropriately. 
     *
     * @param path 检查指定路径是否是 int. 
     * @return 指定路径是否是 int. 
     */
    public boolean isInt(@NotNull String path);

    /**
     * 在指定路径获取一个 boolean 类型的值. 
     * <p>
     * 如果这个 boolean 不存在, 但已指定一个缺省值, 这将返回缺省值.
     * <p>
     * 如果这个 boolean 不存在, 并且没有指定缺省值, 则返回 false. 
     * <p>原文: 
     * Gets the requested boolean by path. 
     * <p>
     * If the boolean does not exist but a default value has been specified, this will return the default value. 
     * If the boolean does not exist and no default value was specified, this will return false. 
     *
     * @param path 获取 boolean 的路径. 
     * @return 返回一个 boolean. 
     */
    public boolean getBoolean(@NotNull String path);

    /**
     * 在指定路径上获取一个 boolean, 如果无法获取, 则直接返回默认值. 
     * <p>
     * 如果无法获取到一个 boolean, 将不会尝试去缺省列表中去获取, 而是直接返回指定的默认值. 
     * <p>原文: 
     * Gets the requested boolean by path, returning a default value if not found. 
     * <p>
     * If the boolean does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}. 
     *
     * @param path 获取 boolean 的路径. 
     * @param def 当指定路径上没有值, 或者不是 boolean 类型时, 返回这个值. 
     * @return 返回一个 boolean. 
     */
    public boolean getBoolean(@NotNull String path, boolean def);

    /**
     * 检查指定路径是否是 boolean. 
     * <p>
     * 如果路径存在, 但不是 boolean, 则返回 false. 
     * <p>
     * 如果路径不存在, 则返回 false. 
     * <p>
     * 如果路径不存在, 但在缺省列表中存在该路径, 则在缺省列表中重复匹配该规则, 直到返回一个适当的值. 
     * <p>原文: 
     * Checks if the specified path is a boolean. 
     * <p>
     * If the path exists but is not a boolean, this will return false. 
     * If the path does not exist, this will return false. 
     * If the path does not exist but a default value has been specified, this will check if that default value is a boolean and return appropriately. 
     *
     * @param path 检查指定路径是否是 boolean. 
     * @return 指定路径是否是 boolean. 
     */
    public boolean isBoolean(@NotNull String path);

    /**
     * 在指定路径获取一个 double 类型的值. 
     * <p>
     * 如果这个 double 不存在, 但已指定一个缺省值, 这将返回缺省值.
     * <p>
     * 如果这个 double 不存在, 并且没有指定缺省值, 则返回0. 
     * <p>原文: 
     * Gets the requested double by path. 
     * <p>
     * If the double does not exist but a default value has been specified, this will return the default value. 
     * If the double does not exist and no default value was specified, this will return 0. 
     *
     * @param path 获取double的路径. 
     * @return 返回一个double. 
     */
    public double getDouble(@NotNull String path);

    /**
     * 在指定路径上获取一个double, 如果无法获取, 则直接返回默认值. 
     * <p>
     * 如果无法获取到一个 double, 将不会尝试去缺省列表中去获取, 而是直接返回指定的默认值. 
     * <p>原文: 
     * Gets the requested double by path, returning a default value if not found. 
     * <p>
     * If the double does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}. 
     *
     * @param path 获取 double 的路径. 
     * @param def 当指定路径上没有值, 或者不是 double 类型时, 返回这个值. 
     * @return 返回一个 double. 
     */
    public double getDouble(@NotNull String path, double def);

    /**
     * 检查指定路径是否是 double. 
     * <p>
     * 如果路径存在, 但不是 double, 则返回 false. 
     * <p>
     * 如果路径不存在, 则返回 false. 
     * <p>
     * 如果路径不存在, 但在缺省列表中存在该路径, 则在缺省列表中重复匹配该规则, 直到返回一个适当的值. 
     * <p>原文: 
     * Checks if the specified path is a double. 
     * <p>
     * If the path exists but is not a double, this will return false. 
     * If the path does not exist, this will return false. 
     * If the path does not exist but a default value has been specified, this will check if that default value is a double and return appropriately. 
     *
     * @param path 检查指定路径是否是 double. 
     * @return 指定路径是否是 double. 
     */
    public boolean isDouble(@NotNull String path);

    /**
     * 在指定路径获取一个 long 类型的值. 
     * <p>
     * 如果这个 long 不存在, 但已指定一个缺省值, 这将返回缺省值.
     * <p>
     * 如果这个 long 不存在, 并且没有指定缺省值, 则返回 0. 
     * <p>原文: 
     * Gets the requested long by path. 
     * <p>
     * If the long does not exist but a default value has been specified, this will return the default value. 
     * If the long does not exist and no default value was specified, this will return 0. 
     *
     * @param path 获取long的路径. 
     * @return 返回一个long. 
     */
    public long getLong(@NotNull String path);

    /**
     * 在指定路径上获取一个 long, 如果无法获取, 则直接返回默认值. 
     * <p>
     * 如果无法获取到一个 long, 将不会尝试去缺省列表中去获取, 而是直接返回指定的默认值. 
     * <p>原文: 
     * Gets the requested long by path, returning a default value if not found. 
     * <p>
     * If the long does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}. 
     *
     * @param path 获取 long 的路径. 
     * @param def 当指定路径上没有值, 或者不是 long 类型时, 返回这个值. 
     * @return 返回一个 long. 
     */
    public long getLong(@NotNull String path, long def);

    /**
     * 检查指定路径是否是 long. 
     * <p>
     * 如果路径存在, 但不是 long, 则返回 false. 
     * <p>
     * 如果路径不存在, 则返回 false. 
     * <p>
     * 如果路径不存在, 但在缺省列表中存在该路径, 则在缺省列表中重复匹配该规则, 直到返回一个适当的值. 
     * <p>原文: 
     * Checks if the specified path is a long. 
     * <p>
     * If the path exists but is not a long, this will return false. 
     * If the path does not exist, this will return false. 
     * If the path does not exist but a default value has been specified, this will check if that default value is a long and return appropriately. 
     *
     * @param path 检查指定路径是否是 long. 
     * @return 指定路径是否是 long. 
     */
    public boolean isLong(@NotNull String path);

    // Java
    /**
     * 在指定路径获取一个 List 类型的值. 
     * <p>
     * 如果这个 List 不存在, 但已指定一个缺省值, 这将返回缺省值. 
     * <p>
     * 如果这个 List 不存在, 并且没有指定缺省值, 则返回 null. 
     * <p>原文: 
     * Gets the requested List by path. 
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value. 
     * If the List does not exist and no default value was specified, this will return null. 
     *
     * @param path 获取 List 的路径. 
     * @return 返回一个 List. 
     */
    @Nullable
    public List<?> getList(@NotNull String path);

    /**
     * 在指定路径上获取一个 List, 如果无法获取, 则直接返回默认值. 
     * <p>
     * 如果无法获取到一个 List, 将不会尝试去缺省列表中去获取, 而是直接返回指定的默认值. 
     * <p>原文: 
     * Gets the requested List by path, returning a default value if not found. 
     * <p>
     * If the List does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}. 
     *
     * @param path 获取 List 的路径. 
     * @param def 当指定路径上没有值, 或者不是 List 类型时, 返回这个值. 
     * @return 返回一个 List. 
     */
    @Contract("_, !null -> !null")
    @Nullable
    public List<?> getList(@NotNull String path, @Nullable List<?> def);

    /**
     * 检查指定路径是否是 List. 
     * <p>
     * 如果路径存在, 但不是 List, 则返回 false. 
     * <p>
     * 如果路径不存在, 则返回 false. 
     * <p>
     * 如果路径不存在, 但在缺省列表中存在该路径, 则在缺省列表中重复匹配该规则, 直到返回一个适当的值. 
     * <p>原文: 
     * Checks if the specified path is a List. 
     * <p>
     * If the path exists but is not a List, this will return false. 
     * If the path does not exist, this will return false. 
     * If the path does not exist but a default value has been specified, this will check if that default value is a List and return appropriately. 
     *
     * @param path 检查指定路径是否是 List. 
     * @return 指定路径是否是 List. 
     */
    public boolean isList(@NotNull String path);

    /**
     * 在指定路径获取一个 List&lt;String&gt;. 
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值. 
     * <p>
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表. 
     * <p>
     * 此方法会尽可能的将 List 中所有的项转化为 String, 但是如果值本身不兼容, 将会发生不可预计的状况. 
     * <p>原文: 
     * Gets the requested List of String by path. 
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value. 
     * If the List does not exist and no default value was specified, this will return an empty List. 
     * <p>
     * This method will attempt to cast any values into a String if possible, but may miss any values out if they are not compatible. 
     *
     * @param path 要获取 List&lt;String&gt; 的路径. 
     * @return 返回一个 List&lt;String&gt;. 
     */
    @NotNull
    public List<String> getStringList(@NotNull String path);

    /**
     * 在指定路径获取一个 List&lt;Integer&gt;. 
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值. 
     * <p>
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表. 
     * <p>
     * 此方法会尽可能的将 List 中所有的项转化为 Integer, 但是如果值本身不兼容, 将会发生不可预计的状况. 
     * <p>原文: 
     * Gets the requested List of Integer by path. 
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value. 
     * If the List does not exist and no default value was specified, this will return an empty List. 
     * <p>
     * This method will attempt to cast any values into a Integer if possible, but may miss any values out if they are not compatible. 
     *
     * @param path 要获取 List&lt;Integer&gt; 的路径. 
     * @return 返回一个 List&lt;Integer&gt;. 
     */
    @NotNull
    public List<Integer> getIntegerList(@NotNull String path);

    /**
     * 在指定路径获取一个 List&lt;Boolean&gt;. 
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值. 
     * <p>
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表. 
     * <p>
     * 此方法会尽可能的将 List 中所有的项转化为 Boolean, 但是如果值本身不兼容, 将会发生不可预计的状况. 
     * <p>原文: 
     * Gets the requested List of Boolean by path. 
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value. 
     * If the List does not exist and no default value was specified, this will return an empty List. 
     * <p>
     * This method will attempt to cast any values into a Boolean if possible, but may miss any values out if they are not compatible. 
     *
     * @param path 要获取 List&lt;Boolean&gt; 的路径. 
     * @return 返回一个 List&lt;Boolean&gt;. 
     */
    @NotNull
    public List<Boolean> getBooleanList(@NotNull String path);

    /**
     * 在指定路径获取一个 List&lt;Double&gt;. 
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值. 
     * <p>
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表. 
     * <p>
     * 此方法会尽可能的将 List 中所有的项转化为 Double, 但是如果值本身不兼容, 将会发生不可预计的状况. 
     * <p>原文: 
     * Gets the requested List of Double by path. 
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value. 
     * If the List does not exist and no default value was specified, this will return an empty List. 
     * <p>
     * This method will attempt to cast any values into a Double if possible, but may miss any values out if they are not compatible. 
     *
     * @param path 要获取 List&lt;Double&gt;的路径. 
     * @return 要获取 List&lt;Double&gt;. 
     */
    @NotNull
    public List<Double> getDoubleList(@NotNull String path);

    /**
     * 在指定路径获取一个 List&lt;Float&gt;. 
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值. 
     * <p>
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表. 
     * <p>
     * 此方法会尽可能的将 List 中所有的项转化为 Float, 但是如果值本身不兼容, 将会发生不可预计的状况. 
     * <p>原文: 
     * Gets the requested List of Float by path. 
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value. 
     * If the List does not exist and no default value was specified, this will return an empty List. 
     * <p>
     * This method will attempt to cast any values into a Float if possible, but may miss any values out if they are not compatible. 
     *
     * @param path 要获取 List&lt;Float&gt;的路径. 
     * @return 返回一个 List&lt;Float&gt;. 
     */
    @NotNull
    public List<Float> getFloatList(@NotNull String path);

    /**
     * 在指定路径获取一个 List&lt;Long&gt;. 
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值. 
     * <p>
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表. 
     * <p>
     * 此方法会尽可能的将 List 中所有的项转化为Long, 但是如果值本身不兼容, 将会发生不可预计的状况. 
     * <p>原文: 
     * Gets the requested List of Long by path. 
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value. 
     * If the List does not exist and no default value was specified, this will return an empty List. 
     * <p>
     * This method will attempt to cast any values into a Long if possible, but may miss any values out if they are not compatible. 
     *
     * @param path 要获取 List&lt;Long&gt;的路径. 
     * @return 返回一个 List&lt;Long&gt;. 
     */
    @NotNull
    public List<Long> getLongList(@NotNull String path);

    /**
     * 在指定路径获取一个 List&lt;Byte&gt;. 
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值. 
     * <p>
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表. 
     * <p>
     * 此方法会尽可能的将 List 中所有的项转化为 Byte, 但是如果值本身不兼容, 将会发生不可预计的状况. 
     * <p>原文: 
     * Gets the requested List of Byte by path. 
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value. 
     * If the List does not exist and no default value was specified, this will return an empty List. 
     * <p>
     * This method will attempt to cast any values into a Byte if possible, but may miss any values out if they are not compatible. 
     *
     * @param path 要获取 List&lt;Byte&gt;的路径. 
     * @return 返回一个 List&lt;Byte&gt;. 
     */
    @NotNull
    public List<Byte> getByteList(@NotNull String path);

    /**
     * 在指定路径获取一个 List&lt;Character&gt;. 
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值. 
     * <p>
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表. 
     * <p>
     * 此方法会尽可能的将 List 中所有的项转化为 Character, 但是如果值本身不兼容, 将会发生不可预计的状况. 
     * <p>原文: 
     * Gets the requested List of Character by path. 
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value. 
     * If the List does not exist and no default value was specified, this will return an empty List. 
     * <p>
     * This method will attempt to cast any values into a Character if possible, but may miss any values out if they are not compatible. 
     *
     * @param path 要获取 List&lt;Character&gt;的路径. 
     * @return 返回一个 List&lt;Character&gt;. 
     */
    @NotNull
    public List<Character> getCharacterList(@NotNull String path);

    /**
     * 在指定路径获取一个 List&lt;Short&gt;. 
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值. 
     * <p>
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表. 
     * <p>
     * 此方法会尽可能的将 List 中所有的项转化为 Short, 但是如果值本身不兼容, 将会发生不可预计的状况. 
     * <p>原文: 
     * Gets the requested List of Short by path. 
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value. 
     * If the List does not exist and no default value was specified, this will return an empty List. 
     * <p>
     * This method will attempt to cast any values into a Short if possible, but may miss any values out if they are not compatible. 
     *
     * @param path 要获取 List&lt;Short&gt;的路径. 
     * @return 返回一个 List&lt;Short&gt;. 
     */
    @NotNull
    public List<Short> getShortList(@NotNull String path);

    /**
     * 在指定路径获取一个 List&lt;Maps&gt;. 
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值. 
     * <p>
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表. 
     * <p>
     * 此方法会尽可能的将 List 中所有的项转化为 Map, 但是如果值本身不兼容, 将会发生不可预计的状况. 
     * <p>原文: 
     * Gets the requested List of Maps by path. 
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value. 
     * If the List does not exist and no default value was specified, this will return an empty List. 
     * <p>
     * This method will attempt to cast any values into a Map if possible, but may miss any values out if they are not compatible. 
     *
     * @param path 要获取 List&lt;Maps&gt;的路径. 
     * @return 返回一个 List&lt;Maps&gt;. 
     */
    @NotNull
    public List<Map<?, ?>> getMapList(@NotNull String path);

    // Bukkit
    /**
     * Gets the requested object at the given path.
     *
     * If the Object does not exist but a default value has been specified, this
     * will return the default value. If the Object does not exist and no
     * default value was specified, this will return null.
     *
     * <b>Note:</b> For example #getObject(path, String.class) is <b>not</b>
     * equivalent to {@link #getString(String) #getString(path)} because
     * {@link #getString(String) #getString(path)} converts internally all
     * Objects to Strings. However, #getObject(path, Boolean.class) is
     * equivalent to {@link #getBoolean(String) #getBoolean(path)} for example.
     *
     * @param <T> the type of the requested object
     * @param path the path to the object.
     * @param clazz the type of the requested object
     * @return Requested object
     */
    @Nullable
    public <T extends Object> T getObject(@NotNull String path, @NotNull Class<T> clazz);

    /**
     * Gets the requested object at the given path, returning a default value if
     * not found
     *
     * If the Object does not exist then the specified default value will
     * returned regardless of if a default has been identified in the root
     * {@link Configuration}.
     *
     * <b>Note:</b> For example #getObject(path, String.class, def) is
     * <b>not</b> equivalent to
     * {@link #getString(String, String) #getString(path, def)} because
     * {@link #getString(String, String) #getString(path, def)} converts
     * internally all Objects to Strings. However, #getObject(path,
     * Boolean.class, def) is equivalent to {@link #getBoolean(String, boolean) #getBoolean(path,
     * def)} for example.
     *
     * @param <T> the type of the requested object
     * @param path the path to the object.
     * @param clazz the type of the requested object
     * @param def the default object to return if the object is not present at
     * the path
     * @return Requested object
     */
    @Contract("_, _, !null -> !null")
    @Nullable
    public <T extends Object> T getObject(@NotNull String path, @NotNull Class<T> clazz, @Nullable T def);

    /**
     * Gets the requested {@link ConfigurationSerializable} object at the given
     * path.
     *
     * If the Object does not exist but a default value has been specified, this
     * will return the default value. If the Object does not exist and no
     * default value was specified, this will return null.
     *
     * @param <T> the type of {@link ConfigurationSerializable}
     * @param path the path to the object.
     * @param clazz the type of {@link ConfigurationSerializable}
     * @return Requested {@link ConfigurationSerializable} object
     */
    @Nullable
    public <T extends ConfigurationSerializable> T getSerializable(@NotNull String path, @NotNull Class<T> clazz);

    /**
     * Gets the requested {@link ConfigurationSerializable} object at the given
     * path, returning a default value if not found
     *
     * If the Object does not exist then the specified default value will
     * returned regardless of if a default has been identified in the root
     * {@link Configuration}.
     *
     * @param <T> the type of {@link ConfigurationSerializable}
     * @param path the path to the object.
     * @param clazz the type of {@link ConfigurationSerializable}
     * @param def the default object to return if the object is not present at
     * the path
     * @return Requested {@link ConfigurationSerializable} object
     */
    @Contract("_, _, !null -> !null")
    @Nullable
    public <T extends ConfigurationSerializable> T getSerializable(@NotNull String path, @NotNull Class<T> clazz, @Nullable T def);

    /**
     * 在指定路径获取一个Vector类型的值. 
     * <p>
     * 如果这个Vector不存在, 但已指定一个缺省值, 这将返回缺省值. Vector. 
     * 如果这个Vector不存在, 并且没有指定缺省值, 则返回null. 
     * <p>原文: 
     * Gets the requested Vector by path. 
     * <p>
     * If the Vector does not exist but a default value has been specified, this will return the default value. 
     * If the Vector does not exist and no default value was specified, this will return null. 
     *
     * @param path 获取Vector的路径. 
     * @return 返回一个Vector. 
     */
    @Nullable
    public Vector getVector(@NotNull String path);

    /**
     * 在指定路径上获取一个{@link Vector}, 如果无法获取, 则直接返回默认值. 
     * <p>
     * 如果无法获取到一个 {@link Vector}, 将不会尝试去缺省列表中去获取, 而是直接返回指定的默认值. 
     * <p>原文: 
     * Gets the requested {@link Vector} by path, returning a default value if not found. 
     * <p>
     * If the Vector does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}. 
     *
     * @param path 获取 {@link Vector} 的路径. 
     * @param def 当指定路径上没有值, 或者不是 {@link Vector} 类型时, 返回这个值. 
     * @return 返回一个 {@link Vector}r. 
     */
    @Contract("_, !null -> !null")
    @Nullable
    public Vector getVector(@NotNull String path, @Nullable Vector def);

    /**
     * 检查指定路径是否是 {@link Vector} . 
     * <p>
     * 如果路径存在, 但不是 {@link Vector} , 则返回 false. 
     * <p>
     * 如果路径不存在, 则返回 false. 
     * <p>
     * 如果路径不存在, 但在缺省列表中存在该路径, 则在缺省列表中重复匹配该规则, 直到返回一个适当的值. 
     * <p>原文: 
     * Checks if the specified path is a Vector. 
     * <p>
     * If the path exists but is not a Vector, this will return false. 
     * If the path does not exist, this will return false. 
     * If the path does not exist but a default value has been specified, this will check if that default value is a Vector and return appropriately. 
     *
     * @param path 检查指定路径是否是 {@link Vector} . 
     * @return 指定路径是否是 {@link Vector} . 
     */
    public boolean isVector(@NotNull String path);

    /**
     * 在指定路径获取一个 {@link OfflinePlayer} 类型的值. 
     * <p>
     * 如果这个 {@link OfflinePlayer} 不存在, 但已指定一个缺省值, 这将返回缺省值. 
     * <p>
     * 如果这个 {@link OfflinePlayer} 不存在, 并且没有指定缺省值, 则返回 null. 
     * <p>原文: 
     * Gets the requested OfflinePlayer by path. 
     * <p>
     * If the OfflinePlayer does not exist but a default value has been specified, this will return the default value. 
     * If the OfflinePlayer does not exist and no default value was specified, this will return null. 
     *
     * @param path 获取 {@link OfflinePlayer} 的路径. 
     * @return 返回一个 {@link OfflinePlayer}. 
     */
    @Nullable
    public OfflinePlayer getOfflinePlayer(@NotNull String path);

    /**
     * 在指定路径上获取一个 {@link OfflinePlayer}, 如果无法获取, 则直接返回默认值. 
     * <p>
     * 如果无法获取到一个 {@link OfflinePlayer}, 将不会尝试去缺省列表中去获取, 而是直接返回指定的默认值. 
     * <p>原文: 
     * Gets the requested {@link OfflinePlayer} by path, returning a default value if not found. 
     * <p>
     * If the OfflinePlayer does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}. 
     *
     * @param path 获取 {@link OfflinePlayer} 的路径. 
     * @param def 当指定路径上没有值, 或者不是 {@link OfflinePlayer} 类型时, 返回这个值. 
     * @return 返回一个 {@link OfflinePlayer}. 
     */
    @Contract("_, !null -> !null")
    @Nullable
    public OfflinePlayer getOfflinePlayer(@NotNull String path, @Nullable OfflinePlayer def);

    /**
     * 检查指定路径是否是 {@link OfflinePlayer}. 
     * <p>
     * 如果路径存在, 但不是 {@link OfflinePlayer}, 则返回 false. 
     * <p>
     * 如果路径不存在, 则返回 false. 
     * <p>
     * 如果路径不存在, 但在缺省列表中存在该路径, 则在缺省列表中重复匹配该规则, 直到返回一个适当的值. 
     * <p>原文: 
     * Checks if the specified path is a OfflinePlayer. 
     * <p>
     * If the path exists but is not a OfflinePlayer, this will return false. 
     * If the path does not exist, this will return false. 
     * If the path does not exist but a default value has been specified, this will check if that default value is a OfflinePlayer and return appropriately. 
     *
     * @param path 检查指定路径是否是 {@link OfflinePlayer}. 
     * @return 指定路径是否是 {@link OfflinePlayer}. 
     */
    public boolean isOfflinePlayer(@NotNull String path);

    /**
     * 在指定路径获取一个 {@link ItemStack} 类型的值. 
     * <p>
     * 如果这个 {@link ItemStack} 不存在, 但已指定一个缺省值, 这将返回缺省值.
     * <p>
     * 如果这个 {@link ItemStack} 不存在, 并且没有指定缺省值, 则返回 null. 
     * <p>原文: 
     * Gets the requested ItemStack by path. 
     * <p>
     * If the ItemStack does not exist but a default value has been specified, this will return the default value. 
     * If the ItemStack does not exist and no default value was specified, this will return null. 
     *
     * @param path 获取 {@link ItemStack} 的路径. 
     * @return 返回一个 {@link ItemStack}. 
     */
    @Nullable
    public ItemStack getItemStack(@NotNull String path);

    /**
     * 在指定路径上获取一个 {@link ItemStack}, 如果无法获取, 则直接返回默认值. 
     * <p>
     * 如果无法获取到一个 {@link ItemStack}, 将不会尝试去缺省列表中去获取, 而是直接返回指定的默认值. 
     * <p>原文: 
     * Gets the requested {@link ItemStack} by path, returning a default value if not found. 
     * <p>
     * If the ItemStack does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}. 
     *
     * @param path 获取ItemStack的路径. 
     * @param def 当指定路径上没有值, 或者不是ItemStack类型时, 返回这个值. 
     * @return 返回一个ItemStack. 
     */
    @Contract("_, !null -> !null")
    @Nullable
    public ItemStack getItemStack(@NotNull String path, @Nullable ItemStack def);

    /**
     * 检查指定路径是否是 {@link ItemStack}. 
     * <p>
     * 如果路径存在, 但不是 {@link ItemStack}, 则返回 false. 
     * <p>
     * 如果路径不存在, 则返回 false. 
     * <p>
     * 如果路径不存在, 但在缺省列表中存在该路径, 则在缺省列表中重复匹配该规则, 直到返回一个适当的值. 
     * <p>原文: 
     * Checks if the specified path is a ItemStack. 
     * <p>
     * If the path exists but is not a ItemStack, this will return false. 
     * If the path does not exist, this will return false. 
     * If the path does not exist but a default value has been specified, this will check if that default value is a ItemStack and return appropriately. 
     *
     * @param path 检查指定路径是否是 {@link ItemStack}. 
     * @return 指定路径是否是 {@link ItemStack}. 
     */
    public boolean isItemStack(@NotNull String path);

    /**
     * 在指定路径获取一个Color类型的值. 
     * <p>
     * 如果这个Color不存在, 但已指定一个缺省值, 这将返回缺省值. Color. 
     * <p>
     * 如果这个Color不存在, 并且没有指定缺省值, 则返回null. 
     * <p>原文: 
     * Gets the requested Color by path. 
     * <p>
     * If the Color does not exist but a default value has been specified, this will return the default value. 
     * If the Color does not exist and no default value was specified, this will return null. 
     *
     * @param path 获取Color的路径. 
     * @return 返回一个Color. 
     */
    @Nullable
    public Color getColor(@NotNull String path);

    /**
     * 在指定路径上获取一个 {@link Color}, 如果无法获取, 则直接返回指定默认值. 
     * <p>
     * 如果无法获取到一个 {@link Color}, 将不会尝试去缺省列表中去获取, 而是直接返回指定的默认值. 
     * <p>原文: 
     * Gets the requested {@link Color} by path, returning a default value if not found. 
     * <p>
     * If the Color does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}. 
     *
     * @param path 获取 {@link Color} 的路径. 
     * @param def 当指定路径上没有值, 或者不是 {@link Color} 类型时, 返回这个值. 
     * @return 返回一个 {@link Color}. 
     */
    @Contract("_, !null -> !null")
    @Nullable
    public Color getColor(@NotNull String path, @Nullable Color def);

    /**
     * 检查指定路径是否是 {@link Color}. 
     * <p>
     * 如果路径存在, 但不是 {@link Color}, 则返回 false. 
     * <p>
     * 如果路径不存在, 则返回 false. 
     * <p>
     * 如果路径不存在, 但在缺省列表中存在该路径, 则在缺省列表中重复匹配该规则, 直到返回一个适当的值. 
     * <p>原文: 
     * Checks if the specified path is a Color. 
     * <p>
     * If the path exists but is not a Color, this will return false. 
     * If the path does not exist, this will return false. 
     * If the path does not exist but a default value has been specified, this will check if that default value is a Color and return appropriately. 
     *
     * @param path 检查指定路径是否是 {@link Color}. 
     * @return 指定路径是否是 {@link Color}. 
     */
    public boolean isColor(@NotNull String path);

    /**
     * Gets the requested Location by path.
     * <p>
     * If the Location does not exist but a default value has been specified,
     * this will return the default value. If the Location does not exist and no
     * default value was specified, this will return null.
     *
     * @param path Path of the Location to get.
     * @return Requested Location.
     */
    @Nullable
    public Location getLocation(@NotNull String path);

    /**
     * Gets the requested {@link Location} by path, returning a default value if
     * not found.
     * <p>
     * If the Location does not exist then the specified default value will
     * returned regardless of if a default has been identified in the root
     * {@link Configuration}.
     *
     * @param path Path of the Location to get.
     * @param def The default value to return if the path is not found or is not
     * a Location.
     * @return Requested Location.
     */
    @Contract("_, !null -> !null")
    @Nullable
    public Location getLocation(@NotNull String path, @Nullable Location def);

    /**
     * Checks if the specified path is a Location.
     * <p>
     * If the path exists but is not a Location, this will return false. If the
     * path does not exist, this will return false. If the path does not exist
     * but a default value has been specified, this will check if that default
     * value is a Location and return appropriately.
     *
     * @param path Path of the Location to check.
     * @return Whether or not the specified path is a Location.
     */
    public boolean isLocation(@NotNull String path);

    /**
     * 获取一个 {@link ConfigurationSection} ,它是一个以指定路径作为基点的新的配置项,修改会同步. 
     * <p>
     * 如果这个 {@link ConfigurationSection} 不存在, 但已指定一个缺省值, 这将返回缺省值.
     * <p>
     * 如果这个 {@link ConfigurationSection} 不存在, 并且没有指定缺省值, 则返回 null. 
     * <p>
     * 更人性化的解释: 现在有一个配置文件如下
     * <pre>
     * root: 
     *   branch1:
     *     branch1_1: something
     *     branch1_2: something
     *   branch2: 
     *     branch2_1: something
     *     branch3_2: something
     * </pre>
     * 如果调用 {@link ConfigurationSection#getConfigurationSection(java.lang.String) }
     * 参数为("branch1") ,则会返回
     * <pre>
     *   branch1:
     *     branch1_1: something
     *     branch1_2: something
     * </pre>
     * 并且修改会同步
     * <p>原文: 
     * Gets the requested ConfigurationSection by path. 
     * <p>
     * If the ConfigurationSection does not exist but a default value has been specified, this will return the default value. 
     * If the ConfigurationSection does not exist and no default value was specified, this will return null. 
     *
     * @param path 获取 {@link ConfigurationSection} 的路径. 
     * @return 返回一个 {@link ConfigurationSection}. 
     */
    @Nullable
    public ConfigurationSection getConfigurationSection(@NotNull String path);

    /**
     * 检查指定路径是否是 {@link ConfigurationSection}. 
     * <p>
     * 如果路径存在, 但不是 {@link ConfigurationSection}, 则返回 false. 
     * <p>
     * 如果路径不存在, 则返回 false. 
     * <p>
     * 如果路径不存在, 但在缺省列表中存在该路径, 则在缺省列表中重复匹配该规则, 直到返回一个适当的值. 
     * <p>原文: 
     * Checks if the specified path is a ConfigurationSection. 
     * <p>
     * If the path exists but is not a ConfigurationSection, this will return false. 
     * If the path does not exist, this will return false. 
     * If the path does not exist but a default value has been specified, this will check if that default value is a ConfigurationSection and return appropriately. 
     *
     * @param path 检查指定路径是否是 {@link ConfigurationSection}. 
     * @return 指定路径是否是 {@link ConfigurationSection}. 
     */
    public boolean isConfigurationSection(@NotNull String path);

    /**
     * Gets the equivalent {@link ConfigurationSection} from the default {@link Configuration} defined in {@link #getRoot()}. 
     * <p>
     * If the root contains no defaults, or the defaults doesn't contain a value for this path, or the value at this path is not a {@link ConfigurationSection} then this will return null. 
     *
     * @return Equivalent section in root configuration
     */
    @Nullable
    public ConfigurationSection getDefaultSection();

    /**
     * 给指定路径添加一个缺省值. 
     * <p>
     * 如果缺省值 {@link Configuration} 没有被提供, 则自动创建一个新的. 
     * <p>
     * 如果值为 null, 表示从缺省值 {@link Configuration} 中删除这个路径上的默认值
     * <p>
     * 如果 {@link #getDefaultSection()} 返回的值为 null, 则建立一个新的
     * <p>原文: 
     * Sets the default value in the root at the given path as provided. 
     * <p>
     * If no source {@link Configuration} was provided as a default collection, then a new {@link MemoryConfiguration} will be created to hold the new default value. 
     * <p>
     * If value is null, the value will be removed from the default Configuration source. 
     * <p>
     * If the value as returned by {@link #getDefaultSection()} is null, then this will create a new section at the path, replacing anything that may have existed there previously. 
     *
     * @param path 要设置缺省值的路径. 
     * @param value 要设置的值. 
     * @throws IllegalArgumentException 当路径为 null 时抛出此异常. 
     */
    public void addDefault(@NotNull String path, @Nullable Object value);
}
