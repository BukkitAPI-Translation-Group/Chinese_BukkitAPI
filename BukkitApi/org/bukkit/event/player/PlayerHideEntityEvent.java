package org.bukkit.event.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当对玩家隐藏可见实体时触发.
 * <br>
 * 此事件仅在实体的可见性状态实际改变时触发.
 * <br>
 * 无论实体是否在追踪范围内，此事件都会触发.
 *
 * @see Player#hideEntity(org.bukkit.plugin.Plugin, org.bukkit.entity.Entity)
 */
public class PlayerHideEntityEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    private final Entity entity;

    public PlayerHideEntityEvent(@NotNull Player who, @NotNull Entity entity) {
        super(who);
        this.entity = entity;
    }

    /**
     * 获取已对玩家隐藏的实体.
     * <p>
     * 原文：
     * Gets the entity which has been hidden from the player.
     *
     * @return 被隐藏的实体
     */
    @NotNull
    public Entity getEntity() {
        return entity;
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
