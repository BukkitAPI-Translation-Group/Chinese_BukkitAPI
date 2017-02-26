package org.bukkit.event.hanging;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Hanging;

/**
 * 当一个悬挂实体被一个实体移除时调用本事件
 */
public class HangingBreakByEntityEvent extends HangingBreakEvent {
    private final Entity remover;

    public HangingBreakByEntityEvent(final Hanging hanging, final Entity remover) {
        this(hanging, remover, HangingBreakEvent.RemoveCause.ENTITY);
    }

    public HangingBreakByEntityEvent(final Hanging hanging, final Entity remover, final HangingBreakEvent.RemoveCause cause) {
        super(hanging, cause);
        this.remover = remover;
    }

    /**
     * 获取移除这个悬挂实体的实体.
     * <p>
     * 原文：Gets the entity that removed the hanging entity
     *
     * @return 移除这个悬挂实体的实体
     */
    public Entity getRemover() {
        return remover;
    }
}