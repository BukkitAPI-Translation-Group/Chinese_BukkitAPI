package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * 玩家经验变化事件.
 */
public class PlayerLevelChangeEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private final int oldLevel;
    private final int newLevel;

    public PlayerLevelChangeEvent(final Player player, final int oldLevel, final int newLevel) {
         super(player);
         this.oldLevel = oldLevel;
         this.newLevel = newLevel;
    }

    /**
     * 获得此玩家之前的经验值. <t>
     * 原文:Gets the old level of the player
     *
     * @return 之前的经验值
     */
    public int getOldLevel() {
        return oldLevel;
    }

    /**
     * 获得此玩家目前的经验值. <t>
     * 原文:Gets the new level of the player
     *
     * @return 目前的经验值
     */
    public int getNewLevel() {
        return newLevel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
