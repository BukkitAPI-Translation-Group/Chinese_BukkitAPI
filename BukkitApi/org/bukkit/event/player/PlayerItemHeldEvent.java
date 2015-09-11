package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 玩家手持某物品事件.
 */
public class PlayerItemHeldEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final int previous;
    private final int current;

    public PlayerItemHeldEvent(final Player player, final int previous, final int current) {
        super(player);
        this.previous = previous;
        this.current = current;
    }

    /**
     * 获得玩家上一次手持物品的物品槽位置.
     * <p>
     * 原文:Gets the previous held slot index
     *
     * @return 上次手持物品的物品槽的位置
     */
    public int getPreviousSlot() {
        return previous;
    }

    /**
     * 获得玩家此次手持物品的物品槽位置.
     * <p>
     * 原文:Gets the new held slot index
     *
     * @return 此次物品的物品槽位置
     */
    public int getNewSlot() {
        return current;
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
