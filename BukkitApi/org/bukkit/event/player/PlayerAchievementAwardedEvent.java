package org.bukkit.event.player;

import org.bukkit.Achievement;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当玩家获得某个成就时触发此事件.
 * @deprecated 未来版本的Minecraft将不会有成就(取而代之的是进度).
 */
@Deprecated
public class PlayerAchievementAwardedEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Achievement achievement;
    private boolean isCancelled = false;

    public PlayerAchievementAwardedEvent(Player player, Achievement achievement) {
        super(player);
        this.achievement = achievement;
    }

    /**
     * 获得次玩家被授予的成就.
     * <p>
     * 原文:Gets the Achievement being awarded.
     *
     * @return 成就
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
