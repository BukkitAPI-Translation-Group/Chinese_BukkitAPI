package org.bukkit.event.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.entity.EntityUnleashEvent;

/**
 * 当一个实体由于玩家的动作释放时调用.
 * <p>
 * 译注:译者不知道“unleash”在此处的含义.
 */
public class PlayerUnleashEntityEvent extends EntityUnleashEvent implements Cancellable {
    private final Player player;
    private boolean cancelled = false;

    public PlayerUnleashEntityEvent(Entity entity, Player player) {
        super(entity, UnleashReason.PLAYER_UNLEASH);
        this.player = player;
    }

    /**
     * 获得释放实体的玩家.
     * <p>
     * 原文:Returns the player who is unleashing the entity.
     *
     * @return 玩家
     */
    public Player getPlayer() {
        return player;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
