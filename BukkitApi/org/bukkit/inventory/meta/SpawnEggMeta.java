package org.bukkit.inventory.meta;

import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * 代表刷怪蛋和它刷出的实体的类型.
 */
public interface SpawnEggMeta extends ItemMeta {

    /**
     * 获取刷怪蛋生成的实体的类型.
     * <p>
     * 原文:
     * Get the type of entity this egg will spawn.
     *
     * @return 实体类型. 根据实现指定的默认值, 可能为 null
     * @deprecated 不同实体类型对应不同的刷怪蛋物品
     */
    @Deprecated
    @Contract("-> fail")
    EntityType getSpawnedType();

    /**
     * 设置刷怪蛋生成的实体的类型.
     * <p>
     * 原文:
     * Set the type of entity this egg will spawn.
     *
     * @param type 实体类型. 根据实现指定的默认值, 可能为 null
     * @deprecated 不同实体类型对应不同的刷怪蛋物品
     */
    @Deprecated
    @Contract("_ -> fail")
    void setSpawnedType(EntityType type);

    @NotNull
    @Override
    SpawnEggMeta clone();
}
