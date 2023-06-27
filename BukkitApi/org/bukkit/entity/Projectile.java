package org.bukkit.entity;

import org.bukkit.projectiles.ProjectileSource;
import org.jetbrains.annotations.Nullable;

/**
 * 表示可被射击实体的概念
 * <p>
 * 原文：
 * Represents a shootable entity.
 */
public interface Projectile extends Entity {

    /**
     * 检索该抛射物的发射者。
     *
     * @return 发射该抛射物的 {@link ProjectileSource}e
     */
    @Nullable
    public ProjectileSource getShooter();

    /**
     * 设置该抛射物的发射者。
     *
     * @param source 发射该抛射物的 {@link ProjectileSource}
     */
    public void setShooter(@Nullable ProjectileSource source);

    /**
     * 确定该抛射物在击中时是否应该弹跳。
     * <p>
     * 如果一个小型火球不弹跳，则会使目标着火。
     *
     * @return 如果应该弹跳，则返回true。
     */
    public boolean doesBounce();

    /**
     * 设置该抛射物在击中时是否应该弹跳。
     *
     * @param doesBounce 是否应该弹跳。
     */
    public void setBounce(boolean doesBounce);
}
