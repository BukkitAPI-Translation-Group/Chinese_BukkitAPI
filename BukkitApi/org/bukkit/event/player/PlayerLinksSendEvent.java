package org.bukkit.event.player;

import org.bukkit.ServerLinks;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当链接列表发送给玩家时触发.
 */
public class PlayerLinksSendEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    private final ServerLinks links;

    public PlayerLinksSendEvent(@NotNull final Player player, @NotNull final ServerLinks links) {
        super(player);
        this.links = links;
    }

    /**
     * 获取要发送的链接以进行修改.
     * <p>
     * 原文：
     * Gets the links to be sent, for modification.
     *
     * @return 链接
     */
    @NotNull
    public ServerLinks getLinks() {
        return links;
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
