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
     * 获取在这个事件中被调用的方块
     *
     * @return 在这个事件中被调用的方块
     */
    public final Block getBlock() {
        return block;
    }
}
