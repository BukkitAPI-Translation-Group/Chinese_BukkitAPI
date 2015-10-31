package org.bukkit.configuration;

import java.util.Map;
import java.util.Set;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.OfflinePlayer;
import org.bukkit.util.Vector;
import org.bukkit.inventory.ItemStack;

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
     * 如果为true,则返回包括所有的能访问到的键的集合.类似于获取硬盘中第一层目录还是遍历全部子目录.
     * <p>
     * 例如:
     * <p>
     * top1.Second1
     * <p>
     * top1.Second2
     * <p>
     * top2.Second1
     * <p>
     * top2.Second2
     * <p>原文:
     * Gets a set containing all keys in this section.
     * <p>
     * If deep is set to true, then this will contain all the keys within any child {@link ConfigurationSection}s (and their children, etc).
     * These will be in a valid path notation for you to use.
     * <p>
     * If deep is set to false, then this will contain only the keys of any direct children, and not their own children.
     *
     * @param deep 获取全部键,或者仅仅获取表层键.
     * @return 将返回一个set,装载着符合要求的键.
     */
    public Set<String> getKeys(boolean deep);

    /**
     * 获取这个配置文件的键值集合.
     * <p>
     * 如果为true,则返回包括所有的能访问到的键和值的集合.
     * 类似于获取硬盘中第一层目录还是遍历全部子目录.
     * <p>
     * 如果为false,则返回表层的键和值的集合.
     * <p>
     * Gets a Map containing all keys and their values for this section.
     * <p>
     * If deep is set to true, then this will contain all the keys and values within any child {@link ConfigurationSection}s (and their children, etc).
     * These keys will be in a valid path notation for you to use.
     * <p>
     * If deep is set to false, then this will contain only the keys and values of any direct children, and not their own children.
     *
     * @param deep 获取全部键值集合(true),或者仅仅获取表层键值集合(false).
     * @return 返回一个Map,路径-值.
     */
    public Map<String, Object> getValues(boolean deep);

    /**
     * 检查{@link ConfigurationSection}是否包含指定路径.
     * <p>
     * 如果这个路径不存在,但已指定一个缺省值,也将返回true.
     * <p>原文:
     * Checks if this {@link ConfigurationSection} contains the given path.
     * <p>
     * If the value for the requested path does not exist but a default value has been specified, this will return true.
     *
     * @param path 要检查的路径
     * @return 如果此部分包含请求的路径，可以通过默认的或者被设置.
     * @throws IllegalArgumentException 如果路径是null时抛出此异常.
     */
    public boolean contains(String path);

    /**
     * Checks if this {@link ConfigurationSection} has a value set for the given path.
     * <p>
     * If the value for the requested path does not exist but a default value has been specified, this will still return false.
     *
     * @param path Path to check for existence.
     * @return True if this section contains the requested path, regardless of having a default.
     * @throws IllegalArgumentException Thrown when path is null.
     */
    public boolean isSet(String path);

    /**
     * Gets the path of this {@link ConfigurationSection} from its root {@link Configuration}
     * <p>
     * For any {@link Configuration} themselves, this will return an empty string.
     * <p>
     * If the section is no longer contained within its root for any reason, such as being replaced with a different value, this may return null.
     * <p>
     * To retrieve the single name of this section, that is, the final part of the path returned by this method, you may use {@link #getName()}.
     *
     * @return Path of this section relative to its root
     */
    public String getCurrentPath();

    /**
     * Gets the name of this individual {@link ConfigurationSection}, in the path.
     * <p>
     * This will always be the final part of {@link #getCurrentPath()}, unless the section is orphaned.
     *
     * @return Name of this section
     */
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
    public ConfigurationSection getParent();

    /**
     * 在指定路径获取一个Object类型的值.
     * <p>
     * 如果这个Object不存在,但已指定一个缺省值,这将返回缺省值.Object.
     * 如果这个Object不存在,并且没有指定缺省值,则返回null.
     * <p>原文:
     * Gets the requested Object by path.
     * <p>
     * If the Object does not exist but a default value has been specified, this will return the default value.
     * If the Object does not exist and no default value was specified, this will return null.
     *
     * @param path 获取Object的路径.
     * @return 返回一个Object.
     */
    public Object get(String path);

    /**
     * 在指定路径上获取一个Object,如果无法获取,则直接返回默认值.
     * <p>
     * 如果Object无法在{@link Configuration}中被获取,则不会尝试去默认列表中去寻找,而是直接返回指定的默认值.
     * <p>原文:
     * Gets the requested Object by path, returning a default value if not found.
     * <p>
     * If the Object does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}.
     *
     * @param path 获取Object的路径.
     * @param def 当指定路径上没有值,返回这个值.
     * @return 返回一个Object.
     */
    public Object get(String path, Object def);

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
    public void set(String path, Object value);

    /**
     * Creates an empty {@link ConfigurationSection} at the specified path.
     * <p>
     * Any value that was previously set at this path will be overwritten.
     * If the previous value was itself a {@link ConfigurationSection}, it will be orphaned.
     *
     * @param path Path to create the section at.
     * @return Newly created section
     */
    public ConfigurationSection createSection(String path);

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
    public ConfigurationSection createSection(String path, Map<?, ?> map);

    // Primitives
    /**
     * 在指定路径获取一个String类型的值.
     * <p>
     * 如果这个String不存在,但已指定一个缺省值,这将返回缺省值.String.
     * 如果这个String不存在,并且没有指定缺省值,则返回null.
     * <p>原文:
     * Gets the requested String by path.
     * <p>
     * If the String does not exist but a default value has been specified, this will return the default value.
     * If the String does not exist and no default value was specified, this will return null.
     *
     * @param path 获取String的路径.
     * @return 返回一个String.
     */
    public String getString(String path);

    /**
     * 在指定路径上获取一个String,如果无法获取,则直接返回默认值.
     * <p>
     * 如果String无法在{@link Configuration}中被获取,则不会尝试去默认列表中去寻找,而是直接返回指定的默认值.
     * <p>原文:
     * Gets the requested String by path, returning a default value if not found.
     * <p>
     * If the String does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}.
     *
     * @param path 获取String的路径.
     * @param def 当指定路径上没有值,或者不是String类型时,返回这个值.
     * @return 返回一个String.
     */
    public String getString(String path, String def);

    /**
     * 检查指定路径是否是String.
     * <p>
     * 如果路径存在,但不是String,则返回false.
     * 如果路径不存在,则返回false.
     * 如果路径不存在,但在默认列表中存在该路径,则在默认列表中重复匹配该规则,直到返回一个适当的值.
     * <p>原文:
     * Checks if the specified path is a String.
     * <p>
     * If the path exists but is not a String, this will return false.
     * If the path does not exist, this will return false.
     * If the path does not exist but a default value has been specified, this will check if that default value is a String and return appropriately.
     *
     * @param path 检查指定路径是否是String.
     * @return 指定路径是否是String.
     */
    public boolean isString(String path);

    /**
     * 在指定路径获取一个int类型的值.
     * <p>
     * 如果这个int不存在,但已指定一个缺省值,这将返回缺省值.int.
     * 如果这个int不存在,并且没有指定缺省值,则返回0.
     * <p>原文:
     * Gets the requested int by path.
     * <p>
     * If the int does not exist but a default value has been specified, this will return the default value.
     * If the int does not exist and no default value was specified, this will return 0.
     *
     * @param path 获取int的路径.
     * @return 返回一个int.
     */
    public int getInt(String path);

    /**
     * 在指定路径上获取一个int,如果无法获取,则直接返回默认值.
     * <p>
     * 如果int无法在{@link Configuration}中被获取,则不会尝试去默认列表中去寻找,而是直接返回指定的默认值.
     * <p>原文:
     * Gets the requested int by path, returning a default value if not found.
     * <p>
     * If the int does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}.
     *
     * @param path 获取int的路径.
     * @param def 当指定路径上没有值,或者不是int类型时,返回这个值.
     * @return 返回一个int.
     */
    public int getInt(String path, int def);

    /**
     * 检查指定路径是否是int.
     * <p>
     * 如果路径存在,但不是int,则返回false.
     * 如果路径不存在,则返回false.
     * 如果路径不存在,但在默认列表中存在该路径,则在默认列表中重复匹配该规则,直到返回一个适当的值.
     * <p>原文:
     * Checks if the specified path is a int.
     * <p>
     * If the path exists but is not a int, this will return false.
     * If the path does not exist, this will return false.
     * If the path does not exist but a default value has been specified, this will check if that default value is a int and return appropriately.
     *
     * @param path 检查指定路径是否是int.
     * @return 指定路径是否是int.
     */
    public boolean isInt(String path);

    /**
     * 在指定路径获取一个boolean类型的值.
     * <p>
     * 如果这个boolean不存在,但已指定一个缺省值,这将返回缺省值.boolean.
     * 如果这个boolean不存在,并且没有指定缺省值,则返回false.
     * <p>原文:
     * Gets the requested boolean by path.
     * <p>
     * If the boolean does not exist but a default value has been specified, this will return the default value.
     * If the boolean does not exist and no default value was specified, this will return false.
     *
     * @param path 获取boolean的路径.
     * @return 返回一个boolean.
     */
    public boolean getBoolean(String path);

    /**
     * 在指定路径上获取一个boolean,如果无法获取,则直接返回默认值.
     * <p>
     * 如果boolean无法在{@link Configuration}中被获取,则不会尝试去默认列表中去寻找,而是直接返回指定的默认值.
     * <p>原文:
     * Gets the requested boolean by path, returning a default value if not found.
     * <p>
     * If the boolean does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}.
     *
     * @param path 获取boolean的路径.
     * @param def 当指定路径上没有值,或者不是boolean类型时,返回这个值.
     * @return 返回一个boolean.
     */
    public boolean getBoolean(String path, boolean def);

    /**
     * 检查指定路径是否是boolean.
     * <p>
     * 如果路径存在,但不是boolean,则返回false.
     * 如果路径不存在,则返回false.
     * 如果路径不存在,但在默认列表中存在该路径,则在默认列表中重复匹配该规则,直到返回一个适当的值.
     * <p>原文:
     * Checks if the specified path is a boolean.
     * <p>
     * If the path exists but is not a boolean, this will return false.
     * If the path does not exist, this will return false.
     * If the path does not exist but a default value has been specified, this will check if that default value is a boolean and return appropriately.
     *
     * @param path 检查指定路径是否是boolean.
     * @return 指定路径是否是boolean.
     */
    public boolean isBoolean(String path);

    /**
     * 在指定路径获取一个double类型的值.
     * <p>
     * 如果这个double不存在,但已指定一个缺省值,这将返回缺省值.double.
     * 如果这个double不存在,并且没有指定缺省值,则返回0.
     * <p>原文:
     * Gets the requested double by path.
     * <p>
     * If the double does not exist but a default value has been specified, this will return the default value.
     * If the double does not exist and no default value was specified, this will return 0.
     *
     * @param path 获取double的路径.
     * @return 返回一个double.
     */
    public double getDouble(String path);

    /**
     * 在指定路径上获取一个double,如果无法获取,则直接返回默认值.
     * <p>
     * 如果double无法在{@link Configuration}中被获取,则不会尝试去默认列表中去寻找,而是直接返回指定的默认值.
     * <p>原文:
     * Gets the requested double by path, returning a default value if not found.
     * <p>
     * If the double does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}.
     *
     * @param path 获取double的路径.
     * @param def 当指定路径上没有值,或者不是double类型时,返回这个值.
     * @return 返回一个double.
     */
    public double getDouble(String path, double def);

    /**
     * 检查指定路径是否是double.
     * <p>
     * 如果路径存在,但不是double,则返回false.
     * 如果路径不存在,则返回false.
     * 如果路径不存在,但在默认列表中存在该路径,则在默认列表中重复匹配该规则,直到返回一个适当的值.
     * <p>原文:
     * Checks if the specified path is a double.
     * <p>
     * If the path exists but is not a double, this will return false.
     * If the path does not exist, this will return false.
     * If the path does not exist but a default value has been specified, this will check if that default value is a double and return appropriately.
     *
     * @param path 检查指定路径是否是double.
     * @return 指定路径是否是double.
     */
    public boolean isDouble(String path);

    /**
     * 在指定路径获取一个long类型的值.
     * <p>
     * 如果这个long不存在,但已指定一个缺省值,这将返回缺省值.long.
     * 如果这个long不存在,并且没有指定缺省值,则返回0.
     * <p>原文:
     * Gets the requested long by path.
     * <p>
     * If the long does not exist but a default value has been specified, this will return the default value.
     * If the long does not exist and no default value was specified, this will return 0.
     *
     * @param path 获取long的路径.
     * @return 返回一个long.
     */
    public long getLong(String path);

    /**
     * 在指定路径上获取一个long,如果无法获取,则直接返回默认值.
     * <p>
     * 如果long无法在{@link Configuration}中被获取,则不会尝试去默认列表中去寻找,而是直接返回指定的默认值.
     * <p>原文:
     * Gets the requested long by path, returning a default value if not found.
     * <p>
     * If the long does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}.
     *
     * @param path 获取long的路径.
     * @param def 当指定路径上没有值,或者不是long类型时,返回这个值.
     * @return 返回一个long.
     */
    public long getLong(String path, long def);

    /**
     * 检查指定路径是否是long.
     * <p>
     * 如果路径存在,但不是long,则返回false.
     * 如果路径不存在,则返回false.
     * 如果路径不存在,但在默认列表中存在该路径,则在默认列表中重复匹配该规则,直到返回一个适当的值.
     * <p>原文:
     * Checks if the specified path is a long.
     * <p>
     * If the path exists but is not a long, this will return false.
     * If the path does not exist, this will return false.
     * If the path does not exist but a default value has been specified, this will check if that default value is a long and return appropriately.
     *
     * @param path 检查指定路径是否是long.
     * @return 指定路径是否是long.
     */
    public boolean isLong(String path);

    // Java
    /**
     * 在指定路径获取一个List类型的值.
     * <p>
     * 如果这个List不存在,但已指定一个缺省值,这将返回缺省值.List.
     * 如果这个List不存在,并且没有指定缺省值,则返回null.
     * <p>原文:
     * Gets the requested List by path.
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value.
     * If the List does not exist and no default value was specified, this will return null.
     *
     * @param path 获取List的路径.
     * @return 返回一个List.
     */
    public List<?> getList(String path);

    /**
     * 在指定路径上获取一个List,如果无法获取,则直接返回默认值.
     * <p>
     * 如果List无法在{@link Configuration}中被获取,则不会尝试去默认列表中去寻找,而是直接返回指定的默认值.
     * <p>原文:
     * Gets the requested List by path, returning a default value if not found.
     * <p>
     * If the List does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}.
     *
     * @param path 获取List的路径.
     * @param def 当指定路径上没有值,或者不是List类型时,返回这个值.
     * @return 返回一个List.
     */
    public List<?> getList(String path, List<?> def);

    /**
     * 检查指定路径是否是List.
     * <p>
     * 如果路径存在,但不是List,则返回false.
     * 如果路径不存在,则返回false.
     * 如果路径不存在,但在默认列表中存在该路径,则在默认列表中重复匹配该规则,直到返回一个适当的值.
     * <p>原文:
     * Checks if the specified path is a List.
     * <p>
     * If the path exists but is not a List, this will return false.
     * If the path does not exist, this will return false.
     * If the path does not exist but a default value has been specified, this will check if that default value is a List and return appropriately.
     *
     * @param path 检查指定路径是否是List.
     * @return 指定路径是否是List.
     */
    public boolean isList(String path);

    /**
     * 在指定路径获取一个List&lt;String&gt;.
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值.
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表.
     * <p>
     * 此方法会尽可能的将list中所有的项转化为String,但是如果值本身不兼容,将会发生不可预计的状况.
     * <p>原文:
     * Gets the requested List of String by path.
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value.
     * If the List does not exist and no default value was specified, this will return an empty List.
     * <p>
     * This method will attempt to cast any values into a String if possible, but may miss any values out if they are not compatible.
     *
     * @param path 要获取List&lt;String&gt;的路径.
     * @return 返回一个List&lt;String&gt;.
     */
    public List<String> getStringList(String path);

    /**
     * 在指定路径获取一个List&lt;Integer&gt;.
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值.
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表.
     * <p>
     * 此方法会尽可能的将list中所有的项转化为Integer,但是如果值本身不兼容,将会发生不可预计的状况.
     * <p>原文:
     * Gets the requested List of Integer by path.
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value.
     * If the List does not exist and no default value was specified, this will return an empty List.
     * <p>
     * This method will attempt to cast any values into a Integer if possible, but may miss any values out if they are not compatible.
     *
     * @param path 要获取List&lt;Integer&gt;的路径.
     * @return 返回一个List&lt;Integer&gt;.
     */
    public List<Integer> getIntegerList(String path);

    /**
     * 在指定路径获取一个List&lt;Boolean&gt;.
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值.
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表.
     * <p>
     * 此方法会尽可能的将list中所有的项转化为Boolean,但是如果值本身不兼容,将会发生不可预计的状况.
     * <p>原文:
     * Gets the requested List of Boolean by path.
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value.
     * If the List does not exist and no default value was specified, this will return an empty List.
     * <p>
     * This method will attempt to cast any values into a Boolean if possible, but may miss any values out if they are not compatible.
     *
     * @param path 要获取List&lt;Boolean&gt;的路径.
     * @return 返回一个List&lt;Boolean&gt;.
     */
    public List<Boolean> getBooleanList(String path);

    /**
     * 在指定路径获取一个List&lt;Double&gt;.
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值.
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表.
     * <p>
     * 此方法会尽可能的将list中所有的项转化为Double,但是如果值本身不兼容,将会发生不可预计的状况.
     * <p>原文:
     * Gets the requested List of Double by path.
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value.
     * If the List does not exist and no default value was specified, this will return an empty List.
     * <p>
     * This method will attempt to cast any values into a Double if possible, but may miss any values out if they are not compatible.
     *
     * @param path 要获取List&lt;Double&gt;的路径.
     * @return 返回一个List&lt;Double&gt;.
     */
    public List<Double> getDoubleList(String path);

    /**
     * 在指定路径获取一个List&lt;Float&gt;.
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值.
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表.
     * <p>
     * 此方法会尽可能的将list中所有的项转化为Float,但是如果值本身不兼容,将会发生不可预计的状况.
     * <p>原文:
     * Gets the requested List of Float by path.
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value.
     * If the List does not exist and no default value was specified, this will return an empty List.
     * <p>
     * This method will attempt to cast any values into a Float if possible, but may miss any values out if they are not compatible.
     *
     * @param path 要获取List&lt;Float&gt;的路径.
     * @return 返回一个List&lt;Float&gt;.
     */
    public List<Float> getFloatList(String path);

    /**
     * 在指定路径获取一个List&lt;Long&gt;.
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值.
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表.
     * <p>
     * 此方法会尽可能的将list中所有的项转化为Long,但是如果值本身不兼容,将会发生不可预计的状况.
     * <p>原文:
     * Gets the requested List of Long by path.
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value.
     * If the List does not exist and no default value was specified, this will return an empty List.
     * <p>
     * This method will attempt to cast any values into a Long if possible, but may miss any values out if they are not compatible.
     *
     * @param path 要获取List&lt;Long&gt;的路径.
     * @return 返回一个List&lt;Long&gt;.
     */
    public List<Long> getLongList(String path);

    /**
     * 在指定路径获取一个List&lt;Byte&gt;.
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值.
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表.
     * <p>
     * 此方法会尽可能的将list中所有的项转化为Byte,但是如果值本身不兼容,将会发生不可预计的状况.
     * <p>原文:
     * Gets the requested List of Byte by path.
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value.
     * If the List does not exist and no default value was specified, this will return an empty List.
     * <p>
     * This method will attempt to cast any values into a Byte if possible, but may miss any values out if they are not compatible.
     *
     * @param path 要获取List&lt;Byte&gt;的路径.
     * @return 返回一个List&lt;Byte&gt;.
     */
    public List<Byte> getByteList(String path);

    /**
     * 在指定路径获取一个List&lt;Character&gt;.
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值.
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表.
     * <p>
     * 此方法会尽可能的将list中所有的项转化为Character,但是如果值本身不兼容,将会发生不可预计的状况.
     * <p>原文:
     * Gets the requested List of Character by path.
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value.
     * If the List does not exist and no default value was specified, this will return an empty List.
     * <p>
     * This method will attempt to cast any values into a Character if possible, but may miss any values out if they are not compatible.
     *
     * @param path 要获取List&lt;Character&gt;的路径.
     * @return 返回一个List&lt;Character&gt;.
     */
    public List<Character> getCharacterList(String path);

    /**
     * 在指定路径获取一个List&lt;Short&gt;.
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值.
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表.
     * <p>
     * 此方法会尽可能的将list中所有的项转化为Short,但是如果值本身不兼容,将会发生不可预计的状况.
     * <p>原文:
     * Gets the requested List of Short by path.
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value.
     * If the List does not exist and no default value was specified, this will return an empty List.
     * <p>
     * This method will attempt to cast any values into a Short if possible, but may miss any values out if they are not compatible.
     *
     * @param path 要获取List&lt;Short&gt;的路径.
     * @return 返回一个List&lt;Short&gt;.
     */
    public List<Short> getShortList(String path);

    /**
     * 在指定路径获取一个List&lt;Maps&gt;.
     * <p>
     * 如果列表不存在，但已指定一个缺省值，这将返回默认值.
     * 如果列表不存在，并且没有指定缺省值，这将返回一个空的列表.
     * <p>
     * 此方法会尽可能的将list中所有的项转化为Map,但是如果值本身不兼容,将会发生不可预计的状况.
     * <p>原文:
     * Gets the requested List of Maps by path.
     * <p>
     * If the List does not exist but a default value has been specified, this will return the default value.
     * If the List does not exist and no default value was specified, this will return an empty List.
     * <p>
     * This method will attempt to cast any values into a Map if possible, but may miss any values out if they are not compatible.
     *
     * @param path 要获取List&lt;Maps&gt;的路径.
     * @return 返回一个List&lt;Maps&gt;.
     */
    public List<Map<?, ?>> getMapList(String path);

    // Bukkit
    /**
     * 在指定路径获取一个Vector类型的值.
     * <p>
     * 如果这个Vector不存在,但已指定一个缺省值,这将返回缺省值.Vector.
     * 如果这个Vector不存在,并且没有指定缺省值,则返回null.
     * <p>原文:
     * Gets the requested Vector by path.
     * <p>
     * If the Vector does not exist but a default value has been specified, this will return the default value.
     * If the Vector does not exist and no default value was specified, this will return null.
     *
     * @param path 获取Vector的路径.
     * @return 返回一个Vector.
     */
    public Vector getVector(String path);

    /**
     * 在指定路径上获取一个{@link Vector},如果无法获取,则直接返回默认值.
     * <p>
     * 如果Vector无法在{@link Configuration}中被获取,则不会尝试去默认列表中去寻找,而是直接返回指定的默认值.
     * <p>原文:
     * Gets the requested {@link Vector} by path, returning a default value if not found.
     * <p>
     * If the Vector does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}.
     *
     * @param path 获取Vector的路径.
     * @param def 当指定路径上没有值,或者不是Vector类型时,返回这个值.
     * @return 返回一个Vector.
     */
    public Vector getVector(String path, Vector def);

    /**
     * 检查指定路径是否是Vector.
     * <p>
     * 如果路径存在,但不是Vector,则返回false.
     * 如果路径不存在,则返回false.
     * 如果路径不存在,但在默认列表中存在该路径,则在默认列表中重复匹配该规则,直到返回一个适当的值.
     * <p>原文:
     * Checks if the specified path is a Vector.
     * <p>
     * If the path exists but is not a Vector, this will return false.
     * If the path does not exist, this will return false.
     * If the path does not exist but a default value has been specified, this will check if that default value is a Vector and return appropriately.
     *
     * @param path 检查指定路径是否是Vector.
     * @return 指定路径是否是Vector.
     */
    public boolean isVector(String path);

    /**
     * 在指定路径获取一个OfflinePlayer类型的值.
     * <p>
     * 如果这个OfflinePlayer不存在,但已指定一个缺省值,这将返回缺省值.OfflinePlayer.
     * 如果这个OfflinePlayer不存在,并且没有指定缺省值,则返回null.
     * <p>原文:
     * Gets the requested OfflinePlayer by path.
     * <p>
     * If the OfflinePlayer does not exist but a default value has been specified, this will return the default value.
     * If the OfflinePlayer does not exist and no default value was specified, this will return null.
     *
     * @param path 获取OfflinePlayer的路径.
     * @return 返回一个OfflinePlayer.
     */
    public OfflinePlayer getOfflinePlayer(String path);

    /**
     * 在指定路径上获取一个{@link OfflinePlayer},如果无法获取,则直接返回默认值.
     * <p>
     * 如果OfflinePlayer无法在{@link Configuration}中被获取,则不会尝试去默认列表中去寻找,而是直接返回指定的默认值.
     * <p>原文:
     * Gets the requested {@link OfflinePlayer} by path, returning a default value if not found.
     * <p>
     * If the OfflinePlayer does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}.
     *
     * @param path 获取OfflinePlayer的路径.
     * @param def 当指定路径上没有值,或者不是OfflinePlayer类型时,返回这个值.
     * @return 返回一个OfflinePlayer.
     */
    public OfflinePlayer getOfflinePlayer(String path, OfflinePlayer def);

    /**
     * 检查指定路径是否是OfflinePlayer.
     * <p>
     * 如果路径存在,但不是OfflinePlayer,则返回false.
     * 如果路径不存在,则返回false.
     * 如果路径不存在,但在默认列表中存在该路径,则在默认列表中重复匹配该规则,直到返回一个适当的值.
     * <p>原文:
     * Checks if the specified path is a OfflinePlayer.
     * <p>
     * If the path exists but is not a OfflinePlayer, this will return false.
     * If the path does not exist, this will return false.
     * If the path does not exist but a default value has been specified, this will check if that default value is a OfflinePlayer and return appropriately.
     *
     * @param path 检查指定路径是否是OfflinePlayer.
     * @return 指定路径是否是OfflinePlayer.
     */
    public boolean isOfflinePlayer(String path);

    /**
     * 在指定路径获取一个ItemStack类型的值.
     * <p>
     * 如果这个ItemStack不存在,但已指定一个缺省值,这将返回缺省值.ItemStack.
     * 如果这个ItemStack不存在,并且没有指定缺省值,则返回null.
     * <p>原文:
     * Gets the requested ItemStack by path.
     * <p>
     * If the ItemStack does not exist but a default value has been specified, this will return the default value.
     * If the ItemStack does not exist and no default value was specified, this will return null.
     *
     * @param path 获取ItemStack的路径.
     * @return 返回一个ItemStack.
     */
    public ItemStack getItemStack(String path);

    /**
     * 在指定路径上获取一个{@link ItemStack},如果无法获取,则直接返回默认值.
     * <p>
     * 如果ItemStack无法在{@link Configuration}中被获取,则不会尝试去默认列表中去寻找,而是直接返回指定的默认值.
     * <p>原文:
     * Gets the requested {@link ItemStack} by path, returning a default value if not found.
     * <p>
     * If the ItemStack does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}.
     *
     * @param path 获取ItemStack的路径.
     * @param def 当指定路径上没有值,或者不是ItemStack类型时,返回这个值.
     * @return 返回一个ItemStack.
     */
    public ItemStack getItemStack(String path, ItemStack def);

    /**
     * 检查指定路径是否是ItemStack.
     * <p>
     * 如果路径存在,但不是ItemStack,则返回false.
     * 如果路径不存在,则返回false.
     * 如果路径不存在,但在默认列表中存在该路径,则在默认列表中重复匹配该规则,直到返回一个适当的值.
     * <p>原文:
     * Checks if the specified path is a ItemStack.
     * <p>
     * If the path exists but is not a ItemStack, this will return false.
     * If the path does not exist, this will return false.
     * If the path does not exist but a default value has been specified, this will check if that default value is a ItemStack and return appropriately.
     *
     * @param path 检查指定路径是否是ItemStack.
     * @return 指定路径是否是ItemStack.
     */
    public boolean isItemStack(String path);

    /**
     * 在指定路径获取一个Color类型的值.
     * <p>
     * 如果这个Color不存在,但已指定一个缺省值,这将返回缺省值.Color.
     * 如果这个Color不存在,并且没有指定缺省值,则返回null.
     * <p>原文:
     * Gets the requested Color by path.
     * <p>
     * If the Color does not exist but a default value has been specified, this will return the default value.
     * If the Color does not exist and no default value was specified, this will return null.
     *
     * @param path 获取Color的路径.
     * @return 返回一个Color.
     */
    public Color getColor(String path);

    /**
     * 在指定路径上获取一个{@link Color},如果无法获取,则直接返回指定默认值.
     * <p>
     * 如果Color无法在{@link Configuration}中被获取,则不会尝试去默认列表中去寻找,而是直接返回指定的默认值.
     * <p>原文:
     * Gets the requested {@link Color} by path, returning a default value if not found.
     * <p>
     * If the Color does not exist then the specified default value will returned regardless of if a default has been identified in the root {@link Configuration}.
     *
     * @param path 获取Color的路径.
     * @param def 当指定路径上没有值,或者不是Color类型时,返回这个值.
     * @return 返回一个Color.
     */
    public Color getColor(String path, Color def);

    /**
     * 检查指定路径是否是Color.
     * <p>
     * 如果路径存在,但不是Color,则返回false.
     * 如果路径不存在,则返回false.
     * 如果路径不存在,但在默认列表中存在该路径,则在默认列表中重复匹配该规则,直到返回一个适当的值.
     * <p>原文:
     * Checks if the specified path is a Color.
     * <p>
     * If the path exists but is not a Color, this will return false.
     * If the path does not exist, this will return false.
     * If the path does not exist but a default value has been specified, this will check if that default value is a Color and return appropriately.
     *
     * @param path 检查指定路径是否是Color.
     * @return 指定路径是否是Color.
     */
    public boolean isColor(String path);

    /**
     * 在指定路径获取一个ConfigurationSection类型的值.
     * <p>
     * 如果这个ConfigurationSection不存在,但已指定一个缺省值,这将返回缺省值.ConfigurationSection.
     * 如果这个ConfigurationSection不存在,并且没有指定缺省值,则返回null.
     * <p>原文:
     * Gets the requested ConfigurationSection by path.
     * <p>
     * If the ConfigurationSection does not exist but a default value has been specified, this will return the default value.
     * If the ConfigurationSection does not exist and no default value was specified, this will return null.
     *
     * @param path 获取ConfigurationSection的路径.
     * @return 返回一个ConfigurationSection.
     */
    public ConfigurationSection getConfigurationSection(String path);

    /**
     * 检查指定路径是否是ConfigurationSection.
     * <p>
     * 如果路径存在,但不是ConfigurationSection,则返回false.
     * 如果路径不存在,则返回false.
     * 如果路径不存在,但在默认列表中存在该路径,则在默认列表中重复匹配该规则,直到返回一个适当的值.
     * <p>原文:
     * Checks if the specified path is a ConfigurationSection.
     * <p>
     * If the path exists but is not a ConfigurationSection, this will return false.
     * If the path does not exist, this will return false.
     * If the path does not exist but a default value has been specified, this will check if that default value is a ConfigurationSection and return appropriately.
     *
     * @param path 检查指定路径是否是ConfigurationSection.
     * @return 指定路径是否是ConfigurationSection.
     */
    public boolean isConfigurationSection(String path);

    /**
     * Gets the equivalent {@link ConfigurationSection} from the default {@link Configuration} defined in {@link #getRoot()}.
     * <p>
     * If the root contains no defaults, or the defaults doesn't contain a value for this path, or the value at this path is not a {@link ConfigurationSection} then this will return null.
     *
     * @return Equivalent section in root configuration
     */
    public ConfigurationSection getDefaultSection();

    /**
     * 给指定路径添加一个缺省值.
     * <p>
     * 如果缺省值{@link Configuration}没有被提供,则自动创建一个新的.
     * <p>
     * 如果值为null,表示从缺省值{@link Configuration}中删除这个路径上的默认值
     * <p>
     * 如果{@link #getDefaultSection()}返回的值为null,则建立一个新的
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
     * @throws IllegalArgumentException 当路径为null时抛出此异常.
     */
    public void addDefault(String path, Object value);
}
