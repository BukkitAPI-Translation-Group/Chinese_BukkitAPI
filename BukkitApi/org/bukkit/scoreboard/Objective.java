package org.bukkit.scoreboard;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表单个计分板计分项, 可展示特定项目的分数.
 * 此计分项只与{@link #getScoreboard()}获取的计分板相关联.
 */
public interface Objective {

    /**
     * 获取记分项的名称.
     * <p>
     * 原文:Gets the name of this Objective
     *
     * @return 记分项的名称
     * @throws IllegalStateException 若此计分项已被注销
     */
    @NotNull
    String getName() throws IllegalStateException;

    /**
     * 获取此计分项展示给玩家的名称.
     * <p>
     * 原文:Gets the name displayed to players for this objective
     *
     * @return 计分项显示名
     * @throws IllegalStateException 若此计分项已被注销
     */
    @NotNull
    String getDisplayName() throws IllegalStateException;

    /**
     * 设置此计分项展示给玩家的名称.
     * <p>
     * 原文:Sets the name displayed to players for this objective.
     *
     * @param displayName 计分项显示名
     * @throws IllegalStateException 若此计分项已被注销
     * @throws IllegalArgumentException 若参数 displayName 为 null
     * @throws IllegalArgumentException 若 displayName 长度超过 128 个字符
     */
    void setDisplayName(@NotNull String displayName) throws IllegalStateException, IllegalArgumentException;

    /**
     * 获取此计分项跟踪的准则.
     * <p>
     * 原文:Gets the criteria this objective tracks.
     *
     * @return 计分项的准则
     * @throws IllegalStateException 若此计分项已被注销
     */
    @NotNull
    String getCriteria() throws IllegalStateException;

    /**
     * 判断此计分项的分数能否被插件直接修改.
     * <p>
     * 原文:Gets if the objective's scores can be modified directly by a plugin.
     *
     * @return 若可修改则为true
     * @throws IllegalStateException 若此计分项已被注销
     * @see Criterias#HEALTH
     */
    boolean isModifiable() throws IllegalStateException;

    /**
     * 获取此计分项附属的计分板.
     * <p>
     * 原文:Gets the scoreboard to which this objective is attached.
     *
     * @return 所属的计分板, 如果此计分项已被{@link #unregister() 注销}则为 null
     */
    @Nullable
    Scoreboard getScoreboard();

    /**
     * 从这个计分板注销这个计分项.
     * <p>
     * 原文:Unregisters this objective from the {@link Scoreboard scoreboard.}
     *
     * @throws IllegalStateException 若此计分项已被注销
     */
    void unregister() throws IllegalStateException;

    /**
     * 设置此计分项显示在指定位置, 并将其从原位置移除 (就是从A处移到B处的意思).
     * <p>
     * 原文:Sets this objective to display on the specified slot for the
     * scoreboard, removing it from any other display slot.
     *
     * @param slot 显示的位置, null 为不显示/隐藏
     * @throws IllegalStateException 若此计分项已被注销
     */
    void setDisplaySlot(@Nullable DisplaySlot slot) throws IllegalStateException;

    /**
     * 获取此计分项显示的位置.
     * <p>
     * 原文:Gets the display slot this objective is displayed at.
     *
     * @return 显示位置, 若不显示则为 null
     * @throws IllegalStateException 若此计分项已被注销
     */
    @Nullable
    DisplaySlot getDisplaySlot() throws IllegalStateException;

    /**
     * 设置计分项数值的渲染方式.
     * <p>
     * 原文:Sets manner in which this objective will be rendered.
     *
     * @param renderType 渲染方式
     * @throws IllegalStateException 若此计分项已被注销
     */
    void setRenderType(@NotNull RenderType renderType) throws IllegalStateException;

    /**
     * 获取计分项数值的渲染方式.
     * <p>
     * 原文:Sets manner in which this objective will be rendered.
     *
     * @return 渲染方式
     * @throws IllegalStateException 若此计分项已被注销
     */
    @NotNull
    RenderType getRenderType() throws IllegalStateException;

    /**
     * 获取某玩家的分数.
     * <p>
     * 原文:Gets a player's Score for an Objective on this Scoreboard
     *
     * @param player 玩家名
     * @return 指定玩家的分数
     * @throws IllegalArgumentException 若参数 player 为 null
     * @throws IllegalStateException 若此计分项已被注销
     * @see #getScore(String)
     * @deprecated 计分板可包含非玩家项目
     */
    @Deprecated
    @NotNull
    Score getScore(@NotNull OfflinePlayer player) throws IllegalArgumentException, IllegalStateException;

    /**
     * 获取某条项目的分数.
     * <p>
     * 原文:Gets an entry's Score for an Objective on this Scoreboard.
     *
     * @param entry 项目名
     * @return 指定项目的分数
     * @throws IllegalArgumentException 若参数 entry 为 null
     * @throws IllegalStateException 若此计分项已被注销
     * @throws IllegalArgumentException 若 entry 长度超过 32767 个字符
     */
    @NotNull
    Score getScore(@NotNull String entry) throws IllegalArgumentException, IllegalStateException;
}
