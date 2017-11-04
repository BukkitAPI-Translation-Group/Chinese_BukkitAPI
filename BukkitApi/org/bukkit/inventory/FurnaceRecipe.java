package org.bukkit.inventory;

import org.bukkit.Material;
import org.bukkit.material.MaterialData;

/**
 * 熔炉冶炼配方.
 * <p>
 * 原文:Represents a smelting recipe.
 */
public class FurnaceRecipe implements Recipe {
    private ItemStack output;
    private ItemStack ingredient;
    private float experience;

    /**
     * 创建一个熔炉冶炼配方.
     * <p>
     * 原文:Create a furnace recipe to craft the specified ItemStack.
     *
     * @param result 填入该冶炼配方产生的生成物.
     * @param source 冶炼原料.
     */
    public FurnaceRecipe(ItemStack result, Material source) {
        this(result, source, 0, 0);
    }

    /**
     * 创建一个熔炉冶炼配方.
     * <p>
     * 原文:Create a furnace recipe to craft the specified ItemStack.
     *
     * @param result 填入该冶炼配方产生的生成物.
     * @param source 冶炼原料.
     */
    public FurnaceRecipe(ItemStack result, MaterialData source) {
        this(result, source.getItemType(), source.getData(), 0);
    }

    /**
     * 创建一个熔炉冶炼配方.
     *
     * @param result 填入该冶炼配方产生的生成物.
     * @param source 冶炼原料.
     * @param experience 熔炼后玩家所得经验
     */
    public FurnaceRecipe(ItemStack result, MaterialData source, float experience) {
        this(result, source.getItemType(), source.getData(), experience);
    }

    /**
     * 创建一个熔炉冶炼公式.
     * <p>
     * 原文:Create a furnace recipe to craft the specified ItemStack.
     *
     * @param result 填入该冶炼配方产生的生成物.
     * @param source 冶炼原料.
     * @param data 数据值. (注意: 该值目前被CraftBukkit服务器忽略，也就是说没有作用)
     * @deprecated 不安全的参数
     */
    @Deprecated
    public FurnaceRecipe(ItemStack result, Material source, int data) {
        this(result, source, data, 0);
    }

    /**
     * 创建一个熔炉冶炼配方.
     *
     * @param result 填入该冶炼公式产生的生成物.
     * @param source 冶炼原料.
     * @param data 数据值. (注意: 该值目前被CraftBukkit服务器忽略，也就是说没有作用)
     * @param experience 冶炼后玩家所得经验
     * @deprecated 不安全的参数
     */
    @Deprecated
    public FurnaceRecipe(ItemStack result, Material source, int data, float experience) {
        this.output = new ItemStack(result);
        this.ingredient = new ItemStack(source, 1, (short) data);
        this.experience = experience;
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
}
