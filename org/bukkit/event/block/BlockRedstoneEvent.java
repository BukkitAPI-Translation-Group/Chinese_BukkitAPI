package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;

/**
 * 当红石信号变化时，调用本事件
 */
public class BlockRedstoneEvent extends BlockEvent {
    private static final HandlerList handlers = new HandlerList();
    private final int oldCurrent;
    private int newCurrent;

    public BlockRedstoneEvent(final Block block, final int oldCurrent, final int newCurrent) {
        super(block);
        this.oldCurrent = oldCurrent;
        this.newCurrent = newCurrent;
    }

    /**
     * 获取这个方块之前的形态
     *
     * @return 这个方块之前的形态
     */
    public int getOldCurrent() {
        return oldCurrent;
    }

    /**
     * 获取这个方块现在的形态
     *
     * @return 这个方块现在的形态
     */
    public int getNewCurrent() {
        return newCurrent;
    }

    /**
     * 设置这个方块现在的形态
     *
     * @param newCurrent 这个方块现在的形态
     */
    public void setNewCurrent(int newCurrent) {
        this.newCurrent = newCurrent;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
