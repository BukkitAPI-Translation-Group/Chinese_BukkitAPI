package org.bukkit.generator.structure;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.registry.RegistryAware;
import org.jetbrains.annotations.NotNull;

/**
 * 表示来自世界的结构。
 *
 * 列出的结构存在于默认服务器中。根据服务器的不同，
 * 可能会有额外的结构存在（例如由数据包添加的结构），
 * 可以通过 {@link Registry#STRUCTURE} 获取。
 */
public abstract class Structure implements Keyed, RegistryAware {

    public static final Structure PILLAGER_OUTPOST = getStructure("pillager_outpost");
    public static final Structure MINESHAFT = getStructure("mineshaft");
    public static final Structure MINESHAFT_MESA = getStructure("mineshaft_mesa");
    public static final Structure MANSION = getStructure("mansion");
    public static final Structure JUNGLE_PYRAMID = getStructure("jungle_pyramid");
    public static final Structure DESERT_PYRAMID = getStructure("desert_pyramid");
    public static final Structure IGLOO = getStructure("igloo");
    public static final Structure SHIPWRECK = getStructure("shipwreck");
    public static final Structure SHIPWRECK_BEACHED = getStructure("shipwreck_beached");
    public static final Structure SWAMP_HUT = getStructure("swamp_hut");
    public static final Structure STRONGHOLD = getStructure("stronghold");
    public static final Structure MONUMENT = getStructure("monument");
    public static final Structure OCEAN_RUIN_COLD = getStructure("ocean_ruin_cold");
    public static final Structure OCEAN_RUIN_WARM = getStructure("ocean_ruin_warm");
    public static final Structure FORTRESS = getStructure("fortress");
    public static final Structure NETHER_FOSSIL = getStructure("nether_fossil");
    public static final Structure END_CITY = getStructure("end_city");
    public static final Structure BURIED_TREASURE = getStructure("buried_treasure");
    public static final Structure BASTION_REMNANT = getStructure("bastion_remnant");
    public static final Structure VILLAGE_PLAINS = getStructure("village_plains");
    public static final Structure VILLAGE_DESERT = getStructure("village_desert");
    public static final Structure VILLAGE_SAVANNA = getStructure("village_savanna");
    public static final Structure VILLAGE_SNOWY = getStructure("village_snowy");
    public static final Structure VILLAGE_TAIGA = getStructure("village_taiga");
    public static final Structure RUINED_PORTAL = getStructure("ruined_portal");
    public static final Structure RUINED_PORTAL_DESERT = getStructure("ruined_portal_desert");
    public static final Structure RUINED_PORTAL_JUNGLE = getStructure("ruined_portal_jungle");
    public static final Structure RUINED_PORTAL_SWAMP = getStructure("ruined_portal_swamp");
    public static final Structure RUINED_PORTAL_MOUNTAIN = getStructure("ruined_portal_mountain");
    public static final Structure RUINED_PORTAL_OCEAN = getStructure("ruined_portal_ocean");
    public static final Structure RUINED_PORTAL_NETHER = getStructure("ruined_portal_nether");
    public static final Structure ANCIENT_CITY = getStructure("ancient_city");
    public static final Structure TRAIL_RUINS = getStructure("trail_ruins");
    public static final Structure TRIAL_CHAMBERS = getStructure("trial_chambers");

    @NotNull
    private static Structure getStructure(@NotNull String name) {
        return Registry.STRUCTURE.getOrThrow(NamespacedKey.minecraft(name));
    }

    /**
     * 返回结构的类型。
     * <p>
     * 原文：Returns the type of the structure.
     *
     * @return the type of structure
     */
    @NotNull
    public abstract StructureType getStructureType();

    /**
     * {@inheritDoc}
     * <p>
     * 原文：{@inheritDoc}
     *
     * @see #getKeyOrThrow()
     * @see #isRegistered()
     * @deprecated 键可能并不总是存在，请改用 {@link #getKeyOrThrow()}。
     */
    @NotNull
    @Override
    @Deprecated(since = "1.21.4")
    public abstract NamespacedKey getKey();
}