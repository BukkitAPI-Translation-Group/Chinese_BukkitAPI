package org.bukkit.event.server;

import java.net.InetAddress;
import java.util.Iterator;

import org.apache.commons.lang.Validate;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.util.CachedServerIcon;

/**
 * 当收到MOTD请求时被调用。显示的玩家会被检查并会在这个事件里被{@link #iterator() iterating}移出。
 */
public class ServerListPingEvent extends ServerEvent implements Iterable<Player> {
    private static final int MAGIC_PLAYER_COUNT = Integer.MIN_VALUE;
    private static final HandlerList handlers = new HandlerList();
    private final InetAddress address;
    private String motd;
    private final int numPlayers;
    private int maxPlayers;

    public ServerListPingEvent(final InetAddress address, final String motd, final int numPlayers, final int maxPlayers) {
        Validate.isTrue(numPlayers >= 0, "Cannot have negative number of players online", numPlayers);
        this.address = address;
        this.motd = motd;
        this.numPlayers = numPlayers;
        this.maxPlayers = maxPlayers;
    }

    /**
     * 这个构造器用于实现提供{@link #iterator()}方法，例如提供{@link #getNumPlayers()}玩家总数。
     * <p>
     * 原文：
     * This constructor is intended for implementations that provide the
     * {@link #iterator()} method, thus provided the {@link #getNumPlayers()}
     * count.
     * 
     * @param address 请求者的地址
     * @param motd 每日信息
     * @param maxPlayers 最大玩家数量
     */
    protected ServerListPingEvent(final InetAddress address, final String motd, final int maxPlayers) {
        this.numPlayers = MAGIC_PLAYER_COUNT;
        this.address = address;
        this.motd = motd;
        this.maxPlayers = maxPlayers;
    }

    /**
     * 获取请求来源地址。
     * <p>
     * 原文：
     * Get the address the ping is coming from.
     *
     * @return 地址
     */
    public InetAddress getAddress() {
        return address;
    }

    /**
     * 获取每日信息。
     * <p>
     * 原文：
     * Get the message of the day message.
     *
     * @return 每日信息
     */
    public String getMotd() {
        return motd;
    }

    /**
     * 更改每日信息。
     * <p>
     * 原文：
     * Change the message of the day message.
     *
     * @param motd 每日信息
     */
    public void setMotd(String motd) {
        this.motd = motd;
    }

    /**
     * 获取玩家数量。
     * <p>
     * 原文：
     * Get the number of players sent.
     *
     * @return 玩家数量
     */
    public int getNumPlayers() {
        int numPlayers = this.numPlayers;
        if (numPlayers == MAGIC_PLAYER_COUNT) {
            numPlayers = 0;
            for (@SuppressWarnings("unused") final Player player : this) {
                numPlayers++;
            }
        }
        return numPlayers;
    }

    /**
     * 获取最大玩家数量。
     * <p>
     * 原文：
     * Get the maximum number of players sent.
     *
     * @return 最大玩家数量
     */
    public int getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * 设置最大玩家数量。
     * <p>
     * 原文：
     * Set the maximum number of players sent.
     *
     * @param maxPlayers 最大玩家数量
     */
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    /**
     * 设置发送给客户端的服务器图标。
     * <p>
     * 原文：
     * Sets the server-icon sent to the client.
     *
     * @param icon 发送给客户端的图标
     * @throws IllegalArgumentException 如果{@link CachedServerIcon}在这个事件中未被调用者创建则抛出错误；一些接口可能会接受null
     * @throws UnsupportedOperationException 如果这个事件的调用者不支持设置这个服务器图标则抛出错误
     */
    public void setServerIcon(CachedServerIcon icon) throws IllegalArgumentException, UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * {@inheritDoc}
     * <p>
     * 调用{@link Iterator#remove()}方法将会强制部分玩家不会在玩家列表里显示，减小{@link #getNumPlayers()}返回的大小，并且不会再被任何一个新的迭代器返回。
     * <p>
     * 原文：
     * {@inheritDoc}
     * <p>
     * Calling the {@link Iterator#remove()} method will force that particular
     * player to not be displayed on the player list, decrease the size
     * returned by {@link #getNumPlayers()}, and will not be returned again by
     * any new iterator.
     *
     * @throws UnsupportedOperationException 如果这个事件的调用者不支持移除玩家则会抛出错误。
     */
    @Override
    public Iterator<Player> iterator() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}