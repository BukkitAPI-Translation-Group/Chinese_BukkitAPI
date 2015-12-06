package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 * 方块被玩家损坏的事件.
 * <p>
 * 若本事件被取消，方块将不会损坏
 */
public class BlockDamageEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private boolean instaBreak;
    private boolean cancel;
    private final ItemStack itemstack;

    public BlockDamageEvent(final Player player, final Block block, final ItemStack itemInHand, final boolean instaBreak) {
        super(block);
        this.instaBreak = instaBreak;
        this.player = player;
        this.itemstack = itemInHand;
        this.cancel = false;
    }

    /**
     * 获取试图损坏这个方块的玩家.
     * <p>
     * 原文：Gets the player damaging the block involved in this event.
     *
     * @return 损坏这个方块的玩家
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * 返回方块是否立即被玩家损坏(比如创造模式).
     * <p>
     * 原文：Gets if the block is set to instantly break when damaged by the player.
     *
     * @return 如果方块在被玩家损坏时是被立即破坏的，返回true，反之false
     *     
     */
    public boolean getInstaBreak() {
        return instaBreak;
    }

    /**
     * 设置方块是否立即被玩家损坏(比如创造模式).
     * <p>
     * 原文：Sets if the block should instantly break when damaged by the player.
     *
     * @param bool 如果你想要方块在被玩家损坏时被立即破坏，请设置true，反之false
     */
    public void setInstaBreak(boolean bool) {
        this.instaBreak = bool;
    }

    /**
     * 获取当前玩家手上的物品.
     * <p>
     * 原文：Gets the ItemStack for the item currently in the player's hand.
     *
     * @return 当前玩家手上的物品
     */
    public ItemStack getItemInHand() {
        return itemstack;
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