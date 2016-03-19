package org.bukkit.event.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;

/**
 * 当玩家点击一个实体时调用此事件.
 */
public class PlayerInteractEntityEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    protected Entity clickedEntity;
    boolean cancelled = false;
    private EquipmentSlot hand;

    public PlayerInteractEntityEvent(final Player who, final Entity clickedEntity) {
        this(who, clickedEntity, EquipmentSlot.HAND);
    }

    public PlayerInteractEntityEvent(final Player who, final Entity clickedEntity, final EquipmentSlot hand) {
        super(who);
        this.clickedEntity = clickedEntity;
        this.hand = hand;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    /**
     * 获取被玩家点击的实体.
     * <p>
     * 原文:Gets the entity that was rightclicked by the player.
     *
     * @return 被玩家点击的实体
     */
    public Entity getRightClicked() {
        return this.clickedEntity;
    }

    /**
     * 用于执行这次交互的手.
     * <p>
     * 原文:The hand used to perform this interaction.
     *
     * @return 用来交互的手
     */
    public EquipmentSlot getHand() {
        return hand;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
