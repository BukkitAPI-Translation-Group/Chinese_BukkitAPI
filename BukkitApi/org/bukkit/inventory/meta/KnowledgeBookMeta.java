package org.bukkit.inventory.meta;

import java.util.List;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

/**
 * 与知识之书有关的元数据.
 */
public interface KnowledgeBookMeta extends ItemMeta {

    /**
     * 检测这本知识之书是否包含合成配方.
     * <p>
     * 原文:
     * Checks for the existence of recipes in the book.
     *
     * @return 是否包含配方
     */
    boolean hasRecipes();

    /**
     * 获取书本内的所有合成配方.
     * <p>
     * 原文:
     * Gets all the recipes in the book.
     *
     * @return 合成配方列表
     */
    @NotNull
    List<NamespacedKey> getRecipes();

    /**
     * 清空书本内原有的合成配方, 替换为提供的合成配方.
     * <p>
     * 原文:
     * Clears the existing book recipes, and sets the book to use the provided
     * recipes.
     *
     * @param recipes 合成配方列表
     */
    void setRecipes(@NotNull List<NamespacedKey> recipes);

    /**
     * 向书的末尾添加新的合成配方.
     * <p>
     * 原文:
     * Adds new recipe to the end of the book.
     *
     * @param recipes 合成配方列表
     */
    void addRecipe(@NotNull NamespacedKey... recipes);

    @NotNull
    @Override
    KnowledgeBookMeta clone();
}
