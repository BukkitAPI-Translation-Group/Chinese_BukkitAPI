package org.bukkit.event.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.util.Vector;

/**
 * 当玩家在实体上点击某实体上的某位置时触发此事件.
 */
public class PlayerInteractAtEntityEvent extends PlayerInteractEntityEvent {
    private static final HandlerList handlers = new HandlerList();
    private final Vector position;

    public PlayerInteractAtEntityEvent(Player who, Entity clickedEntity, Vector position) {
        super(who, clickedEntity);
        this.position = position;
    }
    
    public Vector getClickedPosition() {
        return position.clone();
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
