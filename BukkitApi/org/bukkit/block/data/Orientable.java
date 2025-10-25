package org.bukkit.block.data;

import java.util.Set;
import org.bukkit.Axis;
import org.jetbrains.annotations.NotNull;

/**
 * 'axis' 表示此方块所朝向的轴。
 * <br>
 * 一些方块如传送门方块可能不能以所有方向放置，使用 {@link #getAxes()} 来获取所有可能的方向。
 * 
 * 原文:'axis' represents the axis along whilst this block is oriented.
 * <br>
 * Some blocks such as the portal block may not be able to be placed in all
 * orientations, use {@link #getAxes()} to retrieve all possible such
 * orientations.
 */
public interface Orientable extends BlockData {

    /**
     * 获取 'axis' 属性的值。
     * 
     * 原文:Gets the value of the 'axis' property.
     *
     * @return 'axis' 的值
     * 原文:the 'axis' value
     */
    @NotNull
    Axis getAxis();

    /**
     * 设置 'axis' 属性的值。
     * 
     * 原文:Sets the value of the 'axis' property.
     *
     * @param axis 新的 'axis' 值
     * 原文:the new 'axis' value
     */
    void setAxis(@NotNull Axis axis);

    /**
     * 获取适用于此方块的轴。
     * 
     * 原文:Gets the axes which are applicable to this block.
     *
     * @return 允许的 'axis' 值
     * 原文:the allowed 'axis' values
     */
    @NotNull
    Set<Axis> getAxes();
}
