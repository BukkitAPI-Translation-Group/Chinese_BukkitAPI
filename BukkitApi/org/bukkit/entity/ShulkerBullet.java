package org.bukkit.entity;

import org.jetbrains.annotations.Nullable;

public interface ShulkerBullet extends Projectile {

    /**
     * 获取此弹射物的目标.
     *
     * @return 目标实体
     */
    @Nullable
    Entity getTarget();

    /**
     * 设置此弹射物的目标.
     *
     * @param target 要锁定的实体
     */
    void setTarget(@Nullable Entity target);
}
