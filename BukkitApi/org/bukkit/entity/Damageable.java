package org.bukkit.entity;

import org.bukkit.attribute.Attribute;

/**
 * 表示一个有生命值和可以被伤害的实体({@link Entity})。
 */
public interface Damageable extends Entity {
    /**
     * 给予这个实体一定的伤害.。
     * <p>
     * 原文: Deals the given amount of damage to this entity.
     *
     * @param amount 伤害的数量
     */
    void damage(double amount);

    /**
     * 强制某实体伤害这个实体。
     * <p>
     * 原文: Deals the given amount of damage to this entity, 
     * from a specified entity.
     *
     * @param amount 伤害的数量
     * @param source 伤害来源
     */
    void damage(double amount, Entity source);

    /**
     * 获取当前实体的血量，从0到 {@link #getMaxHealth()}，当血量为 0 时为死亡状态.。
     * <p>
     * 原文: Gets the entity's health from 0 to {@link #getMaxHealth()}, 
     * where 0 is dead.
     *
     * @return 玩家血量,范围是0到最大
     */
    double getHealth();

    /**
     * 设置这个实体的血量，范围是 0 到 {@link #getMaxHealth()}，当血量为 0 时为死亡状态。
     * <p>
     * 原文: Sets the entity's health from 0 to 
     * {@link #getMaxHealth()}, where 0 is dead.
     *
     * @param health 新的血量,范围是 0 到最大.
     * @throws IllegalArgumentException Thrown if the health is {@literal < 0 or >}
     *     {@link #getMaxHealth()}
     */
    void setHealth(double health);

    /**
     * 获取这个实体所能拥有的最大血量。
     * <p>
     * 原文: Gets the maximum health this entity has.
     *
     * @return 最大血量
     * @deprecated 请使用 {@link Attribute#GENERIC_MAX_HEALTH}.
     */
    @Deprecated
    double getMaxHealth();

    /**
     * 设置这个实体所能拥有的最大血量。
     * <p>
     * 如果当前血量高于这个值，那么新的血量将会设置为这个值。
     * <p>
     * Tips: 如果实体有血条,比如({@link Player}， {@link EnderDragon}，{@link Wither}， etc...} 也将会有他们相应的血条样式。
     * <p>
     * 原文: Sets the maximum health this entity can have.
     * <p>
     * If the health of the entity is above the value provided it will be set
     * to that value.
     * <p>
     * Note: An entity with a health bar ({@link Player}, {@link EnderDragon},
     * {@link Wither}, etc...} will have their bar scaled accordingly.
     *
     * @param health amount of health to set the maximum to
     * @deprecated 请使用 {@link Attribute#GENERIC_MAX_HEALTH}.
     */
    @Deprecated
    void setMaxHealth(double health);

    /**
     * 重置最大血量为 20。
     * <p>
     * 原文: Resets the max health to the original amount.
     * @deprecated 请使用 {@link Attribute#GENERIC_MAX_HEALTH}.
     */
    @Deprecated
    void resetMaxHealth();
}