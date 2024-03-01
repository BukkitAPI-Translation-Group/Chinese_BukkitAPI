package org.bukkit.boss;

import java.util.List;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface BossBar {

    /**
     * 用于获取该Boss血量条的标题.
     * <p>
     * 原文:Returns the title of this boss bar
     *
     * @return 当前的Boss血条的标题
     */
    @NotNull
    String getTitle();

    /**
     * 设置当前boss血条的标题.
     * <p>
     * 原文:
     * Sets the title of this boss bar
     *
     * @param title 要设置的boss血条的标题.
     */
    void setTitle(@Nullable String title);

    /**
     * 获取这个boss血条的颜色.
     * <p>
     * 原文:Returns the color of this boss bar
     *
     * @return 返回一个BarColor的实例
     */
    @NotNull
    BarColor getColor();

    /**
     * 设置这个Boss血条的颜色.
     * <p>
     * 原文:Sets the color of this boss bar.
     *
     * @param color 要设置的血条颜色
     */
    void setColor(@NotNull BarColor color);

    /**
     * 获取该Boss血条的样式.
     * <p>
     * 原文:Returns the style of this boss bar
     *
     * @return 这个boss血条的样式
     */
    @NotNull
    BarStyle getStyle();

    /**
     * 设置这个boss血条的样式.
     * <p>
     * 原文:Sets the bar style of this boss bar
     *
     * @param style 要设置的boss血条的样式
     */
    void setStyle(@NotNull BarStyle style);

    /**
     * 从该boss血条内移除一个指定的属性.
     * <p>
     * 原文:Remove an existing flag on this boss bar
     *
     * @param flag 一个已有的指定boss血条内属性,参见BarFlag类
     */
    void removeFlag(@NotNull BarFlag flag);

    /**
     * 向该血条添加一个血条属性.
     * <p>
     * 原文:Add an optional flag to this boss bar
     *
     * @param flag 要添加的属性
     */
    void addFlag(@NotNull BarFlag flag);

    /**
     * 获取某个boss血条属性是否在该血条上存在.
     * <p>
     * 原文:Returns whether this boss bar as the passed flag set
     *
     * @param flag 要检查是否存在的属性
     * @return 是否拥有该属性
     */
    boolean hasFlag(@NotNull BarFlag flag);

    /**
     * 设置该血条的进度.请记住,这个参数必须是1.0（最大值）到0.0（血条空）这两个数字之间的.
     * <p>
     * 原文:Sets the progress of the bar. Values should be between 0.0 (empty) and
     * 1.0 (full)
     *
     * @param progress 要设置该血条的进度
     */
    void setProgress(double progress);

    /**
     * 返回该血条的进度（只会返回1.00到0.00之间的数字）.
     * <p>
     * 原文:Returns the progress of the bar between 0.0 and 1.0
     *
     * @return 这个血条的进度 (血条剩下的血量占总血量的比值)
     */
    double getProgress();

    /**
     * 向该boss血条内添加一个玩家（也就是使该玩家能看见这个血条）.
     * <p>
     * 原文:Adds the player to this boss bar causing it to display on their screen.
     *
     * @param player 要添加的玩家
     */
    void addPlayer(@NotNull Player player);

    /**
     * 从一个boss血条内移除某个玩家（就是使指定玩家看不见该BOSS血条）.
     * <p>
     * 原文:Removes the player from this boss bar causing it to be removed from their
     * screen.
     *
     * @param player 要移除的玩家
     */
    void removePlayer(@NotNull Player player);

    /**
     * 从该boss血条内移除所有玩家.
     * <p>
     * 原文:Removes all players from this boss bar
     *
     * @see #removePlayer(Player)
     */
    void removeAll();

    /**
     * 返回所有能看到这个boss血条的玩家.
     * <p>
     * 原文:Returns all players viewing this boss bar
     *
     * @return 一个包含所有能看到这个血条的玩家的List
     */
    @NotNull
    List<Player> getPlayers();

    /**
     * 设置这个boss血条是否可见.
     * <p>
     * 原文:Set if the boss bar is displayed to attached players.
     *
     * @param visible 该血条的可见状态
     */
    void setVisible(boolean visible);

    /**
     * 获取该血条是否可见.
     * <p>
     * 原文:Set if the boss bar is displayed to attached players.
     *
     * @return 可见状态
     */
    boolean isVisible();

    /**
     * 将该boss血条设置为可见状态.
     * <p>
     * 原文:Shows the previously hidden boss bar to all attached players
     * @deprecated 请使用{@link #setVisible(boolean)}
     */
    @Deprecated
    void show();

    /**
     * 从所有能看见的玩家屏幕上隐藏该血条.
     * <p>
     * 原文:Hides this boss bar from all attached players
     * @deprecated 请使用{@link #setVisible(boolean)}
     */
    @Deprecated
    void hide();
}
