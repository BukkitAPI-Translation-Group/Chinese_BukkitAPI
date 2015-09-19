package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

/**
 * 代表玩家事件.
 */
public abstract class PlayerEvent extends Event {
    protected Player player;

    public PlayerEvent(final Player who) {
        player = who;
    }

    PlayerEvent(final Player who, boolean async) {
        super(async);
        player = who;

    }

    /**
     * 返回哪个玩家触发了此事件.
     * <p>
     * 原文:Returns the player involved in this event
     *
     * @return 触发此事件的玩家
     */
    public final Player getPlayer() {
        return player;
    }
}
