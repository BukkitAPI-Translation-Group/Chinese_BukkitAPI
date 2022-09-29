package org.bukkit.event.entity;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当非玩家实体从一处传送到另一处时触发本事件.
 * <br>
 * 本事件可能因实体自然行为(末影人、潜影贝), 寻路动作(狼), 或者命令(/teleport)而触发.
 */
public class EntityTeleportEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;
    private Location from;
    private Location to;

    public EntityTeleportEvent(@NotNull Entity what, @NotNull Location from, @Nullable Location to) {
        super(what);
        this.from = from;
        this.to = to;
        this.cancel = false;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 获取实体传送起始位置.
     * <p>
     * 原文:Gets the location that this entity moved from
     *
     * @return 传送起始位置
     */
    @NotNull
    public Location getFrom() {
        return from;
    }

    /**
     * 设置实体传送起始位置.
     * <p>
     * 原文:Sets the location that this entity moved from
     *
     * @param from 传送起始位置
     */
    public void setFrom(@NotNull Location from) {
        this.from = from;
    }

    /**
     * 获取实体传送目标位置.
     * <p>
     * 原文:Gets the location that this entity moved to
     *
     * @return 目标位置
     */
    @Nullable
    public Location getTo() {
        return to;
    }

    /**
     * 设置实体传送目标位置.
     * <p>
     * 原文:Sets the location that this entity moved to
     *
     * @param to 目标位置
     */
    public void setTo(@Nullable Location to) {
        this.to = to;
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
