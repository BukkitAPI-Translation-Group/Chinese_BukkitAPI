package org.bukkit.spawner;

import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.SpawnerMinecart;

/**
 * Represents an entity spawner. <br>
 * May be a {@link SpawnerMinecart} or a {@link CreatureSpawner}.
 */
public interface Spawner extends BaseSpawner {

    /**
     * {@inheritDoc}
     * <br>
     * 如果设为-1，则刷怪延迟将被重置为一个随机的值(范围在{@link #getMinSpawnDelay}和{@link #getMaxSpawnDelay()}之间).
     *
     * @param delay 延迟.
     */
    @Override
    public void setDelay(int delay);

    /**
     * 获取刷怪笼最小刷怪延迟.
     * <br>
     * 当刷怪延迟被重置时使用该值.
     * 系统会在范围 [{@link #getMinSpawnDelay()}, {@link #getMaxSpawnDelay()}) 内随机选一个值用于下一个{@link #getDelay() 刷怪延迟}.
     * <br>
     * 默认值为 200 ticks.
     * <p>
     * 原文:The minimum spawn delay amount (in ticks).
     * <br>
     * This value is used when the spawner resets its delay (for any reason).
     * It will choose a random number between {@link #getMinSpawnDelay()}
     * and {@link #getMaxSpawnDelay()} for its next {@link #getDelay()}.
     * <br>
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
     * <br>
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
     * <br>
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
}
