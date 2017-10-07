package org.bukkit.event.entity;

import java.util.EnumMap;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.util.NumberConversions;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.ImmutableMap;

/**
 * 储存伤害事件的数据
 * 原文:
 * Stores data for damage events
 */
public class EntityDamageEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private static final DamageModifier[] MODIFIERS = DamageModifier.values();
    private static final Function<? super Double, Double> ZERO = Functions.constant(-0.0);
    private final Map<DamageModifier, Double> modifiers;
    private final Map<DamageModifier, ? extends Function<? super Double, Double>> modifierFunctions;
    private final Map<DamageModifier, Double> originals;
    private boolean cancelled;
    private final DamageCause cause;

    @Deprecated
    public EntityDamageEvent(final Entity damagee, final DamageCause cause, final double damage) {
        this(damagee, cause, new EnumMap<DamageModifier, Double>(ImmutableMap.of(DamageModifier.BASE, damage)), new EnumMap<DamageModifier, Function<? super Double, Double>>(ImmutableMap.of(DamageModifier.BASE, ZERO)));
    }

    public EntityDamageEvent(final Entity damagee, final DamageCause cause, final Map<DamageModifier, Double> modifiers, final Map<DamageModifier, ? extends Function<? super Double, Double>> modifierFunctions) {
        super(damagee);
        Validate.isTrue(modifiers.containsKey(DamageModifier.BASE), "BASE DamageModifier missing");
        Validate.isTrue(!modifiers.containsKey(null), "Cannot have null DamageModifier");
        Validate.noNullElements(modifiers.values(), "Cannot have null modifier values");
        Validate.isTrue(modifiers.keySet().equals(modifierFunctions.keySet()), "Must have a modifier function for each DamageModifier");
        Validate.noNullElements(modifierFunctions.values(), "Cannot have null modifier function");
        this.originals = new EnumMap<DamageModifier, Double>(modifiers);
        this.cause = cause;
        this.modifiers = modifiers;
        this.modifierFunctions = modifierFunctions;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    /**
     * 获取指定伤害类型的原始伤害,作为本次事件的结构定义 ?
     * @param type (DamageModifier) 伤害类型
     * @return 原始伤害
     * @throws IllegalArgumentException 如果参数(DamageModifier)是null时
     * 
     * 原文:
     * Gets the original damage for the specified modifier, as defined at this
     * event's construction.
     *
     * @param type the modifier
     * @return the original damage
     * @throws IllegalArgumentException if type is null
     */
    public double getOriginalDamage(DamageModifier type) throws IllegalArgumentException {
        final Double damage = originals.get(type);
        if (damage != null) {
            return damage;
        }
        if (type == null) {
            throw new IllegalArgumentException("Cannot have null DamageModifier");
        }
        return 0;
    }

    /**
     * 设置指定伤害类型的伤害
     * @param type 伤害类型
     * @param damage 伤害值
     * @see #getFinalDamage()
     * @throws IllegalArgumentException 如果类型是null时
     * @throws UnsupportedOperationException 如果触发该事件的实体不支持该伤害类型,
     *     或者受到修改,当 {@link  #isApplicable(DamageModifier)} 返回false
     * 
     * 原文:
     * Sets the damage for the specified modifier.
     *
     * @param type the damage modifier
     * @param damage the scalar value of the damage's modifier
     * @see #getFinalDamage()
     * @throws IllegalArgumentException if type is null
     * @throws UnsupportedOperationException if the caller does not support
     *     the particular DamageModifier, or to rephrase, when {@link
     *     #isApplicable(DamageModifier)} returns false
     */
    public void setDamage(DamageModifier type, double damage) throws IllegalArgumentException, UnsupportedOperationException {
        if (!modifiers.containsKey(type)) {
            throw type == null ? new IllegalArgumentException("Cannot have null DamageModifier") : new UnsupportedOperationException(type + " is not applicable to " + getEntity());
        }
        modifiers.put(type, damage);
    }

    /**
     * 返回伤害值
     * @param type 伤害类型
     * @return 引起该事件的原始伤害
     * @throws IllegalArgumentException 如果类型是null
     * @see DamageModifier#BASE
     * 原文:
     * Gets the damage change for some modifier
     *
     * @param type the damage modifier
     * @return The raw amount of damage caused by the event
     * @throws IllegalArgumentException if type is null
     * @see DamageModifier#BASE
     */
    public double getDamage(DamageModifier type) throws IllegalArgumentException {
        Validate.notNull(type, "Cannot have null DamageModifier");
        final Double damage = modifiers.get(type);
        return damage == null ? 0 : damage;
    }

    /**
     * 该方法将检查特定的伤害原因是否是本次触发的原因,
     * 例如 {@link #setDamage(DamageModifier, double)}
     * 将不会抛出 {@link UnsupportedOperationException} 异常
     * <p>
     * {@link DamageModifier#BASE} 总是适用的.
     * 
     * @param type 伤害原因
     * @return 当伤害原因与事件触发的原因相同时返回true 反之返回false
     * @throws IllegalArgumentException 如何传入的参数是null时
     * 原文:
     * This checks to see if a particular modifier is valid for this event's
     * caller, such that, {@link #setDamage(DamageModifier, double)} will not
     * throw an {@link UnsupportedOperationException}.
     * <p>
     * {@link DamageModifier#BASE} is always applicable.
     *
     * @param type the modifier
     * @return true if the modifier is supported by the caller, false otherwise
     * @throws IllegalArgumentException if type is null
     */
    public boolean isApplicable(DamageModifier type) throws IllegalArgumentException {
        Validate.notNull(type, "Cannot have null DamageModifier");
        return modifiers.containsKey(type);
    }

    /**
     * 返回本次事件收到伤害的值
     * 
     * @return 一个没有进过别的处理的 伤害值
     * @see DamageModifier#BASE
     * 原文:
     * Gets the raw amount of damage caused by the event
     *
     * @return The raw amount of damage caused by the event
     * @see DamageModifier#BASE
     */
    public double getDamage() {
        return getDamage(DamageModifier.BASE);
    }

    /**
     * 返回此次事件最终的伤害值 (经过护甲等的修改)
     * 
     * @return 此次事件最终的伤害值
     * Gets the amount of damage caused by the event after all damage
     * reduction is applied.
     *
     * @return the amount of damage caused by the event
     */
    public final double getFinalDamage() {
        double damage = 0;
        for (DamageModifier modifier : MODIFIERS) {
            damage += getDamage(modifier);
        }
        return damage;
    }

    /**
     * Sets the raw amount of damage caused by the event.
     * <p>
     * For compatibility this also recalculates the modifiers and scales
     * them by the difference between the modifier for the previous damage
     * value and the new one.
     *
     * @param damage The raw amount of damage caused by the event
     */
    public void setDamage(double damage) {
        // These have to happen in the same order as the server calculates them, keep the enum sorted
        double remaining = damage;
        double oldRemaining = getDamage(DamageModifier.BASE);
        for (DamageModifier modifier : MODIFIERS) {
            if (!isApplicable(modifier)) {
                continue;
            }

            Function<? super Double, Double> modifierFunction = modifierFunctions.get(modifier);
            double newVanilla = modifierFunction.apply(remaining);
            double oldVanilla = modifierFunction.apply(oldRemaining);
            double difference = oldVanilla - newVanilla;

            // Don't allow value to cross zero, assume zero values should be negative
            double old = getDamage(modifier);
            if (old > 0) {
                setDamage(modifier, Math.max(0, old - difference));
            } else {
                setDamage(modifier, Math.min(0, old - difference));
            }
            remaining += newVanilla;
            oldRemaining += oldVanilla;
        }

        setDamage(DamageModifier.BASE, damage);
    }

    /**
     * Gets the cause of the damage.
     *
     * @return A DamageCause value detailing the cause of the damage.
     */
    public DamageCause getCause() {
        return cause;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * An enum to specify the types of modifier
     *
     * @deprecated 这个API被废弃了，具体见后面的网址，很快就要被移除了，就不深入解释了.This API is responsible for a large number of implementation
     * problems and is in general unsustainable to maintain. It is likely to be
     * removed very soon in a subsequent release. Please see
     * https://www.spigotmc.org/threads/194446/ for more information.
     */
    @Deprecated
    public enum DamageModifier {
        /**
         * This represents the amount of damage being done, also known as the
         * raw {@link EntityDamageEvent#getDamage()}.
         */
        BASE,
        /**
         * This represents the damage reduced by a wearing a helmet when hit
         * by a falling block.
         */
        HARD_HAT,
        /**
         * This represents  the damage reduction caused by blocking, only present for
         * {@link Player Players}.
         */
        BLOCKING,
        /**
         * This represents the damage reduction caused by wearing armor.
         */
        ARMOR,
        /**
         * This represents the damage reduction caused by the Resistance potion effect.
         */
        RESISTANCE,
        /**
         * This represents the damage reduction caused by the combination of:
         * <ul>
         * <li>
         *     Armor enchantments
         * </li><li>
         *     Witch's potion resistance
         * </li>
         * </ul>
         */
        MAGIC,
        /**
         * This represents the damage reduction caused by the absorption potion
         * effect.
         */
        ABSORPTION,
        ;
    }

    /**
     * An enum to specify the cause of the damage
     */
    public enum DamageCause {

        /**
         * Damage caused when an entity contacts a block such as a Cactus.
         * <p>
         * Damage: 1 (Cactus)
         */
        CONTACT,
        /**
         * Damage caused when an entity attacks another entity.
         * <p>
         * Damage: variable
         */
        ENTITY_ATTACK,
		/**
         * Damage caused when an entity attacks another entity in a sweep attack.
         * <p>
         * Damage: variable
         */
        ENTITY_SWEEP_ATTACK,
        /**
         * Damage caused when attacked by a projectile.
         * <p>
         * Damage: variable
         */
        PROJECTILE,
        /**
         * Damage caused by being put in a block
         * <p>
         * Damage: 1
         */
        SUFFOCATION,
        /**
         * Damage caused when an entity falls a distance greater than 3 blocks
         * <p>
         * Damage: fall height - 3.0
         */
        FALL,
        /**
         * Damage caused by direct exposure to fire
         * <p>
         * Damage: 1
         */
        FIRE,
        /**
         * Damage caused due to burns caused by fire
         * <p>
         * Damage: 1
         */
        FIRE_TICK,
        /**
         * Damage caused due to a snowman melting
         * <p>
         * Damage: 1
         */
        MELTING,
        /**
         * Damage caused by direct exposure to lava
         * <p>
         * Damage: 4
         */
        LAVA,
        /**
         * Damage caused by running out of air while in water
         * <p>
         * Damage: 2
         */
        DROWNING,
        /**
         * Damage caused by being in the area when a block explodes.
         * <p>
         * Damage: variable
         */
        BLOCK_EXPLOSION,
        /**
         * Damage caused by being in the area when an entity, such as a
         * Creeper, explodes.
         * <p>
         * Damage: variable
         */
        ENTITY_EXPLOSION,
        /**
         * Damage caused by falling into the void
         * <p>
         * Damage: 4 for players
         */
        VOID,
        /**
         * Damage caused by being struck by lightning
         * <p>
         * Damage: 5
         */
        LIGHTNING,
        /**
         * Damage caused by committing suicide using the command "/kill"
         * <p>
         * Damage: 1000
         */
        SUICIDE,
        /**
         * Damage caused by starving due to having an empty hunger bar
         * <p>
         * Damage: 1
         */
        STARVATION,
        /**
         * Damage caused due to an ongoing poison effect
         * <p>
         * Damage: 1
         */
        POISON,
        /**
         * Damage caused by being hit by a damage potion or spell
         * <p>
         * Damage: variable
         */
        MAGIC,
        /**
         * Damage caused by Wither potion effect
         */
        WITHER,
        /**
         * Damage caused by being hit by a falling block which deals damage
         * <p>
         * <b>Note:</b> Not every block deals damage
         * <p>
         * Damage: variable
         */
        FALLING_BLOCK,
        /**
         * Damage caused in retaliation to another attack by the Thorns
         * enchantment.
         * <p>
         * Damage: 1-4 (Thorns)
         */
        THORNS,
        /**
         * Damage caused by a dragon breathing fire.
         * <p>
         * Damage: variable
         */
        DRAGON_BREATH,
        /**
         * Custom damage.
         * <p>
         * Damage: variable
         */
        CUSTOM,
        /**
         * Damage caused when an entity runs into a wall.
         * <p>
         * Damage: variable
         */
        FLY_INTO_WALL,
        /**
         * Damage caused when an entity steps on {@link Material#MAGMA}.
         * <p>
         * Damage: 1
         */
        HOT_FLOOR,
        /**
         * Damage caused when an entity is colliding with too many entities due
         * to the maxEntityCramming game rule.
         * <p>
         * Damage: 6
         */
        CRAMMING
    }
}
