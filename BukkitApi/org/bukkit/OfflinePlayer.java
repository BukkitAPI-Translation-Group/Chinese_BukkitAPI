package org.bukkit;

import java.util.UUID;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.ServerOperator;

public interface OfflinePlayer extends ServerOperator, AnimalTamer, ConfigurationSerializable {

    /**
     * 检查玩家是否在线
     * <p>
     * 原文:Checks if this player is currently online
     *
     * @return 在线返回true,反之返回false
     */
    public boolean isOnline();

    /**
     * 返回该玩家的游戏名
     * <p>
     * 游戏名并不再是唯一的游戏标识,如果你希望长时间储存,建议使用{@link #getUniqueId()}来替代
     * <p>
     * 原文:Names are no longer unique past a single game session. For persistent storage
     * <p>
     * it is recommended that you use {@link #getUniqueId()} instead.
     *
     * @return 返回玩家游戏名,如果玩家不存在返回null
     */
    public String getName();

    /**
     * 返回该玩家的游戏UUID标识
     *
     * @return 玩家游戏UUID
     */
    public UUID getUniqueId();

    /**
     * 检测该玩家是否被封禁
     *
     * @return 是否被封禁
     */
    public boolean isBanned();

    /**
     * 检测玩家是否存在白名单列表中
     *
     * @return 是否加白
     */
    public boolean isWhitelisted();

    /**
     * 将玩家添加到白名单列表或移除
     *
     * @param value 如果要添加到白名单列表内使用true,反之使用false
     */
    public void setWhitelisted(boolean value);

    /**
     * 获取一个 {@link Player}对象
     * <p>
     * 原文:Gets a {@link Player} object that this represents, if there is one
     * <p>
     * 如果玩家在线,返回Player对象数据,反之返回null
     *
     * @return 玩家Player对象
     */
    public Player getPlayer();

    /**
     * 获取该玩家第一次进入服务器的时间
     * <p>
     * 原文:Gets the first date and time that this player was witnessed on this
     * server.
     * <p>
     * 返回自1970年1月1日0日0分距当前时间的毫秒数.但如果该玩家从未进入服务器,则会返回0
     * <p>
     * If the player has never played before, this will return 0. Otherwise,
     * it will be the amount of milliseconds since midnight, January 1, 1970
     * UTC.
     *
     * @return 返回玩家第一次进入服务器的时间
     */
    public long getFirstPlayed();

    /**
     * 获取该玩家最后一次登录服务器的时间
     * <p>
     * 原文:Gets the last date and time that this player was witnessed on this
     * server.
     * <p>
     * 返回自1970年1月1日0日0分距当前时间的毫秒数.但如果该玩家从未进入服务器,则会返回0
     * <p>
     * 原文:If the player has never played before, this will return 0. Otherwise,
     * it will be the amount of milliseconds since midnight, January 1, 1970
     * UTC.
     *
     * @return 返回最后登录的时间
     */
    public long getLastPlayed();

    /**
     * 检测该玩家是否在先前在此服游戏过
     * <p>
     * 原文:Checks if this player has played on this server before.
     *
     * @return 如果是返回true,反之返回false
     */
    public boolean hasPlayedBefore();

    /**
     * 获取该玩家在床的重生点的Location对象,但如果该玩家从未使用过床或该重生点无效,则会返回null
     * <p>
     * 原文:Gets the Location where the player will spawn at their bed, null if
     * they have not slept in one or their current bed spawn is invalid.
     *
     * @return 获取玩家的床重生点Location对象信息.如果不存在返回null
     */
    public Location getBedSpawnLocation();

}
