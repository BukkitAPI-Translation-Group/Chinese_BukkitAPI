package org.bukkit.inventory;

import com.google.common.base.Preconditions;
import java.util.Collections;
import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一个切石配方。
 */
public class StonecuttingRecipe implements Recipe, Keyed {
    private final NamespacedKey key;
    private ItemStack output;
    private RecipeChoice ingredient;
    private String group = "";

/**
 * 创建一个切石配方以合成指定的物品。
 *
 * @param key 配方的唯一键。
 * @param result 你希望配方创建的物品。
 * @param source 输入材料。
 * <p>原文：Create a Stonecutting recipe to craft the specified ItemStack.
 */
    public StonecuttingRecipe(@NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull Material source) {
        this(key, result, new RecipeChoice.MaterialChoice(Collections.singletonList(source)));
    }

/**
 * 创建一个烹饪配方以合成指定的物品。
 *
 * @param key 配方的唯一键。
 * @param result 你希望配方创建的物品。
 * @param input 输入选择。
 * <p>原文：Create a cooking recipe to craft the specified ItemStack.
 */
    public StonecuttingRecipe(@NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull RecipeChoice input) {
        Preconditions.checkArgument(result.getType() != Material.AIR, "Recipe must have non-AIR result.");
        this.key = key;
        this.output = new ItemStack(result);
        this.ingredient = input;
    }

/**
 * 设置此烹饪配方的输入。
 *
 * @param input 输入材料。
 * @return 修改后的配方，以便链式调用。
 * <p>原文：Sets the input of this cooking recipe.
 */
    @NotNull
    public StonecuttingRecipe setInput(@NotNull Material input) {
        this.ingredient = new RecipeChoice.MaterialChoice(Collections.singletonList(input));
        return this;
    }

/**
 * 获取输入材料。
 *
 * @return 输入材料。
 * <p>原文：Get the input material.
 */
    @NotNull
    public ItemStack getInput() {
        return this.ingredient.getItemStack();
    }

/**
 * 设置此烹饪配方的输入。
 *
 * @param input 输入选择。
 * @return 修改后的配方，以便链式调用。
 * <p>原文：Sets the input of this cooking recipe.
 */
    @NotNull
    public StonecuttingRecipe setInputChoice(@NotNull RecipeChoice input) {
        this.ingredient = input;
        return (StonecuttingRecipe) this;
    }

/**
 * 获取输入选择。
 *
 * @return 输入选择。
 * <p>原文：Get the input choice.
 */
    @NotNull
    public RecipeChoice getInputChoice() {
        return this.ingredient.clone();
    }

/**
 * 获取此配方的结果。
 *
 * @return 结果物品栈。
 * <p>原文：Get the result of this recipe.
 */
    @NotNull
    @Override
    public ItemStack getResult() {
        return output.clone();
    }

    @NotNull
    @Override
    public NamespacedKey getKey() {
        return key;
    }

/**
 * 获取此配方的分组。相同分组的配方在客户端显示时可能会被分组在一起。
 *
 * @return 配方分组。空字符串表示无分组。不能为 null。
 * <p>原文：Get the group of this recipe. Recipes with the same group may be grouped
 * together when displayed in the client.
 */
    @NotNull
    public String getGroup() {
        return group;
    }

/**
 * 设置此配方的分组。相同分组的配方在客户端显示时可能会被分组在一起。
 *
 * @param group 配方分组。空字符串表示无分组。不能为 null。
 * <p>原文：Set the group of this recipe. Recipes with the same group may be grouped
 * together when displayed in the client.
 */
    public void setGroup(@NotNull String group) {
        Preconditions.checkArgument(group != null, "group cannot be null");
        this.group = group;
    }
}
