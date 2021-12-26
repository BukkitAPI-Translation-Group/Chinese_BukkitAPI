package org.bukkit.block;

import org.bukkit.inventory.BlockInventoryHolder;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

/**
 * 代表讲台.
 */
public interface Lectern extends TileState, BlockInventoryHolder {

    /**
     * 获取讲台上书翻到了哪一页.
     * <p>
     * 原文:Get the current lectern page.
     *
     * @return 书的页码
     */
    int getPage();

    /**
     * 把讲台上的书翻到哪一页.
     * 如果给定的页数大于讲台上书的页数, 则相关行为是未定义的.
     * <p>
     * 原文:Set the current lectern page.
     *
     * If the page is greater than the number of pages of the book currently in
     * the inventory, then behavior is undefined.
     *
     * @param page 书的页码
     */
    void setPage(int page);

    /**
     * @return 物品栏
     * @see Container#getInventory()
     */
    @NotNull
    @Override
    Inventory getInventory();

    /**
     * @return 物品栏快照
     * @see Container#getSnapshotInventory()
     */
    @NotNull
    Inventory getSnapshotInventory();
}
