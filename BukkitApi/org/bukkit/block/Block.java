package org.bukkit.block;

import java.util.Collection;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.Metadatable;

/**
 * 代表方块类.
 */
public interface Block extends Metadatable {

    /**
     * 得到该方块的属性. <p>
     * 原文: Gets the metadata for this block
     *
     * @return block 方块属性
     * @deprecated 不安全的参数
     */
    @Deprecated
    byte getData();

    /**
     * 得到该方块的坐标偏移后的方块. <p>
     *
     * @param modX X坐标偏移
     * @param modY Y坐标偏移
     * @param modZ Z坐标偏移
     * @return Block 在偏移后的坐标上的方块
     */
    Block getRelative(int modX, int modY, int modZ);

    /**
     * 得到这个方块某个方向最近的一个方块. <p>
     * 原文:Gets the block at the given face
     * <p>
     * This method is equal to getRelative(face, 1)
     *
     * @param face 方向  {@link BlockFace}}
     * @return Block 在该方块给定的方向的最近的一个方块
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
     * 得到该方块的类型. <p>
     * 原文:Gets the type of this block
     *
     * @return 一个Material类型.
     */
    Material getType();

    /**
     * 得到该方块的ID. <p>
     * 原文: Gets the typeid of this block
     * 
     * @return 方块ID
     * @deprecated 更好的方法是使用getType().
     */
    @Deprecated
    int getTypeId();

    /**
     * 得到1~15之间的亮度. <p>
     * 原文: Gets the light level between 0-15
     *
     * @return 亮度
     */
    byte getLightLevel();

    /**
     * 获取从天空传来该方块上的亮度. <p>
     * 仅仅是天空(太阳,月亮)的,火把萤石等的亮度都会被忽略. <p>
     * 原文:Get the amount of light at this block from the sky.
     * <p>
     * Any light given from other sources (such as blocks like torches) will
     * be ignored.
     *
     * @return 天空光照等级.
     */
    byte getLightFromSky();

    /**
     * 获取从其他方块传来该方块的亮度. <p>
     * 仅仅是方块(火把萤石等),天空中传来的将会被忽略. <p>
     * 原文:Get the amount of light at this block from nearby blocks.
     * <p>
     * Any light given from other sources (such as the sun) will be ignored.
     *
     * @return 其他方块传来的光照的等级.
     */
    byte getLightFromBlocks();

    /**
     * 获取这个方块所在的世界. <p>
     * 原文:Gets the world which contains this Block
     *
     * @return 该方块所在的世界.
     */
    World getWorld();

    /**
     * 得到该方块的X坐标. <p>
     * 原文:Gets the x-coordinate of this block
     *
     * @return X坐标
     */
    int getX();

    /**
     * 得到该方块的Y坐标. <p>
     * 原文:Gets the y-coordinate of this block
     *
     * @return Y坐标
     */
    int getY();

    /**
     * 得到该方块的Z坐标. <p>
     * 原文:Gets the z-coordinate of this block
     *
     * @return Z坐标
     */
    int getZ();

    /**
     * 得到该方块的位置实例. <p>
     * 原文:Gets the Location of the block
     *
     * @return 该方块的位置实例.
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
     * 得到该方块所在的区块. <p>
     * 原文:Gets the chunk which contains this block
     *
     * @return 所在区块.
     */
    Chunk getChunk();

    /**
     * 设置该方块的属性. <p>
     * 原文:Sets the metadata for this block
     *
     * @param data 新的方块属性.
     * @deprecated 不安全的参数.
     */
    @Deprecated
    void setData(byte data);

    /**
     * 设置该方块的属性. <p>
     * 原文: Sets the metadata for this block
     *
     * @param data 新的方块属性
     * @param applyPhysics 为false时取消物理效果.
     * @deprecated 不安全的参数.
     */
    @Deprecated
    void setData(byte data, boolean applyPhysics);

    /**
     * 设置方块类型. <p>
     * 原文: Sets the type of this block
     *
     * @param type 方块类型.
     */
    void setType(Material type);

    /**
     * 设置方块类型. <p>
     * 原文: Sets the type of this block
     *
     * @param type 方块类型.
     * @param applyPhysics 为false时取消物理效果.
     */
    void setType(Material type, boolean applyPhysics);

    /**
     * 设置方块的类型ID. <p>
     * 原文: Sets the type-id of this block
     *
     * @param type 类型ID.
     * @return 方块是否被改变.
     * @deprecated 不安全的参数.
     */
    @Deprecated
    boolean setTypeId(int type);

    /**
     * 设置方块的类型ID. <p>
     * 原文: Sets the type-id of this block
     *
     * @param type 类型ID.
     * @param applyPhysics 为false时取消物理效果.
     * @return 方块是否被改变.
     * @deprecated 不安全的参数.
     */
    @Deprecated
    boolean setTypeId(int type, boolean applyPhysics);

    /**
     * 设置方块ID,属性. <p>
     * 原文: Sets the type-id and the data of this block
     *
     * @param type 类型ID.
     * @param data 方块属性.
     * @param applyPhysics 为false时取消物理效果.
     * @return 方块是否被改变.
     * @deprecated 不安全的参数.
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
     * 得到方块的状态. <p> 
     * 可以用来得到一个木牌对象. <p>
     * 如: Sign sign = (Sign)block.getState(); <p>
     * 原文: Captures the current state of this block. You may then cast that state
     * into any accepted type, such as Furnace or Sign.
     * <p>
     * The returned object will never be updated, and you are not guaranteed
     * that (for example) a sign is still a sign after you capture its state.
     *
     * @return BlockState with the current state of this block.
     */
    BlockState getState();

    /**
     * 得到方块的生物群系. <p>.
     * 原文:Returns the biome that this block resides in
     *
     * @return 生物群系.
     */
    Biome getBiome();

    /**
     * 设置方块的生物群系.
     * 原文:Sets the biome that this block resides in
     *
     * @param bio 新生物群系.
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
     * 检查方块是否为空气. <p>
     * 原文:Checks if this block is empty.
     * <p>
     * A block is considered empty when {@link #getType()} returns {@link
     * Material#AIR}.
     *
     * @return 为空气时返回true.
     */
    boolean isEmpty();

    /**
     * 检查方块是否是液体. <p>
     * 原文:Checks if this block is liquid.
     * <p>
     * A block is considered liquid when {@link #getType()} returns {@link
     * Material#WATER}, {@link Material#STATIONARY_WATER}, {@link
     * Material#LAVA} or {@link Material#STATIONARY_LAVA}.
     *
     * @return 为液体时返回true.
     */
    boolean isLiquid();

    /**
     * Gets the temperature of the biome of this block
     *
     * @return Temperature of this block
     */
    double getTemperature();

    /**
     * Gets the humidity of the biome of this block.
     *
     * @return Humidity of this block
     */
    double getHumidity();

    /**
     * 返回方块在被活塞推动时的反应. <p>
     * 原文:Returns the reaction of the block when moved by a piston
     *
     * @return 反应.
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
     * 返回该方块破坏后会掉落的物品列表. <p>
     * 原文: Returns a list of items which would drop by destroying this block
     *
     * @return 方块会掉落的物品列表.
     */
    Collection<ItemStack> getDrops();

    /**
     * 返回该方块使用的特定的工具破坏后会掉落的物品列表. <p>
     * 原文:Returns a list of items which would drop by destroying this block with
     * a specific tool
     *
     * @param tool 特定的工具.
     * @return 会掉落的物品列表.
     */
    Collection<ItemStack> getDrops(ItemStack tool);

}