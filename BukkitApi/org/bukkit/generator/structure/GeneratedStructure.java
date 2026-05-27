package org.bukkit.generator.structure;

import java.util.Collection;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.util.BoundingBox;
import org.jetbrains.annotations.NotNull;

/**
 * 表示放置在世界中的结构。
 *
 * @see StructurePiece
 */
public interface GeneratedStructure extends PersistentDataHolder {

    /**
     * 获取此放置结构的边界框。
     * <p>
     * 原文：Gets the bounding box of this placed structure.
     *
     * @return bounding box of this placed structure
     */
    @NotNull
    public BoundingBox getBoundingBox();

    /**
     * 获取此放置结构所代表的结构。
     * <p>
     * 原文：Gets the structure that this PlacedStructure represents.
     *
     * @return the structure that this PlacedStructure represents
     */
    @NotNull
    public Structure getStructure();

    /**
     * 获取构成此放置结构的所有 {@link StructurePiece}。
     * <p>
     * 原文：Gets all the {@link StructurePiece} that make up this PlacedStructure.
     *
     * @return a collection of all the StructurePieces
     */
    @NotNull
    public Collection<StructurePiece> getPieces();
}
