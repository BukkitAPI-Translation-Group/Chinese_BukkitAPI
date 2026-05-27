package org.bukkit.inventory.view;

import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.LecternInventory;
import org.jetbrains.annotations.NotNull;

/**
 * 一个提供与讲台视图数据相关额外方法的 {@link InventoryView} 实例。
 */
public interface LecternView extends InventoryView {

    @NotNull
    @Override
    LecternInventory getTopInventory();

    /**
     * 获取LecternView当前所在的页码。
     *
     * @return 书本当前的页码
     * <p>
     * 原文：Gets the page that the LecternView is on.
     *
     * @return The page the book is on
     */
    int getPage();

    /**
     * 设置讲台书本的页码。
     *
     * @param page 讲台书本的页码
     * <p>
     * 原文：Sets the page of the lectern book.
     *
     * @param page the lectern book page
     */
    void setPage(final int page);
}
