package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

/**
 * 代表与方块相关的事件.
 */
public abstract class BlockEvent extends Event {
    protected Block block;

    public BlockEvent(@NotNull final Block theBlock) {
        block = theBlock;
    }

    /**
     * 获取这个事件涉及的方块.
     * <p>
     * 原文：Gets the block involved in this event.
     *
     * @return 这个事件涉及的方块
     */
    @NotNull
    public final Block getBlock() {
        return block;
    }
}