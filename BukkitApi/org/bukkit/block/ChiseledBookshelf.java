package org.bukkit.block;

import org.bukkit.inventory.BlockInventoryHolder;
import org.bukkit.inventory.ChiseledBookshelfInventory;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

/**
 * 代表雕纹书架的捕获状态.
 * <p>
 * 原文:
 * Represents a captured state of a chiseled bookshelf.
 */
public interface ChiseledBookshelf extends TileState, BlockInventoryHolder {

    /**
     * 获取最后交互的物品栏槽位.
     * <p>
     * 原文:
     * Gets the last interacted inventory slot.
     *
     * @return 最后交互的槽位
     */
    int getLastInteractedSlot();

    /**
     * 设置最后交互的物品栏槽位.
     * <p>
     * 原文:
     * Sets the last interacted inventory slot.
     *
     * @param lastInteractedSlot 新的最后交互槽位
     */
    void setLastInteractedSlot(int lastInteractedSlot);

    /**
     * @return 物品栏
     * @see Container#getInventory()
     */
    @NotNull
    @Override
    ChiseledBookshelfInventory getInventory();

    /**
     * @return 快照物品栏
     * @see Container#getSnapshotInventory()
     */
    @NotNull
    ChiseledBookshelfInventory getSnapshotInventory();

    /**
     * 根据相对于此方块的向量获取适当的槽位.<br>
     * 如果给定向量不在任何槽位的边界内, 将返回-1.
     * <p>
     * 原文:
     * Gets the appropriate slot based on a vector relative to this block.<br>
     * Will return -1 if the given vector is not within the bounds of any slot.
     * <p>
     * The supplied vector should only contain components with values between 0.0
     * and 1.0, inclusive.
     *
     * 提供的向量应只包含值在0.0到1.0之间(含)的分量.
     *
     * @param position 相对于此方块的向量
     * @return 给定向量下的槽位或-1
     */
    int getSlot(@NotNull Vector position);
}
