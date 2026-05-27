package org.bukkit.inventory;

import org.bukkit.block.Shelf;
import org.jetbrains.annotations.Nullable;

/**
 * 书架的物品栏接口.
 */
public interface ShelfInventory extends Inventory {

    @Nullable
    @Override
    public Shelf getHolder();
}
