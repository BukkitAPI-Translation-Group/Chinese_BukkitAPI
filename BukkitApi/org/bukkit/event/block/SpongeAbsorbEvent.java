package org.bukkit.event.block;

import java.util.List;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当海绵吸水时触发本事件.
 * <br>
 * 如果本事件没有被取消, 世界将会处于吸水之前的状态, {@link #getBlocks()} 将代表对世界做出的改变.
 * <br>
 * 由于这是一个基于物理变化的事件, 它可能因为“相同”的变化而被多次调用.
 */
public class SpongeAbsorbEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final List<BlockState> blocks;

    public SpongeAbsorbEvent(@NotNull Block block, @NotNull List<BlockState> waterblocks) {
        super(block);
        this.blocks = waterblocks;
    }

    /**
     * 获取因海绵吸水而被移除的方块的列表.
     * <br>
     * 该列表是可变的, 包含处于被移除状态的方块, 即空气({@link Material#AIR})方块.
     * <p>
     * 原文:Get a list of all blocks to be removed by the sponge.
     * <br>
     * This list is mutable and contains the blocks in their removed state, i.e.
     * having a type of {@link Material#AIR}.
     *
     * @return 被移除的方块的列表
     */
    @NotNull
    public List<BlockState> getBlocks() {
        return blocks;
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
