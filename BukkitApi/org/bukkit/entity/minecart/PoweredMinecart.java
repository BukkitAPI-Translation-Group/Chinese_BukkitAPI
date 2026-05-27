package org.bukkit.entity.minecart;

import org.bukkit.entity.Minecart;

/**
 * 代表动力矿车.当玩家往动力矿车里放{@link org.bukkit.Material#COAL 燃料}后它就会自己移动.
 */
public interface PoweredMinecart extends Minecart {

    /**
     * 获取矿车燃料耗尽前的剩余 tick 数.
     * <p>
     * 原文:Get the number of ticks until the minecart runs out of fuel.
     *
     * @return 矿车燃料耗尽前的剩余 tick 数
     */
    public int getFuel();

    /**
     * 设置矿车燃料耗尽前的剩余 tick 数.
     * <p>
     * 原文:Set the number of ticks until the minecart runs out of fuel.
     *
     * @param fuel 矿车燃料耗尽前的剩余 tick 数
     */
    public void setFuel(int fuel);
}