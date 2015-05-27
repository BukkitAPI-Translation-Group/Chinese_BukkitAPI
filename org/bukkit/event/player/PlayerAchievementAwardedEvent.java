package org.bukkit.event.player;

import org.bukkit.Achievement;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当一个玩家获得一个成就时激发.
 */
public class PlayerAchievementAwardedEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Achievement achievement;
    private boolean isCancelled = false;

    public PlayerAchievementAwardedEvent(Player player, Achievement achievement) {
        super(player);
        this.achievement = achievement;
    }

    /**
     * 获得被颁发的成就.
     *
     * @return 颁发的成就
     */
    public Achievement getAchievement() {
        return achievement;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
