package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当一个方块被火烧掉的时候触发此事件.
 * <p>
 * 若方块点燃事件被取消，此方块就不会被火烧毁.
 */
public class BlockBurnEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Block ignitingBlock;

    @Deprecated
    public BlockBurnEvent(final Block block) {
        this(block, null);
    }

    public BlockBurnEvent(final Block block, final Block ignitingBlock) {
        super(block);
        this.ignitingBlock = ignitingBlock;
    }

    /**
     * 获取点燃这个方块的方块.
     * <p>
     * 原文:Gets the block which ignited this block.
     *
     * @return 点燃这个方块的方块，或如果源方块不存在时为null
     */
    public Block getIgnitingBlock() {
        return ignitingBlock;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}