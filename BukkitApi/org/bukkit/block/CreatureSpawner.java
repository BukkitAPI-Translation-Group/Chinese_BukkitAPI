package org.bukkit.block;

import org.bukkit.entity.EntityType;

/**
 * 代表一个刷怪笼(快照).
 */
public interface CreatureSpawner extends BlockState {

    /**
     * 获取刷怪笼的类型.
     * <p>
     * 原文:
     * Get the spawner's creature type.
     *
     * @return 刷怪笼的类型.
     */
    public EntityType getSpawnedType();

    /**
     * 设置刷怪笼的类型.
     * <p>
     * 原文:
     * Set the spawner's creature type.
     *
     * @param creatureType 刷怪笼的类型.
     */
    public void setSpawnedType(EntityType creatureType);

    /**
     * 设置刷怪笼要生成的生物类型.
     * <p>
     * 原文
     * Set the spawner mob type.
     *
     * @param creatureType 刷怪笼类型的名称.
     * @deprecated 不安全的参数，请使用
     * {@link #setSpawnedType(org.bukkit.entity.EntityType)}.
     */
    @Deprecated
    public void setCreatureTypeByName(String creatureType);

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
     * The minimum spawn delay amount (in ticks).
     * <br>
     * This value is used when the spawner resets its delay (for any reason).
     * It will choose a random number between {@link #getMinSpawnDelay()}
     * and {@link #getMaxSpawnDelay()} for its next {@link #getDelay()}.
     *
     * Default value is 200 ticks.
     *
     * @return the minimum spawn delay amount
     */
    public int getMinSpawnDelay();

    /**
     * Set the minimum spawn delay amount (in ticks).
     *
     * @see #getMinSpawnDelay()
     * @param delay the minimum spawn delay amount
     */
    public void setMinSpawnDelay(int delay);

    /**
     * The maximum spawn delay amount (in ticks).
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
     * @return the maximum spawn delay amount
     */
    public int getMaxSpawnDelay();

    /**
     * Set the maximum spawn delay amount (in ticks).
     * <br>
     * This value <b>must</b> be greater than 0, as well as greater than or
     * equal to {@link #getMinSpawnDelay()}
     *
     * @see #getMaxSpawnDelay()
     * @param delay the new maximum spawn delay amount
     */
    public void setMaxSpawnDelay(int delay);

    /**
     * Get how many mobs attempt to spawn.
     * <br>
     * Default value is 4.
     *
     * @return the current spawn count
     */
    public int getSpawnCount();

    /**
     * Set how many mobs attempt to spawn.
     *
     * @param spawnCount the new spawn count
     */
    public void setSpawnCount(int spawnCount);

    /**
     * Set the new maximum amount of similar entities that are allowed to be
     * within spawning range of this spawner.
     * <br>
     * If more than the maximum number of entities are within range, the spawner
     * will not spawn and try again with a new {@link #getDelay()}.
     * <br>
     * Default value is 16.
     *
     * @return the maximum number of nearby, similar, entities
     */
    public int getMaxNearbyEntities();

    /**
     * Set the maximum number of similar entities that are allowed to be within
     * spawning range of this spawner.
     * <br>
     * Similar entities are entities that are of the same {@link EntityType}
     *
     * @param maxNearbyEntities the maximum number of nearby, similar, entities
     */
    public void setMaxNearbyEntities(int maxNearbyEntities);

    /**
     * Get the maximum distance(squared) a player can be in order for this
     * spawner to be active.
     * <br>
     * If this value is less than or equal to 0, this spawner is always active
     * (given that there are players online).
     * <br>
     * Default value is 16.
     *
     * @return the maximum distance(squared) a player can be in order for this
     * spawner to be active.
     */
    public int getRequiredPlayerRange();

    /**
     * Set the maximum distance (squared) a player can be in order for this
     * spawner to be active.
     * <br>
     * Setting this value to less than or equal to 0 will make this spawner
     * always active (given that there are players online).
     *
     * @param requiredPlayerRange the maximum distance (squared) a player can be
     * in order for this spawner to be active.
     */
    public void setRequiredPlayerRange(int requiredPlayerRange);

    /**
     * Get the radius around which the spawner will attempt to spawn mobs in.
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
     * @return the spawn range
     */
    public int getSpawnRange();

    /**
     * Set the new spawn range.
     * <br>
     *
     * @see #getSpawnRange()
     * @param spawnRange the new spawn range
     */
    public void setSpawnRange(int spawnRange);
}
