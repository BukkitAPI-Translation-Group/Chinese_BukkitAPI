package org.bukkit.inventory;

import org.jetbrains.annotations.Nullable;

/**
 * 附魔界面接口
 */
public interface EnchantingInventory extends Inventory {

    /**
     * 设置将被附魔的物品.
     * <p>
     * 原文:Set the item being enchanted.
     *
     * @param item 将被附魔的物品
     */
    void setItem(@Nullable ItemStack item);

    /**
     * 获取将被附魔的物品.
     * <p>
     * 原文:Get the item being enchanted.
     *
     * @return 将被附魔的物品.
     */
    @Nullable
    ItemStack getItem();

    /**
     * 设置将被用于附魔的第二物品(如青金石).
     * <p>
     * 原文: Set the secondary item being used for the enchant.
     *
     * @param item 将被用于附魔的第二物品
     */
    void setSecondary(@Nullable ItemStack item);

    /**
     * 获取将被用于附魔的第二物品(如青金石).
     * <p>
     * 原文: Get the secondary item being used for the enchant.
     *
     * @return 将被用于附魔的第二物品
     */
    @Nullable
    ItemStack getSecondary();
}
