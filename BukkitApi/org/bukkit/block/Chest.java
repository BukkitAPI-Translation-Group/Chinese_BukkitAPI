package org.bukkit.block;

import org.bukkit.inventory.Inventory;

/**
 * 代表一个箱子.
 */
public interface Chest extends BlockState, ContainerBlock {

    /**
     * 返回箱子类型的背包。如果这是大型箱子，也将返回此类型背包.
     * 在这个箱子类型的背包的一部分.
     * 原文:
     * Returns the chest's inventory. If this is a double chest, it returns
     * just the portion of the inventory linked to this half of the chest.
     *
     * @return 箱子类型的背包.
     */
    Inventory getBlockInventory();
}

