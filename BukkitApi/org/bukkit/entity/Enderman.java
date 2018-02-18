package org.bukkit.entity;

import org.bukkit.material.MaterialData;

/**
 * 代表末影人.
 */
public interface Enderman extends Monster {

    /**
     * 获取末影人手持的方块的id和数据.
     * <p>
     * 原文:Get the id and data of the block that the Enderman is carrying.
     *
     * @return 包含方块的id和数据的MaterialData
     */
    public MaterialData getCarriedMaterial();

    /**
     * 设置末影人手持的方块的id和数据.
     * <p>
     * 原文:Set the id and data of the block that the Enderman is carrying.
     *
     * @param material 要设置的手持方块的数据
     */
    public void setCarriedMaterial(MaterialData material);
}
