package org.bukkit.event.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 玩家剪羊毛时调用此事件.
 */
public class PlayerShearEntityEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;
    private final Entity what;

    public PlayerShearEntityEvent(final Player who, final Entity what) {
        super(who);
        this.cancel = false;
        this.what = what;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 获得正在被玩家剪羊毛的实体对象.
     * <p>
     * 原文:Gets the entity the player is shearing
     *
     * @return 被剪实体
     */
    public Entity getEntity() {
        return what;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
