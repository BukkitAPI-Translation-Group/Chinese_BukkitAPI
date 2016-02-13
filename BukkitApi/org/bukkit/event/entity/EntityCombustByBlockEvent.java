package org.bukkit.event.entity;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;

/**
 * 当方块造成实体燃烧时触发该事件.
 * 原文
 * Called when a block causes an entity to combust.
 */
public class EntityCombustByBlockEvent extends EntityCombustEvent {
    private final Block combuster;

    public EntityCombustByBlockEvent(final Block combuster, final Entity combustee, final int duration) {
        super(combustee, duration);
        this.combuster = combuster;
    }

    /**
     * 造成燃烧的可以是岩浆或者一个着火的方块.
     * <p>
     * 警告: 这个方块可能为null.
     * 
     * @return 使实体燃烧的方块
     * 原文:
     * The combuster can be lava or a block that is on fire.
     * <p>
     * WARNING: block may be null.
     *
     * @return the Block that set the combustee alight.
     */
    public Block getCombuster() {
        return combuster;
    }
}
