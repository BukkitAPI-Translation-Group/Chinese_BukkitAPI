package org.bukkit;

import java.util.Date;

/**
 * 封禁列表里的单个封禁条目.本封禁条目可以代表关于一个玩家的封禁或关于一个IP地址的封禁.
 * <p>
 * 封禁条目包括以下属性:
 * <table border=1>
 * <caption>Property information</caption>
 * <tr>
 *     <th>属性</th>
 *     <th>描述</th>
 * </tr><tr>
 *     <td>目标玩家名 / IP地址</td>
 *     <td>目标的玩家名或IP地址/td>
 * </tr><tr>
 *     <td>创建日期</td>
 *     <td>本次封禁的创建日期(开始日期)</td>
 * </tr><tr>
 *     <td>创建者</td>
 *     <td>封禁的创建者，可以是玩家、控制台、插件等</td>
 * </tr><tr>
 *     <td>到期时间</td>
 *     <td>封禁的到期事件</td>
 * </tr><tr>
 *     <td>理由</td>
 *     <td>封禁的理由</td>
 * </tr>
 * </table>
 * <p>
 * 未保存的信息不会自动写入到实现的封禁列表中，
 * 反而，{@link #save()} 方法必须被调用，以保存到封禁列表中.
 * 如果本封禁条目已经过期(例如unban命令)或不再存在于封禁列表中，{@link #save()} 方法的调用将重新添加本条目至封禁列表，
 * 因而导致再次封禁指定的受害者.
 * 同样地，对相关的{@link BanList}或其他的条目的更改可能或可能不会反映在此条目上.
 */
public interface BanEntry {

    /**
     * 获取本次封禁的目标.这可能是一个IP地址或玩家名.
     * <p>
     * 原文:
     * Gets the target involved. This may be in the form of an IP or a player
     * name.
     *
     * @return 被封禁的玩家的名字或IP地址
     */
    public String getTarget();

    /**
     * 获取本次封禁的开始时间.
     * <p>
     * 原文:
     * Gets the date this ban entry was created.
     *
     * @return 封禁开始时间
     */
    public Date getCreated();

    /**
     * 设置本次封禁的开始时间.
     * <p>
     * 原文:
     * Sets the date this ban entry was created.
     *
     * @param created 要设置的日期,不能为null
     * @see #save() 保存更改
     */
    public void setCreated(Date created);

    /**
     * 获取本次封禁的创建者.
     * <p>
     * 注意:创建者可以是任何字符串，虽然大部分情况是玩家名.
     * <p>
     * 原文:
     * Gets the source of this ban.
     * <p>
     * Note: A source is considered any String, although this is generally a
     * player name.
     *
     * @return 封禁创建者
     */
    public String getSource();

    /**
     * 设置本次封禁的创建者.
     * <p>
     * 注意:创建者可以是任何字符串，虽然大部分情况是玩家名.
     * <p>
     * 原文:
     * Sets the source of this ban.
     * <p>
     * Note: A source is considered any String, although this is generally a
     * player name.
     *
     * @param source 新的创建者，若设为null将变为空字符串
     * @see #save() 保存更改
     */
    public void setSource(String source);

    /**
     * 获取本次封禁的到期时间。null为未定义到期时间(永不到期).
     * <p>
     * 原文:
     * Gets the date this ban expires on, or null for no defined end date.
     *
     * @return 到期时间
     */
    public Date getExpiration();

    /**
     * 设置本次封禁的到期时间.设为null则表示永不到期.
     * <p>
     * 原文:
     * Sets the date this ban expires on. Null values are considered
     * "infinite" bans.
     *
     * @param expiration 新的封禁到期时间，null则表示永不到期
     * @see #save() 保存更改
     */
    public void setExpiration(Date expiration);

    /**
     * 获取此次封禁的理由.
     * <p>
     * 原文:
     * Gets the reason for this ban.
     *
     * @return 封禁理由，null为尚未设置，使用默认值
     */
    public String getReason();

    /**
     * 设置本次封禁的理由.
     * <p>
     * 原文:
     * Sets the reason for this ban. Reasons must not be null.
     *
     * @param reason 新的封禁理由，null表示使用默认值
     * @see #save() 保存更改
     */
    public void setReason(String reason);

    /**
     * 保存这个封禁条目，将覆盖在封禁列表里的数据.
     * <p>
     * 保存关于一个未被封禁的玩家的封禁条目，将导致这个玩家再一次被封禁.
     * <p>
     * 原文:
     * Saves the ban entry, overwriting any previous data in the ban list.
     * <p>
     * Saving the ban entry of an unbanned player will cause the player to be
     * banned once again.
     */
    public void save();
}
