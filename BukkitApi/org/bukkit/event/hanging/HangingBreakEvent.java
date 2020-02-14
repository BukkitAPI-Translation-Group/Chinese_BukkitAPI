package org.bukkit.event.hanging;

import org.bukkit.entity.Hanging;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当一个悬挂实体被移除时调用.
 */
public class HangingBreakEvent extends HangingEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final HangingBreakEvent.RemoveCause cause;

    public HangingBreakEvent(@NotNull final Hanging hanging, @NotNull final HangingBreakEvent.RemoveCause cause) {
        super(hanging);
        this.cause = cause;
    }

    /**
     * 获取这个悬挂实体被移除的原因.
     * <p>
     * 原文：Gets the cause for the hanging entity's removal
     *
     * @return 这个悬挂实体被移除的原因
     */
    @NotNull
    public HangingBreakEvent.RemoveCause getCause() {
        return cause;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    /**
     * 指定移除原因的一个枚举
     */
    public enum RemoveCause {
        /**
         * 被一个实体移除
         */
        ENTITY,
        /**
         * 因爆炸而移除
         */
        EXPLOSION,
        /**
         * 放置方块时自动脱落
         */
        OBSTRUCTION,
        /**
         * 破坏它背后的方块而自动脱落
         */
        PHYSICS,
        /**
         * 未分类（未知）的移除原因（默认）
         */
        DEFAULT,
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