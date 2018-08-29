package org.bukkit.entity;

import org.bukkit.block.data.BlockData;
import org.bukkit.material.MaterialData;

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
    public MaterialData getCarriedMaterial();

    /**
     * 设置末影人手持的方块的id和数据.
     * <p>
     * 原文:Sets the id and data of the block that the Enderman is carrying.
     *
     * @param material 要设置的手持方块的数据
     */
    public void setCarriedMaterial(MaterialData material);

    /**
     * 获取末影人手持的方块的方块数据对象.
     * <p>
     * 原文:Gets the data of the block that the Enderman is carrying.
     *
     * @return 包含该方块数据的BlockData对象, 如果没有手持方块返回null
     */
    public BlockData getCarriedBlock();

    /**
     * 设置末影人手持的方块的方块数据对象.
     * <p>
     * 原文:Sets the data of the block that the Enderman is carrying.
     *
     * @param blockData 为该方块设置的BlockData对象, 设为null移除末影人手持的方块
     */
    public void setCarriedBlock(BlockData blockData);
}
