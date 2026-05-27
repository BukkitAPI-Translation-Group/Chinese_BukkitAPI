package org.bukkit.entity;

import org.jetbrains.annotations.NotNull;

/**
 * 代表鲑鱼。
 */
public interface Salmon extends Fish {

    /**
     * 获取此鲑鱼的变种。
     * <p>
     * 原文：Get the variant of this salmon.
     *
     * @return 鲑鱼变种
     */
    @NotNull
    public Variant getVariant();

    /**
     * 设置此鲑鱼的变种。
     * <p>
     * 原文：Set the variant of this salmon.
     *
     * @param variant 鲑鱼变种
     */
    public void setVariant(@NotNull Variant variant);

    /**
     * 代表鲑鱼的变种 - 即其大小。
     */
    public enum Variant {

        /**
         * 小型鲑鱼。
         */
        SMALL,
        /**
         * 默认鲑鱼。
         */
        MEDIUM,
        /**
         * 大型鲑鱼。
         */
        LARGE;
    }
}
