package org.bukkit.entity;

import org.bukkit.block.data.BlockData;
import org.bukkit.material.MaterialData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表末影人.
 */
public interface Enderman extends Monster {

    /**
     * 获取末影人手持的方块的id和数据.
     * <p>
     * 原文:Gets the id and data of the block that the Enderman is carrying.
     *
     * @return 包含方块的id和数据的MaterialData
     */
    @NotNull
    public MaterialData getCarriedMaterial();

    /**
     * 设置末影人手持的方块的id和数据.
     * <p>
     * 原文:Sets the id and data of the block that the Enderman is carrying.
     *
     * @param material 要设置的手持方块的数据
     */
    public void setCarriedMaterial(@NotNull MaterialData material);

    /**
     * 获取末影人手持的方块的方块数据对象.
     * <p>
     * 原文:Gets the data of the block that the Enderman is carrying.
     *
     * @return 包含该方块数据的BlockData对象, 如果没有手持方块返回null
     */
    @Nullable
    public BlockData getCarriedBlock();

    /**
     * 设置末影人手持的方块的方块数据对象.
     * <p>
     * 原文:Sets the data of the block that the Enderman is carrying.
     *
     * @param blockData 为该方块设置的BlockData对象, 设为null移除末影人手持的方块
     */
    public void setCarriedBlock(@Nullable BlockData blockData);

    /**
     * Randomly teleports the Enderman in a 64x64x64 block cuboid region.
     * <p>
     * If the randomly selected point is in the ground, the point is moved 1 block
     * down until air is found or until it goes under
     * {@link org.bukkit.World#getMinHeight()}.
     * <p>
     * This method will return false if this Enderman is not alive, or if the
     * teleport location was obstructed, or if the teleport location is in water.
     *
     * @return true if the teleport succeeded.
     */
    public boolean teleport();

    /**
     * Randomly teleports the Enderman towards the given <code>entity</code>.
     * <p>
     * The point is selected by drawing a vector between this enderman and the
     * given <code>entity</code>. That vector's length is set to 16 blocks.
     * That point is then moved within a 8x8x8 cuboid region. If the randomly
     * selected point is in the ground, the point is moved 1 block down until
     * air is found or until it goes under
     * {@link org.bukkit.World#getMinHeight()}.
     * <p>
     * This method will return false if this Enderman is not alive, or if the
     * teleport location was obstructed, or if the teleport location is in water.
     *
     * @param entity The entity to teleport towards.
     * @return true if the teleport succeeded.
     */
    public boolean teleportTowards(@NotNull Entity entity);
}
