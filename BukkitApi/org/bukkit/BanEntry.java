package org.bukkit;

import java.util.Date;

/**
 * 封禁列表的entry 包括玩家封禁列表和IP封禁列表
 * <p>
 * 封禁列表包括以下属性:
 * <table border=1>
 * <caption>Property信息</caption>
 * <tr>
 *     <th>属性</th>
 *     <th>描述</th>
 * </tr><tr>
 *     <td>目标昵称 / IP地址</td>
 *     <td>目标的昵称或IP地址</td>
 * </tr><tr>
 *     <td>封禁日期</td>
 *     <td>封禁的开始时间</td>
 * </tr><tr>
 *     <td>创建人</td>
 *     <td>封禁命令的发出者。可能是玩家、控制台、插件等。</td>
 * </tr><tr>
 *     <td>到期时间</td>
 *     <td>封禁的到期时间</td>
 * </tr><tr>
 *     <td>理由</td>
 *     <td>封禁的理由</td>
 * </tr>
 * </table>
 * <p>
 * Unsaved information is not automatically written to the implementation's
 * ban list, instead, the {@link #save()} method must be called to write the
 * changes to the ban list. If this ban entry has expired (such as from an
 * unban) and is no longer found in the list, the {@link #save()} call will
 * re-add it to the list, therefore banning the victim specified.
 * <p>
 * Likewise, changes to the associated {@link BanList} or other entries may or
 * may not be reflected in this entry.
 */
public interface BanEntry {

    /**
     * 原文：Gets the target involved. This may be in the form of an IP or a player
     * name.
     * <p>
     * 翻译：得到被封禁者。可能返回一个IP地址或一个玩家昵称。
     *
     * @return 玩家昵称或IP地址
     */
    public String getTarget();

    /**
     * 原文：Gets the date this ban entry was created.
     * <p>
     * 翻译：得到封禁开始日期。
     *
     * @return 封禁开始日期
     */
    public Date getCreated();

    /**
     * 原文：Sets the date this ban entry was created.
     * <p>
     * 翻译：设置封禁开始日期。
     *
     * @param created 要设置的日期。不能为null
     * @see #save() 保存更改
     */
    public void setCreated(Date created);

    /**
     * 原文：Gets the source of this ban.
     * <p>
     * Note: A source is considered any String, although this is generally a
     * player name.
     * <p>
     * 翻译：得到封禁的创建人。
     * <p>
     * 注意：返回的有可能是任何一个字符串，虽然大多数时候是一个玩家名。
     *
     * @return 封禁的创建人
     */
    public String getSource();

    /**
     * 原文：Sets the source of this ban.
     * <p>
     * Note: A source is considered any String, although this is generally a
     * player name.
     * 翻译：设置封禁的创建人。
     * <p>
     * 注意：设置的可以是任何一个字符串，但大多数时候是一个玩家名。
     * <p>
     * @param source 要设置成的创建人，不能为null
     * @see #save() 保存更改
     */
    public void setSource(String source);

    /**
     * 原文：Gets the date this ban expires on, or null for no defined end date.
     * <p>
     * 翻译：得到封禁的到期时间，如果不会到期则为null。
     * <p>
     * @return 到期时间。
     */
    public Date getExpiration();

    /**
     * 原文：Sets the date this ban expires on. Null values are considered
     * "infinite" bans.
     * <p>
     * 翻译：设置封禁的到期时间。如果为null，则为永久封禁。
     *
     * @param expiration 新的到期时间。null则为永久封禁。
     * @see #save() 保存更改
     */
    public void setExpiration(Date expiration);

    /**
     * 原文：Gets the reason for this ban.
     * <p>
     * 翻译：得到封禁理由。
     *
     * @return 封禁理由。如果没有则返回null
     */
    public String getReason();

    /**
     * 原文：Sets the reason for this ban. Reasons must not be null.
     * <p>
     * 翻译：设置封禁的理由。不能为null。
     *
     * @param reason 要设置成的理由
     * @see #save() 保存更改
     */
    public void setReason(String reason);

    /**
     * 原文：Saves the ban entry, overwriting any previous data in the ban list.
     * <p>
     * Saving the ban entry of an unbanned player will cause the player to be
     * banned once again.
     * <p>
     * 翻译：保存刚刚的更改.
     */
    public void save();
}
