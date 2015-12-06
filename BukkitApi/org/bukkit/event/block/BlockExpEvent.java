package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;

/**
 * 方块产生经验的时候(比如煤矿被被打破会掉落经验)时触发.
 */
public class BlockExpEvent extends BlockEvent {
    private static final HandlerList handlers = new HandlerList();
    private int exp;

    public BlockExpEvent(Block block, int exp) {
        super(block);

        this.exp = exp;
    }

    /**
     * 在事件被执行之后获取方块掉落的经验.
     * <p>
     * 原文：Get the experience dropped by the block after the event has processed
     *
     * @return 方块掉落的经验
     */
    public int getExpToDrop() {
        return exp;
    }

    /**
     * 设置这个方块在事件被执行之后会掉落多少经验.
     * <p>
     * 原文：Set the amount of experience dropped by the block after the event has
     * processed
     *
     * @param exp 应该比1多,否则啥也不会掉落
     */
    public void setExpToDrop(int exp) {
        this.exp = exp;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}