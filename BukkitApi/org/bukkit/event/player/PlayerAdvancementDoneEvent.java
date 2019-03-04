package org.bukkit.event.player;

import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * 当玩家完成一个进度中所有的标准时触发此事件.
 * <p>
 * 原文: Called when a player has completed all criteria in an advancement.
 */
public class PlayerAdvancementDoneEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    //
    private final Advancement advancement;

    public PlayerAdvancementDoneEvent(Player who, Advancement advancement) {
        super(who);
        this.advancement = advancement;
    }

    /**
     * 获得已完成的进度.
     * <p>
     * 原文: Get the advancement which has been completed.
     *
     * @return 已完成的 {@link Advancement}
     */
    public Advancement getAdvancement() {
        return advancement;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
