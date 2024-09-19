package org.bukkit.inventory.meta.trim;

import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.Translatable;

/**
 * 表示可以在 {@link ArmorTrim} 中使用的材质。
 * <p>
 * 原文: Represents a material that may be used in an {@link ArmorTrim}.
 */
public interface TrimMaterial extends Keyed, Translatable {

    /**
     * 石英
     * {@link Material#QUARTZ}.
     */
    public static final TrimMaterial QUARTZ = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("quartz"));
    /**
     * 铁锭
     * {@link Material#IRON_INGOT}.
     */
    public static final TrimMaterial IRON = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("iron"));
    /**
     * 下界合金锭
     * {@link Material#NETHERITE_INGOT}.
     */
    public static final TrimMaterial NETHERITE = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("netherite"));
    /**
     * 红石
     * {@link Material#REDSTONE}.
     */
    public static final TrimMaterial REDSTONE = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("redstone"));
    /**
     * 铜锭
     * {@link Material#COPPER_INGOT}.
     */
    public static final TrimMaterial COPPER = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("copper"));
    /**
     * 金锭
     * {@link Material#GOLD_INGOT}.
     */
    public static final TrimMaterial GOLD = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("gold"));
    /**
     * 绿宝石
     * {@link Material#EMERALD}.
     */
    public static final TrimMaterial EMERALD = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("emerald"));
    /**
     * 钻石
     * {@link Material#DIAMOND}.
     */
    public static final TrimMaterial DIAMOND = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("diamond"));
    /**
     * 青金石
     * {@link Material#LAPIS_LAZULI}.
     */
    public static final TrimMaterial LAPIS = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("lapis"));
    /**
     * 紫水晶碎片
     * {@link Material#AMETHYST_SHARD}.
     */
    public static final TrimMaterial AMETHYST = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("amethyst"));
}
