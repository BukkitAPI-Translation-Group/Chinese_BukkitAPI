package org.bukkit.loot;

import org.jetbrains.annotations.Nullable;

/**
 * 表示一个可以拥有战利品表的 {@link org.bukkit.block.Container} 或 {@link org.bukkit.entity.Mob}。
 * <br>
 * 容器的战利品只会在打开时生成，而且仅在容器<i>首次</i>打开时生成。
 * <br>
 * 实体只会在死亡时生成战利品。
 */
public interface Lootable {

    /**
     * 为容器或实体设置战利品表。
     * <br>
     * 要移除战利品表请使用 null。
     * <p>
     * 原文：
     * Set the loot table for a container or entity.
     * <br>
     * To remove a loot table use null.
     *
     * @param table 此 {@link org.bukkit.block.Container} 或 {@link org.bukkit.entity.Mob} 将拥有的战利品表。
     */
    void setLootTable(@Nullable LootTable table);

    /**
     * 获取附加到此方块或实体的战利品表。
     * <br>
     * 如果方块/实体没有战利品表，则返回 null，而不是空的战利品表。
     * <p>
     * 原文：
     * Gets the Loot Table attached to this block or entity.
     * <br>
     *
     * If an block/entity does not have a loot table, this will return null, NOT
     * an empty loot table.
     *
     * @return 附加到此方块或实体的战利品表。
     */
    @Nullable
    LootTable getLootTable();

    /**
     * 设置此战利品表生成战利品时使用的种子。
     * <p>
     * 原文：
     * Set the seed used when this Loot Table generates loot.
     *
     * @param seed 用于生成战利品的种子。默认为 0。
     */
    void setSeed(long seed);

    /**
     * 获取战利品表的种子。
     * <br>
     * 种子用于生成战利品。
     * <p>
     * 原文：
     * Get the Loot Table's seed.
     * <br>
     * The seed is used when generating loot.
     *
     * @return 种子
     */
    long getSeed();
}
