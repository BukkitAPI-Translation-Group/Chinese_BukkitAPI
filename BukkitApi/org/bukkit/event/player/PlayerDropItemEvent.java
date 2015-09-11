package org.bukkit.event.player;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 玩家丢出物品事件.
 */
public class PlayerDropItemEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Item drop;
    private boolean cancel = false;

    public PlayerDropItemEvent(final Player player, final Item drop) {
        super(player);
        this.drop = drop;
    }

    /**
     * 获得此玩家丢出的物品.
     * <p>
     * 原文:Gets the ItemDrop created by the player
     *
     * @return 玩家丢出的物品
     */
    public Item getItemDrop() {
        return drop;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
