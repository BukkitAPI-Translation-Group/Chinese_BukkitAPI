package org.bukkit.projectiles;

import org.bukkit.entity.Projectile;
import org.bukkit.util.Vector;

/**
 * 代表一个有效的弹射源。
 */
public interface ProjectileSource {

    /**
     * 让ProjectileSource弹射一个{@link Projectile}。
     * <p>
     * 原文：Launches a {@link Projectile} from the ProjectileSource.
     *
     * @param <T> Projectile子类
     * @param projectile 要让Projectile弹射的类
     * @return 已弹射的Projectile
     */
    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile);

    /**
     * 让ProjectileSource以一个初始速度弹射{@link Prijectile}。
     * <p>
     * 原文：Launches a {@link Projectile} from the ProjectileSource with an
     * initial velocity.
     *
     * @param <T> Projectile子类
     * @param projectile 要让Projectile弹射的类
     * @param velocity 弹射的速度
     * @return 已弹射的Projectile
     */
    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity);
}