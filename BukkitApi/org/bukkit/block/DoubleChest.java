package org.bukkit.block;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

/**
 * 代表一个大型箱子.
 */
public class DoubleChest implements InventoryHolder {
    private DoubleChestInventory inventory;

    public DoubleChest(DoubleChestInventory chest) {
        inventory = chest;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public InventoryHolder getLeftSide() {
        return inventory.getLeftSide().getHolder();
    }

    public InventoryHolder getRightSide() {
        return inventory.getRightSide().getHolder();
    }

    public Location getLocation() {
        return getInventory().getLocation();
    }

    public World getWorld() {
        return getLocation().getWorld();
    }

    public double getX() {
        return getLocation().getX();
    }

    public double getY() {
        return getLocation().getY();
    }

    public double getZ() {
        return getLocation().getZ();
    }
}
