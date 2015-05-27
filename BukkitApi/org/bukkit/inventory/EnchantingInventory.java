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
     * Set the secondary item being used for the enchant.
     *
     * @param item new item
     */
    void setSecondary(ItemStack item);

    /**
     * Get the secondary item being used for the enchant.
     *
     * @return The second item
     */
    ItemStack getSecondary();
}