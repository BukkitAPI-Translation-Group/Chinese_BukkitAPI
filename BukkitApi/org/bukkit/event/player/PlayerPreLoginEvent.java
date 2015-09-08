package org.bukkit.event.player;

import java.net.InetAddress;
import java.util.UUID;

import org.bukkit.Warning;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * 玩家尝试登录服务器事件.
 *
 * @deprecated 这个事件使登录线程同步;
 * 建议使用{@link AsyncPlayerPreLoginEvent}.
 */
@Deprecated
@Warning(reason="This event causes a login thread to synchronize with the main thread")
public class PlayerPreLoginEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private Result result;
    private String message;
    private final String name;
    private final InetAddress ipAddress;
    private final UUID uniqueId;

    @Deprecated
    public PlayerPreLoginEvent(final String name, final InetAddress ipAddress) {
        this(name, ipAddress, null);
    }

    public PlayerPreLoginEvent(final String name, final InetAddress ipAddress, final UUID uniqueId) {
        this.result = Result.ALLOWED;
        this.message = "";
        this.name = name;
        this.ipAddress = ipAddress;
        this.uniqueId = uniqueId;
    }

    /**
     * 获取当前事件的状态.
     * <p>
     * 原文:Gets the current result of the login, as an enum
     * @return 当前事件的状态
     */
    public Result getResult() {
        return result;
    }

    /**
     * 设置当前事件的状态.
     * <p>
     * 原文:Sets the new result of the login, as an enum
     *
     * @param result 当前事件的状态
     */
    public void setResult(final Result result) {
        this.result = result;
    }

    /**
     * 如果getResult() !=Result.ALLOWED，那么获取踢出的信息.
     * <p>
     * 原文:Gets the current kick message that will be used if getResult() !=
     * Result.ALLOWED
     *
     * @return result 踢出的信息
     */
    public String getKickMessage() {
        return message;
    }

    /**
     * 设置如果getResult() !=Result.ALLOWED，那么将要踢出的消息.
     * <p>
     * 原文:Sets the kick message to display if getResult() != Result.ALLOWED
     *
     * @param message 设置踢出的消息
     */
    public void setKickMessage(final String message) {
        this.message = message;
    }

    /**
     * 允许玩家登录.
     * <p>
     * 原文:Allows the player to log in
     */
    public void allow() {
        result = Result.ALLOWED;
        message = "";
    }

    /**
     * 不允许玩家登录.
     * <p>
     * 原文:Disallows the player from logging in, with the given reason
     *
     * @param result 结果
     * @param message 理由
     */
    public void disallow(final Result result, final String message) {
        this.result = result;
        this.message = message;
    }

    /**
     * 获得此玩家的名字.
     * <p>
     * 原文:Gets the player's name.
     *
     * @return 玩家名字
     */
    public String getName() {
        return name;
    }

    /**
     * 获得此玩家的IP地址.
     * <p>
     * 原文:Gets the player IP address.
     *
     * @return 玩家IP地址
     */
    public InetAddress getAddress() {
        return ipAddress;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    /**
     * 获得此玩家的唯一标识.
     * <p>
     * 原文:Gets the player's unique ID.
     *
     * @return 唯一标识
     */
    public UUID getUniqueId() {
        return uniqueId;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * 踢出玩家的原因.
     */
    public enum Result {

        /**
         * 允许玩家进入服务器.
         */
        ALLOWED,
        /**
         * 由于服务器已满,不允许进入.
         */
        KICK_FULL,
        /**
         * 由于玩家被服务器封禁,不允许进入.
         */
        KICK_BANNED,
        /**
         * 由于玩家不在白名单内,不允许进入.
         */
        KICK_WHITELIST,
        /**
         * 其他原因,就是不允许进入.
         */
        KICK_OTHER
    }
}