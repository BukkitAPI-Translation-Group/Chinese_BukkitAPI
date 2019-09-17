package org.bukkit.entity;

import org.bukkit.DyeColor;
import org.jetbrains.annotations.NotNull;

/**
 * 代表猫.
 * <p>
 * 原文：
 * Meow.
 */
public interface Cat extends Animals, Tameable, Sittable {

    /**
     * 获取这只猫的品种.
     * <p>
     * 原文：
     * Gets the current type of this cat.
     *
     * @return 猫的品种
     */
    @NotNull
    public Type getCatType();

    /**
     * 设置这只猫的品种.
     * <p>
     * 原文：
     * Sets the current type of this cat.
     *
     * @param type 为这只猫设置的新品种
     */
    public void setCatType(@NotNull Type type);

    /**
     * 获取这只猫的项圈颜色.
     * <p>
     * 原文:
     * Get the collar color of this cat
     *
     * @return 项圈的颜色
     */
    @NotNull
    public DyeColor getCollarColor();

    /**
     * 设置这只猫的项圈颜色.
     * <p>
     * 原文:
     * Set the collar color of this cat
     *
     * @param color 要设置的颜色
     */
    public void setCollarColor(@NotNull DyeColor color);

    /**
     * 代表了各种猫的品种.
     * <p>
     * Represents the various different cat types there are.
     */
    public enum Type {
        TABBY,
        BLACK,
        RED,
        SIAMESE,
        BRITISH_SHORTHAIR,
        CALICO,
        PERSIAN,
        RAGDOLL,
        WHITE,
        JELLIE,
        ALL_BLACK;
    }
}
