package org.bukkit.inventory.view.builder;

import org.bukkit.Server;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.Merchant;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 用于创建商人视图的 InventoryViewBuilder
 *
 * @param <V> 通过此构建器创建的 InventoryView 的类型
 */
@ApiStatus.Experimental
public interface MerchantInventoryViewBuilder<V extends InventoryView> extends InventoryViewBuilder<V> {

    @NotNull
    @Override
    MerchantInventoryViewBuilder<V> copy();

    @NotNull
    @Override
    MerchantInventoryViewBuilder<V> title(@NotNull final String title);

    /**
     * 向此构建器添加商人
     * <p>
     * 原文：Adds a merchant to this builder
     *
     * @param merchant 商人
     * @return 此构建器
     */
    @NotNull
    MerchantInventoryViewBuilder<V> merchant(@NotNull final Merchant merchant);

    /**
     * 确定服务器是否应检查玩家能否到达该位置。
     * <p>
     * 如果提供了 checkReachable 且通过 {@link Server#createMerchant(String)} 向构建器提供了虚拟商人，则此方法对实际菜单状态不会产生影响。
     * <p>
     * 原文：Determines whether or not the server should check if the player can reach the location.
     * Given checkReachable is provided and a virtual merchant is provided to the builder from {@link Server#createMerchant(String)} this method will have no effect on the actual menu status.
     *
     * @param checkReachable 是否检查视图是否"可到达"
     * @return 此构建器
     */
    @NotNull
    MerchantInventoryViewBuilder<V> checkReachable(final boolean checkReachable);
}
