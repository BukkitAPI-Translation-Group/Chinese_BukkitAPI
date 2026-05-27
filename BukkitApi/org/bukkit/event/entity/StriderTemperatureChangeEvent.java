package org.bukkit.event.entity;

import org.bukkit.entity.Strider;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当 {@link Strider} 因进入或退出其认为温暖的方块而导致温度改变时调用。
 */
public class StriderTemperatureChangeEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final boolean shivering;
    private boolean cancelled;

    public StriderTemperatureChangeEvent(@NotNull Strider what, boolean shivering) {
        super(what);
        this.shivering = shivering;
    }

    @NotNull
    @Override
    public Strider getEntity() {
        return (Strider) entity;
    }

    /**
     * 获取炽足兽的新颤抖状态。
     * <p>
     * 原文：
     * Get the Strider's new shivering state.
     *
     * @return 新的颤抖状态
     */
    public boolean isShivering() {
        return shivering;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    @NotNull
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
