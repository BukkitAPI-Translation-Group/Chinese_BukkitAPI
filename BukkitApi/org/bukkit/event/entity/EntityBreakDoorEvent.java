package org.bukkit.event.entity;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

/**
 * 在 {@link Entity} 破坏门时触发
 * 原文: Called when an {@link Entity} breaks a door
 * <p>
 * 取消该事件将导致该事件被延迟
 * 原文: Cancelling the event will cause the event to be delayed
 */
public class EntityBreakDoorEvent extends EntityChangeBlockEvent {
    public EntityBreakDoorEvent(final LivingEntity entity, final Block targetBlock) {
        super(entity, targetBlock, Material.AIR, (byte) 0);
    }

    @Override
    public LivingEntity getEntity() {
        return (LivingEntity) entity;
    }
}