package org.bukkit.entity;

import org.jetbrains.annotations.NotNull;

/**
 * 代表鹦鹉.
 */
public interface Parrot extends Tameable, Sittable {

    /**
     * 获得鹦鹉变体.
     * <p>
     * 原文:
     * Get the variant of this parrot.
     *
     * @return 鹦鹉变体
     */
    @NotNull
    public Variant getVariant();

    /**
     * 设置鹦鹉变体.
     * <p>
     * 原文:
     * Set the variant of this parrot.
     *
     * @param variant 鹦鹉变体
     */
    public void setVariant(@NotNull Variant variant);

    /**
     * 代表鹦鹉变体(颜色).
     * <p>
     * 原文:
     * Represents the variant of a parrot - ie its color.
     */
    public enum Variant {
        /**
         * 传统鹦鹉 - 红翅膀.
         * <p>
         * 原文:
         * Classic parrot - red with colored wingtips.
         */
        RED,
        /**
         * 蓝色.
         * <p>
         * 原文:
         * Royal blue colored parrot.
         */
        BLUE,
        /**
         * 绿色.
         * <p>
         * 原文:
         * Green colored parrot.
         */
        GREEN,
        /**
         * 蓝绿色鹦鹉.
         * <p>
         * 原文:
         * Cyan colored parrot.
         */
        CYAN,
        /**
         * 灰色鹦鹉.
         * <p>
         * 原文:
         * Gray colored parrot.
         */
        GRAY;
    }
}
