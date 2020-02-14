package org.bukkit.event.entity;

import com.google.common.base.Function;
import java.util.Map;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

/**
 * 当一个实体受到另外一个实体伤害时触发该事件
 */
public class EntityDamageByEntityEvent extends EntityDamageEvent {
    private final Entity damager;

    public EntityDamageByEntityEvent(@NotNull final Entity damager, @NotNull final Entity damagee, @NotNull final DamageCause cause, final double damage) {
        super(damagee, cause, damage);
        this.damager = damager;
    }

    public EntityDamageByEntityEvent(@NotNull final Entity damager, @NotNull final Entity damagee, @NotNull final DamageCause cause, @NotNull final Map<DamageModifier, Double> modifiers, @NotNull final Map<DamageModifier, ? extends Function<? super Double, Double>> modifierFunctions) {
        super(damagee, cause, modifiers, modifierFunctions);
        this.damager = damager;
    }


    /**
     * 返回造成这次伤害的实体
     * <p>
     * 原文:
     * Returns the entity that damaged the defender.
     *
     * @return 造成这次伤害的实体
     */
    @NotNull
    public Entity getDamager() {
        return damager;
    }
}