package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

/**
 * 当一个实体造成另外一个实体燃烧时触发该事件.
 * 原文:
 * Called when an entity causes another entity to combust.
 */
public class EntityCombustByEntityEvent extends EntityCombustEvent {
    private final Entity combuster;

    @Deprecated(since = "1.21")
    public EntityCombustByEntityEvent(@NotNull final Entity combuster, @NotNull final Entity combustee, final int duration) {
        this(combuster, combustee, (float) duration);
    }

    public EntityCombustByEntityEvent(@NotNull final Entity combuster, @NotNull final Entity combustee, final float duration) {
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
    @NotNull
    public Entity getCombuster() {
        return combuster;
    }
}
