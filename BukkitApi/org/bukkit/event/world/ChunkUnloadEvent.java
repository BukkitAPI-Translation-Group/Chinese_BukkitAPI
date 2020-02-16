package org.bukkit.event.world;

import org.bukkit.Chunk;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当一个区块被卸载时调用
 */
public class ChunkUnloadEvent extends ChunkEvent {
    private static final HandlerList handlers = new HandlerList();
    private boolean saveChunk;

    public ChunkUnloadEvent(@NotNull final Chunk chunk) {
        this(chunk, true);
    }

    public ChunkUnloadEvent(@NotNull Chunk chunk, boolean save) {
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

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
