package org.bukkit.event.entity;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当实体死亡并且有机会复活时触发本事件.
 * 如果实体尚未装备不死图腾, 本事件将以已取消状态触发.
 */
public class EntityResurrectEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    //
    private boolean cancelled;

    private final EquipmentSlot hand;

    public EntityResurrectEvent(@NotNull LivingEntity what, @Nullable EquipmentSlot hand) {
        super(what);
        this.hand = hand;
    }

    @Deprecated
    public EntityResurrectEvent(@NotNull LivingEntity what) {
        this(what, null);
    }

    @NotNull
    @Override
    public LivingEntity getEntity() {
        return (LivingEntity) entity;
    }

    /**
     * Get the hand in which the totem of undying was found, or null if the
     * entity did not have a totem of undying.
     *
     * @return the hand, or null
     */
    @Nullable
    public EquipmentSlot getHand() {
        return hand;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
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
