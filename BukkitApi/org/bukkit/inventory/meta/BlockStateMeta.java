
package org.bukkit.inventory.meta;

import org.bukkit.block.BlockState;

public interface BlockStateMeta extends ItemMeta {

    /**
     * 返回这个物品当前是否附加BlockState. 
     * <p>
     * 原文:Returns whether the item has a block state currently
     * attached to it.
     * 
     * @return 这个物品当前是否附加BlockState
     */
    boolean hasBlockState();

    /**
     * 返回这个物品当前附加的BlockState，如果不存在将创建一个新的.
     * <p>
     * 这个状态是一个副本，它必须被{@link #setBlockState(org.bukkit.block.BlockState)}重新设置(或其它物品).
     * <p>
     * 原文:Returns the currently attached block state for this
     * item or creates a new one if one doesn't exist.
     *
     * The state is a copy, it must be set back (or to another
     * item) with {@link #setBlockState(org.bukkit.block.BlockState)}
     *
     * @return 附加的状态或一个新的状态
     */
    BlockState getBlockState();

    /**
     * 将BlockState副本附加到物品上(设置这个物品的BlockState).
     * <p>
     * 原文:Attaches a copy of the passed block state to the item.
     *
     * @param blockState 要附加给这个方块的BlockState
     * @throws IllegalArgumentException 如果blockState参数为null或对于这个物品是无效的
     */
    void setBlockState(BlockState blockState);
}
