package org.bukkit.event.player;

import com.google.common.base.Preconditions;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.CraftingRecipe;
import org.bukkit.inventory.Recipe;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家在配方书中点击配方时触发.
 */
public class PlayerRecipeBookClickEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    private final Recipe originalRecipe;
    private Recipe recipe;
    private boolean shiftClick;

    public PlayerRecipeBookClickEvent(@NotNull final Player player, @NotNull final Recipe recipe, boolean shiftClick) {
        super(player);
        this.originalRecipe = recipe;
        this.recipe = recipe;
        this.shiftClick = shiftClick;
    }

    /**
     * 获取玩家尝试制作的原始配方. <br>
     * 这<em>不会</em>反映通过 {@link setRecipe} 进行的任何更改.
     * <p>
     * 原文：
     * Gets the original recipe the player was trying to craft. <br>
     * This <em>will not</em> reflect any changes made with {@link setRecipe}.
     *
     * @return 原始配方
     */
    @NotNull
    public Recipe getOriginalRecipe() {
        return this.originalRecipe;
    }

    /**
     * 获取玩家尝试制作的配方. <br>
     * 这<em>会</em>反映通过 {@link setRecipe} 进行的更改.
     * <p>
     * 原文：
     * Gets the recipe the player is trying to craft. <br>
     * This <em>will</em> reflect changes made with {@link setRecipe}.
     *
     * @return 配方
     */
    @NotNull
    public Recipe getRecipe() {
        return this.recipe;
    }

    /**
     * 设置将要使用的配方. <br>
     * 游戏将尝试将此配方的材料移动到适当的槽位中.
     * <p>
     * 原文：
     * Set the recipe that will be used. <br>
     * The game will attempt to move the ingredients for this recipe into the
     * appropriate slots.
     * <p>
     * If the original recipe is a {@link CraftingRecipe} the provided recipe
     * must also be a {@link CraftingRecipe}, otherwise the provided recipe must
     * be of the same type as the original recipe.
     *
     * @param recipe 要使用的配方
     */
    public void setRecipe(@NotNull Recipe recipe) {
        Preconditions.checkArgument(recipe != null, "recipe cannot be null");
        if (this.originalRecipe instanceof CraftingRecipe) { // Any type of crafting recipe is acceptable
            Preconditions.checkArgument(recipe instanceof CraftingRecipe, "provided recipe must be a crafting recipe");
        } else { // Other recipes must be the same type
            Preconditions.checkArgument(this.originalRecipe.getClass() == recipe.getClass(), "provided recipe must be of the same type as original recipe");
        }
        this.recipe = recipe;
    }

    /**
     * 如果为 true，游戏将尝试将尽可能多的此配方的材料移动到适当的槽位中，否则只移动 1 份.
     * <p>
     * 原文：
     * If true the game will attempt to move the ingredients for as many copies
     * of this recipe as possible into the appropriate slots, otherwise only 1
     * copy will be moved.
     *
     * @return 是否应移动尽可能多的副本
     */
    public boolean isShiftClick() {
        return this.shiftClick;
    }

    /**
     * 设置游戏是否尝试将尽可能多的此配方的材料移动到适当的槽位中.
     * <p>
     * 原文：
     * Sets if the game will attempt to move the ingredients for as many copies
     * of this recipe as possible into the appropriate slots.
     *
     * @param shiftClick 是否应移动尽可能多的副本
     */
    public void setShiftClick(boolean shiftClick) {
        this.shiftClick = shiftClick;
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
