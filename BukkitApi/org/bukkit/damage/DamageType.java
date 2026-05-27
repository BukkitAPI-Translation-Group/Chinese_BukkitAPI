package org.bukkit.damage;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.Translatable;
import org.bukkit.registry.RegistryAware;
import org.jetbrains.annotations.NotNull;

/**
 * 代表实体可以受到的伤害类型.
 * <p>
 * 此类中的常量包括原版服务器提供的基础类型.
 * 数据包能够注册更多类型的伤害, 可以通过{@link Registry#DAMAGE_TYPE}获取.
 *
 * @see <a href="https://minecraft.wiki/w/Damage_type">Minecraft Wiki</a>
 */
public interface DamageType extends Keyed, Translatable, RegistryAware {

    public static final DamageType IN_FIRE = getDamageType("in_fire");
    public static final DamageType CAMPFIRE = getDamageType("campfire");
    public static final DamageType LIGHTNING_BOLT = getDamageType("lightning_bolt");
    public static final DamageType ON_FIRE = getDamageType("on_fire");
    public static final DamageType LAVA = getDamageType("lava");
    public static final DamageType HOT_FLOOR = getDamageType("hot_floor");
    public static final DamageType IN_WALL = getDamageType("in_wall");
    public static final DamageType CRAMMING = getDamageType("cramming");
    public static final DamageType DROWN = getDamageType("drown");
    public static final DamageType STARVE = getDamageType("starve");
    public static final DamageType CACTUS = getDamageType("cactus");
    public static final DamageType FALL = getDamageType("fall");
    public static final DamageType ENDER_PEARL = getDamageType("ender_pearl");
    public static final DamageType FLY_INTO_WALL = getDamageType("fly_into_wall");
    public static final DamageType OUT_OF_WORLD = getDamageType("out_of_world");
    public static final DamageType GENERIC = getDamageType("generic");
    public static final DamageType MAGIC = getDamageType("magic");
    public static final DamageType WITHER = getDamageType("wither");
    public static final DamageType DRAGON_BREATH = getDamageType("dragon_breath");
    public static final DamageType DRY_OUT = getDamageType("dry_out");
    public static final DamageType SWEET_BERRY_BUSH = getDamageType("sweet_berry_bush");
    public static final DamageType FREEZE = getDamageType("freeze");
    public static final DamageType STALAGMITE = getDamageType("stalagmite");
    public static final DamageType FALLING_BLOCK = getDamageType("falling_block");
    public static final DamageType FALLING_ANVIL = getDamageType("falling_anvil");
    public static final DamageType FALLING_STALACTITE = getDamageType("falling_stalactite");
    public static final DamageType STING = getDamageType("sting");
    public static final DamageType MOB_ATTACK = getDamageType("mob_attack");
    public static final DamageType MOB_ATTACK_NO_AGGRO = getDamageType("mob_attack_no_aggro");
    public static final DamageType PLAYER_ATTACK = getDamageType("player_attack");
    public static final DamageType SPEAR = getDamageType("spear");
    public static final DamageType ARROW = getDamageType("arrow");
    public static final DamageType TRIDENT = getDamageType("trident");
    public static final DamageType MOB_PROJECTILE = getDamageType("mob_projectile");
    public static final DamageType SPIT = getDamageType("spit");
    public static final DamageType FIREWORKS = getDamageType("fireworks");
    public static final DamageType FIREBALL = getDamageType("fireball");
    public static final DamageType UNATTRIBUTED_FIREBALL = getDamageType("unattributed_fireball");
    public static final DamageType WITHER_SKULL = getDamageType("wither_skull");
    public static final DamageType THROWN = getDamageType("thrown");
    public static final DamageType INDIRECT_MAGIC = getDamageType("indirect_magic");
    public static final DamageType THORNS = getDamageType("thorns");
    public static final DamageType EXPLOSION = getDamageType("explosion");
    public static final DamageType PLAYER_EXPLOSION = getDamageType("player_explosion");
    public static final DamageType SONIC_BOOM = getDamageType("sonic_boom");
    public static final DamageType BAD_RESPAWN_POINT = getDamageType("bad_respawn_point");
    public static final DamageType OUTSIDE_BORDER = getDamageType("outside_border");
    public static final DamageType GENERIC_KILL = getDamageType("generic_kill");
    public static final DamageType WIND_CHARGE = getDamageType("wind_charge");
    public static final DamageType MACE_SMASH = getDamageType("mace_smash");

    @NotNull
    private static DamageType getDamageType(@NotNull String key) {
        return Registry.DAMAGE_TYPE.getOrThrow(NamespacedKey.minecraft(key));
    }

    /**
     * {@inheritDoc}
     * <p>
     * 返回的键是当此伤害类型导致实体死亡时发送的死亡消息的键.
     * <p>
     * <strong>注意</strong> 此翻译键仅在{@link #getDeathMessageType()}为{@link DeathMessageType#DEFAULT}时使用
     */
    @NotNull
    @Override
    public String getTranslationKey();

    /**
     * 获取此伤害类型的{@link DamageScaling}.
     * <p>
     * 原文：
     * Get the {@link DamageScaling} for this damage type.
     *
     * @return 伤害缩放
     */
    @NotNull
    public DamageScaling getDamageScaling();

    /**
     * 获取此伤害类型的{@link DamageEffect}.
     * <p>
     * 原文：
     * Get the {@link DamageEffect} for this damage type.
     *
     * @return 伤害效果
     */
    @NotNull
    public DamageEffect getDamageEffect();

    /**
     * 获取此伤害类型的{@link DeathMessageType}.
     * <p>
     * 原文：
     * Get the {@link DeathMessageType} for this damage type.
     *
     * @return 死亡消息类型
     */
    @NotNull
    public DeathMessageType getDeathMessageType();

    /**
     * 获取此伤害类型造成的饥饿消耗量.
     * <p>
     * 原文：
     * Get the amount of hunger exhaustion caused by this damage type.
     *
     * @return 消耗量
     */
    public float getExhaustion();

    /**
     * {@inheritDoc}
     *
     * @see #getKeyOrThrow()
     * @see #isRegistered()
     * @deprecated A key might not always be present, use {@link #getKeyOrThrow()} instead.
     */
    @NotNull
    @Override
    @Deprecated(since = "1.21.4")
    NamespacedKey getKey();
}
