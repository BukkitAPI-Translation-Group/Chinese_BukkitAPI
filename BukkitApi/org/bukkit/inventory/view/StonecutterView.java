package org.bukkit.inventory.view;

import java.util.List;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.StonecutterInventory;
import org.bukkit.inventory.StonecuttingRecipe;
import org.jetbrains.annotations.NotNull;

/**
 * 一个提供与切石机视图数据相关额外方法的 {@link InventoryView} 实例。
 */
public interface StonecutterView extends InventoryView {

    @NotNull
    @Override
    StonecutterInventory getTopInventory();

    /**
     * 获取当前选中配方的索引.
     * <p>
     * 原文：Gets the current index of the selected recipe.
     *
     * @return 切石机中选中配方的索引, 如果为null则返回-1
     */
    int getSelectedRecipeIndex();

    /**
     * 获取玩家当前可用的所有配方副本.
     * <p>
     * 原文：Gets a copy of all recipes currently available to the player.
     *
     * @return 玩家当前可用的{@link StonecuttingRecipe}副本
     */
    @NotNull
    List<StonecuttingRecipe> getRecipes();

    /**
     * 获取当前可用的配方数量.
     * <p>
     * 原文：Gets the amount of recipes currently available.
     *
     * @return 玩家当前可用的配方数量
     */
    int getRecipeAmount();
}
