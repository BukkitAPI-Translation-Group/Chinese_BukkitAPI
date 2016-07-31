package org.bukkit.event.inventory;

import java.util.List;

import org.bukkit.event.HandlerList;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Event;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

/**
 * 代表与玩家相关的背包事件
 */
public class InventoryEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    protected InventoryView transaction;

    public InventoryEvent(InventoryView transaction) {
        this.transaction = transaction;
    }

    /**
     * 获取此事件涉及的主要背包.
     * <p>
     * 原文:Gets the primary Inventory involved in this transaction
     *
     * @return 顶部背包
     */
    public Inventory getInventory() {
        return transaction.getTopInventory();
    }

    /**
     * 获取正在查看此主要/顶部背包的玩家列表.
     * <p>
     * 原文:Gets the list of players viewing the primary (upper) inventory involved
     * in this event
     *
     * @return 正在查看此背包的玩家
     */
    public List<HumanEntity> getViewers() {
        return transaction.getTopInventory().getViewers();
    }

    /**
     * 获取背包本身的 InventoryView 对象。
     * <p>
     * 原文:Gets the view object itself
     *
     * @return InventoryView
     */
    public InventoryView getView() {
        return transaction;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}