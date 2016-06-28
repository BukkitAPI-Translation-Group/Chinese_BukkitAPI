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
     */
    public SkeletonType getSkeletonType();

    /**
     * 设置骷髅的新种类.
     * <p>
     * 原文:Sets the new type of this skeleton.
     *
     * @param type 新的种类
     */
    public void setSkeletonType(SkeletonType type);

    /*
     * 代表各种不同的骷髅种类.
     */
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
