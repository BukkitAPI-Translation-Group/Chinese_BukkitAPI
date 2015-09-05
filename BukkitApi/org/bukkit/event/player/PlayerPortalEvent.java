package org.bukkit.event.player;

import org.bukkit.Location;
import org.bukkit.TravelAgent;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * 玩家将要被传送门传送事件.
 * <p>
 * 其他实体可见{@link org.bukkit.event.entity.EntityPortalEvent}
 */
public class PlayerPortalEvent extends PlayerTeleportEvent {
    private static final HandlerList handlers = new HandlerList();
    protected boolean useTravelAgent = true;
    protected TravelAgent travelAgent;

    public PlayerPortalEvent(final Player player, final Location from, final Location to, final TravelAgent pta) {
        super(player, from, to);
        this.travelAgent = pta;
    }

    public PlayerPortalEvent(Player player, Location from, Location to, TravelAgent pta, TeleportCause cause) {
        super(player, from, to, cause);
        this.travelAgent = pta;
    }

    /**
     * 是否存在另一端传送门. <p>
     * 原文:Sets whether or not the Travel Agent will be used.
     * <p>
     * 如果设置为true,传送门将试图找到与这个传送门相对的另一个传送门{@link #getTo()}，如果没有则创建一个. <p>
     * 原文:If this is set to true, the TravelAgent will try to find a Portal at
     * the {@link #getTo()} Location, and will try to create one if there is
     * none.
     * <p>
     * 如果设置为false,{@link #getPlayer()}只会被传送到{@link #getTo()}位置. <p>
     * 原文:If this is set to false, the {@link #getPlayer()} will only be
     * teleported to the {@link #getTo()} Location.
     *
     * @param useTravelAgent 是否使用另一端传送门true/false
     */
    public void useTravelAgent(boolean useTravelAgent) {
        this.useTravelAgent = useTravelAgent;
    }

    /**
     * 传送门是否被使用. <p>
     * 原文:Gets whether or not the Travel Agent will be used.
     * <p>
     * 如果设置为true,传送门将试图找到与这个传送门相对的另一个传送门{@link #getTo()}，如果没有则创建一个. <p>
     * 原文:If this is set to true, the TravelAgent will try to find a Portal at
     * the {@link #getTo()} Location, and will try to create one if there is
     * none.
     * <p>
     * 如果设置为false,{@link #getPlayer()}只会被传送到{@link #getTo()}位置. <p>
     * 原文:If this is set to false, the {@link #getPlayer()}} will only be
     * teleported to the {@link #getTo()} Location.
     *
     * @return 传送门是否被使用
     */
    public boolean useTravelAgent() {
        return useTravelAgent && travelAgent != null;
    }

    /**
     * 获得此事件中传送门是否正在被使用. <p>
     * 原文:Gets the Travel Agent used (or not) in this event.
     *
     * @return 传送门是否在被使用
     */
    public TravelAgent getPortalTravelAgent() {
        return this.travelAgent;
    }

    /**
     * 设置此事件中的传送门使用状态. <p>
     * 原文:Sets the Travel Agent used (or not) in this event.
     *
     * @param 传送门使用状态
     */
    public void setPortalTravelAgent(TravelAgent travelAgent) {
        this.travelAgent = travelAgent;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}