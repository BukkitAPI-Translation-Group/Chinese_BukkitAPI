package org.bukkit.plugin;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

/**
 * 存储插件监听器的相关信息.
 */
public class RegisteredListener {
    private final Listener listener;
    private final EventPriority priority;
    private final Plugin plugin;
    private final EventExecutor executor;
    private final boolean ignoreCancelled;

    public RegisteredListener(@NotNull final Listener listener, @NotNull final EventExecutor executor, @NotNull final EventPriority priority, @NotNull final Plugin plugin, final boolean ignoreCancelled) {
        this.listener = listener;
        this.priority = priority;
        this.plugin = plugin;
        this.executor = executor;
        this.ignoreCancelled = ignoreCancelled;
    }

    /**
     * 获取此注册的监听器.
     * <p>
     * 原文：
     * Gets the listener for this registration
     *
     * @return 已注册的监听器
     */
    @NotNull
    public Listener getListener() {
        return listener;
    }

    /**
     * 获取此注册的插件.
     * <p>
     * 原文：
     * Gets the plugin for this registration
     *
     * @return 已注册的插件
     */
    @NotNull
    public Plugin getPlugin() {
        return plugin;
    }

    /**
     * 获取此注册的优先级.
     * <p>
     * 原文：
     * Gets the priority for this registration
     *
     * @return 已注册的优先级
     */
    @NotNull
    public EventPriority getPriority() {
        return priority;
    }

    /**
     * 调用事件执行器.
     * <p>
     * 原文：
     * Calls the event executor
     *
     * @param event 事件对象
     * @throws EventException 如果事件处理器抛出异常
     */
    public void callEvent(@NotNull final Event event) throws EventException {
        if (event instanceof Cancellable) {
            if (((Cancellable) event).isCancelled() && isIgnoringCancelled()) {
                return;
            }
        }
        executor.execute(listener, event);
    }

    /**
     * 此监听器是否忽略已取消的事件.
     * <p>
     * 原文：
     * Whether this listener accepts cancelled events
     *
     * @return 当忽略已取消事件时返回 true
     */
    public boolean isIgnoringCancelled() {
        return ignoreCancelled;
    }
}
