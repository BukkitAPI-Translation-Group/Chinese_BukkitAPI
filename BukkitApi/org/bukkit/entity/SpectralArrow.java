package org.bukkit.entity;

/**
 * 代表一支光灵箭.
 */
public interface SpectralArrow extends AbstractArrow {

    /**
     * 获取此箭矢施加发光效果的持续时间.
     *
     * @return 发发光效果的刻数
     */
    int getGlowingTicks();

    /**
     * 设置施加发光效果的持续时间.
     *
     * @param duration 发光效果的刻数
     */
    void setGlowingTicks(int duration);
}
