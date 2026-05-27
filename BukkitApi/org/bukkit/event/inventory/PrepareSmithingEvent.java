package org.bukkit.event.inventory;

import org.bukkit.event.HandlerList;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.SmithingInventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当物品被放入锻造台中用于升级的槽位时调用。
 */
public class PrepareSmithingEvent extends PrepareInventoryResultEvent {

    private static final HandlerList handlers = new HandlerList();

    public PrepareSmithingEvent(@NotNull InventoryView inventory, @Nullable ItemStack result) {
        super(inventory, result);
    }

    @NotNull
    @Override
    public SmithingInventory getInventory() {
        return (SmithingInventory) super.getInventory();
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
