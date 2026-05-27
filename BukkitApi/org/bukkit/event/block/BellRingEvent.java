package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当钟被敲响时触发.
 */
public class BellRingEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final BlockFace direction;
    private final Entity entity;
    private boolean cancelled;

    public BellRingEvent(@NotNull Block theBlock, @NotNull BlockFace direction, @Nullable Entity entity) {
        super(theBlock);
        this.direction = direction;
        this.entity = entity;
    }

    /**
     * 获取钟被敲响的方向.
     *
     * 原文：
     * Get the direction in which the bell was rung.
     *
     * @return 方向
     */
    @NotNull
    public BlockFace getDirection() {
        return direction;
    }

    /**
     * 获取敲响钟的 {@link Entity}（如果有的话）.
     *
     * 原文：
     * Get the {@link Entity} that rang the bell (if there was one).
     *
     * @return 实体
     */
    @Nullable
    public Entity getEntity() {
        return entity;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
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
