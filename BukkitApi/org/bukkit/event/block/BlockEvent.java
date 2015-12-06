package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.Event;

/**
 * 代表与方块相关的事件.
 */
public abstract class BlockEvent extends Event {
    protected Block block;

    public BlockEvent(final Block theBlock) {
        block = theBlock;
    }

    /**
     * 获取这个事件是哪个方块发生的.
     * <p>
     * 原文：Gets the block involved in this event.
     *
     * @return 在这个事件中触发的方块
     */
    public final Block getBlock() {
        return block;
    }
}