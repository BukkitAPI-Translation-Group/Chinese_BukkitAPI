package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 玩家动作事件
 */
public class PlayerAnimationEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final PlayerAnimationType animationType;
    private boolean isCancelled = false;

    /**
     * 创建一个新的玩家动作
     *
     * @param player 玩家
     */
    public PlayerAnimationEvent(final Player player) {
        super(player);

        // 唯一支持的动作类型:
        animationType = PlayerAnimationType.ARM_SWING;
    }

    /**
     * 获得这个动作的类型
     *
     * @return 动作类型
     */
    public PlayerAnimationType getAnimationType() {
        return animationType;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
