package org.bukkit.block;

import java.util.List;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

/**
 * 代表可存储实体的方块 (译注:或者称为实体容器方块).
 *
 * @param <T> 本方块可存储的实体类型
 */
public interface EntityBlockStorage<T extends Entity> extends TileState {

    /**
     * 检测本实体容器是否已满.
     * <p>
     * 原文:Check if the block is completely full of entities.
     *
     * @return 是否存满实体
     */
    boolean isFull();

    /**
     * 获取已存储的实体的数量.
     * <p>
     * 原文:Get the amount of entities currently in this block.
     *
     * @return 当前存放的实体的数量
     */
    int getEntityCount();

    /**
     * 获取最大可存储的实体数.
     * <p>
     * 原文:Get the maximum amount of entities this block can hold.
     *
     * @return 最大可存储的实体数
     */
    int getMaxEntities();

    /**
     * 设置最大可存储的实体数.
     * <p>
     * 原文:Set the maximum amount of entities this block can hold.
     *
     * @param max 最大可存储的实体数
     */
    void setMaxEntities(int max);

    /**
     * 释放方块存储的所有实体.
     * <p>
     * 原文:Release all the entities currently stored in the block.
     *
     * @return 被释放的实体的列表
     */
    @NotNull
    List<T> releaseEntities();

    /**
     * 入驻一个实体至此方块.
     * <p>
     * 原文:Add an entity to the block.
     *
     * @param entity 要入驻的实体
     */
    void addEntity(@NotNull T entity);
}
