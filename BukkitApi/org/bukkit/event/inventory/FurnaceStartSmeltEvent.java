package org.bukkit.event.inventory;

import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.InventoryBlockStartEvent;
import org.bukkit.inventory.CookingRecipe;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 当熔炉开始熔炼时调用。
 */
public class FurnaceStartSmeltEvent extends InventoryBlockStartEvent {
    private static final HandlerList handlers = new HandlerList();
    private final CookingRecipe<?> recipe;
    private int totalCookTime;

    public FurnaceStartSmeltEvent(@NotNull final Block furnace, @NotNull ItemStack source, @NotNull final CookingRecipe<?> recipe) {
        super(furnace, source);
        this.recipe = recipe;
        this.totalCookTime = recipe.getCookingTime();
    }

    /**
     * 获取与此事件关联的熔炉配方。
     *
     * @return 正在烹饪的熔炉配方
     * <p>原文：Gets the FurnaceRecipe associated with this event
     */
    @NotNull
    public CookingRecipe<?> getRecipe() {
        return recipe;
    }

    /**
     * 获取与此事件关联的总烹饪时间。
     *
     * @return 总烹饪时间
     * <p>原文：Gets the total cook time associated with this event
     */
    public int getTotalCookTime() {
        return totalCookTime;
    }

    /**
     * 设置此事件的总烹饪时间。
     *
     * @param cookTime 新的总烹饪时间
     * <p>原文：Sets the total cook time for this event
     */
    public void setTotalCookTime(int cookTime) {
        this.totalCookTime = cookTime;
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
