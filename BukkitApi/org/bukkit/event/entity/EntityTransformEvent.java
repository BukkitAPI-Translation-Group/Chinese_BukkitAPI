package org.bukkit.event.entity;

import java.util.Collections;
import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当实体将转化/蜕变为其它实体时触发本事件.
 */
public class EntityTransformEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Entity converted;
    private final List<Entity> convertedList;
    private final TransformReason transformReason;

    public EntityTransformEvent(@NotNull Entity original, @NotNull List<Entity> convertedList, @NotNull TransformReason transformReason) {
        super(original);
        this.convertedList = Collections.unmodifiableList(convertedList);
        this.converted = convertedList.get(0);
        this.transformReason = transformReason;
    }

    /**
     * 获取原实体将转变成的实体.
     *
     * 将返回实体转化列表中的第一个实体.
     * <p>
     * 原文:
     * Gets the entity that the original entity was transformed to.
     *
     * This returns the first entity in the transformed entity list.
     *
     * @return 转变成的实体
     * @see #getTransformedEntities()
     */
    @NotNull
    public Entity getTransformedEntity() {
        return converted;
    }

    /**
     * 获取原实体将转变成的实体.
     * <p>
     * 原文:
     * Gets the entities that the original entity was transformed to.
     *
     * @return 实体转化列表
     */
    @NotNull
    public List<Entity> getTransformedEntities() {
        return convertedList;
    }

    /**
     * 获取发生此次转化的原因.
     * <p>
     * 原文:
     * Gets the reason for the conversion that has occurred.
     *
     * @return 发生此次转化的原因
     */
    @NotNull
    public TransformReason getTransformReason() {
        return transformReason;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }

    public enum TransformReason {
        /**
         * 僵尸受到疗愈, 变为村民.
         */
        CURED,
        /**
         * 实体在细雪中发抖, 转化为新实体.
         */
        FROZEN,
        /**
         * 村民受到感染, 变为僵尸.
         */
        INFECTION,
        /**
         * 实体在水中溺亡, 转化为新实体.
         */
        DROWNED,
        /**
         * 哞菇的毛被修剪, 变成普通牛.
         */
        SHEARED,
        /**
         * 雷击中了某个实体.
         */
        LIGHTNING,
        /**
         * 史莱姆分裂成多个小史莱姆.
         */
        SPLIT,
        /**
         * 猪灵转化为僵尸猪灵.
         */
        PIGLIN_ZOMBIFIED,
        /**
         * 未知原因.
         */
        UNKNOWN
    }
}
