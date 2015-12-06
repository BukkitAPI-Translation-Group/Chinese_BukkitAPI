package org.bukkit.event.block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.HandlerList;

/**
 * 活塞臂推出事件.
 */
public class BlockPistonExtendEvent extends BlockPistonEvent {
    private static final HandlerList handlers = new HandlerList();
    private final int length;
    private List<Block> blocks;

    @Deprecated
    public BlockPistonExtendEvent(final Block block, final int length, final BlockFace direction) {
        super(block, direction);

        this.length = length;
    }

    public BlockPistonExtendEvent(final Block block, final List<Block> blocks, final BlockFace direction) {
        super(block, direction);

        this.length = blocks.size();
        this.blocks = blocks;
    }

    /**
     * 获取被活塞移动的方块数.
     * <p>
     * 原文：Get the amount of blocks which will be moved while extending.
     *
     * @return 被活塞移动的方块数.
     * @deprecated 由于史莱姆方块的特性,
     * 这个方法是不准确的因为它不包含史莱姆方块粘走的方块,
     * 如MC版本低于1.8请无视此句.
     */
    @Deprecated
    public int getLength() {
        return this.length;
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
        if (blocks == null) {
            ArrayList<Block> tmp = new ArrayList<Block>();
            for (int i = 0; i < this.getLength(); i++) {
                tmp.add(block.getRelative(getDirection(), i + 1));
            }
            blocks = Collections.unmodifiableList(tmp);
        }
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