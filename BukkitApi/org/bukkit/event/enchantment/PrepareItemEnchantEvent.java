package org.bukkit.event.enchantment;

import org.bukkit.block.Block;
import org.bukkit.enchantments.EnchantmentOffer;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.view.EnchantmentView;
import org.jetbrains.annotations.NotNull;

/**
 * 物品塞入附魔台的事件 - 可被多次调用。
 */
public class PrepareItemEnchantEvent extends InventoryEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Block table;
    private final ItemStack item;
    private final EnchantmentOffer[] offers;
    private final int bonus;
    private boolean cancelled;
    private final Player enchanter;

    public PrepareItemEnchantEvent(@NotNull final Player enchanter, @NotNull EnchantmentView view, @NotNull final Block table, @NotNull final ItemStack item, @NotNull final EnchantmentOffer[] offers, final int bonus) {
        super(view);
        this.enchanter = enchanter;
        this.table = table;
        this.item = item;
        this.offers = offers;
        this.bonus = bonus;
    }

    /**
     * 获取正在为物品附魔的玩家.
     * <p>
     * 原文:
     * Gets the player enchanting the item
     *
     * @return 正在为物品附魔的玩家
     */
    @NotNull
    public Player getEnchanter() {
        return enchanter;
    }

    /**
     * 获取附魔台方块.
     * <p>
     * 原文:
     * Gets the block being used to enchant the item
     *
     * @return 附魔台方块
     */
    @NotNull
    public Block getEnchantBlock() {
        return table;
    }

    /**
     * 获取准备附魔的物品(可改动).
     * <p>
     * 原文:
     * Gets the item to be enchanted (can be modified)
     *
     * @return 附魔的物品ItemStack对象
     */
    @NotNull
    public ItemStack getItem() {
        return item;
    }

    /**
	 * 获取附魔所需要的等级的列表.
	 * <p>
     * 原文:Get a list of offered experience level costs of the enchantment.
     *
     * @return 附魔所需要的等级的列表
     * @deprecated 请换用 {@link #getOffers()} 方法
     */
    @NotNull
    @Deprecated(since = "1.20.5")
    public int[] getExpLevelCostsOffered() {
        int[] levelOffers = new int[offers.length];
        for (int i = 0; i < offers.length; i++) {
            levelOffers[i] = offers[i] != null ? offers[i].getCost() : 0;
        }
        return levelOffers;
    }

    /**
     * 获取对玩家可用的的附魔选项列表. 你可以修改这些值以干预对玩家可用的附魔.
     * 如果附魔台中某个特定的格子没有附魔选项, 则这个附魔选项可能为null.
     * 附魔台中有3个附魔选项格可供编辑.
     * <p>
     * 原文:Get a list of available {@link EnchantmentOffer} for the player. You can
     * modify the values to change the available offers for the player. An offer
     * may be null, if there isn't a enchantment offer at a specific slot. There
     * are 3 slots in the enchantment table available to modify.
     *
     * @return 可用的的附魔选项列表
     */
    @NotNull
    public EnchantmentOffer[] getOffers() {
        return offers;
    }

    /**
     * 获取生效的附魔等级加成 - 对应书架的数量.
     * <p>
     * 原文:Get enchantment bonus in effect - corresponds to number of bookshelves
     *
     * @return 附魔等级加成
     */
    public int getEnchantmentBonus() {
        return bonus;
    }

    @NotNull
    @Override
    public EnchantmentView getView() {
        return (EnchantmentView) super.getView();
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
