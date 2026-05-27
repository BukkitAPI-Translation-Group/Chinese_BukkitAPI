package org.bukkit.event.inventory;

import com.google.common.base.Preconditions;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 当某个实体或方块（例如漏斗）尝试将物品直接从一个物品栏移动到另一个物品栏时调用。
 * <p>
 * 当此事件被调用时，发起者可能已经从源物品栏中移除了该物品，并准备将其移动到目标物品栏中。
 * <p>
 * 如果此事件被取消，物品将被返回到源物品栏（如果需要）。
 * <p>
 * 如果此事件未被取消，发起者将尝试将 ItemStack 放入目标物品栏。如果这不可能且 ItemStack 未被修改，源物品栏槽位将恢复到之前的状态。否则，任何额外的物品将被丢弃。
 */
public class InventoryMoveItemEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Inventory sourceInventory;
    private final Inventory destinationInventory;
    private ItemStack itemStack;
    private final boolean didSourceInitiate;

    public InventoryMoveItemEvent(@NotNull final Inventory sourceInventory, @NotNull final ItemStack itemStack, @NotNull final Inventory destinationInventory, final boolean didSourceInitiate) {
        Preconditions.checkArgument(itemStack != null, "ItemStack cannot be null");
        this.sourceInventory = sourceInventory;
        this.itemStack = itemStack;
        this.destinationInventory = destinationInventory;
        this.didSourceInitiate = didSourceInitiate;
    }

    /**
     * 获取 ItemStack 被取出的物品栏。
     *
     * @return ItemStack 被取出的物品栏
     * <p>原文：Gets the Inventory that the ItemStack is being taken from
     */
    @NotNull
    public Inventory getSource() {
        return sourceInventory;
    }

    /**
     * 获取正在移动的 ItemStack；如果被修改，原始物品将不会从源物品栏中移除。
     *
     * @return ItemStack
     * <p>原文：Gets the ItemStack being moved; if modified, the original item will not
     * be removed from the source inventory.
     */
    @NotNull
    public ItemStack getItem() {
        return itemStack.clone();
    }

    /**
     * 设置正在移动的 ItemStack；如果这与原始 ItemStack 不同，原始物品将不会从源物品栏中移除。
     *
     * @param itemStack ItemStack
     * <p>原文：Sets the ItemStack being moved; if this is different from the original
     * ItemStack, the original item will not be removed from the source
     * inventory.
     */
    public void setItem(@NotNull ItemStack itemStack) {
        Preconditions.checkArgument(itemStack != null, "ItemStack cannot be null.  Cancel the event if you want nothing to be transferred.");
        this.itemStack = itemStack.clone();
    }

    /**
     * 获取 ItemStack 被放入的物品栏。
     *
     * @return ItemStack 被放入的物品栏
     * <p>原文：Gets the Inventory that the ItemStack is being put into
     */
    @NotNull
    public Inventory getDestination() {
        return destinationInventory;
    }

    /**
     * 获取发起传输的物品栏。这将始终是目标或源物品栏。
     *
     * @return 发起传输的物品栏
     * <p>原文：Gets the Inventory that initiated the transfer. This will always be
     * either the destination or source Inventory.
     */
    @NotNull
    public Inventory getInitiator() {
        return didSourceInitiate ? sourceInventory : destinationInventory;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
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
