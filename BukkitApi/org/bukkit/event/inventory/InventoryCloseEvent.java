package org.bukkit.event.inventory;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.InventoryView;

/**
 * 当玩家关闭背包时触发本事件
 */
public class InventoryCloseEvent extends InventoryEvent {
    private static final HandlerList handlers = new HandlerList();

    public InventoryCloseEvent(InventoryView transaction) {
        super(transaction);
    }

    /**
     * 获取涉及此事件的玩家
     * <p>
     * 原文:Returns the player involved in this event
     *
     * @return 涉及此事件的玩家
     */
    public final HumanEntity getPlayer() {
        return transaction.getPlayer();
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}