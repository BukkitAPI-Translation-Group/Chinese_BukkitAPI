package org.bukkit.event.painting;

import org.bukkit.Warning;
import org.bukkit.entity.Painting;
import org.bukkit.event.Event;

/**
 * 获取与画相关的事件.
 *
 * @deprecated 用{@link org.bukkit.event.hanging.HangingBreakByEntityEvent}代替.
 */
@Deprecated
@Warning(reason="This event has been replaced by HangingEvent")
public abstract class PaintingEvent extends Event {
    protected Painting painting;

    protected PaintingEvent(final Painting painting) {
        this.painting = painting;
    }

    /**
     * 获取该事件涉及的画.
     * <p>
     * 原文:Gets the painting involved in this event.
     *
     * @return 画
     */
    public Painting getPainting() {
        return painting;
    }
}
