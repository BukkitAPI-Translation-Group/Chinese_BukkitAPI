package org.bukkit.event.enchantment;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

/**
 * 成功附魔物品的事件 (在附魔台里面附魔的)
 */
public class EnchantItemEvent extends InventoryEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Block table;
    private final ItemStack item;
    private int level;
    private boolean cancelled;
    private final Map<Enchantment,Integer> enchants;
    private final Player enchanter;
    private int button;

    public EnchantItemEvent(final Player enchanter, final InventoryView view, final Block table, final ItemStack item, final int level, final Map<Enchantment, Integer> enchants, final int i) {
        super(view);
        this.enchanter = enchanter;
        this.table = table;
        this.item = item;
        this.level = level;
        this.enchants = new HashMap<Enchantment, Integer>(enchants);
        this.cancelled = false;
        this.button = i;
    }

    /**
     * 获取附魔这个物品的玩家。
     * <p>
     * 原文:
     * Gets the player enchanting the item
     *
     * @return 附魔这个物品的玩家
     */
    public Player getEnchanter() {
        return enchanter;
    }

    /**
     * 获取附魔这个物品的方块。
     * <p>
     * 原文:
     * Gets the block being used to enchant the item
     *
     * @return 附魔这个物品的方块
     */
    public Block getEnchantBlock() {
        return table;
    }

    /**
     * 获取被附魔的物品(可自定义)。
     * <p>
     * 原文:
     * Gets the item to be enchanted (can be modified)
     *
     * @return 被附魔的物品
     */
    public ItemStack getItem() {
        return item;
    }

    /**
     * 获取花费的附魔等级。
     * <p>
     * 原文:
     * Get cost in exp levels of the enchantment
     *
     * @return 花费的附魔等级
     */
    public int getExpLevelCost() {
        return level;
    }

    /**
     * 设置花费的附魔等级。
     * <p>
     * 原文:
     * Set cost in exp levels of the enchantment
     *
     * @param level - 花费的附魔等级
     */
    public void setExpLevelCost(int level) {
        this.level = level;
    }

    /**
     * 获取被加到物品中的附魔的Map (等级, 附魔种类)（若要修改请直接修改Map） . 注意: 不能被添加
     * 到物品中的附魔会被忽略哦。
     * <p>
     * 原文:
     * Get map of enchantment (levels, keyed by type) to be added to item - 
     * (modify map returned to change values). Note: Any enchantments not - 
     * allowed for the item will be ignored
     *
     * @return 被加到物品中的附魔的Map (等级, 附魔种类)
     */
    public Map<Enchantment, Integer> getEnchantsToAdd() {
        return enchants;
    }

    /**
     * 获取玩家点击的附魔的按钮。
     * <p>
     * 原文:
     * Which button was pressed to initiate the enchanting.
     *
     * @return 按钮的序号 (0, 1, 2).
     */
    public int whichButton() {
        return button;
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