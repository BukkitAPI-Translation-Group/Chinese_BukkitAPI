package org.bukkit.util;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.generator.structure.Structure;
import org.bukkit.generator.structure.StructureType;
import org.jetbrains.annotations.NotNull;

/**
 * 保存搜索结构的结果。
 *
 * @see World#locateNearestStructure(Location, Structure, int, boolean)
 * @see World#locateNearestStructure(Location, StructureType, int, boolean)
 */
public interface StructureSearchResult {

    /**
     * 返回找到的结构。
     * <p>
     * 原文：
     * Return the structure which was found.
     *
     * @return 找到的结构
     */
    @NotNull
    Structure getStructure();

    /**
     * 返回结构的位置。
     * <p>
     * 原文：
     * Return the location of the structure.
     *
     * @return 找到结构的位置
     */
    @NotNull
    Location getLocation();
}
