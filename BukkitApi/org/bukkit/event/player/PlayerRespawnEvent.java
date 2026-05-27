package org.bukkit.event.player;

import com.google.common.base.Preconditions;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 玩家重生事件.
 */
public class PlayerRespawnEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private Location respawnLocation;
    private final boolean isBedSpawn;
    private final boolean isAnchorSpawn;
    private final RespawnReason respawnReason;

    @Deprecated(since = "1.16.1")
    public PlayerRespawnEvent(@NotNull final Player respawnPlayer, @NotNull final Location respawnLocation, final boolean isBedSpawn) {
        this(respawnPlayer, respawnLocation, isBedSpawn, false);
    }

    @Deprecated(since = "1.19.4")
    public PlayerRespawnEvent(@NotNull final Player respawnPlayer, @NotNull final Location respawnLocation, final boolean isBedSpawn, final boolean isAnchorSpawn) {
        this(respawnPlayer, respawnLocation, isBedSpawn, false, RespawnReason.PLUGIN);
    }

    public PlayerRespawnEvent(@NotNull final Player respawnPlayer, @NotNull final Location respawnLocation, final boolean isBedSpawn, final boolean isAnchorSpawn, @NotNull final RespawnReason respawnReason) {
        super(respawnPlayer);
        this.respawnLocation = respawnLocation;
        this.isBedSpawn = isBedSpawn;
        this.isAnchorSpawn = isAnchorSpawn;
        this.respawnReason = respawnReason;
    }

    /**
     * 获取当前重生的位置.
     * <p>
     * 原文:Gets the current respawn location
     *
     * @return 玩家重生位置
     */
    @NotNull
    public Location getRespawnLocation() {
        return this.respawnLocation;
    }

    /**
     * 设置一个新的重生位置.
     * <p>
     * 原文:Sets the new respawn location
     *
     * @param respawnLocation 新的重生位置
     */
    public void setRespawnLocation(@NotNull Location respawnLocation) {
        Preconditions.checkArgument(respawnLocation != null, "Respawn location can not be null");
        Preconditions.checkArgument(respawnLocation.getWorld() != null, "Respawn world can not be null");

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

    /**
     * 获取重生位置是否为玩家的重生锚.
     * <p>
     * 原文:
     * Gets whether the respawn location is the player's respawn anchor.
     *
     * @return 如果重生位置是玩家的重生锚则返回true
     */
    public boolean isAnchorSpawn() {
        return isAnchorSpawn;
    }

    /**
     * 获取此重生事件被触发的原因.
     * <p>
     * 原文:
     * Gets the reason this respawn event was called.
     *
     * @return 事件被触发的原因
     */
    @NotNull
    public RespawnReason getRespawnReason() {
        return respawnReason;
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

    /**
     * 用于指定重生事件被触发原因的枚举.
     */
    public enum RespawnReason {

        /**
         * 当玩家死亡并按下重生按钮时.
         */
        DEATH,
        /**
         * 当玩家通过末地传送门离开末地时.
         */
        END_PORTAL,
        /**
         * 当插件使玩家重生时.
         */
        PLUGIN;
    }
}