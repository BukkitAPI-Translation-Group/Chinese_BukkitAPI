package org.bukkit.event.inventory;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.inventory.ItemStack;

/**
 * 当一个物品作为燃料被燃烧的时候触发这个事件. 
 */
public class FurnaceBurnEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final ItemStack fuel;
    private int burnTime;
    private boolean cancelled;
    private boolean burning;

    public FurnaceBurnEvent(final Block furnace, final ItemStack fuel, final int burnTime) {
        super(furnace);
        this.fuel = fuel;
        this.burnTime = burnTime;
        this.cancelled = false;
        this.burning = true;
    }

    /**
     * 获取这个事件中的燃料. 
     * <p>
     * 原文：Gets the fuel ItemStack for this event
     *
     * @return 被燃烧的燃料
     */
    public ItemStack getFuel() {
        return fuel;
    }

    /**
     * 获取此燃料的燃烧时间. 
     * <p>
     * 原文：Gets the burn time for this fuel
     *
     * @return 此燃料的燃烧时间
     */
    public int getBurnTime() {
        return burnTime;
    }

    /**
     * 设置此燃料的燃烧时间. 
     * <p>
     * 原文：Sets the burn time for this fuel
     *
     * @param burnTime 此燃料的燃烧时间
     */
    public void setBurnTime(int burnTime) {
        this.burnTime = burnTime;
    }

    /**
     * 获取熔炉中的燃料是否正在燃烧. 
     * <p>
     * 原文：Gets whether the furnace's fuel is burning or not.
     *
     * @return 熔炉中的燃料是否正在燃烧
     */
    public boolean isBurning() {
        return this.burning;
    }

    /**
     * 设置熔炉中的燃料是否正在燃烧. 
     * <p>
     * 原文：Sets whether the furnace's fuel is burning or not.
     *
     * @param burning 熔炉中的燃料是否正在燃烧
     */
    public void setBurning(boolean burning) {
        this.burning = burning;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
