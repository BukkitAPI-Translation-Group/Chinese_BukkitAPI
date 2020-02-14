package org.bukkit.event.inventory;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家关闭背包时触发本事件
 */
public class InventoryCloseEvent extends InventoryEvent {
    private static final HandlerList handlers = new HandlerList();

    public InventoryCloseEvent(@NotNull InventoryView transaction) {
        super(transaction);
    }

    /**
     * 获取涉及此事件的玩家
     * <p>
     * 原文:Returns the player involved in this event
     *
     * @return 涉及此事件的玩家
     */
    @NotNull
    public final HumanEntity getPlayer() {
        return transaction.getPlayer();
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}