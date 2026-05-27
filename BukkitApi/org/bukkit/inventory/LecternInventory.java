package org.bukkit.inventory;

import org.bukkit.block.Lectern;
import org.jetbrains.annotations.Nullable;

/**
 * 讲台的物品栏接口.
 */
public interface LecternInventory extends Inventory {

    @Nullable
    @Override
    public Lectern getHolder();
}
