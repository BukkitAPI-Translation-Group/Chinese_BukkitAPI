package org.bukkit.event.inventory;

import org.bukkit.event.HandlerList;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

/**
 * 当物品放入铁砧内，并且可以合成出物品的时候触发该事件
 */
public class PrepareAnvilEvent extends InventoryEvent {

    private static final HandlerList handlers = new HandlerList();
    private ItemStack result;

    public PrepareAnvilEvent(InventoryView inventory, ItemStack result) {
        super(inventory);
        this.result = result;
    }

    @Override
    public AnvilInventory getInventory() {
        return (AnvilInventory) super.getInventory();
    }

    /**
     * 获取预合成时铁砧即将打造出来的物品，可能为空.
     * <p>
     * 原文: Get result item,may be null.
     *
     * @return 即将合成出来的物品
     */
    public ItemStack getResult() {
        return result;
    }

    public void setResult(ItemStack result) {
        this.result = result;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}