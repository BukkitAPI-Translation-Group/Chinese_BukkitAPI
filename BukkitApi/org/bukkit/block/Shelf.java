package org.bukkit.block;

import org.bukkit.inventory.BlockInventoryHolder;
import org.bukkit.inventory.ShelfInventory;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

/**
 * 表示书架的捕获状态。
 */
public interface Shelf extends TileState, BlockInventoryHolder {

    /**
     * @return 物品栏
     * @see Container#getInventory()
     */
    @NotNull
    @Override
    ShelfInventory getInventory();

    /**
     * @return 快照物品栏
     * @see Container#getSnapshotInventory()
     */
    @NotNull
    ShelfInventory getSnapshotInventory();

    /**
     * 根据相对于此方块的向量获取对应的槽位。<br>
     * 如果给定的向量不在任何槽位的范围内，则返回 -1。
     * <p>
     * 提供的向量应仅包含值在 0.0 到 1.0 之间（含）的分量。
     *
     * @param position 相对于此方块的向量
     * @return 给定向量下的槽位，或 -1
     * <p>
     * 原文：Gets the appropriate slot based on a vector relative to this block.<br>
     * Will return -1 if the given vector is not within the bounds of any slot.
     * <p>
     * The supplied vector should only contain components with values between 0.0
     * and 1.0, inclusive.
     */
    int getSlot(@NotNull Vector position);
}
