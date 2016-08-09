package org.bukkit.event.world;

import org.bukkit.Chunk;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当一个区块被卸载时调用
 */
public class ChunkUnloadEvent extends ChunkEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private boolean saveChunk;

    public ChunkUnloadEvent(final Chunk chunk) {
        this(chunk, true);
    }

    public ChunkUnloadEvent(Chunk chunk, boolean save) {
        super(chunk);
        this.saveChunk = save;
    }

    /**
     * 返回这个区块是否将被保存.
     * <p>
     * 原文:Return whether this chunk will be saved to disk.
     *
     * @return 区块保存状态
     */
    public boolean isSaveChunk() {
        return saveChunk;
    }

    /**
     * 设置这个区块是否将被保存.
     * <p>
     * 原文:Set whether this chunk will be saved to disk.
     *
     * @param saveChunk 区块保存状态
     */
    public void setSaveChunk(boolean saveChunk) {
        this.saveChunk = saveChunk;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
