package org.bukkit.block;

import org.bukkit.inventory.BrewerInventory;

/**
 * 代表酿造台.
 */
public interface BrewingStand extends BlockState, ContainerBlock {

    /**
     * 返回酿造还需多长时间.
     * <p>
     * 原文：How much time is left in the brewing cycle
     *
     * @return 酿造时间
     */
    int getBrewingTime();

    /**
     * 设置酿造还需多长时间完成.
     * <p>
     * 原文：Set the time left before brewing completes.
     *
     * @param brewTime 酿造时间
     */
    void setBrewingTime(int brewTime);

    public BrewerInventory getInventory();
}