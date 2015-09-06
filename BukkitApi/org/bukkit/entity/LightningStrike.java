package org.bukkit.entity;

/**
 * 代表雷击的实例，可能会或者不会造成伤害。
 */
public interface LightningStrike extends Weather {

    /**
     * 返回雷击是否是没有伤害的效果。
     * <p>
     * 原文：Returns whether the strike is an effect that does no damage.
     *
     * @return 雷击是否为效果
     */
    public boolean isEffect();

}