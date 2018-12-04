package org.bukkit.entity;

import org.bukkit.Material;
import org.bukkit.block.data.BlockData;

/**
 * 代表一个下落方块. 
 * <p>
 * 原文:
 *  Represents a falling block
 */
public interface FallingBlock extends Entity {

    /**
     * 获取下落方块的类型. 
     * <p>
     * 原文:
     * Get the Material of the falling block
     *
     * @return Material of the block
     * @deprecated 请使用 {@link #getBlockData()}
     */
    Material getMaterial();

    /**
     * Get the data for the falling block
     *
     * @return data of the block
     */
    BlockData getBlockData();

    /**
     * 获取下落方块被阻挡时是否会变为掉落物. 
     * <p>
     * 原文: 
     * Get if the falling block will break into an item if it cannot be placed
     *
     * @return 方块在被阻挡时是否会变为掉落物. 
     */
    boolean getDropItem();

    /**
     * 设置下落方块被阻挡时是否会变为掉落物. 
     * <p>
     * 原文: 
     * Set if the falling block will break into an item if it cannot be placed
     *
     * @param drop 当被阻挡时变为掉落物时返回 true. 
     */
    void setDropItem(boolean drop);

    /**
     * 获取此方块能否砸伤实体. 
     * <p>
     * 原文: 
     * Get the HurtEntities state of this block.
     *
     * @return 此方块能否砸伤实体. 
     */
    boolean canHurtEntities();

    /**
     * 设置此方块能否砸伤实体. 
     * <p>
     * 原文: 
     * Set the HurtEntities state of this block.
     *
     * @param hurtEntities 此方块能否砸伤实体. 
     */
    void setHurtEntities(boolean hurtEntities);
}
