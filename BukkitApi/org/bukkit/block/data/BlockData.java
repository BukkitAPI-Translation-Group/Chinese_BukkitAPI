package org.bukkit.block.data;

import org.bukkit.Material;
import org.bukkit.Server;

public interface BlockData extends Cloneable {

    /**
     * 获取该BlockData实例描述的物品.
     * <p>
     * 原文:Get the Material represented by this block data.
     *
     * @return 物品
     */
    Material getMaterial();

    /**
     * 获取方块数据值,当将此数据值传入给 {@link Server#createBlockData(java.lang.String)}
     * 方法时,将无缝重建此实例.
     * <p>
     * 原文:Gets a string, which when passed into a method such as
     * {@link Server#createBlockData(java.lang.String)} will unambiguously
     * recreate this instance.
     *
     * @return 方块序列化的数据值
     */
    String getAsString();

    /**
     * Merges all explicitly set states from the given data with this BlockData.
     * <br>
     * Note that the given data MUST have been created from one of the String
     * parse methods, e.g. {@link Server#createBlockData(java.lang.String)} and
     * not have been subsequently modified.
     * <br>
     * Note also that the block types must match identically.
     *
     * @param data the data to merge from
     * @return a new instance of this blockdata with the merged data
     * @deprecated draft API
     */
    @Deprecated
    BlockData merge(BlockData data);

    /**
     * Checks if the specified BlockData matches this block data.
     * <br>
     * The semantics of this method are such that for manually created or
     * modified BlockData it has the same effect as
     * {@link Object#equals(java.lang.Object)}, whilst for parsed data (that to
     * which {@link #merge(org.bukkit.block.data.BlockData)} applies, it will
     * return true when the type and all explicitly set states match.
     * <br>
     * <b>Note that these semantics mean that a.matches(b) may not be the same
     * as b.matches(a)</b>
     *
     * @param data the data to match against (normally a parsed constant)
     * @return if there is a match
     * @deprecated draft API
     */
    @Deprecated
    boolean matches(BlockData data);

    /**
     * 返回该BlockData实例的副本.
     * <p>
     * 原文:Returns a copy of this BlockData.
     *
     * @return BlockData副本
     */
    BlockData clone();
}
