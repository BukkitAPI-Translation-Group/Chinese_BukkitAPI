// mark
package org.bukkit.boss;

import org.bukkit.entity.Player;

import java.util.List;

public interface BossBar {

    /**
     * 用于获取该Boos血量条的标题
     * <p>
     * 原文:Returns the title of this boss bar
     *
     * @return 当前的Boss血条的标题
     */
    String getTitle();

    /**
     * 设置当前boss血条的标题.
     * 比如凋零这个boss的血条标题就叫凋零.
     * <p>
     * 原文:
     * Sets the title of this boss bar
     *
     * @param title 要设置的boss血条的标题.
     */
    void setTitle(String title);

    /**
     * 获取这个boss血条的颜色
     * <p>
     * 原文:Returns the color of this boss bar
     *
     * @return 返回一个BossColor的实例
     */
    BarColor getColor();

    /**
     * 设置这个Boss血条的颜色
     * <p>
     * 原文:Sets the color of this boss bar.
     *
     * @param color 要设置的血条颜色
     */
    void setColor(BarColor color);

    /**
     * 获取该Boss血条的样式
     * <p>
     * 原文:Returns the style of this boss bar
     *
     * @return 这个boss血条的样式
     */
    BarStyle getStyle();

    /**
     * 设置这个boss血条的样式
     * <p>
     * 原文:Sets the bar style of this boss bar
     *
     * @param style 要设置的boss血条的样式
     */
    void setStyle(BarStyle style);

    /**
     * 从该boss血条内移除一个指定的属性
     *
     * @param flag 一个已有的指定boss血条内属性,参见BarFlag类
     */
    void removeFlag(BarFlag flag);

    /**
     * 向该血条添加一个血条属性
     *
     * @param flag 要添加的属性
     */
    void addFlag(BarFlag flag);

    /**
     * 获取某个boss血条属性是否在该血条上存在
     *
     * @param flag 要检查是否存在的属性
     * @return 是否拥有该属性
     */
    boolean hasFlag(BarFlag flag);

    /**
     * 设置该血条的进度.请记住,这个参数必须是1.0（最大值）到0.0（血条空）这两个数字之间的
     *
     * @param progress 要设置该血条的进度
     */
    void setProgress(double progress);

    /**
     * 返回该血条的进度（只会返回1.00到0.00之间的数字）
     *
     * @return 这个血条的进度（怎么解释呢,就是血条剩下的血量占总血量的比值）
     */
    double getProgress();

    /**
     * 向该boss血条内添加一个玩家（也就是使该玩家能看见这个血条）
     *
     * @param player 要添加的玩家
     */
    void addPlayer(Player player);

    /**
     * 从一个boss血条内移除某个玩家（就是使指定玩家看不见该BOSS血条）
     *
     * @param player 要移除的玩家
     */
    void removePlayer(Player player);

    /**
     * 从该boss血条内移除所有玩家
     *
     * @see #removePlayer(Player)
     */
    void removeAll();

    /**
     * 返回所有能看到这个boss血条的玩家
     *
     * @return 一个包含所有能看到这个血条的玩家的List
     */
    List<Player> getPlayers();

    /**
     * 设置这个boss血条是否可见
     *
     * @param visible 该血条的可见状态
     */
    void setVisible(boolean visible);

    /**
     * 获取该血条是否可见
     *
     * @return 可见状态
     */
    boolean isVisible();

    /**
     * 将该boss血条设置为可见状态
     * @deprecated {@link #setVisible(boolean)}
     */
    @Deprecated
    void show();

    /**
     * 从所有能看见的玩家屏幕上隐藏该血条
     * @deprecated {@link #setVisible(boolean)}
     */
    @Deprecated
    void hide();
}
