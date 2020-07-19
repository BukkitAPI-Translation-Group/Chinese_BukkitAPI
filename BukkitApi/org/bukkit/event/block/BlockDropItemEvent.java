package org.bukkit.event.block;

import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当一个方块被玩家破坏且掉落物品时触发本事件.
 *
 * 如果方块破坏事件(BlockBreakEvent)被取消, 那么将不会触发本事件.
 *
 * 如果将 BlockBreakEvent 中的 isDropItems 设置为 false (通过 BlockBreakEvent 中的 setDropItems 方法设置), 也不会触发本事件.
 *
 * 如果玩家破坏了一个多方块结构, 例如在石头顶部的火把, 本事件也会被调用. 所有结构的掉落物计入同一个事件内.
 *
 * 当调用本事件时, 意味着此方块已经被破坏, 因此 #getBlock() 大部分情况是 AIR.
 * 请使用 #getBlockState() 获取有关此被破坏的方块的更多信息.
 */
public class BlockDropItemEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private boolean cancel;
    private final BlockState blockState;
    private final List<Item> items;

    public BlockDropItemEvent(@NotNull Block block, @NotNull BlockState blockState, @NotNull Player player, @NotNull List<Item> items) {
        super(block);
        this.blockState = blockState;
        this.player = player;
        this.items = items;
    }

    /**
     * 获取破坏这个方块的玩家.
     * <p>
     * 原文:Gets the Player that is breaking the block involved in this event.
     *
     * @return 破坏这个方块的玩家
     */
    @NotNull
    public Player getPlayer() {
        return player;
    }

    /**
     * 获取被破坏的方块的BlockState.
     * <p>
     * 原文:Gets the BlockState of the block involved in this event before it was
     * broken.
     *
     * @return 被破坏的方块的BlockState
     */
    @NotNull
    public BlockState getBlockState() {
        return blockState;
    }

    /**
     * 获取由于破坏方块而产生的掉落物实体的列表.
     *
     * 这个列表是可变的 - 移除在列表中的物品将导致其不会掉落.
     * 然而向这个列表添加新的物品是不合法的.
     * <p>
     * 原文:Gets list of the Item drops caused by the block break.
     *
     * This list is mutable - removing an item from it will cause it to not
     * drop. It is not legal however to add new items to the list.
     *
     * @return 方块被破坏后产生的掉落物的列表
     */
    @NotNull
    public List<Item> getItems() {
        return items;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
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
