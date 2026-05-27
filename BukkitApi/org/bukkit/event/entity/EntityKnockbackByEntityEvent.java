package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

/**
 * 当实体受到来自另一个实体的击退时调用。
 */
public class EntityKnockbackByEntityEvent extends EntityKnockbackEvent {

    private final Entity source;

    public EntityKnockbackByEntityEvent(@NotNull final LivingEntity entity, @NotNull final Entity source, @NotNull final KnockbackCause cause, final double force, @NotNull final Vector rawKnockback, @NotNull final Vector knockback) {
        super(entity, cause, force, rawKnockback, knockback);

        this.source = source;
    }

    /**
     * 获取对防御者造成击退的实体。
     * <p>
     * 原文：
     * Get the entity that has caused knockback to the defender.
     *
     * @return 造成击退的实体
     */
    @NotNull
    public Entity getSourceEntity() {
        return source;
    }
}
