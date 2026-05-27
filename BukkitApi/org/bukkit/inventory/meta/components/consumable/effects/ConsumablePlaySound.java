package org.bukkit.inventory.meta.components.consumable.effects;

import org.bukkit.Sound;
import org.jetbrains.annotations.Nullable;

/**
 * 表示物品被消耗时播放的音效。
 */
public interface ConsumablePlaySound extends ConsumableEffect {

    /**
     * 获取物品消耗完成时播放的音效。
     * <p>原文：Gets the sound to play on completion of the item's consumption.
     *
     * @return 音效
     */
    @Nullable
    Sound getSound();

    /**
     * 设置物品消耗完成时播放的音效。
     * <p>原文：Sets the sound to play on completion of the item's consumption.
     *
     * @param sound 音效
     */
    void setSound(@Nullable Sound sound);
}
