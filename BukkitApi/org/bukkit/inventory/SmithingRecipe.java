package org.bukkit.inventory;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一个锻造配方。
 */
public class SmithingRecipe implements Recipe, Keyed {

    private final NamespacedKey key;
    private final ItemStack result;
    private final RecipeChoice base;
    private final RecipeChoice addition;

/**
 * 创建一个锻造配方以产生指定的结果物品。
 *
 * @param key 配方的唯一键。
 * @param result 你希望配方创建的物品。
 * @param base 基础成分。
 * @param addition 附加成分。
 * @deprecated 从 Minecraft 1.20 开始，锻造配方现在被分为两种不同的配方类型：{@link SmithingTransformRecipe} 和 {@link SmithingTrimRecipe}。此类现在作为这两个类的基类，添加到服务器时不会产生任何效果。
 * <p>原文：Create a smithing recipe to produce the specified result ItemStack.
 */
    @Deprecated(since = "1.20.1")
    public SmithingRecipe(@NotNull NamespacedKey key, @NotNull ItemStack result, @Nullable RecipeChoice base, @Nullable RecipeChoice addition) {
        this.key = key;
        this.result = result;
        this.base = base;
        this.addition = addition;
    }

/**
 * 获取基础配方物品。
 *
 * @return 基础选择。
 * <p>原文：Get the base recipe item.
 */
    @Nullable
    public RecipeChoice getBase() {
        return (base != null) ? base.clone() : null;
    }

/**
 * 获取附加配方物品。
 *
 * @return 附加选择。
 * <p>原文：Get the addition recipe item.
 */
    @Nullable
    public RecipeChoice getAddition() {
        return (addition != null) ? addition.clone() : null;
    }

    @NotNull
    @Override
    public ItemStack getResult() {
        return result.clone();
    }

    @NotNull
    @Override
    public NamespacedKey getKey() {
        return this.key;
    }
}