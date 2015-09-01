package org.bukkit.event.server;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.RegisteredServiceProvider;

/**
 * 当一个服务注册时调用. 
 * <p>
 * 注意:注册和注销的事件顺序不互相依赖.
 */
public class ServiceRegisterEvent extends ServiceEvent {
    private static final HandlerList handlers = new HandlerList();

    public ServiceRegisterEvent(RegisteredServiceProvider<?> registeredProvider) {
        super(registeredProvider);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
