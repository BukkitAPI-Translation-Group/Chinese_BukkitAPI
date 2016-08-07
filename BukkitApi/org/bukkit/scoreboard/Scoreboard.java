package org.bukkit.scoreboard;

import java.util.Set;

import org.bukkit.OfflinePlayer;

/**
 * 代表计分板.
 * 翻译质量比较糟，一看就是机翻，做个标记。
 */
public interface Scoreboard {

    /**
     * 注册一个新的{@link Objective}在这个计分板中. 
     * <p>
     * 原文：Registers an Objective on this Scoreboard
     * <p>
     * @param name {@link Objective}名称
     * @param criteria {@link Objective}标准
     * @return 这个注册了的{@link Objective}.
     * @throws IllegalArgumentException 如果名字为空
     * @throws IllegalArgumentException 如果标准为空
     * @throws IllegalArgumentException 如果该{@link Objective}名已经存在
     */
    Objective registerNewObjective(String name, String criteria) throws IllegalArgumentException;

    /**
     * 通过{@link Objective}名称得到在这个计分板中对应的{@link Objective}. 
     * <p>
     * 原文：Gets an Objective on this Scoreboard by name
     * <p>
     * @param name {@link Objective}名称
     * @return 返回这个{@link Objective}，假如不存在这个名称的{@link Objective}则返回null
     * @throws IllegalArgumentException 如果名字为空
     */
    Objective getObjective(String name) throws IllegalArgumentException;

    /**
     * 通过{@link Objective}标准来得到在这个计分板中对应的{@link Objective}. 
     * <p>
     * 原文：Gets all Objectives of a Criteria on the Scoreboard.
     * <p>
     * @param criteria 标准
     * @return 计分板中使用该标准的{@link Objective}的set视图.
     */
    Set<Objective> getObjectivesByCriteria(String criteria) throws IllegalArgumentException;

    /**
     * 得到所有的{@link Objective}在该计分板中. 
     * <p>
     * 原文：Gets all Objectives on this Scoreboard.
     * <p>
     * @return 计分板中所有的{@link Objective}的set视图.
     */
    Set<Objective> getObjectives();

    /**
     * 得到该计分板显示在某{@link DisplaySlot}的{@link Objective}. 
     * <p>
     * 原文：Gets the Objective currently displayed in a DisplaySlot on this
     * Scoreboard.
     * <p>
     * @param slot 这个{@link DisplaySlot}
     * @return the 返回显示在这个{@link DisplaySlot}上的{@link Objective}
     * @throws IllegalArgumentException 如果 {@link DisplaySlot} 为null.
     */
    Objective getObjective(DisplaySlot slot) throws IllegalArgumentException;

    /**
     * 得到这个玩家所有的分数在该计分板中. 
     * <p>
     * 原文：Gets all scores for a player on this Scoreboard.
     * <p>
     *
     * @param player 玩家.
     * @return 这个玩家在该计分板中所有分数的set视图.
     * @throws IllegalArgumentException 如果玩家为null.
     * @deprecated Scoreboards can contain entries that aren't players
     * @see #getScores(String)
     */
    @Deprecated
    Set<Score> getScores(OfflinePlayer player) throws IllegalArgumentException;

    /**
     * 获取这个计分板上的所有分数. 
     * <p>
     * 原文：Gets all scores for an entry on this Scoreboard.
     * <p>
     *
     * @param entry the entry whose scores are being retrieved
     * @return 该计分板中所有分数的set视图.
     * @throws IllegalArgumentException if entry is null
     */
    Set<Score> getScores(String entry) throws IllegalArgumentException;

    /**
     * 移除该玩家计分板的的所有分数 (重置). 
     * <p>
     * ywRemoves all scores for a player on this Scoreboard.
     * <p>
     *
     * @param player 玩家
     * @throws IllegalArgumentException 如果玩家为null
     * @deprecated Scoreboards can contain entries that aren't players
     * @see #resetScores(String)
     */
    @Deprecated
    void resetScores(OfflinePlayer player) throws IllegalArgumentException;

    /**
     * 移除这个计分板中所有的分数(重置) .
     * <p>
     * Removes all scores for an entry on this Scoreboard.
     * <p>
     *
     * @param entry the entry to drop all current scores for
     * @throws IllegalArgumentException if entry is null
     */
    void resetScores(String entry) throws IllegalArgumentException;

    /**
     * 获取在这个计分板上的玩家队伍.
     * <p>
     * 原文：Gets a player's Team on this Scoreboard.
     * <p>
     *
     * @param player 玩家
     * @return 玩家队伍,或当玩家没有队伍时返回null.
     * @throws IllegalArgumentException 如果玩家为null
     * @deprecated 记分板可以包含不玩家条目
     * @see #getEntryTeam(String)
     */
    @Deprecated
    Team getPlayerTeam(OfflinePlayer player) throws IllegalArgumentException;

    /**
     * 获取在这个计分板上的项目队伍.
     * <p>
     * 原文:Gets a entries Team on this Scoreboard
     *
     * @param entry 要搜索的项目
     * @return 项目队伍，如果这个项目不在这个队伍则为null
     * @throws IllegalArgumentException 如果参数entry为null
     */
    Team getEntryTeam(String entry) throws IllegalArgumentException;

    /**
     * 得到一个给定名称的队伍在该计分板中. 
     * <p>
     * 原文：Gets a Team by name on this Scoreboard.
     * <p>
     *
     * @param teamName 队伍名字
     * @return 一个队伍,如果找不到匹配的队伍则返回Null。
     * @throws IllegalArgumentException 当队伍名为空
     */
    Team getTeam(String teamName) throws IllegalArgumentException;

    /**
     * 得到这个计分板中所有的队伍. 
     * <p>
     * 原文：Gets all teams on this Scoreboard.
     * <p>
     *
     * @return 所有队伍的set视图.
     */
    Set<Team> getTeams();

    /**
     * 注册一个新的队伍在这个计分板中. 
     * <p>
     * 原文：Registers a Team on this Scoreboard.
     * <p>
     *
     * @param name 队伍名称
     * @return 这个被注册的队伍
     * @throws IllegalArgumentException 如果名称为null
     * @throws IllegalArgumentException 如果该队伍名已经存在.
     */
    Team registerNewTeam(String name) throws IllegalArgumentException;

    /**
     * 获取所有目标玩家追踪信息.
     * <p>
     * Gets all players tracked by this Scoreboard.
     * <p>
     *
     * @return immutable set of all tracked players
     * @deprecated Scoreboards can contain entries that aren't players
     * @see #getEntries()
     */
    @Deprecated
    Set<OfflinePlayer> getPlayers();

    /**
     * Gets all entries tracked by this Scoreboard
     *
     * @return immutable set of all tracked entries
     */
    Set<String> getEntries();

    /**
     * 清除指定的{@link DisplaySlot}位置的{@link Objective}.
     * <p>
     * 原文：Clears any objective in the specified slot.
     *
     * @param slot 位置.
     * @throws IllegalArgumentException 如果slot为null.
     */
    void clearSlot(DisplaySlot slot) throws IllegalArgumentException;
}
