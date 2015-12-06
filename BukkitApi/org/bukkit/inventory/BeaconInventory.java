package org.bukkit.inventory;

/**
 * 信标的背包GUI接口
 */
public interface BeaconInventory extends Inventory {

    /**
     * 设置激活这个信标的药水效果的物品. 
     * <p>
     * 原文: Set the item powering the beacon.
     *
     * @param item 新的物品.
     */
    void setItem(ItemStack item);

    /**
     * 返回激活这个信标的药水效果的物品. 
     * <p>
     * 原文: Get the item powering the beacon.
     *
     * @return 物品
     */
    ItemStack getItem();
}