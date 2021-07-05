package org.bukkit.event.entity;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当实体生成于世界内时触发本事件.
 * <p>
 * 如果本事件被取消, 那么实体将不会生成.
 */
public class EntitySpawnEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean canceled;

    public EntitySpawnEvent(@NotNull final Entity spawnee) {
        super(spawnee);
    }

    @Override
    public boolean isCancelled() {
        return canceled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        canceled = cancel;
    }

    /**
     * 获取实体出生的位置.
     * <p>
     * 原文:Gets the location at which the entity is spawning.
     *
     * @return 实体出生的位置
     */
    @NotNull
    public Location getLocation() {
        return getEntity().getLocation();
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
