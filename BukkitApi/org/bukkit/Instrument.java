package org.bukkit;

import com.google.common.collect.Maps;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

/**
 * 代表音符盒可以演奏的乐器类型.
 */
public enum Instrument {

    /**
     * 钢琴是音符盒的标准乐器.
     */
    PIANO(0x0, Sound.BLOCK_NOTE_BLOCK_HARP),
    /**
     * 当音符盒在一个石类方块的顶部时通常会以低音鼓的形式演奏.
     */
    BASS_DRUM(0x1, Sound.BLOCK_NOTE_BLOCK_BASEDRUM),
    /**
     * 当音符盒在一个沙类方块的顶部时通常会以小军鼓的形式演奏.
     */
    SNARE_DRUM(0x2, Sound.BLOCK_NOTE_BLOCK_SNARE),
    /**
     * 当音符盒在一个玻璃方块的顶部时通常会以鼓槌的形式演奏.
     */
    STICKS(0x3, Sound.BLOCK_NOTE_BLOCK_HAT),
    /**
     * 当音符盒在一个木类方块的顶部时通常会以低音吉他的形式演奏.
     */
    BASS_GUITAR(0x4, Sound.BLOCK_NOTE_BLOCK_BASS),
    /**
     * 当音符盒在一个黏土方块的顶部时通常会以长笛的形式演奏.
     */
    FLUTE(0x5, Sound.BLOCK_NOTE_BLOCK_FLUTE),
    /**
     * 当音符盒在一个金块的顶部时通常会以钟的形式演奏.
     */
    BELL(0x6, Sound.BLOCK_NOTE_BLOCK_BELL),
    /**
     * 当音符盒在一个羊毛方块的顶部时通常会以吉他的形式演奏.
     */
    GUITAR(0x7, Sound.BLOCK_NOTE_BLOCK_GUITAR),
    /**
     * 当音符盒在一个浮冰的顶部时通常会以管钟的形式演奏.
     */
    CHIME(0x8, Sound.BLOCK_NOTE_BLOCK_CHIME),
    /**
     * 当音符盒在一个骨块的顶部时通常会以木琴的形式演奏.
     */
    XYLOPHONE(0x9, Sound.BLOCK_NOTE_BLOCK_XYLOPHONE),
    /**
     * 当音符盒在一个铁块的顶部时通常会以铁木琴的形式演奏.
     */
    IRON_XYLOPHONE(0xA, Sound.BLOCK_NOTE_BLOCK_IRON_XYLOPHONE),
    /**
     * 当音符盒在一个灵魂沙的顶部时通常会以牛铃的形式演奏.
     */
    COW_BELL(0xB, Sound.BLOCK_NOTE_BLOCK_COW_BELL),
    /**
     * 当音符盒在一个南瓜的顶部时通常会以迪吉里杜管的形式演奏.
     */
    DIDGERIDOO(0xC, Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO),
    /**
     * 当音符盒在一个绿宝石块的顶部时通常会以比特音乐的形式演奏.
     */
    BIT(0xD, Sound.BLOCK_NOTE_BLOCK_BIT),
    /**
     * 当音符盒在一个干草块的顶部时通常会以班卓琴的形式演奏.
     */
    BANJO(0xE, Sound.BLOCK_NOTE_BLOCK_BANJO),
    /**
     * 当音符盒在一个荧石块的顶部时通常会以电子音的形式演奏.
     */
    PLING(0xF, Sound.BLOCK_NOTE_BLOCK_PLING),
    /**
     * 当僵尸头颅在音符盒的顶部时通常会以僵尸音效的形式演奏.
     */
    ZOMBIE(Sound.BLOCK_NOTE_BLOCK_IMITATE_ZOMBIE),
    /**
     * 当骷髅头颅在音符盒的顶部时通常会以骷髅音效的形式演奏.
     */
    SKELETON(Sound.BLOCK_NOTE_BLOCK_IMITATE_SKELETON),
    /**
     * 当苦力怕头颅在音符盒的顶部时通常会以苦力怕音效的形式演奏.
     */
    CREEPER(Sound.BLOCK_NOTE_BLOCK_IMITATE_CREEPER),
    /**
     * 当末影龙头颅在音符盒的顶部时通常会以末影龙音效的形式演奏.
     */
    DRAGON(Sound.BLOCK_NOTE_BLOCK_IMITATE_ENDER_DRAGON),
    /**
     * 当凋灵骷髅头颅在音符盒的顶部时通常会以凋灵骷髅音效的形式演奏.
     */
    WITHER_SKELETON(Sound.BLOCK_NOTE_BLOCK_IMITATE_WITHER_SKELETON),
    /**
     * 当猪灵头颅在音符盒的顶部时通常会以猪灵音效的形式演奏.
     */
    PIGLIN(Sound.BLOCK_NOTE_BLOCK_IMITATE_PIGLIN),
    /**
     * 当具有所需数据的玩家头颅在音符盒的顶部时通常会以自定义音效的形式演奏.
     */
    CUSTOM_HEAD(null);

    private final byte type;
    private final Sound sound;
    private static final Map<Byte, Instrument> BY_DATA = Maps.newHashMap();

    private Instrument(final Sound sound) {
        this(-1, sound);
    }

    private Instrument(final int type, final Sound sound) {
        this.type = (byte) type;
        this.sound = sound;
    }

    /**
     * 获取与此乐器关联的音效.
     * <br>
     * 对于 {@link Instrument#CUSTOM_HEAD} 将返回 null.
     * <p>
     * 原文:
     * Gets the sound associated with this instrument. <br>
     * Will be null for {@link Instrument#CUSTOM_HEAD}
     *
     * @return 音效, 如果不存在则返回 null
     */
    @Nullable
    public Sound getSound() {
        return this.sound;
    }

    /**
     * @return 乐器的类型ID
     * @deprecated 不安全的参数
     */
    @Deprecated(since = "1.6.2")
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
    @Deprecated(since = "1.6.2")
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