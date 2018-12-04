package org.bukkit.event.block;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.Cancellable;

/**
 * 活塞相关事件
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
     * 判断是否是粘性活塞.
     * <p>
     * 原文：Returns true if the Piston in the event is sticky.
     *
     * @return 如是粘性活塞则返回true.
     */
    public boolean isSticky() {
        return block.getType() == Material.STICKY_PISTON || block.getType() == Material.MOVING_PISTON;
    }

    /**
     * 返回活塞的朝向.
     * <p>
     * 原文：Return the direction in which the piston will operate.
     *
     * @return 活塞的朝向
     */
    public BlockFace getDirection() {
        // Both are meh!
        // return ((PistonBaseMaterial) block.getType().getNewData(block.getData())).getFacing();
        // return ((PistonBaseMaterial) block.getState().getData()).getFacing();
        return direction;
    }
}