package org.bukkit.material;

import org.bukkit.block.BlockFace;
import org.jetbrains.annotations.NotNull;

public interface Directional {

    /**
     * 设置此方块的朝向.
     *
     * @param face 朝向
     */
    public void setFacingDirection(@NotNull BlockFace face);

    /**
     * 获取此方块的朝向.
     *
     * @return 此方块的朝向
     */
    @NotNull
    public BlockFace getFacing();
}
