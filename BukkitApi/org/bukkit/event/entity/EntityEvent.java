package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;

/**
 * 实体相关事件.
 * 原文: Represents an Entity-related event
 */
public abstract class EntityEvent extends Event {
    protected Entity entity;

    public EntityEvent(final Entity what) {
        entity = what;
    }

    /**
     * 返回这个事件所涉及的实体.
     * 原文: Returns the Entity involved in this event
     * @return 涉及这个事件的实体
     * 原文: @return Entity who is involved in this event
     */
    public Entity getEntity() {
        return entity;
    }

    /**
     * Gets the EntityType of the Entity involved in this event.
     *
     * @return EntityType of the Entity involved in this event
     */
    public EntityType getEntityType() {
        return entity.getType();
    }
}