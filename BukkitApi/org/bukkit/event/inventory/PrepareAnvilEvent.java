package org.bukkit.event.inventory;

import org.bukkit.event.HandlerList;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.view.AnvilView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当物品放入铁砧内，并且可以合成出物品的时候触发该事件
 */
public class PrepareAnvilEvent extends PrepareInventoryResultEvent {

    private static final HandlerList handlers = new HandlerList();

    public PrepareAnvilEvent(@NotNull AnvilView inventory, @Nullable ItemStack result) {
        super(inventory, result);
    }

    @NotNull
    @Override
    public AnvilInventory getInventory() {
        return (AnvilInventory) super.getInventory();
    }

    @NotNull
    @Override
    public AnvilView getView() {
        return (AnvilView) super.getView();
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