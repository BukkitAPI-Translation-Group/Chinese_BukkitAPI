package org.bukkit.entity;

import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.ApiStatus;
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
     * @see #getWeapon()
     * @deprecated 发射武器的功能
     */
    @Deprecated(since = "1.21")
    public int getKnockbackStrength();

    /**
     * 设定箭的击退强度.
     * <p>
     * 原文:
     * Sets the knockback strength for an arrow.
     *
     * @param knockbackStrength 击退强度值
     * @see #setWeapon(org.bukkit.inventory.ItemStack)
     * @deprecated 发射武器的功能
     */
    @Deprecated(since = "1.21")
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
     * 获得此箭是否由弩射出.
     * <p>
     * 原文:
     * Gets if this arrow was shot from a crossbow.
     *
     * @return 如果由弩射出则返回true
     */
    public boolean isShotFromCrossbow();

    /**
     * 设置此箭是否由弩射出.
     * <p>
     * 原文:
     * Sets if this arrow was shot from a crossbow.
     *
     * @param shotFromCrossbow 是否由弩射出
     * @see #setWeapon(org.bukkit.inventory.ItemStack)
     * @deprecated 改用发射武器的功能
     */
    @Deprecated(since = "1.21")
    public void setShotFromCrossbow(boolean shotFromCrossbow);

    /**
     * 获取此箭被拾起时将获得的 ItemStack.
     * <p>
     * 原文:
     * Gets the ItemStack which will be picked up from this arrow.
     *
     * @return 被拾起的 ItemStack
     */
    @NotNull
    @ApiStatus.Experimental
    public ItemStack getItem();

    /**
     * 设置此箭被拾起时将获得的 ItemStack.
     * <p>
     * 原文:
     * Sets the ItemStack which will be picked up from this arrow.
     *
     * @param item 被拾起时的 ItemStack
     */
    @ApiStatus.Experimental
    public void setItem(@NotNull ItemStack item);

    /**
     * 获取发射此箭的 ItemStack.
     * <p>
     * 原文:
     * Gets the ItemStack which fired this arrow.
     *
     * @return 发射此箭的 ItemStack
     */
    @NotNull
    @ApiStatus.Experimental
    public ItemStack getWeapon();

    /**
     * 设置发射此箭的 ItemStack.
     * <p>
     * 原文:
     * Sets the ItemStack which fired this arrow.
     *
     * @param item 发射此箭的 ItemStack
     */
    @ApiStatus.Experimental
    public void setWeapon(@NotNull ItemStack item);

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
