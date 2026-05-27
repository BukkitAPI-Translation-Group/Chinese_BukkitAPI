package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当试炼密室中的宝库即将显示物品时触发.
 */
@ApiStatus.Experimental
public class VaultDisplayItemEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private ItemStack displayItem;

    public VaultDisplayItemEvent(@NotNull Block theBlock, @Nullable ItemStack displayItem) {
        super(theBlock);
        this.displayItem = displayItem;
    }

    /**
     * 获取将在宝库内显示的物品.
     *
     * 原文：
     * Gets the item that will be displayed inside the vault.
     *
     * @return 要显示的物品
     */
    @Nullable
    public ItemStack getDisplayItem() {
        return displayItem;
    }

    /**
     * 设置将在宝库内显示的物品.
     *
     * 原文：
     * Sets the item that will be displayed inside the vault.
     *
     * @param displayItem 要显示的物品
     */
    public void setDisplayItem(@Nullable ItemStack displayItem) {
        this.displayItem = displayItem;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
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
