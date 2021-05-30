package org.bukkit.block.structure;

/**
 * 代表{@link org.bukkit.block.Structure 结构方块}如何旋转.
 */
public enum StructureRotation {

    /**
     * 无旋转.
     */
    NONE,
    /**
     * 顺时针旋转90度.
     */
    CLOCKWISE_90,
    /**
     * 顺时针旋转180度.
     */
    CLOCKWISE_180,
    /**
     * 逆时针旋转90度.
     * <br>
     * 相当于顺时针旋转270度.
     */
    COUNTERCLOCKWISE_90;
}
