package org.bukkit.material;

import org.bukkit.block.BlockFace;
import org.jetbrains.annotations.NotNull;

/**
 * 表示一个方块可以附着在另一个方块上.
 */
public interface Attachable extends Directional {

    /**
     * 获取此方块附着的面.
     * <p>
     * 原文：
     * Gets the face that this block is attached on
     *
     * @return 附着的面
     */
    @NotNull
    public BlockFace getAttachedFace();
}
