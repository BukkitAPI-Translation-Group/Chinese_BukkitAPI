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
     * 获取该抛射物的发射者.
     * <p>
     * 原文:Retrieve the shooter of this projectile.
     *
     * @return 发射该抛射物的 {@link ProjectileSource}
     */
    @Nullable
    public ProjectileSource getShooter();

    /**
     * 设置该抛射物的发射者.
     * <p>
     * 原文:Set the shooter of this projectile.
     *
     * @param source 发射该抛射物的 {@link ProjectileSource}
     */
    public void setShooter(@Nullable ProjectileSource source);

    /**
     * 判断该抛射物在击中物体时是否应该弹跳.
     * <p>
     * 如果一个小型火球不弹跳,则会使目标着火.
     * <p>
     * 原文:Determine if this projectile should bounce or not when it hits.
     * <p>
     * If a small fireball does not bounce it will set the target on fire.
     *
     * @return 如果应该弹跳，则返回true。
     * @deprecated 不起任何作用
     */
    @Deprecated
    public boolean doesBounce();

    /**
     * 设置该抛射物在击中物体时是否应该弹跳.
     * <p>
     * 原文:Set whether or not this projectile should bounce or not when it hits
     * something.
     *
     * @param doesBounce 是否应该弹跳
     * @deprecated 不起任何作用
     */
    @Deprecated
    public void setBounce(boolean doesBounce);
}
