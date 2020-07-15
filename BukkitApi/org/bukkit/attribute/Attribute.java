package org.bukkit.attribute;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

/**
 * 在 {@link Attributable} 里面的枚举.
 */
public enum Attribute implements Keyed {

    /**
     * 生物的最大血量
     */
    GENERIC_MAX_HEALTH("generic.max_health"),
    /**
     * 当一个生物正在跟随其他生物/人的时候的跟随范围
     */
    GENERIC_FOLLOW_RANGE("generic.follow_range"),
    /**
     * 当生物被攻击的时候的击退抗性.
     */
    GENERIC_KNOCKBACK_RESISTANCE("generic.knockback_resistance"),
    /**
     * 生物的移动速度.
     */
    GENERIC_MOVEMENT_SPEED("generic.movement_speed"),
    /**
     * 实体的飞行速度.
     */
    GENERIC_FLYING_SPEED("generic.flying_speed"),
    /**
     * 当生物攻击其他生物/实体时所造成的伤害.
     */
    GENERIC_ATTACK_DAMAGE("generic.attack_damage"),
    /**
     * Attack knockback of an Entity.
     */
    GENERIC_ATTACK_KNOCKBACK("generic.attack_knockback"),
    /**
     * 生物的攻击速率.
     */
    GENERIC_ATTACK_SPEED("generic.attack_speed"),
    /**
     * 护甲的防御值
     */
    GENERIC_ARMOR("generic.armor"),
    /**
     * Armor durability bonus of an Entity.
     */
    GENERIC_ARMOR_TOUGHNESS("generic.armor_toughness"),
    /**
     * 生物的可能的掉落物
     */
    GENERIC_LUCK("generic.luck"),
    /**
     * 马跳起来的蓄力条.
     */
    HORSE_JUMP_STRENGTH("horse.jump_strength"),
    /**
     * 僵尸增援的几率.
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
}
