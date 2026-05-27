package org.bukkit.inventory;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.material.MaterialData;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一个无序配方，即成分在合成网格中的排列无关紧要。
 */
public class ShapelessRecipe extends CraftingRecipe {
    private final List<RecipeChoice> ingredients = new ArrayList<>();

    @Deprecated(since = "1.12")
    public ShapelessRecipe(@NotNull ItemStack result) {
        this(NamespacedKey.randomKey(), result);
    }

/**
 * 创建一个合成指定物品的无序配方。构造函数仅决定结果和类型；要设置实际配方，你需要调用适当的方法。
 *
 * @param key 配方的唯一键。
 * @param result 你希望配方创建的物品。
 * @exception IllegalArgumentException 如果 {@code result} 是空物品（AIR）。
 * @see ShapelessRecipe#addIngredient(Material)
 * @see ShapelessRecipe#addIngredient(MaterialData)
 * @see ShapelessRecipe#addIngredient(Material,int)
 * @see ShapelessRecipe#addIngredient(int,Material)
 * @see ShapelessRecipe#addIngredient(int,MaterialData)
 * @see ShapelessRecipe#addIngredient(int,Material,int)
 * <p>原文：Create a shapeless recipe to craft the specified ItemStack. The
 * constructor merely determines the result and type; to set the actual
 * recipe, you'll need to call the appropriate methods.
 */
    public ShapelessRecipe(@NotNull NamespacedKey key, @NotNull ItemStack result) {
        super(key, checkResult(result));
    }

/**
 * 添加指定的成分。
 *
 * @param ingredient 要添加的成分。
 * @return 修改后的配方，以便链式调用。
 * <p>原文：Adds the specified ingredient.
 */
    @NotNull
    public ShapelessRecipe addIngredient(@NotNull MaterialData ingredient) {
        return addIngredient(1, ingredient);
    }

/**
 * 添加指定的成分。
 *
 * @param ingredient 要添加的成分。
 * @return 修改后的配方，以便链式调用。
 * <p>原文：Adds the specified ingredient.
 */
    @NotNull
    public ShapelessRecipe addIngredient(@NotNull Material ingredient) {
        return addIngredient(1, ingredient, 0);
    }

/**
 * 添加指定的成分。
 *
 * @param ingredient 要添加的成分。
 * @param rawdata 数据值，或 -1 表示允许任何数据值。
 * @return 修改后的配方，以便链式调用。
 * @deprecated 魔法值。
 * <p>原文：Adds the specified ingredient.
 */
    @Deprecated(since = "1.6.2")
    @NotNull
    public ShapelessRecipe addIngredient(@NotNull Material ingredient, int rawdata) {
        return addIngredient(1, ingredient, rawdata);
    }

/**
 * 添加多个指定成分。
 *
 * @param count 要添加的数量（不能超过9个！）。
 * @param ingredient 要添加的成分。
 * @return 修改后的配方，以便链式调用。
 * <p>原文：Adds multiples of the specified ingredient.
 */
    @NotNull
    public ShapelessRecipe addIngredient(int count, @NotNull MaterialData ingredient) {
        return addIngredient(count, ingredient.getItemType(), ingredient.getData());
    }

/**
 * 添加多个指定成分。
 *
 * @param count 要添加的数量（不能超过9个！）。
 * @param ingredient 要添加的成分。
 * @return 修改后的配方，以便链式调用。
 * <p>原文：Adds multiples of the specified ingredient.
 */
    @NotNull
    public ShapelessRecipe addIngredient(int count, @NotNull Material ingredient) {
        return addIngredient(count, ingredient, 0);
    }

/**
 * 添加多个指定成分。
 *
 * @param count 要添加的数量（不能超过9个！）。
 * @param ingredient 要添加的成分。
 * @param rawdata 数据值，或 -1 表示允许任何数据值。
 * @return 修改后的配方，以便链式调用。
 * @deprecated 魔法值。
 * <p>原文：Adds multiples of the specified ingredient.
 */
    @Deprecated(since = "1.6.2")
    @NotNull
    public ShapelessRecipe addIngredient(int count, @NotNull Material ingredient, int rawdata) {
        Preconditions.checkArgument(ingredients.size() + count <= 9, "Shapeless recipes cannot have more than 9 ingredients");

        // -1 is the old wildcard, map to Short.MAX_VALUE as the new one
        if (rawdata == -1) {
            rawdata = Short.MAX_VALUE;
        }

        while (count-- > 0) {
            ingredients.add(new RecipeChoice.MaterialChoice(Collections.singletonList(ingredient)));
        }
        return this;
    }

    @NotNull
    public ShapelessRecipe addIngredient(@NotNull RecipeChoice ingredient) {
        Preconditions.checkArgument(ingredients.size() + 1 <= 9, "Shapeless recipes cannot have more than 9 ingredients");

        ingredients.add(ingredient);
        return this;
    }

/**
 * 从列表中移除一个成分。
 *
 * @param ingredient 要移除的成分。
 * @return 修改后的配方。
 * <p>原文：Removes an ingredient from the list.
 */
    @NotNull
    public ShapelessRecipe removeIngredient(@NotNull RecipeChoice ingredient) {
        ingredients.remove(ingredient);

        return this;
    }

/**
 * 从列表中移除一个成分。如果该成分出现多次，只移除其中一个实例。仅移除数据值为 0 的精确匹配项。
 *
 * @param ingredient 要移除的成分。
 * @return 修改后的配方。
 * <p>原文：Removes an ingredient from the list. If the ingredient occurs multiple
 * times, only one instance of it is removed. Only removes exact matches,
 * with a data value of 0.
 */
    @NotNull
    public ShapelessRecipe removeIngredient(@NotNull Material ingredient) {
        return removeIngredient(ingredient, 0);
    }

/**
 * 从列表中移除一个成分。如果该成分出现多次，只移除其中一个实例。如果数据值为 -1，则只移除数据值为 -1 的成分。
 *
 * @param ingredient 要移除的成分。
 * @return 修改后的配方。
 * <p>原文：Removes an ingredient from the list. If the ingredient occurs multiple
 * times, only one instance of it is removed. If the data value is -1,
 * only ingredients with a -1 data value will be removed.
 */
    @NotNull
    public ShapelessRecipe removeIngredient(@NotNull MaterialData ingredient) {
        return removeIngredient(ingredient.getItemType(), ingredient.getData());
    }

/**
 * 从列表中移除多个成分实例。如果实例数量少于指定数量，将全部移除。仅移除数据值为 0 的精确匹配项。
 *
 * @param count 要移除的副本数量。
 * @param ingredient 要移除的成分。
 * @return 修改后的配方。
 * <p>原文：Removes multiple instances of an ingredient from the list. If there are
 * less instances then specified, all will be removed. Only removes exact
 * matches, with a data value of 0.
 */
    @NotNull
    public ShapelessRecipe removeIngredient(int count, @NotNull Material ingredient) {
        return removeIngredient(count, ingredient, 0);
    }

/**
 * 从列表中移除多个成分实例。如果实例数量少于指定数量，将全部移除。如果数据值为 -1，则只移除数据值为 -1 的成分。
 *
 * @param count 要移除的副本数量。
 * @param ingredient 要移除的成分。
 * @return 修改后的配方。
 * <p>原文：Removes multiple instances of an ingredient from the list. If there are
 * less instances then specified, all will be removed. If the data value
 * is -1, only ingredients with a -1 data value will be removed.
 */
    @NotNull
    public ShapelessRecipe removeIngredient(int count, @NotNull MaterialData ingredient) {
        return removeIngredient(count, ingredient.getItemType(), ingredient.getData());
    }

/**
 * 从列表中移除一个成分。如果该成分出现多次，只移除其中一个实例。如果数据值为 -1，则只移除数据值为 -1 的成分。
 *
 * @param ingredient 要移除的成分。
 * @param rawdata 数据值。
 * @return 修改后的配方。
 * @deprecated 魔法值。
 * <p>原文：Removes an ingredient from the list. If the ingredient occurs multiple
 * times, only one instance of it is removed. If the data value is -1,
 * only ingredients with a -1 data value will be removed.
 */
    @Deprecated(since = "1.6.2")
    @NotNull
    public ShapelessRecipe removeIngredient(@NotNull Material ingredient, int rawdata) {
        return removeIngredient(1, ingredient, rawdata);
    }

/**
 * 从列表中移除多个成分实例。如果实例数量少于指定数量，将全部移除。如果数据值为 -1，则只移除数据值为 -1 的成分。
 *
 * @param count 要移除的副本数量。
 * @param ingredient 要移除的成分。
 * @param rawdata 数据值。
 * @return 修改后的配方。
 * @deprecated 魔法值。
 * <p>原文：Removes multiple instances of an ingredient from the list. If there are
 * less instances then specified, all will be removed. If the data value
 * is -1, only ingredients with a -1 data value will be removed.
 */
    @Deprecated(since = "1.6.2")
    @NotNull
    public ShapelessRecipe removeIngredient(int count, @NotNull Material ingredient, int rawdata) {
        Iterator<RecipeChoice> iterator = ingredients.iterator();
        while (count > 0 && iterator.hasNext()) {
            ItemStack stack = iterator.next().getItemStack();
            if (stack.getType() == ingredient && stack.getDurability() == rawdata) {
                iterator.remove();
                count--;
            }
        }
        return this;
    }

/**
 * 获取此配方使用的成分列表。
 *
 * @return 输入列表。
 * <p>原文：Get the list of ingredients used for this recipe.
 */
    @NotNull
    public List<ItemStack> getIngredientList() {
        ArrayList<ItemStack> result = new ArrayList<ItemStack>(ingredients.size());
        for (RecipeChoice ingredient : ingredients) {
            result.add(ingredient.getItemStack().clone());
        }
        return result;
    }

    @NotNull
    public List<RecipeChoice> getChoiceList() {
        List<RecipeChoice> result = new ArrayList<>(ingredients.size());
        for (RecipeChoice ingredient : ingredients) {
            result.add(ingredient.clone());
        }
        return result;
    }
}