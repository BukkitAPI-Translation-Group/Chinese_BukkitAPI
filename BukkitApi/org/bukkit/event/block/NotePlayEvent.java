package org.bukkit.event.block;

import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 音符盒播放音符的事件【玩家点击/红石触发】
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
     * 获取被使用的 {@link Instrument}.
     *
     * @return Instrument;
     */
    public Instrument getInstrument() {
        return instrument;
    }

    /**
     * 获取被播放过的 {@link Note} .
     *
     * @return Note.
     */
    public Note getNote() {
        return note;
    }

    /**
     * 覆盖被使用过的 {@link Instrument} .
     *
     * @param instrument Instrument. 没有为null.
     */
    public void setInstrument(Instrument instrument) {
        if (instrument != null) {
            this.instrument = instrument;
        }

    }

    /**
     * 覆盖被播放过的{@link Note}.
     *
     * @param note 音符盒. 没有为null.
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
