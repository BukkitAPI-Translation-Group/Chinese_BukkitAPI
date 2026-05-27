package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当实体 targeting 一个 {@link LivingEntity} 且只能 targeting 生物实体时调用。
 */
public class EntityTargetLivingEntityEvent extends EntityTargetEvent {
    public EntityTargetLivingEntityEvent(@NotNull final Entity entity, @Nullable final LivingEntity target, @Nullable final TargetReason reason) {
        super(entity, target, reason);
    }

    @Override
    @Nullable
    public LivingEntity getTarget() {
        return (LivingEntity) super.getTarget();
    }

    /**
     * 设置你希望生物 targeting 的实体。
     * <p>
     * 可以设置为 null，null 会导致实体没有目标。
     * <p>
     * 必须是 LivingEntity 或 null。
     * <p>
     * 原文：
     * Set the Entity that you want the mob to target.
     * <p>
     * It is possible to be null, null will cause the entity to be
     * target-less.
     * <p>
     * Must be a LivingEntity, or null.
     *
     * @param target 要 targeting 的实体
     */
    @Override
    public void setTarget(@Nullable Entity target) {
        if (target == null || target instanceof LivingEntity) {
            super.setTarget(target);
        }
    }
}
