package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 玩家动作事件.
 */
public class PlayerAnimationEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final PlayerAnimationType animationType;
    private boolean isCancelled = false;

    @Deprecated
    public PlayerAnimationEvent(@NotNull final Player player) {
        this(player, PlayerAnimationType.ARM_SWING);
    }

    /**
     * 构造一个新的PlayerAnimation事件.
     * <p>
     * 原文:Construct a new PlayerAnimation event
     *
     * @param player 玩家实例
     * @param playerAnimationType 动作类型
     */
    public PlayerAnimationEvent(@NotNull final Player player, @NotNull final PlayerAnimationType playerAnimationType) {
        super(player);
        animationType = playerAnimationType;
    }

    /**
     * 获得此事件中玩家的动作类型.
     * <p>
     * 原文:Get the type of this animation event
     *
     * @return 动作类型
     */
    @NotNull
    public PlayerAnimationType getAnimationType() {
        return animationType;
    }

    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
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