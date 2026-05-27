package org.bukkit.entity;

import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一个火球.
 */
public interface Fireball extends Projectile, Explosive {

    /**
     * 设置火球飞行的方向.
     * <br>
     * 这是一个便捷方法,它会改变速度方向和加速度方向,同时保持力度不变.
     * <br>
     * <b>注意:</b> 此方法仅使用向量的方向,并会将其归一化(使用副本).
     * <br>
     * <b>特殊情况:</b> 当给定方向为
     * {@link Vector#isZero() 零向量}时,速度和加速度也将被设置为零,且不会保持力度.
     * <p>
     * 原文:Sets the direction the fireball should be flying towards.
     * <br>
     * This is a convenience method, it will change the velocity direction and
     * acceleration direction, while keeping the power the same.
     * <br>
     * <b>Note:</b> This method only uses the direction of the vector and will
     * normalize (a copy of) it.
     * <br>
     * <b>Special Case:</b> When the given direction is
     * {@link Vector#isZero() zero}, the velocity and acceleration will also be
     * set to zero without keeping the power.
     *
     * @param direction 此火球应飞行的方向
     * @see #setVelocity(Vector)
     * @see #setAcceleration(Vector)
     */
    public void setDirection(@NotNull Vector direction);

    /**
     * 获取此火球的飞行方向.
     * 返回的向量不会被归一化.
     * <p>
     * 原文:Retrieve the direction this fireball is heading toward.
     * The returned vector is not normalized.
     *
     * @return 方向
     * @see #getAcceleration()
     * @deprecated 命名不当的方法,返回的是 {@link #getAcceleration()} 的值
     */
    @NotNull
    @Deprecated(since = "1.20.6")
    public Vector getDirection();

    /**
     * 设置火球的加速度.
     *
     * 加速度每 tick 都会被应用到速度上,根据火球的具体类型,会施加一个阻尼/阻力因子,
     * 以防止速度无限增长.
     * <br>
     * <b>注意:</b> 客户端可能不会遵循非默认的加速度力度,因此会导致火球位置预测错误,
     * 造成视觉上的卡顿.
     * <p>
     * 原文:Sets the acceleration of the fireball.
     *
     * The acceleration gets applied to the velocity every tick, depending on
     * the specific type of the fireball a damping / drag factor is applied so
     * that the velocity does not grow into infinity.
     * <br>
     * <b>Note:</b> that the client may not respect non-default acceleration
     * power and will therefore mispredict the location of the fireball, causing
     * visual stutter.
     *
     * @param acceleration 加速度
     */
    void setAcceleration(@NotNull Vector acceleration);

    /**
     * 获取此火球的加速度.
     * <p>
     * 原文:Retrieve the acceleration of this fireball.
     *
     * @return 加速度
     */
    @NotNull
    Vector getAcceleration();
}
