package org.bukkit.event.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.entity.EntityUnleashEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 当一个实体被玩家解开拴绳时调用.
 * <p>
 *
 */
public class PlayerUnleashEntityEvent extends EntityUnleashEvent implements Cancellable {
    private final Player player;
    private boolean cancelled = false;

    public PlayerUnleashEntityEvent(@NotNull Entity entity, @NotNull Player player) {
        super(entity, UnleashReason.PLAYER_UNLEASH);
        this.player = player;
    }

    /**
     * 获得解开拴绳的玩家.
     * <p>
     * 原文:Returns the player who is unleashing the entity.
     *
     * @return 玩家
     */
    @NotNull
    public Player getPlayer() {
        return player;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
