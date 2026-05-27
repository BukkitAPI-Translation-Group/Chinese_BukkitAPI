package org.bukkit.entity;

import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一个铜傀儡实体。
 *
 * 注意，傀儡的天线由 {@link EquipmentSlot#SADDLE} 控制。
 */
public interface CopperGolem extends Golem {

    /**
     * 获取傀儡进入下一个氧化阶段的下一个刻。
     *
     * @return 下一个氧化刻
     * <p>原文：Gets the next tick at which the golem will progress to the next weather state.
     */
    long getNextWeatheringTick();

    /**
     * 设置傀儡进入下一个氧化阶段的刻。
     *
     * @param tick 新的氧化刻
     * <p>原文：Sets the tick at which the golem will progress to the next weather state.
     */
    void setNextWeatheringTick(long tick);

    /**
     * 获取傀儡当前的氧化状态。
     *
     * @return 当前的氧化状态
     * <p>原文：Gets the golem's current weather state.
     */
    @NotNull
    CopperWeatherState getWeatherState();

    /**
     * 设置傀儡当前的氧化状态。
     *
     * @param state 新的状态
     * <p>原文：Sets the golem's current wheather state
     */
    void setWeatherState(@NotNull CopperWeatherState state);

    /**
     * 代表铜的氧化状态。
     */
    public enum CopperWeatherState {

        /**
         * 未氧化。
         */
        UNAFFECTED,
        /**
         * 轻度氧化。
         */
        EXPOSED,
        /**
         * 中度氧化。
         */
        WEATHERED,
        /**
         * 完全氧化。
         */
        OXIDIZED;
    }
}
