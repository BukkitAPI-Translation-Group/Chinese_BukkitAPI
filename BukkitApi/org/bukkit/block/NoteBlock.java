package org.bukkit.block;

import org.bukkit.Instrument;
import org.bukkit.Note;

/**
 * 代表音符盒.
 */
public interface NoteBlock extends BlockState {

    /**
     * 获取一个音符盒对象.
     * <p>
     * 原文:
     * Gets the note.
     *
     * @return 这个音符盒对象.
     */
    public Note getNote();

    /**
     * 获取一个音符盒对象.
     * <p>
     * 原文:
     * Gets the note.
     *
     * @return 音符盒ID.
     * @deprecated 不安全的参数
     */
    @Deprecated
    public byte getRawNote();

    /**
     * 设置一个音符盒对象.
     * <p>
     * 原文:
     * Set the note.
     *
     * @param note 音符盒对象.
     */
    public void setNote(Note note);

    /**
     * 设置一个音符盒对象.
     * <p>
     * 原文:
     * Set the note.
     *
     * @param note 音符盒ID.
     * @deprecated 不安全的参数
     */
    @Deprecated
    public void setRawNote(byte note);

    /**
     * 尝试让一个方块播放.
     * <p>
     * 如果这个方块不是音符盒,将返回false.
     * <p>
     * 原文:
     * Attempts to play the note at block
     * <p>
     * If the block is no longer a note block, this will return false
     *
     * @return true true表示成功,否则返回false
     */
    public boolean play();

    /**
     * 用任意乐器播放任意音符盒.
     * <p>
     * 原文:
     * Plays an arbitrary note with an arbitrary instrument
     *
     * @param instrument 乐器id
     * @param note 音符盒id
     * @return 成功为true,否则为false
     * @deprecated 不安全的参数
     */
    @Deprecated
    public boolean play(byte instrument, byte note);

    /**
     * 用任意乐器播放任意音符盒.
     * <p>
     * 原文:
     * Plays an arbitrary note with an arbitrary instrument
     *
     * @param instrument 乐器
     * @param note 音符盒
     * @return 成功为true,否则为false
     * @see Instrument Note
     */
    public boolean play(Instrument instrument, Note note);
}