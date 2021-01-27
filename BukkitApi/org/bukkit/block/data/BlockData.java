package org.bukkit.block.data;

import org.bukkit.Material;
import org.bukkit.Server;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface BlockData extends Cloneable {

    /**
     * 获取该 BlockData 实例描述的物品.
     * <p>
     * 原文:
     * Get the Material represented by this block data.
     *
     * @return 物品
     */
    @NotNull
    Material getMaterial();

    /**
     * 获取方块数据值, 当将此数据值传入给 {@link Server#createBlockData(java.lang.String)}
     * 方法时, 将无缝重建此实例.
     * <p>
     * 原文:
     * Gets a string, which when passed into a method such as
     * {@link Server#createBlockData(java.lang.String)} will unambiguously
     * recreate this instance.
     *
     * @return 方块序列化的数据值
     */
    @NotNull
    String getAsString();

    /**
     * 获取一个字符串, 在传入类似于 {@link Server#createBlockData(java.lang.String)}
     * 的方法时可以重建此实例或与此实例相似的一个新实例， 但未被指定的数据值可以选择性的省略.
     * 如果该实例已经被解析且有数据值被省略, 那么再次解析 (字符串) 时就可以创建一个 (与该实例)
     * 一模一样的准确实例, 否则就不能保证新实例与旧实例相等 (equal).
     * <p>
     * 该方法仅对由 {@link Server#createBlockData(String)} 等方法
     * 或其他任何数据值被有选择地赋值而创建的 BlockData 实例有效.
     * 若非此情况, 将会返回 {@link #getAsString()} 方法的执行结果.
     * 预期结果如下:
     * <pre>{@code
     * String dataString = "minecraft:chest[waterlogged=true]"
     * BlockData data = Bukkit.createBlockData(dataString);
     * dataString.equals(data.getAsString(true)); // 将会返回 true
     * dataString.equals(data.getAsString(false)); // 在所有数据值都被赋值的情况下会返回 false
     * dataString.equals(data.getAsString()); // 与上一条语句等价, "getAsString(false)"
     * }</pre>
     * <p>
     * 原文:
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
     * @param hideUnspecified 为 true 时未指定的数据值将会被省略,
     * 为 false 时未指定的数据值也会被编入字符串, 与 {@link #getAsString()} 方法的执行结果一样.
     *
     * @return 关于此方块的序列化数据字符串
     */
    @NotNull
    String getAsString(boolean hideUnspecified);

    /**
     * 将此 BlockData 中的数据与给定数据中所有明确数据合并.
     * <p>
     * 译注: 这里的明确不明确应该是指有具体值的, 被赋值的是明确的.
     * <br>
     * 请注意传入的数据 必须 是由某一种字符串解析方法产生的实例,
     * 例如 {@link Server#createBlockData(java.lang.String)},
     * 且没有被修改过.
     * <br>
     * 也要注意两个 BlockData 的方块类型也要相匹配.
     * <p>
     * 原文:
     * Merges all explicitly set states from the given data with this BlockData.
     * <br>
     * Note that the given data MUST have been created from one of the String
     * parse methods, e.g. {@link Server#createBlockData(java.lang.String)} and
     * not have been subsequently modified.
     * <br>
     * Note also that the block types must match identically.
     *
     * @param data 合并数据来源
     * @return 该方块数据与指定数据合并后的新 BlockData 实例
     */
    @NotNull
    BlockData merge(@NotNull BlockData data);

    /**
     * 判断给定 BlockData 数据与当前方块数据是否相同.
     * <br>
     * 对于手动创建或修改过的 BlockData, 该方法在语义上与
     * {@link Object#equals(java.lang.Object)} 方法效果一致,
     * 而对于已解析的数据 (由 {@link #merge(org.bukkit.block.data.BlockData)} 方法应用产生的),
     * 该方法仅在方块类型和所有明确数据值相匹配时返回 true.
     * <br>
     * <b>请注意 a.matches(b) 与 b.matches(a) 的含义可能不相同</b>
     * <p>
     * 原文:
     * Checks if the specified BlockData matches this block data.
     * <br>
     * The semantics of this method are such that for manually created or
     * modified BlockData it has the same effect as
     * {@link Object#equals(java.lang.Object)}, whilst for parsed data (that to
     * which {@link #merge(org.bukkit.block.data.BlockData)} applies), it will
     * return true when the type and all explicitly set states match.
     * <br>
     * <b>Note that these semantics mean that a.matches(b) may not be the same
     * as b.matches(a)</b>
     *
     * @param data 需要判断相同的数据 (通常是一个常量解析出来的)
     * @return 若两者相匹配返回 true
     */
    boolean matches(@Nullable BlockData data);

    /**
     * 返回该 BlockData 实例的副本.
     * <p>
     * 原文:
     * Returns a copy of this BlockData.
     *
     * @return BlockData 副本
     */
    @NotNull
    BlockData clone();
}
