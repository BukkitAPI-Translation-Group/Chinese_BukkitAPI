package org.bukkit.event.block;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.CraftingRecipe;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 当合成器即将合成物品时触发的事件.
 */
public class CrafterCraftEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final CraftingRecipe recipe;
    private ItemStack result;
    private List<ItemStack> remainingItems;
    private boolean cancelled;

    @Deprecated(since = "1.21.4")
    public CrafterCraftEvent(@NotNull Block theBlock, @NotNull CraftingRecipe recipe, @NotNull ItemStack result) {
        this(theBlock, recipe, result, new ArrayList<>());
    }

    public CrafterCraftEvent(@NotNull Block theBlock, @NotNull CraftingRecipe recipe, @NotNull ItemStack result, @NotNull List<ItemStack> remainingItems) {
        super(theBlock);
        this.result = result;
        this.recipe = recipe;
        this.remainingItems = remainingItems;
    }

    /**
     * 获取合成的结果.
     *
     * 原文：
     * Gets the result for the craft.
     *
     * @return 合成的结果
     */
    @NotNull
    public ItemStack getResult() {
        return result.clone();
    }

    /**
     * 设置合成的结果.
     *
     * 原文：
     * Sets the result of the craft.
     *
     * @param result 合成的结果
     */
    public void setResult(@NotNull ItemStack result) {
        this.result = result.clone();
    }

    /**
     * 获取配方合成后将剩余的物品.
     *
     * 原文：
     * Gets the items that will remain after the recipe has been crafted.
     *
     * @return 剩余物品列表
     */
    @NotNull
    public List<ItemStack> getRemainingItems() {
        return remainingItems;
    }

    /**
     * 获取用于合成此物品的配方.
     *
     * 原文：
     * Gets the recipe that was used to craft this item.
     *
     * @return 用于合成此物品的配方
     */
    @NotNull
    public CraftingRecipe getRecipe() {
        return recipe;
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
