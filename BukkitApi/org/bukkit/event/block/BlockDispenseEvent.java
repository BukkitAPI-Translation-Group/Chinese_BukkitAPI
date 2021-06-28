package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

/**
 * 物品被方块(比如发射器,投掷器等)射出的事件.
 * <p>
 * 取消该事件, 物品就不会被射出.
 */
public class BlockDispenseEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled = false;
    private ItemStack item;
    private Vector velocity;

    public BlockDispenseEvent(@NotNull final Block block, @NotNull final ItemStack dispensed, @NotNull final Vector velocity) {
        super(block);
        this.item = dispensed;
        this.velocity = velocity;
    }

    /**
     * 获取被射出的物品.
     * <p>
     * 注意:修改返回的item对象没用, 必须用 {@link #setItem(org.bukkit.inventory.ItemStack)} 代替.
     * <p>
     * 原文：Gets the item that is being dispensed. Modifying the returned item will
     * have no effect, you must use {@link
     * #setItem(org.bukkit.inventory.ItemStack)} instead.
     *
     * @return 被射出的物品
     */
    @NotNull
    public ItemStack getItem() {
        return item.clone();
    }

    /**
     * 设置被射出的物品.
     * <p>
     * 原文：Sets the item being dispensed.
     *
     * @param item 被射出的物品
     */
    public void setItem(@NotNull ItemStack item) {
        this.item = item;
    }

    /**
     * 获取物品射出的速度、角度 (单位: 米每tick).
     * <p>
     * 注意: 修改返回的对象并不会修改速度, 必须
     * 用{@link #setVelocity(org.bukkit.util.Vector)}.
     * <p>
     * 原文：Gets the velocity.
     * <p>
     * Note: Modifying the returned Vector will not change the velocity, you
     * must use {@link #setVelocity(org.bukkit.util.Vector)} instead.
     *
     * @return 射出物品的速度的Vector(向量)
     */
    @NotNull
    public Vector getVelocity() {
        return velocity.clone();
    }

    /**
     * 设置物品射出的速度速度、角度 (单位: 米每tick).
     * <p>
     * 原文:Sets the velocity of the item being dispensed in meters per tick.
     *
     * @param vel 射出的物品的速度、角度.
     */
    public void setVelocity(@NotNull Vector vel) {
        velocity = vel;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
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