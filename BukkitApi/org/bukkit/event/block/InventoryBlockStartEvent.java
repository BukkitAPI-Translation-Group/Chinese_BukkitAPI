package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.FurnaceStartSmeltEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 用于以下情况：
 * <ul>
 * <li>熔炉开始熔炼 {@link FurnaceStartSmeltEvent}</li>
 * <li>酿造台开始酿造 {@link BrewingStartEvent}</li>
 * <li>营火开始烹饪 {@link CampfireStartEvent}</li>
 * </ul>
 */
public class InventoryBlockStartEvent extends BlockEvent {

    private static final HandlerList handlers = new HandlerList();
    private final ItemStack source;

    public InventoryBlockStartEvent(@NotNull final Block block, @NotNull ItemStack source) {
        super(block);
        this.source = source;
    }

    /**
     * 获取此事件的源 ItemStack.
     *
     * 原文：
     * Gets the source ItemStack for this event.
     *
     * @return 源 ItemStack
     */
    @NotNull
    public ItemStack getSource() {
        return source;
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
