package org.bukkit.inventory.meta;

import java.util.Map;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.jetbrains.annotations.NotNull;

/**
 * EnchantmentMeta 特定于专门<i>存储</i>附魔的物品, 而非被附魔的物品.
 * {@link Material#ENCHANTED_BOOK 附魔书} 就是一个可存储附魔的物品的例子.
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
     * 检测是否存储特定的附魔.
     * <p>
     * 原文:Checks for storage of the specified enchantment.
     *
     * @param ench 要检测的附魔
     * @return 若此附魔存放于本 meta 中返回 true
     */
    boolean hasStoredEnchant(@NotNull Enchantment ench);

    /**
     * 检测指定附魔的等级.
     * <p>
     * 原文:Checks for the level of the stored enchantment.
     *
     * @param ench 要检测的附魔
     * @return 附魔等级, 0 代表不存在此附魔
     */
    int getStoredEnchantLevel(@NotNull Enchantment ench);

    /**
     * 获取在ItemMeta存储的附魔的副本.
     * <p>
     * 原文:Gets a copy the stored enchantments in this ItemMeta.
     *
     * @return 一个不可变的存储的附魔的副本
     */
    @NotNull
    Map<Enchantment, Integer> getStoredEnchants();

    /**
     * 向本物品存放一个指定的附魔.
     * <p>
     * 原文:Stores the specified enchantment in this item meta.
     *
     * @param ench 要存储的附魔
     * @param level 附魔等级
     * @param ignoreLevelRestriction 是否忽略附魔的等级限制
     * @return 添加附魔成功返回 true, false反之
     * @throws IllegalArgumentException 若指定附魔为 null
     */
    boolean addStoredEnchant(@NotNull Enchantment ench, int level, boolean ignoreLevelRestriction);

    /**
     * 移除物品上指定的附魔.
     * <p>
     * 原文:Remove the specified stored enchantment from this item meta.
     *
     * @param ench 要移除的附魔
     * @return 移除附魔成功返回 true, false反之
     * @throws IllegalArgumentException 若指定附魔为 null
     */
    boolean removeStoredEnchant(@NotNull Enchantment ench) throws IllegalArgumentException;

    /**
     * 检测指定的附魔是否与任何 ItemMeta 里的附魔冲突.
     * <p>
     * 原文:Checks if the specified enchantment conflicts with any enchantments in
     * this ItemMeta.
     *
     * @param ench 要检测的附魔
     * @return 有冲突的附魔返回 true, false 反之
     */
    boolean hasConflictingStoredEnchant(@NotNull Enchantment ench);

    @Override
    @NotNull
    EnchantmentStorageMeta clone();
}
