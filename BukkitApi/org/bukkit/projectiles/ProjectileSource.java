package org.bukkit.projectiles;

import org.bukkit.entity.Projectile;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一个有效的抛射物发射源。
 */
public interface ProjectileSource {

    /**
     * 让ProjectileSource发射一个{@link Projectile}。
     * <p>
     * 原文：Launches a {@link Projectile} from the ProjectileSource.
     *
     * @param projectile 要让ProjectileSource发射的抛射物类型
     * @return 发射的抛射物实例对象
     */
    @NotNull
    public <T extends Projectile> T launchProjectile(@NotNull Class<? extends T> projectile);

    /**
     * 让ProjectileSource以一个初始速度向量发射{@link Projectile}。
     * <p>
     * 原文：Launches a {@link Projectile} from the ProjectileSource with an
     * initial velocity.
     *
     * @param projectile 要让ProjectileSource发射的抛射物类型
     * @param velocity 抛射物的速度向量
     * @return 发射的抛射物实例对象
     */
    @NotNull
    public <T extends Projectile> T launchProjectile(@NotNull Class<? extends T> projectile, @Nullable Vector velocity);
}
