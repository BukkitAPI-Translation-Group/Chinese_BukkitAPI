package org.bukkit.event.world;

import org.bukkit.Chunk;
import org.bukkit.event.HandlerList;
import org.bukkit.generator.BlockPopulator;

/**
 * 当一个新的区块填充完毕时抛出.
 * <p>
 * 如果您想要用此事件来填充区块，请参见 {@link BlockPopulator}.
 * <p>
 * 原文:
 * Thrown when a new chunk has finished being populated.
 * <p>
 * If your intent is to populate the chunk using this event, please see {@link
 * BlockPopulator}
 */
public class ChunkPopulateEvent extends ChunkEvent {
    private static final HandlerList handlers = new HandlerList();

    public ChunkPopulateEvent(final Chunk chunk) {
        super(chunk);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}