package org.bukkit.event.player;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家游戏模式发生变化时调用此事件.
 */
public class PlayerGameModeChangeEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final GameMode newGameMode;

    public PlayerGameModeChangeEvent(@NotNull final Player player, @NotNull final GameMode newGameMode) {
        super(player);
        this.newGameMode = newGameMode;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    /**
     * 获取玩家切换后的游戏模式.
     * <p>
     * 原文:Gets the GameMode the player is switched to.
     *
     * @return 新游戏模式
     */
    @NotNull
    public GameMode getNewGameMode() {
        return newGameMode;
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
