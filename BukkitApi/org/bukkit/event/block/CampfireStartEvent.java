package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.CampfireRecipe;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 当营火开始烹饪时触发.
 */
public class CampfireStartEvent extends InventoryBlockStartEvent {

    private static final HandlerList handlers = new HandlerList();
    private int cookingTime;
    private CampfireRecipe campfireRecipe;

    public CampfireStartEvent(@NotNull final Block furnace, @NotNull ItemStack source, @NotNull CampfireRecipe recipe) {
        super(furnace, source);
        this.cookingTime = recipe.getCookingTime();
        this.campfireRecipe = recipe;
    }

    /**
     * 获取此事件关联的 CampfireRecipe.
     *
     * 原文：
     * Gets the CampfireRecipe associated with this event.
     *
     * @return 正在烹饪的 CampfireRecipe
     */
    @NotNull
    public CampfireRecipe getRecipe() {
        return campfireRecipe;
    }

    /**
     * 获取此事件关联的总烹饪时间.
     *
     * 原文：
     * Gets the total cook time associated with this event.
     *
     * @return 总烹饪时间
     */
    public int getTotalCookTime() {
        return cookingTime;
    }

    /**
     * 设置此事件的总烹饪时间.
     *
     * 原文：
     * Sets the total cook time for this event.
     *
     * @param cookTime 新的总烹饪时间
     */
    public void setTotalCookTime(int cookTime) {
        this.cookingTime = cookTime;
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
