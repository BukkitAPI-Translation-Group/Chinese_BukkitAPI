package org.bukkit.attribute;

/**
 * 在 {@link Attributable} 里面的枚举.
 */
public enum Attribute {

    /**
     * 生物的最大血量
     */
    GENERIC_MAX_HEALTH,
    /**
     * 当一个生物正在跟随其他生物/人的时候的跟随范围
     */
    GENERIC_FOLLOW_RANGE,
    /**
     * 当生物被攻击的时候的击退抗性.
     */
    GENERIC_KNOCKBACK_RESISTANCE,
    /**
     * 生物的移动速度.
     */
    GENERIC_MOVEMENT_SPEED,
    /**
     * Flying speed of an Entity.
     */
    GENERIC_FLYING_SPEED,
    /**
     * 当生物攻击其他人时所造成的伤害.
     */
    GENERIC_ATTACK_DAMAGE,
    /**
     * 生物的攻击速率.
     */
    GENERIC_ATTACK_SPEED,
    /**
     * 护甲的防御值
     */
    GENERIC_ARMOR,
    /**
     * Armor durability bonus of an Entity.
     */
    GENERIC_ARMOR_TOUGHNESS,
    /**
     * 生物的可能的掉落物
     */
    GENERIC_LUCK,
    /**
     * 马跳起来的蓄力条.
     */
    HORSE_JUMP_STRENGTH,
    /**
     * 僵尸增援的几率.
     */
    ZOMBIE_SPAWN_REINFORCEMENTS;
}
