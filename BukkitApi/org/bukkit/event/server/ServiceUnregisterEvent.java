package org.bukkit.event.server;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.RegisteredServiceProvider;

/**
 * 当一个服务注销时调用.
 * <p>
 * 注意:注册和注销的事件顺序不互相依赖.
 */
public class ServiceUnregisterEvent extends ServiceEvent {
    private static final HandlerList handlers = new HandlerList();

    public ServiceUnregisterEvent(RegisteredServiceProvider<?> serviceProvider) {
        super(serviceProvider);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
