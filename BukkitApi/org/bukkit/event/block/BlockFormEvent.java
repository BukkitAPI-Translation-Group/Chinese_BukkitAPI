package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.HandlerList;

/**
 * 当一个方块因为自然变化被放置、更改或者蔓延时(比如下雪),触发此事件.
 * <p>
 * 使用 {@link BlockSpreadEvent} 来捕获方块，事实上在方块蔓延的时候，不只是
 * "随意地" 构成。
 * <p>
 * 例子:
 * <ul>
 * <li>雪在下雪的时候形成.
 * <li>冰在有雪的生物群系中构成.
 * <li>黑曜石/圆石/(石头)由于(熔岩)与水接触而蔓延(熔岩与水的接触的结果).
 * <li>混凝土由于混凝土粉末与水的混合固化而蔓延.
 * </ul>
 * <p>
 * 如果本事件被取消，方块将不会蔓延等.
 * 
 * @see BlockSpreadEvent
 */
public class BlockFormEvent extends BlockGrowEvent {
    private static final HandlerList handlers = new HandlerList();

    public BlockFormEvent(final Block block, final BlockState newState) {
        super(block, newState);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
