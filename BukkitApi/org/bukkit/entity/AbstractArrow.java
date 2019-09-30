package org.bukkit.entity;

import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一支箭.
 * <p>
 * 原文:
 * Represents an arrow.
 */
public interface AbstractArrow extends Projectile {

    /**
     * 获得此箭的击退强度, 由射出此箭的弓箭 {@link org.bukkit.enchantments.Enchantment#KNOCKBACK KnockBack} 等级定义.
     * <p>
     * 原文:
     * Gets the knockback strength for an arrow, which is the
     * {@link org.bukkit.enchantments.Enchantment#KNOCKBACK KnockBack} level
     * of the bow that shot it.
     *
     * @return 击退强度值
     */
    public int getKnockbackStrength();

    /**
     * 设定箭的击退强度.
     * <p>
     * 原文:
     * Sets the knockback strength for an arrow.
     *
     * @param knockbackStrength 击退强度值
     */
    public void setKnockbackStrength(int knockbackStrength);

    /**
     * 获得此箭将造成的基本伤害值.
     * 
     * 普通箭默认为2.0, 附魔弓加成额外的伤害<code>0.5 * (1 + 力量附魔等级 )</code>
     * <p>
     * 原文:
     * Gets the base amount of damage this arrow will do.
     *
     * Defaults to 2.0 for a normal arrow with
     * <code>0.5 * (1 + power level)</code> added for arrows fired from
     * enchanted bows.
     *
     * @return 基本伤害值
     */
    public double getDamage();

    /**
     * 设置此箭将造成的基本伤害值.
     * <p>
     * 原文:
     * Sets the base amount of damage this arrow will do.
     *
     * @param damage 新的伤害值
     */
    public void setDamage(double damage);

    /**
     * 获得此箭能够穿透实体的次数.
     * <p>
     * 原文:
     * Gets the number of times this arrow can pierce through an entity.
     *
     * @return 穿透等级
     */
    public int getPierceLevel();

    /**
     * 设置此箭能够穿透实体的次数.
     *
     * 必须在 0 至 127 次之间.
     * <p>
     * 原文:
     * Sets the number of times this arrow can pierce through an entity.
     *
     * Must be between 0 and 127 times.
     *
     * @param pierceLevel 新的穿透等级
     */
    public void setPierceLevel(int pierceLevel);

    /**
     * 获得此箭是否能造成暴击.
     * <p>
     * 暴击箭将会增加伤害并产生粒子效果.
     * <p>
     * 暴击箭一般是发生在玩家将弓箭完全蓄力后发射.
     * <p>
     * 原文:
     * Gets whether this arrow is critical.
     * <p>
     * Critical arrows have increased damage and cause particle effects.
     * <p>
     * Critical arrows generally occur when a player fully draws a bow before
     * firing.
     *
     * @return 暴击返回true
     */
    public boolean isCritical();

    /**
     * 设置此箭是否暴击.
     * <p>
     * 原文:
     * Sets whether or not this arrow should be critical.
     *
     * @param critical 是否暴击
     */
    public void setCritical(boolean critical);

    /**
     * 获得此箭是否在一个方块上.
     * <p>
     * 在方块上的箭将静止, 且可能能被玩家拾起. 
     * <p>
     * 原文:
     * Gets whether this arrow is in a block or not.
     * <p>
     * Arrows in a block are motionless and may be picked up by players.
     *
     * @return 如果在方块上返回true
     */
    public boolean isInBlock();

    /**
     * 获得这支箭连接的方块.
     * 译注:箭插在方块上, 这个方块就是箭连接的方块.
     * <p>
     * 原文:
     * Gets the block to which this arrow is attached.
     *
     * @return 返回所连接的方块, 否则返回null
     */
    @Nullable
    public Block getAttachedBlock();

    /**
     * 获得此箭的拾起状态.
     * <p>
     * 原文:
     * Gets the current pickup status of this arrow.
     *
     * @return 这只箭的拾起状态.
     */
    @NotNull
    public PickupStatus getPickupStatus();

    /**
     * 设置此箭的拾起状态.
     * <p>
     * 原文:
     * Sets the current pickup status of this arrow.
     *
     * @param status 新的拾起状态.
     */
    public void setPickupStatus(@NotNull PickupStatus status);

    /**
     * 代表拾起状态.
     * <p>
     * 原文:
     * Represents the pickup status of this arrow.
     */
    public enum PickupStatus {
        /**
         * 不允许被拾起.
         * <p>
         * 原文:
         * The arrow cannot be picked up.
         */
        DISALLOWED,
        /**
         * 允许被拾起.
         * <p>
         * 原文:
         * The arrow can be picked up.
         */
        ALLOWED,
        /**
         * 只能被创造模式的玩家拾起.
         * <p>
         * 原文:
         * The arrow can only be picked up by players in creative mode.
         */
        CREATIVE_ONLY
    }
}
