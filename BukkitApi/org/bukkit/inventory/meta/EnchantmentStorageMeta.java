package org.bukkit.inventory.meta;

import java.util.Map;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

/**
 * EnchantmentMeta is specific to items that can <i>store</i> enchantments, as
 * opposed to being enchanted. {@link Material#ENCHANTED_BOOK} is an example
 * of an item with enchantment storage.
 */
public interface EnchantmentStorageMeta extends ItemMeta {

    /**
     * 检测是否存在任何附魔.
     * <p>
     * 原文:Checks for the existence of any stored enchantments.
     *
     * @return 这个meta是否存在一个附魔
     */
    boolean hasStoredEnchants();

    /**
     * Checks for storage of the specified enchantment.
     *
     * @param ench enchantment to check
     * @return true if this enchantment is stored in this meta
     */
    boolean hasStoredEnchant(Enchantment ench);

    /**
     * Checks for the level of the stored enchantment.
     *
     * @param ench enchantment to check
     * @return The level that the specified stored enchantment has, or 0 if
     *     none
     */
    int getStoredEnchantLevel(Enchantment ench);

    /**
     * 获取在ItemMeta存储的附魔的副本.
     * <p>
     * 原文:Gets a copy the stored enchantments in this ItemMeta.
     *
     * @return 一个不可变的存储的附魔的副本
     */
    Map<Enchantment, Integer> getStoredEnchants();

    /**
     * Stores the specified enchantment in this item meta.
     *
     * @param ench Enchantment to store
     * @param level Level for the enchantment
     * @param ignoreLevelRestriction this indicates the enchantment should be
     *     applied, ignoring the level limit
     * @return true if the item meta changed as a result of this call, false
     *     otherwise
     * @throws IllegalArgumentException if enchantment is null
     */
    boolean addStoredEnchant(Enchantment ench, int level, boolean ignoreLevelRestriction);

    /**
     * Remove the specified stored enchantment from this item meta.
     *
     * @param ench Enchantment to remove
     * @return true if the item meta changed as a result of this call, false
     *     otherwise
     * @throws IllegalArgumentException if enchantment is null
     */
    boolean removeStoredEnchant(Enchantment ench) throws IllegalArgumentException;

    /**
     * 检测指定的附魔是否与任何ItemMeta里的附魔冲突.
     * <p>
     * 原文:Checks if the specified enchantment conflicts with any enchantments in
     * this ItemMeta.
     *
     * @param ench 要检测的附魔
     * @return 附魔是否与任何ItemMeta里的附魔冲突
     */
    boolean hasConflictingStoredEnchant(Enchantment ench);

    EnchantmentStorageMeta clone();
}
