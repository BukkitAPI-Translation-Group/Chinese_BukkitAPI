package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 玩家进入服务器事件.
 */
public class PlayerJoinEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private String joinMessage;

    public PlayerJoinEvent(@NotNull final Player playerJoined, @Nullable final String joinMessage) {
        super(playerJoined);
        this.joinMessage = joinMessage;
    }

    /**
     * 获取玩家加入游戏后发送给全体玩家的信息.
     * <p>
     * 原文:Gets the join message to send to all online players
     *
     * @return 加入信息,可以为null
     */
    @Nullable
    public String getJoinMessage() {
        return joinMessage;
    }

    /**
     * 设置玩家加入游戏后发送给全体玩家的信息.
     * <p>
     * 原文:Sets the join message to send to all online players
     *
     * @param joinMessage 加入信息, 若为null则不会发送加入信息
     */
    public void setJoinMessage(@Nullable String joinMessage) {
        this.joinMessage = joinMessage;
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
