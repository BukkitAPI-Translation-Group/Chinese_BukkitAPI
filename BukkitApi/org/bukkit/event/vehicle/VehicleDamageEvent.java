package org.bukkit.event.vehicle;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.util.NumberConversions;

/**
 * 载具被伤害的事件
 */
public class VehicleDamageEvent extends VehicleEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Entity attacker;
    private double damage;
    private boolean cancelled;

    @Deprecated
    public VehicleDamageEvent(final Vehicle vehicle, final Entity attacker, final int damage) {
        this(vehicle, attacker, (double) damage);
    }

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
     * 这个方法存在的原因是为了向后兼容。它不会在运行时存在，并且不应该在任何情况下使用。
     * <p>
     * 原文：This method exists for legacy reasons to provide backwards
     * compatibility. It will not exist at runtime and should not be used
     * under any circumstances.
     * 
     * @return 载具受到的伤害
     */
    @Deprecated
    public int _INVALID_getDamage() {
        return NumberConversions.ceil(getDamage());
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

    /**
     * 这个方法存在的原因是为了向后兼容。它不会在运行时存在，并且不应该在任何情况下使用。
     * <p>
     * 原文：This method exists for legacy reasons to provide backwards
     * compatibility. It will not exist at runtime and should not be used
     * under any circumstances.
     * 
     * @param damage 载具受到的伤害
     */
    @Deprecated
    public void _INVALID_setDamage(int damage) {
        setDamage(damage);
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