package org.bukkit.block;

import org.bukkit.Material;

/**
 * 代表一个唱片机(快照).
 */
public interface Jukebox extends BlockState {
    /**
     * 获取唱片机正在播放的唱片.
     * <p>
     * 原文:
     * Gets the record being played.
     *
     * @return 这个唱片物品,如果返回AIR就表示没有在播放
     */
    public Material getPlaying();

    /**
     * 设置正在播放的唱片.
     * <p>
     * 原文:
     * Sets the record being played.
     *
     * @param record 这个唱片物品,设置为AIR/null则为停止播放
     */
    public void setPlaying(Material record);

    /**
     * 检查唱片机是否正在播放唱片.
     * <p>
     * 原文:
     * Checks if the jukebox is playing a record.
     *
     * @return 返回true就表示唱片正在播放
     */
    public boolean isPlaying();

    /**
     * 停止唱片机的播放,并弹出唱片.
     * <p>
     * 如果这个方块不是一个唱片机，
     * 那么使用本方法将没有任何效果并返回false.
     * <p>
     * 原文:
     * Stops the jukebox playing and ejects the current record.
     * <p>
     * If the block represented by this state is no longer a jukebox, this will
     * do nothing and return false.
     *
     * @return true表示已弹出唱片;false表示唱片机没有播放唱片
     * @throws IllegalStateException 如果方块状态未应用(译注:仅仅是一种表示而未应用到实际的方块上)
     */
    public boolean eject();
}