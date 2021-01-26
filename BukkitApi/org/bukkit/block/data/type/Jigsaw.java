package org.bukkit.block.data.type;

import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;

/**
 * 'orientation' 指方块的朝向.
 */
public interface Jigsaw extends BlockData {

    /**
     * 获取 'orientation' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'orientation' property.
     *
     * @return 属性 'orientation' 的值
     */
    @NotNull
    Orientation getOrientation();

    /**
     * 设置 'orientation' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'orientation' property.
     *
     * @param orientation 新的 'orientation' 属性值
     */
    void setOrientation(@NotNull Orientation orientation);

    /**
     * 拼图方块可朝向的方向.
     */
    public enum Orientation {

        DOWN_EAST,
        DOWN_NORTH,
        DOWN_SOUTH,
        DOWN_WEST,
        UP_EAST,
        UP_NORTH,
        UP_SOUTH,
        UP_WEST,
        WEST_UP,
        EAST_UP,
        NORTH_UP,
        SOUTH_UP;
    }
}
