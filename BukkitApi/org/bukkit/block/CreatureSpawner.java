package org.bukkit.block;

import org.bukkit.entity.EntityType;

/**
 * 代表一个刷怪笼.
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
     * <p>
     * 原文:
     * Get the spawner's delay.
     *
     * @return 这个延迟.
     */
    public int getDelay();

    /**
     * 设置刷怪笼刷怪延迟.
     * <p>
     * 原文:
     * Set the spawner's delay.
     *
     * @param delay 这个延迟.
     */
    public void setDelay(int delay);
}
