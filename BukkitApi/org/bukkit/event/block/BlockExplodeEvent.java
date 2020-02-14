package org.bukkit.event.block;

import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 方块爆炸事件.
 * <p>
 * 译注:{@link #getBlock()}方法返回的是引起爆炸的方块(比如TNT),并不是被炸掉的方块.
 */
public class BlockExplodeEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;
    private final List<Block> blocks;
    private float yield;

    public BlockExplodeEvent(@NotNull final Block what, @NotNull final List<Block> blocks, final float yield) {
        super(what);
        this.blocks = blocks;
        this.yield = yield;
        this.cancel = false;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 返回被炸毁的方块的列表.
     * <p>
     * 原文：Returns the list of blocks that would have been removed or were removed
     * from the explosion event.
     *
     * @return 炸毁的方块的列表
     */
    @NotNull
    public List<Block> blockList() {
        return blocks;
    }

    /**
     * 返回这次爆炸炸毁的方块掉落的可能性(小数百分比). 
     * <p>
     * 原文：Returns the percentage of blocks to drop from this explosion
     *
     * @return 小数百分率
     */
    public float getYield() {
        return yield;
    }

    /**
     * 设置这次爆炸炸毁的方块掉落的可能性(小数百分比).
     * <p>
     * 原文：Sets the percentage of blocks to drop from this explosion
     *
     * @param yield 小数百分率
     */
    public void setYield(float yield) {
        this.yield = yield;
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