package org.bukkit.event.entity;

import java.util.List;

import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.HandlerList;

/**
 * 当滞留药水应用它的效果时触发本事件，期间每5 tick发生一次。
 */
public class AreaEffectCloudApplyEvent extends EntityEvent {
    private static final HandlerList handlers = new HandlerList();
    private final List<LivingEntity> affectedEntities;

    public AreaEffectCloudApplyEvent(final AreaEffectCloud entity, final List<LivingEntity> affectedEntities) {
        super(entity);
        this.affectedEntities = affectedEntities;
    }

    @Override
    public AreaEffectCloud getEntity() {
        return (AreaEffectCloud) entity;
    }

    /**
     * 获取一个受影响实体的可变列表。
     * <p>
     * 特别注意不是在列表里的每个实体都保证受影响。
     * 药水效果云可能由于{@link AreaEffectCloud#getDurationOnUse()}或{@link AreaEffectCloud#getRadiusOnUse()}的消耗死在应用过程中的影响
     * <p>
     * 原文:
     * Retrieves a mutable list of the effected entities
     * <p>
     * It is important to note that not every entity in this list
     * is guaranteed to be effected.  The cloud may die during the
     * application of its effects due to the depletion of {@link AreaEffectCloud#getDurationOnUse()}
     * or {@link AreaEffectCloud#getRadiusOnUse()}
     *
     * @return 受影响的实体列表
     */
    public List<LivingEntity> getAffectedEntities() {
        return affectedEntities;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}