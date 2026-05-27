package org.bukkit.event.inventory;

import org.bukkit.event.HandlerList;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当物品被放入槽位并且结果被计算时调用。
 */
public class PrepareInventoryResultEvent extends InventoryEvent {

    private static final HandlerList handlers = new HandlerList();
    private ItemStack result;

    public PrepareInventoryResultEvent(@NotNull InventoryView inventory, @Nullable ItemStack result) {
        super(inventory);
        this.result = result;
    }

    /**
     * 获取结果物品，可能为 null。
     *
     * @return 结果物品
     * <p>原文：Get result item, may be null.
     */
    @Nullable
    public ItemStack getResult() {
        return result;
    }

    /**
     * 设置结果物品，可能为 null。
     *
     * @param result 结果物品
     * <p>原文：Set result item, may be null.
     */
    public void setResult(@Nullable ItemStack result) {
        this.result = result;
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
