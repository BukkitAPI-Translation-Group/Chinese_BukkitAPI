package org.bukkit.event.server;

import org.bukkit.plugin.RegisteredServiceProvider;

/**
 * 事件关联的注册服务器.这就相当于一个{@link org.bukkit.plugin.ServicesManager}.
 */
public abstract class ServiceEvent extends ServerEvent {
    private final RegisteredServiceProvider<?> provider;

    public ServiceEvent(final RegisteredServiceProvider<?> provider) {
        this.provider = provider;
    }

    public RegisteredServiceProvider<?> getProvider() {
        return provider;
    }
}