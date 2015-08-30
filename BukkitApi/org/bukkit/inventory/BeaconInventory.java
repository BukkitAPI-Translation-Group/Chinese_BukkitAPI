package org.bukkit.inventory;

/**
 * 与信标信号的接口.
 */
public interface BeaconInventory extends Inventory {

    /**
     * 设置提供给信标信号的物品.
     * <p>
     * 原文: Set the item powering the beacon.
     *
     * @param item 新的物品.
     */
    void setItem(ItemStack item);

    /**
     * 获取提供给信标信号的物品.
     * <p>
     * 原文: Get the item powering the beacon.
     *
     * @return 提供给信标信号的物品.
     */
    ItemStack getItem();
}
