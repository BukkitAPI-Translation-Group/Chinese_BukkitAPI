package org.bukkit.entity;

/**
 * 代表一只骆驼
 */
public interface Camel extends AbstractHorse, Sittable {

    /**
     * 获取这只骆驼是否处于奔跑状态（冲刺）
     * <p>
     * 原文：
     * Gets whether this camel is dashing (sprinting)
     *
     * @return 奔跑状态
     */
    boolean isDashing();

    /**
     * 设置这只骆驼是否处于奔跑状态（冲刺）
     * <p>
     * 原文：
     * Sets whether this camel is dashing (sprinting).
     *
     * @param dashing 新的奔跑状态
     */
    void setDashing(boolean dashing);
}
