package org.bukkit.event.player;

import java.net.InetAddress;
import java.util.UUID;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * 储存一个尝试登录的玩家的详情信息.
 * <p>
 * 这个事件不是同步的，也不用主方法运行的.
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
     * 以enum形式获得这次事件的结果.
     *
     * @return 这次登录的结果
     */
    public Result getLoginResult() {
        return result;
    }

    /**
     * 以枚举形式获得这次事件的结果
     *
     * @return 这次登录的结果
     * @deprecated 这个方法从{@link
     *     PlayerPreLoginEvent} 里面引用了一个过时枚举类型.
     * @see #getLoginResult()
     */
    @Deprecated
    public PlayerPreLoginEvent.Result getResult() {
        return result == null ? null : result.old();
    }

    /**
     * 以枚举形式设置这次登录的结果
     * 
     * @param result 要设置的结果
     */
    public void setLoginResult(final Result result) {
        this.result = result;
    }

    /**
     * 以枚举形式设置这次登录的结果
     * 
     * @param result 要设置的结果
     * @deprecated 这个方法从 {@link
     *     PlayerPreLoginEvent} 里面引用了一个过时的枚举类型.
     * @see #setLoginResult(Result)
     */
    @Deprecated
    public void setResult(final PlayerPreLoginEvent.Result result) {
        this.result = result == null ? null : Result.valueOf(result.name());
    }

    /**
     * 当getResult() 不等于Result.ALLOWED的时候获得这次踢出玩家的消息
     * 
     * @return 现在玩家踢出的消息
     */
    public String getKickMessage() {
        return message;
    }

    /**
     * 当getResult() 不等于Result.ALLOWED的时候设置这次踢出玩家的消息
     * 
     * @param message 新的踢出玩家时显示的信息
     */
    public void setKickMessage(final String message) {
        this.message = message;
    }

    /**
     * 是否允许玩家登录.
     */
    public void allow() {
        result = Result.ALLOWED;
        message = "";
    }

    /**
     * 不允许玩家登录并且提供原因
     *
     * @param result 是否允许玩家登录的新结果
     * @param message 给玩家的原因
     */
    public void disallow(final Result result, final String message) {
        this.result = result;
        this.message = message;
    }

    /**
     * 不允许玩家登录并且提供原因
     *
     * @param result 是否允许玩家登录的新结果
     * @param message 给玩家的原因
     * @deprecated 这个方法从 {@link
     *     PlayerPreLoginEvent} 里面引用了一个过时的枚举类型
     * @see #disallow(Result, String)
     */
    @Deprecated
    public void disallow(final PlayerPreLoginEvent.Result result, final String message) {
        this.result = result == null ? null : Result.valueOf(result.name());
        this.message = message;
    }

    /**
     * 获得玩家的名字.
     *
     * @return 玩家的名字
     */
    public String getName() {
        return name;
    }

    /**
     * 获取玩家的IP地址.
     *
     * @return IP地址
     */
    public InetAddress getAddress() {
        return ipAddress;
    }

    /**
     * 获得玩家独特的ID.
     *
     * @return 独特的ID
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
     * 对于其他插件的基本踢出玩家的原因
     */
    public enum Result {

        /**
         * 玩家被允许登录
         */
        ALLOWED,
        /**
         * 玩家因为服务器满了所以不允许登录
         */
        KICK_FULL,
        /**
         * 玩家因为被封号了所以不允许登录
         */
        KICK_BANNED,
        /**
         * 玩家因为不在白名单上所以不允许登录
         */
        KICK_WHITELIST,
        /**
         * 玩家没有理由就是不让登陆
         */
        KICK_OTHER;

        @Deprecated
        private PlayerPreLoginEvent.Result old() {
            return PlayerPreLoginEvent.Result.valueOf(name());
        }
    }
}
