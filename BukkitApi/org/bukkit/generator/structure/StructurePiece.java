package org.bukkit.generator.structure;

import org.bukkit.util.BoundingBox;
import org.jetbrains.annotations.NotNull;

/**
 * 代表{@link GeneratedStructure}的一个独立组成部分.
 *
 * @see GeneratedStructure
 */
public interface StructurePiece {

    /**
     * 获取此结构部件的边界框.
     *
     * @return 此结构部件的边界框
     */
    @NotNull
    public BoundingBox getBoundingBox();
}
