package org.bukkit.entity.minecart;

import org.bukkit.entity.Minecart;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.loot.Lootable;

/**
 * 代表运输矿车，你可以使用{@link InventoryHolder}里的方法来访问.
 */
public interface StorageMinecart extends Minecart, InventoryHolder, Lootable {
}