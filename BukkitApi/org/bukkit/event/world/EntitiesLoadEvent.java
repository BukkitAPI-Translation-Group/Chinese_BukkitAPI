package org.bukkit.event.world;

import java.util.List;
import org.bukkit.Chunk;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当实体将被加载时调用.
 *
 * 事件提供的区块可能尚未加载.
 */
public class EntitiesLoadEvent extends ChunkEvent {

    private static final HandlerList handlers = new HandlerList();
    private final List<Entity> entities;

    public EntitiesLoadEvent(@NotNull Chunk chunk, @NotNull List<Entity> entities) {
        super(chunk);
        this.entities = entities;
    }

    /**
     * 获取被加载的实体.
     * <p>
     * 原文:
     * Get the entities which are being loaded.
     *
     * @return 被加载的实体的不可变列表
     */
    @NotNull
    public List<Entity> getEntities() {
        return entities;
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
