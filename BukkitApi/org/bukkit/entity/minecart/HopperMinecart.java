package org.bukkit.entity.minecart;

import org.bukkit.entity.Minecart;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.loot.Lootable;

/**
 * 代表漏斗矿车.
 */
public interface HopperMinecart extends Minecart, InventoryHolder, Lootable {

    /**
     * 检测这个矿车是否会将物品捡进背包.
     * <p>
     * 原文：Checks whether or not this Minecart will pick up
     * items into its inventory.
     *
     * @return 这个矿车是否会将物品捡进背包.
     */
    boolean isEnabled();

    /**
     * 设置这个矿车是否会将物品捡进背包.
     * <p>
     * 原文：Sets whether this Minecart will pick up items.
     *
     * @param enabled 新的启用状态
     */
    void setEnabled(boolean enabled);
}
