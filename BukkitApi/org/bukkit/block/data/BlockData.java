package org.bukkit.block.data;

import org.bukkit.Material;
import org.bukkit.Server;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface BlockData extends Cloneable {

    /**
     * 获取该BlockData实例描述的物品.
     * <p>
     * 原文:Get the Material represented by this block data.
     *
     * @return 物品
     */
    @NotNull
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
    @NotNull
    String getAsString();

    /**
     * Gets a string, which when passed into a method such as
     * {@link Server#createBlockData(java.lang.String)} will recreate this or a
     * similar instance where unspecified states (if any) may be optionally
     * omitted. If this instance was parsed and states are omitted, this exact
     * instance will be creatable when parsed again, else their equality cannot
     * be guaranteed.
     * <p>
     * This method will only take effect for BlockData instances created by
     * methods such as {@link Server#createBlockData(String)} or any similar
     * method whereby states are optionally defined. If otherwise, the result of
     * {@link #getAsString()} will be returned. The following behaviour would be
     * expected:
     * <pre>{@code
     * String dataString = "minecraft:chest[waterlogged=true]"
     * BlockData data = Bukkit.createBlockData(dataString);
     * dataString.equals(data.getAsString(true)); // This would return true
     * dataString.equals(data.getAsString(false)); // This would return false as all states are present
     * dataString.equals(data.getAsString()); // This is equivalent to the above, "getAsString(false)"
     * }</pre>
     *
     * @param hideUnspecified true if unspecified states should be omitted,
     * false if they are to be shown as performed by {@link #getAsString()}.
     *
     * @return serialized data string for this block
     */
    @NotNull
    String getAsString(boolean hideUnspecified);

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
     */
    @NotNull
    BlockData merge(@NotNull BlockData data);

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
     */
    boolean matches(@Nullable BlockData data);

    /**
     * 返回该BlockData实例的副本.
     * <p>
     * 原文:Returns a copy of this BlockData.
     *
     * @return BlockData副本
     */
    @NotNull
    BlockData clone();
}
