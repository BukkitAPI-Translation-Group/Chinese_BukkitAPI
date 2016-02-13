package org.bukkit.event.entity;

import org.bukkit.Location;
import org.bukkit.TravelAgent;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;

/**
 * 当一个非玩家的实体被传送门传送时触发本事件
 * <p>
 * 对于玩家请看 {@link org.bukkit.event.player.PlayerPortalEvent}
 * 原文:
 * Called when a non-player entity is about to teleport because it is in
 * contact with a portal.
 * <p>
 * For players see {@link org.bukkit.event.player.PlayerPortalEvent}
 */
public class EntityPortalEvent extends EntityTeleportEvent {
    private static final HandlerList handlers = new HandlerList();
    protected boolean useTravelAgent = true;
    protected TravelAgent travelAgent;

    public EntityPortalEvent(final Entity entity, final Location from, final Location to, final TravelAgent pta) {
        super(entity, from, to);
        this.travelAgent = pta;
    }

    /**
     * 设置Travel Agent是否启用
     * <p>
     * 如果此项别设置为true,TravelAgent将尝试寻找一个{@link #getTo()}位置附近的一个传送门
     * 若没有传送门将尝试创建一个传送门.
     * <p>
     * 如果此项被设为false, {@link #getEntity()} 将只能被传送到 {@link #getTo()}.
     * @param useTravelAgent Travel Agent是否启用
     * 原文:
     * Sets whether or not the Travel Agent will be used.
     * <p>
     * If this is set to true, the TravelAgent will try to find a Portal at
     * the {@link #getTo()} Location, and will try to create one if there is
     * none.
     * <p>
     * If this is set to false, the {@link #getEntity()} will only be
     * teleported to the {@link #getTo()} Location.
     *
     * @param useTravelAgent whether to use the Travel Agent
     */
    public void useTravelAgent(boolean useTravelAgent) {
        this.useTravelAgent = useTravelAgent;
    }

    /**
     * 返回Travel Agent是否启用
     * <p>
     * 如果此项别设置为true,TravelAgent将尝试寻找一个{@link #getTo()}位置附近的一个传送门
     * 若没有传送门将尝试创建一个传送门.
     * <p>
     * 如果此项被设为false, {@link #getEntity()} 将只能被传送到 {@link #getTo()}.
     * 
     * @return 是否启用Travel Agent
     * 原文:
     * Gets whether or not the Travel Agent will be used.
     * <p>
     * If this is set to true, the TravelAgent will try to find a Portal at
     * the {@link #getTo()} Location, and will try to create one if there is
     * none.
     * <p>
     * If this is set to false, the {@link #getEntity()} will only be
     * teleported to the {@link #getTo()} Location.
     *
     * @return whether to use the Travel Agent
     */
    public boolean useTravelAgent() {
        return useTravelAgent;
    }

    /**
     * 返回Travel Agent使用(或不使用)于本次事件.
     * 
     * @return Travel Agent使用(或不使用)于本次事件
     * 原文:
     * Gets the Travel Agent used (or not) in this event.
     *
     * @return the Travel Agent used (or not) in this event
     */
    public TravelAgent getPortalTravelAgent() {
        return this.travelAgent;
    }

    /**
     * 设置 Travel Agent使用(或不使用)于本次事件.
     * 
     * @param travelAgent 使用(或不使用)于本次事件.
     * 原文:
     * Sets the Travel Agent used (or not) in this event.
     *
     * @param travelAgent the Travel Agent used (or not) in this event
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