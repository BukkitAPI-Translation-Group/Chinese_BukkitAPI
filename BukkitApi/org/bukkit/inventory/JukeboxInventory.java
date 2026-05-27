package org.bukkit.inventory;

import org.bukkit.block.Jukebox;
import org.jetbrains.annotations.Nullable;

/**
 * 唱片机物品栏的接口。
 */
public interface JukeboxInventory extends Inventory {

    /**
     * 设置唱片机中的唱片。
     * <p>
     * 这将立即开始播放插入的物品，如果提供的物品为 null 则停止播放。
     *
     * <p>原文：Set the record in the jukebox.
     * <p>This will immediately start playing the inserted item or stop playing if the
     * item provided is null.
     *
     * @param item 新唱片
     */
    void setRecord(@Nullable ItemStack item);

    /**
     * 获取唱片机中的唱片。
     *
     * <p>原文：Get the record in the jukebox.
     *
     * @return 当前唱片
     */
    @Nullable
    ItemStack getRecord();

    @Nullable
    @Override
    public Jukebox getHolder();
}
