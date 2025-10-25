package org.bukkit.block;

import java.util.Collection;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.BoundingBox;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表潮涌核心.
 */
public interface Conduit extends TileState {

    /**
     * 检查此潮涌核心是否处于激活状态.
     * <p>
     * 原文:
     * Checks whether or not this conduit is active.
     * <p>
     * A conduit is considered active if there are at least 16 valid frame
     * blocks surrounding it and the conduit is surrounded by a 3x3x3 area of
     * water source blocks (or waterlogged blocks), at which point its animation
     * will activate, start spinning, and apply effects to nearby players.
     *
     * 如果周围有至少16个有效的框架方块, 并且潮涌核心被3x3x3的水源方块(或含水方块)区域包围,
     * 则认为潮涌核心处于激活状态, 此时它的动画将激活, 开始旋转, 并对附近的玩家施加效果.
     *
     * @return 如果激活返回true, 否则返回false
     */
    public boolean isActive();

    /**
     * 获取此潮涌核心是否正在积极寻找附近的敌对生物.
     * <p>
     * 原文:
     * Get whether or not this conduit is actively hunting for nearby hostile
     * creatures.
     * <p>
     * A conduit will hunt if it is active (see {@link #isActive()}) and its
     * frame is complete (it is surrounded by at least 42 valid frame blocks).
     * While hunting, the {@link #getTarget()
     * conduit's target}, if within its {@link #getHuntingArea() hunting area},
     * will be damaged every 2 seconds.
     *
     * 如果潮涌核心处于激活状态(参见 {@link #isActive()})且其框架完整(周围有至少42个有效框架方块),
     * 则会进行狩猎. 狩猎时, 如果潮涌核心的 {@link #getTarget() 目标}在其 {@link #getHuntingArea() 狩猎区域}内,
     * 将每2秒受到一次伤害.
     *
     * @return 如果正在狩猎返回true, 否则返回false
     */
    public boolean isHunting();

    /**
     * 获取构成此潮涌核心框架的所有 {@link Block 方块} 的 {@link Collection 集合}.
     * 返回的集合将只包含潮涌核心所需的有效框架类型的方块,
     * <strong>不包括</strong>潮涌核心正在搜索的方块,
     * 这意味着集合的大小将根据调用时潮涌核心周围有多少有效框架而变化.
     * <p>
     * 原文:
     * Get a {@link Collection} of all {@link Block Blocks} that make up the
     * frame of this conduit. The returned collection will contain only blocks
     * that match the types required by the conduit to make up a valid frame,
     * <strong>not</strong> the blocks at which the conduit is searching,
     * meaning it will be of variable size depending on how many valid frames
     * are surrounding the conduit at the time of invocation.
     *
     * @return 框架方块
     */
    @NotNull
    public Collection<Block> getFrameBlocks();

    /**
     * 获取当前围绕潮涌核心的有效框架方块数量.
     * <p>
     * 原文:
     * Get the amount of valid frame blocks that are currently surrounding the
     * conduit.
     *
     * @return 框架方块数量
     */
    public int getFrameBlockCount();

    /**
     * 获取玩家将获得潮涌核心益处的范围(以方块为单位).
     * <p>
     * 原文:
     * Get the range (measured in blocks) within which players will receive the
     * conduit's benefits.
     *
     * @return 潮涌核心范围
     */
    public int getRange();

    /**
     * 设置潮涌核心的狩猎目标.
     * <p>
     * 原文:
     * Set the conduit's hunting target.
     * <p>
     * Note that the value set by this method may be overwritten by the
     * conduit's periodic hunting logic. If the target is ever set to
     * {@code null}, the conduit will continue to look for a new target.
     * Additionally, if the target is set to an entity that does not meet a
     * conduit's hunting conditions (e.g. the entity is not within the
     * {@link #getHuntingArea() hunting area}, has already been killed, etc.)
     * then the passed entity will be ignored and the conduit will also continue
     * to look for a new target.
     *
     * 请注意, 此方法设置的值可能会被潮涌核心的周期性狩猎逻辑覆盖.
     * 如果目标被设置为 {@code null}, 潮涌核心将继续寻找新目标.
     * 此外, 如果目标被设置为不符合潮涌核心狩猎条件的实体
     * (例如实体不在 {@link #getHuntingArea() 狩猎区域}内, 已经被杀死等),
     * 则传递的实体将被忽略, 潮涌核心也将继续寻找新目标.
     *
     * @param target 目标实体, 或null以移除目标
     *
     * @return 如果目标被更改返回true, 如果目标相同返回false
     */
    public boolean setTarget(@Nullable LivingEntity target);

    /**
     * 获取潮涌核心的狩猎目标.
     * <p>
     * 原文:
     * Get the conduit's hunting target.
     *
     * @return 狩猎目标, 如果潮涌核心没有目标则返回null
     */
    @Nullable
    public LivingEntity getTarget();

    /**
     * 检查此潮涌核心是否有活动的(存活的)狩猎目标.
     * <p>
     * 原文:
     * Check whether or not this conduit has an active (alive) hunting target.
     *
     * @return 如果有狩猎目标返回true, 否则返回false
     */
    public boolean hasTarget();

    /**
     * 获取潮涌核心将在其中搜索敌对实体作为目标的 {@link BoundingBox 边界框}(相对于真实世界坐标).
     * <p>
     * 原文:
     * Get a {@link BoundingBox} (relative to real-world coordinates) in which
     * the conduit will search for hostile entities to target.
     *
     * @return 狩猎区域边界框
     */
    @NotNull
    public BoundingBox getHuntingArea();
}
