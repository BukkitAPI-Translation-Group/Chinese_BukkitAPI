package org.bukkit.material;

import org.bukkit.block.BlockFace;
import org.jetbrains.annotations.NotNull;

/**
 * 表示一个方块可以附着在另一个方块上.
 */
public interface Attachable extends Directional {

    /**
     * 获取此方块附着的面.
     *
     * @return 附着的面
     */
    @NotNull
    public BlockFace getAttachedFace();
}
