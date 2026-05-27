package org.bukkit.inventory;

import com.google.common.base.Preconditions;
import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.recipe.CraftingBookCategory;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一个有序或无序的合成配方。
 */
public abstract class CraftingRecipe implements Recipe, Keyed {
    private final NamespacedKey key;
    private final ItemStack output;
    private String group = "";
    private CraftingBookCategory category = CraftingBookCategory.MISC;

    protected CraftingRecipe(@NotNull NamespacedKey key, @NotNull ItemStack result) {
        Preconditions.checkArgument(key != null, "key cannot be null");
        this.key = key;
        this.output = new ItemStack(result);
    }

    @NotNull
    @Override
    public NamespacedKey getKey() {
        return key;
    }

    /**
     * 获取此配方的结果。
     * <p>
     * 原文：
     * Get the result of this recipe.
     *
     * @return 结果物品堆。
     */
    @Override
    @NotNull
    public ItemStack getResult() {
        return output.clone();
    }

    /**
     * 获取此配方的分组。具有相同分组的配方在客户端显示时可能会被分组在一起。
     * <p>
     * 原文：
     * Get the group of this recipe. Recipes with the same group may be grouped
     * together when displayed in the client.
     *
     * @return 配方分组。空字符串表示没有分组。不能为 null。
     */
    @NotNull
    public String getGroup() {
        return group;
    }

    /**
     * 设置此配方的分组。具有相同分组的配方在客户端显示时可能会被分组在一起。
     * <p>
     * 原文：
     * Set the group of this recipe. Recipes with the same group may be grouped
     * together when displayed in the client.
     *
     * @param group 配方分组。空字符串表示没有分组。不能为 null。
     */
    public void setGroup(@NotNull String group) {
        Preconditions.checkArgument(group != null, "group cannot be null");
        this.group = group;
    }

    /**
     * 获取此配方在配方书中出现的类别。
     * <br>
     * 如果未设置，则默认为 {@link CraftingBookCategory#MISC}。
     * <p>
     * 原文：
     * Gets the category which this recipe will appear in the recipe book under.
     * <br>
     * Defaults to {@link CraftingBookCategory#MISC} if not set.
     *
     * @return 配方书类别
     */
    @NotNull
    public CraftingBookCategory getCategory() {
        return category;
    }

    /**
     * 设置此配方在配方书中出现的类别。
     * <br>
     * 如果未设置，则默认为 {@link CraftingBookCategory#MISC}。
     * <p>
     * 原文：
     * Sets the category which this recipe will appear in the recipe book under.
     * <br>
     * Defaults to {@link CraftingBookCategory#MISC} if not set.
     *
     * @param category 配方书类别
     */
    public void setCategory(@NotNull CraftingBookCategory category) {
        Preconditions.checkArgument(category != null, "category cannot be null");
        this.category = category;
    }

    /**
     * 检查用于 CraftingRecipe 相关构造器的 ItemStack 是否为空。
     * <p>
     * 原文：
     * Checks an ItemStack to be used in constructors related to CraftingRecipe
     * is not empty.
     *
     * @param result 一个 ItemStack
     * @return 相同的结果 ItemStack
     * @throws IllegalArgumentException 如果 {@code result} 是空物品（AIR）
     */
    @ApiStatus.Internal
    @NotNull
    protected static ItemStack checkResult(@NotNull ItemStack result) {
        Preconditions.checkArgument(result.getType() != Material.AIR, "Recipe must have non-AIR result.");
        return result;
    }
}