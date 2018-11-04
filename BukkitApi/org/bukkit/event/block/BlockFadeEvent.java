package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 方块因为自然条件消退，融化，消失的事件.
 * <p>
 * 例如:
 * <ul>
 * <li>雪被附近的光源融化
 * <li>冰被附近的光源融化
 * <li>火燃烧后破坏可以作为燃料的方块
 * <li>珊瑚因缺水而变为失活的珊瑚.</li>
 * </ul>
 * <p>
 * 如果这事件被取消, 方块不会因为自然条件消退，融化，消失.
 */
public class BlockFadeEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final BlockState newState;

    public BlockFadeEvent(final Block block, final BlockState newState) {
        super(block);
        this.newState = newState;
        this.cancelled = false;
    }

    /**
     * 获取因为世界条件消退，融化，消失的方块的状态({@link BlockState}).
     * <p>
     * 原文：Gets the state of the block that will be fading, melting or
     * disappearing.
     *
     * @return 方块的新状态({@link BlockState})
     */
    public BlockState getNewState() {
        return newState;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}