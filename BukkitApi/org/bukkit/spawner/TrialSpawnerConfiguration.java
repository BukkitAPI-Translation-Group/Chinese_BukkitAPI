package org.bukkit.spawner;

import java.util.Map;
import org.bukkit.loot.LootTable;
import org.jetbrains.annotations.NotNull;

/**
 * 表示试炼刷怪笼的配置之一。
 */
public interface TrialSpawnerConfiguration extends BaseSpawner {

    /**
     * 获取刷怪笼在进入冷却之前将生成的基础实体数量。
     * <p>
     * 原文：Gets the base number of entities the spawner will spawn before going into cooldown.
     *
     * @return the number of entities
     */
    public float getBaseSpawnsBeforeCooldown();

    /**
     * 设置刷怪笼在进入冷却之前将生成的基础实体数量。
     * <p>
     * 原文：Sets the base number of entities the spawner will spawn before going into cooldown.
     *
     * @param amount the number of entities
     */
    public void setBaseSpawnsBeforeCooldown(float amount);

    /**
     * 获取此刷怪笼可以同时跟踪的基础实体数量。<br>
     * 如果达到限制，刷怪笼将无法生成更多实体，直到现有实体被杀死或移动太远。
     * <p>
     * 原文：Gets the base number of entities this spawner can track at once. If the limit is reached the spawner will not be able to spawn any more entities until the existing entities are killed or move too far away.
     *
     * @return the number of entities
     */
    public float getBaseSimultaneousEntities();

    /**
     * 设置此刷怪笼可以同时跟踪的基础实体数量。<br>
     * 如果达到限制，刷怪笼将无法生成更多实体，直到现有实体被杀死或移动太远。
     * <p>
     * 原文：Sets the base number of entities this spawner can track at once. If the limit is reached the spawner will not be able to spawn any more entities until the existing entities are killed or move too far away.
     *
     * @param amount the number of entities
     */
    public void setBaseSimultaneousEntities(float amount);

    /**
     * 获取刷怪笼在进入冷却之前将为每个跟踪的玩家生成的额外实体数量。
     * <p>
     * 原文：Gets the additional number of entities the spawner will spawn per tracked player before going into cooldown.
     *
     * @return the number of entities
     */
    public float getAdditionalSpawnsBeforeCooldown();

    /**
     * 设置刷怪笼在进入冷却之前将为每个跟踪的玩家生成的额外实体数量。
     * <p>
     * 原文：Sets the additional number of entities the spawner will spawn per tracked player before going into cooldown.
     *
     * @param amount the number of entities
     */
    public void setAdditionalSpawnsBeforeCooldown(float amount);

    /**
     * 获取此刷怪笼可以为每个跟踪的玩家同时跟踪的额外实体数量。<br>
     * 如果达到限制，刷怪笼将无法生成更多实体，直到现有实体被杀死或移动太远。
     * <p>
     * 原文：Gets the additional number of entities this spawner can track at once per tracked player. If the limit is reached the spawner will not be able to spawn any more entities until the existing entities are killed or move too far away.
     *
     * @return the number of entities
     */
    public float getAdditionalSimultaneousEntities();

    /**
     * 设置此刷怪笼可以为每个跟踪的玩家同时跟踪的额外实体数量。<br>
     * 如果达到限制，刷怪笼将无法生成更多实体，直到现有实体被杀死或移动太远。
     * <p>
     * 原文：Sets the additional number of entities this spawner can track at once per tracked player. If the limit is reached the spawner will not be able to spawn any more entities until the existing entities are killed or move too far away.
     *
     * @param amount the number of entities
     */
    public void setAdditionalSimultaneousEntities(float amount);

    /**
     * 获取此刷怪笼可以从中选择奖励的 {@link LootTable} 列表及其关联的选择权重。
     * <p>
     * 原文：Gets a list of {@link LootTable}s this spawner can pick a reward from as well as their associated weight to be chosen.
     *
     * @return a map of loot tables and their associated weight, or an empty map if there are none
     */
    @NotNull
    public Map<LootTable, Integer> getPossibleRewards();

    /**
     * 将 {@link LootTable} 添加到此刷怪笼可以从中选择奖励的表列表中，并带有给定的权重。
     * <p>
     * 原文：Add a {@link LootTable} to the list of tables this spawner can pick a reward from with a given weight.
     *
     * @param table  the loot table
     * @param weight the weight, must be at least 1
     */
    public void addPossibleReward(@NotNull LootTable table, int weight);

    /**
     * 从该刷怪笼可以选择奖励的表列表中移除指定的 {@link LootTable}。
     * <p>
     * 原文：Removes the provided {@link LootTable} from the list of tables this spawner can pick a reward from.
     *
     * @param table the loot table
     */
    public void removePossibleReward(@NotNull LootTable table);

    /**
     * 设置此刷怪笼可以选择奖励的 {@link LootTable} 列表及其权重。<br>
     * 映射中的所有战利品表必须非空，且所有权重必须至少为 1。
     * <p>
     * 原文：Sets the list of {@link LootTable}s and their weights this spawner can pick a reward from. All loot tables in the map must be non-null and all weights must be at least 1.
     *
     * @param rewards a map of loot tables and their weights, or null to clear all possible tables
     */
    public void setPossibleRewards(@NotNull Map<LootTable, Integer> rewards);
}