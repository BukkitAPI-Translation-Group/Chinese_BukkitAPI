package org.bukkit.event.world;

import com.google.common.base.Preconditions;
import org.bukkit.GameEvent;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表 Mojang 通用游戏事件.
 *
 * 你应该尽可能地使用 Bukkit 框架提供的其它事件, 此事件在游戏内部主要用于<a href="https://minecraft-zh.gamepedia.com/Sculk_Sensor">Sculk_Sensor</a>.
 * <p>
 * 原文:Represents a generic Mojang game event.
 *
 * Specific Bukkit events should be used where possible, this event is mainly
 * used internally by Sculk sensors.
 */
public class GenericGameEvent extends WorldEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final GameEvent event;
    private final Location location;
    private final Entity entity;
    private int radius;
    private boolean cancelled;

    public GenericGameEvent(@NotNull GameEvent event, @NotNull Location location, @Nullable Entity entity, int radius) {
        super(location.getWorld());
        this.event = event;
        this.location = location;
        this.entity = entity;
        this.radius = radius;
    }

    /**
     * 获取本事件的底层事件.
     * <p>
     * 原文:Get the underlying event.
     *
     * @return 底层事件
     */
    @NotNull
    public GameEvent getEvent() {
        return event;
    }

    /**
     * 获取事件发生所在的位置.
     * <p>
     * 原文:Get the location where the event occurred.
     *
     * @return 事件发生地点
     */
    @NotNull
    public Location getLocation() {
        return location;
    }

    /**
     * 获取触发此事件的实体, 若存在.
     * <p>
     * 原文:Get the entity which triggered this event, if present.
     *
     * @return 触发此事件的实体, 若不存在返回 null
     */
    @Nullable
    public Entity getEntity() {
        return entity;
    }

    /**
     * 获取此事件广播的范围半径.
     * <p>
     * 原文:Get the block radius to which this event will be broadcast.
     *
     * @return 广播范围
     */
    public int getRadius() {
        return radius;
    }

    /**
     * 设置此事件广播的范围半径.
     * <p>
     * 原文:Set the radius to which the event should be broadcast.
     *
     * @param radius 半径, 必须大于或等于 0
     */
    public void setRadius(int radius) {
        Preconditions.checkArgument(radius >= 0, "Radius must be >= 0");
        this.radius = radius;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
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
