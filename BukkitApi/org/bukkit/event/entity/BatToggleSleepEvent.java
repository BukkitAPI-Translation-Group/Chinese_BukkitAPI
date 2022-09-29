package org.bukkit.event.entity;

import org.bukkit.entity.Bat;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当一只蝙蝠将要睡觉或醒来时触发本事件.
 * <p>
 * 如果本事件被取消, 那么这只蝙蝠将不会切换睡眠状态.
 */
public class BatToggleSleepEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private boolean cancel = false;
    private final boolean awake;

    public BatToggleSleepEvent(@NotNull Bat what, boolean awake) {
        super(what);
        this.awake = awake;
    }

    /**
     * 获取这只蝙蝠是否准备苏醒.
     * <p>
     * 原文:Get whether or not the bat is attempting to awaken.
     *
     * @return 如果准备醒来则为 true, 反之为 false
     */
    public boolean isAwake() {
        return awake;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
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
