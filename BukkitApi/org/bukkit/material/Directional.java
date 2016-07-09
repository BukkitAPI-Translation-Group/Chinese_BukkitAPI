package org.bukkit.material;

import org.bukkit.block.BlockFace;

public interface Directional {

    /**
     * 设置这个方块的朝向.
     * <p>
     * 原文:Sets the direction that this block is facing in
     *
     * @param face 这个方块的朝向
     */
    public void setFacingDirection(BlockFace face);

    /**
     * 获取这个方块的朝向.
     * <p>
     * 原文:Gets the direction this block is facing
     *
     * @return 这个方块的朝向
     */
    public BlockFace getFacing();
}
