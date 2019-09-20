package org.bukkit.entity;

import org.bukkit.util.Vector;

/**
 * 代表一个火球.
 * <p>
 * 原文:
 * Represents a Fireball.
 */
public interface Fireball extends Projectile, Explosive {

    /**
     * 火球以直线飞行, setVelocity(...) 无效果.
     * <p>
     * 原文:
     * Fireballs fly straight and do not take setVelocity(...) well.
     *
     * @param direction 火球的飞行方向
     */
    public void setDirection(Vector direction);

    /**
     * 获得火球的前进方向.
     * <p>
     * 原文:
     * Retrieve the direction this fireball is heading toward
     *
     * @return 方向(向量)
     */
    public Vector getDirection();

}
