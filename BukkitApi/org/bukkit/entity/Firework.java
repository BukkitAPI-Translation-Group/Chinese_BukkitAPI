package org.bukkit.entity;

import org.bukkit.inventory.meta.FireworkMeta;
import org.jetbrains.annotations.NotNull;

/**
 * 烟花火箭实体.
 */
public interface Firework extends Projectile {

    /**
     * 获取烟花火箭元数据的副本.
     * <p>
     * 原文:Get a copy of the fireworks meta
     *
     * @return 烟花火箭元数据的副本
     */
    @NotNull
    FireworkMeta getFireworkMeta();

    /**
     * 为此烟花火箭应用提供的烟花火箭元数据.
     * <p>
     * 原文:Apply the provided meta to the fireworks
     *
     * @param meta 要应用的 FireworkMeta
     */
    void setFireworkMeta(@NotNull FireworkMeta meta);

    /**
     * 使烟花尽早爆炸, 像是它的引火线已燃烧殆尽.
     * <p>
     * 原文:Cause this firework to explode at earliest opportunity, as if it has no
     * remaining fuse.
     */
    void detonate();

    /**
     * 获取此烟花是否以一定角度发射 (比如使用弩).
     *
     * 若此值为false, 烟花将以垂直向上的方向飞行.
     * <p>
     * 原文:Gets if the firework was shot at an angle (i.e. from a crossbow).
     *
     * A firework which was not shot at an angle will fly straight upwards.
     *
     * @return 此烟花是否以一定角度发射
     */
    boolean isShotAtAngle();

    /**
     * 设置此烟花是否以一定角度发射 (比如使用弩).
     *
     * 若设置此值为false, 烟花将以垂直向上的方向飞行.
     * <p>
     * 原文:Sets if the firework was shot at an angle (i.e. from a crossbow).
     *
     * A firework which was not shot at an angle will fly straight upwards.
     *
     * @param shotAtAngle 此烟花是否以一定角度发射
     */
    void setShotAtAngle(boolean shotAtAngle);
}
