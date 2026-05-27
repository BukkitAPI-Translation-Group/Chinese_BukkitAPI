package org.bukkit.entity;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一个有大小的火球。
 */
public interface SizedFireball extends Fireball {

    /**
     * 获取显示用的 {@link ItemStack}。
     * <p>
     * 原文：Gets the display {@link ItemStack}.
     *
     * @return 显示用的ItemStack
     */
    @NotNull
    ItemStack getDisplayItem();

    /**
     * 设置火球显示用的 {@link ItemStack}。
     * <p>
     * 原文：Sets the display {@link ItemStack} for the fireball.
     *
     * @param item 要显示的ItemStack
     */
    void setDisplayItem(@NotNull ItemStack item);
}
