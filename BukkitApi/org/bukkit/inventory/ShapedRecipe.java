package org.bukkit.inventory;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.material.MaterialData;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一个有序（即普通的）合成配方。
 */
public class ShapedRecipe extends CraftingRecipe {
    private String[] rows;
    private Map<Character, RecipeChoice> ingredients = new HashMap<>();

/**
 * 创建一个合成指定物品的配方。构造函数仅决定结果和类型；要设置实际配方，你需要调用适当的方法。
 *
 * @param result 你希望配方创建的物品。
 * @see ShapedRecipe#shape(String...)
 * @see ShapedRecipe#setIngredient(char, Material)
 * @see ShapedRecipe#setIngredient(char, Material, int)
 * @see ShapedRecipe#setIngredient(char, MaterialData)
 * @see ShapedRecipe#setIngredient(char, RecipeChoice)
 * @deprecated 配方必须有键。请改用 {@link #ShapedRecipe(NamespacedKey, ItemStack)}。
 * <p>原文：Create a shaped recipe to craft the specified ItemStack. The
 * constructor merely determines the result and type; to set the actual
 * recipe, you'll need to call the appropriate methods.
 */
    @Deprecated(since = "1.12")
    public ShapedRecipe(@NotNull ItemStack result) {
        this(NamespacedKey.randomKey(), result);
    }

/**
 * 创建一个合成指定物品的配方。构造函数仅决定结果和类型；要设置实际配方，你需要调用适当的方法。
 *
 * @param key 配方的唯一键。
 * @param result 你希望配方创建的物品。
 * @exception IllegalArgumentException 如果 {@code result} 是空物品（AIR）。
 * @see ShapedRecipe#shape(String...)
 * @see ShapedRecipe#setIngredient(char, Material)
 * @see ShapedRecipe#setIngredient(char, Material, int)
 * @see ShapedRecipe#setIngredient(char, MaterialData)
 * @see ShapedRecipe#setIngredient(char, RecipeChoice)
 * <p>原文：Create a shaped recipe to craft the specified ItemStack. The
 * constructor merely determines the result and type; to set the actual
 * recipe, you'll need to call the appropriate methods.
 */
    public ShapedRecipe(@NotNull NamespacedKey key, @NotNull ItemStack result) {
        super(key, checkResult(result));
    }

/**
 * 设置此配方的形状为指定的行。每个字符代表不同的成分；空格字符必须为空，每个字符代表什么需要单独设置。第一行对应工作台最上方的部分，例如如果提供三行，第一行代表工作台最上面一行。
 *
 * @param shape 配方的行（最多3行）。
 * @return 修改后的配方，以便链式调用。
 * <p>原文：Set the shape of this recipe to the specified rows. Each character
 * represents a different ingredient; excluding space characters, which
 * must be empty, exactly what each character represents is set separately.
 * The first row supplied corresponds with the upper most part of the recipe
 * on the workbench e.g. if all three rows are supplies the first string
 * represents the top row on the workbench.
 */
    @NotNull
    public ShapedRecipe shape(@NotNull final String... shape) {
        Preconditions.checkArgument(shape != null, "Must provide a shape");
        Preconditions.checkArgument(shape.length > 0 && shape.length < 4, "Crafting recipes should be 1, 2 or 3 rows, not ", shape.length);

        int lastLen = -1;
        for (String row : shape) {
            Preconditions.checkArgument(row != null, "Shape cannot have null rows");
            Preconditions.checkArgument(row.length() > 0 && row.length() < 4, "Crafting rows should be 1, 2, or 3 characters, not ", row.length());

            Preconditions.checkArgument(lastLen == -1 || lastLen == row.length(), "Crafting recipes must be rectangular");
            lastLen = row.length();
        }
        this.rows = new String[shape.length];
        for (int i = 0; i < shape.length; i++) {
            this.rows[i] = shape[i];
        }

        // Remove character mappings for characters that no longer exist in the shape
        HashMap<Character, RecipeChoice> newIngredients = new HashMap<>();
        for (String row : shape) {
            for (char c : row.toCharArray()) {
                // SPIGOT-7770: Space in recipe shape must represent no ingredient
                if (c == ' ') {
                    continue;
                }

                newIngredients.put(c, ingredients.get(c));
            }
        }
        this.ingredients = newIngredients;

        return this;
    }

/**
 * 设置配方形状中某个字符引用的 {@link RecipeChoice}。注意，在设置成分之前，必须先使用 {@link #shape(String...)} 定义配方的形状。
 *
 * @param key 形状中代表成分的字符。
 * @param ingredient 成分。
 * @return 修改后的配方，以便链式调用。
 * @throws IllegalArgumentException 如果 {@code key} 是空格字符。
 * @throws IllegalArgumentException 如果 {@code key} 未出现在形状中。
 * <p>原文：Sets the {@link RecipeChoice} that a character in the recipe shape refers to.
 * <p>
 * Note that before an ingredient can be set, the recipe's shape must be defined
 * with {@link #shape(String...)}.
 */
    @NotNull
    public ShapedRecipe setIngredient(char key, @NotNull MaterialData ingredient) {
        return setIngredient(key, ingredient.getItemType(), ingredient.getData());
    }

/**
 * 设置配方形状中某个字符代表的材料。注意，在设置成分之前，必须先使用 {@link #shape(String...)} 定义配方的形状。
 *
 * @param key 形状中代表成分的字符。
 * @param ingredient 成分。
 * @return 修改后的配方，以便链式调用。
 * @throws IllegalArgumentException 如果 {@code key} 是空格字符。
 * @throws IllegalArgumentException 如果 {@code key} 未出现在形状中。
 * <p>原文：Sets the material that a character in the recipe shape refers to.
 * <p>
 * Note that before an ingredient can be set, the recipe's shape must be defined
 * with {@link #shape(String...)}.
 */
    @NotNull
    public ShapedRecipe setIngredient(char key, @NotNull Material ingredient) {
        return setIngredient(key, ingredient, 0);
    }

/**
 * 设置配方形状中某个字符代表的材料。注意，在设置成分之前，必须先使用 {@link #shape(String...)} 定义配方的形状。
 *
 * @param key 形状中代表成分的字符。
 * @param ingredient 成分。
 * @param raw 原始材料数据的整数值。
 * @return 修改后的配方，以便链式调用。
 * @throws IllegalArgumentException 如果 {@code key} 是空格字符。
 * @throws IllegalArgumentException 如果 {@code key} 未出现在形状中。
 * @deprecated 魔法值。
 * <p>原文：Sets the material that a character in the recipe shape refers to.
 * <p>
 * Note that before an ingredient can be set, the recipe's shape must be defined
 * with {@link #shape(String...)}.
 */
    @Deprecated(since = "1.6.2")
    @NotNull
    public ShapedRecipe setIngredient(char key, @NotNull Material ingredient, int raw) {
        Preconditions.checkArgument(key != ' ', "Space in recipe shape must represent no ingredient");
        Preconditions.checkArgument(ingredients.containsKey(key), "Symbol does not appear in the shape:", key);

        // -1 is the old wildcard, map to Short.MAX_VALUE as the new one
        if (raw == -1) {
            raw = Short.MAX_VALUE;
        }

        ingredients.put(key, new RecipeChoice.MaterialChoice(Collections.singletonList(ingredient)));
        return this;
    }

/**
 * 设置配方形状中某个字符代表的材料。注意，在设置成分之前，必须先使用 {@link #shape(String...)} 定义配方的形状。
 *
 * @param key 形状中代表成分的字符。
 * @param ingredient 成分。
 * @return 修改后的配方，以便链式调用。
 * @throws IllegalArgumentException 如果 {@code key} 是空格字符。
 * @throws IllegalArgumentException 如果 {@code key} 未出现在形状中。
 * <p>原文：Sets the material that a character in the recipe shape refers to.
 * <p>
 * Note that before an ingredient can be set, the recipe's shape must be defined
 * with {@link #shape(String...)}.
 */
    @NotNull
    public ShapedRecipe setIngredient(char key, @NotNull RecipeChoice ingredient) {
        Preconditions.checkArgument(key != ' ', "Space in recipe shape must represent no ingredient");
        Preconditions.checkArgument(ingredients.containsKey(key), "Symbol does not appear in the shape:", key);

        ingredients.put(key, ingredient);
        return this;
    }

/**
 * 获取成分映射的副本。
 *
 * @return 字符到成分的映射。
 * <p>原文：Get a copy of the ingredients map.
 */
    @NotNull
    public Map<Character, ItemStack> getIngredientMap() {
        HashMap<Character, ItemStack> result = new HashMap<Character, ItemStack>();
        for (Map.Entry<Character, RecipeChoice> ingredient : ingredients.entrySet()) {
            if (ingredient.getValue() == null) {
                result.put(ingredient.getKey(), null);
            } else {
                result.put(ingredient.getKey(), ingredient.getValue().getItemStack().clone());
            }
        }
        return result;
    }

/**
 * 获取选择映射的副本。
 *
 * @return 字符到成分的映射。
 * <p>原文：Get a copy of the choice map.
 */
    @NotNull
    public Map<Character, RecipeChoice> getChoiceMap() {
        Map<Character, RecipeChoice> result = new HashMap<>();
        for (Map.Entry<Character, RecipeChoice> ingredient : ingredients.entrySet()) {
            if (ingredient.getValue() == null) {
                result.put(ingredient.getKey(), null);
            } else {
                result.put(ingredient.getKey(), ingredient.getValue().clone());
            }
        }
        return result;
    }

/**
 * 获取形状。
 *
 * @return 配方的形状。
 * @throws NullPointerException 尚未设置时抛出。
 * <p>原文：Get the shape.
 */
    @NotNull
    public String[] getShape() {
        return rows.clone();
    }
}