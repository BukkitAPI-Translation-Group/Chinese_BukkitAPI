package org.bukkit.block;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.Metadatable;

/**
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
     * 获取这个方块所代表的BlockState对象.
     * <p>
     * 原文:
     * Gets the block represented by this BlockState
     *
     * @return 这个方块代表的BlockState对象
     */
    Block getBlock();

    /**
     * 获取这个方块的元数据.
     * <p>
     * 原文:
     * Gets the metadata for this block
     *
     * @return 方块具体的元数据
     */
    MaterialData getData();

    /**
     * 获取这个方块的类型.
     * <p>
     * 原文:
     * Gets the type of this block
     *
     * @return 方块类型
     */
    Material getType();

    /**
     * 获取这个方块的类型id.
     * <p>
     * 原文:
     * Gets the type-id of this block
     *
     * @return 方块类型id
     * @deprecated 魔法值
     */
    @Deprecated
    int getTypeId();

    /**
     * 获取光照强度，在0-15之间.
     * <p>
     * 原文:
     * Gets the light level between 0-15
     *
     * @return 光照强度
     */
    byte getLightLevel();

    /**
     * 获取方块包含在哪一个世界里.
     * 
     * <p>
     * 原文:
     * Gets the world which contains this Block
     *
     * @return 方块所处世界
     */
    World getWorld();

    /*
     * 获取这个方块的X坐标.
     * <p>
     * 原文:
     * Gets the x-coordinate of this block
     *
     * @return X坐标
     */
    int getX();

    /**
     * 获取这个方块的Y坐标.
     * <p>
     * 原文:
     * Gets the y-coordinate of this block
     *
     * @return Y坐标
     */
    int getY();

    /**
     * 获取这个方块的Z坐标.
     * <p>
     * 原文:
     * Gets the z-coordinate of this block
     *
     * @return Z坐标
     */
    int getZ();

    /**
     * 获取这个方块的位置.
     * <p>
     * 原文:
     * Gets the location of this block
     *
     * @return 位置
     */
    Location getLocation();

    /**
     * Stores the location of this block in the provided Location object.
     * <p>
     * If the provided Location is null this method does nothing and returns
     * null.
     *
     * @param loc the location to copy into
     * @return The Location object provided or null
     */
    Location getLocation(Location loc);

    /**
     * 获取方块包含在哪一个区块里.
     * <p>
     * 原文:
     * Gets the chunk which contains this block
     *
     * @return 方块所处区块
     */
    Chunk getChunk();

    /**
     * 设置这个方块的元数据.
     * <p>
     * 原文:
     * Sets the metadata for this block
     *
     * @param data 新的方块的具体元数据
     */
    void setData(MaterialData data);

    /**
     * 设置这个方块的类型.
     * <p>
     * 原文:
     * Sets the type of this block
     *
     * @param type Material类型来更改方块类型
     */
    void setType(Material type);

    /**
     * 设置这个方块的类型id.
     * <p>
     * 原文:
     * Sets the type-id of this block
     *
     * @param type 要让此方块改变的类型id
     * @return 这个是否有用呢?
     * @deprecated 魔法值
     */
    @Deprecated
    boolean setTypeId(int type);

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
     * @return 将数据作为原始字节
     * @deprecated 魔法值
     */
    @Deprecated
    public byte getRawData();

    /**
     * @param data 方块的新的数据值
     * @deprecated 魔法值
     */
    @Deprecated
    public void setRawData(byte data);

    /**
     * Returns whether this state is placed in the world.
     *
     * Some methods will not work if the blockState isn't
     * placed in the world.
     *
     * @return whether the state is placed in the world
     *         or 'virtual' (e.g. on an itemstack)
     */
    boolean isPlaced();
}