package org.bukkit.inventory.view;

import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantInventory;
import org.jetbrains.annotations.NotNull;

/**
 * 一个提供与商人视图数据相关额外方法的 {@link InventoryView} 实例。
 */
public interface MerchantView extends InventoryView {

    @NotNull
    @Override
    MerchantInventory getTopInventory();

    /**
     * 获取此视图对应的商人。
     *
     * @return 此视图使用的商人
     * <p>
     * 原文：Gets the merchant that this view is for.
     *
     * @return The merchant that this view uses
     */
    @NotNull
    Merchant getMerchant();
}
