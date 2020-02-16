package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 玩家用快捷键互换主手和副手的物品时触发本事件.
 */
public class PlayerSwapHandItemsEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    //
    private ItemStack mainHandItem;
    private ItemStack offHandItem;
    private boolean cancelled;

    public PlayerSwapHandItemsEvent(@NotNull Player player, @NotNull ItemStack mainHandItem, @NotNull ItemStack offHandItem) {
        super(player);

        this.mainHandItem = mainHandItem;
        this.offHandItem = offHandItem;
    }

    /**
     * 获取切换到主手的物品.
     * <p>
     * 原文:Gets the item switched to the main hand.
     *
     * @return 主手里的物品
     */
    @Nullable
    public ItemStack getMainHandItem() {
        return mainHandItem;
    }

    /**
     * 设置主手里的物品.
     * <p>
     * 原文:Sets the item in the main hand.
     *
     * @param mainHandItem 主手里的物品
     */
    public void setMainHandItem(@Nullable ItemStack mainHandItem) {
        this.mainHandItem = mainHandItem;
    }

    /**
     * 获取切换到副手的物品.
     * <p>
     * 原文:Gets the item switched to the off hand.
     *
     * @return 副手里的物品
     */
    @Nullable
    public ItemStack getOffHandItem() {
        return offHandItem;
    }

    /**
     * 设置副手里的物品.
     * <p>
     * 原文:Sets the item in the off hand.
     *
     * @param offHandItem 副手里的物品
     */
    public void setOffHandItem(@Nullable ItemStack offHandItem) {
        this.offHandItem = offHandItem;
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
