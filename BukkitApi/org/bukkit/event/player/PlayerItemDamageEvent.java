package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家使用的物品因使用而受到耐久度损伤时触发.
 */
public class PlayerItemDamageEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final ItemStack item;
    private int damage;
    private boolean cancelled = false;

    public PlayerItemDamageEvent(@NotNull Player player, @NotNull ItemStack what, int damage) {
        super(player);
        this.item = what;
        this.damage = damage;
    }

    /**
     * 获取正在受损的物品.
     * <p>
     * 原文：
     * Gets the item being damaged.
     *
     * @return 物品
     */
    @NotNull
    public ItemStack getItem() {
        return item;
    }

    /**
     * 获取此物品将承受的耐久度损伤量.
     * <p>
     * 原文：
     * Gets the amount of durability damage this item will be taking.
     *
     * @return 耐久度变化
     */
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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
