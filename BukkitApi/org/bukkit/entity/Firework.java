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
     * 设置此烟花火箭附着的 {@link LivingEntity}.
     * <p>
     * 当附着到实体时, 烟花效果将正常作用但保持在实体位置.
     * 如果实体 {@code LivingEntity#isGliding() 正在滑翔}, 则实体将获得朝向其视线方向的推进力.
     * <p>
     * 原文：Set the {@link LivingEntity} to which this firework is attached.
     * <p>
     * When attached to an entity, the firework effect will act as normal but
     * remain positioned on the entity. If the entity {@code LivingEntity#isGliding()
     * is gliding}, then the entity will receive a boost in the direction that
     * they are looking.
     *
     * @param entity 烟花应附着的实体, 或 null 以移除附着的实体
     * @return 如果实体可以附着则为 true, 如果烟花已经引爆则为 false
     */
    boolean setAttachedTo(@Nullable LivingEntity entity);

    /**
     * 获取此烟花火箭附着的 {@link LivingEntity}.
     * <p>
     * 当附着到实体时, 烟花效果将正常作用但保持在实体位置.
     * 如果实体 {@code LivingEntity#isGliding() 正在滑翔}, 则实体将获得朝向其视线方向的推进力.
     * <p>
     * 原文：Get the {@link LivingEntity} to which this firework is attached.
     * <p>
     * When attached to an entity, the firework effect will act as normal but
     * remain positioned on the entity. If the entity {@code LivingEntity#isGliding()
     * is gliding}, then the entity will receive a boost in the direction that
     * they are looking.
     *
     * @return 附着的实体, 如果没有则为 null
     */
    @Nullable
    LivingEntity getAttachedTo();

    /**
     * 设置此烟花火箭已存活的 tick 数. 如果此值超过 {@link #getMaxLife()}, 烟花将引爆.
     * <p>
     * 原文：Set the ticks that this firework has been alive. If this value exceeds
     * {@link #getMaxLife()}, the firework will detonate.
     *
     * @param ticks 要设置的 tick 数. 必须大于或等于 0
     * @return 如果设置成功则为 true, 如果烟花已经引爆则为 false
     */
    boolean setLife(int ticks);

    /**
     * 获取此烟花火箭已存活的 tick 数. 当此值达到 {@link #getMaxLife()} 时, 烟花将引爆.
     * <p>
     * 原文：Get the ticks that this firework has been alive. When this value reaches
     * {@link #getMaxLife()}, the firework will detonate.
     *
     * @return 存活 tick 数
     */
    int getLife();

    /**
     * 设置此烟花火箭在引爆前存在的时间 (以 tick 为单位).
     * <p>
     * 原文：Set the time in ticks this firework will exist until it is detonated.
     *
     * @param ticks 要设置的 tick 数. 必须大于 0
     * @return 如果设置成功则为 true, 如果烟花已经引爆则为 false
     */
    boolean setMaxLife(int ticks);

    /**
     * 获取此烟花火箭在引爆前存在的时间 (以 tick 为单位).
     * <p>
     * 原文：Get the time in ticks this firework will exist until it is detonated.
     *
     * @return 最大存活时间 (以 tick 为单位)
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
     * 检查此烟花是否已经引爆.
     * <p>
     * 原文：Check whether or not this firework has detonated.
     *
     * @return 如果已引爆则为 true, 如果仍在世界中则为 false
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
