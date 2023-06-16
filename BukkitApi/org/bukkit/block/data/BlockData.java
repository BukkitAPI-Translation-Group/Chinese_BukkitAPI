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
     *                        为 false 时未指定的数据值也会被编入字符串, 与 {@link #getAsString()} 方法的执行结果一样.
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
     * 获取方块的{@link SoundGroup}，可以用它来获取其行走声音、击打声音等其它声音。
     * <p>
     * 原文:
     * Gets the block's {@link SoundGroup} which can be used to get its step
     * sound, hit sound, and others.
     *
     * @return 音效组
     */
    @NotNull
    SoundGroup getSoundGroup();

    /**
     * 获取此状态下的方块在世界中发出的光照强度。
     * <p>
     * 原文:
     * Get the amount of light emitted by this state when in the world.
     *
     * @return 光照强度
     */
    int getLightEmission();

    /**
     * 检查此状态下的方块是否会遮挡其他方块。
     * <p>
     * 方块状态遮挡会影响其他方块的视觉特性（例如，如果其下方有遮挡状态，则树叶和湿海绵将不会产生滴水颗粒），或光能否通过它。
     * <p>
     * 原文:
     * Check whether or not this state will occlude other blocks.
     * <p>
     * Block state occlusion affects visual features of other blocks (e.g. leaves and
     * wet sponges will not spawn dripping water particles if an occluding state is
     * below it), or whether light will pass through it.
     *
     * @return 如果会遮挡其它方块为true, 否则为 false
     */
    boolean isOccluding();

    /**
     * 检查是否需要使用特定物品才能掉落其物品。例如，钻石矿石需要使用铁镐才能采集，否则使用木镐或石镐无法掉落钻石。
     * <p>
     * 原文:
     * Check whether or not this state requires a specific item to be used to drop
     * items when broken. For example, diamond ore requires an iron pickaxe and will
     * not drop diamonds when broken with a wooden or stone pickaxe.
     *
     * @return 如果需要一种或多种特定物品才能掉落物品则为true, 如果任意物品（或空手）即可掉落物品则为 false
     */
    boolean requiresCorrectToolForDrops();

    /**
     * 返回给定物品是否为破坏此方块的首选选择。
     * <p>
     * 在某些情况下，这将决定方块是否掉落任何物品或额外的战利品。
     * <p>
     * 原文:
     * Returns if the given item is a preferred choice to break this Block.
     * <p>
     * In some cases this determines if a block will drop anything or extra
     * loot.
     *
     * @param tool 用于破坏此方块的工具或物品
     * @return 如果此工具是破坏此方块的首选选择则为 true.
     */
    boolean isPreferredTool(@NotNull ItemStack tool);

    /**
     * 返回方块被活塞推动时的反应。
     * <p>
     * 原文:
     * Returns the reaction of the block when moved by a piston
     *
     * @return reaction 反应
     */
    @NotNull
    PistonMoveReaction getPistonMoveReaction();

    /**
     * 检查如果此状态下的方块放置在给定的{@link Block 方块}上，它是否会被正常支撑。
     * <p>
     * 例如，这可能有用来检查壁式火炬是否能够在其相邻的方块状态上存活。
     * <p>
     * 原文:
     * Checks if this state would be properly supported if it were placed at
     * the given {@link Block}.
     * <p>
     * This may be useful, for instance, to check whether or not a wall torch is
     * capable of surviving on its neighbouring block states.
     *
     * @param block 此方块要放置在哪个方块上
     * @return 如果此方块可被支撑则为 true, 如果此状态下的方块无法在此世界的状况下留存则为 false
     */
    boolean isSupported(@NotNull Block block);

    /**
     * 检查如果此状态下的方块放置在给定的 {@link Location} 的方块上，它是否会被正常支撑。
     * <p>
     * 例如，这可能有用来检查壁式火炬是否能够在其相邻的方块状态上存活。
     * <p>
     * 原文:
     * Checks if this state would be properly supported if it were placed at
     * the block at the given {@link Location}.
     * <p>
     * This may be useful, for instance, to check whether or not a wall torch is
     * capable of surviving on its neighbouring block states.
     *
     * @param location 此方块要放置在哪个位置上
     * @return 如果此方块可被支撑则为 true, 如果此状态下的方块无法在此世界的状况下留存则为 false
     */
    boolean isSupported(@NotNull Location location);

    /**
     * 检查状态的 {@link BlockFace} 是否能够为相邻的方块状态提供特定级别的 {@link BlockSupport}。
     * <p>
     * 任何给定状态都可以根据其状态支持零、一个或多个支撑级别。一个常见的例子是墙只能在上表面中心支撑火把，而草方块则在所有表面支持所有支撑级别。
     * <p>
     * 原文:
     * Checks if a state's {@link BlockFace} is capable of providing a given level
     * of {@link BlockSupport} for neighbouring block states.
     * <p>
     * Any given state may support either none, one, or more than one level of block
     * support depending on its states. A common example would be a wall's ability to support
     * torches only on the center of the upper block face, whereas a grass block would
     * support all levels of block support on all block faces.
     *
     * @param face 要检测的面
     * @param support 可能的支撑级别
     * @return 如果这一面足够牢固并可支撑此方块则为 true, 否则为 false
     */
    boolean isFaceSturdy(@NotNull BlockFace face, @NotNull BlockSupport support);

    /**
     * 获取玩家放置此方块所使用的物品材质。
     * <p>
     * 对于大多数方块，这与 {@link #getMaterial()} 相同，但有些方块有不同的材质用于放置它们。
     * <p>
     * 例如：
     * <pre>
     * {@link Material#REDSTONE_WIRE} -> {@link Material#REDSTONE}
     * {@link Material#CARROTS} -> {@link Material#CARROT}
     * </pre>
     * <p>
     * 原文:
     * Gets the material that a player would use to place this block.
     * <p>
     * For most blocks this is the same as {@link #getMaterial()} but some blocks
     * have different materials used to place them.
     * <p>
     * For example:
     * <pre>
     * {@link Material#REDSTONE_WIRE} -> {@link Material#REDSTONE}
     * {@link Material#CARROTS} -> {@link Material#CARROT}
     * </pre>
     *
     * @return 放置此方块所使用的物品材质
     */
    @NotNull
    Material getPlacementMaterial();

    /**
     * 使用指定的 {@link StructureRotation} 旋转此方块数据。
     * <p>
     * 这对于没有可旋转状态的方块没有影响。
     * <p>
     * 原文:
     * Rotates this blockdata by the specified {@link StructureRotation}.
     * <p>
     * This has no effect on blocks that do not have any rotatable states.
     *
     * @param rotation 旋转角度
     */
    void rotate(@NotNull StructureRotation rotation);

    /**
     * 使用指定的 {@link Mirror} 镜像此方块数据。
     * <p>
     * 这对于没有可镜像状态的方块没有影响。
     * <p>
     * 原文:
     * Mirrors this blockdata using the specified {@link Mirror}.
     * <p>
     * This has no effect on blocks that do not have any mirrorable states.
     *
     * @param mirror 镜像
     */
    void mirror(@NotNull Mirror mirror);
}
