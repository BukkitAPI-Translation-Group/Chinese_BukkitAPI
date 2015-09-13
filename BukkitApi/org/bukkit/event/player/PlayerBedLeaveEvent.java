package org.bukkit.event.player;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * 玩家离开床时触发此事件.
 */
public class PlayerBedLeaveEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private final Block bed;

    public PlayerBedLeaveEvent(final Player who, final Block bed) {
        super(who);
        this.bed = bed;
    }

    /**
     * 返回此事件涉及的床.
     * <p>
     * Returns the bed block involved in this event.
     *
     * @return 床
     */
    public Block getBed() {
        return bed;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}