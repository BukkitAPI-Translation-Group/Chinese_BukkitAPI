package org.bukkit.entity;

import org.bukkit.inventory.meta.FireworkMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
     * Set the {@link LivingEntity} to which this firework is attached.
     * <p>
     * When attached to an entity, the firework effect will act as normal but
     * remain positioned on the entity. If the entity {@code LivingEntity#isGliding()
     * is gliding}, then the entity will receive a boost in the direction that
     * they are looking.
     *
     * @param entity the entity to which the firework should be attached, or
     * null to remove the attached entity
     * @return true if the entity could be attached, false if the firework was
     * already detonated
     */
    boolean setAttachedTo(@Nullable LivingEntity entity);

    /**
     * Get the {@link LivingEntity} to which this firework is attached.
     * <p>
     * When attached to an entity, the firework effect will act as normal but
     * remain positioned on the entity. If the entity {@code LivingEntity#isGliding()
     * is gliding}, then the entity will receive a boost in the direction that
     * they are looking.
     *
     * @return the attached entity, or null if none
     */
    @Nullable
    LivingEntity getAttachedTo();

    /**
     * Set the ticks that this firework has been alive. If this value exceeds
     * {@link #getMaxLife()}, the firework will detonate.
     *
     * @param ticks the ticks to set. Must be greater than or equal to 0
     * @return true if the life was set, false if this firework has already detonated
     */
    boolean setLife(int ticks);

    /**
     * Get the ticks that this firework has been alive. When this value reaches
     * {@link #getMaxLife()}, the firework will detonate.
     *
     * @return the life ticks
     */
    int getLife();

    /**
     * Set the time in ticks this firework will exist until it is detonated.
     *
     * @param ticks the ticks to set. Must be greater than 0
     * @return true if the time was set, false if this firework has already detonated
     */
    boolean setMaxLife(int ticks);

    /**
     * Get the time in ticks this firework will exist until it is detonated.
     *
     * @return the maximum life in ticks
     */
    int getMaxLife();

    /**
     * 使烟花尽早爆炸, 像是它的引火线已燃烧殆尽.
     * <p>
     * 原文:Cause this firework to explode at earliest opportunity, as if it has no
     * remaining fuse.
     */
    void detonate();

    /**
     * Check whether or not this firework has detonated.
     *
     * @return true if detonated, false if still in the world
     */
    boolean isDetonated();

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
