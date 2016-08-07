package org.bukkit.event.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * 玩家传送事件.
 */
public class PlayerTeleportEvent extends PlayerMoveEvent {
    private static final HandlerList handlers = new HandlerList();
    private TeleportCause cause = TeleportCause.UNKNOWN;

    public PlayerTeleportEvent(final Player player, final Location from, final Location to) {
        super(player, from, to);
    }

    public PlayerTeleportEvent(final Player player, final Location from, final Location to, final TeleportCause cause) {
        this(player, from, to);

        this.cause = cause;
    }

    /**
     * 获得此次传送的传送理由.
     * <p>
     * 原文:Gets the cause of this teleportation event
     *
     * @return 传送理由
     */
    public TeleportCause getCause() {
        return cause;
    }

    public enum TeleportCause {
        /**
         * 玩家抛出末影珍珠传送
         */
        ENDER_PEARL,
        /**
         * 由命令进行传送.
         */
        COMMAND,
        /**
         * 由插件进行传送.
         */
        PLUGIN,
        /**
         * 由地狱传送门进行传送.
         */
        NETHER_PORTAL,
        /**
         * 由末地传送门进行传送.
         */
        END_PORTAL,
        /**
         * 由旁观者菜单传送到一个实体/玩家.
         */
        SPECTATE,
        /**
         * 由末地折跃门进行传送.
         */
        END_GATEWAY,
        /**
         * 由紫影果进行传送.
         */
        CHORUS_FRUIT,
        /**
         * 由除已知枚举外的其他情况进行了传送.
         */
        UNKNOWN;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
