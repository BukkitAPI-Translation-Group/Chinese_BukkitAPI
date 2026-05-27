package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 当酿造台开始酿造时触发.
 */
public class BrewingStartEvent extends InventoryBlockStartEvent {

    private static final HandlerList handlers = new HandlerList();
    private int brewingTime;

    public BrewingStartEvent(@NotNull final Block furnace, @NotNull ItemStack source, int brewingTime) {
        super(furnace, source);
        this.brewingTime = brewingTime;
    }

    /**
     * 获取此事件关联的总酿造时间.
     *
     * 原文：
     * Gets the total brew time associated with this event.
     *
     * @return 总酿造时间
     */
    public int getTotalBrewTime() {
        return brewingTime;
    }

    /**
     * 设置此事件的总酿造时间.
     *
     * 原文：
     * Sets the total brew time for this event.
     *
     * @param brewTime 新的总酿造时间
     */
    public void setTotalBrewTime(int brewTime) {
        this.brewingTime = brewTime;
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
