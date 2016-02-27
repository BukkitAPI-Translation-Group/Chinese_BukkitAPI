package org.bukkit.event.enchantment;

import org.bukkit.block.Block;
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
    private final int[] levelsOffered;
    private final int bonus;
    private boolean cancelled;
    private final Player enchanter;

    public PrepareItemEnchantEvent(final Player enchanter, InventoryView view, final Block table, final ItemStack item, final int[] levelsOffered, final int bonus) {
        super(view);
        this.enchanter = enchanter;
        this.table = table;
        this.item = item;
        this.levelsOffered = levelsOffered;
        this.bonus = bonus;
        this.cancelled = false;
    }

    /**
     * 获取附魔的玩家。
     * <p>
     * 原文:
     * Gets the player enchanting the item
     *
     * @return 附魔的玩家
     */
    public Player getEnchanter() {
        return enchanter;
    }

    /**
     * 获取用来附魔的方块。
     * <p>
     * 原文:
     * Gets the block being used to enchant the item
     *
     * @return 用来附魔的方块
     */
    public Block getEnchantBlock() {
        return table;
    }

    /**
     * 获取附魔的物品(可改动)。
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
     * 获取附魔需要的等级列表（更改返回值即可改变需要的等级）。
     * <p>
     * 原文:
     * Get list of offered exp level costs of the enchantment (modify values
     * to change offer)
     *
     * @return 获取附魔需要的等级列表
     */
    public int[] getExpLevelCostsOffered() {
        return levelsOffered;
    }

    /**
     * 获取附魔的附加效果。
     * <p>
     * 原文:
     * Get enchantment bonus in effect - corresponds to number of bookshelves
     *
     * @return 附魔的附加效果
     */
    public int getEnchantmentBonus() {
        return bonus;
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