package org.bukkit.event.inventory;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.inventory.BrewerInventory;

/**
 * 当酿造完成时触发这个事件. 
 */
public class BrewEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private BrewerInventory contents;
    private boolean cancelled;

    public BrewEvent(Block brewer, BrewerInventory contents) {
        super(brewer);
        this.contents = contents;
    }

    /**
     * 获取此事件中的酿造台的物品栏. 
     * 
     * 原文：Gets the contents of the Brewing Stand.
     *
     * @return 酿造台的物品栏
     */
    public BrewerInventory getContents() {
        return contents;
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
