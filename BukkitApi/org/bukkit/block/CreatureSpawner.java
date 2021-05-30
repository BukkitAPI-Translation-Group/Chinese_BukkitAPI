package org.bukkit.block;

import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;

/**
 * 代表刷怪笼.
 */
public interface CreatureSpawner extends TileState {

    /**
     * 获取刷出的生物的类型.
     * <p>
     * 原文:
     * Get the spawner's creature type.
     *
     * @return 生物类型
     */
    @NotNull
    public EntityType getSpawnedType();

    /**
     * 设置刷出的生物的类型.
     * <p>
     * 原文:
     * Set the spawner's creature type.
     *
     * @param creatureType 生物类型
     */
    public void setSpawnedType(@NotNull EntityType creatureType);

    /**
     * 设置刷怪笼要生成的生物名.
     * <p>
     * 原文:
     * Set the spawner mob type.
     *
     * @param creatureType 要刷出的生物的名称.
     * @deprecated 不安全的参数，请使用
     * {@link #setSpawnedType(org.bukkit.entity.EntityType)}.
     */
    @Deprecated
    public void setCreatureTypeByName(@NotNull String creatureType);

    /**
     * 获取要刷出的生物的名称.
     * <p>
     * 原文:
     * Get the spawner's creature type.
     *
     * @return 要刷出的生物的名称.
     * @deprecated 不安全的参数，请使用{@link #getSpawnedType()}.
     */
    @Deprecated
    @NotNull
    public String getCreatureTypeName();

    /**
     * 获取刷怪笼的刷怪延迟.
     * <br>
     * 延迟时间以tick为单位.
     * <p>
     * 原文:
     * Get the spawner's delay.
     * <br>
     * This is the delay, in ticks, until the spawner will spawn its next mob.
     *
     * @return 延迟.
     */
    public int getDelay();

    /**
     * 设置刷怪笼刷怪延迟.
     * <br>
     * 如果设为-1，则刷怪延迟将被重置为一个随机的值(范围在{@link #getMinSpawnDelay}和{@link #getMaxSpawnDelay()}之间).
     * <p>
     * 原文:
     * Set the spawner's delay.
     * <br>
     * If set to -1, the spawn delay will be reset to a random value between
     * {@link #getMinSpawnDelay} and {@link #getMaxSpawnDelay()}.
     *
     * @param delay 延迟.
     */
    public void setDelay(int delay);

    /**
     * 获取刷怪笼最小刷怪延迟.
     * <br>
     * 当刷怪延迟被重置时使用该值.
     * 系统会在范围 [{@link #getMinSpawnDelay()}, {@link #getMaxSpawnDelay()}) 内随机选一个值用于下一个{@link #getDelay() 刷怪延迟}.
     *
     * 默认值为 200 ticks.
     * <p>
     * 原文:The minimum spawn delay amount (in ticks).
     * <br>
     * This value is used when the spawner resets its delay (for any reason).
     * It will choose a random number between {@link #getMinSpawnDelay()}
     * and {@link #getMaxSpawnDelay()} for its next {@link #getDelay()}.
     *
     * Default value is 200 ticks.
     *
     * @return 最小刷怪延迟
     */
    public int getMinSpawnDelay();

    /**
     * 设置刷怪笼最小刷怪延迟.
     * <p>
     * 原文:Set the minimum spawn delay amount (in ticks).
     *
     * @see #getMinSpawnDelay()
     * @param delay 最小刷怪延迟
     */
    public void setMinSpawnDelay(int delay);

    /**
     * 获取刷怪笼最大刷怪延迟.
     * <br>
     * 当刷怪延迟被重置时使用该值.
     * 系统会在范围 [{@link #getMinSpawnDelay()}, {@link #getMaxSpawnDelay()}) 内随机选一个值用于下一个{@link #getDelay() 刷怪延迟}.
     * <br>
     * 该值<b>必须</b>大于0且小于或等于 {@link #getMaxSpawnDelay()}.
     *
     * 默认值为 800 ticks.
     * <p>
     * 原文:The maximum spawn delay amount (in ticks).
     * <br>
     * This value is used when the spawner resets its delay (for any reason).
     * It will choose a random number between {@link #getMinSpawnDelay()}
     * and {@link #getMaxSpawnDelay()} for its next {@link #getDelay()}.
     * <br>
     * This value <b>must</b> be greater than 0 and less than or equal to
     * {@link #getMaxSpawnDelay()}.
     *
     * Default value is 800 ticks.
     *
     * @return 最大刷怪延迟
     */
    public int getMaxSpawnDelay();

    /**
     * 设置刷怪笼最大刷怪延迟.
     * <br>
     * 该值<b>必须</b>大于0且小于或等于 {@link #getMaxSpawnDelay()}.
     * <p>
     * 原文:Set the maximum spawn delay amount (in ticks).
     * <br>
     * This value <b>must</b> be greater than 0, as well as greater than or
     * equal to {@link #getMinSpawnDelay()}
     *
     * @see #getMaxSpawnDelay()
     * @param delay 最大刷怪延迟
     */
    public void setMaxSpawnDelay(int delay);

    /**
     * 获取刷怪笼每次刷怪的数量.
     * <br>
     * 默认值为 4.
     * <p>
     * 原文:Get how many mobs attempt to spawn.
     * <br>
     * Default value is 4.
     *
     * @return 刷怪数
     */
    public int getSpawnCount();

    /**
     * 设置刷怪笼每次刷怪的数量.
     * <p>
     * 原文:Set how many mobs attempt to spawn.
     *
     * @param spawnCount 刷怪数
     */
    public void setSpawnCount(int spawnCount);

    /**
     * 获取刷怪范围内允许出现的相似实体的最大数量.
     * <br>
     * 如果刷怪范围内存在超过数量上限的实体, 刷怪笼将不会刷怪并在随机的新延迟后再次尝试刷怪.
     * <br>
     * 默认值为 6 (译注:原文 "16" 的数据有误, wiki和代码中的数据均为 6).
     * <p>
     * 原文:Set the new maximum amount of similar entities that are allowed to be
     * within spawning range of this spawner.
     * <br>
     * If more than the maximum number of entities are within range, the spawner
     * will not spawn and try again with a new {@link #getDelay()}.
     * <br>
     * Default value is 16.
     *
     * @return 附近相似实体的最大数量
     */
    public int getMaxNearbyEntities();

    /**
     * 设置刷怪范围内允许出现的相似实体的最大数量.
     * <br>
     * “相似实体”指的是同种{@link EntityType 类型}的实体.
     * <p>
     * 原文:Set the maximum number of similar entities that are allowed to be within
     * spawning range of this spawner.
     * <br>
     * Similar entities are entities that are of the same {@link EntityType}
     *
     * @param maxNearbyEntities 附近相似实体的最大数量
     */
    public void setMaxNearbyEntities(int maxNearbyEntities);

    /**
     * 获取玩家使刷怪笼激活所需的最远距离.
     * <br>
     * 如果该值小于或等于0, 则此刷怪笼永远处于激活状态.
     * <br>
     * 默认值为 16.
     * <br>
     * 译注:原文中的 "distance(squared)" 意为在比较距离时会使用此距离的平方与
     * 两点(玩家与刷怪笼)间坐标差的平方和作比较, 毕竟乘法运算比开方运算快很多.
     * <p>
     * 原文:Get the maximum distance(squared) a player can be in order for this
     * spawner to be active.
     * <br>
     * If this value is less than or equal to 0, this spawner is always active
     * (given that there are players online).
     * <br>
     * Default value is 16.
     *
     * @return 激活刷怪笼所需最远距离
     */
    public int getRequiredPlayerRange();

    /**
     * 设置玩家使刷怪笼激活所需的最远距离.
     * <br>
     * 如果设置小于或等于0的值, 将使刷怪笼永远处于激活状态.
     * <p>
     * 原文:Set the maximum distance (squared) a player can be in order for this
     * spawner to be active.
     * <br>
     * Setting this value to less than or equal to 0 will make this spawner
     * always active (given that there are players online).
     *
     * @param requiredPlayerRange 激活刷怪笼所需最远距离
     */
    public void setRequiredPlayerRange(int requiredPlayerRange);

    /**
     * 获取刷怪笼刷怪区域的半径.
     * <br>
     * 这个区域形为正方形, 以刷怪笼所在地为中心, 向 x,z 轴方向延伸(不含刷怪笼本身).
     * <br>
     * 这个区域以刷怪笼的y轴(它的底部)为中心算起, 高2个方块,
     * 这允许生物有足够空间在这个区域的顶部和底部平面下一格方块的区域内生成.
     * <br>
     * 默认值为 4.
     * <p>
     * 原文:Get the radius around which the spawner will attempt to spawn mobs in.
     * <br>
     * This area is square, includes the block the spawner is in, and is
     * centered on the spawner's x,z coordinates - not the spawner itself.
     * <br>
     * It is 2 blocks high, centered on the spawner's y-coordinate (its bottom);
     * thus allowing mobs to spawn as high as its top surface and as low
     * as 1 block below its bottom surface.
     * <br>
     * Default value is 4.
     *
     * @return 刷怪半径
     */
    public int getSpawnRange();

    /**
     * 设置新的刷怪半径.
     * <p>
     * 原文:Set the new spawn range.
     * <br>
     *
     * @see #getSpawnRange()
     * @param spawnRange 半径
     */
    public void setSpawnRange(int spawnRange);
}
