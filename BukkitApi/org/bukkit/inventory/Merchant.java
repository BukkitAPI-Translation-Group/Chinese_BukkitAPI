package org.bukkit.inventory;

import java.util.List;

import org.bukkit.entity.HumanEntity;

/**
 * 代表一个商人.商人是一种特殊类型的库存，是一种以物换物的自定义交易.
 * <p>
 * Represents a merchant. A merchant is a special type of inventory which can
 * facilitate custom trades between items.
 */
public interface Merchant {

    /**
     * 获取该商人当前可用的交易列表.
     * <p>
     * 原文: Get a list of trades currently available from this merchant.
     *
     * @return 一个不可变的交易列表
     */
    List<MerchantRecipe> getRecipes();

    /**
     * 设置该商家当前可用的交易列表.
     * <br>
     * 这不会改变当前与该商家交易的玩家的选定交易.
     * <p>
     * 原文: Set the list of trades currently available from this merchant.
     * <br>
     * This will not change the selected trades of players currently trading
     * with this merchant.
     *
     * @param recipes 一个关于{@link MerchantRecipe}的List
     */
    void setRecipes(List<MerchantRecipe> recipes);

    /**
     * 获取该商人的交易列表的某个索引处的{@link MerchantRecipe}.
     * <p>
     * 原文: Get the recipe at a certain index of this merchant's trade list.
     *
     * @param i 索引
     * @return {@link MerchantRecipe}
     * @throws IndexOutOfBoundsException 当下标越界时抛出此异常
     */
    MerchantRecipe getRecipe(int i) throws IndexOutOfBoundsException;

    /**
     * 设置在该商人的交易列表的指定索引处的{@link MerchantRecipe}.
     * <p>
     * 原文: Set the recipe at a certain index of this merchant's trade list.
     *
     * @param i      索引
     * @param recipe 给定的交易配方
     * @throws IndexOutOfBoundsException 当下标越界时抛出此异常
     */
    void setRecipe(int i, MerchantRecipe recipe) throws IndexOutOfBoundsException;

    /**
     * 获取此商人当前可用的交易数量.
     * <p>
     * 原文: Get the number of trades this merchant currently has available.
     *
     * @return the recipe count
     */
    int getRecipeCount();

    /**
     * 获取该商人是否正在交易.
     * <p>
     * 原文: Gets whether this merchant is currently trading.
     *
     * @return 商人是否在交易
     */
    boolean isTrading();

    /**
     * 获取该商人正在进行交易的玩家, 如果目前没有交易，则返回null.
     * <p>
     * 原文: Gets the player this merchant is trading with, or null if it is not
     * currently trading.
     *
     * @return 与商人正在交易的玩家, 当没有交易的时候返回null
     */
    HumanEntity getTrader();
}
