package org.bukkit;

/**
 * 确定在光线跟踪时, 碰撞到流体时的表现. 
 * <p>
 * 原文:
 * Determines the collision behavior when fluids get hit during ray tracing.
 */
public enum FluidCollisionMode {

    /**
     * 忽略流体.
     */
    NEVER,
    /**
     * 仅与源流体块碰撞.
     */
    SOURCE_ONLY,
    /**
     * 与所有流体碰撞.
     */
    ALWAYS;
}
