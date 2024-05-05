package org.bukkit.enchantments;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 方便选择{@link Enchantment}的一个简单的封装类.
 * @deprecated 仅为保障向后兼容性, EnchantmentWrapper 已不再使用
 */
public abstract class EnchantmentWrapper extends Enchantment {
    protected EnchantmentWrapper() {
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
        return this;
    }
}