package org.bukkit.event.inventory;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 当一个 ItemStack 即将增加酿造台的燃料等级时调用。
 */
public class BrewingStandFuelEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final ItemStack fuel;
    private int fuelPower;
    private boolean cancelled;
    private boolean consuming = true;

    public BrewingStandFuelEvent(@NotNull Block brewingStand, @NotNull ItemStack fuel, int fuelPower) {
        super(brewingStand);
        this.fuel = fuel;
        this.fuelPower = fuelPower;
    }

    /**
     * 获取燃料的 ItemStack，在数量被扣除之前。
     *
     * @return 燃料的 ItemStack
     * <p>原文：Gets the ItemStack of the fuel before the amount was subtracted.
     */
    @NotNull
    public ItemStack getFuel() {
        return fuel;
    }

    /**
     * 获取此燃料的燃料能量。每单位能量可以为一次酿造操作提供燃料。
     *
     * @return 此燃料的燃料能量
     * <p>原文：Gets the fuel power for this fuel. Each unit of power can fuel one
     * brewing operation.
     */
    public int getFuelPower() {
        return fuelPower;
    }

    /**
     * 设置此燃料的燃料能量。每单位能量可以为一次酿造操作提供燃料。
     *
     * @param fuelPower 此燃料的燃料能量
     * <p>原文：Sets the fuel power for this fuel. Each unit of power can fuel one
     * brewing operation.
     */
    public void setFuelPower(int fuelPower) {
        this.fuelPower = fuelPower;
    }

    /**
     * 获取酿造台的燃料是否会被减少/消耗。
     *
     * @return 燃料是否会被减少
     * <p>原文：Gets whether the brewing stand's fuel will be reduced / consumed or not.
     */
    public boolean isConsuming() {
        return consuming;
    }

    /**
     * 设置酿造台的燃料是否会被减少/消耗。
     *
     * @param consuming 燃料是否会被减少
     * <p>原文：Sets whether the brewing stand's fuel will be reduced / consumed or not.
     */
    public void setConsuming(boolean consuming) {
        this.consuming = consuming;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
