package org.bukkit.entity;

/**
 * 代表生物的动作与姿态.
 */
public enum Pose {

    /**
     * 生物普通站立姿态.
     *
     */
    STANDING,
    /**
     * 生物正在滑翔.
     */
    FALL_FLYING,
    /**
     * 生物处于睡梦中...
     */
    SLEEPING,
    /**
     * 生物在游泳.
     */
    SWIMMING,
    /**
     * 生物使用三叉戟在水/雨/雪中激流(快速移动).
     */
    SPIN_ATTACK,
    /**
     * 生物正在潜行.
     */
    SNEAKING,
    /**
     * 生物在跳远/长跳.
     */
    LONG_JUMPING,
    /**
     * 生物死亡倒地.
     */
    DYING;
}
