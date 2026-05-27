package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 当方块被玩家刷扫时触发.
 */
@ApiStatus.Experimental
public class BlockBrushEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final BlockState newState;
    private boolean cancel;

    public BlockBrushEvent(@NotNull final Block theBlock, @NotNull final BlockState newState, @NotNull final Player player) {
        super(theBlock);

        this.newState = newState;
        this.player = player;
    }

    /**
     * 获取正在刷扫此事件中方块的玩家.
     *
     * 原文：
     * Gets the Player that is brushing the block involved in this event.
     *
     * @return 正在刷扫此事件中方块的玩家
     */
    @NotNull
    public Player getPlayer() {
        return player;
    }

    /**
     * 获取此方块将转变成的方块状态.
     *
     * 原文：
     * Gets the state of the block that this block will turn into.
     *
     * @return 方块将转变成的方块状态
     */
    @NotNull
    public BlockState getNewState() {
        return newState;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    @NotNull
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
