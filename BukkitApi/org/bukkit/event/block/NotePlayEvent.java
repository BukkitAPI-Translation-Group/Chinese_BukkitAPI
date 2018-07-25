package org.bukkit.event.block;

import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 音符盒播放音符的事件[玩家点击/红石触发]
 */
public class NotePlayEvent extends BlockEvent implements Cancellable {

    private static HandlerList handlers = new HandlerList();
    private Instrument instrument;
    private Note note;
    private boolean cancelled = false;

    public NotePlayEvent(Block block, Instrument instrument, Note note) {
        super(block);
        this.instrument = instrument;
        this.note = note;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    /**
     * 获取要播放的音符的乐器({@link Instrument}).
     * <p>
     * 原文：Gets the {@link Instrument} to be used.
     *
     * @return 乐器
     */
    public Instrument getInstrument() {
        return instrument;
    }

    /**
     * 获取要播放的音符({@link Note}).
     * <p>
     * 原文：Gets the {@link Note} to be played.
     *
     * @return 音符
     */
    public Note getNote() {
        return note;
    }

    /**
     * 设置播放音符用的乐器({@link Instrument}).
     * <p>
     * 原文：Overrides the {@link Instrument} to be used.
     *
     * @param instrument 乐器，没有为null.
     * @deprecated 在较新版本的Minecraft(1.13及以上)无效
     */
    @Deprecated
    public void setInstrument(Instrument instrument) {
        if (instrument != null) {
            this.instrument = instrument;
        }

    }

    /**
     * 设置要播放的音符({@link Note}).
     * <p>
     * 原文：Overrides the {@link Note} to be played.
     *
     * @param note 音符，没有为null
     * @deprecated 在较新版本的Minecraft(1.13及以上)无效
     */
    public void setNote(Note note) {
        if (note != null) {
            this.note = note;
        }
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}