package org.bukkit.event.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.entity.EntityUnleashEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.NotNull;

/**
 * 当一个实体被玩家解开拴绳时调用.
 */
public class PlayerUnleashEntityEvent extends EntityUnleashEvent implements Cancellable {

    private boolean cancelled = false;

    private final Player player;
    private final EquipmentSlot hand;

    public PlayerUnleashEntityEvent(@NotNull Entity entity, @NotNull Player player, @NotNull EquipmentSlot hand) {
        super(entity, UnleashReason.PLAYER_UNLEASH);
        this.player = player;
        this.hand = hand;
    }

    @Deprecated(since = "1.19.2")
    public PlayerUnleashEntityEvent(@NotNull Entity entity, @NotNull Player player) {
        this(entity, player, EquipmentSlot.HAND);
    }

    /**
     * 获得解开拴绳的玩家.
     * <p>
     * 原文:Returns the player who is unleashing the entity.
     *
     * @return 玩家
     */
    @NotNull
    public Player getPlayer() {
        return player;
    }

    /**
     * Get the hand used by the player to unleash the entity.
     *
     * @return the hand
     */
    @NotNull
    public EquipmentSlot getHand() {
        return hand;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
