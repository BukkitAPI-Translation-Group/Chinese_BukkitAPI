package org.bukkit.event.enchantment;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.Validate;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 成功附魔物品的事件 (在附魔台里面附魔的)
 */
public class EnchantItemEvent extends InventoryEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Block table;
    private final ItemStack item;
    private int level;
    private boolean cancelled;
    private final Map<Enchantment, Integer> enchants;
    private final Player enchanter;
    private final int button;

    public EnchantItemEvent(@NotNull final Player enchanter, @NotNull final InventoryView view, @NotNull final Block table, @NotNull final ItemStack item, final int level, @NotNull final Map<Enchantment, Integer> enchants, final int i) {
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
    @NotNull
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
    @NotNull
    public Block getEnchantBlock() {
        return table;
    }

    /**
     * 获取被附魔的物品(可改动).
     * <p>
     * 原文:
     * Gets the item to be enchanted (can be modified)
     *
     * @return 被附魔的物品
     */
    @NotNull
    public ItemStack getItem() {
        return item;
    }

    /**
     * 获取花费的经验等级(最低), 这个等级以数字形式显示在附魔台界面中附魔选项的右侧.
     * <p>
     * 原文:
     * Gets the cost (minimum level) which is displayed as a number on the right
     * hand side of the enchantment offer.
     *
     * @return 花费的经验等级
     */
    public int getExpLevelCost() {
        return level;
    }

    /**
     * 设置花费的经验等级(最低), 这个等级以数字形式显示在附魔台界面中附魔选项的右侧.
     * <p>
     * 原文:
     * Sets the cost (minimum level) which is displayed as a number on the right
     * hand side of the enchantment offer.
     *
     * @param level - 花费的经验等级
     */
    public void setExpLevelCost(int level) {
        Validate.isTrue(level > 0, "The cost must be greater than 0!");

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
    @NotNull
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