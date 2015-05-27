package org.bukkit.inventory;

import org.bukkit.Material;
import org.bukkit.material.MaterialData;

/**
 * 熔炉冶炼公式.
 * <p>
 * 原文:Represents a smelting recipe.
 */
public class FurnaceRecipe implements Recipe {
    private ItemStack output;
    private ItemStack ingredient;

    /**
     * 创建一个熔炉冶炼公式.
     * <p>
     * 原文:Create a furnace recipe to craft the specified ItemStack.
     *
     * @param result 填入该冶炼公式产生的生成物.
     * @param source 冶炼原料.
     */
    public FurnaceRecipe(ItemStack result, Material source) {
        this(result, source, 0);
    }

    /**
     * 创建一个熔炉冶炼公式.
     * <p>
     * 原文:Create a furnace recipe to craft the specified ItemStack.
     *
     * @param result 填入该冶炼公式产生的生成物.
     * @param source 冶炼原料.
     */
    public FurnaceRecipe(ItemStack result, MaterialData source) {
        this(result, source.getItemType(), source.getData());
    }

    /**
     * 创建一个熔炉冶炼公式.
     * <p>
     * 原文:Create a furnace recipe to craft the specified ItemStack.
     *
     * @param result 填入该冶炼公式产生的生成物.
     * @param source 冶炼原料.
     * @param data The data value. (Note: This is currently ignored by the
     *     CraftBukkit server.)
     * @deprecated Magic value
     */
    @Deprecated
    public FurnaceRecipe(ItemStack result, Material source, int data) {
        this.output = new ItemStack(result);
        this.ingredient = new ItemStack(source, 1, (short) data);
    }

    /**
     * 设置此冶炼公式的原料.
     * <p>
     * 原文:Sets the input of this furnace recipe.
     *
     * @param input 冶炼原料.
     * @return 返回新的冶炼公式.
     */
    public FurnaceRecipe setInput(MaterialData input) {
        return setInput(input.getItemType(), input.getData());
    }

    /**
     * 设置此冶炼公式的原料.
     * <p>
     * 原文:Sets the input of this furnace recipe.
     *
     * @param input 冶炼原料.
     * @return 返回新的冶炼公式.
     */
    public FurnaceRecipe setInput(Material input) {
        return setInput(input, 0);
    }

    /**
     * 设置此冶炼公式的原料.
     * <p>
     * 原文:Sets the input of this furnace recipe.
     *
     * @param input 冶炼原料.
     * @param data The data value. (Note: This is currently ignored by the
     *     CraftBukkit server.)
     * @return 返回新的冶炼公式.
     * @deprecated Magic value
     */
    @Deprecated
    public FurnaceRecipe setInput(Material input, int data) {
        this.ingredient = new ItemStack(input, 1, (short) data);
        return this;
    }

    /**
     * 获取该冶炼公式的冶炼原料.
     * <p>
     * 原文:Get the input material.
     *
     * @return 冶炼原料.
     */
    public ItemStack getInput() {
        return this.ingredient.clone();
    }

    /**
     * 获取该冶炼公式的冶炼生成物Item.
     * <p>
     * 原料:Get the result of this recipe.
     *
     * @return 冶炼生成物Item.
     */
    public ItemStack getResult() {
        return output.clone();
    }
}