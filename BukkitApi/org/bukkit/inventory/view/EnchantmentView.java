package org.bukkit.inventory.view;

import org.bukkit.enchantments.EnchantmentOffer;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

/**
 * 一个提供与附魔台视图数据相关额外方法的 {@link InventoryView} 实例。
 */
public interface EnchantmentView extends InventoryView {

    @NotNull
    @Override
    EnchantingInventory getTopInventory();

    /**
     * 获取此视图中使用的随机附魔种子。
     *
     * @return 使用的随机种子
     * <p>
     * 原文：Gets the random enchantment seed used in this view
     *
     * @return The random seed used
     */
    int getEnchantmentSeed();

    /**
     * 获取此EnchantmentView的附魔选项。
     *
     * @return 提供的附魔选项
     * <p>
     * 原文：Gets the offers of this EnchantmentView
     *
     * @return The enchantment offers that are provided
     */
    @NotNull
    EnchantmentOffer[] getOffers();

    /**
     * 设置要提供给玩家的附魔选项。
     *
     * @param offers 要提供的附魔选项
     * @throws IllegalArgumentException 如果数组长度不为3
     * <p>
     * 原文：Sets the offers to provide to the player.
     *
     * @param offers The offers to provide
     * @throws IllegalArgumentException if the array length isn't 3
     */
    void setOffers(@NotNull EnchantmentOffer[] offers) throws IllegalArgumentException;
}
