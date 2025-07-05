package org.bukkit.inventory.meta.trim;

import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.Translatable;
import org.bukkit.registry.RegistryAware;
import org.jetbrains.annotations.NotNull;

/**
 * 表示可以在 {@link ArmorTrim} 中使用的材质。
 * <p>
 * 原文: Represents a material that may be used in an {@link ArmorTrim}.
 */
public interface TrimMaterial extends Keyed, Translatable, RegistryAware {

    /**
     * 石英
     * {@link Material#QUARTZ}.
     */
    public static final TrimMaterial QUARTZ = getTrimMaterial("quartz");
    /**
     * 铁锭
     * {@link Material#IRON_INGOT}.
     */
    public static final TrimMaterial IRON = getTrimMaterial("iron");
    /**
     * 下界合金锭
     * {@link Material#NETHERITE_INGOT}.
     */
    public static final TrimMaterial NETHERITE = getTrimMaterial("netherite");
    /**
     * 红石
     * {@link Material#REDSTONE}.
     */
    public static final TrimMaterial REDSTONE = getTrimMaterial("redstone");
    /**
     * 铜锭
     * {@link Material#COPPER_INGOT}.
     */
    public static final TrimMaterial COPPER = getTrimMaterial("copper");
    /**
     * 金锭
     * {@link Material#GOLD_INGOT}.
     */
    public static final TrimMaterial GOLD = getTrimMaterial("gold");
    /**
     * 绿宝石
     * {@link Material#EMERALD}.
     */
    public static final TrimMaterial EMERALD = getTrimMaterial("emerald");
    /**
     * 钻石
     * {@link Material#DIAMOND}.
     */
    public static final TrimMaterial DIAMOND = getTrimMaterial("diamond");
    /**
     * 青金石
     * {@link Material#LAPIS_LAZULI}.
     */
    public static final TrimMaterial LAPIS = getTrimMaterial("lapis");
    /**
     * 紫水晶碎片
     * {@link Material#AMETHYST_SHARD}.
     */
    public static final TrimMaterial AMETHYST = getTrimMaterial("amethyst");
    /**
     * 树脂砖
     * {@link Material#RESIN_BRICK}.
     */
    public static final TrimMaterial RESIN = getTrimMaterial("resin");

    @NotNull
    private static TrimMaterial getTrimMaterial(@NotNull String key) {
        return Registry.TRIM_MATERIAL.getOrThrow(NamespacedKey.minecraft(key));
    }

    /**
     * {@inheritDoc}
     *
     * @see #getKeyOrThrow()
     * @see #isRegistered()
     * @deprecated A key might not always be present, use {@link #getKeyOrThrow()} instead.
     */
    @NotNull
    @Override
    @Deprecated(since = "1.21.4")
    NamespacedKey getKey();
}