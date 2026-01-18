package org.bukkit.inventory.meta;

import org.bukkit.MusicInstrument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表(山羊角)乐器的物品元数据. (译注)
 */
public interface MusicInstrumentMeta extends ItemMeta {

    /**
     * 设置山羊角的乐器类型.
     * <p>
     * 原文:
     * Sets the goat horn's instrument.
     *
     * @param instrument 要设置的乐器
     */
    void setInstrument(@Nullable MusicInstrument instrument);

    /**
     * 获取山羊角的乐器类型.
     * <p>
     * 原文:
     * Gets the instrument of the goat horn.
     *
     * @return 山羊角的乐器类型
     */
    @Nullable
    MusicInstrument getInstrument();

    @Override
    @NotNull
    MusicInstrumentMeta clone();
}