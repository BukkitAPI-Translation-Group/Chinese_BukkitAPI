package org.bukkit;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 用于储存一个指定的音符。
 */
public class Note {

    /**
     * 一个包含音调的枚举。
     */
    public enum Tone {
        G(0x1, true),
        A(0x3, true),
        B(0x5, false),
        C(0x6, true),
        D(0x8, true),
        E(0xA, false),
        F(0xB, true);

        private final boolean sharpable;
        private final byte id;

        private static final Map<Byte, Note.Tone> BY_DATA = Maps.newHashMap();
        /** 音调的数量。 原文：The number of tones including sharped tones. */
        public static final byte TONES_COUNT = 12;

        private Tone(int id, boolean sharpable) {
            this.id = (byte) (id % TONES_COUNT);
            this.sharpable = sharpable;
        }

        /**
         * 返回这个音调未升高的ID。
         * <p>
         * 原文：
         * Returns the not sharped id of this tone.
         *
         * @return 这个音调未升高的ID
         * @deprecated 不安全的参数
         */
        @Deprecated(since = "1.6.2")
        public byte getId() {
            return getId(false);
        }

        /**
         * 返回音调ID。这些方法能够返回这个音调升高的ID。如果音调不能升高则会返回这个音调未升高的ID。
         * <p>
         * 原文：
         * Returns the id of this tone. These method allows to return the
         * sharped id of the tone. If the tone couldn't be sharped it always
         * return the not sharped id of this tone.
         *
         * @param sharped 设为true则返回升高的ID
         * @return 这个音调的ID
         * @deprecated 不安全的参数
         */
        @Deprecated(since = "1.6.2")
        public byte getId(boolean sharped) {
            byte id = (byte) (sharped && sharpable ? this.id + 1 : this.id);

            return (byte) (id % TONES_COUNT);
        }

        /**
         * 返回音调是否能被升高。
         * <p>
         * 原文：
         * Returns if this tone could be sharped.
         *
         * @return 音调是否能被升高
         */
        public boolean isSharpable() {
            return sharpable;
        }

        /**
         * 返回这个音调的ID是否为升高音调的ID。
         * <p>
         * 原文：
         * Returns if this tone id is the sharped id of the tone.
         *
         * @param id 音调ID
         * @return 这个音调的ID是否为升高音调的ID
         * @throws IllegalArgumentException 如果音调和半音都没有ID则抛出错误
         * @deprecated 不安全的参数
         */
        @Deprecated(since = "1.6.2")
        public boolean isSharped(byte id) {
            if (id == getId(false)) {
                return false;
            } else if (id == getId(true)) {
                return true;
            } else {
                // The id isn't matching to the tone!
                throw new IllegalArgumentException("The id isn't matching to the tone.");
            }
        }

        /**
         * 返回音调对应的ID，同时返回半音。
         * <p>
         * 原文：
         * Returns the tone to id. Also returning the semitones.
         *
         * @param id 音调的ID
         * @return 音调对应的ID
         * @deprecated 不安全的参数
         */
        @Deprecated(since = "1.6.2")
        @Nullable
        public static Tone getById(byte id) {
            return BY_DATA.get(id);
        }

        static {
            for (Tone tone : values()) {
                int id = tone.id % TONES_COUNT;
                BY_DATA.put((byte) id, tone);

                if (tone.isSharpable()) {
                    id = (id + 1) % TONES_COUNT;
                    BY_DATA.put((byte) id, tone);
                }
            }
        }
    }

    private static final float[] pitchArray = new float[25];
    static {
        for (int i = 0; i <= 24; i++) {
            // See https://minecraft.wiki/w/Note_Block#Notes
            pitchArray[i] = (float) Math.pow(2, (i - 12) / 12f);
        }
    }

    private final byte note;

    /**
     * 构造一个新的note类。
     * <p>
     * 原文：
     * Creates a new note.
     *
     * @param note 内部音符ID。{@link #getId()}会返回这个数值。这个数值必须在区间[0;&nbsp;24]中
     */
    public Note(int note) {
        Preconditions.checkArgument(note >= 0 && note <= 24, "The note value has to be between 0 and 24.");

        this.note = (byte) note;
    }

    /**
     * 构造一个新的note类。
     * <p>
     * 原文：
     * Creates a new note.
     *
     * @param octave 音符处于的八度音阶。必须在0-2间
     * @param tone 在这个八度音阶中的音调。如果八度音阶为2则音调必须为F#
     * @param sharped 设置音调是否升高 (例如F#)
     */
    public Note(int octave, @NotNull Tone tone, boolean sharped) {
        if (sharped && !tone.isSharpable()) {
            tone = Tone.values()[tone.ordinal() + 1];
            sharped = false;
        }
        if (octave < 0 || octave > 2 || (octave == 2 && !(tone == Tone.F && sharped))) {
            throw new IllegalArgumentException("Tone and octave have to be between F#0 and F#2");
        }

        this.note = (byte) (octave * Tone.TONES_COUNT + tone.getId(sharped));
    }

    /**
     * 为一个大调创建一个新的note类，例如A大调。
     * <p>
     * 原文：
     * Creates a new note for a flat tone, such as A-flat.
     *
     * @param octave 音符处于的八度音阶。必须为0或1
     * @param tone 在这个八度音阶中的音调
     * @return 新的note类对象
     */
    @NotNull
    public static Note flat(int octave, @NotNull Tone tone) {
        Preconditions.checkArgument(octave != 2, "Octave cannot be 2 for flats");
        tone = tone == Tone.G ? Tone.F : Tone.values()[tone.ordinal() - 1];
        return new Note(octave, tone, tone.isSharpable());
    }

    /**
     * 为一个升调创建一个note类，例如A升调。
     * <p>
     * 原文：
     * Creates a new note for a sharp tone, such as A-sharp.
     *
     * @param octave 音符处于的八度音阶。必须在0-2间
     * @param tone 在这个八度音阶中的音调。如果八度音阶为2则音调必须为F#
     * @return 新的note类对象
     */
    @NotNull
    public static Note sharp(int octave, @NotNull Tone tone) {
        return new Note(octave, tone, true);
    }

    /**
     * 为一个自然调创建一个note类，例如自然A调。
     * <p>
     * 原文：
     * Creates a new note for a natural tone, such as A-natural.
     *
     * @param octave 音符处于的八度音阶。必须为0或1
     * @param tone 在这个八度音阶中的音调
     * @return 新的note类对象
     */
    @NotNull
    public static Note natural(int octave, @NotNull Tone tone) {
        Preconditions.checkArgument(octave != 2, "Octave cannot be 2 for naturals");
        return new Note(octave, tone, false);
    }

    /**
     * @return 在这个音符之上的半音
     */
    @NotNull
    public Note sharped() {
        Preconditions.checkArgument(note < 24, "This note cannot be sharped because it is the highest known note!");
        return new Note(note + 1);
    }

    /**
     * @return 在这个音符之下的半音
     */
    @NotNull
    public Note flattened() {
        Preconditions.checkArgument(note > 0, "This note cannot be flattened because it is the lowest known note!");
        return new Note(note - 1);
    }

    /**
     * 返回这个音符的内部ID。
     * <p>
     * 原文：
     * Returns the internal id of this note.
     *
     * @return 这个音符的内部ID
     * @deprecated 不安全的参数
     */
    @Deprecated(since = "1.6.2")
    public byte getId() {
        return note;
    }

    /**
     * 返回这个音符的八度音阶。
     * <p>
     * 原文：
     * Returns the octave of this note.
     *
     * @return 这个音符的八度音阶
     */
    public int getOctave() {
        return note / Tone.TONES_COUNT;
    }

    private byte getToneByte() {
        return (byte) (note % Tone.TONES_COUNT);
    }

    /**
     * 返回这个音符的音调。
     * <p>
     * 原文：
     * Returns the tone of this note.
     *
     * @return 这个音符的音调
     */
    @NotNull
    public Tone getTone() {
        return Tone.getById(getToneByte());
    }

    /**
     * 返回音符是否升高。
     * <p>
     * 原文：
     * Returns if this note is sharped.
     *
     * @return 音符是否升高
     */
    public boolean isSharped() {
        byte note = getToneByte();
        return Tone.getById(note).isSharped(note);
    }

    /**
     * Gets the pitch of this note. This is the value used with
     * {@link World#playSound} or the /playsound command.
     *
     * @return the pitch
     */
    public float getPitch() {
        return pitchArray[this.note];
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + note;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Note other = (Note) obj;
        if (note != other.note)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Note{" + getTone().toString() + (isSharped() ? "#" : "") + "}";
    }
}