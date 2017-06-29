package org.bukkit.block;

import java.util.Collection;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.Metadatable;

/**
 * 代表方块. This is a live object, and only one Block may exist for
 * any given location in a world. The state of the block may change
 * concurrently to your own handling of it; use block.getState() to get a
 * snapshot state of a block which will not be modified.
 */
public interface Block extends Metadatable {

    /**
     * 获取此方块的元数据.
     * <p>
     * 原文:Gets the metadata for this block
     *
     * @return 方块元数据
     * @deprecated 不安全的参数
     */
    @Deprecated
    byte getData();

    /**
     * 以指定坐标偏移量获取方块 （相对与方块位置的偏移量）.
     * <p>
     * 原文：Gets the block at the given offsets
     *
     * @param modX X坐标偏移量
     * @param modY Y坐标偏移量
     * @param modZ Z坐标偏移量
     * @return 在此坐标偏移量的方块
     */
    Block getRelative(int modX, int modY, int modZ);

    /**
     * Gets the block at the given face
     * <p>
     * This method is equal to getRelative(face, 1)
     *
     * @param face Face of this block to return
     * @return Block at the given face
     * @see #getRelative(BlockFace, int)
     */
    Block getRelative(BlockFace face);

    /**
     * Gets the block at the given distance of the given face
     * <p>
     * For example, the following method places water at 100,102,100; two
     * blocks above 100,100,100.
     *
     * <pre>
     * Block block = world.getBlockAt(100, 100, 100);
     * Block shower = block.getRelative(BlockFace.UP, 2);
     * shower.setType(Material.WATER);
     * </pre>
     *
     * @param face Face of this block to return
     * @param distance Distance to get the block at
     * @return Block at the given face
     */
    Block getRelative(BlockFace face, int distance);

    /**
     * 获取此方块的种类.
     * <p>
     * 原文:Gets the type of this block
     *
     * @return 方块种类
     */
    Material getType();

    /**
     * 获取此方块的种类ID.
     * <p>
     * 原文：Gets the type-id of this block
     *
     * @return 方块种类ID
     * @deprecated 不安全的参数
     */
    @Deprecated
    int getTypeId();

    /**
     * 获取此方块的光亮等级，范围0~15.
     * <p>
     * 原文：Gets the light level between 0-15
     *
     * @return 光亮等级
     */
    byte getLightLevel();

    /**
     * Get the amount of light at this block from the sky.
     * <p>
     * Any light given from other sources (such as blocks like torches) will
     * be ignored.
     *
     * @return Sky light level
     */
    byte getLightFromSky();

    /**
     * Get the amount of light at this block from nearby blocks.
     * <p>
     * Any light given from other sources (such as the sun) will be ignored.
     *
     * @return Block light level
     */
    byte getLightFromBlocks();

    /**
     * 获取此方块所处的世界.
     * <p>
     * 原文：Gets the world which contains this Block
     *
     * @return 方块所处的世界
     */
    World getWorld();

    /**
     * 获取此方块的X坐标.
     * <p>
     * 原文：Gets the x-coordinate of this block
     *
     * @return X坐标
     */
    int getX();

    /**
     * 获取此方块的Y坐标.
     * <p>
     * 原文：Gets the y-coordinate of this block
     *
     * @return Y坐标
     */
    int getY();

    /**
     * 获取此方块的Z坐标.
     * <p>
     * 原文：Gets the z-coordinate of this block
     *
     * @return Z坐标
     */
    int getZ();

    /**
     * 获取方块的位置信息.
     * <p>
     * 原文:Gets the Location of the block
     *
     * @return 方块的位置
     */
    Location getLocation();

    /**
     * Stores the location of the block in the provided Location object.
     * <p>
     * If the provided Location is null this method does nothing and returns
     * null.
     *
     * @param loc the location to copy into
     * @return The Location object provided or null
     */
    Location getLocation(Location loc);

    /**
     * 获取包含此方块的区块(方块所在的区块).
     * <p>
     * 原文:Gets the chunk which contains this block
     *
     * @return 包含此方块的区块
     */
    Chunk getChunk();

    /**
     * 为这个方块设置元数据.
     * <p>
     * 原文:Sets the metadata for this block
     *
     * @param data 元数据
     * @deprecated 不安全的参数
     */
    @Deprecated
    void setData(byte data);

    /**
     * 为这个方块设置元数据.
     * <p>
     * 原文:Sets the metadata for this block
     *
     * @param data 元数据
     * @param applyPhysics False to cancel physics from the changed block.
     * @deprecated 不安全的参数
     */
    @Deprecated
    void setData(byte data, boolean applyPhysics);

    /**
     * 设置这个方块的类型.
     * <p>
     * 原文:Sets the type of this block
     *
     * @param type 方块的Material类型
     */
    void setType(Material type);

    /**
     * Sets the type of this block
     *
     * @param type Material to change this block to
     * @param applyPhysics False to cancel physics on the changed block.
     */
    void setType(Material type, boolean applyPhysics);

    /**
     * Sets the type-id of this block
     *
     * @param type Type-Id to change this block to
     * @return whether the block was changed
     * @deprecated Magic value
     */
    @Deprecated
    boolean setTypeId(int type);

    /**
     * Sets the type-id of this block
     *
     * @param type Type-Id to change this block to
     * @param applyPhysics False to cancel physics on the changed block.
     * @return whether the block was changed
     * @deprecated Magic value
     */
    @Deprecated
    boolean setTypeId(int type, boolean applyPhysics);

    /**
     * Sets the type-id of this block
     *
     * @param type Type-Id to change this block to
     * @param data The data value to change this block to
     * @param applyPhysics False to cancel physics on the changed block
     * @return whether the block was changed
     * @deprecated Magic value
     */
    @Deprecated
    boolean setTypeIdAndData(int type, byte data, boolean applyPhysics);

    /**
     * Gets the face relation of this block compared to the given block.
     * <p>
     * For example: 
     * <pre>{@code
     * Block current = world.getBlockAt(100, 100, 100);
     * Block target = world.getBlockAt(100, 101, 100);
     *
     * current.getFace(target) == BlockFace.Up;
     * }</pre>
     * <br>
     * If the given block is not connected to this block, null may be returned
     *
     * @param block Block to compare against this block
     * @return BlockFace of this block which has the requested block, or null
     */
    BlockFace getFace(Block block);

    /**
     * Captures the current state of this block. You may then cast that state
     * into any accepted type, such as Furnace or Sign.
     * <p>
     * The returned object will never be updated, and you are not guaranteed
     * that (for example) a sign is still a sign after you capture its state.
     *
     * @return BlockState with the current state of this block.
     */
    BlockState getState();

    /**
     * Returns the biome that this block resides in
     *
     * @return Biome type containing this block
     */
    Biome getBiome();

    /**
     * Sets the biome that this block resides in
     *
     * @param bio new Biome type for this block
     */
    void setBiome(Biome bio);

    /**
     * Returns true if the block is being powered by Redstone.
     *
     * @return True if the block is powered.
     */
    boolean isBlockPowered();

    /**
     * Returns true if the block is being indirectly powered by Redstone.
     *
     * @return True if the block is indirectly powered.
     */
    boolean isBlockIndirectlyPowered();

    /**
     * Returns true if the block face is being powered by Redstone.
     *
     * @param face The block face
     * @return True if the block face is powered.
     */
    boolean isBlockFacePowered(BlockFace face);

    /**
     * Returns true if the block face is being indirectly powered by Redstone.
     *
     * @param face The block face
     * @return True if the block face is indirectly powered.
     */
    boolean isBlockFaceIndirectlyPowered(BlockFace face);

    /**
     * Returns the redstone power being provided to this block face
     *
     * @param face the face of the block to query or BlockFace.SELF for the
     *     block itself
     * @return The power level.
     */
    int getBlockPower(BlockFace face);

    /**
     * Returns the redstone power being provided to this block
     *
     * @return The power level.
     */
    int getBlockPower();

    /**
     * Checks if this block is empty.
     * <p>
     * A block is considered empty when {@link #getType()} returns {@link
     * Material#AIR}.
     *
     * @return true if this block is empty
     */
    boolean isEmpty();

    /**
     * Checks if this block is liquid.
     * <p>
     * A block is considered liquid when {@link #getType()} returns {@link
     * Material#WATER}, {@link Material#STATIONARY_WATER}, {@link
     * Material#LAVA} or {@link Material#STATIONARY_LAVA}.
     *
     * @return true if this block is liquid
     */
    boolean isLiquid();

    /**
     * Gets the temperature of the biome of this block
     *
     * @return Temperature of this block
     */
    double getTemperature();

    /**
     * Gets the humidity of the biome of this block
     *
     * @return Humidity of this block
     */
    double getHumidity();

    /**
     * Returns the reaction of the block when moved by a piston
     *
     * @return reaction
     */
    PistonMoveReaction getPistonMoveReaction();

    /**
     * Breaks the block and spawns items as if a player had digged it
     *
     * @return true if the block was destroyed
     */
    boolean breakNaturally();

    /**
     * Breaks the block and spawns items as if a player had digged it with a
     * specific tool
     *
     * @param tool The tool or item in hand used for digging
     * @return true if the block was destroyed
     */
    boolean breakNaturally(ItemStack tool);

    /**
     * Returns a list of items which would drop by destroying this block
     *
     * @return a list of dropped items for this type of block
     */
    Collection<ItemStack> getDrops();

    /**
     * Returns a list of items which would drop by destroying this block with
     * a specific tool
     *
     * @param tool The tool or item in hand used for digging
     * @return a list of dropped items for this type of block
     */
    Collection<ItemStack> getDrops(ItemStack tool);

}
