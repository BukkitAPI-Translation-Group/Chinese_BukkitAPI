package org.bukkit.inventory.view.builder;

import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 没有特殊属性或参数的通用 InventoryView 构建器
 *
 * @param <V> 通过此构建器创建的 InventoryView 的类型
 */
@ApiStatus.Experimental
public interface InventoryViewBuilder<V extends InventoryView> {

    /**
     * 创建此构建器的副本
     * <p>
     * 原文：Makes a copy of this builder
     *
     * @return 此构建器的副本
     */
    @NotNull
    InventoryViewBuilder<V> copy();

    /**
     * 设置构建器的标题
     * <p>
     * 原文：Sets the title of the builder
     *
     * @param title 标题
     * @return 此构建器
     */
    @NotNull
    InventoryViewBuilder<V> title(@NotNull final String title);

    /**
     * 将此构建器构建为 InventoryView
     * <p>
     * 原文：Builds this builder into a InventoryView
     *
     * @param player 要分配给视图的玩家
     * @return 创建的 InventoryView
     */
    @NotNull
    V build(@NotNull final HumanEntity player);
}
