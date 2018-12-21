package org.bukkit.event.player;

import java.net.InetAddress;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * 玩家尝试登录的事件.
 * <br>
 * Note that this event is called <i>early</i> in the player initialization
 * process. It is recommended that most options involving the Player
 * <i>entity</i> be postponed to the {@link PlayerJoinEvent} instead.
 */
public class PlayerLoginEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private final InetAddress address;
    private final String hostname;
    private Result result = Result.ALLOWED;
    private String message = "";

    /**
     * 这个构造器默认踢出消息为空、登录状态为ALLOWED
     * <p>
     * 原文:
     * This constructor defaults message to an empty string, and result to
     * ALLOWED
     *
     * @param player 这个事件的{@link Player 玩家}
     * @param hostname 用于连接服务器的主机名
     * @param address 玩家的IP地址
     */
    public PlayerLoginEvent(final Player player, final String hostname, final InetAddress address) {
        super(player);
        this.hostname = hostname;
        this.address = address;
    }

    /**
     * 此构造器预配置事件的结果和消息.
     * <p>
     * 原文:This constructor pre-configures the event with a result and message
     *
     * @param player 这个事件的{@link Player 玩家}
     * @param hostname 用于连接服务器的主机名
     * @param address 玩家的IP地址
     * @param result 事件的登录状态结果
     * @param message 拒绝登录时显示的消息
     */
    public PlayerLoginEvent(final Player player, String hostname, final InetAddress address, final Result result, final String message) {
        this(player, hostname, address);
        this.result = result;
        this.message = message;
    }

    /**
     * 获取当前的登录状态.
     * <p>
     * 原文:Gets the current result of the login, as an enum
     *
     * @return 登录状态
     */
    public Result getResult() {
        return result;
    }

    /**
     * 设置登录的状态.
     * <p>
     * 原文:Sets the new result of the login, as an enum
     *
     * @param result 登录状态
     */
    public void setResult(final Result result) {
        this.result = result;
    }

    /**
     * 如果<code>getResult() != Result.ALLOWED</code>,获取将使用的踢出消息
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
     * 如果<code>getResult() != Result.ALLOWED</code>,设置要显示的踢出消息
     * <p>
     * 原文:Sets the kick message to display if getResult() != Result.ALLOWED
     *
     * @param message 踢出消息
     */
    public void setKickMessage(final String message) {
        this.message = message;
    }

    /**
     * 获取玩家用于连接服务器的主机名，如果未知则为空
     * <p>
     * 原文:Gets the hostname that the player used to connect to the server, or
     * blank if unknown
     *
     * @return 主机名
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * 允许玩家登录
     * <p>
     * 原文:Allows the player to log in
     */
    public void allow() {
        result = Result.ALLOWED;
        message = "";
    }

    /**
     * 以给定的理由不允许玩家登录
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
     * 获取玩家的{@link InetAddress IP地址}.
     * 这个方法是在此事件期间使用 <code>player.getAddress()</code> 为null的解决办法
     * <p>
     * 原文:Gets the {@link InetAddress} for the Player associated with this event.
     * This method is provided as a workaround for player.getAddress()
     * returning null during PlayerLoginEvent.
     *
     * @return 玩家的IP地址。为兼容旧版，这可能是null
     */
    public InetAddress getAddress() {
        return address;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * 踢出玩家的理由
     */
    public enum Result {

        /**
         * 玩家被允许登录
         */
        ALLOWED,
        /**
         * 由于服务器已满,不允许登录
         */
        KICK_FULL,
        /**
         * 由于玩家被封禁，不允许登录
         */
        KICK_BANNED,
        /**
         * 由于玩家不在白名单上而不允许登录
         * white list
         */
        KICK_WHITELIST,
        /**
         * 由于其他原因而不允许登录
         */
        KICK_OTHER
    }
}