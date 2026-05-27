package org.bukkit.util;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;

/**
 * 由体素组成的形状。
 *
 * 例如，用于表示方块的详细碰撞形状。
 */
public interface VoxelShape {

    /**
     * 将此形状转换为等效于该形状的 {@link BoundingBox} 集合：如果边界框与该形状的任何边界框相交，则与该方块形状相交。
     * <p>
     * 原文：
     * Converts this shape into a collection of {@link BoundingBox} equivalent
     * to the shape: a bounding box intersects with this block shape if it
     * intersects with any of the shape's bounding boxes.
     *
     * @return 转换为边界框的形状
     */
    @NotNull
    public Collection<BoundingBox> getBoundingBoxes();

    /**
     * 检查给定边界框是否与此方块形状相交。
     * <p>
     * 原文：
     * Checks if the given bounding box intersects this block shape.
     *
     * @param other 要测试的边界框
     * @return 如果 other 与此形状重叠则返回 true，否则返回 false
     */
    public boolean overlaps(@NotNull BoundingBox other);
}
