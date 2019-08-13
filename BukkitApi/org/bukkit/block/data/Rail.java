package org.bukkit.block.data;

import java.util.Set;
import org.jetbrains.annotations.NotNull;

/**
 * 'shape'数据值表示此铁轨的形态(铁轨连接方向).
 * <br>
 * 某些铁轨可能不能够摆放成所有的形态，使用
 * {@link #getShapes()}来获悉此铁轨可以怎样摆放.
 */
public interface Rail extends BlockData {

    /**
     * 获取'shape'的数据值.
     * <p>
     * 原文:Gets the value of the 'shape' property.
     *
     * @return 铁轨的形态
     */
    @NotNull
    Shape getShape();

    /**
     * 设置'shape'的数据值.
     * <p>
     * 原文:Sets the value of the 'shape' property.
     *
     * @param shape 铁轨的形态
     */
    void setShape(@NotNull Shape shape);

    /**
     * 获取适用于此铁轨的形态.
     * <p>
     * 原文:Gets the shapes which are applicable to this block.
     *
     * @return 适用于此铁轨的形态
     */
    @NotNull
    Set<Shape> getShapes();

    /**
     * 铁轨方块可使用的不同形态.
     */
    public enum Shape {

        /**
         * The rail runs flat along the north/south (Z) axis.
         */
        NORTH_SOUTH,
        /**
         * The rail runs flat along the east/west (X) axis.
         */
        EAST_WEST,
        /**
         * The rail ascends in the east (positive X) direction.
         */
        ASCENDING_EAST,
        /**
         * The rail ascends in the west (negative X) direction.
         */
        ASCENDING_WEST,
        /**
         * The rail ascends in the north (negative Z) direction.
         */
        ASCENDING_NORTH,
        /**
         * The rail ascends in the south (positive Z) direction.
         */
        ASCENDING_SOUTH,
        /**
         * The rail forms a curve connecting the south and east faces of the
         * block.
         */
        SOUTH_EAST,
        /**
         * The rail forms a curve connecting the south and west faces of the
         * block.
         */
        SOUTH_WEST,
        /**
         * The rail forms a curve connecting the north and west faces of the
         * block.
         */
        NORTH_WEST,
        /**
         * The rail forms a curve connecting the north and east faces of the
         * block.
         */
        NORTH_EAST;
    }
}
