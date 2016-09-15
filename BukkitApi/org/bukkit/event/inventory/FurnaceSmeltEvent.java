package org.bukkit.event.inventory;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.inventory.ItemStack;

/**
 * 当一个物品被熔炼完毕时触发这个事件. 
 */
public class FurnaceSmeltEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final ItemStack          source;
    private ItemStack                result;
    private boolean                  cancelled;

    public FurnaceSmeltEvent(final Block furnace, final ItemStack source, final ItemStack result) {
        super(furnace);
        this.source = source;
        this.result = result;
        this.cancelled = false;
    }

    /**
     * 获取被熔炼的物品. 
     * <p>
     * 原文：Gets the smelted ItemStack for this event
     *
     * @return 被熔炼的物品
     */
    public ItemStack getSource() {
        return source;
    }

    /**
     * 获取熔炼产物. 
     * <p>
     * 原文：Gets the resultant ItemStack for this event
     *
     * @return 熔炼产物
     */
    public ItemStack getResult() {
        return result;
    }

    /**
     * 设置熔炼产物. 
     * <p>
     * 原文：Sets the resultant ItemStack for this event
     *
     * @param result 熔炼产物
     */
    public void setResult(ItemStack result) {
        this.result = result;
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
