package org.bukkit.block.data.type;

import org.bukkit.block.data.AnaloguePowerable;
import org.bukkit.block.data.Waterlogged;
import org.jetbrains.annotations.NotNull;

/**
 * 'sculk_sensor_phase' 表示传感器当前的运行阶段.
 */
public interface SculkSensor extends AnaloguePowerable, Waterlogged {

    /**
     * 获取 'sculk_sensor_phase' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'sculk_sensor_phase' property.
     *
     * @return 'sculk_sensor_phase' 的值
     */
    @NotNull
    Phase getPhase();

    /**
     * 设置 'sculk_sensor_phase' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'sculk_sensor_phase' property.
     *
     * @param phase 新的 'sculk_sensor_phase' 值
     */
    void setPhase(@NotNull Phase phase);

    /**
     * 传感器的阶段.
     */
    public enum Phase {

        /**
         * 传感器未激活.
         */
        INACTIVE,
        /**
         * 传感器已激活.
         */
        ACTIVE,
        /**
         * 传感器正在冷却.
         */
        COOLDOWN;
    }
}
