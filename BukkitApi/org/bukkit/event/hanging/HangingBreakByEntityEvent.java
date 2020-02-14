package org.bukkit.event.hanging;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Hanging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当一个悬挂实体被一个实体移除时调用本事件
 */
public class HangingBreakByEntityEvent extends HangingBreakEvent {
    private final Entity remover;

    public HangingBreakByEntityEvent(@NotNull final Hanging hanging, @Nullable final Entity remover) {
        this(hanging, remover, HangingBreakEvent.RemoveCause.ENTITY);
    }

    public HangingBreakByEntityEvent(@NotNull final Hanging hanging, @Nullable final Entity remover, @NotNull final HangingBreakEvent.RemoveCause cause) {
        super(hanging, cause);
        this.remover = remover;
    }

    /**
     * 获取移除这个悬挂实体的实体.
     * 可能为null, 比如当此实体被爆炸破坏时.
     * <p>
     * 原文:Gets the entity that removed the hanging entity.
     * May be null, for example when broken by an explosion.
     *
     * @return 移除这个悬挂实体的实体
     */
    @Nullable
    public Entity getRemover() {
        return remover;
    }
}