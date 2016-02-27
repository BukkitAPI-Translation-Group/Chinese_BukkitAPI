package org.bukkit.block;

import org.bukkit.inventory.InventoryHolder;

/**
 * 代表一个投掷器.
 */
public interface Dropper extends BlockState, InventoryHolder {
    /**
     * 一个投掷器的正常行为是尝试从投掷器类型的背包随机进行投掷物品.
     * <p>
     * 投掷器正常的行为如下:
     * <p>
     * 如果这个投掷器方块面对的是一个InventoryHolder或者ContainerBlock类型对象,
     * ItemStack将会随机抽取投掷器里的物品放在第一个空的物品栏(从0开始计数),如果背包已满,什么也不会发生.
     * <p>
     * 如果这个投掷器方块面对的不是一个InventoryHolder或者ContainerBlock类型对象,
     * ItemStack将随机抽取投掷器里的物品一掉落在地上的形式 {@link org.bukkit.entity.Item Item} 投掷.
     * <p>
     * 原文:
     * Tries to drop a randomly selected item from the Dropper's inventory,
     * following the normal behavior of a Dropper.
     * <p>
     * Normal behavior of a Dropper is as follows:
     * <p>
     * If the block that the Dropper is facing is an InventoryHolder or
     * ContainerBlock the randomly selected ItemStack is placed within that 
     * Inventory in the first slot that's available, starting with 0 and
     * counting up.  If the inventory is full, nothing happens.
     * <p>
     * If the block that the Dropper is facing is not an InventoryHolder or
     * ContainerBlock, the randomly selected ItemStack is dropped on
     * the ground in the form of an {@link org.bukkit.entity.Item Item}.
     */
     public void drop();
}
