package org.bukkit.event.entity;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当实体使用鞘翅滑翔状态被切换时发送。
 * 此事件被调用的示例：
 * <ul>
 *     <li>玩家在空中使用鞘翅时按下跳跃键</li>
 *     <li>玩家在滑翔时（使用鞘翅）落地</li>
 * </ul>
 * 这可以通过玩家变为水平姿势的动画来直观估计。
 */
public class EntityToggleGlideEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    private boolean cancel = false;
    private final boolean isGliding;

    public EntityToggleGlideEvent(@NotNull LivingEntity who, final boolean isGliding) {
        super(who);
        this.isGliding = isGliding;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 如果实体现在正在滑翔则返回 true，如果实体停止滑翔则返回 false。
     * <p>
     * 原文：
     * Returns true if the entity is now gliding or
     * false if the entity stops gliding.
     *
     * @return 新的滑翔状态
     */
    public boolean isGliding() {
        return isGliding;
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

}
