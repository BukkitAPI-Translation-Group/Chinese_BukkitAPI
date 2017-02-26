package org.bukkit.event.enchantment;

import org.bukkit.block.Block;
import org.bukkit.enchantments.EnchantmentOffer;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

/**
 * 物品塞入附魔台的事件 - 可以同时调用。
 */
public class PrepareItemEnchantEvent extends InventoryEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Block table;
    private final ItemStack item;
    private final EnchantmentOffer[] offers;
    private final int bonus;
    private boolean cancelled;
    private final Player enchanter;

    public PrepareItemEnchantEvent(final Player enchanter, InventoryView view, final Block table, final ItemStack item, final EnchantmentOffer[] offers, final int bonus) {
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
    public int[] getExpLevelCostsOffered() {
        int[] levelOffers = new int[offers.length];
        for (int i = 0; i < offers.length; i++) {
            levelOffers[i] = offers[i] != null ? offers[i].getCost() : 0;
        }
        return levelOffers;
    }

    /**
     * Get a list of available {@link EnchantmentOffer} for the player. You can
     * modify the values to change the available offers for the player. An offer
     * may be null, if there isn't a enchantment offer at a specific slot. There
     * are 3 slots in the enchantment table available to modify.
     *
     * @return list of available enchantment offers
     */
    public EnchantmentOffer[] getOffers() {
        return offers;
    }

    /**
     * Get enchantment bonus in effect - corresponds to number of bookshelves
     *
     * @return enchantment bonus
     */
    public int getEnchantmentBonus() {
        return bonus;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
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
