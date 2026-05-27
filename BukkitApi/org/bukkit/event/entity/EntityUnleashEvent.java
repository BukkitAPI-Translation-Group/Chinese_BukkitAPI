package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 在实体被解除拴绳之前立即调用。
 */
public class EntityUnleashEvent extends EntityEvent {
    private static final HandlerList handlers = new HandlerList();
    private final UnleashReason reason;

    public EntityUnleashEvent(@NotNull Entity entity, @NotNull UnleashReason reason) {
        super(entity);
        this.reason = reason;
    }

    /**
     * 返回解除拴绳的原因。
     * <p>
     * 原文：
     * Returns the reason for the unleashing.
     *
     * @return 原因
     */
    @NotNull
    public UnleashReason getReason() {
        return reason;
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

    public enum UnleashReason {
        /**
         * 当实体的拴绳持有者已死亡或登出，因此被解除拴绳。
         */
        HOLDER_GONE,
        /**
         * 当实体的拴绳持有者尝试解除其拴绳时。
         */
        PLAYER_UNLEASH,
        /**
         * 当实体的拴绳持有者距离超过 10 个方块时。
         */
        DISTANCE,
        /**
         * 拴绳被剪断。
         */
        SHEAR,
        /**
         * 使用了烟花火箭。
         */
        FIREWORK,
        UNKNOWN;
    }
}
