package org.bukkit.entity;

/**
 * 表示一只箭矢.
 */
public interface Arrow extends Projectile {

    /**
     * 获取箭头的击退强度,这表示附魔{@link org.bukkit.enchantments.Enchantment#KNOCKBACK 力量}等级. 
     * <p>
     * 原文:Gets the knockback strength for an arrow, which is the
     * {@link org.bukkit.enchantments.Enchantment#KNOCKBACK KnockBack} level
     * of the bow that shot it.mine
     *
     * @return 附魔击退等级
     */
    public int getKnockbackStrength();

    /**
     * 设置箭矢的附魔击退等级. 
     * <p>
     * 原文: Sets the knockback strength for an arrow.
     *
     * @param knockbackStrength 附魔击退等级
     */
    public void setKnockbackStrength(int knockbackStrength);

    /**
     * 获取此箭矢是否产生暴击. </br>
     * 产生暴击的箭矢会产生更多的伤害并伴随粒子效果. </br>
     * 暴击箭矢通常发生在玩家满弓射箭时.
     * <p>
     * 原文: Gets whether this arrow is critical.</br>
     * Critical arrows have increased damage and cause particle effects.</br>
     * Critical arrows generally occur when a player fully draws a bow before firing.
     *
     * @return 如果是暴击箭矢则返回true
     */
    public boolean isCritical();

    /**
     * 设置这个箭矢是否是否产生了暴击. 
     * <p>
     * 原文:Sets whether or not this arrow should be critical.
     *
     * @param critical 它是否是否产生了暴击
     */
    public void setCritical(boolean critical);

    /**
     * 获取此箭矢是否嵌入于一个方块中.
     * <p>
     * 嵌入于方块中的箭矢是静止的，并且可能被玩家拾取.
     * <p>
     * 原文:Gets whether this arrow is in a block or not.
     * <p>
     * Arrows in a block are motionless and may be picked up by players.
     *
     * @return 此箭矢是否嵌入于方块中
     */
    public boolean isInBlock();

    /**
     * 获取该箭矢附着在哪个方块上.
     * <p>
     * 原文:Gets the block to which this arrow is attached.
     *
     * @return 箭矢附着(嵌入)的方块，若箭矢没有嵌入于方块中返回null
     */
    public Block getAttachedBlock();

    /**
     * 获取此箭矢的当前拾取状态. 
     * <p>
     * 原文:Gets the current pickup status of this arrow.
     *
     * @return 此箭矢的拾取状态
     */
    public PickupStatus getPickupStatus();

    /**
     * 设置此箭矢的当前拾取状态. 
     * <p>
     * 原文:Sets the current pickup status of this arrow.
     *
     * @param status 此箭矢新的拾取状态
     */
    public void setPickupStatus(PickupStatus status);

    /**
     * 表示此箭矢的拾取状态. 
     */
    public enum PickupStatus {
        /**
         * 此箭矢不能被拾取. 
         */
        DISALLOWED,
        /**
         * 此箭矢能被拾取. 
         */
        ALLOWED,
        /**
         * 此箭矢只能被处于创造模式的玩家拾取. 
         */
        CREATIVE_ONLY
    }
}
