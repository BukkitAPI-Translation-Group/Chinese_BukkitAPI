package org.bukkit.util;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.jetbrains.annotations.NotNull;

/**
 * 保存搜索生物群系的结果。
 *
 * @see World#locateNearestBiome(Location, int, Biome...)
 * @see World#locateNearestBiome(Location, int, int, int, Biome...)
 */
public interface BiomeSearchResult {

    /**
     * 返回找到的生物群系。
     * <p>
     * 原文：
     * Return the biome which was found.
     *
     * @return 找到的生物群系
     */
    @NotNull
    Biome getBiome();

    /**
     * 返回生物群系的位置。
     * <p>
     * 原文：
     * Return the location of the biome.
     *
     * @return 找到生物群系的位置
     */
    @NotNull
    Location getLocation();
}
