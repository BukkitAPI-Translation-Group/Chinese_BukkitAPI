package org.bukkit.event.entity;

import org.bukkit.entity.Entity;

/**
 * 当一个实体造成另外一个实体燃烧时触发该事件.
 * 原文:
 * Called when an entity causes another entity to combust.
 */
public class EntityCombustByEntityEvent extends EntityCombustEvent {
    private final Entity combuster;

    public EntityCombustByEntityEvent(final Entity combuster, final Entity combustee, final int duration) {
        super(combustee, duration);
        this.combuster = combuster;
    }

    /**
     * 返回造成燃烧的实体.
     * 
     * @return 
     * 
     * Get the entity that caused the combustion event.
     *
     * @return 造成燃烧的实体
     */
    public Entity getCombuster() {
        return combuster;
    }
}
