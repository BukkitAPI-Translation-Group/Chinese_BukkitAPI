package org.bukkit.event.player;

import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * 玩家重生事件.
 */
public class PlayerRespawnEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private Location respawnLocation;
    private final boolean isBedSpawn;

    public PlayerRespawnEvent(final Player respawnPlayer, final Location respawnLocation, final boolean isBedSpawn) {
        super(respawnPlayer);
        this.respawnLocation = respawnLocation;
        this.isBedSpawn = isBedSpawn;
    }

    /**
     * 获取当前重生的位置.
     * <p>
     * 原文:Gets the current respawn location
     *
     * @return 玩家重生位置
     */
    public Location getRespawnLocation() {
        return this.respawnLocation;
    }

    /**
     * 设置一个新的重生位置.
     * <p>
     * 原文:Sets the new respawn location
     *
     * @param location 新的重生位置
     */
    public void setRespawnLocation(Location respawnLocation) {
        Validate.notNull(respawnLocation, "Respawn location can not be null");
        Validate.notNull(respawnLocation.getWorld(), "Respawn world can not be null");

        this.respawnLocation = respawnLocation;
    }

    /**
     * 获取此玩家是否在他的床上重生.
     * <p>
     * 原文:Gets whether the respawn location is the player's bed.
     *
     * @return 玩家是否重生在床上
     */
    public boolean isBedSpawn() {
        return this.isBedSpawn;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}