package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家注销插件通道时触发事件.
 */
public class PlayerUnregisterChannelEvent extends PlayerChannelEvent {

    public PlayerUnregisterChannelEvent(@NotNull final Player player, @NotNull final String channel) {
        super(player, channel);
    }
}
