package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.Material;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 方块物理事件(例如是沙子掉落).
 */
public class BlockPhysicsEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final int changed;
    private boolean cancel = false;

    /**
     *
     * @deprecated 不安全的参数
     * @param block 这个事件的方块
     * @param changed 方块id
     */
    @Deprecated
    public BlockPhysicsEvent(final Block block, final int changed) {
        super(block);
        this.changed = changed;
    }

    /**
     * 获取事件中被改变的方块的ID.
     * <p>
     * 原文：Gets the type of block that changed, causing this event
     *
     * @return 被改变的方块的id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public int getChangedTypeId() {
        return changed;
    }

    /**
     * 获取事件中被改变的方块.
     * <p>
     * 原文：Gets the type of block that changed, causing this event
     *
     * @return 事件中被改变的方块的种类
     */
    public Material getChangedType() {
        return Material.getMaterial(changed);
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