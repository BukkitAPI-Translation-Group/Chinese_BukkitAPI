package org.bukkit.entity;

import org.bukkit.DyeColor;
import org.jetbrains.annotations.NotNull;

/**
 * 代表狼.
 */
public interface Wolf extends Tameable, Sittable {

    /**
     * 检测狼是否愤怒.
     * <p>
     * 原文:
     * Checks if this wolf is angry
     *
     * @return 如果愤怒则为true
     */
    public boolean isAngry();

    /**
     * 设置这只狼的愤怒状态.
     * <p>
     * 愤怒的狼不能喂食或驯服.
     * <p>
     * 原文:
     * Sets the anger of this wolf.
     * <p>
     * An angry wolf can not be fed or tamed.
     *
     * @param angry 如果愤怒则为true
     * @see #setTarget(org.bukkit.entity.LivingEntity)
     */
    public void setAngry(boolean angry);

    /**
     * 获取这只狼的项圈颜色.
     * <p>
     * 原文:
     * Get the collar color of this wolf
     *
     * @return 项圈的颜色
     */
    @NotNull
    public DyeColor getCollarColor();

    /**
     * 设置这只狼的项圈颜色.
     * <p>
     * 原文:
     * Set the collar color of this wolf
     *
     * @param color 颜色
     */
    public void setCollarColor(@NotNull DyeColor color);
}