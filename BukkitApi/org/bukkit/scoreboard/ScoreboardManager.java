package org.bukkit.scoreboard;

import java.lang.ref.WeakReference;

/**
 * 计分板管理
 */
public interface ScoreboardManager {

    /**
     * 获取初始服务器计分板.
     * <p>
     * 该计分板数据保于服务器,受/scoreboard 指令影响,
     * 显示玩家初始计分.
     * <p>
     * @return 初始服务器计分板
     */
    Scoreboard getMainScoreboard();

    /**
     * 获取一个新的计分板，由服务器持续保存监测
     * 可受玩家、插件影响.
     *<p>
     * @return 返回注册的计分板
     * @see WeakReference
     */
    Scoreboard getNewScoreboard();
}
