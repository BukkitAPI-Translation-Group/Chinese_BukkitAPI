package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.HandlerList;

/**
 * 当一个方块基于自然法则地蔓延时触发此事件(比如菌丝的蔓延).
 * <p>
 * 用 {@link BlockFormEvent} 来获取方块 。方块蔓延是“随机”的形式，不是
 * 实际地传播.
 * <p>
 * 例如:
 * <ul>
 * <li>蘑菇的蔓延
 * <li>火的蔓延
 * </ul>
 * <p>
 * 若本事件被取消,方块就不会蔓延.
 *
 * @see BlockFormEvent
 */
public class BlockSpreadEvent extends BlockFormEvent {
    private static final HandlerList handlers = new HandlerList();
    private final Block source;

    public BlockSpreadEvent(final Block block, final Block source, final BlockState newState) {
        super(block, newState);
        this.source = source;
    }

    /**
     * 获取这个事件中蔓延的源方块.
     * <p>
     * 原文：Gets the source block involved in this event.
     *
     * @return 这个事件中蔓延的源方块
     */
    public Block getSource() {
        return source;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}