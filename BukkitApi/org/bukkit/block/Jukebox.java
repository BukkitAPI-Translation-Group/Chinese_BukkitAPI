package org.bukkit.block;

import org.bukkit.Material;
import org.bukkit.inventory.BlockInventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.JukeboxInventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表唱片机.
 */
public interface Jukebox extends TileState, BlockInventoryHolder {

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
     * Gets whether or not this jukebox has a record.
     * <p>
     * A jukebox can have a record but not {@link #isPlaying() be playing}
     * if it was stopped with {@link #stopPlaying()} or if a record has
     * finished playing.
     *
     * @return true if this jukebox has a record, false if it the jukebox
     * is empty
     */
    public boolean hasRecord();

    /**
     * 获取插入该唱片机的唱片 (译注:这是较新版本才有的API, 建议使用getPlaying).
     * <p>
     * 原文:Sets the record being played.
     *
     * @return 唱片物品堆副本,如果返回空气物品堆(本方法不会返回null)就表示唱片机内无唱片插入
     */
    @NotNull
    public ItemStack getRecord();

    /**
     * 设置将要播放的唱片, 唱片机将自动播放. (译注:这是较新版本才有的API, 建议使用setPlaying).
     * <p>
     * 原文:Sets the record being played. The jukebox will start playing automatically.
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
     * Starts the jukebox playing if there is a record.
     *
     * @return true if the jukebox had a record and was able to start playing, false
     * if the jukebox was already playing or did not have a record
     */
    public boolean startPlaying();

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

    /**
     * @return inventory
     * @see Container#getInventory()
     */
    @NotNull
    @Override
    JukeboxInventory getInventory();

    /**
     * @return snapshot inventory
     * @see Container#getSnapshotInventory()
     */
    @NotNull
    JukeboxInventory getSnapshotInventory();
}