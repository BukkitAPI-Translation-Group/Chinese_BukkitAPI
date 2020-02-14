package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 液体流动/龙蛋自己传送的事件(源方块到目标方块).
 * <p>
 * 如果事件被取消,方块不会移动/流动.
 */
public class BlockFromToEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    protected Block to;
    protected BlockFace face;
    protected boolean cancel;

    public BlockFromToEvent(@NotNull final Block block, @NotNull final BlockFace face) {
        super(block);
        this.face = face;
        this.cancel = false;
    }

    public BlockFromToEvent(@NotNull final Block block, @NotNull final Block toBlock) {
        super(block);
        this.to = toBlock;
        this.face = BlockFace.SELF;
        this.cancel = false;
    }

    /**
     * 获取方块想要移动到的{@link BlockFace 朝向}.
     * <p>
     * 原文：Gets the BlockFace that the block is moving to.
     *
     * @return 方块想要移动到的{@link BlockFace 朝向}
     */
    @NotNull
    public BlockFace getFace() {
        return face;
    }

    /**
     * 获取方块要移动到的地方的一个快捷的方法.
     * <p>
     * Convenience method for getting the faced Block.
     *
     * @return 目标方块
     */
    @NotNull
    public Block getToBlock() {
        if (to == null) {
            to = block.getRelative(face);
        }
        return to;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
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