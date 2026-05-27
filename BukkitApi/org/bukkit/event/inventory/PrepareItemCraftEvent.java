package org.bukkit.event.inventory;

import org.bukkit.event.HandlerList;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.Recipe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PrepareItemCraftEvent extends InventoryEvent {
    private static final HandlerList handlers = new HandlerList();
    private boolean repair;
    private CraftingInventory matrix;

    public PrepareItemCraftEvent(@NotNull CraftingInventory what, @NotNull InventoryView view, boolean isRepair) {
        super(view);
        this.matrix = what;
        this.repair = isRepair;
    }

    /**
     * 获取已形成的配方。如果此事件是由工具修复触发的，这将是一个代表修复的临时无序配方。
     *
     * @return 正在合成的配方
     * <p>原文：Get the recipe that has been formed. If this event was triggered by a
     * tool repair, this will be a temporary shapeless recipe representing the
     * repair.
     */
    @Nullable
    public Recipe getRecipe() {
        return matrix.getRecipe();
    }

    /**
     * @return 形成配方的合成物品栏。
     * <p>原文：The crafting inventory on which the recipe was formed.
     */
    @NotNull
    @Override
    public CraftingInventory getInventory() {
        return matrix;
    }

    /**
     * 检查此事件是否由工具修复操作而非合成配方触发。
     *
     * @return 如果这是修复则返回 true
     * <p>原文：Check if this event was triggered by a tool repair operation rather
     * than a crafting recipe.
     */
    public boolean isRepair() {
        return repair;
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
