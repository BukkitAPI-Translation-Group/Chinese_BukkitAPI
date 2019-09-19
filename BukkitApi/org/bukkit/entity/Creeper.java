package org.bukkit.entity;

/**
 * 代表爬行者.
 */
public interface Creeper extends Monster {

    /**
     * 检查这个爬行者是否为高压的(触电)
     * <p>
     * 原文:
     * Checks if this Creeper is powered (Electrocuted)
     *
     * @return true if 如果爬行者是高压的则为true
     */
    public boolean isPowered();

    /**
     * 设置这个爬行者为高压状态.
     * <p>
     * 原文:
     * Sets the Powered status of this Creeper
     *
     * @param value 新的高压状态
     */
    public void setPowered(boolean value);

    /**
     * 为爬行者设置点燃tick值, 此tick值为爬行者爆炸前点燃状态的维持时间.
     * <p>
     * 原文:
     * Set the maximum fuse ticks for this Creeper, where the maximum ticks 
     * is the amount of time in which a creeper is allowed to be in the 
     * primed state before exploding.
     *
     * @param ticks 新的点燃状态的最大tick值
     */
    public void setMaxFuseTicks(int ticks);

    /**
     * 获得此爬行者的点燃状态tick值, 此tick值为爬行者爆炸前点燃状态的维持时间.
     * <p>
     * 原文:
     * Get the maximum fuse ticks for this Creeper, where the maximum ticks 
     * is the amount of time in which a creeper is allowed to be in the 
     * primed state before exploding.
     *
     * @return 点燃状态的最大tick值
     */
    public int getMaxFuseTicks();

    /**
     * 设置爬行者的爆炸半径.
     * <p>
     * 原文:
     * Set the explosion radius in which this Creeper's explosion will affect.
     *
     * @param radius 新的爆炸半径
     */
    public void setExplosionRadius(int radius);

    /**
     * 获得爬行者的爆炸半径.
     * <p> 
     * 原文:
     * Get the explosion radius in which this Creeper's explosion will affect.
     *
     * @return 爆炸半径
     */
    public int getExplosionRadius();
}
