package org.bukkit.inventory.view;

import org.bukkit.inventory.BrewerInventory;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

/**
 * 一个提供与酿造台视图数据相关额外方法的 {@link InventoryView} 实例。
 */
public interface BrewingStandView extends InventoryView {

    @NotNull
    @Override
    BrewerInventory getTopInventory();

    /**
     * 获取此酿造台的燃料等级。
     * <p>
     * Minecraft中默认最大燃料等级为20。
     *
     * @return 剩余的燃料等级数量
     * <p>
     * 原文：Gets the fuel level of this brewing stand.
     * <p>
     * The default maximum fuel level in minecraft is 20.
     *
     * @return The amount of fuel level left
     */
    int getFuelLevel();

    /**
     * 获取剩余的酿造刻数。
     *
     * @return 酿造任务剩余的刻数
     * <p>
     * 原文：Gets the amount of brewing ticks left.
     *
     * @return The amount of ticks left for the brewing task
     */
    int getBrewingTicks();

    /**
     * 设置剩余的燃料等级。
     *
     * @param level 燃料等级，不得小于0
     * @throws IllegalArgumentException 如果等级小于0
     * <p>
     * 原文：Sets the fuel level left.
     *
     * @param level the level of the fuel, which is no less than 0
     * @throws IllegalArgumentException if the level is less than 0
     */
    void setFuelLevel(final int level) throws IllegalArgumentException;

    /**
     * 设置剩余的酿造刻数。
     *
     * @param ticks 剩余的刻数，不得小于0
     * @throws IllegalArgumentException 如果刻数小于0
     * <p>
     * 原文：Sets the brewing ticks left.
     *
     * @param ticks the ticks left, which is no less than 0
     * @throws IllegalArgumentException if the ticks are less than 0
     */
    void setBrewingTicks(final int ticks) throws IllegalArgumentException;
}
