package org.bukkit.entity;

import org.jetbrains.annotations.NotNull;

/**
 * 美西螈.
 */
public interface Axolotl extends Animals {

    /**
     * 获取此美西螈是否正在装死.
     *
     * 美西螈在水下受到伤害时可能会装死.
     * <p>
     * 原文：Gets if this axolotl is playing dead.
     *
     * An axolotl may play dead when it is damaged underwater.
     *
     * @return 装死状态
     */
    boolean isPlayingDead();

    /**
     * 设置此美西螈是否正在装死.
     *
     * 美西螈在水下受到伤害时可能会装死.
     * <p>
     * 原文：Sets if this axolotl is playing dead.
     *
     * An axolotl may play dead when it is damaged underwater.
     *
     * @param playingDead 装死状态
     */
    void setPlayingDead(boolean playingDead);

    /**
     * 获取此美西螈的变种.
     * <p>
     * 原文：Get the variant of this axolotl.
     *
     * @return 美西螈变种
     */
    @NotNull
    Variant getVariant();

    /**
     * 设置此美西螈的变种.
     * <p>
     * 原文：Set the variant of this axolotl.
     *
     * @param variant 美西螈变种
     */
    void setVariant(@NotNull Variant variant);

    /**
     * 美西螈的变种 - 即其颜色.
     */
    public enum Variant {

        /**
         * 白化 (粉色) 美西螈.
         */
        LUCY,
        /**
         * 棕色美西螈.
         */
        WILD,
        /**
         * 金色美西螈.
         */
        GOLD,
        /**
         * 青色美西螈.
         */
        CYAN,
        /**
         * 蓝色美西螈.
         */
        BLUE;
    }
}
