package org.bukkit.entity;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface ThrowableProjectile extends Projectile {

    /**
     * 获取投掷弹射物将显示的ItemStack.
     * <p>
     * 原文：
     * Gets the ItemStack the thrown projectile will display.
     *
     * @return 投掷物品显示的ItemStack
     */
    @NotNull
    ItemStack getItem();

    /**
     * 设置投掷弹射物显示的ItemStack.
     * <p>
     * 原文：
     * Sets the display ItemStack for the thrown projectile.
     *
     * @param item 要显示的ItemStack
     */
    void setItem(@NotNull ItemStack item);
}
