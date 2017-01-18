package org.bukkit.entity;

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
    public SkeletonType getSkeletonType();

    /**
     * @deprecated Must spawn a new subtype variant
     */
    @Deprecated
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
