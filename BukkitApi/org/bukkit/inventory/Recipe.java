package org.bukkit.inventory;

/**
 * 代表某种类型的制作配方.
 * <br>
 * 原文: Represents some type of crafting recipe.
 */
public interface Recipe {

    /**
     * 得到这个配方的结果.
     * <p>
     * 原文: Get the result of this recipe.
     *
     * @return {@link ItemStack}
     */
    ItemStack getResult();
}
