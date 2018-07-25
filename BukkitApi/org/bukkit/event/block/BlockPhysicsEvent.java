package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 方块物理事件(例如是沙子掉落).
 */
public class BlockPhysicsEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final BlockData changed;
    private boolean cancel = false;

    public BlockPhysicsEvent(final Block block, final BlockData changed) {
        super(block);
        this.changed = changed;
    }

    /**
     * 获取事件中被改变的方块.
     * <p>
     * 原文：Gets the type of block that changed, causing this event
     *
     * @return 事件中被改变的方块的种类
     */
    public Material getChangedType() {
        return changed.getMaterial();
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}