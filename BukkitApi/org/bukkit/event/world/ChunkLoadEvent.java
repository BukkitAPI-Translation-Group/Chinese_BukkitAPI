package org.bukkit.event.world;

import org.bukkit.Chunk;
import org.bukkit.event.HandlerList;

/**
 * 当一个区块被加载时调用.
 */
public class ChunkLoadEvent extends ChunkEvent {
    private static final HandlerList handlers = new HandlerList();
    private final boolean newChunk;

    public ChunkLoadEvent(final Chunk chunk, final boolean newChunk) {
        super(chunk);
        this.newChunk = newChunk;
    }

    /**
     * 获取这个区块是否为最近创建的.
     * <p>
     * 请注意,如果这个区块是新的,它将不会在这个时候填充.
     * <p>
     * 原文:
     * Gets if this chunk was newly created or not.
     * <p>
     * Note that if this chunk is new, it will not be populated at this time.
     *
     * @return 如果区块是新的，则为true，否则为false
     */
    public boolean isNewChunk() {
        return newChunk;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}