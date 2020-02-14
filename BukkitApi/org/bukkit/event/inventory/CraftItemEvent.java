package org.bukkit.event.inventory;

import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.Recipe;
import org.jetbrains.annotations.NotNull;

/**
 * 当一个物品被合成的时候触发这个事件. 
 */
public class CraftItemEvent extends InventoryClickEvent {
    private Recipe recipe;

    public CraftItemEvent(@NotNull Recipe recipe, @NotNull InventoryView what, @NotNull SlotType type, int slot, @NotNull ClickType click, @NotNull InventoryAction action) {
        super(what, type, slot, click, action);
        this.recipe = recipe;
    }

    public CraftItemEvent(@NotNull Recipe recipe, @NotNull InventoryView what, @NotNull SlotType type, int slot, @NotNull ClickType click, @NotNull InventoryAction action, int key) {
        super(what, type, slot, click, action, key);
        this.recipe = recipe;
    }

    /**
     * 获取合成出该物品所用的合成公式. 
     * 
     * @return 被合成出来的物品所用的合成公式
     */
    @NotNull
    public Recipe getRecipe() {
        return recipe;
    }

    @NotNull
    @Override
    public CraftingInventory getInventory() {
        return (CraftingInventory) super.getInventory();
    }
}

