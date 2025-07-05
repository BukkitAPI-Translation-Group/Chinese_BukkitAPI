package org.bukkit.attribute;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Locale;
import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.Translatable;
import org.bukkit.registry.RegistryAware;
import org.bukkit.util.OldEnum;
import org.jetbrains.annotations.NotNull;

/**
 * 在 {@link Attributable} 里面的枚举.
 */
public interface Attribute extends OldEnum<Attribute>, Keyed, Translatable, RegistryAware {

    /**
     * 生物的最大血量
     */
    Attribute MAX_HEALTH = getAttribute("max_health");
    /**
     * 当一个生物正在跟随其他生物/人的时候的跟随范围
     */
    Attribute FOLLOW_RANGE = getAttribute("follow_range");
    /**
     * 当生物被攻击的时候的击退抗性
     */
    Attribute KNOCKBACK_RESISTANCE = getAttribute("knockback_resistance");
    /**
     * 生物的移动速度
     */
    Attribute MOVEMENT_SPEED = getAttribute("movement_speed");
    /**
     * 实体的飞行速度
     */
    Attribute FLYING_SPEED = getAttribute("flying_speed");
    /**
     * 当生物攻击其他生物/实体时所造成的伤害
     */
    Attribute ATTACK_DAMAGE = getAttribute("attack_damage");
    /**
     * 生物的攻击击退力度
     */
    Attribute ATTACK_KNOCKBACK = getAttribute("attack_knockback");
    /**
     * 生物的攻击速率
     */
    Attribute ATTACK_SPEED = getAttribute("attack_speed");
    /**
     * 护甲的防御值
     */
    Attribute ARMOR = getAttribute("armor");
    /**
     * 护甲的韧性
     */
    Attribute ARMOR_TOUGHNESS = getAttribute("armor_toughness");
    /**
     * 实体的坠落伤害倍增器。
     * <p>
     * 原文:
     * The fall damage multiplier of an Entity.
     */
    Attribute FALL_DAMAGE_MULTIPLIER = getAttribute("fall_damage_multiplier");
    /**
     * 生物的可能的掉落物
     */
    Attribute LUCK = getAttribute("luck");
    /**
     * 实体的最大吸收值（即护甲吸收）。
     * <p>
     * 原文:
     * Maximum absorption of an Entity.
     */
    Attribute MAX_ABSORPTION = getAttribute("max_absorption");
    /**
     * 实体可以坠落而不受伤害的高度。
     * <p>
     * 原文:
     * The distance which an Entity can fall without damage.
     */
    Attribute SAFE_FALL_DISTANCE = getAttribute("safe_fall_distance");
    /**
     * 实体的相对大小。
     * <p>
     * 原文:
     * The relative scale of an Entity.
     */
    Attribute SCALE = getAttribute("scale");
    /**
     * 实体可以跨越的高度。
     * <p>
     * 原文:
     * The height which an Entity can walk over.
     */
    Attribute STEP_HEIGHT = getAttribute("step_height");
    /**
     * 施加在实体上的重力。
     * <p>
     * 原文:
     * The gravity applied to an Entity.
     */
    Attribute GRAVITY = getAttribute("gravity");
    /**
     * 实体跳跃的力量。
     * <p>
     * 原文:
     * Strength with which an Entity will jump.
     */
    Attribute JUMP_STRENGTH = getAttribute("jump_strength");
    /**
     * 实体在着火后保持燃烧的时间。
     * <p>
     * 原文:
     * How long an entity remains burning after ignition.
     */
    Attribute BURNING_TIME = getAttribute("burning_time");
    /**
     * The distance at which the camera is placed away.
     */
    Attribute CAMERA_DISTANCE = getAttribute("camera_distance");
    /**
     * 对爆炸造成的击退的抗性。
     * <p>
     * 原文:
     * Resistance to knockback from explosions.
     */
    Attribute EXPLOSION_KNOCKBACK_RESISTANCE = getAttribute("explosion_knockback_resistance");
    /**
     * 在困难地形中的移动速度。
     * <p>
     * 原文:
     * Movement speed through difficult terrain.
     */
    Attribute MOVEMENT_EFFICIENCY = getAttribute("movement_efficiency");
    /**
     * 水下使用的氧气。
     * <p>
     * 原文:
     * Oxygen use underwater.
     */
    Attribute OXYGEN_BONUS = getAttribute("oxygen_bonus");
    /**
     * 在水中移动的速度。
     */
    Attribute WATER_MOVEMENT_EFFICIENCY = getAttribute("water_movement_efficiency");
    /**
     * Range at which mobs will be tempted by items.
     */
    Attribute TEMPT_RANGE = getAttribute("tempt_range");
    /**
     * 玩家可以触及的方块距离。
     * <p>
     * 原文:
     * The block reach distance of a Player.
     */
    Attribute BLOCK_INTERACTION_RANGE = getAttribute("block_interaction_range");
    /**
     * 玩家可以触及的实体距离。
     * <p>
     * 原文:
     * The entity reach distance of a Player.
     */
    Attribute ENTITY_INTERACTION_RANGE = getAttribute("entity_interaction_range");
    /**
     * 玩家破坏方块的速度。
     * <p>
     * 原文:
     * Block break speed of a Player.
     */
    Attribute BLOCK_BREAK_SPEED = getAttribute("block_break_speed");
    /**
     * 正确工具的挖矿速度。
     * <p>
     * 原文:
     * Mining speed for correct tools.
     */
    Attribute MINING_EFFICIENCY = getAttribute("mining_efficiency");
    /**
     * 潜行速度。
     * <p>
     * 原文:
     * Sneaking speed.
     */
    Attribute SNEAKING_SPEED = getAttribute("sneaking_speed");
    /**
     * 水下挖掘速度。
     * <p>
     * 原文:
     * Underwater mining speed.
     */
    Attribute SUBMERGED_MINING_SPEED = getAttribute("submerged_mining_speed");
    /**
     * 横扫伤害。
     * <p>
     * 原文:
     * Sweeping damage.
     */
    Attribute SWEEPING_DAMAGE_RATIO = getAttribute("sweeping_damage_ratio");
    /**
     * 僵尸增援的几率
     */
    Attribute SPAWN_REINFORCEMENTS = getAttribute("spawn_reinforcements");
    /**
     * Waypoint transmission range.
     */
    Attribute WAYPOINT_TRANSMIT_RANGE = getAttribute("waypoint_transmit_range");
    /**
     * Waypoing receive range.
     */
    Attribute WAYPOINT_RECEIVE_RANGE = getAttribute("waypoint_receive_range");

    @NotNull
    private static Attribute getAttribute(@NotNull String key) {
        return Registry.ATTRIBUTE.getOrThrow(NamespacedKey.minecraft(key));
    }

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

    /**
     * @param name of the attribute.
     * @return the attribute with the given name.
     * @deprecated only for backwards compatibility, use {@link Registry#get(NamespacedKey)} instead.
     */
    @NotNull
    @Deprecated(since = "1.21.3")
    static Attribute valueOf(@NotNull String name) {
        Attribute attribute = Bukkit.getUnsafe().get(Registry.ATTRIBUTE, NamespacedKey.fromString(name.toLowerCase(Locale.ROOT)));
        Preconditions.checkArgument(attribute != null, "No attribute found with the name %s", name);
        return attribute;
    }

    /**
     * @return an array of all known attributes.
     * @deprecated use {@link Registry#iterator()}.
     */
    @NotNull
    @Deprecated(since = "1.21.3")
    static Attribute[] values() {
        return Lists.newArrayList(Registry.ATTRIBUTE).toArray(new Attribute[0]);
    }
}
