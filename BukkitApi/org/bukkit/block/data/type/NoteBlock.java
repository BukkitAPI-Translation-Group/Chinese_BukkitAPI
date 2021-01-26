package org.bukkit.block.data.type;

import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.block.data.Powerable;
import org.jetbrains.annotations.NotNull;

/**
 * 'instrument' 为该音符盒被激活时发出的音色.
 * <br>
 * 'note' 为使用该乐器发音时指定的音调.
 */
public interface NoteBlock extends Powerable {

    /**
     * 获取 'instrument' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'instrument' property.
     *
     * @return 属性 'instrument' 的值
     */
    @NotNull
    Instrument getInstrument();

    /**
     * 设置 'instrument' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'instrument' property.
     *
     * @param instrument 新的 'instrument' 属性值
     */
    void setInstrument(@NotNull Instrument instrument);

    /**
     * 获取 'note' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'note' property.
     *
     * @return 属性 'note' 的值
     */
    @NotNull
    Note getNote();

    /**
     * 设置 'note' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'note' property.
     *
     * @param note 新的 'note' 属性值
     */
    void setNote(@NotNull Note note);
}
