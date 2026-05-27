package org.bukkit.inventory;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 合成台的用户界面接口.
 */
public interface CraftingInventory extends Inventory {

    /**
     * 获取合成台产生的合成品.
     * <p>
     * 原文:Check what item is in the result slot of this crafting inventory.
     *
     * @return 合成品.
     */
    @Nullable
    ItemStack getResult();

    /**
     * 获取合成公式.
     * <p>
     * 原文:Get the contents of the crafting matrix.
     *
     * @return 合成公式. 个别条目可能为null.
     */
    @NotNull
    ItemStack[] getMatrix();

    /**
     * 设置最终合成品.
     * <p>
     * 原文:Set the item in the result slot of the crafting inventory.
     *
     * @param newResult 新合成品.
     */
    void setResult(@Nullable ItemStack newResult);

    /**
     * 替换合成矩阵的内容.
     * <p>
     * 原文:Replace the contents of the crafting matrix.
     *
     * @param contents 新的内容. 个别条目可能为null.
     * @throws IllegalArgumentException 如果contents的长度大于合成矩阵的大小.
     */
    void setMatrix(@NotNull ItemStack[] contents);

    /**
     * 获取当前合成台上形成的合成配方(如果有的话).
     * <p>
     * 原文:Get the current recipe formed on the crafting inventory, if any.
     *
     * @return 配方, 如果当前内容不匹配任何配方则返回null.
     */
    @Nullable
    Recipe getRecipe();
}