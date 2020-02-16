package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 玩家等级改变事件.
 */
public class PlayerLevelChangeEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private final int oldLevel;
    private final int newLevel;

    public PlayerLevelChangeEvent(@NotNull final Player player, final int oldLevel, final int newLevel) {
        super(player);
        this.oldLevel = oldLevel;
        this.newLevel = newLevel;
    }

    /**
     * 获得此玩家的旧等级.
     * <p>
     * 原文:Gets the old level of the player
     *
     * @return 旧等级
     */
    public int getOldLevel() {
        return oldLevel;
    }

    /**
     * 获得此玩家升级/降级后的等级.
     * <p>
     * 原文:Gets the new level of the player
     *
     * @return 升级/降级后的等级
     */
    public int getNewLevel() {
        return newLevel;
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
