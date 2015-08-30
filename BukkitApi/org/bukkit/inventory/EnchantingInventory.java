package org.bukkit.inventory;

/**
 * 附魔的用户界面接口
 * <p>
 * 原文:Interface to the inventory of an Enchantment Table.
 */
public interface EnchantingInventory extends Inventory {

    /**
     * 设置要被附魔主要效果的Item项目.
     * <p>
     * 原文:Set the item being enchanted.
     *
     * @param item 需要设置的Item项目.
     */
    void setItem(ItemStack item);

    /**
     * 获取被附魔主要效果的Item项目.
     * <p>
     * 原文:Get the item being enchanted.
     *
     * @return Item项目.
     */
    ItemStack getItem();

    /**
     * 设置被用来附魔的辅助材料Item项目.
     * <p>
     * 原文: Set the secondary item being used for the enchant.
     *
     * @param item 新的辅助材料.
     */
    void setSecondary(ItemStack item);

    /**
     * 获取当前附魔物品的辅助Item项目.
     * <p>
     * 原文: Get the secondary item being used for the enchant.
     *
     * @return 辅助物品.
     */
    ItemStack getSecondary();
}