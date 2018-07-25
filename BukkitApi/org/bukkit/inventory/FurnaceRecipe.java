package org.bukkit.inventory;

import com.google.common.base.Preconditions;
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
    private ItemStack ingredient;
    private float experience;
    private int cookingTime;

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
     * 创建一个熔炉冶炼配方.
     * <p>
     * 原文:Create a furnace recipe to craft the specified ItemStack.
     *
     * @param key 冶炼配方的唯一键值
     * @param result 填入该冶炼配方产生的生成物
     * @param source 冶炼原料
     * @param experience 熔炼后玩家所得经验
     * @param cookingTime 熔炼时间 (以ticks为单位)
     */
    public FurnaceRecipe(NamespacedKey key, ItemStack result, Material source, float experience, int cookingTime) {
        this(key, result, source, 0, experience, cookingTime);
    }

    @Deprecated
    public FurnaceRecipe(NamespacedKey key, ItemStack result, Material source, int data, float experience, int cookingTime) {
        this.key = key;
        this.output = new ItemStack(result);
        this.ingredient = new ItemStack(source, 1, (short) data);
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
        return setInput(input.getItemType(), input.getData());
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
}
