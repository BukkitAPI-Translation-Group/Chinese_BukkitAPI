package org.bukkit.event.entity;

import org.bukkit.entity.AbstractVillager;
import org.bukkit.entity.Villager;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.MerchantRecipe;
import org.jetbrains.annotations.NotNull;

/**
 * 当 {@link Villager} 即将补充其交易之一时调用。
 * <p>
 * 如果此事件通过，村民将把受影响的 {@link #getRecipe() MerchantRecipe} 的 {@link MerchantRecipe#getUses() uses} 重置为 <code>0</code>。
 */
public class VillagerReplenishTradeEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    //
    private MerchantRecipe recipe;

    public VillagerReplenishTradeEvent(@NotNull AbstractVillager what, @NotNull MerchantRecipe recipe) {
        super(what);
        this.recipe = recipe;
    }

    /**
     * 获取要补充的配方。
     * <p>
     * 原文：
     * Get the recipe to replenish.
     *
     * @return 补充的配方
     */
    @NotNull
    public MerchantRecipe getRecipe() {
        return recipe;
    }

    /**
     * 设置要补充的配方。
     * <p>
     * 原文：
     * Set the recipe to replenish.
     *
     * @param recipe 补充的配方
     */
    public void setRecipe(@NotNull MerchantRecipe recipe) {
        this.recipe = recipe;
    }

    /**
     * 获取添加的额外使用次数。
     * <p>
     * 原文：
     * Get the bonus uses added.
     *
     * @return 添加的额外使用次数
     * @deprecated MC 1.14 改变了村民补充交易的方式。使用 {@link MerchantRecipe#getUses()}。
     */
    @Deprecated(since = "1.18.1")
    public int getBonus() {
        return recipe.getUses();
    }

    /**
     * 设置添加的额外使用次数。
     * <p>
     * 原文：
     * Set the bonus uses added.
     *
     * @param bonus 添加的额外使用次数
     * @deprecated MC 1.14 改变了村民补充交易的方式。这不再有效。
     */
    @Deprecated(since = "1.18.1")
    public void setBonus(int bonus) {
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
    public AbstractVillager getEntity() {
        return (AbstractVillager) super.getEntity();
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