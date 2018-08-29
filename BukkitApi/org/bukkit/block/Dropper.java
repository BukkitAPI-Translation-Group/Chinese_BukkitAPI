package org.bukkit.block;

import org.bukkit.Nameable;
import org.bukkit.loot.Lootable;

/**
 * 代表一个投掷器(快照).
 */
public interface Dropper extends Container, Nameable, Lootable {
    /**
     * 一个投掷器的正常行为是尝试从投掷器的物品栏随机进行投掷物品.
     * <p>
     * 投掷器正常的行为如下:
     * <p>
     * 如果这个投掷器方块面对的是一个InventoryHolder,
     * ItemStack将会随机抽取投掷器里的物品放在第一个空的物品栏(从0开始计数),如果背包已满,什么也不会发生.
     * <p>
     * 如果这个投掷器方块面对的不是一个InventoryHolder,
     * ItemStack将随机抽取投掷器里的物品一掉落在地上的形式 {@link org.bukkit.entity.Item Item} 投掷.
     * <p>
     * 如果该方块状态代表的方块不再是一个投掷器,使用本方法没有任何效果.
     * <p>
     * 原文:
     * Tries to drop a randomly selected item from the dropper's inventory,
     * following the normal behavior of a dropper.
     * <p>
     * Normal behavior of a dropper is as follows:
     * <p>
     * If the block that the dropper is facing is an InventoryHolder,
     * the randomly selected ItemStack is placed within that 
     * Inventory in the first slot that's available, starting with 0 and
     * counting up.  If the inventory is full, nothing happens.
     * <p>
     * If the block that the dropper is facing is not an InventoryHolder,
     * the randomly selected ItemStack is dropped on
     * the ground in the form of an {@link org.bukkit.entity.Item Item}.
     * <p>
     * If the block represented by this state is no longer a dropper, this will
     * do nothing.
     * 
     * @throws IllegalStateException 如果方块状态未应用(译注:仅仅是一种表示而未应用到实际的方块上)
     */
     public void drop();
}
