package org.bukkit.entity;

/**
 * 代表可爆炸的实体.
 */
public interface Explosive extends Entity {

    /**
     * 设置爆炸的影响半径.
     * <p>
     * 原文:Set the radius affected by this explosive's explosion
     *
     * @param yield 爆炸的影响半径
     */
    public void setYield(float yield);

    /**
     * 返回爆炸的影响半径.
     * <p>
     * 原文:Return the radius or yield of this explosive's explosion
     *
     * @return 爆炸的影响半径
     */
    public float getYield();

    /**
     * 设置此次爆炸是否会生火.
     * <p>
     * 原文:Set whether or not this explosive's explosion causes fire
     *
     * @param isIncendiary 此次爆炸是否会生火
     */
    public void setIsIncendiary(boolean isIncendiary);

    /**
     * 返回此次爆炸是否会生火.
     * <p>
     * 原文:Return whether or not this explosive creates a fire when exploding
     *
     * @return 此次爆炸是否会生火
     */
    public boolean isIncendiary();
}
