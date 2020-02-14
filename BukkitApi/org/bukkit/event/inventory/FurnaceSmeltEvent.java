package org.bukkit.event.inventory;

import org.bukkit.event.block.BlockCookEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 当一个物品被熔炼完毕时触发这个事件. 
 */
public class FurnaceSmeltEvent extends BlockCookEvent {

    public FurnaceSmeltEvent(@NotNull final Block furnace, @NotNull final ItemStack source, @NotNull final ItemStack result) {
        super(furnace, source, result);
    }
}
