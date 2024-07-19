package org.bukkit.block;

import org.bukkit.spawner.Spawner;
import org.jetbrains.annotations.Nullable;

/**
 * 代表刷怪笼.
 */
public interface CreatureSpawner extends TileState, Spawner {

    /**
     * 设置刷怪笼要生成的生物名.
     * <p>
     * 原文:
     * Set the spawner mob type.
     *
     * @param creatureType 要刷出的生物的名称, 设为 null 清除类型.
     * @deprecated 不安全的参数，请使用
     * {@link #setSpawnedType(org.bukkit.entity.EntityType)}.
     */
    @Deprecated
    public void setCreatureTypeByName(@Nullable String creatureType);

    /**
     * 获取要刷出的生物的名称.
     * <p>
     * 原文:
     * Get the spawner's creature type.
     *
     * @return 要刷出的生物的名称(如已设置).
     * @deprecated 不安全的参数，请使用{@link #getSpawnedType()}.
     */
    @Deprecated
    @Nullable
    public String getCreatureTypeName();
}
