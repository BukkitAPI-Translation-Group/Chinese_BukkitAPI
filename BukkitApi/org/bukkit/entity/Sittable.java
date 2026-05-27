package org.bukkit.entity;

/**
 * 一种可以坐下的动物。
 */
public interface Sittable {

    /**
     * 检查此动物是否正在坐下。
     *
     * @return 如果正在坐下则为 true
     * <p>原文：Checks if this animal is sitting
     */
    boolean isSitting();

    /**
     * 设置此动物是否坐下。将移除动物之前正在跟随的任何路径。
     *
     * @param sitting 如果坐下则为 true
     * <p>原文：Sets if this animal is sitting. Will remove any path that the animal was following beforehand.
     */
    void setSitting(boolean sitting);

}
