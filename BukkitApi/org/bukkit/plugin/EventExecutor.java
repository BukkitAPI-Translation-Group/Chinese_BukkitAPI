package org.bukkit.plugin;

import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.Listener;

/**
 * 定义了事件调用插件的类的接口。
 */
public interface EventExecutor {
    public void execute(Listener listener, Event event) throws EventException;
}