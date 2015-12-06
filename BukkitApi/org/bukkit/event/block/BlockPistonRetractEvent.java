package org.bukkit.event.block;

import java.util.List;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.HandlerList;

/**
 * 活塞臂缩回事件
 */
public class BlockPistonRetractEvent extends BlockPistonEvent {
    private static final HandlerList handlers = new HandlerList();
    private List<Block> blocks;
    
    public BlockPistonRetractEvent(final Block block, final List<Block> blocks, final BlockFace direction) {
        super(block, direction);
        
        this.blocks = blocks;
    }

    /**
     * 如果缩回的活塞是粘性的,获取被这个活塞粘住的方块的位置. 
     * <p>
     * 原文：Gets the location where the possible moving block might be if the
     * retracting piston is sticky.
     *
     * @return 这个活塞粘住的方块的位置
     */
    @Deprecated
    public Location getRetractLocation() {
        return getBlock().getRelative(getDirection(), 2).getLocation();
    }
    
    /**
     * 获取被活塞移动的不可改变的方块列表.
     * <p>
     * 原文：Get an immutable list of the blocks which will be moved by the
     * extending.
     *
     * @return 被活塞移动的方块列表.
     */
    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}