package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 玩家注册通信通道之后立即触发此事件.
 */
public class PlayerRegisterChannelEvent extends PlayerChannelEvent {

    public PlayerRegisterChannelEvent(@NotNull final Player player, @NotNull final String channel) {
        super(player, channel);
    }
}
