package org.bukkit.enchantments;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

/**
 * 方便选择{@link Enchantment}s的一个简单的封装类。
 * <p>
 * 大多数方法于{@link Enchantment}。
 */
public class EnchantmentWrapper extends Enchantment {
    public EnchantmentWrapper(String name) {
        super(NamespacedKey.minecraft(name));
    }

    /**
     * 得到这个包装类所对应的的附魔.
     * <p>
     * 原文：Gets the enchantment bound to this wrapper
     *
     * @return 附魔
     */
    public Enchantment getEnchantment() {
        return Enchantment.getByKey(getKey());
    }

    @Override
    public int getMaxLevel() {
        return getEnchantment().getMaxLevel();
    }

    @Override
    public int getStartLevel() {
        return getEnchantment().getStartLevel();
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return getEnchantment().getItemTarget();
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return getEnchantment().canEnchantItem(item);
    }

    @Override
    public String getName() {
        return getEnchantment().getName();
    }
    @Override
    public boolean isTreasure() {
        return getEnchantment().isTreasure();
    }

    @Override
    public boolean isCursed() {
        return getEnchantment().isCursed();
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        return getEnchantment().conflictsWith(other);
    }
}