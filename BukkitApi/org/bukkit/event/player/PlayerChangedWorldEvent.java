package org.bukkit.event.player;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * 当玩家切换到另一个世界时触发此事件.
 */
public class PlayerChangedWorldEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private final World from;

    public PlayerChangedWorldEvent(final Player player, final World from) {
        super(player);
        this.from = from;
    }

    /**
     * 获得玩家切换到目标世界之前所在的世界.
     * <p>
     * 原文:Gets the world the player is switching from.
     *
     * @return 玩家切换到目标世界之前所在的世界
     */
    public World getFrom() {
        return from;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
