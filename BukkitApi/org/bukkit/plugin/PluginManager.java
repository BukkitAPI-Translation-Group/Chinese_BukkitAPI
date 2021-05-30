package org.bukkit.plugin;

import java.io.File;
import java.util.Set;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 服务器的插件管理器.
 */
public interface PluginManager {

    /**
     * 注册指定的插件加载器.
     * <p>
     * 原文:Registers the specified plugin loader
     *
     * @param loader 要注册的 PluginLoader 类
     * @throws IllegalArgumentException 当给定的类不是一个有效的 PluginLoader 时抛出
     */
    public void registerInterface(@NotNull Class<? extends PluginLoader> loader) throws IllegalArgumentException;

    /**
     * 检测指定插件是否已加载并在合适时返回其对象.
     * <p>
     * 请注意插件名区分大小写.
     * <p>
     * 原文:Checks if the given plugin is loaded and returns it when applicable
     * <p>
     * Please note that the name of the plugin is case-sensitive
     *
     * @param name 要检测的插件的名称
     * @return 如果此插件存在, 返回对应插件对象, 否则返回null
     */
    @Nullable
    public Plugin getPlugin(@NotNull String name);

    /**
     * 获取所有已载入的插件对象.
     * <p>
     * 原文:
     * Gets a list of all currently loaded plugins.
     * @return 返回类型为Plugin的数组
     */
    @NotNull
    public Plugin[] getPlugins();

    /**
     * 检测指定插件是否已启用.
     * <p>
     * 请注意插件名区分大小写.
     * <p>
     * 原文:Checks if the given plugin is enabled or not
     * <p>
     * Please note that the name of the plugin is case-sensitive.
     *
     * @param name 要检测的插件的名称
     * @return 如果此插件已启用, 返回true
     */
    public boolean isPluginEnabled(@NotNull String name);

    /**
     * 检查指定插件是否启用.
     * <p>
     * 原文:
     * Checks if the given plugin is enabled or not.
     *
     * @param plugin 要检测的插件的对象
     * @return 如果此插件已启用, 返回true
     */
    @Contract("null -> false")
    public boolean isPluginEnabled(@Nullable Plugin plugin);

    /**
     * 加载某个文件为插件.
     * <p>
     * 文件必须对当前的插件加载器有效才会被加载.
     * <p>
     * 原文:Loads the plugin in the specified file
     * <p>
     * File must be valid according to the current enabled Plugin interfaces
     *
     * @param file 要加载的插件文件
     * @return 加载成功后的插件对象, 若插件文件无效返回null
     * @throws InvalidPluginException 若指定文件不是一个有效的插件
     * @throws InvalidDescriptionException 若插件包含一个无效的插件描述文件(plugin.yml)
     * @throws UnknownDependencyException 若插件要求的依赖找不到
     */
    @Nullable
    public Plugin loadPlugin(@NotNull File file) throws InvalidPluginException, InvalidDescriptionException, UnknownDependencyException;

    /**
     * 载入指定目录内的插件.
     * <p>
     * 原文:
     * Loads the plugins contained within the specified directory.
     *
     * @param directory 指定目录的File对象
     * @return 返回带有已成功载入的插件Plugin对象的数组
     */
    @NotNull
    public Plugin[] loadPlugins(@NotNull File directory);

    /**
     * 停用所有已载入的插件.
     * <p>
     * 原文:
     * Disables all the loaded plugins.
     */
    public void disablePlugins();

    /**
     * 停用并清除所有已启用插件的Plugin对象.
     * <p>
     * 原文:
     * Disables and removes all plugins.
     */
    public void clearPlugins();

    /**
     * 调用一个具有详细信息的事件.
     * <p>
     * 译注:(针对 Bukkkit 中对本接口的唯一实现{@link SimplePluginManager}来说)本方法是线程安全的, 但不可以在同步代码块/同步线程中触发异步事件,
     * 也不可以从异步线程中触发同步事件.
     * <p>
     * 原文:Calls an event with the given details
     *
     * @param event 事件
     * @throws IllegalStateException 当从同步代码中触发异步事件时抛出
     *     <p>
     *     <i>注意:这是插件开发者应尽的义务, 不应用其来测试同步状态. 这是逻辑流有缺陷的迹象</i>
     */
    public void callEvent(@NotNull Event event) throws IllegalStateException;

    /**
     * 注册在指定监听器类中的所有事件.
     * <p>
     * 原文:Registers all the events in the given listener class
     *
     * @param listener 要注册的监听器
     * @param plugin 注册事件的插件
     */
    public void registerEvents(@NotNull Listener listener, @NotNull Plugin plugin);

    /**
     * 将指定的执行器注册至指定的事件类.
     * <p>
     * 原文:Registers the specified executor to the given event class
     *
     * @param event 要注册的事件类型
     * @param listener 要注册的监听器
     * @param priority 要注册的事件的优先级
     * @param executor 要注册的EventExecutor
     * @param plugin 注册事件的插件
     */
    public void registerEvent(@NotNull Class<? extends Event> event, @NotNull Listener listener, @NotNull EventPriority priority, @NotNull EventExecutor executor, @NotNull Plugin plugin);

    /**
     * 将指定的执行器注册至指定的事件类.
     * <p>
     * 原文:Registers the specified executor to the given event class
     *
     * @param event 要注册的事件类型
     * @param listener 要注册的监听器
     * @param priority 要注册的事件的优先级
     * @param executor 要注册的EventExecutor
     * @param plugin 注册事件的插件
     * @param ignoreCancelled 是否忽略已取消的事件
     */
    public void registerEvent(@NotNull Class<? extends Event> event, @NotNull Listener listener, @NotNull EventPriority priority, @NotNull EventExecutor executor, @NotNull Plugin plugin, boolean ignoreCancelled);

    /**
     * 启用指定插件.
     * <p>
     * 尝试启用一个已启用的插件, 什么都不会发生.
     * <p>
     * 原文:Enables the specified plugin
     * <p>
     * Attempting to enable a plugin that is already enabled will have no
     * effect
     *
     * @param plugin 要启用的插件
     */
    public void enablePlugin(@NotNull Plugin plugin);

    /**
     * 停用指定的插件.
     * <p>
     * 尝试停用一个已停用的插件, 什么都不会发生.
     * <p>
     * 原文:Disables the specified plugin
     * <p>
     * Attempting to disable a plugin that is not enabled will have no effect
     *
     * @param plugin 要停用的插件
     */
    public void disablePlugin(@NotNull Plugin plugin);

    /**
     * 以指定的完整权限节点获取对应{@link Permission}对象.
     * <p>
     * 原文:Gets a {@link Permission} from its fully qualified name
     *
     * @param name Name of the permission
     * @return 对应{@link Permission}对象, 若权限节点不存在返回null
     */
    @Nullable
    public Permission getPermission(@NotNull String name);

    /**
     * 添加一个{@link Permission}至本插件管理器.
     * <p>
     * 如果已有同名权限, 会抛出一个异常.
     * <p>
     * 原文:Adds a {@link Permission} to this plugin manager.
     * <p>
     * If a permission is already defined with the given name of the new
     * permission, an exception will be thrown.
     *
     * @param perm 要添加的权限
     * @throws IllegalArgumentException 如果同名权限已存在
     */
    public void addPermission(@NotNull Permission perm);

    /**
     * 从本插件管理器中移除已注册的{@link Permission 权限}.
     * <p>
     * 如果指定的权限未在本插件管理器中注册, 什么都不会发生.
     * <p>
     * 原文:Removes a {@link Permission} registration from this plugin manager.
     * <p>
     * If the specified permission does not exist in this plugin manager,
     * nothing will happen.
     * <p>
     * Removing a permission registration will <b>not</b> remove the
     * permission from any {@link Permissible}s that have it.
     *
     * @param perm 要移除的权限
     */
    public void removePermission(@NotNull Permission perm);

    /**
     * 从本插件管理器中移除已注册的{@link Permission 权限}.
     * <p>
     * 如果指定的权限未在本插件管理器中注册, 什么都不会发生.
     * <p>
     * 原文:Removes a {@link Permission} registration from this plugin manager.
     * <p>
     * If the specified permission does not exist in this plugin manager,
     * nothing will happen.
     * <p>
     * Removing a permission registration will <b>not</b> remove the
     * permission from any {@link Permissible}s that have it.
     *
     * @param name 要移除的权限
     */
    public void removePermission(@NotNull String name);

    /**
     * 获取普通玩家默认拥有的权限或op默认拥有的权限.
     * <p>
     * 原文:
     * Gets the default permissions for the given op status
     *
     * @param op 是否获取op状态下默认拥有的权限
     * @return 返回 普通玩家/OP 默认拥有的权限
     */
    @NotNull
    public Set<Permission> getDefaultPermissions(boolean op);

    /**
     * 重新计算指定{@link Permission 权限}的默认值.
     * <p>
     * 若指定的权限未在本插件管理器注册, 将没有效果.
     * <p>
     * 原文:Recalculates the defaults for the given {@link Permission}.
     * <p>
     * This will have no effect if the specified permission is not registered
     * here.
     *
     * @param perm 要重算的权限
     */
    public void recalculatePermissionDefaults(@NotNull Permission perm);

    /**
     * 以指定的权限名订阅与其有关的 Permissible.
     * <p>
     * 若指定的权限以任何形式改变, 要求重新计算传入的Permissible.
     * <p>
     * 原文:Subscribes the given Permissible for information about the requested
     * Permission, by name.
     * <p>
     * If the specified Permission changes in any form, the Permissible will
     * be asked to recalculate.
     *
     * @param permission 要订阅的权限
     * @param permissible 要订阅的Permissible
     */
    public void subscribeToPermission(@NotNull String permission, @NotNull Permissible permissible);

    /**
     * 以指定的权限名退订与其有关的 Permissible.
     * <p>
     * 原文:Unsubscribes the given Permissible for information about the requested
     * Permission, by name.
     *
     * @param permission 要退订的权限
     * @param permissible 已订阅的Permissible
     */
    public void unsubscribeFromPermission(@NotNull String permission, @NotNull Permissible permissible);

    /**
     * 根据权限名获取此权限已订阅的{@link Permissible}的集合.
     * <p>
     * 原文:Gets a set containing all subscribed {@link Permissible}s to the given
     * permission, by name
     *
     * @param permission 要检索的权限
     * @return 包含此权限已订阅的所有{@link Permissible}的集合
     */
    @NotNull
    public Set<Permissible> getPermissionSubscriptions(@NotNull String permission);

    /**
     * 为普通玩家/op默认权限订阅指定{@link Permissible}.
     * <p>
     * 若指定的默认权限列表以任何形式改动, 要求重新计算传入的Permissible.
     * <p>
     * 原文:Subscribes to the given Default permissions by operator status
     * <p>
     * If the specified defaults change in any form, the Permissible will be
     * asked to recalculate.
     *
     * @param op 是否根据op的默认权限列表订阅
     * @param permissible 要订阅的Permissible
     */
    public void subscribeToDefaultPerms(boolean op, @NotNull Permissible permissible);

    /**
     * 退订普通玩家/op默认权限已订阅的{@link Permissible}.
     * <p>
     * 原文:Unsubscribes from the given Default permissions by operator status
     *
     * @param op 是否根据op的默认权限列表退订
     * @param permissible 权限已订阅的Permissible
     */
    public void unsubscribeFromDefaultPerms(boolean op, @NotNull Permissible permissible);

    /**
     * 获取普通玩家/op默认权限列表已订阅的{@link Permissible}.
     * <p>
     * 原文:Gets a set containing all subscribed {@link Permissible}s to the given
     * default list, by op status
     *
     * @param op 是否根据op的默认权限列表检索
     * @return 包含所有权限订阅者的集合
     */
    @NotNull
    public Set<Permissible> getDefaultPermSubscriptions(boolean op);

    /**
     * 获取已注册的权限的集合.
     * <p>
     * 此集合是一个副本, 对其编辑不会作用于内部的权限列表.
     * <p>
     * 原文:Gets a set of all registered permissions.
     * <p>
     * This set is a copy and will not be modified live.
     *
     * @return 包含所有已注册权限的集合
     */
    @NotNull
    public Set<Permission> getPermissions();

    /**
     * 返回是否在事件调用中使用插件计时器.
     * <p>
     * 译注:Timings是一个性能分析工具, 通过Timings可以了解
     * 服务器的性能损耗情况, 通过它可以定位插件/服务器代码中性能较差的方法, 并针对性地进行优化.
     * 可以通过"/timings on"开始记录, "/timings paste"上传记录, "/timings off"关闭记录 (仅针对Spigot及其衍生服务端).
     * <p>
     * 原文:Returns whether or not timing code should be used for event calls
     *
     * @return 若已启用Timings
     */
    public boolean useTimings();
}
