package org.bukkit.block.data;

import java.util.Set;
import org.bukkit.block.BlockFace;
import org.jetbrains.annotations.NotNull;

/**
 * 'facing'代表方块的朝向.
 * <br>
 * 一些方块可能不能够面向东南西北所有方向，可以用
 * {@link #getFaces()} 来获取这个方块所有可能的朝向.
 */
public interface Directional extends BlockData {

    /**
     * 获取方块朝向属性.
     * <p>
     * 原文:Gets the value of the 'facing' property.
     *
     * @return 方块朝向属性
     */
    @NotNull
    BlockFace getFacing();

    /**
     * 设置方块的朝向.
     * <p>
     * 原文:Sets the value of the 'facing' property.
     *
     * @param facing 方块的朝向
     */
    void setFacing(@NotNull BlockFace facing);

    /**
     * 获取可应用于此方块的朝向.
     * <p>
     * 原文:Gets the faces which are applicable to this block.
     *
     * @return 允许的朝向值
     */
    @NotNull
    Set<BlockFace> getFaces();
}
