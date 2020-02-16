package org.bukkit.event.player;

import com.google.common.base.Preconditions;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 玩家移动事件.
 */
public class PlayerMoveEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private Location from;
    private Location to;

    public PlayerMoveEvent(@NotNull final Player player, @NotNull final Location from, @Nullable final Location to) {
        super(player);
        this.from = from;
        this.to = to;
    }

    /**
     * 获取此事件的取消状态. 被取消的事件将不会在服务器上执行，但将仍然传递给其他插件.
     * <p>
     * 如果一个移动或传送事件被取消,玩家将被移动或传送回getFrom()定义的位置。这不会触发此事件.
     * <p>
     * 原文:Gets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins
     * <p>
     * If a move or teleport event is cancelled, the player will be moved or
     * teleported back to the Location as defined by getFrom(). This will not
     * fire an event
     *
     * @return 是否取消了这个事件
     */
    @Override
    public boolean isCancelled() {
        return cancel;
    }

    /**
     * 设置取消状态的事件。被取消的事件不会在服务器执行,但仍将传递给其他插件执行.
     * <p>
     * 如果一个移动或传送事件被取消,玩家将被移动或传送回getFrom()定义的位置。这不会触发此事件.
     * <p>
     * 原文:Sets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins
     * <p>
     * If a move or teleport event is cancelled, the player will be moved or
     * teleported back to the Location as defined by getFrom(). This will not
     * fire an event
     *
     * @param cancel 是否取消这个事件
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 得到玩家发生移动前的位置.
     * <p>
     * 原文:Gets the location this player moved from
     *
     * @return 玩家移动之前的位置
     */
    @NotNull
    public Location getFrom() {
        return from;
    }

    /**
     * 设置玩家将要移动到此位置之前的位置.
     * <p>
     * 原文:Sets the location to mark as where the player moved from
     *
     * @param from 记录玩家移动之前的位置
     */
    public void setFrom(@NotNull Location from) {
        validateLocation(from);
        this.from = from;
    }

    /**
     * 得到玩家移动到的位置.
     * <p>
     * 原文:Gets the location this player moved to
     *
     * @return 玩家移动到的位置
     */
    @Nullable
    public Location getTo() {
        return to;
    }

    /**
     * 设置玩家将要移动的位置.
     * <p>
     * 原文:Sets the location that this player will move to
     *
     * @param to 玩家将要移动到的位置
     */
    public void setTo(@NotNull Location to) {
        validateLocation(to);
        this.to = to;
    }

    private void validateLocation(@NotNull Location loc) {
        Preconditions.checkArgument(loc != null, "Cannot use null location!");
        Preconditions.checkArgument(loc.getWorld() != null, "Cannot use null location with null world!");
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