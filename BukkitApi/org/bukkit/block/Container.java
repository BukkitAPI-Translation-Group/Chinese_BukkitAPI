package org.bukkit.block;

import org.bukkit.Nameable;
import org.bukkit.inventory.BlockInventoryHolder;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

/**
 * 代表容器方块.
 */
public interface Container extends TileState, BlockInventoryHolder, Lockable, Nameable {

    /**
     * 获取此容器方块的物品栏.
     * <p>
     * 如果于此同时此方块的类型发生改变, 返回的物品栏可能不再有效.
     * <p>
     * 如果此方块未被放置, 这将返回物品栏快照.
     * <p>
     * 原文:Gets the inventory of the block represented by this block state.
     * <p>
     * If the block was changed to a different type in the meantime, the
     * returned inventory might no longer be valid.
     * <p>
     * If this block state is not placed this will return the captured inventory
     * snapshot instead.
     *
     * @return 物品栏
     */
    @NotNull
    @Override
    Inventory getInventory();

    /**
     * 获取本容器的物品栏的快照.
     * <p>
     * 返回的快照不与任何方块相关联.
     * 任何对此物品栏快照的修改将不会应用于真实的方块上, 直到调用 {@link #update(boolean, boolean)}.
     * <p>
     * 原文:Gets the captured inventory snapshot of this container.
     * <p>
     * The returned inventory is not linked to any block. Any modifications to
     * the returned inventory will not be applied to the block represented by
     * this block state up until {@link #update(boolean, boolean)} has been
     * called.
     *
     * @return 物品栏快照
     */
    @NotNull
    Inventory getSnapshotInventory();
}
