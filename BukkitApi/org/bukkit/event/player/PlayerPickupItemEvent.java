package org.bukkit.event.player;

import org.bukkit.Warning;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityPickupItemEvent;

/**
 * 玩家捡起掉落物品事件.
 * @deprecated {@link EntityPickupItemEvent}
 */
@Deprecated
@Warning(false)
public class PlayerPickupItemEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Item item;
    private boolean cancel = false;
    private final int remaining;

    public PlayerPickupItemEvent(final Player player, final Item item, final int remaining) {
        super(player);
        this.item = item;
        this.remaining = remaining;
    }

    /**
     * 获得此玩家在地面捡起的物品.
     * <p>
     * 原文:Gets the Item picked up by the player.
     *
     * @return 此掉落物品
     */
    public Item getItem() {
        return item;
    }

    /**
     * 获得地面剩余掉落物品数量(如果有的话).
     * <p>
     * 原文:Gets the amount remaining on the ground, if any
     *
     * @return 剩余掉落物品数量
     */
    public int getRemaining() {
        return remaining;
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