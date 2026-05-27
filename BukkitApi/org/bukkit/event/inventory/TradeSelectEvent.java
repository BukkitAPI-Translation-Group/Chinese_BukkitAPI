package org.bukkit.event.inventory;

import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.inventory.view.MerchantView;
import org.jetbrains.annotations.NotNull;

/**
 * 每当玩家在交易侧边栏点击新交易时调用此事件。
 * <p>
 * 此事件允许用户获取交易的索引，让他们通过 Merchant 获取 MerchantRecipe。
 */
public class TradeSelectEvent extends InventoryInteractEvent {

    private static final HandlerList handlers = new HandlerList();
    //
    private final int index;

    public TradeSelectEvent(@NotNull MerchantView transaction, int newIndex) {
        super(transaction);
        this.index = newIndex;
    }

    /**
     * 用于获取玩家点击的交易的索引。
     *
     * @return 玩家点击的交易的索引
     * <p>原文：Used to get the index of the trade the player clicked on.
     */
    public int getIndex() {
        return index;
    }

    @NotNull
    @Override
    public MerchantInventory getInventory() {
        return (MerchantInventory) super.getInventory();
    }

    /**
     * 获取涉及的 Merchant。
     *
     * @return Merchant
     * <p>原文：Get the Merchant involved.
     */
    @NotNull
    public Merchant getMerchant() {
        return getInventory().getMerchant();
    }

    @NotNull
    @Override
    public MerchantView getView() {
        return (MerchantView) super.getView();
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