package org.bukkit.event.player;

import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家从地上捡起箭时触发本事件.
 */
public class PlayerPickupArrowEvent extends PlayerPickupItemEvent {

    private final AbstractArrow arrow;

    public PlayerPickupArrowEvent(@NotNull final Player player, @NotNull final Item item, @NotNull final AbstractArrow arrow) {
        super(player, item, 0);
        this.arrow = arrow;
    }

    /**
     * 获取玩家捡起的箭.
     * <p>
     * 原文:Get the arrow being picked up by the player
     *
     * @return 被捡起的箭
     */
    @NotNull
    public AbstractArrow getArrow() {
        return arrow;
    }
}