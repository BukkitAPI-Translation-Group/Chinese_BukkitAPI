package org.bukkit.entity;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * 代表骷髅.
 */
public interface Skeleton extends Monster {

    /**
     * 获取骷髅当前的种类.
     * <p>
     * 原文:Gets the current type of this skeleton.
     *
     * @return 当前的种类
     * @deprecated 应检查这是什么类实例
     */
    @Deprecated
    @NotNull
    public SkeletonType getSkeletonType();

    /**
     * @param type 种类
     * @deprecated Must spawn a new subtype variant
     */
    @Deprecated
    @Contract("_ -> fail")
    public void setSkeletonType(SkeletonType type);

    /*
     * @deprecated classes are different types
     */
    @Deprecated
    public enum SkeletonType {

        /**
         * Standard skeleton type.
         */
        NORMAL,
        /**
         * Wither skeleton. Generally found in Nether fortresses.
         */
        WITHER,
        /**
         * Stray skeleton. Generally found in ice biomes. Shoots tipped arrows.
         */
        STRAY;
    }
}
