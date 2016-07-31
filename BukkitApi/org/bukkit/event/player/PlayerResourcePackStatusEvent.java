package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * 当玩家对通过 {@link Player#setResourcePack(java.lang.String)} 发起的资源包请求采取动作时触发本事件.
 */
public class PlayerResourcePackStatusEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    private final Status status;

    public PlayerResourcePackStatusEvent(final Player who, Status resourcePackStatus) {
        super(who);
        this.status = resourcePackStatus;
    }

    /**
     * 获取这个资源包的状态.
     * <p>
     * 原文:Gets the status of this pack.
     *
     * @return 当前的状态
     */
    public Status getStatus() {
        return status;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * 资源包状态
     */
    public enum Status {

        /**
         * 资源包成功地下载和应用到了客户端.
         */
        SUCCESSFULLY_LOADED,
        /**
         * 客户端拒绝接受资源包
         */
        DECLINED,
        /**
         * 客户端接受了资源包，但下载失败
         */
        FAILED_DOWNLOAD,
        /**
         * 客户端接受了资源包，并开始下载
         */
        ACCEPTED;
    }
}