package org.bukkit.entity.minecart;

import org.bukkit.entity.Explosive;
import org.bukkit.entity.Minecart;

/**
 * 代表TNT矿车，可以被引爆.
 */
public interface ExplosiveMinecart extends Minecart, Explosive {

    /**
     * 设置此矿车的引信时间（以tick为单位）。
     * <p>
     * 如果将引信时间设置为非零值，将会点燃此爆炸物。
     * <p>
     * 原文：Set the fuse ticks of this minecart.
     *
     * @param ticks 引信时间（以tick为单位）
     */
    public void setFuseTicks(int ticks);

    /**
     * 获取此矿车的引信时间（以tick为单位）。
     * <p>
     * 如果引信时间降为0，矿车将会爆炸。
     * <p>
     * 原文：Get the fuse ticks of this minecart.
     *
     * @return 引信时间（以tick为单位），如果此矿车的引信尚未点燃则返回-1
     */
    public int getFuseTicks();

    /**
     * 获取基于矿车速度计算的爆炸威力增加系数。
     * <p>
     * 原文：Gets the factor by which explosion yield increases based on Minecart speed.
     *
     * @return 增加系数
     */
    public float getExplosionSpeedFactor();

    /**
     * 设置基于矿车速度计算的爆炸威力增加系数。
     * <p>
     * 原文：Sets the factor by which explosion yield increases based on Minecart speed.
     *
     * @param factor 新的系数
     */
    public void setExplosionSpeedFactor(float factor);

    /**
     * 点燃此矿车的引信。
     * <p>
     * 原文：Ignite this minecart's fuse naturally.
     */
    public void ignite();

    /**
     * 检查此矿车的引信是否已被点燃。
     * <p>
     * 原文：Check whether or not this minecart's fuse has been ignited.
     *
     * @return 如果已点燃则为true，否则为false
     */
    public boolean isIgnited();

    /**
     * 立即引爆此矿车，爆炸威力由其当前移动速度决定。
     * <p>
     * 原文：Immediately explode this minecart with the power assumed by its current movement.
     */
    public void explode();

    /**
     * 以指定威力立即引爆此矿车。
     * <p>
     * 原文：Immediately explode this minecart with the given power.
     *
     * @param power 爆炸威力，必须为正数且不能超过5.0
     */
    public void explode(double power);
}