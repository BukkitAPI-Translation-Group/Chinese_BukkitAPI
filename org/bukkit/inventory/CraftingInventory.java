package org.bukkit.inventory;

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
    ItemStack getResult();

    /**
     * 获取合成公式.
     * <p>
     * 原文:Get the contents of the crafting matrix.
     *
     * @return 合成公式.
     */
    ItemStack[] getMatrix();

    /**
     * 设置最终合成品.
     * <p>
     * 原文:Set the item in the result slot of the crafting inventory.
     *
     * @param newResult 新合成品.
     */
    void setResult(ItemStack newResult);

    /**
     * Replace the contents of the crafting matrix
     *
     * @param contents The new contents.
     * @throws IllegalArgumentException if the length of contents is greater
     *     than the size of the crafting matrix.
     */
    void setMatrix(ItemStack[] contents);

    /**
     * Get the current recipe formed on the crafting inventory, if any.
     *
     * @return The recipe, or null if the current contents don't match any
     *     recipe.
     */
    Recipe getRecipe();
}