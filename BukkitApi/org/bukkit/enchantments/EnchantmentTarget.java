package org.bukkit.enchantments;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * 代表了{@link Enchantment}的适用目标
 */
public enum EnchantmentTarget {
    /**
     * 允许将这个附魔用于所有的物品上.
     * <p>
     * 原文：
     * Allows the Enchantment to be placed on all items
     */
    ALL {
        @Override
        public boolean includes(Material item) {
            return true;
        }
    },

    /**
     * 允许将该附魔用于装备上. (包括鞋子，护腿，衣服以及帽子)
     * <p>
     * 原文：
     * Allows the Enchantment to be placed on armor
     */
    ARMOR {
        @Override
        public boolean includes(Material item) {
            return ARMOR_FEET.includes(item)
                || ARMOR_LEGS.includes(item)
                || ARMOR_HEAD.includes(item)
                || ARMOR_TORSO.includes(item);
        }
    },

    /**
     * 允许将该附魔用于鞋子上.
     * <p>
     * 原文：
     * Allows the Enchantment to be placed on feet slot armor
     */
    ARMOR_FEET {
        @Override
        public boolean includes(Material item) {
            return item.equals(Material.LEATHER_BOOTS)
                || item.equals(Material.CHAINMAIL_BOOTS)
                || item.equals(Material.IRON_BOOTS)
                || item.equals(Material.DIAMOND_BOOTS)
                || item.equals(Material.GOLD_BOOTS);
        }
    },

    /**
     * 允许将该附魔用于护腿上.
     * <p>
     * 原文：
     * Allows the Enchantment to be placed on leg slot armor
     */
    ARMOR_LEGS {
        @Override
        public boolean includes(Material item) {
            return item.equals(Material.LEATHER_LEGGINGS)
                || item.equals(Material.CHAINMAIL_LEGGINGS)
                || item.equals(Material.IRON_LEGGINGS)
                || item.equals(Material.DIAMOND_LEGGINGS)
                || item.equals(Material.GOLD_LEGGINGS);
        }
    },

    /**
     * 允许将该附魔用于衣服上.
     * <p>
     * 原文：
     * Allows the Enchantment to be placed on torso slot armor
     */
    ARMOR_TORSO {
        @Override
        public boolean includes(Material item) {
            return item.equals(Material.LEATHER_CHESTPLATE)
                || item.equals(Material.CHAINMAIL_CHESTPLATE)
                || item.equals(Material.IRON_CHESTPLATE)
                || item.equals(Material.DIAMOND_CHESTPLATE)
                || item.equals(Material.GOLD_CHESTPLATE);
        }
    },

    /**
     * 允许将该附魔用于帽子上.
     * <p>
     * 原文：
     * Allows the Enchantment to be placed on head slot armor
     */
    ARMOR_HEAD {
        @Override
        public boolean includes(Material item) {
            return item.equals(Material.LEATHER_HELMET)
                || item.equals(Material.CHAINMAIL_HELMET)
                || item.equals(Material.DIAMOND_HELMET)
                || item.equals(Material.IRON_HELMET)
                || item.equals(Material.GOLD_HELMET);
        }
    },

    /**
     * 允许将该附魔用于剑上.
     * <p>
     * 原文：
     * Allows the Enchantment to be placed on weapons (swords)
     */
    WEAPON {
        @Override
        public boolean includes(Material item) {
            return item.equals(Material.WOOD_SWORD)
                || item.equals(Material.STONE_SWORD)
                || item.equals(Material.IRON_SWORD)
                || item.equals(Material.DIAMOND_SWORD)
                || item.equals(Material.GOLD_SWORD);
        }
    },

    /**
     * 允许将该附魔用于工具上，如锹，稿，锄，斧。
     * <p>
     * 原文:
     * Allows the Enchantment to be placed on tools (spades, pickaxe, hoes,
     * axes)
     */
    TOOL {
        @Override
        public boolean includes(Material item) {
            return item.equals(Material.WOOD_SPADE)
                || item.equals(Material.STONE_SPADE)
                || item.equals(Material.IRON_SPADE)
                || item.equals(Material.DIAMOND_SPADE)
                || item.equals(Material.GOLD_SPADE)
                || item.equals(Material.WOOD_PICKAXE)
                || item.equals(Material.STONE_PICKAXE)
                || item.equals(Material.IRON_PICKAXE)
                || item.equals(Material.DIAMOND_PICKAXE)
                || item.equals(Material.GOLD_PICKAXE)
                || item.equals(Material.WOOD_HOE)         // 注: 并没有一个适用于它的附魔(锄头没有附魔)
                || item.equals(Material.STONE_HOE)        // 注: 并没有一个适用于它的附魔(锄头没有附魔)
                || item.equals(Material.IRON_HOE)         // 注: 并没有一个适用于它的附魔(锄头没有附魔)
                || item.equals(Material.DIAMOND_HOE)      // 注: 并没有一个适用于它的附魔(锄头没有附魔)
                || item.equals(Material.GOLD_HOE)         // 注: 并没有一个适用于它的附魔(锄头没有附魔)
                || item.equals(Material.WOOD_AXE)
                || item.equals(Material.STONE_AXE)
                || item.equals(Material.IRON_AXE)
                || item.equals(Material.DIAMOND_AXE)
                || item.equals(Material.GOLD_AXE)
                || item.equals(Material.SHEARS)           // NOTE: 并没有一个适用于它的附魔(剪刀没有附魔)
                || item.equals(Material.FLINT_AND_STEEL); // NOTE: 并没有一个适用于它的附魔(打火石没有附魔)
        }
    },

    /**
     * 允许将该附魔用于弓上.
     * <p>
     * 原文：
     * Allows the Enchantment to be placed on bows.
     */
    BOW {
        @Override
        public boolean includes(Material item) {
            return item.equals(Material.BOW);
        }
    },

    /**
     * 允许将该附魔用于钓鱼竿上.
     * <p>
     * 原文：
     * Allows the Enchantment to be placed on fishing rods.
     */
    FISHING_ROD {
        @Override
        public boolean includes(Material item) {
            return item.equals(Material.FISHING_ROD);
        }
    };

    /**
     * 检查是否包含该物品类型.
     * <p>
     * 原文：
     * Check whether this target includes the specified item.
     *
     * @param item 物品
     * @return 如果包含则返回true。
     */
    public abstract boolean includes(Material item);

    /**
     * 检查是否包含该物品.
     * <p>
     * 原文：Check whether this target includes the specified item.
     *
     * @param item 物品
     * @return 如果包含则返回true。
     */
    public boolean includes(ItemStack item) {
        return includes(item.getType());
    }
}