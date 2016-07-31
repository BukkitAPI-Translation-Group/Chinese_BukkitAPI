package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

/**
 * 代表与玩家相关的背包事件;注意本事件实际上什么也不做
 *
 * @deprecated 请使用{@link InventoryClickEvent} 或 {@link InventoryOpenEvent}，或者使用 {@link org.bukkit.event.inventory} 里的其他背包事件.
 */
@Deprecated
public class PlayerInventoryEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    protected Inventory inventory;

    public PlayerInventoryEvent(final Player player, final Inventory inventory) {
        super(player);
        this.inventory = inventory;
    }

    /**
     * 获取与此事件有关的背包.
     * <p>
     * 原文:Gets the Inventory involved in this event
     *
     * @return Inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}