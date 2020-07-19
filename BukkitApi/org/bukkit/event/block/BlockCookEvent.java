package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 当物品堆在方块内成功烹饪时触发本事件 (原版中这个方块一般是营火).
 * <p>
 * 译注:在熔炉内的烧炼不属于烹饪范畴, 因此不会触发本事件. 如果您想监听熔炉相关事件, 可以参考 inventory 事件包中的相关事件.
 */
public class BlockCookEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final ItemStack source;
    private ItemStack result;
    private boolean cancelled;

    public BlockCookEvent(@NotNull final Block block, @NotNull final ItemStack source, @NotNull final ItemStack result) {
        super(block);
        this.source = source;
        this.result = result;
        this.cancelled = false;
    }

    /**
     * 获取被烹饪的物品堆 (比如生的食物).
     * <p>
     * 原文:Gets the smelted ItemStack for this event
     *
     * @return 被烹饪的原物品堆
     */
    @NotNull
    public ItemStack getSource() {
        return source;
    }

    /**
     * 获取烹饪后得到的物品堆 (比如熟食).
     * <p>
     * 原文:Gets the resultant ItemStack for this event
     *
     * @return 烹饪后得到的物品堆
     */
    @NotNull
    public ItemStack getResult() {
        return result;
    }

    /**
     * 设置烹饪后得到的物品堆.
     * <p>
     * 原文:Sets the resultant ItemStack for this event
     *
     * @param result 烹饪后得到的物品堆
     */
    public void setResult(@NotNull ItemStack result) {
        this.result = result;
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
