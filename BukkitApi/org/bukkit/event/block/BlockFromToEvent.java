package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 水流动/龙蛋自己传送的事件（源方块->目标方块） 
 * <p>
 * 事件被取消, 方块不会移动/流动.
 */
public class BlockFromToEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    protected Block to;
    protected BlockFace face;
    protected boolean cancel;

    public BlockFromToEvent(final Block block, final BlockFace face) {
        super(block);
        this.face = face;
        this.cancel = false;
    }

    public BlockFromToEvent(final Block block, final Block toBlock) {
        super(block);
        this.to = toBlock;
        this.face = BlockFace.SELF;
        this.cancel = false;
    }

    /**
     * 获取方块想要移动到的 BlockFace 
     *
     * @return 方块想要移动到的 BlockFace 
     */
    public BlockFace getFace() {
        return face;
    }

    /**
     * 获取目标方块的一个便捷的方法
     *
     * @return 目标方块
     */
    public Block getToBlock() {
        if (to == null) {
            to = block.getRelative(face);
        }
        return to;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
