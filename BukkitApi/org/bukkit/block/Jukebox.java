package org.bukkit.block;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表唱片机.
 */
public interface Jukebox extends TileState {
    /**
     * 获取插入该唱片机的唱片.
     * <p>
     * 原文:
     * Gets the record inserted into the jukebox.
     *
     * @return 这个唱片物品,如果返回AIR就表示唱片机内无唱片插入
     */
    @NotNull
    public Material getPlaying();

    /**
     * 设置将要播放的唱片.
     * <p>
     * 原文:
     * Sets the record being played.
     *
     * @param record 这个唱片物品,设置为AIR/null则停止播放
     */
    public void setPlaying(@Nullable Material record);

    /**
     * 获取插入该唱片机的唱片 (译注:这是较新版本才有的API, 建议使用getPlaying).
     * <p>
     * 原文:Gets the record item inserted into the jukebox.
     *
     * @return 唱片物品堆副本,如果返回空气物品堆(本方法不会返回null)就表示唱片机内无唱片插入
     */
    @NotNull
    public ItemStack getRecord();

    /**
     * 设置将要播放的唱片 (译注:这是较新版本才有的API, 建议使用setPlaying).
     * <p>
     * 原文:Sets the record being played.
     *
     * @param record 这个唱片物品,设置为AIR/null则停止播放
     */
    public void setRecord(@Nullable ItemStack record);

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
     * 使唱片机停止播放, 但不弹出唱片.
     * <p>
     * 原文:Stops the jukebox playing without ejecting the record.
     */
    public void stopPlaying();

    /**
     * 停止唱片机的播放,并弹出唱片.
     * <p>
     * 如果这个方块不再是一个唱片机,
     * 那么使用本方法将没有任何效果并返回false.
     * <p>
     * 原文:
     * Stops the jukebox playing and ejects the current record.
     * <p>
     * If the block represented by this state is no longer a jukebox, this will
     * do nothing and return false.
     *
     * @return true表示已弹出唱片;false表示唱片机没有播放唱片
     * @throws IllegalStateException 如果方块状态未应用(译注:仅仅是一种表示而未应用到实际的方块上, 一种虚拟状态)
     */
    public boolean eject();
}