package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * 不会翻译怎么办
 * 机翻结果:
 * 这个事件会在一个玩家注册或者反注册一个新的插件渠道时被激发
 * This event is called after a player registers or unregisters a new plugin
 * channel.
 */
public abstract class PlayerChannelEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private final String channel;

    public PlayerChannelEvent(final Player player, final String channel) {
        super(player);
        this.channel = channel;
    }

    public final String getChannel() {
        return channel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
