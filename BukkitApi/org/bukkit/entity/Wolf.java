package org.bukkit.entity;

import org.bukkit.DyeColor;

/**
 * 代表狼.
 */
public interface Wolf extends Animals, Tameable, Sittable {

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
     * 愤怒的狼不能喂食或驯服,并必须有工具目标.
     * 若攻击目标未指定, 这只狼将很快平息它的怒气 (字面翻译:快速收回至不愤怒的状态).
     * <p>
     * 原文:
     * Sets the anger of this wolf.
     * <p>
     * An angry wolf can not be fed or tamed, and must have a target to attack.
     * If a target is not set the wolf will quickly revert to its non-angry
     * state.
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
    public DyeColor getCollarColor();

    /**
     * 设置这只狼的项圈颜色.
     * <p>
     * 原文:
     * Set the collar color of this wolf
     *
     * @param color 应用的颜色
     */
    public void setCollarColor(DyeColor color);
}