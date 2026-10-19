package org.bukkit.inventory;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一种配方，当与额外材料结合时会改变输入材料的类型，但保留所有自定义数据。仅使用结果物品栈的物品类型。
 * <br>
 * 在原版中用于给潜影盒染色。
 */
public class TransmuteRecipe extends CraftingRecipe implements ComplexRecipe {

    private final RecipeChoice input;
    private final RecipeChoice material;
    private final int minimumMaterialCount;
    private final int maximumMaterialCount;
    private final boolean addMaterialCountToResult;

    /**
     * Create a transmute recipe to produce a result of the specified type.
     *
     * @param key the unique recipe key
     * @param result the transmuted result item
     * @param input the input ingredient
     * @param material the additional ingredient
     * @param minimumMaterialCount minimum count of the material, default 1, range [1, 8]
     * @param maximumMaterialCount maximum count of the material, default 1, range [1, 8]
     * @param addMaterialCountToResult whether the material count should be added to the result stack count, default false
     */
    public TransmuteRecipe(@NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull RecipeChoice input, @NotNull RecipeChoice material, int minimumMaterialCount, int maximumMaterialCount, boolean addMaterialCountToResult) {
        super(key, checkResult(result));
        this.input = input;
        this.material = material;
        this.minimumMaterialCount = minimumMaterialCount;
        this.maximumMaterialCount = maximumMaterialCount;
        this.addMaterialCountToResult = addMaterialCountToResult;
    }

/**
 * 创建一个转化配方以产生指定类型的结果。
 *
 * @param key 配方的唯一键。
 * @param result 转化后的结果物品。
 * @param input 输入成分。
 * @param material 额外成分。
 * <p>原文：Create a transmute recipe to produce a result of the specified type.
 */
    public TransmuteRecipe(@NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull RecipeChoice input, @NotNull RecipeChoice material) {
        this(key, result, input, material, 1, 1, false);
    }

/**
 * 创建一个转化配方以产生指定类型的结果。
 *
 * @param key 配方的唯一键。
 * @param result 转化后的结果材料。
 * @param input 输入成分。
 * @param material 额外成分。
 * <p>原文：Create a transmute recipe to produce a result of the specified type.
 */
    public TransmuteRecipe(@NotNull NamespacedKey key, @NotNull Material result, @NotNull RecipeChoice input, @NotNull RecipeChoice material) {
        this(key, new ItemStack(result), input, material);
    }

/**
 * 获取将被转化的输入材料。
 *
 * @return 转化的输入。
 * <p>原文：Gets the input material, which will be transmuted.
 */
    @NotNull
    public RecipeChoice getInput() {
        return input.clone();
    }

/**
 * 获取触发转化所需的额外材料。
 *
 * @return 成分材料。
 * <p>原文：Gets the additional material required to cause the transmutation.
 */
    @NotNull
    public RecipeChoice getMaterial() {
        return material.clone();
    }

    /**
     * Gets the minimum amount of items matched by the material ingredient.
     *
     * @return minimum count of the material, default 1, range [1, 8]
     */
    public int getMinimumMaterialCount() {
        return minimumMaterialCount;
    }

    /**
     * Gets the maximum amount of items matched by the material ingredient.
     *
     * @return maximum count of the material, default 1, range [1, 8]
     */
    public int getMaximumMaterialCount() {
        return maximumMaterialCount;
    }

    /**
     * Gets whether the material ingredient count should be added to the result
     * stack count after crafting.
     *
     * @return whether the material ingredient count should be added to the
     * result stack count, default false
     */
    public boolean isAddMaterialCountToResult() {
        return addMaterialCountToResult;
    }
}
