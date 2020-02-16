package org.bukkit.inventory;

import org.jetbrains.annotations.Nullable;

/**
 * 信标的背包界面接口
 */
public interface BeaconInventory extends Inventory {

    /**
     * 设置信标内的物品. 
     * <p>
     * 原文: Set the item powering the beacon.
     *
     * @param item 新的物品.
     */
    void setItem(@Nullable ItemStack item);

    /**
     * 返回信标内的物品. 
     * <p>
     * 原文: Get the item powering the beacon.
     *
     * @return 物品
     */
    @Nullable
    ItemStack getItem();
}
