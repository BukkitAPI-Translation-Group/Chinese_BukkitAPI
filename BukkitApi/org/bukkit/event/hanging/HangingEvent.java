package org.bukkit.event.hanging;

import org.bukkit.entity.Hanging;
import org.bukkit.event.Event;

/**
 * 代表与悬挂实体有关的事件.
 * <p>
 * 译注：什么是悬挂实体？比如画，它属于实体，而且可以悬挂，那么我们就成那些实体为悬挂实体。
 */
public abstract class HangingEvent extends Event {
    protected Hanging hanging;

    protected HangingEvent(final Hanging painting) {
        this.hanging = painting;
    }

    /**
     * 获取涉及了这个事件的悬挂实体.
     * <p>
     * 原文：Gets the hanging entity involved in this event.
     *
     * @return 悬挂实体
     */
    public Hanging getEntity() {
        return hanging;
    }
}