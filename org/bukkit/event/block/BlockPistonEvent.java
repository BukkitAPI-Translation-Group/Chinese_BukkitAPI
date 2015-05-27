package org.bukkit.event.block;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.Cancellable;

/**
 * 活塞被启动的事件
 */
public abstract class BlockPistonEvent extends BlockEvent implements Cancellable {
    private boolean cancelled;
    private final BlockFace direction;

    public BlockPistonEvent(final Block block, final BlockFace direction) {
        super(block);
        this.direction = direction;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    /**
     * 粘性活塞返回true
     *
     * @return 粘性活塞返回true
     */
    public boolean isSticky() {
        return block.getType() == Material.PISTON_STICKY_BASE || block.getType() == Material.PISTON_MOVING_PIECE;
    }

    /**
     * 活塞的方向.
     *
     * @return 活塞的方向
     */
    public BlockFace getDirection() {
        // Both are meh!
        // return ((PistonBaseMaterial) block.getType().getNewData(block.getData())).getFacing();
        // return ((PistonBaseMaterial) block.getState().getData()).getFacing();
        return direction;
    }
}
