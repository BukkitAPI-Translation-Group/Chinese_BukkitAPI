package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家经验值发生变化时调用此事件.
 */
public class PlayerExpChangeEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private int exp;

    public PlayerExpChangeEvent(@NotNull final Player player, final int expAmount) {
         super(player);
         exp = expAmount;
    }

    /**
     * 获得玩家将要获得的经验.
     * <p>
     * 原文:Get the amount of experience the player will receive
     *
     * @return 将要获得的经验
     */
    public int getAmount() {
        return exp;
    }

    /**
     * 设置玩家将要获得的经验.
     * <p>
     * 原文:Set the amount of experience the player will receive
     *
     * @param amount 设置的经验
     */
    public void setAmount(int amount) {
        exp = amount;
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
