package org.bukkit.event.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当向玩家显示隐藏实体时触发.
 * <br>
 * 此事件仅在实体的可见性状态实际改变时触发.
 * <br>
 * 无论实体是否在追踪范围内，此事件都会触发.
 *
 * @see Player#showEntity(org.bukkit.plugin.Plugin, org.bukkit.entity.Entity)
 */
public class PlayerShowEntityEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    private final Entity entity;

    public PlayerShowEntityEvent(@NotNull Player who, @NotNull Entity entity) {
        super(who);
        this.entity = entity;
    }

    /**
     * 获取已对玩家显示的实体.
     * <p>
     * 原文：
     * Gets the entity which has been shown to the player.
     *
     * @return 被显示的实体
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
