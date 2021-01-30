package org.bukkit.inventory.meta;

import java.util.List;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表弩.
 */
public interface CrossbowMeta extends ItemMeta {

    /**
     * 返回弩是否装填了抛射物.
     * <p>
     * 原文:
     * Returns whether the item has any charged projectiles.
     *
     * @return 弩是否装填了抛射物
     */
    boolean hasChargedProjectiles();

    /**
     * 返回弩装填的抛射物的不可变列表.
     * <p>
     * 原文:
     * Returns an immutable list of the projectiles charged on this item.
     *
     * @return 装填的抛射物
     */
    @NotNull
    List<ItemStack> getChargedProjectiles();

    /**
     * 设置弩装填的抛射物.
     *
     * 为 null 时移除所有抛射物.
     * <p>
     * 原文:
     * Sets the projectiles charged on this item.
     *
     * Removes all projectiles when given null.
     *
     * @param projectiles 要装填的抛射物
     * @throws IllegalArgumentException 如果任意一个抛射物不是箭或烟花火箭
     */
    void setChargedProjectiles(@Nullable List<ItemStack> projectiles);

    /**
     * 向本弩装填一个抛射物.
     * <p>
     * 原文:
     * Adds a charged projectile to this item.
     *
     * @param item 抛射物
     * @throws IllegalArgumentException 若抛射物不是箭或烟花火箭
     */
    void addChargedProjectile(@NotNull ItemStack item);
}
