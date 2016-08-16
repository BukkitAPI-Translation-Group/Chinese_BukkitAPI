package org.bukkit;

import java.util.Map;

import com.google.common.collect.Maps;

public enum Instrument {

    /**
     * 钢琴是一个音符盒的标准乐器。
     * 原文：
     * Piano is the standard instrument for a note block.
     */
    PIANO(0x0),
    /**
     * 当音符盒在一个石类方块的顶部时通常会以低音鼓的形式演奏。
     * 原文：
     * Bass drum is normally played when a note block is on top of a
     * stone-like block
     */
    BASS_DRUM(0x1),
    /**
     * 当音符盒在一个沙类方块的顶部时通常会以小军鼓的形式演奏。
     * 原文：
     * Snare drum is normally played when a note block is on top of a sandy
     * block.
     */
    SNARE_DRUM(0x2),
    /**
     * 当音符盒在一个玻璃方块的顶部时通常会以鼓槌的形式演奏。
     * 原文：
     * Sticks are normally played when a note block is on top of a glass
     * block.
     */
    STICKS(0x3),
    /**
     * 当音符盒在一个木类方块的顶部时通常会以低音吉他的形式演奏。
     * 原文：
     * Bass guitar is normally played when a note block is on top of a wooden
     * block.
     */
    BASS_GUITAR(0x4);

    private final byte type;
    private final static Map<Byte, Instrument> BY_DATA = Maps.newHashMap();

    private Instrument(final int type) {
        this.type = (byte) type;
    }

    /**
     * @return 乐器的类型ID。
     * @deprecated 不安全的参数
     */
    @Deprecated
    public byte getType() {
        return this.type;
    }

    /**
     * 根据类型ID获取Instrument对象。
     * 原文：
     * Get an instrument by its type ID.
     *
     * @param type 类型ID
     * @return 相应的Instrument对象
     * @deprecated 不安全的参数
     */
    @Deprecated
    public static Instrument getByType(final byte type) {
        return BY_DATA.get(type);
    }

    static {
        for (Instrument instrument : Instrument.values()) {
            BY_DATA.put(instrument.getType(), instrument);
        }
    }
}