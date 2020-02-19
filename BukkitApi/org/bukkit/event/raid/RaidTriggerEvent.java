package org.bukkit.event.raid;

import org.bukkit.Raid;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当袭击被触发时触发本事件 (例如:带有不祥之兆效果的玩家进入村庄).
 */
public class RaidTriggerEvent extends RaidEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    //
    private final Player player;
    private boolean cancel;

    public RaidTriggerEvent(@NotNull Raid raid, @NotNull World world, @NotNull Player player) {
        super(raid, world);
        this.player = player;
    }

    /**
     * 返回触发此袭击的玩家.
     * <p>
     * 原文:Returns the player who triggered the raid.
     *
     * @return 触发此袭击的玩家
     */
    @NotNull
    public Player getPlayer() {
        return player;
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
