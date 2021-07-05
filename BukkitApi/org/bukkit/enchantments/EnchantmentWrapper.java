package org.bukkit.enchantments;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 方便选择{@link Enchantment}的一个简单的封装类.
 */
public class EnchantmentWrapper extends Enchantment {
    public EnchantmentWrapper(@NotNull String name) {
        super(NamespacedKey.minecraft(name));
    }

    /**
     * 获取这个包装类所对应的的附魔.
     * <p>
     * 原文:Gets the enchantment bound to this wrapper
     *
     * @return 附魔
     */
    @NotNull
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

    @NotNull
    @Override
    public EnchantmentTarget getItemTarget() {
        return getEnchantment().getItemTarget();
    }

    @Override
    public boolean canEnchantItem(@NotNull ItemStack item) {
        return getEnchantment().canEnchantItem(item);
    }

    @NotNull
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
    public boolean conflictsWith(@NotNull Enchantment other) {
        return getEnchantment().conflictsWith(other);
    }
}