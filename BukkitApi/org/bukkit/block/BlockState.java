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
 * 表示方块某一时刻的状态的快照, 不会随方块本身的变更自动更改.
 * <p>
 * 与每个坐标只能存在一个Block实例不同, 对于任何给定的Block, BlockState实例可以存在多个.
 * 请注意, 其它插件可能会更改方块的状态, 而你的插件不会知道其变更;
 * 或者其它插件可能会将方块更改为另一种类型, 从而导致你的BlockState失效.
 */
public interface BlockState extends Metadatable {

    /**
     * 获取此方块状态所表示的方块.
     * <p>
     * 原文:Gets the block represented by this block state.
     *
     * @return 此方块状态所表示的方块
     * @throws IllegalStateException 如果此方块未被放置
     */
    @NotNull
    Block getBlock();

    /**
     * 获取此方块状态的元数据.
     * <p>
     * 原文:Gets the metadata for this block state.
     *
     * @return 方块的元数据
     */
    @NotNull
    MaterialData getData();

    /**
     * 获取此方块状态的数据.
     * <p>
     * 原文:Gets the data for this block state.
     *
     * @return 方块的数据
     */
    @NotNull
    BlockData getBlockData();

    /**
     * 获取此方块状态的类型.
     * <p>
     * 原文:Gets the type of this block state.
     *
     * @return 方块的类型
     */
    @NotNull
    Material getType();

    /**
     * 获取本状态表示的方块所提供的光照强度.
     * <p>
     * 原文:Gets the current light level of the block represented by this block state.
     *
     * @return 光照强度, 范围: 0-15
     * @throws IllegalStateException 如果此方块未被放置
     */
    byte getLightLevel();

    /**
     * 获取方块所在的世界.
     * <p>
     * 原文:Gets the world which contains the block represented by this block state.
     *
     * @return 方块所在的世界
     * @throws IllegalStateException 如果此方块未被放置
     */
    @NotNull
    World getWorld();

    /**
     * 获取此方块状态的x坐标.
     * <p>
     * 原文:Gets the x-coordinate of this block state.
     *
     * @return x坐标
     */
    int getX();

    /**
     * 获取此方块状态的y坐标.
     * <p>
     * 原文:Gets the y-coordinate of this block state.
     *
     * @return y坐标
     */
    int getY();

    /**
     * 获取此方块状态的z坐标.
     * <p>
     * 原文:Gets the z-coordinate of this block state.
     *
     * @return z坐标
     */
    int getZ();

    /**
     * 获取此方块状态的位置.
     * <p>
     * 如果此方块未被放置, 则返回的Location中的world将为null!
     * <p>
     * 原文:Gets the location of this block state.
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
     * 如果此方块未被放置, 则返回的Location中的world将为null!
     * <p>
     * 原文:Stores the location of this block state in the provided Location object.
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
     * 获取此方块状态所在的区块.
     * <p>
     * 原文:Gets the chunk which contains the block represented by this block state.
     *
     * @return 方块所在的区块
     * @throws IllegalStateException 如果此方块未被放置
     */
    @NotNull
    Chunk getChunk();

    /**
     * 设置此方块状态的元数据.
     * <p>
     * 原文:Sets the metadata for this block state.
     *
     * @param data 方块状态的元数据
     */
    void setData(@NotNull MaterialData data);

    /**
     * 设置此方块状态的数据.
     * <p>
     * 原文:Sets the data for this block state.
     *
     * @param data 方块数据
     */
    void setBlockData(@NotNull BlockData data);

    /**
     * 设置本方块状态的类型.
     * <p>
     * 原文:Sets the type of this block state.
     *
     * @param type 要改变的类型
     */
    void setType(@NotNull Material type);

    /**
     * 尝试更新此状态代表的方块, 将此状态中定义的新数据值应用于其方块.
     * <p>
     * 这与调用 update(false) 等效. 也就是说, 如果方块类型不再与本状态的类型相同,
     * 将不会修改方块本身的状态. 万一出现这种状况, 将返回 false.
     * <p>
     * 原文:Attempts to update the block represented by this state, setting it to
     * the new values as defined by this state.
     * <p>
     * This has the same effect as calling update(false). That is to say,
     * this will not modify the state of a block if it is no longer the same
     * type as it was when this state was taken. It will return false in this
     * eventuality.
     *
     * @return true 成功更新返回 true, 否则为 false
     * @see #update(boolean)
     */
    boolean update();

    /**
     * 尝试更新此状态代表的方块, 将此状态中定义的新数据值应用于其方块.
     * <p>
     * 这与调用 update(force, true) 等效. 也就是说, 这将触发周围方块的物理更新.
     * <p>
     * 原文:Attempts to update the block represented by this state, setting it to
     * the new values as defined by this state.
     * <p>
     * This has the same effect as calling update(force, true). That is to
     * say, this will trigger a physics update to surrounding blocks.
     *
     * @param force true以强制设置状态
     * @return 成功更新返回 true, 否则为 false
     */
    boolean update(boolean force);

    /**
     * 尝试更新此状态代表的方块, 将此状态中定义的新数据值应用于其方块.
     * <p>
     * 如果此方块未被放置, 这将没有任何效果并返回 false.
     * <p>
     * 除非 force 为 true, 当原方块的类型与此方块状态的类型不再相同时, 将不会修改方块本身的状态.
     * <p>
     * 原文:Attempts to update the block represented by this state, setting it to
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
     * @param force true以强制设置状态
     * @param applyPhysics false以取消对周围方块的物理更新
     * @return 成功更新返回 true, 否则为 false
     */
    boolean update(boolean force, boolean applyPhysics);

    /**
     * @return 原始字节数据
     * @deprecated 不安全的参数
     */
    @Deprecated
    public byte getRawData();

    /**
     * @param data 方块新数据值
     * @deprecated 不安全的参数
     */
    @Deprecated
    public void setRawData(byte data);

    /**
     * 返回本状态是否已放置于世界.
     * <p>
     * 如果方块状态未放置于世界, 一些方法将不能正常工作.
     * <p>
     * 译注:这里的具体含义指是否已设置状态的 world 字段.
     * 从真实方块获取到的 BlockState 是已设置所在世界的,
     * 从 ItemMeta 中获取的 BlockState 是虚拟的, 其未设置所在的世界.
     * 因此对于虚拟的 BlockState, 与世界有关的操作都是不能进行的.
     * <p>
     * 原文:Returns whether this state is placed in the world.
     * <p>
     * Some methods will not work if the block state isn't
     * placed in the world.
     *
     * @return 是否已为本状态设置所在世界, 或这是虚拟的状态(false) (比如应用于一个物品堆)
     */
    boolean isPlaced();
}
