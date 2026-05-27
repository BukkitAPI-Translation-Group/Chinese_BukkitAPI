package org.bukkit.generator.structure;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.registry.RegistryAware;
import org.jetbrains.annotations.NotNull;

/**
 * 表示 {@link Structure} 的结构类型。
 *
 * 列出的结构类型存在于默认服务器中。根据服务器的不同，
 * 可能会有额外的结构类型存在（例如由数据包添加的结构类型），
 * 可以通过 {@link Registry#STRUCTURE_TYPE} 获取。
 */
public abstract class StructureType implements Keyed, RegistryAware {

    public static final StructureType BURIED_TREASURE = getStructureType("buried_treasure");
    public static final StructureType DESERT_PYRAMID = getStructureType("desert_pyramid");
    public static final StructureType END_CITY = getStructureType("end_city");
    public static final StructureType FORTRESS = getStructureType("fortress");
    public static final StructureType IGLOO = getStructureType("igloo");
    public static final StructureType JIGSAW = getStructureType("jigsaw");
    public static final StructureType JUNGLE_TEMPLE = getStructureType("jungle_temple");
    public static final StructureType MINESHAFT = getStructureType("mineshaft");
    public static final StructureType NETHER_FOSSIL = getStructureType("nether_fossil");
    public static final StructureType OCEAN_MONUMENT = getStructureType("ocean_monument");
    public static final StructureType OCEAN_RUIN = getStructureType("ocean_ruin");
    public static final StructureType RUINED_PORTAL = getStructureType("ruined_portal");
    public static final StructureType SHIPWRECK = getStructureType("shipwreck");
    public static final StructureType STRONGHOLD = getStructureType("stronghold");
    public static final StructureType SWAMP_HUT = getStructureType("swamp_hut");
    public static final StructureType WOODLAND_MANSION = getStructureType("woodland_mansion");

    @NotNull
    private static StructureType getStructureType(@NotNull String name) {
        return Registry.STRUCTURE_TYPE.getOrThrow(NamespacedKey.minecraft(name));
    }

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