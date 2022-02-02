package org.bukkit.scoreboard;

import java.util.Set;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 计分板上的队伍, 拥有共同的显示名和其它属性.
 * 此队伍只与 {@link #getScoreboard()} 获取的计分板相关联.
 */
public interface Team {

    /**
     * 获取此队伍的名称.
     * <p>
     * 原文:Gets the name of this Team
     *
     * @return 队伍名
     * @throws IllegalStateException 若此队伍已被注销
     */
    @NotNull
    String getName() throws IllegalStateException;

    /**
     * 获取此队伍的显示名.
     * <p>
     * 原文:Gets the name displayed to entries for this team
     *
     * @return 队伍显示名
     * @throws IllegalStateException 若此队伍已被注销
     */
    @NotNull
    String getDisplayName() throws IllegalStateException;

    /**
     * 设置队伍的显示名称.
     * <p>
     * 原文:Sets the name displayed to entries for this team
     *
     * @param displayName 队伍显示名
     * @throws IllegalArgumentException 若 displayName 长度超过 128 个字符
     * @throws IllegalStateException 若此队伍已被注销
     */
    void setDisplayName(@NotNull String displayName) throws IllegalStateException, IllegalArgumentException;

    /**
     * 获取添加于队员名前的前缀.
     * <p>
     * 原文:Gets the prefix prepended to the display of entries on this team.
     *
     * @return 队员名前缀
     * @throws IllegalStateException 若此队伍已被注销
     */
    @NotNull
    String getPrefix() throws IllegalStateException;

    /**
     * 设置添加于队员名前的前缀.
     * <p>
     * 原文:Sets the prefix prepended to the display of entries on this team.
     *
     * @param prefix 队员名前缀
     * @throws IllegalArgumentException 若参数 prefix 为 null
     * @throws IllegalArgumentException 若 prefix 长度超过 64 个字符
     * @throws IllegalStateException 若此队伍已被注销
     */
    void setPrefix(@NotNull String prefix) throws IllegalStateException, IllegalArgumentException;

    /**
     * 获取添加于队员名后的后缀.
     * <p>
     * 原文:Gets the suffix appended to the display of entries on this team.
     *
     * @return 队员名后缀
     * @throws IllegalStateException 若此队伍已被注销
     */
    @NotNull
    String getSuffix() throws IllegalStateException;

    /**
     * 设置添加于队员名后的后缀.
     * <p>
     * 原文:Sets the suffix appended to the display of entries on this team.
     *
     * @param suffix 要设置的队员名后缀
     * @throws IllegalArgumentException 若参数 suffix 为 null
     * @throws IllegalArgumentException 若 suffix 长度超过 64 个字符
     * @throws IllegalStateException 若此队伍已被注销
     */
    void setSuffix(@NotNull String suffix) throws IllegalStateException, IllegalArgumentException;

    /**
     * 获取队伍的颜色.
     * <p>
     * 此颜色只代表队伍主要颜色,
     * 其它颜色比如队员名前后缀的颜色由其前缀/后缀处理.
     * <p>
     * 原文:Gets the color of the team.
     * <br>
     * This only sets the team outline, other occurrences of colors such as in
     * names are handled by prefixes / suffixes.
     *
     * @return 队伍颜色, 默认为 {@link ChatColor#RESET}
     * @throws IllegalStateException 若此队伍已被注销
     */
    @NotNull
    ChatColor getColor() throws IllegalStateException;

    /**
     * 设置队伍的颜色.
     * <p>
     * 本方法只是设置了队伍主要颜色,
     * 其它颜色比如队员名前后缀的颜色由其前缀/后缀处理.
     * <p>
     * 原文:Sets the color of the team.
     * <br>
     * This only sets the team outline, other occurrences of colors such as in
     * names are handled by prefixes / suffixes.
     *
     * @param color 新颜色, 不能为 null. 使用 {@link ChatColor#RESET} 重置颜色
     */
    void setColor(@NotNull ChatColor color);

    /**
     * 获取队伍成员能否互相攻击.
     * <p>
     * 原文:Gets the team friendly fire state
     *
     * @return 如果允许互相攻击则为true
     * @throws IllegalStateException 若此队伍已被注销
     */
    boolean allowFriendlyFire() throws IllegalStateException;

    /**
     * 设置队伍成员能否互相攻击.
     * <p>
     * 原文:Sets the team friendly fire state
     *
     * @param enabled 如果允许互相攻击则为true
     * @throws IllegalStateException 若此队伍已被注销
     */
    void setAllowFriendlyFire(boolean enabled) throws IllegalStateException;

    /**
     * 获取此队伍能否看见处于{@link PotionEffectType#INVISIBILITY
     * 隐身}状态效果下的队友.
     * <p>
     * 原文:Gets the team's ability to see {@link PotionEffectType#INVISIBILITY
     * invisible} teammates.
     *
     * @return 如果隐身队友可被同队队友看见则为true
     * @throws IllegalStateException 若此队伍已被注销
     */
    boolean canSeeFriendlyInvisibles() throws IllegalStateException;

    /**
     * 设置此队伍能否看见处于{@link PotionEffectType#INVISIBILITY
     * 隐身}状态效果下的队友.
     * <p>
     * 原文:Sets the team's ability to see {@link PotionEffectType#INVISIBILITY
     * invisible} teammates.
     *
     * @param enabled 如果隐身队友可被同队队友看见则为true
     * @throws IllegalStateException 若此队伍已被注销
     */
    void setCanSeeFriendlyInvisibles(boolean enabled) throws IllegalStateException;

    /**
     * 获取此队伍的玩家名可见性.
     * <p>
     * 原文:Gets the team's ability to see name tags
     *
     * @return 当前设置的可见性
     * @throws IllegalArgumentException 若此队伍已被注销
     * @deprecated 另请参阅 {@link #getOption(org.bukkit.scoreboard.Team.Option)}
     */
    @Deprecated
    @NotNull
    NameTagVisibility getNameTagVisibility() throws IllegalArgumentException;

    /**
     * 设置此队伍的玩家名可见性.
     * <p>
     * 原文:Set's the team's ability to see name tags
     *
     * @param visibility 要设置的 nameTagVisibility
     * @throws IllegalArgumentException 若此队伍已被注销
     * @deprecated 另请参阅
     * {@link #setOption(org.bukkit.scoreboard.Team.Option, org.bukkit.scoreboard.Team.OptionStatus)}
     */
    @Deprecated
    void setNameTagVisibility(@NotNull NameTagVisibility visibility) throws IllegalArgumentException;

    /**
     * 获取队伍内所有玩家的集合.
     * <p>
     * 原文:Gets the Set of players on the team
     *
     * @return 队伍玩家集合
     * @throws IllegalStateException 若此队伍已被注销
     * @see #getEntries()
     * @deprecated 队伍可包含非玩家项目
     */
    @Deprecated
    @NotNull
    Set<OfflinePlayer> getPlayers() throws IllegalStateException;

    /**
     * 获取队伍内所有项目的集合.
     * <p>
     * 原文:Gets the Set of entries on the team
     *
     * @return 队伍项目集合
     * @throws IllegalStateException 若此队伍已被注销
     */
    @NotNull
    Set<String> getEntries() throws IllegalStateException;

    /**
     * 获取此队伍的队员数.
     * <p>
     * 原文:Gets the size of the team
     *
     * @return 队伍队员数
     * @throws IllegalStateException 若此队伍已被注销
     */
    int getSize() throws IllegalStateException;

    /**
     * 获取此队伍所附属的计分板.
     * <p>
     * 原文:Gets the Scoreboard to which this team is attached
     *
     * @return 管理此队伍的计分板, 如果此队伍已被{@link #unregister() 注销}则返回 null
     */
    @Nullable
    Scoreboard getScoreboard();

    /**
     * 将某玩家加入这个队伍.
     * <p>
     * 这将使此玩家离开其它队伍.
     * <p>
     * 原文:This puts the specified player onto this team for the scoreboard.
     * <p>
     * This will remove the player from any other team on the scoreboard.
     *
     * @param player 要加入的玩家
     * @throws IllegalArgumentException 若参数 player 为 null
     * @throws IllegalStateException 若此队伍已被注销
     * @see #addEntry(String)
     * @deprecated 队伍可包含非玩家项目
     */
    @Deprecated
    void addPlayer(@NotNull OfflinePlayer player) throws IllegalStateException, IllegalArgumentException;

    /**
     * 将某条项目加入这个队伍.
     * <p>
     * 这将使此项目离开其它队伍.
     * <p>
     * 原文:This puts the specified entry onto this team for the scoreboard.
     * <p>
     * This will remove the entry from any other team on the scoreboard.
     *
     * @param entry 要加入的项目
     * @throws IllegalArgumentException 若参数 entry 为 null
     * @throws IllegalStateException 若此队伍已被注销
     */
    void addEntry(@NotNull String entry) throws IllegalStateException, IllegalArgumentException;

    /**
     * 使某玩家离开此队伍.
     * <p>
     * 原文:Removes the player from this team.
     *
     * @param player 要移除的玩家
     * @return 此玩家是否曾为队伍中的一员
     * @throws IllegalArgumentException 若参数 player 为 null
     * @throws IllegalStateException 若此队伍已被注销
     * @see #removeEntry(String)
     * @deprecated 队伍可包含非玩家项目
     */
    @Deprecated
    boolean removePlayer(@NotNull OfflinePlayer player) throws IllegalStateException, IllegalArgumentException;

    /**
     * 移除队伍中的某条项目.
     * <p>
     * 原文:Removes the entry from this team.
     *
     * @param entry 要移除的项目
     * @return 此项目是否曾为队伍中的一员
     * @throws IllegalArgumentException 若参数 entry 为 null
     * @throws IllegalStateException 若此队伍已被注销
     */
    boolean removeEntry(@NotNull String entry) throws IllegalStateException, IllegalArgumentException;

    /**
     * 从这个计分板上注销这个队伍.
     * <p>
     * 原文:Unregisters this team from the Scoreboard
     *
     * @throws IllegalStateException 若此队伍已被注销
     */
    void unregister() throws IllegalStateException;

    /**
     * 检测某玩家是否在此队伍内.
     * <p>
     * 原文:Checks to see if the specified player is a member of this team.
     *
     * @param player 要查找的玩家
     * @return 如果在队伍内就返回true
     * @throws IllegalArgumentException 若参数 player 为 null
     * @throws IllegalStateException 若此队伍已被注销
     * @see #hasEntry(String)
     * @deprecated 队伍可包含非玩家项目
     */
    @Deprecated
    boolean hasPlayer(@NotNull OfflinePlayer player) throws IllegalArgumentException, IllegalStateException;
    /**
     * 检测某项目是否在此队伍内.
     * <p>
     * 原文:Checks to see if the specified entry is a member of this team.
     *
     * @param entry 要查找的项目
     * @return 如果在队伍内就返回true
     * @throws IllegalArgumentException 若参数 entry 为 null
     * @throws IllegalStateException 若此队伍已被注销
     */
    boolean hasEntry(@NotNull String entry) throws IllegalArgumentException, IllegalStateException;

    /**
     * 获取队伍的一个选项.
     * <p>
     * 原文:Get an option for this team
     *
     * @param option 要获取的选项
     * @return 选项状态值
     * @throws IllegalStateException 若此队伍已被注销
     */
    @NotNull
    OptionStatus getOption(@NotNull Option option) throws IllegalStateException;

    /**
     * 为队伍设置一个选项.
     * <p>
     * 原文:Set an option for this team
     *
     * @param option 要设置的选项
     * @param status 选项状态值
     * @throws IllegalStateException 若此队伍已被注销
     */
    void setOption(@NotNull Option option, @NotNull OptionStatus status) throws IllegalStateException;

    /**
     * 代表可应用于队伍的选项.
     * <p>
     * 译注:对于所有的 Option, 其 OptionStatus 默认值均为 ALWAYS.
     * 这些 Option 对应的 OptionStatus 的意义不尽相同, 为避免歧义,
     * 对应 OptionStatus 的效果用表格列举如下:
     * <table border=1>
     * <caption>Option - OptionStatus 对照表</caption>
     * <tr>
     *     <th></th>
     *     <th>NAME_TAG_VISIBILITY</th>
     *     <th>DEATH_MESSAGE_VISIBILITY</th>
     *     <th>COLLISION_RULE</th>
     * </tr>
     * <tr>
     *     <th>ALWAYS</th>
     *     <td>一直显示玩家名称</td>
     *     <td>一直显示死亡消息</td>
     *     <td>启用碰撞</td>
     * </tr>
     * <tr>
     *     <th>NEVER</th>
     *     <td>对所有玩家隐藏玩家名称</td>
     *     <td>对所有玩家隐藏死亡消息</td>
     *     <td>队内没有玩家可被推动</td>
     * </tr>
     * <tr>
     *     <th>FOR_OTHER_TEAMS</th>
     *     <td>对其它队伍玩家隐藏玩家名称(仅本队能看到)</td>
     *     <td>对其它队伍玩家隐藏死亡消息</td>
     *     <td>仅队内玩家可互相推动</td>
     * </tr>
     * <tr>
     *     <th>FOR_OWN_TEAM</th>
     *     <td>对同队玩家隐藏玩家名称(其他人能看到)</td>
     *     <td>对同队玩家隐藏死亡消息</td>
     *     <td>仅其它队伍玩家可推动本队玩家</td>
     * </tr>
     * </table>
     */
    public enum Option {

        /**
         * 玩家显示名的可见性.
         */
        NAME_TAG_VISIBILITY,
        /**
         * 玩家死亡消息的可见性.
         */
        DEATH_MESSAGE_VISIBILITY,
        /**
         * 队伍中玩家与其他人的碰撞规则.
         */
        COLLISION_RULE;
    }

    /**
     * 选项应用给队伍成员的方式.
     * <p>
     * 译注:对于所有的 Option, 其 OptionStatus 默认值均为 ALWAYS.
     * 这些 Option 对应的 OptionStatus 的意义不尽相同, 为避免歧义,
     * 对应 OptionStatus 的效果用表格列举如下:
     * <table border=1>
     * <caption>Option - OptionStatus 对照表</caption>
     * <tr>
     *     <th></th>
     *     <th>NAME_TAG_VISIBILITY</th>
     *     <th>DEATH_MESSAGE_VISIBILITY</th>
     *     <th>COLLISION_RULE</th>
     * </tr>
     * <tr>
     *     <th>ALWAYS</th>
     *     <td>一直显示玩家名称</td>
     *     <td>一直显示死亡消息</td>
     *     <td>启用碰撞</td>
     * </tr>
     * <tr>
     *     <th>NEVER</th>
     *     <td>对所有玩家隐藏玩家名称</td>
     *     <td>对所有玩家隐藏死亡消息</td>
     *     <td>队内没有玩家可被推动</td>
     * </tr>
     * <tr>
     *     <th>FOR_OTHER_TEAMS</th>
     *     <td>对其它队伍玩家隐藏玩家名称(仅本队能看到)</td>
     *     <td>对其它队伍玩家隐藏死亡消息</td>
     *     <td>仅队内玩家可互相推动</td>
     * </tr>
     * <tr>
     *     <th>FOR_OWN_TEAM</th>
     *     <td>对同队玩家隐藏玩家名称(其他人能看到)</td>
     *     <td>对同队玩家隐藏死亡消息</td>
     *     <td>仅其它队伍玩家可推动本队玩家</td>
     * </tr>
     * </table>
     */
    public enum OptionStatus {

        /**
         * 向所有人应用此选项.
         */
        ALWAYS,
        /**
         * 永不应用此选项.
         */
        NEVER,
        /**
         * 向其它队伍应用选项.
         */
        FOR_OTHER_TEAMS,
        /**
         * 只向当前队伍的成员应用此选项.
         */
        FOR_OWN_TEAM;
    }
}
