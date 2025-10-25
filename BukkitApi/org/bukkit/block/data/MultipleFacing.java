package org.bukkit.block.data;

import java.util.Set;
import org.bukkit.block.BlockFace;
import org.jetbrains.annotations.NotNull;

/**
 * 这个类包含了 'north', 'east', 'south', 'west', 'up', 'down'
 * 布尔标志，用于设置方块的哪些面显示纹理。
 * <br>
 * 有些方块可能不能在所有方向上都有面，使用
 * {@link #getAllowedFaces()} 来获取这个方块所有可能的面。在非允许的面上调用任何方法都是无效的。
 * 
 * 原文:This class encompasses the 'north', 'east', 'south', 'west', 'up', 'down'
 * boolean flags which are used to set which faces of the block textures are
 * displayed on.
 * <br>
 * Some blocks may not be able to have faces on all directions, use
 * {@link #getAllowedFaces()} to get all possible faces for this block. It is
 * not valid to call any methods on non-allowed faces.
 */
public interface MultipleFacing extends BlockData {

    /**
     * 检查此方块是否启用了指定的面。
     * 
     * 原文:Checks if this block has the specified face enabled.
     *
     * @param face 要检查的面
     * 原文:face to check
     * @return 如果面已启用则返回true
     * 原文:if face is enabled
     */
    boolean hasFace(@NotNull BlockFace face);

    /**
     * 设置此方块是否启用指定的面。
     * 
     * 原文:Set whether this block has the specified face enabled.
     *
     * @param face 要设置的面
     * 原文:face to set
     * @param has 是否有该面
     * 原文:the face
     */
    void setFace(@NotNull BlockFace face, boolean has);

    /**
     * 获取此方块上所有启用的面。
     * 
     * 原文:Get all of the faces which are enabled on this block.
     *
     * @return 所有启用的面
     * 原文:all faces enabled
     */
    @NotNull
    Set<BlockFace> getFaces();

    /**
     * 获取此方块上所有可能设置的面。
     * 
     * 原文:Gets all of this faces which may be set on this block.
     *
     * @return 所有允许的面
     * 原文:all allowed faces
     */
    @NotNull
    Set<BlockFace> getAllowedFaces();
}
