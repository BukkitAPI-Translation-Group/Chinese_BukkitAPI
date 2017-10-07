package org.bukkit.event.vehicle;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 载具被伤害的事件
 */
public class VehicleDamageEvent extends VehicleEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Entity attacker;
    private double damage;
    private boolean cancelled;

    public VehicleDamageEvent(final Vehicle vehicle, final Entity attacker, final double damage) {
        super(vehicle);
        this.attacker = attacker;
        this.damage = damage;
    }

    /**
     * 获取攻击这个载具的实体.
     * <p>
     * 原文:Gets the Entity that is attacking the vehicle
     *
     * @return 攻击这个载具的实体
     */
    public Entity getAttacker() {
        return attacker;
    }

    /**
     * 获取载具受到的伤害.
     * <p>
     * 原文:Gets the damage done to the vehicle
     *
     * @return 载具受到的伤害
     */
    public double getDamage() {
        return damage;
    }

    /**
     * 设置载具受到的伤害.
     * <p>
     * 原文:Sets the damage done to the vehicle
     *
     * @param damage 载具受到的伤害
     */
    public void setDamage(double damage) {
        this.damage = damage;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}