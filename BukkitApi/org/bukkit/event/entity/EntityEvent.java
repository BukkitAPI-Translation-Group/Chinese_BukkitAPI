package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

/**
 * 代表实体相关事件.
 */
public abstract class EntityEvent extends Event {
    protected Entity entity;

    public EntityEvent(@NotNull final Entity what) {
        entity = what;
    }

    /**
     * 返回这个事件所涉及的实体.
     * <p>
     * 原文: Returns the Entity involved in this event
     * @return 涉及这个事件的实体
     */
    @NotNull
    public Entity getEntity() {
        return entity;
    }

    /**
     * 获取涉及这个事件的实体的EntityType.
     * <p>
     * 原文：Gets the EntityType of the Entity involved in this event.
     *
     * @return 涉及这个事件的实体的EntityType
     */
    @NotNull
    public EntityType getEntityType() {
        return entity.getType();
    }
}