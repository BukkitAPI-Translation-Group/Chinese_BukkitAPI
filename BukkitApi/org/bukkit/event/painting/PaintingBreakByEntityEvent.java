package org.bukkit.event.painting;

import org.bukkit.Warning;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Painting;

/**
 * 当画被一个实体摧毁时触发.
 *
 * @deprecated 用{@link org.bukkit.event.hanging.HangingBreakByEntityEvent}代替.
 */
@Deprecated
@Warning(reason="This event has been replaced by HangingBreakByEntityEvent")
public class PaintingBreakByEntityEvent extends PaintingBreakEvent {
    private final Entity remover;

    public PaintingBreakByEntityEvent(final Painting painting, final Entity remover) {
        super(painting, RemoveCause.ENTITY);
        this.remover = remover;
    }

    /**
     * 获取摧毁这幅画的实体.
     * <p>
     * 原文:Gets the entity that removed the painting
     *
     * @return 摧毁这幅画的实体
     */
    public Entity getRemover() {
        return remover;
    }
}
