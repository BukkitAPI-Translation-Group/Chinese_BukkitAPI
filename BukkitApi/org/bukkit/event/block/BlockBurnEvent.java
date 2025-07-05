package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当一个方块被火烧掉的时候触发此事件.
 * <p>
 * 若方块点燃事件被取消，此方块就不会被火烧毁.
 */
public class BlockBurnEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Block ignitingBlock;

    @Deprecated(since = "1.11.2")
    public BlockBurnEvent(@NotNull final Block block) {
        this(block, null);
    }

    public BlockBurnEvent(@NotNull final Block block, @Nullable final Block ignitingBlock) {
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
    @Nullable
    public Block getIgnitingBlock() {
        return ignitingBlock;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}