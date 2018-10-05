package org.bukkit.entity;

import org.bukkit.Material;

/**
 * 代表一个下落方块. 
 * <p>
 * 原文:
 *  Represents a falling block
 */
public interface FallingBlock extends Entity {

	/**
	 * 获取下落方块的材料. 
	 * <p>
	 * 原文:
	 *  Get the Material of the falling block
	 *
	 * @return 方块材料
	 */
	Material getMaterial();

	/**
	 * 获取下落方块的ID. 
	 * <p>
	 * 原文: 
	 * Get the ID of the falling block
	 *
	 * @return 方块ID
	 * @deprecated Magic value
	 */
	@Deprecated
	int getBlockId();

	/**
	 * 获取下落方块的数据值
	 * <p>
	 * 原文: 
	 * Get the data for the falling block
	 *
	 * @return 方块数据值
	 * @deprecated Magic value
	 */
	@Deprecated
	byte getBlockData();

	/**
	 * 获取下落方块被阻挡时是否会变为掉落物
	 * <p>
	 * 原文: 
	 * Get if the falling block will break into an item if it cannot be placed
	 *
	 * @return 方块在被阻挡时是否会变为掉落物
	 */
	boolean getDropItem();

	/**
	 * 设置下落方块被阻挡时是否会变为掉落物
	 * <p>
	 * 原文: 
	 * Set if the falling block will break into an item if it cannot be placed
	 *
	 * @param drop true: 当被阻挡时变为掉落物
	 */
	void setDropItem(boolean drop);

	/**
	 * 获取此方块伤害实体的状态
	 * <p>
	 * 原文: 
	 * Get the HurtEntities state of this block.
	 *
	 * @return 实体是否会被此方块伤害
	 */
	boolean canHurtEntities();

	/**
	 * 设置此方块伤害实体的状态
	 * <p>
	 * 原文: 
	 * Set the HurtEntities state of this block.
	 *
	 * @param hurtEntities 实体是否会被此方块伤害
	 */
	void setHurtEntities(boolean hurtEntities);
}
