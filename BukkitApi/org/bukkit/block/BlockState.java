package org.bukkit.block;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.data.BlockData;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.Metadatable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示方块的状态(快照)，不会自动更改.
 * <p>
 * 与每个坐标只能存在一个实例的Block不同，对于任何给定的Block，BlockState可以存在多次.
 * 请注意，其他插件可能会更改BlockState，而你的插件将不知道已更改. 
 * 或者其他插件可能会将方块更改为另一种类型，从而导致你的BlockState失效. 
 * 原文:
 * <p>
 * Represents a captured state of a block, which will not change
 * automatically.
 * <p>
 * Unlike Block, which only one object can exist per coordinate, BlockState
 * can exist multiple times for any given Block. Note that another plugin may
 * change the state of the block and you will not know, or they may change the
 * block to another type entirely, causing your BlockState to become invalid.
 */
public interface BlockState extends Metadatable {

    /**
     * 获取此方块状态所表示的方块. 
     * 原文:
     * <p>
     * Gets the block represented by this block state.
     *
     * @return 此方块状态所表示的方块
     * @throws IllegalStateException if this block state is not placed
     */
    @NotNull
    Block getBlock();

    /**
     * 获取此方块状态的元数据. 
     * 原文:
     * <p>
     * Gets the metadata for this block state.
     *
     * @return 方块的元数据
     */
    @NotNull
    MaterialData getData();

    /*
     * 获取此方块状态的数据. 
     * 原文:
     * <p>
     * Gets the data for this block state.
     *
     * @return 方块的数据
     */
    @NotNull
    BlockData getBlockData();

    /**
     * 获取此方块状态的类型. 
     * 原文:
     * <p>
     * Gets the type of this block state.
     *
     * @return 方块的类型
     */
    @NotNull
    Material getType();

    /**
     * 获取此方块状态所提供的光照强度. 
     * 原文:
     * <p>
     * Gets the current light level of the block represented by this block state.
     *
     * @return 光照强度, 阈值: 0-15
     * @throws IllegalStateException if this block state is not placed
     */
    byte getLightLevel();

    /**
     * 获取此方块状态所指向的世界. 
     * 原文:
     * <p>
     * Gets the world which contains the block represented by this block state.
     *
     * @return 此方块状态指向的包含方块的世界
     * @throws IllegalStateException if this block state is not placed
     */
    @NotNull
    World getWorld();

    /**
     * 获取此方块状态的x坐标. 
     * 原文:
     * <p>
     * Gets the x-coordinate of this block state.
     *
     * @return x坐标
     */
    int getX();

    /**
     * 获取此方块状态的y坐标. 
     * 原文:
     * <p>
     * Gets the y-coordinate of this block state.
     *
     * @return y坐标
     */
    int getY();

    /**
     * 获取此方块状态的z坐标. 
     * 原文:
     * <p>
     * Gets the z-coordinate of this block state.
     *
     * @return z坐标
     */
    int getZ();

    /**
     * 获取此方块状态的位置. 
     * <p>
     * 如果此方块状态未被放置在方块上, 则返回的Location中的world将为null!
     * 原文:
     * <p>
     * Gets the location of this block state.
     * <p>
     * If this block state is not placed the location's world will be null!
     *
     * @return 位置
     */
    @NotNull
    Location getLocation();

    /**
     * 存储此方块状态的位置到给定的位置实例中. 
     * <p>
     * 如果给定的位置实例为null, 则将不进行任何操作并返回null.
     * <p>
     * 如果此方块状态未被放置在方块上, 则返回的Location中的world将为null!
     * 原文:
     * <p>
     * Stores the location of this block state in the provided Location object.
     * <p>
     * If the provided Location is null this method does nothing and returns
     * null.
     * <p>
     * If this block state is not placed the location's world will be null!
     *
     * @param loc 要复制入的位置实例
     * @return 给定的位置实例/null
     */
    @Contract("null -> null; !null -> !null")
    @Nullable
    Location getLocation(@Nullable Location loc);

    /**
     * Gets the chunk which contains the block represented by this block state.
     *
     * @return the containing Chunk
     * @throws IllegalStateException if this block state is not placed
     */
    @NotNull
    Chunk getChunk();

    /**
     * Sets the metadata for this block state.
     *
     * @param data New block specific metadata
     */
    void setData(@NotNull MaterialData data);

    /**
     * Sets the data for this block state.
     *
     * @param data New block specific data
     */
    void setBlockData(@NotNull BlockData data);

    /**
     * Sets the type of this block state.
     *
     * @param type Material to change this block state to
     */
    void setType(@NotNull Material type);

    /**
     * Attempts to update the block represented by this state, setting it to
     * the new values as defined by this state.
     * <p>
     * This has the same effect as calling update(false). That is to say,
     * this will not modify the state of a block if it is no longer the same
     * type as it was when this state was taken. It will return false in this
     * eventuality.
     *
     * @return true if the update was successful, otherwise false
     * @see #update(boolean)
     */
    boolean update();

    /**
     * Attempts to update the block represented by this state, setting it to
     * the new values as defined by this state.
     * <p>
     * This has the same effect as calling update(force, true). That is to
     * say, this will trigger a physics update to surrounding blocks.
     *
     * @param force true to forcefully set the state
     * @return true if the update was successful, otherwise false
     */
    boolean update(boolean force);

    /**
     * Attempts to update the block represented by this state, setting it to
     * the new values as defined by this state.
     * <p>
     * If this state is not placed, this will have no effect and return true.
     * <p>
     * Unless force is true, this will not modify the state of a block if it
     * is no longer the same type as it was when this state was taken. It will
     * return false in this eventuality.
     * <p>
     * If force is true, it will set the type of the block to match the new
     * state, set the state data and then return true.
     * <p>
     * If applyPhysics is true, it will trigger a physics update on
     * surrounding blocks which could cause them to update or disappear.
     *
     * @param force true to forcefully set the state
     * @param applyPhysics false to cancel updating physics on surrounding
     *     blocks
     * @return true if the update was successful, otherwise false
     */
    boolean update(boolean force, boolean applyPhysics);

    /**
     * @return The data as a raw byte.
     * @deprecated Magic value
     */
    @Deprecated
    public byte getRawData();

    /**
     * @param data The new data value for the block.
     * @deprecated Magic value
     */
    @Deprecated
    public void setRawData(byte data);

    /**
     * Returns whether this state is placed in the world.
     * <p>
     * Some methods will not work if the block state isn't
     * placed in the world.
     *
     * @return whether the state is placed in the world
     *         or 'virtual' (e.g. on an itemstack)
     */
    boolean isPlaced();
}
