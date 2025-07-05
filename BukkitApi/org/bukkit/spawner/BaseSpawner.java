package org.bukkit.spawner;

import java.util.Collection;
import java.util.List;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.block.spawner.SpawnRule;
import org.bukkit.block.spawner.SpawnerEntry;
import org.bukkit.entity.EntitySnapshot;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.SpawnerMinecart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a basic entity spawner. <br>
 * May be a {@link SpawnerMinecart}, {@link CreatureSpawner} or {@link TrialSpawnerConfiguration}.
 */
public interface BaseSpawner {

    /**
     * 获取刷出的生物的类型.
     * <p>
     * 原文:
     * Get the spawner's creature type.
     *
     * @return 生物类型, 如未设置返回 null
     */
    @Nullable
    public EntityType getSpawnedType();

    /**
     * Set the spawner's creature type. <br>
     * This will override any entities that have been added with {@link #addPotentialSpawn}
     *
     * @param creatureType The creature type or null to clear.
     */
    public void setSpawnedType(@Nullable EntityType creatureType);

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
     * <p>
     * 原文:Set the spawner's delay.
     *
     * @param delay 延迟.
     */
    public void setDelay(int delay);

    /**
     * 获取玩家使刷怪笼激活所需的最远距离.
     * <br>
     * 如果该值小于或等于0, 则此刷怪笼永远处于激活状态.
     * <br>
     * 默认值为 16.
     * <p>
     * 原文:Get the maximum distance a player can be in order for this
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
     * 原文:Set the maximum distance a player can be in order for this
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

    /**
     * Gets the {@link EntitySnapshot} that will be spawned by this spawner or null
     * if no entities have been assigned to this spawner. <br>
     * <p>
     * All applicable data from the spawner will be copied, such as custom name,
     * health, and velocity. <br>
     *
     * @return the entity snapshot or null if no entities have been assigned to this
     *         spawner.
     */
    @Nullable
    public EntitySnapshot getSpawnedEntity();

    /**
     * Sets the entity that will be spawned by this spawner. <br>
     * This will override any previous entries that have been added with
     * {@link #addPotentialSpawn}
     * <p>
     * All applicable data from the snapshot will be copied, such as custom name,
     * health, and velocity. <br>
     *
     * @param snapshot the entity snapshot or null to clear
     */
    public void setSpawnedEntity(@Nullable EntitySnapshot snapshot);

    /**
     * Sets the {@link SpawnerEntry} that will be spawned by this spawner. <br>
     * This will override any previous entries that have been added with
     * {@link #addPotentialSpawn}
     *
     * @param spawnerEntry the spawner entry to use
     */
    public void setSpawnedEntity(@NotNull SpawnerEntry spawnerEntry);

    /**
     * Adds a new {@link EntitySnapshot} to the list of entities this spawner can
     * spawn.
     * <p>
     * The weight will determine how often this entry is chosen to spawn, higher
     * weighted entries will spawn more often than lower weighted ones. <br>
     * The {@link SpawnRule} will determine under what conditions this entry can
     * spawn, passing null will use the default conditions for the given entity.
     *
     * @param snapshot  the snapshot that will be spawned
     * @param weight    the weight
     * @param spawnRule the spawn rule for this entity, or null
     */
    public void addPotentialSpawn(@NotNull EntitySnapshot snapshot, int weight, @Nullable SpawnRule spawnRule);

    /**
     * Adds a new {@link SpawnerEntry} to the list of entities this spawner can
     * spawn.
     *
     * @param spawnerEntry the spawner entry to use
     * @see #addPotentialSpawn(EntitySnapshot, int, SpawnRule)
     */
    public void addPotentialSpawn(@NotNull final SpawnerEntry spawnerEntry);

    /**
     * Sets the list of {@link SpawnerEntry} this spawner can spawn. <br>
     * This will override any previous entries added with
     * {@link #addPotentialSpawn}
     *
     * @param entries the list of entries
     */
    public void setPotentialSpawns(@NotNull final Collection<SpawnerEntry> entries);

    /**
     * Gets a list of potential spawns from this spawner or an empty list if no
     * entities have been assigned to this spawner. <br>
     * Changes made to the returned list will not be reflected in the spawner unless
     * applied with {@link #setPotentialSpawns}
     *
     * @return a list of potential spawns from this spawner, or an empty list if no
     *         entities have been assigned to this spawner
     * @see #getSpawnedType()
     */
    @NotNull
    public List<SpawnerEntry> getPotentialSpawns();
}
