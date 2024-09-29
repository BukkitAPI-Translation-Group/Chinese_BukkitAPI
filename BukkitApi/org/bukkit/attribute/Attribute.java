package org.bukkit.attribute;

import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Translatable;
import org.jetbrains.annotations.NotNull;

/**
 * 在 {@link Attributable} 里面的枚举.
 */
public enum Attribute implements Keyed, Translatable {

    /**
     * 生物的最大血量
     */
    GENERIC_MAX_HEALTH("generic.max_health"),
    /**
     * 当一个生物正在跟随其他生物/人的时候的跟随范围
     */
    GENERIC_FOLLOW_RANGE("generic.follow_range"),
    /**
     * 当生物被攻击的时候的击退抗性
     */
    GENERIC_KNOCKBACK_RESISTANCE("generic.knockback_resistance"),
    /**
     * 生物的移动速度
     */
    GENERIC_MOVEMENT_SPEED("generic.movement_speed"),
    /**
     * 实体的飞行速度
     */
    GENERIC_FLYING_SPEED("generic.flying_speed"),
    /**
     * 当生物攻击其他生物/实体时所造成的伤害
     */
    GENERIC_ATTACK_DAMAGE("generic.attack_damage"),
    /**
     * 生物的攻击击退力度
     */
    GENERIC_ATTACK_KNOCKBACK("generic.attack_knockback"),
    /**
     * 生物的攻击速率
     */
    GENERIC_ATTACK_SPEED("generic.attack_speed"),
    /**
     * 护甲的防御值
     */
    GENERIC_ARMOR("generic.armor"),
    /**
     * 护甲的韧性
     */
    GENERIC_ARMOR_TOUGHNESS("generic.armor_toughness"),
    /**
     * 实体的坠落伤害倍增器。
     * <p>
     * 原文:
     * The fall damage multiplier of an Entity.
     */
    GENERIC_FALL_DAMAGE_MULTIPLIER("generic.fall_damage_multiplier"),
    /**
     * 生物的可能的掉落物
     */
    GENERIC_LUCK("generic.luck"),
    /**
     * 实体的最大吸收值（即护甲吸收）。
     * <p>
     * 原文:
     * Maximum absorption of an Entity.
     */
    GENERIC_MAX_ABSORPTION("generic.max_absorption"),
    /**
     * 实体可以坠落而不受伤害的高度。
     * <p>
     * 原文:
     * The distance which an Entity can fall without damage.
     */
    GENERIC_SAFE_FALL_DISTANCE("generic.safe_fall_distance"),
    /**
     * 实体的相对大小。
     * <p>
     * 原文:
     * The relative scale of an Entity.
     */
    GENERIC_SCALE("generic.scale"),
    /**
     * 实体可以跨越的高度。
     * <p>
     * 原文:
     * The height which an Entity can walk over.
     */
    GENERIC_STEP_HEIGHT("generic.step_height"),
    /**
     * 施加在实体上的重力。
     * <p>
     * 原文:
     * The gravity applied to an Entity.
     */
    GENERIC_GRAVITY("generic.gravity"),
    /**
     * 实体跳跃的力量。
     * <p>
     * 原文:
     * Strength with which an Entity will jump.
     */
    GENERIC_JUMP_STRENGTH("generic.jump_strength"),
    /**
     * 实体在着火后保持燃烧的时间。
     * <p>
     * 原文:
     * How long an entity remains burning after ignition.
     */
    GENERIC_BURNING_TIME("generic.burning_time"),
    /**
     * 对爆炸造成的击退的抗性。
     * <p>
     * 原文:
     * Resistance to knockback from explosions.
     */
    GENERIC_EXPLOSION_KNOCKBACK_RESISTANCE("generic.explosion_knockback_resistance"),
    /**
     * 在困难地形中的移动速度。
     * <p>
     * 原文:
     * Movement speed through difficult terrain.
     */
    GENERIC_MOVEMENT_EFFICIENCY("generic.movement_efficiency"),
    /**
     * 水下使用的氧气。
     * <p>
     * 原文:
     * Oxygen use underwater.
     */
    GENERIC_OXYGEN_BONUS("generic.oxygen_bonus"),
    /**
     * 在水中移动的速度。
     * <p>
     * 原文:
     * Movement speed through water.
     */
    GENERIC_WATER_MOVEMENT_EFFICIENCY("generic.water_movement_efficiency"),
    /**
     * 玩家可以触及的方块距离。
     * <p>
     * 原文:
     * The block reach distance of a Player.
     */
    PLAYER_BLOCK_INTERACTION_RANGE("player.block_interaction_range"),
    /**
     * 玩家可以触及的实体距离。
     * <p>
     * 原文:
     * The entity reach distance of a Player.
     */
    PLAYER_ENTITY_INTERACTION_RANGE("player.entity_interaction_range"),
    /**
     * 玩家破坏方块的速度。
     * <p>
     * 原文:
     * Block break speed of a Player.
     */
    PLAYER_BLOCK_BREAK_SPEED("player.block_break_speed"),
    /**
     * 正确工具的挖矿速度。
     * <p>
     * 原文:
     * Mining speed for correct tools.
     */
    PLAYER_MINING_EFFICIENCY("player.mining_efficiency"),
    /**
     * 潜行速度。
     * <p>
     * 原文:
     * Sneaking speed.
     */
    PLAYER_SNEAKING_SPEED("player.sneaking_speed"),
    /**
     * 水下挖掘速度。
     * <p>
     * 原文:
     * Underwater mining speed.
     */
    PLAYER_SUBMERGED_MINING_SPEED("player.submerged_mining_speed"),
    /**
     * 横扫伤害。
     * <p>
     * 原文:
     * Sweeping damage.
     */
    PLAYER_SWEEPING_DAMAGE_RATIO("player.sweeping_damage_ratio"),
    /**
     * 僵尸增援的几率
     */
    ZOMBIE_SPAWN_REINFORCEMENTS("zombie.spawn_reinforcements");

    private final NamespacedKey key;

    private Attribute(String key) {
        this.key = NamespacedKey.minecraft(key);
    }

    @NotNull
    @Override
    public NamespacedKey getKey() {
        return key;
    }

    @NotNull
    @Override
    public String getTranslationKey() {
        return Bukkit.getUnsafe().getTranslationKey(this);
    }
}
