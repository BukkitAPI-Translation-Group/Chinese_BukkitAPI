package org.bukkit.event.entity;

import com.google.common.base.Preconditions;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

/**
 * 当生物实体受到击退时调用。
 */
public class EntityKnockbackEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final KnockbackCause cause;
    private final double force;
    private final Vector rawKnockback;
    private Vector knockback;
    private boolean cancelled;

    public EntityKnockbackEvent(@NotNull final LivingEntity entity, @NotNull final KnockbackCause cause, final double force, @NotNull final Vector rawKnockback, @NotNull final Vector knockback) {
        super(entity);

        this.cause = cause;
        this.force = force;
        this.rawKnockback = rawKnockback;
        this.knockback = knockback;
    }

    @NotNull
    @Override
    public LivingEntity getEntity() {
        return (LivingEntity) entity;
    }

    /**
     * 获取击退的原因。
     * <p>
     * 原文：
     * Gets the cause of the knockback.
     *
     * @return 击退的原因
     */
    @NotNull
    public KnockbackCause getCause() {
        return cause;
    }

    /**
     * 获取击退的原始力度。<br>
     * 此值基于攻击者的 {@link Enchantment#KNOCKBACK} 等级和实体的 {@link Attribute#KNOCKBACK_RESISTANCE} 等因素。
     * <p>
     * 原文：
     * Gets the raw force of the knockback. <br>
     * This value is based on factors such as the {@link Enchantment#KNOCKBACK}
     * level of an attacker and the
     * {@link Attribute#KNOCKBACK_RESISTANCE} of the entity.
     *
     * @return 击退力度
     */
    public double getForce() {
        return force;
    }

    /**
     * 获取将应用于实体的原始击退力度。<br>
     * 此值为只读，对其进行的修改 <b>不会</b> 对最终受到的击退产生任何影响。
     * <p>
     * 原文：
     * Gets the raw knockback force that will be applied to the entity. <br>
     * This value is read-only, changes made to it <b>will not</b> have any
     * effect on the final knockback received.
     *
     * @return 原始击退力度
     * @see #getFinalKnockback()
     */
    @NotNull
    public Vector getKnockback() {
        return rawKnockback.clone();
    }

    /**
     * 获取将应用于实体的最终击退力度。<br>
     * 与 {@link EntityKnockbackEvent#getKnockback()} 不同，此值受实体当前速度以及是否接触地面的影响。
     * <p>
     * <b>注意：</b> 此方法返回副本，必须通过 {@link #setFinalKnockback(Vector)} 应用更改。
     * <p>
     * 原文：
     * Gets the force that will be applied to the entity. <br>
     * In contrast to {@link EntityKnockbackEvent#getKnockback()} this value is
     * affected by the entities current velocity and whether they are touching
     * the ground.
     * <p>
     * <b>Note:</b> this method returns a copy, changes must be applied with
     * {@link #setFinalKnockback(Vector)}.
     *
     * @return 最终击退力度
     */
    @NotNull
    public Vector getFinalKnockback() {
        return knockback.clone();
    }

    /**
     * 设置将应用于实体的击退力度。
     * <p>
     * 原文：
     * Sets the force that will be applied to the entity.
     *
     * @param knockback 要应用的击退力度
     */
    @NotNull
    public void setFinalKnockback(@NotNull Vector knockback) {
        Preconditions.checkArgument(knockback != null, "Knockback cannot be null");

        this.knockback = knockback;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * 指定击退原因的枚举。
     */
    public enum KnockbackCause {

        /**
         * 由非实体伤害造成的击退。
         */
        DAMAGE,
        /**
         * 由攻击实体造成的击退。
         */
        ENTITY_ATTACK,
        /**
         * 由爆炸造成的击退。
         */
        EXPLOSION,
        /**
         * 由目标使用盾牌格挡造成的击退。
         */
        SHIELD_BLOCK,
        /**
         * 由横扫攻击造成的击退。
         */
        SWEEP_ATTACK,
        /**
         * 原因未知的击退。
         */
        UNKNOWN;
    }
}
