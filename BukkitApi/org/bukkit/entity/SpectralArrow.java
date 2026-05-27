package org.bukkit.entity;

/**
 * 代表一支光灵箭.
 */
public interface SpectralArrow extends AbstractArrow {

    /**
     * 获取此箭矢施加发光效果的持续时间.
     * <p>
     * 原文：
     * Returns the amount of time that this arrow will apply
     * the glowing effect for.
     *
     * @return 发光效果的刻数
     */
    int getGlowingTicks();

    /**
     * 设置施加发光效果的持续时间.
     * <p>
     * 原文：
     * Sets the amount of time to apply the glowing effect for.
     *
     * @param duration 发光效果的刻数
     */
    void setGlowingTicks(int duration);
}
