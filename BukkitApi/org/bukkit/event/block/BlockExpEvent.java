package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;

/**
 * 原：An event that's called when a block yields experience.
 * 这就是传说中方块产生经验的事件。
 */
public class BlockExpEvent extends BlockEvent {
    private static final HandlerList handlers = new HandlerList();
    private int exp;

    public BlockExpEvent(Block block, int exp) {
        super(block);

        this.exp = exp;
    }

    /**
     * 在事件被执行之后获取方块掉落的经验
     *
     * @return 方块掉落的经验
     */
    public int getExpToDrop() {
        return exp;
    }

    /**
     * 设置这个方块在事件被执行之后会掉落多少经验
     *
     * @param exp 应该比1多，否则啥也不会掉落
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
