package org.bukkit.scoreboard;

import org.bukkit.OfflinePlayer;

/**
 * 
 * 计分板对象: 显示特定条目分数.
 * <p>
 * 该对象仅显示关联项目.{@link #getScoreboard() scoreboard}.
 * <p>
 * 原文:An objective on a scoreboard that can show scores specific to entries. This
 * objective is only relevant to the display of the associated {@link
 * #getScoreboard() scoreboard}.
 * 
 */
public interface Objective {

    /**
     * 获取对象名称.
     *<p>
     * @return 对象名称
     * @throws IllegalStateException 对象已被注销
     */
    String getName() throws IllegalStateException;

    /**
     * 获取对象内用于显示的名称.
     *<p>
     * @return 用于显示的名称
     * @throws IllegalStateException 对象已被注销
     */
    String getDisplayName() throws IllegalStateException;

    /**
     * 设置对象内用于显示的名称.
     *<p>
     * @param displayName 用于显示的名称
     * @throws IllegalStateException 对象已被注销
     * @throws IllegalArgumentException 参数displayName（显示名称）为空
     * @throws IllegalArgumentException 参数displayName（显示名称）大于128个字符
     *     characters.
     */
    void setDisplayName(String displayName) throws IllegalStateException, IllegalArgumentException;

    /**
     * 获取对象规则.
     * <p>
     * 原文:Gets the criteria this objective tracks.
     * 
     * @return 对象规则
     * @throws IllegalStateException 对象已被注销
     */
    String getCriteria() throws IllegalStateException;

    /**
     * 获取布尔值:对象分数是否可以被插件直接修改.
     *<p>
     * @return true-可以
     * @throws IllegalStateException 对象已被注销
     * @see Criterias#HEALTH
     */
    boolean isModifiable() throws IllegalStateException;

    /**
     * 获取对象所链接的计分板.
     *<p>
     * @return 所属计分板 或者 null 对象已被注销 {@link #unregister()
     *     unregistered}
     */
    Scoreboard getScoreboard();

    /**
     * 注销对象 {@link Scoreboard scoreboard.}.
     *<p>
     * @throws IllegalStateException 对象已被注销
     */
    void unregister() throws IllegalStateException;

    /**
     * 设置对象显示的计分板位置区域.
     * <p>
     * 原文:Sets this objective to display on the specified slot for the
     * scoreboard, removing it from any other display slot.
     *
     * @param slot 显示的位置区域(null不显示)
     * @throws IllegalStateException 对象已被注销
     */
    void setDisplaySlot(DisplaySlot slot) throws IllegalStateException;

    /**
     * 获取对象显示的计分板位置区域.
     * <p>
     * Gets the display slot this objective is displayed at.
     *
     * @return 对象显示位置区域(null为不显示)
     * @throws IllegalStateException 对象已被注销
     */
    DisplaySlot getDisplaySlot() throws IllegalStateException;

    /**
     * Sets manner in which this objective will be rendered.
     *
     * @param renderType new render type
     * @throws IllegalStateException if this objective has been unregistered
     */
    void setRenderType(RenderType renderType) throws IllegalStateException;

    /**
     * Sets manner in which this objective will be rendered.
     *
     * @return the render type
     * @throws IllegalStateException if this objective has been unregistered
     */
    RenderType getRenderType() throws IllegalStateException;

    /**
     * 获对象内玩分数.
     * <p>
     * 原文:Gets a player's Score for an Objective on this Scoreboard
     *
     * @param player 玩家ID
     * @return 指定对象和玩家的分数
     * @throws IllegalArgumentException 参数player（玩家ID）为空
     * @throws IllegalStateException if this 对象已被注销
     * @deprecated 计分板可以包含非玩家项
     * @see #getScore(String)
     */
    @Deprecated
    Score getScore(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException;

    /**
     * 获取一个对象的计分项目的积分.
     * <p>
     * 原文:Gets an entry's Score for an Objective on this Scoreboard.
     *
     * @param entry 计分项目
     * @return 对象内指定项目的积分
     * @throws IllegalArgumentException 参数entry（项目）为空
     * @throws IllegalStateException 对象已被注销
     */
    Score getScore(String entry) throws IllegalArgumentException, IllegalStateException;
}
