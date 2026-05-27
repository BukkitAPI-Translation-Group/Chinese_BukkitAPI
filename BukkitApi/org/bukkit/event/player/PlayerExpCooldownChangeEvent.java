package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家的经验值冷却时间改变时触发.
 */
public class PlayerExpCooldownChangeEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    private int newCooldown;
    private final ChangeReason reason;

    public PlayerExpCooldownChangeEvent(@NotNull final Player player, int newcooldown, @NotNull ChangeReason reason) {
        super(player);
        this.newCooldown = newcooldown;
        this.reason = reason;
    }

    /**
     * 获取变更原因.
     * <p>
     * 原文：
     * Gets the reason for the change.
     *
     * @return 变更原因
     */
    @NotNull
    public ChangeReason getReason() {
        return reason;
    }

    /**
     * 获取玩家的新冷却时间.
     * <p>
     * 原文：
     * Gets the new cooldown for the player.
     *
     * @return 新冷却时间
     * @see Player#getExpCooldown()
     */
    public int getNewCooldown() {
        return newCooldown;
    }

    /**
     * 设置玩家的新冷却时间.
     * <p>
     * 原文：
     * Sets the new cooldown for the player.
     *
     * @param newCooldown 要设置的新冷却时间
     * @see Player#setExpCooldown(int)
     */
    public void setNewCooldown(int newCooldown) {
        this.newCooldown = newCooldown;
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

    public enum ChangeReason {

        /**
         * 冷却时间由拾取经验球设置.
         */
        PICKUP_ORB,
        /**
         * 冷却时间由插件设置.
         *
         * @see Player#setExpCooldown(int)
         */
        PLUGIN;
    }
}
