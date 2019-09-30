package org.bukkit.entity;

/**
 * 代表鹦鹉.
 * <p>
 * 原文:
 * Represents a Parrot.
 */
public interface Parrot extends Animals, Tameable, Sittable {

    /**
     * 获得鹦鹉变体.
     * <p>
     * 原文:
     * Get the variant of this parrot.
     *
     * @return 鹦鹉变体
     */
    public Variant getVariant();

    /**
     * 设置鹦鹉变体.
     * <p>
     * 原文:
     * Set the variant of this parrot.
     *
     * @param variant 鹦鹉变体
     */
    public void setVariant(Variant variant);

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
