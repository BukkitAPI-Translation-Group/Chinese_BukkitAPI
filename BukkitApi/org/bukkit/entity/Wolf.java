package org.bukkit.entity;

import org.bukkit.DyeColor;

/**
 * 代表狼.
 */
public interface Wolf extends Animals, Tameable {

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
     * 愤怒的狼不能喂食或驯服,并会积极寻找目标进行攻击.
     * <p>
     * 原文:
     * Sets the anger of this wolf.
     * <p>
     * An angry wolf can not be fed or tamed, and will actively look for
     * targets to attack.
     *
     * @param angry 如果愤怒则为true
     */
    public void setAngry(boolean angry);

    /**
     * 检测狼是否坐下.
     * <p>
     * 原文:
     * Checks if this wolf is sitting
     *
     * @return 如果坐下则为true
     */
    public boolean isSitting();

    /**
     * 设置狼是否坐下.
     * <p>
     * 将删除狼事先的任何路径(机翻的，外佬的思想真搞不懂，但这不是重点).
     * <p>
     * 原文:
     * Sets if this wolf is sitting.
     * <p>
     * Will remove any path that the wolf was following beforehand.
     *
     * @param sitting 如果坐下则为true
     */
    public void setSitting(boolean sitting);

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