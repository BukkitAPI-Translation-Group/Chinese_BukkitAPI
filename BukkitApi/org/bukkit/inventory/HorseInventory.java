package org.bukkit.inventory;

import org.jetbrains.annotations.Nullable;

/**
 * 马(抽象)的界面接口.
 */
public interface HorseInventory extends AbstractHorseInventory {

    /**
     * 获取马所装备的盔甲.
     * <p>
     * 原文:Gets the item in the horse's armor slot.
     *
     * @return 盔甲
     */
    @Nullable
    ItemStack getArmor();

    /**
     * 为这匹马装备盔甲.
     * <p>
     * 原文:Sets the item in the horse's armor slot.
     *
     * @param stack 盔甲
     */
    void setArmor(@Nullable ItemStack stack);
}
