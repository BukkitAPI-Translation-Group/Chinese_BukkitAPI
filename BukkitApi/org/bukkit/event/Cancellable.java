package org.bukkit.event;

public interface Cancellable {

    /**
     * 获取一个事件取消的状态. 一个被取消的事件不能在
     * 服务器里被执行，但是仍然会传递事件到其他插件
     *
     * @return true 如果事件已经被取消
     */
    public boolean isCancelled();

    /**
     * 设置一个事件取消的状态. 一个被取消的事件不能在
     * 服务器里被执行，但是仍然会传递事件到其他插件
     *
     * @param cancel true 如果你想取消这个事件
     */
    public void setCancelled(boolean cancel);
}
