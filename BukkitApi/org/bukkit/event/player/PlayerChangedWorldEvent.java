package org.bukkit.event.player;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家切换到另一个世界时触发此事件.
 */
public class PlayerChangedWorldEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private final World from;

    public PlayerChangedWorldEvent(@NotNull final Player player, @NotNull final World from) {
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
    @NotNull
    public World getFrom() {
        return from;
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
