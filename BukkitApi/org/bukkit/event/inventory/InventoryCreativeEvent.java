package org.bukkit.event.inventory;

import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 当处于创造模式的玩家在物品栏/快捷栏中放下或拾取物品，以及当他们在创造模式下从物品栏中丢弃物品时，会调用此事件。
 */
public class InventoryCreativeEvent extends InventoryClickEvent {
    private ItemStack item;

    public InventoryCreativeEvent(@NotNull InventoryView what, @NotNull SlotType type, int slot, @NotNull ItemStack newItem) {
        super(what, type, slot, ClickType.CREATIVE, InventoryAction.PLACE_ALL);
        this.item = newItem;
    }

    @Override
    @NotNull
    public ItemStack getCursor() {
        return item;
    }

    @Override
    public void setCursor(@NotNull ItemStack item) {
        this.item = item;
    }
}
