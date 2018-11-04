package org.bukkit.event.entity;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

/**
 * 当{@link Entity 实体}破坏门时触发本事件.
 * <p>
 * 取消该事件将导致该事件被延迟.
 */
public class EntityBreakDoorEvent extends EntityChangeBlockEvent {
    public EntityBreakDoorEvent(final LivingEntity entity, final Block targetBlock) {
        super(entity, targetBlock, Material.AIR.createBlockData());
    }

    @Override
    public LivingEntity getEntity() {
        return (LivingEntity) entity;
    }
}