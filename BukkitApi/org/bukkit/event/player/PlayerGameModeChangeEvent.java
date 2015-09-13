package org.bukkit.event.player;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当玩家游戏模式发生变化则调用此事件.
 */
public class PlayerGameModeChangeEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final GameMode newGameMode;

    public PlayerGameModeChangeEvent(final Player player, final GameMode newGameMode) {
        super(player);
        this.newGameMode = newGameMode;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    /**
     * 获取玩家目前的游戏模式.
     * <p>
     * 原文:Gets the GameMode the player is switched to.
     *
     * @return  玩家目前的游戏模式
     */
    public GameMode getNewGameMode() {
        return newGameMode;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
