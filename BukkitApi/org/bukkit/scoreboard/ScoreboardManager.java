package org.bukkit.scoreboard;

import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;

/**
 * 计分板管理器.
 */
public interface ScoreboardManager {

    /**
     * 获取服务器控制的主要计分板.
     * <p>
     * 该计分板数据保存于服务器, 受 /scoreboard 命令的影响,
     * 且为显示给玩家的默认计分板.
     * <p>
     * 原文:Gets the primary Scoreboard controlled by the server.
     * <p>
     * This Scoreboard is saved by the server, is affected by the /scoreboard
     * command, and is the scoreboard shown by default to players.
     *
     * @return 服务器默认计分板
     */
    @NotNull
    Scoreboard getMainScoreboard();

    /**
     * 获取一个新的计分板, 其对象由服务器持续跟踪.
     * 只要玩家或插件还持有对这个计分板对象的(强)引用, 此对象就会被持续跟踪.
     * <p>
     * 译注:CraftBukkit 使用弱引用技术管理计分板对象, 若插件或玩家均不再使用此计分板
     * (可以理解为完成使命了), 服务器会在 GC 时清理掉, 不需要开发者手动置空.
     * <p>
     * 原文:Gets a new Scoreboard to be tracked by the server. This scoreboard will
     * be tracked as long as a reference is kept, either by a player or by a
     * plugin.
     *
     * @return 注册的计分板对象
     * @see WeakReference
     */
    @NotNull
    Scoreboard getNewScoreboard();
}
