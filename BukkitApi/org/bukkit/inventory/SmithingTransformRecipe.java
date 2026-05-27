package org.bukkit.inventory;

import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一个锻造变换配方。
 */
public class SmithingTransformRecipe extends SmithingRecipe {

    private final RecipeChoice template;

/**
 * 创建一个锻造配方以产生指定的结果物品。
 *
 * @param key 配方的唯一键。
 * @param result 你希望配方创建的物品。
 * @param template 模板物品。
 * @param base 基础成分。
 * @param addition 附加成分。
 * <p>原文：Create a smithing recipe to produce the specified result ItemStack.
 */
    public SmithingTransformRecipe(@NotNull NamespacedKey key, @NotNull ItemStack result, @Nullable RecipeChoice template, @Nullable RecipeChoice base, @Nullable RecipeChoice addition) {
        super(key, result, base, addition);
        this.template = template;
    }

/**
 * 获取模板配方物品。
 *
 * @return 模板选择。
 * <p>原文：Get the template recipe item.
 */
    @Nullable
    public RecipeChoice getTemplate() {
        return (template != null) ? template.clone() : null;
    }
}