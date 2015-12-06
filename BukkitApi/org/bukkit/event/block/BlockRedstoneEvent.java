package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;

/**
 * 当方块接受到的红石信号变化时触发此事件
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
     * 获取这个方块之前的红石信号强度(0~15).
     * <p>
     * 原文：Gets the old current of this block
     *
     * @return 红石信号强度(0~15)
     */
    public int getOldCurrent() {
        return oldCurrent;
    }

    /**
     * 获取这个方块收到的红石信号强度将要变成的值(0~15).
     * <p>
     * 原文：Gets the new current of this block
     *
     * @return 红石信号强度(0~15)
     */
    public int getNewCurrent() {
        return newCurrent;
    }

    /**
     * 设置这个方块收到的红石信号强度将要变成的值(0~15).
     * <p>
     * 原文：Sets the new current of this block
     *
     * @param newCurrent 红石信号强度,取值(0~15)
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