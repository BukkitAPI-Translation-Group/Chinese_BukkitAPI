package org.bukkit.entity.minecart;

import org.bukkit.entity.Minecart;

/**
 * 代表动力矿车.当玩家往动力矿车里放{@link org.bukkit.Material#COAL 燃料}后它就会自己移动.
 */
public interface PoweredMinecart extends Minecart {

    /**
     * Get the number of ticks until the minecart runs out of fuel.
     *
     * @return Number of ticks until the minecart runs out of fuel
     */
    public int getFuel();

    /**
     * Set the number of ticks until the minecart runs out of fuel.
     *
     * @param fuel Number of ticks until the minecart runs out of fuel
     */
    public void setFuel(int fuel);
}