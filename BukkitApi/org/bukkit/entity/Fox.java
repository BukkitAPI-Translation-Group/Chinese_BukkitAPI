package org.bukkit.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
     * @param type 要设置的新品种.
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
     * @param crouching 设置为true则蜷缩.
     */
    void setCrouching(boolean crouching);

    /**
     * 设置是否正在睡觉.
     * <p>
     * 原文:
     * Sets if this animal is sleeping.
     *
     * @param sleeping 设置为true则进入睡眠状态
     */
    void setSleeping(boolean sleeping);

    /**
     * Gets the first trusted player.
     *
     * @return the owning AnimalTamer, or null if not owned
     */
    @Nullable
    public AnimalTamer getFirstTrustedPlayer();

    /**
     * Set the first trusted player.
     * <p>
     * The first trusted player may only be removed after the second.
     *
     * @param player the AnimalTamer to be trusted
     */
    public void setFirstTrustedPlayer(@Nullable AnimalTamer player);

    /**
     * Gets the second trusted player.
     *
     * @return the owning AnimalTamer, or null if not owned
     */
    @Nullable
    public AnimalTamer getSecondTrustedPlayer();

    /**
     * Set the second trusted player.
     * <p>
     * The second trusted player may only be added after the first.
     *
     * @param player the AnimalTamer to be trusted
     */
    public void setSecondTrustedPlayer(@Nullable AnimalTamer player);

    /**
     * Gets whether the fox is faceplanting the ground
     *
     * @return Whether the fox is faceplanting the ground
     */
    boolean isFaceplanted();

    /**
     * 代表各种狐狸品种.
     * <p>
     * 原文:
     * Represents the various different fox types there are.
     */
    public enum Type {
        RED,
        SNOW;
    }
}
