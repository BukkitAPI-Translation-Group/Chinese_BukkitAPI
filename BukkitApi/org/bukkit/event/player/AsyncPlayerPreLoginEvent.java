package org.bukkit.event.player;

import java.net.InetAddress;
import java.util.UUID;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * 存储尝试登录的玩家的详细信息，玩家尝试登录服务器的事件.
 * <p>
 * 这个事件是异步的，不在主线程上执行.
 */
public class AsyncPlayerPreLoginEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private Result result;
    private String message;
    private final String name;
    private final InetAddress ipAddress;
    private final UUID uniqueId;

    @Deprecated
    public AsyncPlayerPreLoginEvent(final String name, final InetAddress ipAddress) {
        this(name, ipAddress, null);
    }

    public AsyncPlayerPreLoginEvent(final String name, final InetAddress ipAddress, final UUID uniqueId) {
        super(true);
        this.result = Result.ALLOWED;
        this.message = "";
        this.name = name;
        this.ipAddress = ipAddress;
        this.uniqueId = uniqueId;
    }

    /**
     * 获取登录的状态.
     * <p>
     * 原文:Gets the current result of the login, as an enum
     *
     * @return 登录的状态
     */
    public Result getLoginResult() {
        return result;
    }

    /**
     * 获取登录的状态.
     * <p>
     * 原文:Gets the current result of the login, as an enum
     *
     * @return 登录的状态
     * @deprecated 这个方法使用了来自 {@link PlayerPreLoginEvent} 的已弃用的枚举
     * @see #getLoginResult()
     */
    @Deprecated
    public PlayerPreLoginEvent.Result getResult() {
        return result == null ? null : result.old();
    }

    /**
     * 设置登录的状态.
     * <p>
     * 原文:Sets the new result of the login, as an enum
     *
     * @param result 状态
     */
    public void setLoginResult(final Result result) {
        this.result = result;
    }

    /**
     * 设置登录的状态.
     * <p>
     * 原文:Sets the new result of the login, as an enum
     *
     * @param result 状态
     * @deprecated 这个方法使用了来自 {@link PlayerPreLoginEvent} 的已弃用的枚举
     * @see #setLoginResult(Result)
     */
    @Deprecated
    public void setResult(final PlayerPreLoginEvent.Result result) {
        this.result = result == null ? null : Result.valueOf(result.name());
    }

    /**
     * 获取将要使用的踢出消息，如果getResult() != Result.ALLOWED.
     * <p>
     * 原文:Gets the current kick message that will be used if getResult() !=
     * Result.ALLOWED
     *
     * @return 踢出消息
     */
    public String getKickMessage() {
        return message;
    }

    /**
     * 设置要显示的踢出消息，如果getResult() != Result.ALLOWED.
     * <p>
     * 原文:Sets the kick message to display if getResult() != Result.ALLOWED
     *
     * @param message 踢出消息
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
     * 以给定的理由不允许玩家登录.
     * <p>
     * 原文:Disallows the player from logging in, with the given reason
     *
     * @param result 不允许玩家登录的理由
     * @param message 给用户显示的踢出消息
     */
    public void disallow(final Result result, final String message) {
        this.result = result;
        this.message = message;
    }

    /**
     * 以给定的理由不允许玩家登录.
     * <p>
     * 原文:Disallows the player from logging in, with the given reason
     *
     * @param result 不允许玩家登录的理由
     * @param message 给用户显示的踢出消息
     * @deprecated 这个方法使用了来自 {@link PlayerPreLoginEvent} 的已弃用的枚举
     * @see #disallow(Result, String)
     */
    @Deprecated
    public void disallow(final PlayerPreLoginEvent.Result result, final String message) {
        this.result = result == null ? null : Result.valueOf(result.name());
        this.message = message;
    }

    /**
     * 获取玩家的名字.
     * <p>
     * 原文:Gets the player's name.
     *
     * @return 玩家名
     */
    public String getName() {
        return name;
    }

    /**
     * 获取玩家的IP地址.
     * <p>
     * 原文:Gets the player IP address.
     *
     * @return IP地址
     */
    public InetAddress getAddress() {
        return ipAddress;
    }

    /**
     * 获取玩家的唯一标识.
     * <p>
     * 原文:Gets the player's unique ID.
     *
     * @return UUID
     */
    public UUID getUniqueId() {
        return uniqueId;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * 基本的踢出理由，为了插件间的通信
     */
    public enum Result {

        /**
         * 玩家被允许登录
         */
        ALLOWED,
        /**
         * 由于服务器已满而不允许登录
         */
        KICK_FULL,
        /**
         * 由于该玩家被封禁而不允许登录
         */
        KICK_BANNED,
        /**
         * 由于玩家不在白名单上而不允许登录
         */
        KICK_WHITELIST,
        /**
         * 由于未定义的理由而不允许登录
         */
        KICK_OTHER;

        @Deprecated
        private PlayerPreLoginEvent.Result old() {
            return PlayerPreLoginEvent.Result.valueOf(name());
        }
    }
}
