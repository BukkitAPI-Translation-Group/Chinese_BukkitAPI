package org.bukkit.entity;

import org.jetbrains.annotations.NotNull;

/**
 * 代表狐狸.
 * <p>
 * 原文:
 * What does the fox say?
 */
public interface Fox extends Animals, Sittable {

    /**
     * 获取此狐狸品种.
     * <p>
     * 原文:
     * Gets the current type of this fox.
     *
     * @return 狐狸品种.
     */
    @NotNull
    public Type getFoxType();

    /**
     * 设置狐狸的品种.
     * <p>
     * 原文:
     * Sets the current type of this fox.
     *
     * @param type New type of this fox.
     */
    public void setFoxType(@NotNull Type type);

    /**
     * 判断是否蜷缩.
     * <p>
     * 原文:
     * Checks if this animal is crouching
     *
     * @return 蜷缩中返回true.
     */
    boolean isCrouching();

    /**
     * 设置是否蜷缩.
     * <p>
     * 原文:
     * Sets if this animal is crouching.
     *
     * @param 设置为true则蜷缩.
     */
    void setCrouching(boolean crouching);

    /**
     * 设置是否正在睡觉.
     * <p>
     * 原文:
     * Sets if this animal is sleeping.
     *
     * @param 设置为true则进入睡觉状态
     */
    void setSleeping(boolean sleeping);

    /**
     * 代表许多的狐狸品种.
     * <p>
     * 原文:
     * Represents the various different fox types there are.
     */
    public enum Type {
        RED,
        SNOW;
    }
}
