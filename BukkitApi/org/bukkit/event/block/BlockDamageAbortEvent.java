package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家停止破坏方块时触发.
 * @see BlockDamageEvent
 */
public class BlockDamageAbortEvent extends BlockEvent {

    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final ItemStack itemstack;

    public BlockDamageAbortEvent(@NotNull final Player player, @NotNull final Block block, @NotNull final ItemStack itemInHand) {
        super(block);
        this.player = player;
        this.itemstack = itemInHand;
    }

    /**
     * 获取停止破坏此事件中方块的玩家.
     *
     * 原文：
     * Gets the player that stopped damaging the block involved in this event.
     *
     * @return 停止破坏方块的玩家
     */
    @NotNull
    public Player getPlayer() {
        return player;
    }

    /**
     * 获取玩家手中当前物品的 ItemStack.
     *
     * 原文：
     * Gets the ItemStack for the item currently in the player's hand.
     *
     * @return 玩家手中当前物品的 ItemStack
     */
    @NotNull
    public ItemStack getItemInHand() {
        return itemstack;
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
