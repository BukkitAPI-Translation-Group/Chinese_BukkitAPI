package org.bukkit.block;

import org.bukkit.Nameable;
import org.bukkit.inventory.Inventory;
import org.bukkit.loot.Lootable;

/**
 * 代表一个箱子(快照).
 */
public interface Chest extends Container, Nameable, Lootable {

    /**
     * 返回箱子类型的物品栏.
     * <p>
     * 如果这是大型箱子，将返回与此箱子对应的一半.
     * <p>
     * 如果方块状态未应用(译注:仅仅是一种表示而未应用到实际的方块上)本方法将返回物品栏快照.
     * <p>
     * 原文:
     * Gets the inventory of the chest block represented by this block state.
     * <p>
     * If the chest is a double chest, it returns just the portion of the
     * inventory linked to the half of the chest corresponding to this block state.
     * <p>
     * If the block was changed to a different type in the meantime, the
     * returned inventory might no longer be valid.
     * <p>
     * If this block state is not placed this will return the captured
     * inventory snapshot instead.
     *
     * @return 箱子类型的物品栏
     */
    Inventory getBlockInventory();
}

