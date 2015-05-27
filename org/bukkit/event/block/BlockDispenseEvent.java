package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

/**
 * 物品被方块射出的事件.
 * <p>
 * 取消该事件, 物品就不会被射出.
 * 
 */
public class BlockDispenseEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled = false;
    private ItemStack item;
    private Vector velocity;

    public BlockDispenseEvent(final Block block, final ItemStack dispensed, final Vector velocity) {
        super(block);
        this.item = dispensed;
        this.velocity = velocity;
    }

    /**
     * 获取被射出的物品的ItemStack. 修改返回的项目
     * 没用, 必须用另一个 {@link
     * #setItem(org.bukkit.inventory.ItemStack)} 代替.
     *
     * @return 被射出的物品的ItemStack
     */
    public ItemStack getItem() {
        return item.clone();
    }

    /**
     * 设置被射出的物品
     *
     * @param item 被射出的物品的ItemStack
     */
    public void setItem(ItemStack item) {
        this.item = item;
    }

    /**
     * 获取射出的速度.
     * <p>
     * 注意: 修改返回的项目并不会修改速度, 必须
     * 用另一个{@link #setVelocity(org.bukkit.util.Vector)} 代替.
     *
     * @return 射出物品的速度的Vector(向量)
     */
    public Vector getVelocity() {
        return velocity.clone();
    }

    /**
     * 设置射出的速度.
     *
     * @param vel 射出的物品的速度.
     */
    public void setVelocity(Vector vel) {
        velocity = vel;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
