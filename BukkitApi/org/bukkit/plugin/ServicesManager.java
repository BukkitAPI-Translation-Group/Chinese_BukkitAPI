package org.bukkit.plugin;

import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 管理服务和服务提供者. 服务是定义提供者必须实现的方法列表的接口. 提供者是这些服务的实现. 可以从服务管理器查询提供者以使用服务 (如果可用). 如果多个插件注册了同一服务, 则优先级最高的服务优先.
 */
public interface ServicesManager {

    /**
     * 注册一个服务的提供者.
     * <p>
     * 原文：
     * Register a provider of a service.
     *
     * @param <T> 提供者类型
     * @param service 服务类
     * @param provider 要注册的提供者
     * @param plugin 拥有该提供者的插件
     * @param priority 提供者的优先级
     */
    public <T> void register(@NotNull Class<T> service, @NotNull T provider, @NotNull Plugin plugin, @NotNull ServicePriority priority);

    /**
     * 注销特定插件注册的所有提供者.
     * <p>
     * 原文：
     * Unregister all the providers registered by a particular plugin.
     *
     * @param plugin 要注销的插件
     */
    public void unregisterAll(@NotNull Plugin plugin);

    /**
     * 注销特定服务的特定提供者.
     * <p>
     * 原文：
     * Unregister a particular provider for a particular service.
     *
     * @param service 服务接口
     * @param provider 服务提供者实现
     */
    public void unregister(@NotNull Class<?> service, @NotNull Object provider);

    /**
     * 注销特定提供者.
     * <p>
     * 原文：
     * Unregister a particular provider.
     *
     * @param provider 服务提供者实现
     */
    public void unregister(@NotNull Object provider);

    /**
     * 查询提供者. 如果没有为服务注册提供者, 可能返回 null. 返回优先级最高的提供者.
     * <p>
     * 原文：
     * Queries for a provider. This may return null if no provider has been registered for a service. The highest priority provider is returned.
     *
     * @param <T> 服务接口类型
     * @param service 服务接口
     * @return 提供者或 null
     */
    @Nullable
    public <T> T load(@NotNull Class<T> service);

    /**
     * 查询提供者注册信息. 如果没有为服务注册提供者, 可能返回 null.
     * <p>
     * 原文：
     * Queries for a provider registration. This may return null if no provider has been registered for a service.
     *
     * @param <T> 服务接口类型
     * @param service 服务接口
     * @return 提供者注册信息或 null
     */
    @Nullable
    public <T> RegisteredServiceProvider<T> getRegistration(@NotNull Class<T> service);

    /**
     * 获取插件的提供者注册信息.
     * <p>
     * 原文：
     * Get registrations of providers for a plugin.
     *
     * @param plugin 插件
     * @return 提供者注册信息
     */
    @NotNull
    public List<RegisteredServiceProvider<?>> getRegistrations(@NotNull Plugin plugin);

    /**
     * 获取服务的提供者注册信息. 返回的列表是不可修改的.
     * <p>
     * 原文：
     * Get registrations of providers for a service. The returned list is unmodifiable.
     *
     * @param <T> 服务接口类型
     * @param service 服务接口
     * @return 注册信息列表
     */
    @NotNull
    public <T> Collection<RegisteredServiceProvider<T>> getRegistrations(@NotNull Class<T> service);

    /**
     * 获取已知服务列表. 如果服务有已注册的提供者, 则该服务是已知的.
     * <p>
     * 原文：
     * Get a list of known services. A service is known if it has registered providers for it.
     *
     * @return 已知服务列表
     */
    @NotNull
    public Collection<Class<?>> getKnownServices();

    /**
     * 返回是否已为服务注册了提供者. 不要先检查此方法然后再调用 <code>load(service)</code>, 因为那将是非线程安全的情况.
     * <p>
     * 原文：
     * Returns whether a provider has been registered for a service. Do not check this first only to call load(service) later, as that would be a non-thread safe situation.
     *
     * @param <T> 服务类型
     * @param service 要检查的服务
     * @return 是否有已注册的提供者
     */
    public <T> boolean isProvidedFor(@NotNull Class<T> service);

}
