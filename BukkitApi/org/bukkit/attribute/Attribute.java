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
     * The fall damage multiplier of an Entity.
     */
    GENERIC_FALL_DAMAGE_MULTIPLIER("generic.fall_damage_multiplier"),
    /**
     * 生物的可能的掉落物
     */
    GENERIC_LUCK("generic.luck"),
    /**
     * Maximum absorption of an Entity.
     */
    GENERIC_MAX_ABSORPTION("generic.max_absorption"),
    /**
     * The distance which an Entity can fall without damage.
     */
    GENERIC_SAFE_FALL_DISTANCE("generic.safe_fall_distance"),
    /**
     * The relative scale of an Entity.
     */
    GENERIC_SCALE("generic.scale"),
    /**
     * The height which an Entity can walk over.
     */
    GENERIC_STEP_HEIGHT("generic.step_height"),
    /**
     * The gravity applied to an Entity.
     */
    GENERIC_GRAVITY("generic.gravity"),
    /**
     * Strength with which an Entity will jump.
     */
    GENERIC_JUMP_STRENGTH("generic.jump_strength"),
    /**
     * The block reach distance of a Player.
     */
    PLAYER_BLOCK_INTERACTION_RANGE("player.block_interaction_range"),
    /**
     * The entity reach distance of a Player.
     */
    PLAYER_ENTITY_INTERACTION_RANGE("player.entity_interaction_range"),
    /**
     * Block break speed of a Player.
     */
    PLAYER_BLOCK_BREAK_SPEED("player.block_break_speed"),
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
