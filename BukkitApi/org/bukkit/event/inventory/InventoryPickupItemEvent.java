package org.bukkit.event.inventory;

import org.bukkit.entity.Item;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

/**
 * 当漏斗/漏斗矿车收起掉落的物品时触发本事件.
 */
public class InventoryPickupItemEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Inventory inventory;
    private final Item item;

    public InventoryPickupItemEvent(@NotNull final Inventory inventory, @NotNull final Item item) {
        super();
        this.inventory = inventory;
        this.item = item;
    }

    /**
     * 获取捡起这个物品的背包.
     * <p>
     * 原文:Gets the Inventory that picked up the item
     *
     * @return Inventory
     */
    @NotNull
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * 获取被捡起的物品实体.
     * <p>
     * 原文:Gets the Item entity that was picked up
     *
     * @return Item
     */
    @NotNull
    public Item getItem() {
        return item;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
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