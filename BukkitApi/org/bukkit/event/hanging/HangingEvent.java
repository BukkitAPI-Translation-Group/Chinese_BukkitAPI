package org.bukkit.event.hanging;

import org.bukkit.entity.Hanging;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

/**
 * 代表与悬挂实体有关的事件.
 */
public abstract class HangingEvent extends Event {
    protected Hanging hanging;

    protected HangingEvent(@NotNull final Hanging painting) {
        this.hanging = painting;
    }

    /**
     * 获取涉及了这个事件的悬挂实体.
     * <p>
     * 原文：Gets the hanging entity involved in this event.
     *
     * @return 悬挂实体
     */
    @NotNull
    public Hanging getEntity() {
        return hanging;
    }
}
