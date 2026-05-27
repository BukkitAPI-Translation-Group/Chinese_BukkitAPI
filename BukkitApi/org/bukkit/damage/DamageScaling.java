package org.bukkit.damage;

import org.bukkit.entity.Player;

/**
 * 一种关于服务器难度的伤害缩放方式.
 */
public enum DamageScaling {

    /**
     * 伤害不缩放.
     */
    NEVER,
    /**
     * 伤害仅在{@link DamageSource#getCausingEntity() 造成伤害的实体}不是{@link Player}时缩放.
     */
    WHEN_CAUSED_BY_LIVING_NON_PLAYER,
    /**
     * 伤害总是缩放.
     */
    ALWAYS;
}
