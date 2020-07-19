package org.bukkit.event.block;

import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.world.StructureGrowEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当玩家使用骨粉向某方块施肥后导致方块发生变化时触发本事件.
 * 将在合适之时调用 {@link StructureGrowEvent}.
 */
public class BlockFertilizeEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    //
    private final Player player;
    private final List<BlockState> blocks;

    public BlockFertilizeEvent(@NotNull Block theBlock, @Nullable Player player, @NotNull List<BlockState> blocks) {
        super(theBlock);
        this.player = player;
        this.blocks = blocks;
    }

    /**
     * 获取进行施肥的玩家.
     * <p>
     * 原文:Gets the player that triggered the fertilization.
     *
     * @return 进行施肥的玩家, 若不适用则为null
     */
    @Nullable
    public Player getPlayer() {
        return player;
    }

    /**
     * 返回由于施肥而产生变化的所有方块的列表.
     * <p>
     * 原文:Gets a list of all blocks changed by the fertilization.
     *
     * @return 产生变化的方块的列表
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
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
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
