package org.bukkit.damage;

/**
 * 代表{@link DamageSource}使用的死亡消息类型.
 */
public enum DeathMessageType {

    /**
     * 不应用特殊的死亡消息逻辑.
     */
    DEFAULT,
    /**
     * 显示摔落伤害死亡的变体而非普通死亡消息.
     * <br>
     * <b>示例：</b>death.fell.assist.item
     */
    FALL_VARIANTS,
    /**
     * 显示有意设计的死亡消息而非普通死亡消息.
     */
    INTENTIONAL_GAME_DESIGN;
}
