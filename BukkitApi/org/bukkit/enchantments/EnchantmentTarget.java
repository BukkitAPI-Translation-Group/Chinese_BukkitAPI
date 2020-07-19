package org.bukkit.enchantments;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表了{@link Enchantment}的适用目标
 */
public enum EnchantmentTarget {
    /**
     * 允许将这个附魔用于所有的物品上.
     * <p>
     * 原文：
     * Allows the Enchantment to be placed on all items
     *
     * @deprecated 原版中该适用目标不复存在
     */
    @Deprecated
    ALL {
        @Override
        public boolean includes(@NotNull Material item) {
            for (EnchantmentTarget target : EnchantmentTarget.values()) {
                if (target != this && target.includes(item)) {
                    return true;
                }
            }

            return false;
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
        public boolean includes(@NotNull Material item) {
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
        public boolean includes(@NotNull Material item) {
            return item.equals(Material.LEATHER_BOOTS)
                || item.equals(Material.CHAINMAIL_BOOTS)
                || item.equals(Material.IRON_BOOTS)
                || item.equals(Material.DIAMOND_BOOTS)
                || item.equals(Material.GOLDEN_BOOTS)
                || item.equals(Material.NETHERITE_BOOTS);
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
        public boolean includes(@NotNull Material item) {
            return item.equals(Material.LEATHER_LEGGINGS)
                || item.equals(Material.CHAINMAIL_LEGGINGS)
                || item.equals(Material.IRON_LEGGINGS)
                || item.equals(Material.DIAMOND_LEGGINGS)
                || item.equals(Material.GOLDEN_LEGGINGS)
                || item.equals(Material.NETHERITE_LEGGINGS);
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
        public boolean includes(@NotNull Material item) {
            return item.equals(Material.LEATHER_CHESTPLATE)
                || item.equals(Material.CHAINMAIL_CHESTPLATE)
                || item.equals(Material.IRON_CHESTPLATE)
                || item.equals(Material.DIAMOND_CHESTPLATE)
                || item.equals(Material.GOLDEN_CHESTPLATE)
                || item.equals(Material.NETHERITE_CHESTPLATE);
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
        public boolean includes(@NotNull Material item) {
            return item.equals(Material.LEATHER_HELMET)
                || item.equals(Material.CHAINMAIL_HELMET)
                || item.equals(Material.DIAMOND_HELMET)
                || item.equals(Material.IRON_HELMET)
                || item.equals(Material.GOLDEN_HELMET)
                || item.equals(Material.TURTLE_HELMET)
                || item.equals(Material.NETHERITE_HELMET);
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
        public boolean includes(@NotNull Material item) {
            return item.equals(Material.WOODEN_SWORD)
                || item.equals(Material.STONE_SWORD)
                || item.equals(Material.IRON_SWORD)
                || item.equals(Material.DIAMOND_SWORD)
                || item.equals(Material.GOLDEN_SWORD)
                || item.equals(Material.NETHERITE_SWORD);
        }
    },

    /**
     * 允许将该附魔用于工具上，如锹，稿，斧。
     * <p>
     * 原文:
     * Allows the Enchantment to be placed on tools (spades, pickaxe, axes)
     */
    TOOL {
        @Override
        public boolean includes(@NotNull Material item) {
            return item.equals(Material.WOODEN_SHOVEL)
                || item.equals(Material.STONE_SHOVEL)
                || item.equals(Material.IRON_SHOVEL)
                || item.equals(Material.DIAMOND_SHOVEL)
                || item.equals(Material.GOLDEN_SHOVEL)
                || item.equals(Material.NETHERITE_SHOVEL)
                || item.equals(Material.WOODEN_PICKAXE)
                || item.equals(Material.STONE_PICKAXE)
                || item.equals(Material.IRON_PICKAXE)
                || item.equals(Material.DIAMOND_PICKAXE)
                || item.equals(Material.GOLDEN_PICKAXE)
                || item.equals(Material.NETHERITE_PICKAXE)
                || item.equals(Material.WOODEN_AXE)
                || item.equals(Material.STONE_AXE)
                || item.equals(Material.IRON_AXE)
                || item.equals(Material.DIAMOND_AXE)
                || item.equals(Material.GOLDEN_AXE)
                || item.equals(Material.NETHERITE_AXE)
                || item.equals(Material.WOODEN_HOE)
                || item.equals(Material.STONE_HOE)
                || item.equals(Material.IRON_HOE)
                || item.equals(Material.DIAMOND_HOE)
                || item.equals(Material.GOLDEN_HOE)
                || item.equals(Material.NETHERITE_HOE);
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
        public boolean includes(@NotNull Material item) {
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
        public boolean includes(@NotNull Material item) {
            return item.equals(Material.FISHING_ROD);
        }
    },

    /**
     * 允许将该附魔用于带耐久度的物品上.
     * <p>
     * 原文:Allows the enchantment to be placed on items with durability.
     */
    BREAKABLE {
        @Override
        public boolean includes(@NotNull Material item) {
            return item.getMaxDurability() > 0 && item.getMaxStackSize() == 1;
        }
    },

    /**
     * 允许将这类附魔附加于可穿戴物品.
     * <p>
     * 原文:Allows the enchantment to be placed on wearable items.
     */
    WEARABLE {
        @Override
        public boolean includes(@NotNull Material item) {
            return ARMOR.includes(item)
                    || item.equals(Material.ELYTRA)
                    || item.equals(Material.CARVED_PUMPKIN)
                    || item.equals(Material.JACK_O_LANTERN)
                    || item.equals(Material.SKELETON_SKULL)
                    || item.equals(Material.WITHER_SKELETON_SKULL)
                    || item.equals(Material.ZOMBIE_HEAD)
                    || item.equals(Material.PLAYER_HEAD)
                    || item.equals(Material.CREEPER_HEAD)
                    || item.equals(Material.DRAGON_HEAD);
        }
    },

    /**
     * 允许将这类附魔附加于三叉戟.
     */
    TRIDENT {
        @Override
        public boolean includes(@NotNull Material item) {
            return item.equals(Material.TRIDENT);
        }
    },

    /**
     * 允许将这类附魔附加于弩上.
     */
    CROSSBOW {
        @Override
        public boolean includes(@NotNull Material item) {
            return item.equals(Material.CROSSBOW);
        }
    },

    /**
     * 允许将这类附魔附加于vanishing items.
     */
    VANISHABLE {
        @Override
        public boolean includes(@NotNull Material item) {
            return BREAKABLE.includes(item) || (WEARABLE.includes(item) && !item.equals(Material.ELYTRA)) || item.equals(Material.COMPASS);
        }
    };

    /**
     * 检查本适用目标是否包含该物品类型.
     * <p>
     * 原文：
     * Check whether this target includes the specified item.
     *
     * @param item 物品
     * @return 如果包含则返回true
     */
    public abstract boolean includes(@NotNull Material item);

    /**
     * 检查本适用目标是否包含该物品.
     * <p>
     * 原文：Check whether this target includes the specified item.
     *
     * @param item 物品
     * @return 如果包含则返回true
     */
    public boolean includes(@NotNull ItemStack item) {
        return includes(item.getType());
    }
}