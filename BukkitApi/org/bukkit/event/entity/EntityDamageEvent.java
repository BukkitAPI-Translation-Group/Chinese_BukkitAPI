package org.bukkit.event.entity;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import org.bukkit.Material;
import org.bukkit.WorldBorder;
import org.bukkit.damage.DamageSource;
import org.bukkit.damage.DamageType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 储存伤害事件的数据
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
    private final DamageSource damageSource;

    @Deprecated(forRemoval = true)
    public EntityDamageEvent(@NotNull final Entity damagee, @NotNull final DamageCause cause, final double damage) {
        this(damagee, cause, DamageSource.builder(DamageType.GENERIC).build(), damage);
    }

    public EntityDamageEvent(@NotNull final Entity damagee, @NotNull final DamageCause cause, @NotNull final DamageSource damageSource, final double damage) {
        this(damagee, cause, damageSource, new EnumMap<DamageModifier, Double>(ImmutableMap.of(DamageModifier.BASE, damage)), new EnumMap<DamageModifier, Function<? super Double, Double>>(ImmutableMap.of(DamageModifier.BASE, ZERO)));
    }

    @Deprecated(forRemoval = true)
    public EntityDamageEvent(@NotNull final Entity damagee, @NotNull final DamageCause cause, @NotNull final Map<DamageModifier, Double> modifiers, @NotNull final Map<DamageModifier, ? extends Function<? super Double, Double>> modifierFunctions) {
        this(damagee, cause, DamageSource.builder(DamageType.GENERIC).build(), modifiers, modifierFunctions);
    }

    public EntityDamageEvent(@NotNull final Entity damagee, @NotNull final DamageCause cause, @NotNull final DamageSource damageSource, @NotNull final Map<DamageModifier, Double> modifiers, @NotNull final Map<DamageModifier, ? extends Function<? super Double, Double>> modifierFunctions) {
        super(damagee);
        Preconditions.checkArgument(modifiers.containsKey(DamageModifier.BASE), "BASE DamageModifier missing");
        Preconditions.checkArgument(!modifiers.containsKey(null), "Cannot have null DamageModifier");
        Preconditions.checkArgument(modifiers.values().stream().allMatch(Objects::nonNull), "Cannot have null modifier values");
        Preconditions.checkArgument(modifiers.keySet().equals(modifierFunctions.keySet()), "Must have a modifier function for each DamageModifier");
        Preconditions.checkArgument(modifierFunctions.values().stream().allMatch(Objects::nonNull), "Cannot have null modifier function");
        this.originals = new EnumMap<DamageModifier, Double>(modifiers);
        this.cause = cause;
        this.modifiers = modifiers;
        this.modifierFunctions = modifierFunctions;
        this.damageSource = damageSource;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    /**
     * 获取指定伤害类型的原始伤害,作为本次事件的结构定义 .
     * <p>
     * 原文:Gets the original damage for the specified modifier, as defined at this
     * event's construction.
     *
     * @param type (DamageModifier) 伤害类型
     * @return 原始伤害
     * @throws IllegalArgumentException 如果参数(DamageModifier)是null时
     */
    public double getOriginalDamage(@NotNull DamageModifier type) throws IllegalArgumentException {
        Preconditions.checkArgument(type != null, "Cannot have null DamageModifier");
        final Double damage = originals.get(type);
        return (damage != null) ? damage : 0;
    }

    /**
     * 设置指定伤害类型的伤害.
     * <p>
     * 原文:Sets the damage for the specified modifier.
     *
     * @param type 伤害类型
     * @param damage 伤害值
     * @see #getFinalDamage()
     * @throws IllegalArgumentException 如果类型是null时
     * @throws UnsupportedOperationException 如果触发该事件的实体不支持该伤害类型,
     *     或者受到修改,当 {@link  #isApplicable(DamageModifier)} 返回false
     */
    public void setDamage(@NotNull DamageModifier type, double damage) throws IllegalArgumentException, UnsupportedOperationException {
        Preconditions.checkArgument(type != null, "Cannot have null DamageModifier");
        if (!modifiers.containsKey(type)) {
            throw new UnsupportedOperationException(type + " is not applicable to " + getEntity());
        }
        modifiers.put(type, damage);
    }

    /**
     * 通过特定修饰符返回伤害值.
     * <p>
     * 原文:Gets the damage change for some modifier
     *
     * @param type 伤害类型
     * @return 引起该事件的原始伤害
     * @throws IllegalArgumentException 如果类型是null
     * @see DamageModifier#BASE
     */
     public double getDamage(@NotNull DamageModifier type) throws IllegalArgumentException {
        Preconditions.checkArgument(type != null, "Cannot have null DamageModifier");
        final Double damage = modifiers.get(type);
        return damage == null ? 0 : damage;
    }

    /**
     * 该方法将检查特定的伤害原因是否是本次触发的原因,
     * 例如 {@link #setDamage(DamageModifier, double)}
     * 将不会抛出 {@link UnsupportedOperationException} 异常
     * <p>
     * {@link DamageModifier#BASE} 总是适用的.
     * <p>
     * 原文:This checks to see if a particular modifier is valid for this event's
     * caller, such that, {@link #setDamage(DamageModifier, double)} will not
     * throw an {@link UnsupportedOperationException}.
     * <p>
     * {@link DamageModifier#BASE} is always applicable.
     * 
     * @param type 伤害原因
     * @return 当伤害原因与事件触发的原因相同时返回true 反之返回false
     * @throws IllegalArgumentException 如何传入的参数是null时
     */
    public boolean isApplicable(@NotNull DamageModifier type) throws IllegalArgumentException {
        Preconditions.checkArgument(type != null, "Cannot have null DamageModifier");
        return modifiers.containsKey(type);
    }

    /**
     * 返回本次事件收到伤害的值.
     * <p>
     * 原文:Gets the raw amount of damage caused by the event
     *
     * @return 一个没有进过别的处理的 伤害值
     * @see DamageModifier#BASE
     */
    public double getDamage() {
        return getDamage(DamageModifier.BASE);
    }

    /**
     * 返回此次事件最终的伤害值 (经过护甲等的修改).
     * <p>
     * 原文:Gets the amount of damage caused by the event after all damage
     * reduction is applied.
     *
     * @return 此次事件最终的伤害值
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
     * <p>
     * While a DamageCause may indicate a specific Bukkit-assigned cause of damage,
     * {@link #getDamageSource()} may expose additional types of damage such as custom
     * damage types provided by data packs, as well as any direct or indirect entities,
     * locations, or other contributing factors to the damage being inflicted. The
     * alternative is generally preferred, but DamageCauses provided to this event
     * should largely encompass most common use cases for developers if a simple cause
     * is required.
     *
     * @return a DamageCause value detailing the cause of the damage.
     */
    @NotNull
    public DamageCause getCause() {
        return cause;
    }

    /**
     * Get the source of damage.
     *
     * @return a DamageSource detailing the source of the damage.
     */
    @NotNull
    public DamageSource getDamageSource() {
        return damageSource;
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
     * An enum to specify the types of modifier
     *
     * @deprecated 这个API被废弃了，具体见后面的网址，很快就要被移除了，就不深入解释了.This API is responsible for a large number of implementation
     * problems and is in general unsustainable to maintain. It is likely to be
     * removed very soon in a subsequent release. Please see
     * <a href="https://www.spigotmc.org/threads/194446/">this thread</a> for more information.
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
     * 造成伤害的原因.
     */
    public enum DamageCause {

        /**
         * Damage caused by /kill command
         * <p>
         * Damage: {@link Float#MAX_VALUE}
         */
        KILL,
        /**
         * Damage caused by the World Border
         * <p>
         * Damage: {@link WorldBorder#getDamageAmount()}
         */
        WORLD_BORDER,
        /**
         * 实体接触仙人掌、钟乳石（石笋）或浆果丛等方块时受到的伤害.
         * <p>
         * 伤害:动态改变.
         * <p>
         * 原文:
         * Damage caused when an entity contacts a block such as a Cactus,
         * Dripstone (Stalagmite) or Berry Bush.
         * <p>
         * Damage: variable
         */
        CONTACT,
        /**
         * 一个实体攻击另一个实体时受到的伤害.
         * <p>
         * 伤害:动态改变.
         * <p>
         * 原文:
         * Damage caused when an entity attacks another entity.
         * <p>
         * Damage: variable
         */
        ENTITY_ATTACK,
        /**
         * 一个实体在横扫范围中攻击到另一个实体时受到的伤害.
         * <p>
         * 伤害:动态改变.
         * <p>
         * 原文:
         * Damage caused when an entity attacks another entity in a sweep attack.
         * <p>
         * Damage: variable
         */
        ENTITY_SWEEP_ATTACK,
        /**
         * 被抛射物攻击时受到的伤害.
         * <p>
         * 伤害:动态改变.
         * <p>
         * 原文:
         * Damage caused when attacked by a projectile.
         * <p>
         * Damage: variable
         */
        PROJECTILE,
        /**
         * 被方块卡住受到的伤害.
         * <p>
         * 伤害:1.
         * <p>
         * 原文:
         * Damage caused by being put in a block
         * <p>
         * Damage: 1
         */
        SUFFOCATION,
        /**
         * 实体掉落高度大于 3 格时受到的伤害.
         * <p>
         * 伤害: 掉落高度 - 3.0.
         * <p>
         * 原文:
         * Damage caused when an entity falls a distance greater than 3 blocks
         * <p>
         * Damage: fall height - 3.0
         */
        FALL,
        /**
         * 直接暴露在火中受到的伤害.
         * <p>
         * 伤害: 1.
         * <p>
         * 原文:
         * Damage caused by direct exposure to fire
         * <p>
         * Damage: 1
         */
        FIRE,
        /**
         * 由于烧伤造成的伤害.
         * <p>
         * 伤害: 1.
         * <p>
         * 原文:
         * Damage caused due to burns caused by fire
         * <p>
         * Damage: 1
         */
        FIRE_TICK,
        /**
         * 雪人由于融化受到的伤害.
         * <p>
         * 伤害: 1.
         * <p>
         * 原文:
         * Damage caused due to a snowman melting
         * <p>
         * Damage: 1
         */
        MELTING,
        /**
         * 直接暴露在熔浆受到的伤害.
         * <p>
         * 伤害: 4.
         * <p>
         * 原文:
         * Damage caused by direct exposure to lava
         * <p>
         * Damage: 4
         */
        LAVA,
        /**
         * 在水中耗尽空气受到的伤害.
         * <p>
         * 伤害: 2.
         * <p>
         * 原文:
         * Damage caused by running out of air while in water
         * <p>
         * Damage: 2
         */
        DROWNING,
        /**
         * 在爆炸范围内受到的伤害.
         * <p>
         * 伤害: 动态改变.
         * <p>
         * 原文:
         * Damage caused by being in the area when a block explodes.
         * <p>
         * Damage: variable
         */
        BLOCK_EXPLOSION,
        /**
         * 在实体爆炸范围内受到的伤害,例如苦力怕的爆炸.
         * <p>
         * 伤害: 动态改变.
         * <p>
         * 原文:
         * Damage caused by being in the area when an entity, such as a
         * Creeper, explodes.
         * <p>
         * Damage: variable
         */
        ENTITY_EXPLOSION,
        /**
         * 掉入虚空受到的伤害.
         * <p>
         * 伤害:  每半秒4点.
         * <p>
         * 原文:
         * Damage caused by falling into the void
         * <p>
         * Damage: 4 for players
         */
        VOID,
        /**
         * 雷击造成的伤害.
         * <p>
         * 伤害: 5.
         * <p>
         * 原文:
         * Damage caused by being struck by lightning
         * <p>
         * Damage: 5
         */
        LIGHTNING,
        /**
         * Damage caused by committing suicide.
         * <p>
         * <b>Note:</b> This is currently only used by plugins, default commands
         * like /minecraft:kill use {@link #KILL} to damage players.
         * <p>
         * Damage: variable
         */
        SUICIDE,
        /**
         * 当饥饿值为空时受到的伤害.
         * <p>
         * 伤害: 1.
         * <p>
         * 原文:
         * Damage caused by starving due to having an empty hunger bar
         * <p>
         * Damage: 1
         */
        STARVATION,
        /**
         * 由于持续性毒药造成的伤害.
         * <p>
         * 伤害: 1.
         * <p>
         * 原文:
         * Damage caused due to an ongoing poison effect
         * <p>
         * Damage: 1
         */
        POISON,
        /**
         * 伤害药水或魔法造成的伤害.
         * <p>
         * 伤害: 动态改变.
         * <p>
         * 原文:
         * Damage caused by being hit by a damage potion or spell
         * <p>
         * Damage: variable
         */
        MAGIC,
        /**
         * 凋零效果造成的伤害.
         * <p>
         * 原文:
         * Damage caused by Wither potion effect
         */
        WITHER,
        /**
         * 被掉落中的方块砸中造成的伤害
         * <p>
         * <b>注意:</b> 不是所有方块都会造成伤害.
         * <p>
         * 伤害: 动态改变.
         * <p>
         * 原文:
         * Damage caused by being hit by a falling block which deals damage
         * <p>
         * <b>Note:</b> Not every block deals damage
         * <p>
         * Damage: variable
         */
        FALLING_BLOCK,
        /**
         * 被荆棘反弹的攻击所造成的伤害(反伤).
         * <p>
         * 伤害: 1-4(荆棘).
         * <p>
         * 原文:
         * Damage caused in retaliation to another attack by the Thorns
         * enchantment.
         * <p>
         * Damage: 1-4 (Thorns)
         */
        THORNS,
        /**
         * 龙息造成的伤害 (恶龙咆哮~).
         * <p>
         * 伤害: 动态改变.
         * <p>
         * 原文:
         * Damage caused by a dragon breathing fire.
         * <p>
         * Damage: variable
         */
        DRAGON_BREATH,
        /**
         * 自定义伤害.
         * <p>
         * 伤害: 动态改变.
         * <p>
         * 原文:
         * Custom damage.
         * <p>
         * Damage: variable
         */
        CUSTOM,
        /**
         * 实体撞墙时造成的伤害.
         * <p>
         * 伤害: 动态改变.
         * <p>
         * 原文:
         * Damage caused when an entity runs into a wall.
         * <p>
         * Damage: variable
         */
        FLY_INTO_WALL,
        /**
         * 实体站在{@link Material#MAGMA_BLOCK}上时收到的伤害.
         * <p>
         * 伤害: 1.
         * <p>
         * 原文:
         * Damage caused when an entity steps on {@link Material#MAGMA_BLOCK}.
         * <p>
         * Damage: 1
         */
        HOT_FLOOR,
        /**
         * 由于游戏规则:maxEntityCramming,一个实体和许多其他实体挤压受到的伤害.
         * <p>
         * 伤害: 6.
         * <p>
         * 原文:
         * Damage caused when an entity is colliding with too many entities due
         * to the maxEntityCramming game rule.
         * <p>
         * Damage: 6
         */
        CRAMMING,
        /**
         * 实体(例如:鱼)不在水中时受到的伤害.
         * <p>
         * 伤害: 1.
         * <p>
         * 原文:
         * Damage caused when an entity that should be in water is not.
         * <p>
         * Damage: 1
         */
        DRYOUT,
        /**
         * 冻伤引起的伤害.
         * <p>
         * 伤害: 1 或 5.
         * <p>
         * 原文:
         * Damage caused from freezing.
         * <p>
         * Damage: 1 or 5
         */
        FREEZE,
        /**
         * 来自{@link org.bukkit.entity.Warden}音波攻击造成的伤害.
         * <p>
         * 伤害: 10.
         * <p>
         * 原文:
         * Damage caused by the Sonic Boom attack from {@link org.bukkit.entity.Warden}
         * <p>
         * Damage: 10
         */
        SONIC_BOOM;
    }
}
