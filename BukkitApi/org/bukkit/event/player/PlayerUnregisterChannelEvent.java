package org.bukkit.event.player;

import org.bukkit.entity.Player;

/**
 * 玩家通过bukkit指令注销插件时触发事件.
 */
public class PlayerUnregisterChannelEvent extends PlayerChannelEvent {

    public PlayerUnregisterChannelEvent(final Player player, final String channel) {
        super(player, channel);
    }
}