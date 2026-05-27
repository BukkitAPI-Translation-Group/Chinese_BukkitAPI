package org.bukkit.plugin;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.event.server.ServiceRegisterEvent;
import org.bukkit.event.server.ServiceUnregisterEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 一个简单的服务管理器.
 */
public class SimpleServicesManager implements ServicesManager {

    /**
     * 提供者映射.
     */
    private final Map<Class<?>, List<RegisteredServiceProvider<?>>> providers = new HashMap<Class<?>, List<RegisteredServiceProvider<?>>>();

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
    @Override
    public <T> void register(@NotNull Class<T> service, @NotNull T provider, @NotNull Plugin plugin, @NotNull ServicePriority priority) {
        RegisteredServiceProvider<T> registeredProvider = null;
        synchronized (providers) {
            List<RegisteredServiceProvider<?>> registered = providers.get(service);
            if (registered == null) {
                registered = new ArrayList<RegisteredServiceProvider<?>>();
                providers.put(service, registered);
            }

            registeredProvider = new RegisteredServiceProvider<T>(service, provider, priority, plugin);

            // Insert the provider into the collection, much more efficient big O than sort
            int position = Collections.binarySearch(registered, registeredProvider);
            if (position < 0) {
                registered.add(-(position + 1), registeredProvider);
            } else {
                registered.add(position, registeredProvider);
            }

        }
        Bukkit.getServer().getPluginManager().callEvent(new ServiceRegisterEvent(registeredProvider));
    }

    /**
     * 注销特定插件注册的所有提供者.
     * <p>
     * 原文：
     * Unregister all the providers registered by a particular plugin.
     *
     * @param plugin 要注销的插件
     */
    @Override
    public void unregisterAll(@NotNull Plugin plugin) {
        ArrayList<ServiceUnregisterEvent> unregisteredEvents = new ArrayList<ServiceUnregisterEvent>();
        synchronized (providers) {
            Iterator<Map.Entry<Class<?>, List<RegisteredServiceProvider<?>>>> it = providers.entrySet().iterator();

            try {
                while (it.hasNext()) {
                    Map.Entry<Class<?>, List<RegisteredServiceProvider<?>>> entry = it.next();
                    Iterator<RegisteredServiceProvider<?>> it2 = entry.getValue().iterator();

                    try {
                        // Removed entries that are from this plugin

                        while (it2.hasNext()) {
                            RegisteredServiceProvider<?> registered = it2.next();

                            if (registered.getPlugin().equals(plugin)) {
                                it2.remove();
                                unregisteredEvents.add(new ServiceUnregisterEvent(registered));
                            }
                        }
                    } catch (NoSuchElementException e) { // Why does Java suck
                    }

                    // Get rid of the empty list
                    if (entry.getValue().size() == 0) {
                        it.remove();
                    }
                }
            } catch (NoSuchElementException e) {}
        }
        for (ServiceUnregisterEvent event : unregisteredEvents) {
            Bukkit.getServer().getPluginManager().callEvent(event);
        }
    }

    /**
     * 注销特定服务的特定提供者.
     * <p>
     * 原文：
     * Unregister a particular provider for a particular service.
     *
     * @param service 服务接口
     * @param provider 服务提供者实现
     */
    @Override
    public void unregister(@NotNull Class<?> service, @NotNull Object provider) {
        ArrayList<ServiceUnregisterEvent> unregisteredEvents = new ArrayList<ServiceUnregisterEvent>();
        synchronized (providers) {
            Iterator<Map.Entry<Class<?>, List<RegisteredServiceProvider<?>>>> it = providers.entrySet().iterator();

            try {
                while (it.hasNext()) {
                    Map.Entry<Class<?>, List<RegisteredServiceProvider<?>>> entry = it.next();

                    // We want a particular service
                    if (entry.getKey() != service) {
                        continue;
                    }

                    Iterator<RegisteredServiceProvider<?>> it2 = entry.getValue().iterator();

                    try {
                        // Removed entries that are from this plugin

                        while (it2.hasNext()) {
                            RegisteredServiceProvider<?> registered = it2.next();

                            if (registered.getProvider() == provider) {
                                it2.remove();
                                unregisteredEvents.add(new ServiceUnregisterEvent(registered));
                            }
                        }
                    } catch (NoSuchElementException e) { // Why does Java suck
                    }

                    // Get rid of the empty list
                    if (entry.getValue().size() == 0) {
                        it.remove();
                    }
                }
            } catch (NoSuchElementException e) {}
        }
        for (ServiceUnregisterEvent event : unregisteredEvents) {
            Bukkit.getServer().getPluginManager().callEvent(event);
        }
    }

    /**
     * 注销特定提供者.
     * <p>
     * 原文：
     * Unregister a particular provider.
     *
     * @param provider 服务提供者实现
     */
    @Override
    public void unregister(@NotNull Object provider) {
        ArrayList<ServiceUnregisterEvent> unregisteredEvents = new ArrayList<ServiceUnregisterEvent>();
        synchronized (providers) {
            Iterator<Map.Entry<Class<?>, List<RegisteredServiceProvider<?>>>> it = providers.entrySet().iterator();

            try {
                while (it.hasNext()) {
                    Map.Entry<Class<?>, List<RegisteredServiceProvider<?>>> entry = it.next();
                    Iterator<RegisteredServiceProvider<?>> it2 = entry.getValue().iterator();

                    try {
                        // Removed entries that are from this plugin

                        while (it2.hasNext()) {
                            RegisteredServiceProvider<?> registered = it2.next();

                            if (registered.getProvider().equals(provider)) {
                                it2.remove();
                                unregisteredEvents.add(new ServiceUnregisterEvent(registered));
                            }
                        }
                    } catch (NoSuchElementException e) { // Why does Java suck
                    }

                    // Get rid of the empty list
                    if (entry.getValue().size() == 0) {
                        it.remove();
                    }
                }
            } catch (NoSuchElementException e) {}
        }
        for (ServiceUnregisterEvent event : unregisteredEvents) {
            Bukkit.getServer().getPluginManager().callEvent(event);
        }
    }

    /**
     * 查询提供者. 如果没有为服务注册提供者, 可能返回 null. 返回优先级最高的提供者.
     * <p>
     * 原文：
     * Queries for a provider. This may return if no provider has been registered for a service. The highest priority provider is returned.
     *
     * @param <T> 服务接口类型
     * @param service 服务接口
     * @return 提供者或 null
     */
    @Override
    @Nullable
    public <T> T load(@NotNull Class<T> service) {
        synchronized (providers) {
            List<RegisteredServiceProvider<?>> registered = providers.get(service);

            if (registered == null) {
                return null;
            }

            // This should not be null!
            return service.cast(registered.get(0).getProvider());
        }
    }

    /**
     * 查询提供者注册信息. 如果没有为服务注册提供者, 可能返回 null.
     * <p>
     * 原文：
     * Queries for a provider registration. This may return if no provider has been registered for a service.
     *
     * @param <T> 服务接口类型
     * @param service 服务接口
     * @return 提供者注册信息或 null
     */
    @Override
    @Nullable
    @SuppressWarnings("unchecked")
    public <T> RegisteredServiceProvider<T> getRegistration(@NotNull Class<T> service) {
        synchronized (providers) {
            List<RegisteredServiceProvider<?>> registered = providers.get(service);

            if (registered == null) {
                return null;
            }

            // This should not be null!
            return (RegisteredServiceProvider<T>) registered.get(0);
        }
    }

    /**
     * 获取插件的提供者注册信息.
     * <p>
     * 原文：
     * Get registrations of providers for a plugin.
     *
     * @param plugin 插件
     * @return 提供者注册信息
     */
    @Override
    @NotNull
    public List<RegisteredServiceProvider<?>> getRegistrations(@NotNull Plugin plugin) {
        ImmutableList.Builder<RegisteredServiceProvider<?>> ret = ImmutableList.<RegisteredServiceProvider<?>>builder();
        synchronized (providers) {
            for (List<RegisteredServiceProvider<?>> registered : providers.values()) {
                for (RegisteredServiceProvider<?> provider : registered) {
                    if (provider.getPlugin().equals(plugin)) {
                        ret.add(provider);
                    }
                }
            }
        }
        return ret.build();
    }

    /**
     * 获取服务的提供者注册信息. 返回的列表是不可修改的副本.
     * <p>
     * 原文：
     * Get registrations of providers for a service. The returned list is an unmodifiable copy.
     *
     * @param <T> 服务接口类型
     * @param service 服务接口
     * @return 注册信息列表的副本
     */
    @Override
    @NotNull
    @SuppressWarnings("unchecked")
    public <T> List<RegisteredServiceProvider<T>> getRegistrations(@NotNull Class<T> service) {
        ImmutableList.Builder<RegisteredServiceProvider<T>> ret;
        synchronized (providers) {
            List<RegisteredServiceProvider<?>> registered = providers.get(service);

            if (registered == null) {
                return ImmutableList.<RegisteredServiceProvider<T>>of();
            }

            ret = ImmutableList.<RegisteredServiceProvider<T>>builder();

            for (RegisteredServiceProvider<?> provider : registered) {
                ret.add((RegisteredServiceProvider<T>) provider);
            }

        }
        return ret.build();
    }

    /**
     * 获取已知服务列表. 如果服务有已注册的提供者, 则该服务是已知的.
     * <p>
     * 原文：
     * Get a list of known services. A service is known if it has registered providers for it.
     *
     * @return 已知服务集合的副本
     */
    @Override
    @NotNull
    public Set<Class<?>> getKnownServices() {
        synchronized (providers) {
            return ImmutableSet.<Class<?>>copyOf(providers.keySet());
        }
    }

    /**
     * 返回是否已为服务注册了提供者.
     * <p>
     * 原文：
     * Returns whether a provider has been registered for a service.
     *
     * @param <T> 服务类型
     * @param service 要检查的服务
     * @return 当且仅当有已注册的提供者时返回 true
     */
    @Override
    public <T> boolean isProvidedFor(@NotNull Class<T> service) {
        synchronized (providers) {
            return providers.containsKey(service);
        }
    }
}
