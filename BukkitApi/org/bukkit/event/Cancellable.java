package org.bukkit.event;

/**
 * 一个表明事件可被插件或服务器取消的类型.
 */
public interface Cancellable {

    /**
     * 获取这个事件是否被取消.一个被取消的事件不会在服务器里执行，但是仍然会传递事件到其他插件.
     * <p>
     * 原文：Gets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins
     *
     * @return 如果事件已经被取消，则为true
     */
    public boolean isCancelled();

    /**
     * 取消这个事件. 一个被取消的事件不会在
     * 服务器里执行，但是仍然会传递事件到其他插件.
     * <p>
     * 原文：Sets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins.
     *
     * @param cancel 如果你想取消这个事件，则为true
     */
    public void setCancelled(boolean cancel);
}
