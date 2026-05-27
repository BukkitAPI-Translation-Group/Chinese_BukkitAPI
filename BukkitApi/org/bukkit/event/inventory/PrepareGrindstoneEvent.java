package org.bukkit.event.inventory;

import org.bukkit.event.HandlerList;
import org.bukkit.inventory.GrindstoneInventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当物品被放入砂轮中用于修复或解除附魔的槽位时调用。
 */
public class PrepareGrindstoneEvent extends PrepareInventoryResultEvent {

    private static final HandlerList handlers = new HandlerList();

    public PrepareGrindstoneEvent(@NotNull InventoryView inventory, @Nullable ItemStack result) {
        super(inventory, result);
    }

    @NotNull
    @Override
    public GrindstoneInventory getInventory() {
        return (GrindstoneInventory) super.getInventory();
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
