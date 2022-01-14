package org.bukkit.scoreboard;

import java.util.Set;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 单个计分板.
 */
public interface Scoreboard {

    /**
     * 向计分板注册一个计分项.
     * <p>
     * 原文:Registers an Objective on this Scoreboard
     *
     * @param name 计分项名称
     * @param criteria 计分项的准则
     * @return 注册的计分项实例
     * @throws IllegalArgumentException 若参数 name 为 null
     * @throws IllegalArgumentException 若 name 长度超过 16 个字符
     * (注:此参数在1.18+支持最长32767个字符)
     * @throws IllegalArgumentException 若参数 criteria 为 null
     * @throws IllegalArgumentException 若同名计分项已存在
     * @deprecated 应明确指定计分项的显示名
     */
    @Deprecated
    @NotNull
    Objective registerNewObjective(@NotNull String name, @NotNull String criteria) throws IllegalArgumentException;

    /**
     * 向计分板注册一个计分项.
     * <p>
     * 原文:Registers an Objective on this Scoreboard
     *
     * @param name 计分项名称
     * @param criteria 计分项的准则
     * @param displayName 展示给玩家的计分项显示名称
     * @return 注册的计分项实例
     * @throws IllegalArgumentException 若参数 name 为 null
     * @throws IllegalArgumentException 若 name 长度超过 16 个字符
     * (注:此参数在1.18+支持最长32767个字符)
     * @throws IllegalArgumentException 若参数 criteria 为 null
     * @throws IllegalArgumentException 若参数 displayName 为 null
     * @throws IllegalArgumentException 若 displayName 长度超过 128 个字符
     * @throws IllegalArgumentException 若同名计分项已存在
     */
    @NotNull
    Objective registerNewObjective(@NotNull String name, @NotNull String criteria, @NotNull String displayName) throws IllegalArgumentException;

    /**
     * 向计分板注册一个计分项.
     * <p>
     * 原文:Registers an Objective on this Scoreboard
     *
     * @param name 计分项名称
     * @param criteria 计分项的准则
     * @param displayName 展示给玩家的计分项显示名称
     * @param renderType 计分项的渲染方式
     * @return 注册的计分项实例
     * @throws IllegalArgumentException 若参数 name 为 null
     * @throws IllegalArgumentException 若 name 长度超过 16 个字符
     * (注:此参数在1.18+支持最长32767个字符)
     * @throws IllegalArgumentException 若参数 criteria 为 null
     * @throws IllegalArgumentException 若参数 displayName 为 null
     * @throws IllegalArgumentException 若 displayName 长度超过 128 个字符
     * @throws IllegalArgumentException 若参数 renderType 为 null
     * @throws IllegalArgumentException 若同名计分项已存在
     */
    @NotNull
    Objective registerNewObjective(@NotNull String name, @NotNull String criteria, @NotNull String displayName, @NotNull RenderType renderType) throws IllegalArgumentException;

    /**
     * 根据名称获取计分项.
     * <p>
     * 原文:Gets an Objective on this Scoreboard by name
     *
     * @param name 计分项名称
     * @return 计分项对象, 如果不存在则为 null
     * @throws IllegalArgumentException 若参数 name 为 null
     */
    @Nullable
    Objective getObjective(@NotNull String name) throws IllegalArgumentException;

    /**
     * 获取使用此准则的所有计分项.
     * <p>
     * 原文:Gets all Objectives of a Criteria on the Scoreboard
     *
     * @param criteria 准则
     * @return 使用指定准测的计分项的不可变集合
     * @throws IllegalArgumentException 若参数 criteria 为 null
     */
    @NotNull
    Set<Objective> getObjectivesByCriteria(@NotNull String criteria) throws IllegalArgumentException;

    /**
     * 获取计分板上的所有计分项.
     * <p>
     * 原文:Gets all Objectives on this Scoreboard
     *
     * @return 所有计分项的不可变集合
     */
    @NotNull
    Set<Objective> getObjectives();

    /**
     * 获取计分板展示在指定位置的计分项.
     * <p>
     * 原文:Gets the Objective currently displayed in a DisplaySlot on this
     * Scoreboard
     *
     * @param slot 显示位置
     * @return 此处的计分项, 如果没有则为 null
     * @throws IllegalArgumentException 若参数 slot 为 null
     */
    @Nullable
    Objective getObjective(@NotNull DisplaySlot slot) throws IllegalArgumentException;

    /**
     * 获取某玩家的所有分数记录.
     * <p>
     * 原文:Gets all scores for a player on this Scoreboard
     *
     * @param player the player whose scores are being retrieved
     * @return 该玩家的所有分数记录的不可变集合
     * @throws IllegalArgumentException if player is null
     * @deprecated 计分板可包含非玩家项目
     * @see #getScores(String)
     */
    @Deprecated
    @NotNull
    Set<Score> getScores(@NotNull OfflinePlayer player) throws IllegalArgumentException;

    /**
     * 获取某项目的所有分数记录.
     * <p>
     * 原文:Gets all scores for an entry on this Scoreboard
     *
     * @param entry 项目
     * @return 该项目的所有分数记录的不可变集合
     * @throws IllegalArgumentException 若参数 entry 为 null
     */
    @NotNull
    Set<Score> getScores(@NotNull String entry) throws IllegalArgumentException;

    /**
     * 移除某玩家在此计分板上的所有分数.
     * <p>
     * 原文:Removes all scores for a player on this Scoreboard
     *
     * @param player 清空哪一玩家的分数
     * @throws IllegalArgumentException 若参数 player 为 null
     * @deprecated 计分板可包含非玩家项目
     * @see #resetScores(String)
     */
    @Deprecated
    void resetScores(@NotNull OfflinePlayer player) throws IllegalArgumentException;

    /**
     * 移除某项目在此计分板上的所有分数.
     * <p>
     * 原文:Removes all scores for an entry on this Scoreboard
     *
     * @param entry 清空哪一项目的分数
     * @throws IllegalArgumentException 若参数 entry 为 null
     */
    void resetScores(@NotNull String entry) throws IllegalArgumentException;

    /**
     * 获取玩家所处的队伍.
     * <p>
     * 原文:Gets a player's Team on this Scoreboard
     *
     * @param player 要搜索的玩家
     * @return 玩家所处队伍, 若玩家不在队伍内则为 null
     * @throws IllegalArgumentException 若参数 player 为 null
     * @deprecated 计分板可包含非玩家项目
     * @see #getEntryTeam(String)
     */
    @Deprecated
    @Nullable
    Team getPlayerTeam(@NotNull OfflinePlayer player) throws IllegalArgumentException;

    /**
     * 获取项目所处的队伍.
     * <p>
     * 原文:Gets a entries Team on this Scoreboard
     *
     * @param entry 要搜索的项目
     * @return 项目所处队伍, 若此项目不在队伍内则为 null
     * @throws IllegalArgumentException 若参数 entry 为 null
     */
    @Nullable
    Team getEntryTeam(@NotNull String entry) throws IllegalArgumentException;

    /**
     * 根据名称获取指定队伍.
     * <p>
     * 原文:Gets a Team by name on this Scoreboard
     *
     * @param teamName 队伍名
     * @return 匹配的队伍, 若无此队伍则为 null
     * @throws IllegalArgumentException 若参数 teamName 为 null
     */
    @Nullable
    Team getTeam(@NotNull String teamName) throws IllegalArgumentException;

    /**
     * 获取计分板上的所有队伍.
     * <p>
     * 原文:Gets all teams on this Scoreboard
     *
     * @return 所有队伍的不可变集合
     */
    @NotNull
    Set<Team> getTeams();

    /**
     * 向计分板注册一个队伍.
     * <p>
     * 原文:Registers a Team on this Scoreboard
     *
     * @param name 队伍名
     * @return 注册的队伍
     * @throws IllegalArgumentException 若参数 name 为 null
     * @throws IllegalArgumentException 若同名队伍已存在
     */
    @NotNull
    Team registerNewTeam(@NotNull String name) throws IllegalArgumentException;

    /**
     * 获取计分板跟踪的所有玩家.
     * <p>
     * 原文:Gets all players tracked by this Scoreboard
     *
     * @return 跟踪的所有玩家的不可变集合
     * @deprecated 计分板可包含非玩家项目
     * @see #getEntries()
     */
    @Deprecated
    @NotNull
    Set<OfflinePlayer> getPlayers();

    /**
     * 获取计分板跟踪的所有项目.
     * <p>
     * 原文:Gets all entries tracked by this Scoreboard
     *
     * @return 跟踪的所有项目的不可变集合
     */
    @NotNull
    Set<String> getEntries();

    /**
     * 清空指定位置处的计分项.
     * <p>
     * 原文:Clears any objective in the specified slot.
     *
     * @param slot 计分项位置
     * @throws IllegalArgumentException 若参数 slot 为 null
     */
    void clearSlot(@NotNull DisplaySlot slot) throws IllegalArgumentException;
}
