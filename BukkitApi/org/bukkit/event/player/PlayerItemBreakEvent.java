package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 * 某玩家工具耐久消耗完毕时触发(比如铲子，打火石，铁制工具).
 * <p>
 * 当物品耐久值为0时，将触发此事件.事件结束后，物品耐久值将复位至0.
 */
public class PlayerItemBreakEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private final ItemStack brokenItem;

    public PlayerItemBreakEvent(final Player player, final ItemStack brokenItem) {
        super(player);
        this.brokenItem = brokenItem;
    }

    /**
     * 获得因耐久值不足将要被销毁的物品.
     * <p>
     * 原文:Gets the item that broke
     *
     * @return 这个物品
     */
    public ItemStack getBrokenItem() {
        return brokenItem;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
