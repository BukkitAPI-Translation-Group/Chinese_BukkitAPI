package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

/**
 * 方块搭建成实体时调用本事件.
 * <p>
 * 举个例子:
 * <ul>
 * <li>用雪块、南瓜搭建成一个雪傀儡时.
 * <li>用铁块、南瓜搭建成一个铁傀儡时.
 * </ul>
 */
public class EntityBlockFormEvent extends BlockFormEvent {
    private final Entity entity;

    public EntityBlockFormEvent(final Entity entity, final Block block, final BlockState blockstate) {
        super(block, blockstate);

        this.entity = entity;
    }

    /**
     * 获取被建造的实体.
     * <p>
     * 原文：Get the entity that formed the block.
     *
     * @return 这个事件的实体
     */
    public Entity getEntity() {
        return entity;
    }
}