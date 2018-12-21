package org.bukkit.inventory;

import com.google.common.base.Preconditions;
import java.util.Collections;
import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.material.MaterialData;

/**
 * 熔炉冶炼配方.
 */
public class FurnaceRecipe implements Recipe {
    private final NamespacedKey key;
    private ItemStack output;
    private RecipeChoice ingredient;
    private float experience;
    private int cookingTime;
    private String group = "";

    @Deprecated
    public FurnaceRecipe(ItemStack result, Material source) {
        this(NamespacedKey.randomKey(), result, source, 0, 0, 200);
    }

    @Deprecated
    public FurnaceRecipe(ItemStack result, MaterialData source) {
        this(NamespacedKey.randomKey(), result, source.getItemType(), source.getData(), 0, 200);
    }

    @Deprecated
    public FurnaceRecipe(ItemStack result, MaterialData source, float experience) {
        this(NamespacedKey.randomKey(), result, source.getItemType(), source.getData(), experience, 200);
    }

    @Deprecated
    public FurnaceRecipe(ItemStack result, Material source, int data) {
        this(NamespacedKey.randomKey(), result, source, data, 0, 200);
    }

    /**
     * Create a furnace recipe to craft the specified ItemStack.
     *
     * @param key The unique recipe key
     * @param result The item you want the recipe to create.
     * @param source The input material.
     * @param experience The experience given by this recipe
     * @param cookingTime The cooking time (in ticks)
     */
    public FurnaceRecipe(NamespacedKey key, ItemStack result, Material source, float experience, int cookingTime) {
        this(key, result, source, 0, experience, cookingTime);
    }

    @Deprecated
    public FurnaceRecipe(NamespacedKey key, ItemStack result, Material source, int data, float experience, int cookingTime) {
        this(key, result, new RecipeChoice.MaterialChoice(Collections.singletonList(source)), experience, cookingTime);
    }

    /**
     * Create a furnace recipe to craft the specified ItemStack.
     *
     * @param key The unique recipe key
     * @param result The item you want the recipe to create.
     * @param input The input choices.
     * @param experience The experience given by this recipe
     * @param cookingTime The cooking time (in ticks)
     */
    public FurnaceRecipe(NamespacedKey key, ItemStack result, RecipeChoice input, float experience, int cookingTime) {
        this.key = key;
        this.output = new ItemStack(result);
        this.ingredient = input;
        this.experience = experience;
        this.cookingTime = cookingTime;
    }

    /**
     * 设置此冶炼配方的原料.
     * <p>
     * 原文:Sets the input of this furnace recipe.
     *
     * @param input 冶炼原料.
     * @return 返回新的冶炼配方.
     */
    public FurnaceRecipe setInput(MaterialData input) {
        return new RecipeChoice.MaterialChoice(Collections.singletonList(input));
    }

    /**
     * 设置此冶炼配方的原料.
     * <p>
     * 原文:Sets the input of this furnace recipe.
     *
     * @param input 冶炼原料.
     * @return 返回新的冶炼配方
     */
    public FurnaceRecipe setInput(Material input) {
        return setInput(input, 0);
    }

    /**
     * Sets the input of this furnace recipe.
     *
     * @param input The input choice.
     * @return The changed recipe, so you can chain calls.
     */
    public FurnaceRecipe setInputChoice(RecipeChoice input) {
        this.ingredient = input;
        return this;
    }

    /**
     * Get the input choice.
     *
     * @return The input choice.
     */
    public RecipeChoice getInputChoice() {
        return this.ingredient.clone();
    }

    /**
     * 设置此冶炼配方的原料.
     * <p>
     * 原文:Sets the input of this furnace recipe.
     *
     * @param input 冶炼原料.
     * @param data 数据值. (注意: 该值目前被CraftBukkit服务器忽略，也就是说没有作用)
     * @return 返回新的冶炼配方.
     * @deprecated Magic value
     */
    @Deprecated
    public FurnaceRecipe setInput(Material input, int data) {
        this.ingredient = new ItemStack(input, 1, (short) data);
        return this;
    }

    /**
     * 获取该冶炼配方的冶炼原料.
     * <p>
     * 原文:Get the input material.
     *
     * @return 冶炼原料.
     */
    public ItemStack getInput() {
        return this.ingredient.clone();
    }

    /**
     * 获取该冶炼配方的冶炼生成物.
     * <p>
     * 原料:Get the result of this recipe.
     *
     * @return 冶炼生成物
     */
    public ItemStack getResult() {
        return output.clone();
    }

    /**
     * 设置烧炼后给予玩家的经验.
     * <p>
     * 原文:Sets the experience given by this recipe.
     *
     * @param experience 经验值
     */
    public void setExperience(float experience) {
        this.experience = experience;
    }

    /**
     * 获得烧炼后给予玩家的经验.
     * <p>
     * 原文:Get the experience given by this recipe.
     *
     * @return 经验值
     */
    public float getExperience() {
        return experience;
    }

    /**
     * 设置冶炼所需时间(以ticks为单位).
     * <p>
     * 原文:Set the cooking time for this recipe in ticks.
     *
     * @param cookingTime 冶炼时间
     */
    public void setCookingTime(int cookingTime) {
        Preconditions.checkArgument(cookingTime >= 0, "cookingTime must be >= 0");
        this.cookingTime = cookingTime;
    }

    /**
     * 获取冶炼所需时间(以ticks为单位).
     * <p>
     * 原文:Get the cooking time for this recipe in ticks.
     *
     * @return 冶炼时间
     */
    public int getCookingTime() {
        return cookingTime;
    }

    @Override
    public NamespacedKey getKey() {
        return key;
    }

    /**
     * Get the group of this recipe. Recipes with the same group may be grouped
     * together when displayed in the client.
     *
     * @return recipe group. An empty string denotes no group. May not be null.
     */
    public String getGroup() {
        return group;
    }

    /**
     * Set the group of this recipe. Recipes with the same group may be grouped
     * together when displayed in the client.
     *
     * @param group recipe group. An empty string denotes no group. May not be
     * null.
     */
    public void setGroup(String group) {
        Preconditions.checkArgument(group != null, "group");
        this.group = group;
    }
}
