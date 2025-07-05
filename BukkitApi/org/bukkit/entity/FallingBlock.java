package org.bukkit.entity;

import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;

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
    @Deprecated(since = "1.6.2")
    @NotNull
    Material getMaterial();

    /**
     * Get the data for the falling block
     *
     * @return data of the block
     */
    @NotNull
    BlockData getBlockData();

    /**
     * 获取下落方块被阻挡时是否会变为掉落物.
     * <p>
     * 请注意, 如果 {@link #getCancelDrop()} 为 {@code true}, 则下落方块将不会掉落物品,
     * 无论此方法是否返回 {@code true}.
     * <p>
     * 原文: 
     * Get if the falling block will break into an item if it cannot be placed.
     * <p>
     * Note that if {@link #getCancelDrop()} is {@code true}, the falling block
     * will not drop an item regardless of whether or not the returned value is
     * {@code true}.
     *
     * @return 方块在被阻挡时是否会变为掉落物. 
     */
    boolean getDropItem();

    /**
     * 设置下落方块被阻挡时是否会变为掉落物. 
     * <p>
     * 请注意, 如果 {@link #getCancelDrop()} 为 {@code true}, 则下落方块将不会掉落物品,
     * 无论是否设置为 {@code true}.
     * 原文: 
     * Set if the falling block will break into an item if it cannot be placed.
     * <p>
     * Note that if {@link #getCancelDrop()} is {@code true}, the falling block
     * will not drop an item regardless of whether or not the value is set to
     * {@code true}.
     *
     * @param drop 当被阻挡时变为掉落物时返回 true. 
     */
    void setDropItem(boolean drop);

    /**
     * Get if the falling block will not become a block upon landing and not drop
     * an item.
     * <p>
     * Unlike {@link #getDropItem()}, this property will prevent the block from
     * forming into a block when it lands, causing it to disappear. If this property
     * is true and {@link #getDropItem()} is true, an item will <strong>NOT</strong>
     * be dropped.
     *
     * @return true if the block will disappear
     */
    boolean getCancelDrop();

    /**
     * Get if the falling block will not become a block upon landing and not drop
     * an item.
     * <p>
     * Unlike {@link #setDropItem(boolean)}, this property will prevent the block
     * from forming into a block when it lands, causing it to disappear. If this
     * property is true and {@link #getDropItem()} is true, an item will
     * <strong>NOT</strong> be dropped.
     *
     * @param cancelDrop true to make the block disappear when landing
     */
    void setCancelDrop(boolean cancelDrop);

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

    /**
     * Get the amount of damage inflicted upon entities multiplied by the distance
     * that the block had fallen when this falling block lands on them.
     *
     * @return the damage per block
     */
    float getDamagePerBlock();

    /**
     * Set the amount of damage inflicted upon entities multiplied by the distance
     * that the block had fallen when this falling block lands on them.
     * <p>
     * If {@code damage} is non-zero, this method will automatically call
     * {@link #setHurtEntities(boolean) setHurtEntities(true)}.
     *
     * @param damage the damage per block to set. Must be >= 0.0
     */
    void setDamagePerBlock(float damage);

    /**
     * Get the maximum amount of damage that can be inflicted upon entities when
     * this falling block lands on them.
     *
     * @return the max damage
     */
    int getMaxDamage();

    /**
     * Set the maximum amount of damage that can be inflicted upon entities when
     * this falling block lands on them.
     * <p>
     * If {@code damage} is non-zero, this method will automatically call
     * {@link #setHurtEntities(boolean) setHurtEntities(true)}.
     *
     * @param damage the max damage to set. Must be >= 0
     */
    void setMaxDamage(int damage);
}
