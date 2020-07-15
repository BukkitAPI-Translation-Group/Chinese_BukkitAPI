package org.spigotmc.event.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家加入服务器后, 准备在某世界出生时触发本事件.
 */
public class PlayerSpawnLocationEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private Location spawnLocation;

    public PlayerSpawnLocationEvent(@NotNull final Player who, @NotNull Location spawnLocation) {
        super(who);
        this.spawnLocation = spawnLocation;
    }


    /**
     * 获取玩家的出生点.
     * 如果此玩家曾在此服务器游戏过({@link Player#hasPlayedBefore()}), 本位置将默认为player.dat文件中的值.
     * 对于新玩家, 默认的出生点为主世界的出生点.
     * <p>
     * 原文:Gets player's spawn location.
     * If the player {@link Player#hasPlayedBefore()}, it's going to default to the location inside player.dat file.
     * For new players, the default spawn location is spawn of the main Bukkit world.
     *
     * @return 出生点
     */
    @NotNull
    public Location getSpawnLocation() {
        return spawnLocation;
    }

    /**
     * 设置玩家的出生点 (仅在本事件中生效).
     * <p>
     * 原文:Sets player's spawn location.
     *
     * @param location 出生点
     */
    public void setSpawnLocation(@NotNull Location location) {
        this.spawnLocation = location;
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
