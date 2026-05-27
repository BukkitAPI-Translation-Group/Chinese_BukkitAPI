package org.bukkit.util;

import org.bukkit.entity.Entity;
import org.bukkit.generator.LimitedRegion;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * EntityTransformer 用于修改由结构生成的实体。
 */
@FunctionalInterface
@ApiStatus.Experimental
public interface EntityTransformer {

    /**
     * 转换结构中的实体。
     * <p>
     * 原文：
     * Transforms a entity in a structure.
     *
     * @param region 可访问区域
     * @param x 实体的 x 坐标
     * @param y 实体的 y 坐标
     * @param z 实体的 z 坐标
     * @param entity 实体
     * @param allowedToSpawn 实体是否被允许生成
     *
     * @return {@code true} 如果实体应该生成，否则 {@code false}
     */
    boolean transform(@NotNull LimitedRegion region, int x, int y, int z, @NotNull Entity entity, boolean allowedToSpawn);
}
