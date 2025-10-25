package org.bukkit.block.spawner;

import com.google.common.base.Preconditions;
import java.util.Map;
import org.bukkit.entity.EntitySnapshot;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.loot.LootTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示一个可以添加到怪物生成器的加权生成潜力。
 * 
 * 原文:Represents a weighted spawn potential that can be added to a monster spawner.
 */
public class SpawnerEntry {

    private EntitySnapshot snapshot;
    private int spawnWeight;
    private SpawnRule spawnRule;
    private Equipment equipment;

    public SpawnerEntry(@NotNull EntitySnapshot snapshot, int spawnWeight, @Nullable SpawnRule spawnRule) {
        this(snapshot, spawnWeight, spawnRule, null);
    }

    public SpawnerEntry(@NotNull EntitySnapshot snapshot, int spawnWeight, @Nullable SpawnRule spawnRule, @Nullable Equipment equipment) {
        Preconditions.checkArgument(snapshot != null, "Snapshot cannot be null");

        this.snapshot = snapshot;
        this.spawnWeight = spawnWeight;
        this.spawnRule = spawnRule;
        this.equipment = equipment;
    }

    /**
     * 获取此SpawnerEntry的{@link EntitySnapshot}。
     * 
     * 原文:Gets the {@link EntitySnapshot} for this SpawnerEntry.
     *
     * @return 实体快照
     * 原文:the snapshot
     */
    @NotNull
    public EntitySnapshot getSnapshot() {
        return snapshot;
    }

    /**
     * 设置此SpawnerEntry的{@link EntitySnapshot}。
     * 
     * 原文:Sets the {@link EntitySnapshot} for this SpawnerEntry.
     *
     * @param snapshot 实体快照
     * 原文:the snapshot
     */
    public void setSnapshot(@NotNull EntitySnapshot snapshot) {
        Preconditions.checkArgument(snapshot != null, "Snapshot cannot be null");
        this.snapshot = snapshot;
    }

    /**
     * 获取此SpawnerEntry的权重，当添加到生成器时，权重较高的条目会更频繁地生成。
     * 
     * 原文:Gets the weight for this SpawnerEntry, when added to a spawner entries
     * with higher weight will spawn more often.
     *
     * @return 权重值
     * 原文:the weight
     */
    public int getSpawnWeight() {
        return spawnWeight;
    }

    /**
     * 设置此SpawnerEntry的权重，当添加到生成器时，权重较高的条目会更频繁地生成。
     * 
     * 原文:Sets the weight for this SpawnerEntry, when added to a spawner entries
     * with higher weight will spawn more often.
     *
     * @param spawnWeight 新的生成权重
     * 原文:the new spawn weight
     */
    public void setSpawnWeight(int spawnWeight) {
        this.spawnWeight = spawnWeight;
    }

    /**
     * 获取此SpawnerEntry的{@link SpawnRule}的副本，如果没有设置则返回null。
     * 
     * 原文:Gets a copy of the {@link SpawnRule} for this SpawnerEntry, or null if
     * none has been set.
     *
     * @return 生成规则的副本或null
     * 原文:a copy of the spawn rule or null
     */
    @Nullable
    public SpawnRule getSpawnRule() {
        return spawnRule == null ? null : spawnRule.clone();
    }

    /**
     * 设置此SpawnerEntry的{@link SpawnRule}，可以使用null来清除当前的生成规则。
     * 
     * 原文:Sets the {@link SpawnRule} for this SpawnerEntry, null may be used to
     * clear the current spawn rule.
     *
     * @param spawnRule 要使用的新生成规则或null
     * 原文:the new spawn rule to use or null
     */
    public void setSpawnRule(@Nullable SpawnRule spawnRule) {
        this.spawnRule = spawnRule;
    }

    /**
     * 获取将应用于生成实体的装备。
     * 
     * 原文:Gets the equipment which will be applied to the spawned entity.
     *
     * @return 装备，或null
     * 原文:the equipment, or null
     */
    @Nullable
    public Equipment getEquipment() {
        return equipment;
    }

    /**
     * 设置将应用于生成实体的装备。
     * 
     * 原文:Sets the equipment which will be applied to the spawned entity.
     *
     * @param equipment 新装备，或null
     * 原文:new equipment, or null
     */
    public void setEquipment(@Nullable Equipment equipment) {
        this.equipment = equipment;
    }

    /**
     * 表示应用于生成实体的装备战利品表。
     * 
     * 原文:Represents the equipment loot table applied to a spawned entity.
     */
    public static class Equipment {

        private LootTable equipmentLootTable;
        private final Map<EquipmentSlot, Float> dropChances;

        public Equipment(@NotNull LootTable equipmentLootTable, @NotNull Map<EquipmentSlot, Float> dropChances) {
            this.equipmentLootTable = equipmentLootTable;
            this.dropChances = dropChances;
        }

        /**
         * 设置实体的战利品表。
         * <br>
         * 要移除战利品表，使用null。
         * 
         * 原文:Set the loot table for the entity.
         * <br>
         * To remove a loot table use null.
         *
         * @param table 这个{@link org.bukkit.entity.Mob}将拥有的战利品表。
         * 原文:table this {@link org.bukkit.entity.Mob} will have.
         */
        public void setEquipmentLootTable(@NotNull LootTable table) {
            this.equipmentLootTable = table;
        }

        /**
         * 获取实体的战利品表。
         * <br>
         * 
         * 原文:Gets the loot table for the entity.
         * <br>
         * If an entity does not have a loot table, this will return null, NOT
         * an empty loot table.
         *
         * @return 这个实体的战利品表。
         * 原文:the loot table for this entity.
         */
        @NotNull
        public LootTable getEquipmentLootTable() {
            return this.equipmentLootTable;
        }

        /**
         * 获取实体每个槽位掉落概率的可变映射。
         * 如果非null，实体的掉落概率将被给定的值覆盖。
         * 
         * 原文:Gets a mutable map of the drop chances for each slot of the entity.
         * If non-null, the entity's drop chances will be overridden with the
         * given value.
         *
         * @return 掉落概率的可变映射
         * 原文:mutable map of drop chances
         */
        @NotNull
        public Map<EquipmentSlot, Float> getDropChances() {
            return this.dropChances;
        }
    }
}
