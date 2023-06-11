package org.bukkit.block.data;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.SoundGroup;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockSupport;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.block.structure.Mirror;
import org.bukkit.block.structure.StructureRotation;
import org.bukkit.inventory.ItemStack;
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

    /**
     * Gets the block's {@link SoundGroup} which can be used to get its step
     * sound, hit sound, and others.
     *
     * @return the sound effect group
     */
    @NotNull
    SoundGroup getSoundGroup();

    /**
     * Get the amount of light emitted by this state when in the world.
     *
     * @return the light emission
     */
    int getLightEmission();

    /**
     * Check whether or not this state will occlude other blocks.
     * <p>
     * Block state occlusion affects visual features of other blocks (e.g. leaves and
     * wet sponges will not spawn dripping water particles if an occluding state is
     * below it), or whether light will pass through it.
     *
     * @return true if occluding, false otherwise
     */
    boolean isOccluding();

    /**
     * Check whether or not this state requires a specific item to be used to drop
     * items when broken. For example, diamond ore requires an iron pickaxe and will
     * not drop diamonds when broken with a wooden or stone pickaxe.
     *
     * @return true if a more specific item is required for drops, false if any item
     * (or an empty hand) will drop items
     */
    boolean requiresCorrectToolForDrops();

    /**
     * Returns if the given item is a preferred choice to break this Block.
     *
     * In some cases this determines if a block will drop anything or extra
     * loot.
     *
     * @param tool The tool or item used for breaking this block
     * @return true if the tool is preferred for breaking this block.
     */
    boolean isPreferredTool(@NotNull ItemStack tool);

    /**
     * Returns the reaction of the block when moved by a piston
     *
     * @return reaction
     */
    @NotNull
    PistonMoveReaction getPistonMoveReaction();

    /**
     * Checks if this state would be properly supported if it were placed at
     * the given {@link Block}.
     * <p>
     * This may be useful, for instance, to check whether or not a wall torch is
     * capable of surviving on its neighbouring block states.
     *
     * @param block the block position at which the state would be placed
     *
     * @return true if the block is supported, false if this state would not survive
     * the world conditions
     */
    boolean isSupported(@NotNull Block block);

    /**
     * Checks if this state would be properly supported if it were placed at
     * the block at the given {@link Location}.
     * <p>
     * This may be useful, for instance, to check whether or not a wall torch is
     * capable of surviving on its neighbouring block states.
     *
     * @param location the location at which the state would be placed
     *
     * @return true if the block is supported, false if this state would not survive
     * the world conditions
     */
    boolean isSupported(@NotNull Location location);

    /**
     * Checks if a state's {@link BlockFace} is capable of providing a given level
     * of {@link BlockSupport} for neighbouring block states.
     * <p>
     * Any given state may support either none, one, or more than one level of block
     * support depending on its states. A common example would be a wall's ability to support
     * torches only on the center of the upper block face, whereas a grass block would
     * support all levels of block support on all block faces.
     *
     * @param face the face to check
     * @param support the possible support level
     *
     * @return true if the face is sturdy and can support a block, false otherwise
     */
    boolean isFaceSturdy(@NotNull BlockFace face, @NotNull BlockSupport support);

    /**
     * Gets the material that a player would use to place this block.
     * <p>
     * For most blocks this is the same as {@link #getMaterial()} but some blocks
     * have different materials used to place them.
     *
     * For example:
     * <pre>
     * {@link Material#REDSTONE_WIRE} -> {@link Material#REDSTONE}
     * {@link Material#CARROTS} -> {@link Material#CARROT}
     * </pre>
     * @return placement material
     */
    @NotNull
    Material getPlacementMaterial();

    /**
     * Rotates this blockdata by the specified {@link StructureRotation}.
     * <p>
     * This has no effect on blocks that do not have any rotatable states.
     *
     * @param rotation the rotation
     */
    void rotate(@NotNull StructureRotation rotation);

    /**
     * Mirrors this blockdata using the specified {@link Mirror}.
     * <p>
     * This has no effect on blocks that do not have any mirrorable states.
     *
     * @param mirror the mirror
     */
    void mirror(@NotNull Mirror mirror);
}
