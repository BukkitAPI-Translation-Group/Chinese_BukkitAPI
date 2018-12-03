package org.bukkit.plugin;

import java.io.File;
import java.util.Set;

import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;

/**
 * Handles all plugin management from the Server
 */
public interface PluginManager {

    /**
     * 注册给定的插件加载器
     * <p/>
     * 原文:
     * Registers the specified plugin loader
     *
     * @param loader 要注册的插件加载器的类
     * @throws IllegalArgumentException 当给定的类不是有效的插件加载器时抛出
     */
    public void registerInterface(Class<? extends PluginLoader> loader) throws IllegalArgumentException;

    /**
     * 检查指定名称的插件是否被加载,在已被加载的情况下返回插件所属的对象.
     * 注意,插件的名称是区分大小写的.
     * <p/>
     * 原文:
     * Checks if the given plugin is loaded and returns it when applicable
     * <p>
     * Please note that the name of the plugin is case-sensitive
     *
     * @param name Name of the plugin to check
     * @return Plugin if it exists, otherwise null
     */
    public Plugin getPlugin(String name);

    /**
     * 获取所有已载入的插件对象.
     * <p/>
     * 原文:
     * Gets a list of all currently loaded plugins.
     * @return 返回类型为Plugin的数组
     */
    public Plugin[] getPlugins();

    /**
     * 检查指定名称的插件是否启用.
     * 注意,插件的名称是区分大小写的.
     * <p/>
     * 原文:
     * Checks if the given plugin is enabled or not
     * <p>
     * Please note that the name of the plugin is case-sensitive.
     *
     * @param name 要检查的插件的名称
     * @return 如果插件已经启用了,返回true;反之,没有启用择返回false
     */
    public boolean isPluginEnabled(String name);

    /**
     * 检查指定插件是否启用.
     * <p/>
     * 原文:
     * Checks if the given plugin is enabled or not.
     *
     * @param plugin 要检查的插件所属的Plugin对象
     * @return 如果插件已经启用了,返回true;反之,没有启用则返回false
     */
    public boolean isPluginEnabled(Plugin plugin);

    /**
     * Loads the plugin in the specified file
     * <p>
     * File must be valid according to the current enabled Plugin interfaces
     *
     * @param file File containing the plugin to load
     * @return The Plugin loaded, or null if it was invalid
     * @throws InvalidPluginException Thrown when the specified file is not a
     *     valid plugin
     * @throws InvalidDescriptionException Thrown when the specified file
     *     contains an invalid description
     * @throws UnknownDependencyException If a required dependency could not
     *     be resolved
     */
    public Plugin loadPlugin(File file) throws InvalidPluginException, InvalidDescriptionException, UnknownDependencyException;

    /**
     * 载入指定目录内的插件.
     * <p/>
     * 原文:
     * Loads the plugins contained within the specified directory.
     *
     * @param 指定目录的File对象
     * @return 返回带有已成功载入的插件Plugin对象的数组
     */
    public Plugin[] loadPlugins(File directory);

    /**
     * 停用所有已载入的插件.
     * <p/>
     * 原文:
     * Disables all the loaded plugins.
     */
    public void disablePlugins();

    /**
     * 停用并清除所有已启用插件的Plugin对象.
     * <p/>
     * 原文:
     * Disables and removes all plugins.
     */
    public void clearPlugins();

    /**
     * Calls an event with the given details
     *
     * @param event Event details
     * @throws IllegalStateException Thrown when an asynchronous event is
     *     fired from synchronous code.
     *     <p>
     *     <i>Note: This is best-effort basis, and should not be used to test
     *     synchronized state. This is an indicator for flawed flow logic.</i>
     */
    public void callEvent(Event event) throws IllegalStateException;

    /**
     * 注册指定事件监听器中的所有事件执行器所属的事件.
     * <p/>
     * 原文:
     * Registers all the events in the given listener class
     *
     * @param listener 要注册的监听器
     * @param plugin 监听器所属的插件
     */
    public void registerEvents(Listener listener, Plugin plugin);

    /**
     * Registers the specified executor to the given event class
     *
     * @param event Event type to register
     * @param listener Listener to register
     * @param priority Priority to register this event at
     * @param executor EventExecutor to register
     * @param plugin Plugin to register
     */
    public void registerEvent(Class<? extends Event> event, Listener listener, EventPriority priority, EventExecutor executor, Plugin plugin);

    /**
     * Registers the specified executor to the given event class
     *
     * @param event Event type to register
     * @param listener Listener to register
     * @param priority Priority to register this event at
     * @param executor EventExecutor to register
     * @param plugin Plugin to register
     * @param ignoreCancelled Whether to pass cancelled events or not
     */
    public void registerEvent(Class<? extends Event> event, Listener listener, EventPriority priority, EventExecutor executor, Plugin plugin, boolean ignoreCancelled);

    /**
     * 启用指定的插件.
     * 对已经启用的插件调用本方法将没有任何作用.
     * <p/>
     * 原文:
     * Enables the specified plugin
     * <p>
     * Attempting to enable a plugin that is already enabled will have no
     * effect
     *
     * @param plugin 要启用的插件
     */
    public void enablePlugin(Plugin plugin);

    /**
     * 启用指定的插件.
     * 对已经启用的插件调用本方法将没有任何作用.
     * <p/>
     * 原文:
     * Attempting to disable a plugin that is not enabled will have no effect
     *
     * @param plugin 要停用的插件
     */
    public void disablePlugin(Plugin plugin);

    /**
     * Gets a {@link Permission} from its fully qualified name
     *
     * @param name Name of the permission
     * @return Permission, or null if none
     */
    public Permission getPermission(String name);

    /**
     * Adds a {@link Permission} to this plugin manager.
     * <p>
     * If a permission is already defined with the given name of the new
     * permission, an exception will be thrown.
     *
     * @param perm Permission to add
     * @throws IllegalArgumentException Thrown when a permission with the same
     *     name already exists
     */
    public void addPermission(Permission perm);

    /**
     * Removes a {@link Permission} registration from this plugin manager.
     * <p>
     * If the specified permission does not exist in this plugin manager,
     * nothing will happen.
     * <p>
     * Removing a permission registration will <b>not</b> remove the
     * permission from any {@link Permissible}s that have it.
     *
     * @param perm Permission to remove
     */
    public void removePermission(Permission perm);

    /**
     * Removes a {@link Permission} registration from this plugin manager.
     * <p>
     * If the specified permission does not exist in this plugin manager,
     * nothing will happen.
     * <p>
     * Removing a permission registration will <b>not</b> remove the
     * permission from any {@link Permissible}s that have it.
     *
     * @param name Permission to remove
     */
    public void removePermission(String name);

    /**
     * 获取普通玩家默认拥有的权限或op默认拥有的权限.
     * <p/>
     * 原文:
     * Gets the default permissions for the given op status
     *
     * @param 是否获取op状态下默认拥有的权限
     * @return 返回 普通玩家/OP 默认拥有的权限
     */
    public Set<Permission> getDefaultPermissions(boolean op);

    /**
     * Recalculates the defaults for the given {@link Permission}.
     * <p>
     * This will have no effect if the specified permission is not registered
     * here.
     *
     * @param perm Permission to recalculate
     */
    public void recalculatePermissionDefaults(Permission perm);

    /**
     * Subscribes the given Permissible for information about the requested
     * Permission, by name.
     * <p>
     * If the specified Permission changes in any form, the Permissible will
     * be asked to recalculate.
     *
     * @param permission Permission to subscribe to
     * @param permissible Permissible subscribing
     */
    public void subscribeToPermission(String permission, Permissible permissible);

    /**
     * Unsubscribes the given Permissible for information about the requested
     * Permission, by name.
     *
     * @param permission Permission to unsubscribe from
     * @param permissible Permissible subscribing
     */
    public void unsubscribeFromPermission(String permission, Permissible permissible);

    /**
     * Gets a set containing all subscribed {@link Permissible}s to the given
     * permission, by name
     *
     * @param permission Permission to query for
     * @return Set containing all subscribed permissions
     */
    public Set<Permissible> getPermissionSubscriptions(String permission);

    /**
     * Subscribes to the given Default permissions by operator status
     * <p>
     * If the specified defaults change in any form, the Permissible will be
     * asked to recalculate.
     *
     * @param op Default list to subscribe to
     * @param permissible Permissible subscribing
     */
    public void subscribeToDefaultPerms(boolean op, Permissible permissible);

    /**
     * Unsubscribes from the given Default permissions by operator status
     *
     * @param op Default list to unsubscribe from
     * @param permissible Permissible subscribing
     */
    public void unsubscribeFromDefaultPerms(boolean op, Permissible permissible);

    /**
     * Gets a set containing all subscribed {@link Permissible}s to the given
     * default list, by op status
     *
     * @param op Default list to query for
     * @return Set containing all subscribed permissions
     */
    public Set<Permissible> getDefaultPermSubscriptions(boolean op);

    /**
     * 获得所有已注册的权限的集合(Set).
     * 返回的Set对象是复制原有对象获得的,对返回的Set对象进行修改不会影响原本的Set对象.
     * Gets a set of all registered permissions.
     * <p>
     * This set is a copy and will not be modified live.
     *
     * @return 包含当前所有已注册权限的集合(Set)对象
     */
    public Set<Permission> getPermissions();

    /**
     * Returns whether or not timing code should be used for event calls
     *
     * @return True if event timings are to be used
     */
    public boolean useTimings();
}
