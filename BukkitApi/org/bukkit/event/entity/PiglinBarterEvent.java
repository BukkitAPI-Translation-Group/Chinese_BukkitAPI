package org.bukkit.event.entity;

import java.util.List;
import org.bukkit.entity.Piglin;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 储存与猪灵以物易物交互相关的所有数据。
 *
 * 此事件可由猪灵拾取其以物易物列表上的物品触发。
 */
public class PiglinBarterEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final List<ItemStack> outcome;
    private final ItemStack input;

    public PiglinBarterEvent(@NotNull Piglin what, @NotNull ItemStack input, @NotNull List<ItemStack> outcome) {
        super(what);

        this.input = input;
        this.outcome = outcome;
    }

    @NotNull
    @Override
    public Piglin getEntity() {
        return (Piglin) super.getEntity();
    }

    /**
     * 获取以物易物的输入。
     * <p>
     * 原文：
     * Gets the input of the barter.
     *
     * @return 用于以物易物的物品
     */
    @NotNull
    public ItemStack getInput() {
        return input.clone();
    }

    /**
     * 返回表示以物易物结果的可变列表。
     * <p>
     * 原文：
     * Returns a mutable list representing the outcome of the barter.
     *
     * @return 玩家将收到的物品的可变列表
     */
    @NotNull
    public List<ItemStack> getOutcome() {
        return outcome;
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
