package org.bukkit.block;

import org.bukkit.Material;

/**
 * 代表一个唱片机.
 */
public interface Jukebox extends BlockState {
    /**
     * 获取唱片机正在播放的唱片.
     * <p>
     * 原文:
     * Get the record currently playing
     *
     * @return 这个唱片物品,如果返回AIR就表示唱片及没有在播放
     */
    public Material getPlaying();

    /**
     * 设置正在播放的唱片.
     * <p>
     * 原文:
     * Set the record currently playing
     *
     * @param record 这个唱片物品,设置为AIR/null则为停止播放
     */
    public void setPlaying(Material record);

    /**
     * 检查唱片机是否正在播放唱片.
     * <p>
     * 原文:
     * Check if the jukebox is currently playing a record
     *
     * @return 返回true就表示唱片及正在播放
     */
    public boolean isPlaying();

    /**
     * 停止唱片机的播放,并弹出唱片.
     * <p>
     * 原文:
     * Stop the jukebox playing and eject the current record
     *
     * @return true表示已弹出唱片;false表示唱片机没有播放唱片
     */
    public boolean eject();
}
