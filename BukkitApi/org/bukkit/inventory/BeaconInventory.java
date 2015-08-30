package org.bukkit.inventory;

/**
 * 与信标信号的接口
 */
public interface BeaconInventory extends Inventory {

    /**
     * 原文: Set the item powering the beacon.
     * <p>
     * 译文: 设置提供给信标信号的物品
     *
     * @param item 新的物品
     */
    void setItem(ItemStack item);

    /**
     * 原文: Get the item powering the beacon.
     * <p>
     * 译文: 获取提供给信标信号的物品
     *
     * @return 提供给信标信号的物品
     */
    ItemStack getItem();
}
