package org.bukkit.event.player;

import org.bukkit.entity.Player;

/**
 * 当玩家注销插件通道时触发事件.
 */
public class PlayerUnregisterChannelEvent extends PlayerChannelEvent {

    public PlayerUnregisterChannelEvent(final Player player, final String channel) {
        super(player, channel);
    }
}