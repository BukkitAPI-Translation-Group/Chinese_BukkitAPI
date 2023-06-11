package org.bukkit;

import com.google.common.collect.Maps;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public enum Instrument {

    /**
     * 钢琴是音符盒的标准乐器。
     */
    PIANO(0x0),
    /**
     * 当音符盒在一个石类方块的顶部时通常会以低音鼓的形式演奏。
     */
    BASS_DRUM(0x1),
    /**
     * 当音符盒在一个沙类方块的顶部时通常会以小军鼓的形式演奏。
     */
    SNARE_DRUM(0x2),
    /**
     * 当音符盒在一个玻璃方块的顶部时通常会以鼓槌的形式演奏。
     */
    STICKS(0x3),
    /**
     * 当音符盒在一个木类方块的顶部时通常会以低音吉他的形式演奏。
     */
    BASS_GUITAR(0x4),
    /**
     * Flute is normally played when a note block is on top of a clay block.
     */
    FLUTE(0x5),
    /**
     * Bell is normally played when a note block is on top of a gold block.
     */
    BELL(0x6),
    /**
     * Guitar is normally played when a note block is on top of a woolen block.
     */
    GUITAR(0x7),
    /**
     * Chime is normally played when a note block is on top of a packed ice
     * block.
     */
    CHIME(0x8),
    /**
     * Xylophone is normally played when a note block is on top of a bone block.
     */
    XYLOPHONE(0x9),
    /**
     * Iron Xylophone is normally played when a note block is on top of a iron block.
     */
    IRON_XYLOPHONE(0xA),
    /**
     * Cow Bell is normally played when a note block is on top of a soul sand block.
     */
    COW_BELL(0xB),
    /**
     * Didgeridoo is normally played when a note block is on top of a pumpkin block.
     */
    DIDGERIDOO(0xC),
    /**
     * Bit is normally played when a note block is on top of a emerald block.
     */
    BIT(0xD),
    /**
     * Banjo is normally played when a note block is on top of a hay block.
     */
    BANJO(0xE),
    /**
     * Pling is normally played when a note block is on top of a glowstone block.
     */
    PLING(0xF),
    /**
     * Zombie is normally played when a Zombie Head is on top of the note block.
     */
    ZOMBIE,
    /**
     * Skeleton is normally played when a Skeleton Head is on top of the note block.
     */
    SKELETON,
    /**
     * Creeper is normally played when a Creeper Head is on top of the note block.
     */
    CREEPER,
    /**
     * Dragon is normally played when a Dragon Head is on top of the note block.
     */
    DRAGON,
    /**
     * Wither Skeleton is normally played when a Wither Skeleton Head is on top of the note block.
     */
    WITHER_SKELETON,
    /**
     * Piglin is normally played when a Piglin Head is on top of the note block.
     */
    PIGLIN,
    /**
     * Custom Sound is normally played when a Player Head with the required data is on top of the note block.
     */
    CUSTOM_HEAD;

    private final byte type;
    private static final Map<Byte, Instrument> BY_DATA = Maps.newHashMap();

    private Instrument() {
        this(-1);
    }

    private Instrument(final int type) {
        this.type = (byte) type;
    }

    /**
     * @return 乐器的类型ID
     * @deprecated 不安全的参数
     */
    @Deprecated
    public byte getType() {
        return this.type;
    }

    /**
     * 根据类型ID获取Instrument对象。
     * <p>
     * 原文：
     * Get an instrument by its type ID.
     *
     * @param type 类型ID
     * @return 相应的Instrument对象
     * @deprecated 不安全的参数
     */
    @Deprecated
    @Nullable
    public static Instrument getByType(final byte type) {
        return BY_DATA.get(type);
    }

    static {
        for (Instrument instrument : Instrument.values()) {
            BY_DATA.put(instrument.getType(), instrument);
        }
    }
}