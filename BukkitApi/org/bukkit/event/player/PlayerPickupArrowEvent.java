package org.bukkit.event.player;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

/**
 * 当玩家从地上捡起箭时触发本事件.
 */
public class PlayerPickupArrowEvent extends PlayerPickupItemEvent {

    private final Arrow arrow;

    public PlayerPickupArrowEvent(final Player player, final Item item, final Arrow arrow) {
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
    public Arrow getArrow() {
        return arrow;
    }
}