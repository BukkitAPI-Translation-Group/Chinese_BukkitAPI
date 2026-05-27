package org.bukkit.inventory;

import org.bukkit.block.ChiseledBookshelf;
import org.jetbrains.annotations.Nullable;

/**
 * 雕纹书架的物品栏接口.
 */
public interface ChiseledBookshelfInventory extends Inventory {

    @Nullable
    @Override
    public ChiseledBookshelf getHolder();
}
