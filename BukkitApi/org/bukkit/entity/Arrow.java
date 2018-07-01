package org.bukkit.entity;

/**
 * 表示箭矢.
 * <p>
 * 原文: Represents an arrow.
 */
public interface Arrow extends Projectile {

    /**
     * 获取箭头的击退强度,这是射箭的{@link org.bukkit.enchantments.Enchantment#KNOCKBACK 力量}等级.
     * <p>
     * 原文:Gets the knockback strength for an arrow, which is the
     * {@link org.bukkit.enchantments.Enchantment#KNOCKBACK KnockBack} level
     * of the bow that shot it.
     *
     * @return 击退强度值
     */
    public int getKnockbackStrength();

    /**
     * 设置箭矢的击退强度.
     * <p>
     * 原文: Sets the knockback strength for an arrow.
     *
     * @param knockbackStrength 击退强度值
     */
    public void setKnockbackStrength(int knockbackStrength);

    /**
     * 获取此箭头是否重要.</br>
     * 重要的箭增加了伤害并产生粒子效果.</br>
     * 重要的箭通常发生在玩家在射箭前拉满弓.
     * <p>
     * 原文: Gets whether this arrow is critical.</br>
     * Critical arrows have increased damage and cause particle effects.</br>
     * Critical arrows generally occur when a player fully draws a bow before firing.
     *
     * @return 如果是重要的就返回true
     */
    public boolean isCritical();

    /**
     * 设置这个箭矢是否应该是重要的.
     * <p>
     * 原文:Sets whether or not this arrow should be critical.
     *
     * @param critical 它是否应该是重要的
     */
    public void setCritical(boolean critical);

    /**
     * 获取此箭矢的当前拾取状态.
     * <p>
     * 原文:Gets the current pickup status of this arrow.
     *
     * @return 此箭头的拾取状态
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
     * 表示此箭头的拾取状态 .
     * <p>
     * 原文:Represents the pickup status of this arrow.
     */
    public enum PickupStatus {
        /**
         * 此箭矢不能被拾取. 
         * <p>
         * 原文: The arrow cannot be picked up.
         */
        DISALLOWED,
        /**
         * 此箭矢能被拾取. 
         * <p>
         * 原文: The arrow can be picked up.
         */
        ALLOWED,
        /**
         * 此箭矢只能被创造玩家拾取. 
         * <p>
         * 原文: The arrow can only be picked up by players in creative mode.
         */
        CREATIVE_ONLY
    }
}
