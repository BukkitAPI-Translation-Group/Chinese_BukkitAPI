package org.bukkit.event.player;

import org.bukkit.entity.Player;

/**
 * 玩家注册之后立即开启一个与玩家通信的通道.
 */
public class PlayerRegisterChannelEvent extends PlayerChannelEvent {

    public PlayerRegisterChannelEvent(final Player player, final String channel) {
        super(player, channel);
    }
}
