package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * 玩家离开服务器事件.
 */
public class PlayerQuitEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private String quitMessage;

    public PlayerQuitEvent(final Player who, final String quitMessage) {
        super(who);
        this.quitMessage = quitMessage;
    }

    /**
     * 获取某玩家离开游戏后，发送给全体玩家的离开消息.
     * <p>
     * 原文:Gets the quit message to send to all online players
     *
     * @return string 玩家离开消息
     */
    public String getQuitMessage() {
        return quitMessage;
    }

    /**
     * 设置某玩家离开游戏后，发送给全体玩家的离开消息.
     * <p>
     * 原文:Sets the quit message to send to all online players
     *
     * @param quitMessage 玩家离开消息
     */
    public void setQuitMessage(String quitMessage) {
        this.quitMessage = quitMessage;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}