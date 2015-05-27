package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import java.util.List;

/**
 * 方块爆炸事件
 */
public class BlockExplodeEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;
    private final List<Block> blocks;
    private float yield;

    public BlockExplodeEvent(final Block what, final List<Block> blocks, final float yield) {
        super(what);
        this.blocks = blocks;
        this.yield = yield;
        this.cancel = false;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 返回炸没的方块的列表
     *
     * @return 炸没的方块的列表
     */
    public List<Block> blockList() {
        return blocks;
    }

    /**
     * 返回来自这次爆炸的方块掉落的百分比 
     *
     * @return 百分率
     */
    public float getYield() {
        return yield;
    }

    /**
     * 设置来自这次爆炸的方块掉落的百分比 
     *
     * @param 百分率
     */
    public void setYield(float yield) {
        this.yield = yield;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
