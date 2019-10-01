package org.bukkit.entity;

import java.util.Collection;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

/**
 * 代表一个被抛出的药水瓶.
 */
public interface ThrownPotion extends Projectile {

    /**
     * 返回应用于此药水瓶的药水效果.
     * <p>
     * 原文:
     * Returns the effects that are applied by this potion.
     *
     * @return 药水效果
     */
    public Collection<PotionEffect> getEffects();

    /**
     * 返回此药水瓶物品的副本.
     * <p>
     * 修改此物品副本并不会直接修改这个被抛出的药水瓶本身.
     * 如果你希望修改此药水瓶, 你必须使用{@link
     * #setItem(ItemStack) setItemStack}方法.
     * <p>
     * 原文:
     * Returns a copy of the ItemStack for this thrown potion.
     * <p>
     * Altering this copy will not alter the thrown potion directly. If you
     * want to alter the thrown potion, you must use the {@link
     * #setItem(ItemStack) setItemStack} method.
     *
     * @return 此药水瓶的副本
     */
    public ItemStack getItem();

    /**
     * 设置此药水瓶物品.
     * <p>
     * 设置的物品必须为药水, 否则此方法会抛出异常.
     * <p>
     * 原文:
     * Set the ItemStack for this thrown potion.
     * <p>
     * The ItemStack must be a potion, otherwise an exception is thrown.
     *
     * @param item 要设置的药水物品.
     */
    public void setItem(ItemStack item);
}
