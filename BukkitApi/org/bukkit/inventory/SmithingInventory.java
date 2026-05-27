package org.bukkit.inventory;

import org.jetbrains.annotations.Nullable;

/**
 * 锻造台物品栏的接口。
 */
public interface SmithingInventory extends Inventory {

    /**
     * 检查锻造台结果槽中的物品。
     *
     * <p>原文：Check what item is in the result slot of this smithing table.
     *
     * @return 结果物品
     */
    @Nullable
    ItemStack getResult();

    /**
     * 设置锻造台结果槽中的物品。
     *
     * <p>原文：Set the item in the result slot of the smithing table
     *
     * @param newResult 新的结果物品
     */
    void setResult(@Nullable ItemStack newResult);

    /**
     * 获取锻造台上当前形成的配方（如果有）。
     *
     * <p>原文：Get the current recipe formed on the smithing table, if any.
     *
     * @return 配方，如果当前内容不匹配任何配方则返回 null
     */
    @Nullable
    Recipe getRecipe();
}
