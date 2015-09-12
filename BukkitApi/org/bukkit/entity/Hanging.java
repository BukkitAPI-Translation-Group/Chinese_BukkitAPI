package org.bukkit.entity;

import org.bukkit.block.BlockFace;
import org.bukkit.material.Attachable;

/**
 * 代表悬挂实体。
 */
public interface Hanging extends Entity, Attachable {

    /**
     * 设置悬挂实体的方向，这可能会重写所有规则。
     * <p>
     * 原文：Sets the direction of the hanging entity, potentially overriding rules
     * of placement. Note that if the result is not valid the object would
     * normally drop as an item.
     *
     * @param face 新的方向
     * @param force 是否强制
     * @return False if force was false and there was no block for it to
     *     attach to in order to face the given direction.
     */
    public boolean setFacingDirection(BlockFace face, boolean force);
}