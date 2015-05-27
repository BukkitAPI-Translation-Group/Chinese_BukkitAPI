package org.bukkit.event.player;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * 当一个玩家正在离开床的时候被激活.
 */
public class PlayerBedLeaveEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private final Block bed;

    public PlayerBedLeaveEvent(final Player who, final Block bed) {
        super(who);
        this.bed = bed;
    }

    /**
     * 获得这次床的方块.
     *
     * @return 床方块
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
