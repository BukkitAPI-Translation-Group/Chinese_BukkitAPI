package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家注册/注销一个新的插件通道时触发本事件
 */
public abstract class PlayerChannelEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private final String channel;

    public PlayerChannelEvent(@NotNull final Player player, @NotNull final String channel) {
        super(player);
        this.channel = channel;
    }

    @NotNull
    public final String getChannel() {
        return channel;
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