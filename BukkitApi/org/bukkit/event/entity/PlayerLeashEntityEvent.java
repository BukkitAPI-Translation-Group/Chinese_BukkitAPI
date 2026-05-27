package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.NotNull;

/**
 * 在玩家将生物拴绳之前立即调用。
 */
public class PlayerLeashEntityEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Entity leashHolder;
    private final Entity entity;
    private boolean cancelled = false;
    private final Player player;
    private final EquipmentSlot hand;

    public PlayerLeashEntityEvent(@NotNull Entity what, @NotNull Entity leashHolder, @NotNull Player leasher, @NotNull EquipmentSlot hand) {
        this.leashHolder = leashHolder;
        this.entity = what;
        this.player = leasher;
        this.hand = hand;
    }

    @Deprecated(since = "1.19.2")
    public PlayerLeashEntityEvent(@NotNull Entity what, @NotNull Entity leashHolder, @NotNull Player leasher) {
        this(what, leashHolder, leasher, EquipmentSlot.HAND);
    }

    /**
     * 返回持有拴绳的实体。
     * <p>
     * 原文：
     * Returns the entity that is holding the leash.
     *
     * @return 拴绳持有者
     */
    @NotNull
    public Entity getLeashHolder() {
        return leashHolder;
    }

    /**
     * 返回被拴绳的实体。
     * <p>
     * 原文：
     * Returns the entity being leashed.
     *
     * @return 实体
     */
    @NotNull
    public Entity getEntity() {
        return entity;
    }

    /**
     * 返回参与此事件的玩家。
     * <p>
     * 原文：
     * Returns the player involved in this event
     *
     * @return 参与此事件的玩家
     */
    @NotNull
    public final Player getPlayer() {
        return player;
    }

    /**
     * 返回玩家用于拴绳实体的手。
     * <p>
     * 原文：
     * Returns the hand used by the player to leash the entity.
     *
     * @return 手
     */
    @NotNull
    public EquipmentSlot getHand() {
        return hand;
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

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}