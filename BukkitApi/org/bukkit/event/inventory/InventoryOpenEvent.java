package org.bukkit.event.inventory;

import org.bukkit.inventory.InventoryView;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当玩家打开物品栏时触发本事件
 */
public class InventoryOpenEvent extends InventoryEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;

    public InventoryOpenEvent(InventoryView transaction) {
        super(transaction);
        this.cancelled = false;
    }

    /**
     * 返回涉及此事件的玩家.
     * <p>
     * 原文:Returns the player involved in this event
     *
     * @return 涉及此事件的玩家
     */
    public final HumanEntity getPlayer() {
        return transaction.getPlayer();
    }

    /**
     * 获取此事件的取消状态. 一个取消的事件将不会在服务器上执行，但将仍然传递给其他插件.
     * <p>
     * 如果一个物品栏打开事件被取消，物品栏界面将不会显示.
     * <p>
     * 原文:Gets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins.
     * <p>
     * If an inventory open event is cancelled, the inventory screen will not
     * show.
     *
     * @return 事件取消状态
     */
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * 设置此事件的取消状态. 一个取消的事件将不会在服务器上执行，但将仍然传递给其他插件.
     * <p>
     * 如果一个物品栏打开事件被取消，物品栏界面将不会显示.
     * <p>
     * 原文:Sets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins.
     * <p>
     * If an inventory open event is cancelled, the inventory screen will not
     * show.
     *
     * @param cancel 事件取消状态
     */
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    } 
}
