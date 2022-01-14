package org.bukkit.scoreboard;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * {@link #getObjective() 计分项}跟踪的某条{@link #getEntry() 项目}的单条分数记录.
 * 改变此分数记录不会影响其它的计分项或计分板.
 */
public interface Score {

    /**
     * 获取此分数为哪个玩家而记.
     * <p>
     * 原文:Gets the OfflinePlayer being tracked by this Score
     *
     * @return 分数对应的玩家
     * @see #getEntry()
     * @deprecated 计分板可包含非玩家项目
     */
    @Deprecated
    @NotNull
    OfflinePlayer getPlayer();

    /**
     * 获取此分数为哪个项目而记.
     * <p>
     * 原文:Gets the entry being tracked by this Score
     *
     * @return 分数对应的项目
     */
    @NotNull
    String getEntry();

    /**
     * 获取此分数记录所属的计分项.
     * <p>
     * 原文:Gets the Objective being tracked by this Score
     *
     * @return 所属计分项
     */
    @NotNull
    Objective getObjective();

    /**
     * 获取当前分数.
     * <p>
     * 原文:Gets the current score
     *
     * @return 分数
     * @throws IllegalStateException 若相关的计分项已被注销
     */
    int getScore() throws IllegalStateException;

    /**
     * 设置当前分数.
     * <p>
     * 原文:Sets the current score.
     *
     * @param score 分数
     * @throws IllegalStateException 若相关的计分项已被注销
     */
    void setScore(int score) throws IllegalStateException;

    /**
     * 判断是否曾设置过分数数据.
     * <p>
     * 原文:Shows if this score has been set at any point in time.
     *
     * @return 是否曾设置过分数数据
     * @throws IllegalStateException 若相关的计分项已被注销
     */
    boolean isScoreSet() throws IllegalStateException;

    /**
     * 获取相关计分项所属的计分板.
     * <p>
     * 原文:Gets the scoreboard for the associated objective.
     *
     * @return 相关计分项所属的计分板, 如果计分项已被{@link Objective#unregister() 注销}则为 null
     */
    @Nullable
    Scoreboard getScoreboard();
}
