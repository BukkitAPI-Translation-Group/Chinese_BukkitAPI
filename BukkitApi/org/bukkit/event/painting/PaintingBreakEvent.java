package org.bukkit.event.painting;

import org.bukkit.Warning;
import org.bukkit.entity.Painting;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当画被摧毁时触发.
 *
 * @deprecated 用{@link org.bukkit.event.hanging.HangingBreakByEntityEvent}代替.
 */
@Deprecated
@Warning(reason="This event has been replaced by HangingBreakEvent")
public class PaintingBreakEvent extends PaintingEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final RemoveCause cause;

    public PaintingBreakEvent(final Painting painting, final RemoveCause cause) {
        super(painting);
        this.cause = cause;
    }

    /**
     * 获取画被摧毁的原因.
     * <p>
     * 原文:Gets the cause for the painting's removal
     *
     * @return 画的摧毁原因
     */
    public RemoveCause getCause() {
        return cause;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    /**
     * 指定摧毁原因的枚举.
     */
    public enum RemoveCause {
        /**
         * 被实体摧毁.
         */
        ENTITY,
        /**
         * 被火摧毁.
         */
        FIRE,
        /**
         * 通过放置方块在上面来摧毁.
         */
        OBSTRUCTION,
        /**
         * 被水流摧毁.
         */
        WATER,
        /**
         * 通过破坏背面的方块等摧毁.
         */
        PHYSICS,
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
