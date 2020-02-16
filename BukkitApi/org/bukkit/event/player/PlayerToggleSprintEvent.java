package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 玩家切换疾跑状态时调用此事件
 */
public class PlayerToggleSprintEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final boolean isSprinting;
    private boolean cancel = false;

    public PlayerToggleSprintEvent(@NotNull final Player player, final boolean isSprinting) {
        super(player);
        this.isSprinting = isSprinting;
    }

    /**
     * 获得玩家目前的疾跑状态(正在疾跑/没有疾跑).
     * <p>
     * Gets whether the player is now sprinting or not.
     *
     * @return 疾跑状态
     */
    public boolean isSprinting() {
        return isSprinting;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
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
