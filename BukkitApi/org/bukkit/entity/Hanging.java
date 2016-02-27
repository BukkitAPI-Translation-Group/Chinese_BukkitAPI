package org.bukkit.entity;

import org.bukkit.block.BlockFace;
import org.bukkit.material.Attachable;

/**
 * 代表悬挂实体。
 * <p>
 * 译注：什么是悬挂实体？比如画，它属于实体，而且可以悬挂，那么我们就称那些实体为悬挂实体。
 */
public interface Hanging extends Entity, Attachable {

    /**
     * 设置悬挂实体的方向，这可能会重写所有规则。注意：如果结果是无效对象，该对象会作为一个物品而掉落.
     * <p>
     * 原文：Sets the direction of the hanging entity, potentially overriding rules
     * of placement. Note that if the result is not valid the object would
     * normally drop as an item.
     *
     * @param face 新的方向
     * @param force 是否强制
     * @return 如果强制执行失败或者那里没有方块附着给定的方向则为false
     */
    public boolean setFacingDirection(BlockFace face, boolean force);
}