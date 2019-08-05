package org.bukkit.block;

import org.bukkit.inventory.BrewerInventory;
import org.jetbrains.annotations.NotNull;

/**
 * 代表酿造台(快照).
 */
public interface BrewingStand extends Container {

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

    /**
     * 获取酿造台当前剩余的燃料.
     * <p>
     * 原文：Get the level of current fuel for brewing.
     *
     * @return 酿造台当前剩余的燃料
     */
    int getFuelLevel();

    /** 
     * 设置酿造台当前剩余的燃料.
     * <p>
     * 原文：Set the level of current fuel for brewing.
     *
     * @param level 酿造台当前剩余的燃料
     */
    void setFuelLevel(int level);

    @NotNull
    @Override
    BrewerInventory getInventory();

    @NotNull
    @Override
    BrewerInventory getSnapshotInventory();
}