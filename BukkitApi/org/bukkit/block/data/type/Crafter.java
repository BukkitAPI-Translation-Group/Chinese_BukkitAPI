package org.bukkit.block.data.type;

import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Powerable;
import org.jetbrains.annotations.NotNull;

/**
 * 'orientation' 是方块的朝向方向.
 * <br>
 * 类似于 {@link Powerable}，'triggered' 表示发射器当前是否被激活.
 * <br>
 * 'crafting' 表示合成器的嘴是否张开且顶部是否发光.
 */
public interface Crafter extends BlockData {

    /**
     * 获取 'crafting' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'crafting' property.
     *
     * @return 'crafting' 的值
     */
    boolean isCrafting();

    /**
     * 设置 'crafting' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'crafting' property.
     *
     * @param crafting 新的 'crafting' 值
     */
    void setCrafting(boolean crafting);

    /**
     * 获取 'triggered' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'triggered' property.
     *
     * @return 'triggered' 的值
     */
    boolean isTriggered();

    /**
     * 设置 'triggered' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'triggered' property.
     *
     * @param triggered 新的 'triggered' 值
     */
    void setTriggered(boolean triggered);

    /**
     * 获取 'orientation' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'orientation' property.
     *
     * @return 'orientation' 的值
     */
    @NotNull
    Orientation getOrientation();

    /**
     * 设置 'orientation' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'orientation' property.
     *
     * @param orientation 新的 'orientation' 值
     */
    void setOrientation(@NotNull Orientation orientation);

    /**
     * 合成器可以朝向的方向.
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
