package org.bukkit.event.entity;

import org.bukkit.entity.Firework;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当烟花爆炸时触发本事件
 */
public class FireworkExplodeEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;

    public FireworkExplodeEvent(@NotNull final Firework what) {
        super(what);
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    /**
     * 设置此事件的取消状态。如果烟花的爆炸被取消，烟花仍然将被移除，但烟花颗粒不会显示.
     * <p>
     * 原文:Set the cancelled state of this event. If the firework explosion is
     * cancelled, the firework will still be removed, but no particles will be
     * displayed.
     *
     * @param cancel 是否取消事件
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @NotNull
    @Override
    public Firework getEntity() {
        return (Firework) super.getEntity();
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