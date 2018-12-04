package org.bukkit.inventory;

/**
 * 代表玩家和商人之间的用户界面接口.
 * <br>
 * 该Inventory的持有者是拥有的村民, 如果玩家正在于由插件创造的Inventory进行交易, 则Holder(持有者)将为null
 * <p>
 * 原文: Represents a trading inventory between a player and a merchant.
 * <br>
 * The holder of this Inventory is the owning Villager, or null if the player is
 * trading with a merchant created by a plugin.
 */
public interface MerchantInventory extends Inventory {

    /**
     * 获取当前的交易配方的索引.
     * 原文: Get the index of the currently selected recipe.
     *
     * @return 当前所选的交易配方的索引
     */
    int getSelectedRecipeIndex();

    /**
     * 获取当前选择的交易配方.
     * 原文: Get the currently selected recipe.
     *
     * @return 当前选择的交易配方
     */
    MerchantRecipe getSelectedRecipe();
}
