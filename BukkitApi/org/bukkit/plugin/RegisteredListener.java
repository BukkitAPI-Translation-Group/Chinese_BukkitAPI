package org.bukkit.plugin;

import org.bukkit.event.*;

/**
 * 与该插件信息相关的监听器。
 * Stores relevant information for plugin listeners
 */
public class RegisteredListener {
    private final Listener listener;
    private final EventPriority priority;
    private final Plugin plugin;
    private final EventExecutor executor;
    private final boolean ignoreCancelled;

    public RegisteredListener(final Listener listener, final EventExecutor executor, final EventPriority priority, final Plugin plugin, final boolean ignoreCancelled) {
        this.listener = listener;
        this.priority = priority;
        this.plugin = plugin;
        this.executor = executor;
        this.ignoreCancelled = ignoreCancelled;
    }

    /**
     * 注册此监听器。
     * 原文：Gets the listener for this registration
     *
     * @return 已注册该监听器。
     */
    public Listener getListener() {
        return listener;
    }

    /**
     * 注册此插件。
     * 原文：Gets the plugin for this registration
     *
     * @return 已注册该插件。
     */
    public Plugin getPlugin() {
        return plugin;
    }

    /**
     * 注册事件发生的优先次序。
     * 原文：Gets the priority for this registration
     *
     * @return 已注册优先次序
     */
    public EventPriority getPriority() {
        return priority;
    }

    /**
     * 调用事件执行器。
     * 原文：Calls the event executor.
     *
     * @param event 事件。
     * @throws EventException 如果事件处理器抛出异常。
     */
    public void callEvent(final Event event) throws EventException {
        if (event instanceof Cancellable){
            if (((Cancellable) event).isCancelled() && isIgnoringCancelled()){
                return;
            }
        }
        executor.execute(listener, event);
    }

     /**
      * 监听器接受是否取消该事件的指令。
     * 原文：Whether this listener accepts cancelled events
     *
     * @return 真 如果忽略被取消的事件。
     */
    public boolean isIgnoringCancelled() {
        return ignoreCancelled;
    }
}